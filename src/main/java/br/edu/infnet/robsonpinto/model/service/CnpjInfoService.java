package br.edu.infnet.robsonpinto.model.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.clients.ValidadorCnpjFeignClient;
import br.edu.infnet.robsonpinto.model.domain.CnpjInfo;

@Service
public class CnpjInfoService {
	
	private final ValidadorCnpjFeignClient validadorCnpjFeignClient;
	
	public CnpjInfoService(ValidadorCnpjFeignClient validadorCnpjFeignClient) {
		this.validadorCnpjFeignClient = validadorCnpjFeignClient;
	}

	public CnpjInfo validarVendedor(String cnpj) {
		return validadorCnpjFeignClient.validarCnpj(cnpj);
	}
}
