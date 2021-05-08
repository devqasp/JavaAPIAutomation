package br.com.java.api.automation;

import java.lang.reflect.InvocationTargetException;

public class APIRegister {

	@SuppressWarnings("unchecked")
	private static <T> T getAPI(Class<?> clazz) {
		//
		T api = null;
		//
		try {
			api = (T) clazz
				.getDeclaredConstructor()
				.newInstance();
		//
		} catch (
			InstantiationException
			| IllegalAccessException
			| IllegalArgumentException
			| InvocationTargetException
			| NoSuchMethodException
			| SecurityException ex)
		{
			ex.printStackTrace();
		}
		//
		return api;
	}

	public static CEPAPI getCEPAPI() {
		return getAPI(CEPAPI.class);
	}
}