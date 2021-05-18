package br.com.java.api.automation;

public class CEPURL {

	private final String CEPURL = "https://viacep.com.br/ws";

	public String getURLWithCEPNumber(String CEP) {
		return 
			String.format(
				"%s/%s/",
				this.CEPURL,
				CEP
			);
		//
	}
}
