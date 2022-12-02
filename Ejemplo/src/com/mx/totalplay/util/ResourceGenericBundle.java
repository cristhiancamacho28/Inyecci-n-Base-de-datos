package com.mx.totalplay.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceGenericBundle {
	public static String getProperties(String sproperties) {
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(
					Constantes.PROPERTIES, Locale.getDefault());
		} catch (MissingResourceException e) {

			bundle = null;
		}

		String cadena = "";
		if (bundle != null) {
			try {
				cadena = bundle.getString(sproperties);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cadena;
		}
		return null;
	}

}
