
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ForTheWind
 */
public class User{
	private int id;
	private String user;
	private String address;
	private String phone;
	
	public User()
	{
		this.id = 0;
		this.user = "";
		this.address = "";
		this.phone = "";
	}
	
	public User(String i, String u, String a, String p)
	{
		this.id = Integer.parseInt(i);
		this.user = u;
		this.address = a;
		this.phone = p;
	}
	
	public boolean Save()
	{
		PreparedStatement ps = null;
		
		try{
			Statement stmt;
			// if the con is active
			Class.forName(mainFrame.driver).newInstance();
			mainFrame.con = DriverManager.getConnection(mainFrame.URL, mainFrame.username, mainFrame.pass);
			String query = "UPDATE user SET user = '" + this.user + "'  , address = '" + this.address + "', phone = '" + this.phone +
					"' WHERE id = " + this.id;
			stmt = (Statement) mainFrame.con.createStatement();
			stmt.executeUpdate(query);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
}
