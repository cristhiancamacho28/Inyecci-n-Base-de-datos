package com.mx.totalplay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mx.totalplay.main.Registro;
import com.mx.totalplay.util.Constantes;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectorConfig;

public class PortalSF_DAO {
	
	public static void insertarRegistro(Registro registro)
	{
		try 
	    {
	     Class.forName ("oracle.jdbc.driver.OracleDriver");
	    } 
	    catch (ClassNotFoundException e) 
	    {
	     e.printStackTrace();
	    }
		
		Connection conn;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.213.16.22:1521:HITVOPTV", "DESKVM", "GB434o58Vb3");
		
			Statement stmt = conn.createStatement();
			//ResultSet rset = stmt.executeQuery("select PPU_NAME_PROFILE from PSF_PROFILE_USER");
			
			String insert = "";
			int respuesta =0;
			
			insert = "insert into ";
			insert += "PSF_TABLA_PRUEBA";
			insert += "(";
			insert += "FIRSTNAME,";
			insert += "LASTNAME,";
			insert += "PHONENUMBER1,";
			insert += "PHONENUMBER2,";
			insert += "EMAIL";
			insert += ") ";
			insert += "values ";
			insert += "(";
			insert += "'"+registro.getNombre()+"',";
			insert += "'"+registro.getApellidoP()+"',";
			insert += "'"+registro.getTelefono()+"',";
			insert += "'"+registro.getTelefono()+"',";
			insert += "'"+registro.getEmail()+"'";
			insert += ")";
			
			respuesta = stmt.executeUpdate(insert);
			
			if(respuesta!=0)
		    {
		    	System.out.println ("Se insertó registro");   // Print col 1
		    }
		          
		    stmt.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public static String obtenerSessionId()
	{
		String session_id="";
		String update = "";
		int respuesta=0;
		float time = (float) 0;
		try 
	    {
	     Class.forName ("oracle.jdbc.driver.OracleDriver");
	    } 
	    catch (ClassNotFoundException e) 
	    {
	     e.printStackTrace();
	    }
		
		Connection conn;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.213.16.22:1521:HITVOPTV", "DESKVM", "GB434o58Vb3");
		
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT SESSION_ID as sessionId , (SYSDATE - UPDATE_SESSION_ID) * 24 * 60  as updateSessionId FROM PSF_STATIC_SESSION_ID");
			
			while(rset.next())
			{
				session_id = rset.getString(1);
				time = rset.getFloat(2);
			}
			
			if(time>30)
			{
				ConnectorConfig config = new ConnectorConfig();
				config.setUsername(Constantes.USERSF);
				config.setPassword(Constantes.PUERTA_SF);
				config.setAuthEndpoint(Constantes.LOGINSF);
				try 
				{
					PartnerConnection partnerConnection;
					partnerConnection = new PartnerConnection(config);
					LoginResult login = partnerConnection.login(Constantes.USERSF, Constantes.PUERTA_SF);
					session_id = login.getSessionId();
					System.out.println("New Session..."+session_id);
					
					update = "update ";
					update += "PSF_STATIC_SESSION_ID ";
					update += "set ";
					update += "SESSION_ID ='"+session_id+"',";
					update += "UPDATE_SESSION_ID = SYSDATE";
					
					respuesta = stmt.executeUpdate(update);
					
					if(respuesta!=0)
				    {
				    	System.out.println ("Se actualizó sessión id");   // Print col 1
				    }
					
				}
				catch(Exception ex)
				{	
					System.out.println ("Error al actualizar session id:"+ex.getMessage());
				}
				
				
				
			}
		          
		    stmt.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		return session_id;
	}
}
