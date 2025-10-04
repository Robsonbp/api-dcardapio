package br.edu.infnet.robsonpinto.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.robsonpinto.model.domain.CnpjInfo;

@FeignClient(name = "robsoncpnjapi", url = "${api.robsoncnpjapi.url}")
public interface ValidadorCnpjFeignClient {
	
	@GetMapping("/api/cnpj/{cnpj}")
	public CnpjInfo validarCnpj(@PathVariable String cnpj);
}
