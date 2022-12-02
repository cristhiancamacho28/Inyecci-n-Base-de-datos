package com.mx.totalplay.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.mx.totalplay.main.Registro;
import com.mx.totalplay.main.ServiceResponse;
import com.mx.totalplay.util.Constantes;


public class clasePrueba {
	
	
	public ServiceResponse obtenerNuevasCuentas(String inputJson,String session_id) {
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
			HttpPost httppost = new HttpPost(Constantes.WS_CLIENTES_NUEVOS);
			httppost.setHeader("Accept", "application/json; charset=utf-8");
			httppost.setHeader("Content-type", "application/json; charset=utf-8");
			httppost.setHeader("sessionId", session_id);
			httppost.setHeader("Authorization", "OAuth " + session_id);
			
			StringEntity input = new StringEntity((inputJson), "UTF-8");
			httppost.setEntity(input);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
			
			if (statusCode == 200) 
			{
				Gson gson = new Gson();
				serviceResponse = gson.fromJson(responseString,ServiceResponse.class);
				return serviceResponse;
			} else 
			{
				serviceResponse.setResult("1");
				serviceResponse.setResultDescription("Error al consumir servicio.StatusCode= "+String.valueOf(statusCode));
				return serviceResponse;
			}
		} catch (ClientProtocolException e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion ClientProtocolException: = "+e.getMessage());
			return serviceResponse;
		} catch (IOException e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion IOException: = "+e.getMessage());
			return serviceResponse;
		} catch (Exception e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion no controlada: = "+e.getMessage());
			return serviceResponse;
		}
	}
	
	public ServiceResponse pom(String inputJson,String session_id) {
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
			HttpPost httppost = new HttpPost(Constantes.WS_POM);
			httppost.setHeader("Accept", "application/json; charset=utf-8");
			httppost.setHeader("Content-type", "application/json; charset=utf-8");
			httppost.setHeader("sessionId", session_id);
			httppost.setHeader("Authorization", "OAuth " + session_id);
			
			StringEntity input = new StringEntity((inputJson), "UTF-8");
			httppost.setEntity(input);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
			
			if (statusCode == 200) 
			{
				Gson gson = new Gson();
				serviceResponse = gson.fromJson(responseString,ServiceResponse.class);
				return serviceResponse;
			} else 
			{
				serviceResponse.setResult("1");
				serviceResponse.setResultDescription("Error al consumir servicio.StatusCode= "+String.valueOf(statusCode));
				return serviceResponse;
			}
		} catch (ClientProtocolException e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion ClientProtocolException: = "+e.getMessage());
			return serviceResponse;
		} catch (IOException e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion IOException: = "+e.getMessage());
			return serviceResponse;
		} catch (Exception e) {
			serviceResponse.setResult("1");
			serviceResponse.setResultDescription("Excepcion no controlada: = "+e.getMessage());
			return serviceResponse;
		}
		
	}
}
