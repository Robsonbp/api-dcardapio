package br.edu.infnet.robsonpinto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.robsonpinto.model.domain.CnpjInfo;
import br.edu.infnet.robsonpinto.model.service.CnpjInfoService;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjInfoController {
	
	private final CnpjInfoService cnpjInfoService;
	
	public CnpjInfoController(CnpjInfoService cnpjInfoService) {
		this.cnpjInfoService = cnpjInfoService;
	}
	
	@GetMapping("/{cnpj}")
	public ResponseEntity<CnpjInfo> validarVendedor(@PathVariable String cnpj) {
		CnpjInfo cnpjResponse = cnpjInfoService.validarVendedor(cnpj);
		return ResponseEntity.ok(cnpjResponse);
	}
}
