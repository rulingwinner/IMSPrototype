import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame 
{
	Container c;
	JButton btnProd, btnEmp, btnDel, btnSup;

	MainFrame()
	{
		c=getContentPane();
		//c.setLayout(new FlowLayout());
		c.setLayout(null);
		btnProd=new JButton("Products");
		btnEmp=new JButton("Employees");
		btnDel=new JButton("Deliveries");
		btnSup=new JButton("Suppliers");
		
		btnProd.setBounds(280,100,350,250);
		btnEmp.setBounds(730,100,350,250);
		btnDel.setBounds(280,400,350,250);
		btnSup.setBounds(730,400,350,250);

		c.add(btnProd);
		c.add(btnEmp);
		c.add(btnDel);
		c.add(btnSup);

		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ProdFrame a=new ProdFrame();
				dispose();
			}
		});
		
		/*btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new DispEmp();
				dispose();
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new DispDel();
				dispose();
			}
		});
		
		btnSup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new DispSupplier();
				dispose();
			}
		});*/

		/*btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				ViewFrame a=new ViewFrame();
				dispose();
			}
		});*/

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Inventory Management System");
		//setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) 
	{
		MainFrame m=new MainFrame();
	}
}

class DatabaseHandler
{
	static Connection con;

	static void getCon()
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","YASHRAJ","yashraj10");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}

	public void addProduct(String pid, String name, int cost, String brand)
	{
		getCon();		

		try
		{
			String sql="INSERT INTO product VALUES(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,pid);
			pst.setString(2,name);
			pst.setInt(3,cost);
			pst.setString(4,brand);
			pst.setInt(5,0);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" record inserted");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),e+"Insert issue");
		}
	}

	public void addBatch(String bid, String pid, String bexp)
	{
		getCon();		

		try
		{
			String sql="INSERT INTO batch VALUES(?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,bid);
			pst.setString(2,pid);
			pst.setString(3,bexp);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" record inserted");
			if(r==1)
			{
				String sql1="update product set pqty=pqty+1 where pid=?";
				PreparedStatement pst1=con.prepareStatement(sql1);
				pst1.setString(1,pid);
				int r1=pst1.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),e+"Insert issue");
		}
	}

	public String dispProd()
	{
		getCon();
		StringBuffer sb=new StringBuffer();		

		try
		{
			Statement s1=con.createStatement();
			String s2="SELECT * FROM product";
			ResultSet rs=s1.executeQuery(s2);
			while(rs.next())
			{
				String pid=rs.getString(1);
				String pname=rs.getString(2);
				int price=rs.getInt(3);
				String pbrand=rs.getString(4);
				int pqty=rs.getInt(5);
				sb.append("\n"+"Pid: "+pid+"\tName: "+pname+"\tPrice: "+price+"\t\tBrand: "+pbrand+"\tQuantity: "+pqty);
			}
			sb.deleteCharAt(0);
		}
		catch(SQLException e){}	
		
		return sb.toString();
	}

	public String dispBatch()
	{
		getCon();
		StringBuffer sb=new StringBuffer();		

		try
		{
			Statement s2=con.createStatement();
			String s3="SELECT * FROM batch";
			ResultSet rs=s2.executeQuery(s3);
			while(rs.next())
			{
				String bid=rs.getString(1);
				String pid=rs.getString(2);
				String bexp=rs.getString(3);
				sb.append("\n"+"Bid: "+bid+"\tPid: "+pid+"\tExpiry Date: "+bexp);
			}
			sb.deleteCharAt(0);
		}
		catch(SQLException e){}	
		
		return sb.toString();
	}
	
	/*public void updateEmployee(int id,String name)
	{
		getCon();		

		try
		{
			///*
			String sql="UPDATE employee SET ename=? WHERE eid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setInt(2,id);
			//try{
			int r=pst.executeUpdate();
			///}catch(Exception e){System.out.println("Except ion");}
			//*/
			
			/*
			String sql="UPDATE employee SET ename='"+name+"' WHERE eid="+id;
			Statement pst=con.createStatement();
			int r=pst.executeUpdate(sql);
			*/

			//JOptionPane.showMessageDialog(new JDialog(),r+" records inserted");
		/*	JOptionPane.showMessageDialog(new JDialog(),"ID="+id+"\n Name updated as "+name);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Update issue:\n"+e);
		}
	}

	public void deleteEmployee(int id)
	{
		getCon();

		try
		{
			String sql="DELETE FROM employee WHERE eid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+"Employee Deleted");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Delete issue:\n"+e);
		}
	}*/

}