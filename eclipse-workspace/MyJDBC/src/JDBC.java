import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class JDBC {
	public static void main(String[] args) throws ClassNotFoundException
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AGRADIP", "sree&agra!");
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the order ID- ");
		    int o_id = sc.nextInt();
		    System.out.print("Enter the product ID- ");
		    int p_id = sc.nextInt();
		    System.out.print("Enter the unit price- ");
		    int price = sc.nextInt();
		    System.out.print("Enter the quantity- ");
		    int qty = sc.nextInt();
		    System.out.println("All the data's are inserted successfully");
		    System.out.println("Hey,, Do you want to view the data??");
		    String bool = sc.next();
		    
		    PreparedStatement ps = conn.prepareStatement("INSERT INTO order_item(order_id, product_id, unit_price, quantity) VALUES(?, ?, ?, ?)");
		    ps.setInt(1, o_id);
		    ps.setInt(2, p_id);
		    ps.setInt(3, price);
		    ps.setInt(4, qty);
		    int status = ps.executeUpdate();
		    
		    if(bool.equalsIgnoreCase("Yes"))
		    {
		    	Statement st = conn.createStatement();
		    	ResultSet rs = st.executeQuery("SELECT * FROM order_item");
		    	while(rs.next())
		    	{
		    		System.out.print(rs.getInt(1) + " ");
		    		System.out.print(rs.getInt(2) + " ");
		    		System.out.print(rs.getInt(3) + " ");
		    		System.out.println(rs.getInt(4) + " ");
		    	}
		    }
		    else
		    {
		    	System.out.println("Okay !!");
		    }
		    conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("Not inserted");
		}
	}

}
