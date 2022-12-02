package com.mx.totalplay.main;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import com.mx.totalplay.dao.PortalSF_DAO;
import com.mx.totalplay.services.clasePrueba;
import com.mx.totalplay.util.Constantes;
import com.google.gson.*;;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		clasePrueba test = new clasePrueba();
		String input = "{\"accion\":\"Consulta\",\"unidadNegocio\":\"Totalplay\"}";
		int Datos = 0;
		String session = "";
		session = PortalSF_DAO.obtenerSessionId();
	
		if(session.equals("")){
			System.out.println("No se pudo obtener el session id");
			return;
		}
		
		ServiceResponse response = test.obtenerNuevasCuentas(input,session);
		if(response.getResult().equals("0")){
			System.out.println ("Proceso-1 Inyeccion a la Base de Datos");
			for(Registro registro :response.getListCuentasFactura()){
				///AQUI EL LLAMADO DEL SERVICIO POM/////
				/*Map<String, Object>Json = new HashMap<String, Object>();
				Json.put("PhoneNumber1", registro.getTelefono());
				Json.put("PhoneNumber2", registro.getTelefono());
				Json.put("FirstName", registro.getNombre());
				Json.put("LastName", registro.getApellidoP());
				Json.put("Email", registro.getEmail());
				Gson gson = new Gson();
				String infgson = gson.toJson(Json);
				ServiceResponse pom_response = new ServiceResponse();
				pom_response = test.pom(infgson);
				*/
				PortalSF_DAO.insertarRegistro(registro);
				Datos++;
			}
		}
		System.out.println ("Proceso-1 Finalizado " + Datos + "registros insertados");
		Thread.sleep(1000);
		System.out.println ("Proceso-2 Extracion e inseerccion de datos");
	}
}
