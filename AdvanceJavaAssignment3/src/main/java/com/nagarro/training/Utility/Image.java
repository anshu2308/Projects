package com.nagarro.training.Utility;
import java.io.ByteArrayOutputStream;

import java.io.*;
import java.sql.SQLException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import com.nagarro.training.Entity.Products;

public class Image {
	public static void  makeImage(int id) throws SQLException, IOException  {
		 Products p=null;
		 String sql = "SELECT * FROM Products WHERE Sno = ?";
		 
		 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "root")) 
		 {
			 PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, id);
	            
	            ResultSet result = statement.executeQuery();
	           
	            if(result.next()) {
				 p=new Products();
				 Blob blob=result.getBlob("image");
				System.out.println(result.getString("title"));
				 InputStream is=blob.getBinaryStream();
				   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = is.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	               
	              
	                p.setBase64Image(base64Image);
				 
	                is.close();
	                outputStream.close();		 
			 }
	}
		 catch(Exception e) {
			 System.out.println("Cant read");
		 }
	}
}
