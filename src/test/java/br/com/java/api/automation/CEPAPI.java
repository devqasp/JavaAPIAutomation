package br.com.java.api.automation;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.java.api.automation.model.ResponseClass;
import br.com.java.api.automation.utils.GlobalUtils;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CEPAPI {

	private static Map<String, Object> parameters;
	
	private static String _CEP;

	@Test
	public void getCEPService(String CEP) {
		
		CEPAPI._CEP = CEP;

		RestAssured.baseURI = new CEPURL()
			.getURLWithCEPNumber(CEPAPI._CEP);

		RequestSpecification request = 
			RestAssured
				.given()
				.config(RestAssured
					.config()
					.sslConfig(new SSLConfig()
						.allowAllHostnames()
						.relaxedHTTPSValidation()
					)
					.encoderConfig(EncoderConfig
						.encoderConfig()
						.encodeContentTypeAs(
							"x-www-form-urlencoded",
							ContentType.URLENC)
						)
					)
				.accept("*/*")
				.contentType(
					"application/x-www-form-urlencoded; charset=UTF-8"
				);

		Response response =
			request
				.when()
				.log()
				.all()
				.get("json");

		ValidatableResponse validatableResponse = 
			response.then();

		validatableResponse
			.statusCode(200)
			.and()
			.log()
			.all();

		ResponseClass.setResponse(
			response.asString()
		);
	}
	
	@Test
	public void validateCEPJSONKeys() {
		
		CEPAPI.parameters = GlobalUtils
			.generateMapFromString(
				ResponseClass.getResponse()
			);
		
		Assertions
			.assertThat(
				CEPAPI.parameters
			)
			.isNotEmpty()
			.isNotNull();
		
		Assertions
			.assertThat(
				CEPAPI.parameters
			)
			.containsKeys(
				"cep",
				"logradouro",
				"complemento",
				"bairro",
			    "localidade",
			    "uf",
			    "ibge",
			    "gia",
			    "ddd",
			    "siafi"
			);
		//
	}
	
	@Test
	public void validateCEPJSONValues(
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
		Assertions
			.assertThat(
				CEPAPI.parameters
			)
			.containsValues(
				CEPAPI._CEP,
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
		//
	}
}