package br.com.java.api.automation.step.definition;

import br.com.java.api.automation.APIRegister;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CEPSD extends APIRegister {

	@Dado("que eu consulto o {string}")
	public void queEuConsultoO(String CEP) {
		getCEPAPI().getCEPService(CEP);
	}
	
	@Então("os dados de CEP {string} {string} {string} {string} {string} {string} {string} {string} {string} deverão ser validados")
	public void osDadosDeCEPDeverãoSerValidados(
		String logradouro,
		String complemento,
		String bairro,
		String localidade,
		String uf,
		String ibge,
		String gia,
		String ddd,
		String siafi
	)
	{
		getCEPAPI().validateCEPJSONKeys();
		getCEPAPI().validateCEPJSONValues(
			logradouro,
			complemento,
			bairro,
			localidade,
			uf,
			ibge,
			gia,
			ddd,
			siafi
		);
	}
}