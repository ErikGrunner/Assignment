package Assignment;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

	
	Ai test = new Ai();
	
	
	public Gui (String title)
	{
		  // set the title
		   super(title);
		
		   // sets the screen layout  - in this case, border layout
		   setLayout(new FlowLayout());
		   
		   // create a label
		   label1  = new JLabel("Please Enter Symptoms");
		   label2  = new JLabel("Tempature:");
		   button1 = new JButton("Check");
		   button2 = new JButton("no");
		   box1 = new JTextField("Enter guess");
		   checkBox1 = new JCheckBox("Aches");
		   checkBox2 = new JCheckBox("Sore Throat");
		   rButton1 = new JRadioButton("Hot");
		   rButton2 = new JRadioButton("Normal");
		   rButton3 = new JRadioButton("Cool");
		   
		   ButtonGroup group = new ButtonGroup();
		   group.add(rButton1);
		   group.add(rButton2);
		   group.add(rButton3);
		   // create a section of screen (panel) that will hold some GUI components 
		   JPanel myPanel = new JPanel();
		   JPanel myPanel2 = new JPanel();
		   JPanel myPanel3 = new JPanel();
		   
		   // add the label we created to the panel 
		   myPanel.add(button1);
		   myPanel2.add(label1);
		   myPanel2.add(checkBox1);
		   myPanel2.add(checkBox2);
		   myPanel3.add(label2);
		   myPanel3.add(rButton1);
		   myPanel3.add(rButton2);
		   myPanel3.add(rButton3);
		   
		   
		   // add the panel to the screen  - uses the add() method of JFrame to do this. 
		   add(myPanel, BorderLayout.NORTH);
		   add(myPanel2, BorderLayout.CENTER);
		   add(myPanel3, BorderLayout.CENTER);

			// set the location of the screen  
		   setLocation(200,200);

		   // Define the size of the frame  
		   setSize(600,400);
		   box1.setSize(200, 24);
		   
		   // make the screen appear - without this, it doesn't!  
		   setVisible(true);
		   
		   button1.addActionListener(this);
		   checkBox1.addItemListener(null);
		   	   
	 }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if( arg0.getSource() == button1) {
			//JOptionPane.showMessageDialog(null, "Checking Symptoms");
			test.ReadData();
			Numerator=0;
			if(checkBox1.isSelected())
			{
				Numerator += test.getAchesNumerator() ;
				System.out.println("Aches"+test.getAchesNumerator());
			}
			if(checkBox2.isSelected())
			{
				Numerator += test.getSoreThroatNumerator() ;
				System.out.println("Throat"+test.getSoreThroatNumerator());
			}
			if(rButton1.isSelected())
			{
				Numerator += test.getTempatureHotNumerator() ;
				System.out.println("Hot"+test.getTempatureHotNumerator());
			}
			if(rButton2.isSelected())
			{
				Numerator += test.getTempatureNormalNumerator() ;
				System.out.println("Normal"+test.getTempatureNormalNumerator());
			}
			if(rButton3.isSelected())
			{
				Numerator += test.getTempatureCoolNumerator() ;
				System.out.println("Cool"+test.getTempatureCoolNumerator());
			}
			System.out.println("Denominator"+test.getDenominator());
			if(Numerator/test.getDenominator()==1)
			{
				JOptionPane.showMessageDialog(null, "Probability:"+(Numerator/test.getDenominator())+"<html><a href=\"http://google.com/\">a link</a></html>");
			}
			JOptionPane.showMessageDialog(null, "Probability:"+(Numerator/test.getDenominator()));
		}

		
	}

}