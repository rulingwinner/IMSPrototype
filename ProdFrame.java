import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProdFrame extends JFrame 
{
	Container c;
	JButton btnAddP, btnDispP, btnAddB, btnDispB, btnBack;
	JPanel mainPanel1,mainPanel2,p1,p2;

	ProdFrame()
	{
		c=getContentPane();

		//c.setLayout(new BorderLayout(20,20));
		c.setLayout(null);
		
		mainPanel1 = new JPanel();
		mainPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel2 = new JPanel();
		mainPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		p1=new JPanel();
		p1.setLayout(new GridLayout(2,2,40,40));
		p1.setMaximumSize(new Dimension(800,550));
		btnAddP=new JButton("Add Product");
		btnDispP=new JButton("Display Products");
		btnAddB=new JButton("Add Batch");
		btnDispB=new JButton("Display Batch");
		
		btnAddP.setPreferredSize(new Dimension(300,200));
		btnDispP.setPreferredSize(new Dimension(300,200));
		btnAddB.setPreferredSize(new Dimension(300,200));
		btnDispB.setPreferredSize(new Dimension(300,200));
		
		p1.add(btnAddP);
		p1.add(btnDispP);
		p1.add(btnAddB);
		p1.add(btnDispB);
		
		mainPanel1.add(p1);

		p2=new JPanel();
		p2.setLayout(new GridLayout(1,1,40,40));
		p2.setMaximumSize(new Dimension(150,55));
		//p2.setLocation(375,640);
		btnBack=new JButton("Back");
		btnBack.setPreferredSize(new Dimension(150,50));
		p2.add(btnBack);
		
		mainPanel2.add(p2);
		

		btnAddP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				AddProd a=new AddProd();
				dispose();
			}
		});

		btnDispP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				DispProd a=new DispProd();
				dispose();
			}
		});

		btnAddB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				AddBatch a=new AddBatch();
				dispose();
			}
		});

		btnDispB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				DispBatch a=new DispBatch();
				dispose();
			}
		});



		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				MainFrame a=new MainFrame();
				dispose();
			}
		});

		/*btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ViewFrame a=new ViewFrame();
				dispose();
			}
		});*/


		/*c.add(mainPanel1,BorderLayout.CENTER);
		c.add(mainPanel2,BorderLayout.SOUTH);*/
		
		mainPanel1.setBounds(300,50,800,500);
		mainPanel2.setBounds(635,560,150,70);
		c.add(mainPanel1);
		c.add(mainPanel2);
		
		
		setTitle("Inventory Management System");
		//setSize(350,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}