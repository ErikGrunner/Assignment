package Assignment;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class Gui extends JFrame  implements ActionListener
{


	private float Numerator = 0;//used in calculation
	private JButton button1;
	private int z =0;//used to label the radio buttons

	Ai data = new Ai();

	//create all required objects for the gui
	JLabel[] l = new JLabel[data.getTitles().size()];
	JRadioButton[] r = new JRadioButton[data.totalAnswers()];
	{
		z =0;
	for(int i=0; i<data.getTitles().size()-1;i++) //this groups all the radio buttons to each question
	{
		l[i] = new JLabel((String) data.getTitles().get(i));
		this.add(l[i]);
		ButtonGroup group = new ButtonGroup();

		//this.add(new JLabel((String) data.getTitles().get(i)));
		//JRadioButton[] r = new JRadioButton[data.getTitles().size()];
		for(int j=0; j<data.getD(i).getNewObj().size();j++) 
		{

			r[z] = new JRadioButton((String) data.getD(i).getNewObj(j));

			group.add(r[z]);
			this.add(r[z]); 
			r[z].addActionListener(this);
			//this.add(new JRadioButton((String) data.getD(i).getNewObj(j)));
			//System.out.println("ZZZZZ"+z);
			z+=1;
		}
	}
	}


	public Gui (String title)
	{
		// sets up other parts of the gui
		super(title);
		setLayout(new FlowLayout());
		button1 = new JButton("Check");
		JPanel myPanel = new JPanel();
		myPanel.add(button1);
		add(myPanel, BorderLayout.NORTH);
		button1.addActionListener(this);
		setSize(600,400);
		setLocation(200,200);
		setVisible(true);
	}






	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if( e.getSource() == button1) 
		{
			data.ReadData();
			Numerator=0;
			//JOptionPane.showMessageDialog(null, "Checking Symptoms" +Numerator);
			z=0;
			for(int i=0; i<data.getTitles().size()-1;i++) 
			{
				for(int j[]= {0}; j[0]<data.getD(i).getNewObj().size();j[0]++) 
				{
					System.out.println("trace"+z);
					System.out.println(r[z].isSelected());
					if(r[z].isSelected())
					{
						System.out.println(r[z].isSelected());
						Numerator += data.getResults(i,j[0]);
					}
					z+=1;
				}
			}
			JOptionPane.showMessageDialog(null, "Probability: %"+(int)100*(Numerator/(data.getDenominator()-1))/*+"__"+(Numerator)+"/"+(data.getDenominator()-1)*/);
		}
	}
}