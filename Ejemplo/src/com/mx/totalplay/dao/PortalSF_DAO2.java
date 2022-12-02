package com.mx.totalplay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mx.totalplay.main.RegistrosDatos;

public class PortalSF_DAO2 {
	public static void extraerRegistroDatos(RegistrosDatos registrosDatos){
		try{ Class.forName ("oracle.jdbc.driver.OracleDriver"); } 
	    catch (ClassNotFoundException e){ e.printStackTrace(); }
		Connection conn;
		try {	
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.213.16.22:1521:HITVOPTV", "DESKVM", "GB434o58Vb3");
			Statement stmt = conn.createStatement();
			String query = "select FIRTSNAME, LASTNAME, PHONENUMBER1, PHONENUMBER2, EMAIL from PSF_TABLA_PRUEBA";
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				registrosDatos.getFirstname();
				registrosDatos.getLastname();
				registrosDatos.getPhonenumber1();
				registrosDatos.getPhonenumber2();
				registrosDatos.getEmail();			   
			    System.out.println(registrosDatos.getFirstname() + "\t" + registrosDatos.getLastname() + "\t" + registrosDatos.getPhonenumber1() + 
			    		"\t" + registrosDatos.getPhonenumber2() + "\t" + registrosDatos.getEmail());				   
				}
		    stmt.close();
		}catch (SQLException e){ e.printStackTrace(); }
	}
	public static void insertarRegistroDatos(RegistrosDatos registrosDatos){
		try{ Class.forName ("oracle.jdbc.driver.OracleDriver"); } 
	    catch (ClassNotFoundException e){ e.printStackTrace(); }
		Connection conn;
		try{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.213.16.22:1521:HITVOPTV", "DESKVM", "GB434o58Vb3");
			Statement stmt = conn.createStatement();
			String insert = "";
			int respuesta =0;
			
			insert = "insert into ";
			insert += "PSF_TABLA_PRUEBA2";
			insert += "(";
			insert += "FIRSTNAME,";
			insert += "LASTNAME,";
			insert += "PHONENUMBER1,";
			insert += "PHONENUMBER2,";
			insert += "EMAIL";
			insert += ") ";
			insert += "values ";
			insert += "(";
			insert += "'"+registrosDatos.getFirstname()+"',";
			insert += "'"+registrosDatos.getLastname()+"',";
			insert += "'"+registrosDatos.getPhonenumber1()+"',";
			insert += "'"+registrosDatos.getEmail()+"',";
			insert += "'"+registrosDatos.getEmail()+"'";
			insert += ")";
			respuesta = stmt.executeUpdate(insert);
			
			if(respuesta!=0){
		    	System.out.println ("Se insertó registro");   // Print col 1
		    }         
		    stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}