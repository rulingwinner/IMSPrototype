import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddBatch extends JFrame 
{
	Container c;
	JLabel lblPid, lblBid, lblExp;
	JTextField txtPid, txtBid, txtExp;
	JButton btnSave, btnBack;
	JPanel p1,p2;

	AddBatch()
	{
		c=getContentPane();
		//c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.setLayout(null);

		p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,30,30));		
		lblPid=new JLabel("Product ID");
		txtPid=new JTextField(6);
		lblBid=new JLabel("Batch ID");
		txtBid=new JTextField(10);
		lblExp=new JLabel("Expiry Date (DD-MM-YYYY)");
		txtExp=new JTextField(5);
		p1.add(lblPid);
		p1.add(txtPid);
		p1.add(lblBid);
		p1.add(txtBid);
		p1.add(lblExp);
		p1.add(txtExp);
		
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
					String bid=txtBid.getText();
					String pid=txtPid.getText();
					String bexp=txtExp.getText();


					if(bid.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Bid is empty");
						txtBid.requestFocus();
						return;
					}

					if(pid.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Pid is empty");
						txtPid.requestFocus();
						return;
					}

					if(bexp.length()==0)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Expiry date is empty");
						txtExp.requestFocus();
						return;
					}

					DatabaseHandler d=new DatabaseHandler();
					d.addBatch(bid,pid,bexp);
					txtBid.setText("");
					txtPid.setText("");
					txtExp.setText("");
				}
			});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ProdFrame a=new ProdFrame();
				dispose();
			}
		});

		setTitle("Add Batch");
		//setSize(500,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}