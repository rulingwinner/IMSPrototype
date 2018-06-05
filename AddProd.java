import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddProd extends JFrame 
{
	Container c;
	JLabel lblPid, lblName, lblCost, lblBrand;
	JTextField txtPid, txtName, txtCost, txtBrand;
	JButton btnSave, btnBack;
	JPanel p1,p2;

	AddProd()
	{
		c=getContentPane();
		//c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.setLayout(null);

		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,30,30));
		lblPid=new JLabel("Product ID");
		txtPid=new JTextField(6);
		lblName=new JLabel("Product Name");
		txtName=new JTextField(10);
		lblCost=new JLabel("Product Cost");
		txtCost=new JTextField(5);
		lblBrand=new JLabel("Product Brand");
		txtBrand=new JTextField(10);
		p1.add(lblPid);
		p1.add(txtPid);
		p1.add(lblName);
		p1.add(txtName);
		p1.add(lblCost);
		p1.add(txtCost);
		p1.add(lblBrand);
		p1.add(txtBrand);
		
		p1.setBounds(500,150,300,200);
		c.add(p1);

		p2=new JPanel(new GridLayout(1,2,20,20));
		btnSave=new JButton("Save");
		btnBack=new JButton("Back");
		p2.add(btnSave);
		p2.add(btnBack);
		
		p2.setBounds(550,450,200,50);
		c.add(p2);

		btnSave.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String pid=txtPid.getText();
					String name=txtName.getText();
					String strcost=txtCost.getText();
					int cost=Integer.parseInt(strcost);
					String brand=txtBrand.getText();


					if(pid.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Pid is empty");
						txtPid.requestFocus();
						return;
					}

					if(name.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Name is empty");
						txtName.requestFocus();
						return;
					}

					if(strcost.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Cost is empty");
						txtCost.requestFocus();
						return;
					}

					if(brand.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Brand is empty");
						txtBrand.requestFocus();
						return;
					}

					DatabaseHandler d=new DatabaseHandler();
					d.addProduct(pid,name,cost,brand);
					txtPid.setText("");
					txtName.setText("");
					txtCost.setText("");
					txtBrand.setText("");
				}
			});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ProdFrame a=new ProdFrame();
				dispose();
			}
		});
		
		setTitle("Add Product");
		//setSize(400,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}