package jbdc1;
import java.io.*;
import java.sql.*;


public class Storeimage1 {

	public static void main(String[] a)
	{
		
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		String filepath="C:/gayatri/Andre.jpg";
		try{
			
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="INSERT INTO person(name,image) values(?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,"Andre Sebastian");
			InputStream inputStream=new FileInputStream(new File(filepath));
			stmt.setBlob(2,inputStream);
			int row=stmt.executeUpdate();
			if(row>0)
			{
				System.out.print("A contact was insertted with photo image");
			}	
			conn.close();
		}catch(Exception e)
		{
			System.out.print(e);
		}	
		
	}
}	
