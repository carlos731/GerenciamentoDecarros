package com.example.gerenciadordecarros.Inicializacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.gerenciadordecarros.domain.Acessorio;
import com.example.gerenciadordecarros.domain.Carro;
import com.example.gerenciadordecarros.domain.Chave;
import com.example.gerenciadordecarros.domain.Documento;
import com.example.gerenciadordecarros.domain.Fabricante;
import com.example.gerenciadordecarros.service.AcessorioService;
import com.example.gerenciadordecarros.service.CarroService;
import com.example.gerenciadordecarros.service.ChaveService;
import com.example.gerenciadordecarros.service.DocumentoService;
import com.example.gerenciadordecarros.service.FabricanteService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired 
	private DocumentoService documentoService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@Autowired
	private ChaveService chaveService;
	
	@Autowired 
	private AcessorioService acessorioService;
	
	@Autowired
	private CarroService carroService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Fabricante fabricante = new Fabricante("Chevrolet");
		Fabricante fabricante1 = new Fabricante("Fiat");
		Fabricante fabricante2 = new Fabricante("Porshe");
		fabricanteService.saveAll(Arrays.asList(fabricante, fabricante1, fabricante2));
		
		Documento documento = new Documento("Habilitação", "214232123asd13");
		Documento documento1 = new Documento("Automével", "21423asd2asd11233");
		Documento documento2 = new Documento("Asdasd", "21123423asdsa213");
		documentoService.saveAll(Arrays.asList(documento, documento1, documento2));

		Chave chave = new Chave("10239109sa0f99012wafd23");
		Chave chave1 = new Chave("10239109sa0f9asadf9023");
		Chave chave2 = new Chave("1023910sdafasf9sa0f993");
		chaveService.saveAll(Arrays.asList(chave, chave1, chave2));
		
		Acessorio acessorio = new Acessorio("Peça 1");
		Acessorio acessorio2 = new Acessorio("Peça 2");
		Acessorio acessorio3 = new Acessorio("Peça 3");
		acessorioService.saveAll(Arrays.asList(acessorio, acessorio2, acessorio3));
		
		List<Acessorio> listaAcessorio = new ArrayList<>();
		listaAcessorio.add(acessorio);
		listaAcessorio.add(acessorio2);
		
		Carro carro = new Carro("Camaro", fabricante, documento, chave, listaAcessorio);
		carroService.saveAll(Arrays.asList(carro));
		
		
		
	}
}
