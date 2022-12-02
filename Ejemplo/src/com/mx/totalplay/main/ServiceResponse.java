package com.mx.totalplay.main;

public class ServiceResponse {
	private String resultDescription;
	private String result;
	private Registro[] listCuentasFactura;
	
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Registro[] getListCuentasFactura() {
		return listCuentasFactura;
	}
	public void setListCuentasFactura(Registro[] listCuentasFactura) {
		this.listCuentasFactura = listCuentasFactura;
	}
	
	
}
