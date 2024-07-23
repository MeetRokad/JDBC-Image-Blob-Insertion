package in.jdbc.main;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class BlobInsertionApp
{
	public static void main(String []args) throws SQLException,IOException
	{
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		
		//(1)Load Driver
		
		//(2)establish connection 
		
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="Meet@231";
		connection=DriverManager.getConnection(url,username,password);
		//(3)Create a statement object and execute sql query
		
		String name=null;
		String imageLoc=null;
		
		String sqlInsertQuery = "insert into persons(`name`,`image`) values(?,?)";
		
		if(connection!=null) 
		{
			pstmt = connection.prepareStatement(sqlInsertQuery);
			
			if(sc != null)
			{
				System.out.print("Enter the username : ");
				name=sc.next();
				
				System.out.println("Enter the imageLocation : ");
				imageLoc=sc.next();
			}
			
			pstmt.setString(1,name);
			pstmt.setBinaryStream(2,new FileInputStream(new File(imageLoc)));
			
			int rowaffacted = pstmt.executeUpdate();
			System.out.println("No of rows inserted is :: " + rowaffacted);
			sc.close();
		}
		
	}
		
}