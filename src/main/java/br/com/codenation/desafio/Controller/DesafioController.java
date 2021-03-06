package br.com.codenation.desafio.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.codenation.desafio.Domain.Cifra;
import br.com.codenation.desafio.service.DesafioService;

@RestController
public class DesafioController {

	@Autowired
	DesafioService desafioService;

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	@GetMapping(value = "/api")
	public ResponseEntity<Cifra> decifrarDesafioCodenation() {

		ResponseEntity<Cifra> objAnswer = desafioService.getObjCodificadoApi();
		desafioService.inserirNovosDados(objAnswer);

		return ResponseEntity.ok(objAnswer.getBody());
	}
	@PostMapping(value = "/api")
	public ResponseEntity<String> enviarArquivo(Cifra cifra){
			
		ResponseEntity<String> objAnswer = desafioService.postarArquivo();
		
		return ResponseEntity.ok(objAnswer.getBody());
		
	}

}
