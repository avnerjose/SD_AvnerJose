package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.service.EnderecoService;

@SpringBootTest
public class EnderecoTest {
	@Autowired
	private EnderecoService enderecoService;

	@Test
	public void testarUUIDGeradoPeloJPAListener() {
		Endereco e = new Endereco();

		e.setRua("AV. Joao de amargo");
		e.setNumero("510");
		e.setCidade("Santa Rita do Sapucaí");
		e.setUf("MG");

		enderecoService.salvar(e);

		System.out.println(e);
	}
}
