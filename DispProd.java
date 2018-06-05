import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DispProd extends JFrame 
{
	Container c;
	TextArea taData;
	JButton btnBack;
	JPanel p1,p2;
	JScrollPane spData;

	DispProd()
	{
		c=getContentPane();
		//c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.setLayout(null);
		
		p1=new JPanel();
		taData=new TextArea(5,100);
		
		p1.add(taData);
		p1.setBounds(520,150,800,200);
		taData.setEditable(false);
		spData=new JScrollPane(taData);
		spData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spData.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		p1.add(spData);
		c.add(p1);

		p2=new JPanel();
		btnBack=new JButton("Back");
		
		
		p2.add(btnBack);
		p2.setBounds(650,450,100,50);
		c.add(p2);

		DatabaseHandler d=new DatabaseHandler();
		String data=d.dispProd();
		taData.setText(data);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ProdFrame a=new ProdFrame();
				dispose();
			}
		});

		setTitle("Display Products");
		//setSize(400,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);				
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}