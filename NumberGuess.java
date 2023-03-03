/////////////////////////////////////////////////////////////////////////////////
//				Jay Ganesh
////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////
//Java Program for Number Guessing
//////////////////////////////////////////////
import java.lang.*;
import java.util.*; 
import javax.swing.*;  
import java.awt.event.*;  
////////////////////////////////////////////////////////
//Class Name:       MyNumber
//Description:      containes the main logic of an application
//Date:             03/02/2023
//Author:           Manas Ohara
////////////////////////////////////////////////////////
class MyNumber implements ActionListener
{
	//range to generate random numbers
	final int iMax_range = 100;
	final int iMin_range = 1;
	final int iRange = iMax_range - iMin_range + 1;
	protected int iRandomGeneratedNum = 0;
	
	//GUI Components
	JFrame frame = new JFrame("Number Guessing Game by Manas Ohara");
	JTextField t1 = new JTextField();
	JLabel label = new JLabel("Enter number between 1 to 100: ");
        JButton b1 = new JButton("Guess!!");

	////////////////////////////////////////////////////////
	//Function Name:    MyNumber
	//Description:      allocate the resources which are required by class
	//Input:            ---
	//Output:           ---
	//Date:             03/02/2023
	//Author:           Manas Ohara
	////////////////////////////////////////////////////////
	MyNumber()
	{
		iRandomGeneratedNum = (int)(Math.random() * iRange) + iMin_range;
		frame.setSize(600,200);  
        	label.setBounds(30,20,500,30);
        	t1.setBounds(300,20,200,30);  
        	b1.setBounds(250,80,100,40);
        	b1.addActionListener(this);  
        	frame.add(label);
        	frame.add(t1);
        	frame.add(b1);
        	frame.setLayout(null);  
    		frame.setVisible(true); 
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	////////////////////////////////////////////////////////
	//Function Name:    getMyRandomNumber
	//Description:      return the randomly generated number in Constructor call
	//Input:            ---
	//Output:           int
	//Date:             03/02/2023
	//Author:           Manas Ohara
	////////////////////////////////////////////////////////
	public int getMyRandomNumber()
	{
		return iRandomGeneratedNum;
	}
	
	////////////////////////////////////////////////////////
	//Function Name:    actionPerformed
	//Description:      action listner function on button
	//Input:            ActionEvent e
	//Output:           ---
	//Date:             03/02/2023
	//Author:           Manas Ohara
	////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e)
	{  
		String s1 = t1.getText();  
		int iNum = Integer.parseInt(s1); 
		if(e.getSource()==b1)
		{  
			//Number Validation
		    if( ( iNum <= 0 ) || ( iNum > 100 ) )
		    {
			System.out.println("Enter number in given range\n");
			return;
		    }
		    System.out.println("My Random number is : "+getMyRandomNumber());
	    	    int iRandom = getMyRandomNumber();
		    if( iNum ==  iRandom )
		    {
		    	JDialog d = new JDialog(frame,"Success!!!");
		    	JLabel l = new JLabel("Number matched !!! \n");
		    	l.setBounds(30,10,350,40);
		    	d.add(l);
            		d.setSize(500, 100);
			d.setVisible(true);
		    }	
		    else
		    {
		    	JDialog d = new JDialog(frame,"Failure!!!");
		    	JLabel l = new JLabel("Number did not match!!!\n");
		    	l.setBounds(30,10,350,40);
		    	d.add(l);
            		d.setSize(500, 100);
			d.setVisible(true);
			System.out.println();
		    }
		} 
    }
}
class NumberGuess
{
	public static void main(String args[])
	{
		MyNumber obj = new MyNumber();
	}
	

}
