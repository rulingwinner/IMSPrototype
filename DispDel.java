import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DispDel extends JFrame 
{
	Container c;
	TextArea taData;
	JButton btnBack;
	JPanel p1,p2;

	DispDel()
	{
		c=getContentPane();
		//c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.setLayout(null);

		p1=new JPanel();
		taData=new TextArea(6,50);
		
		p1.add(taData);
		p1.setBounds(520,150,400,200);
		c.add(p1);

		p2=new JPanel();
		btnBack=new JButton("Back");
		
		p2.add(btnBack);
		p2.setBounds(650,450,100,50);
		c.add(p2);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new MainFrame();
				dispose();
			}
		});

		setTitle("Display Deliveries");
		//setSize(400,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);				
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}