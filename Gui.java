package Assignment;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Gui extends JFrame  implements ActionListener
{


	private float Numerator = 0;
	private JLabel label1;
	private JLabel label2;
	private JButton button1;
	private JButton button2;
	private JTextField box1;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JRadioButton rButton1;
	private JRadioButton rButton2;
	private JRadioButton rButton3;

	Ai data = new Ai();

	//create all required objects for the gui
	JLabel[] l = new JLabel[data.getTitles().size()];
	JRadioButton[] r = new JRadioButton[data.getTitles().size()];
	{
	for(int i=0; i<data.getTitles().size()-1;i++) 
	{
		l[i] = new JLabel((String) data.getTitles().get(i));
		this.add(l[i]);
		ButtonGroup group = new ButtonGroup();

		//this.add(new JLabel((String) data.getTitles().get(i)));
		//JRadioButton[] r = new JRadioButton[data.getTitles().size()];
		for(int j=0; j<data.getD(i).getNewObj().size();j++) 
		{

			r[j] = new JRadioButton((String) data.getD(i).getNewObj(j));

			group.add(r[j]);
			this.add(r[j]); 
			//r[j].addActionListener(this);
			//this.add(new JRadioButton((String) data.getD(i).getNewObj(j)));
		}
	}}


	public Gui (String title)
	{
		// set the title
		super(title);

		//System.out.println("titles lenght "+data.getTitles().get(0));

		


		/*for (int[] j= {0}; j[0]<data.getD(i).getNewObj().size();j[0]++)
			{
				r[j[0]].addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						//if( e.getSource() == button1) 
						{
							JOptionPane.showMessageDialog(null, "Checking Symptoms");
							if(r[j[0]].isSelected() == true)
							{
								System.out.println("Yatzi");
							}
						}
					} 
				});

			}*/

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
			JOptionPane.showMessageDialog(null, "Checking Symptoms" +Numerator);
			for(int i=0; i<data.getTitles().size();i++) 
			{
				for(int j[]= {0}; j[0]<data.getD(i).getNewObj().size();j[0]++) 
				{
					System.out.println("trace"+j[0]);
					if(r[j[0]].isSelected() == true)
					{
						System.out.println(data.getD(i).getNewObj(j[0]));
						System.out.println("Yatzi"+j[0]);
						Numerator += data.getResults(i,j[0]);
						System.out.println((String) data.getTitles().get(i) + data.getResults(i, j[0]));
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Probability:"+(Numerator/data.getDenominator()));
		}
	}
}
/*
				for (int[] j= {0}; j[0]<data.getD(i).getNewObj().size();j[0]++)
				{
					r[j[0]].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							//if( e.getSource() == button1) 
							{
								JOptionPane.showMessageDialog(null, "Checking Symptoms");
								if(r[j[0]].isSelected() == true)
								{
									System.out.println("Yatzi");
								}
							}
						} 
					});

		}}

	}
}
		/*button1.addActionListener(this);
		checkBox1.addItemListener(null);

	}/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if( arg0.getSource() == button1) {
			//JOptionPane.showMessageDialog(null, "Checking Symptoms");
			data.ReadData();
			Numerator=0;
			if(checkBox1.isSelected())
			{
				Numerator += data.getAchesNumerator() ;
				System.out.println("Aches"+data.getAchesNumerator());
			}
			if(checkBox2.isSelected())
			{
				Numerator += data.getSoreThroatNumerator() ;
				System.out.println("Throat"+data.getSoreThroatNumerator());
			}
			if(rButton1.isSelected())
			{
				Numerator += data.getTempatureHotNumerator() ;
				System.out.println("Hot"+data.getTempatureHotNumerator());
			}
			if(rButton2.isSelected())
			{
				Numerator += data.getTempatureNormalNumerator() ;
				System.out.println("Normal"+data.getTempatureNormalNumerator());
			}
			if(rButton3.isSelected())
			{
				Numerator += data.getTempatureCoolNumerator() ;
				System.out.println("Cool"+data.getTempatureCoolNumerator());
			}
			System.out.println("Denominator"+data.getDenominator());
			if(Numerator/data.getDenominator()==1)
			{
				JOptionPane.showMessageDialog(null, "Probability:"+(Numerator/data.getDenominator())+"<html><a href=\"http://google.com/\">a link</a></html>");
			}
			JOptionPane.showMessageDialog(null, "Probability:"+(Numerator/data.getDenominator()));
		}


	}

}*/