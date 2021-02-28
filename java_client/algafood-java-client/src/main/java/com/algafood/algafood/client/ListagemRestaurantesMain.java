package com.algafood.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.algafood.algafood.client.api.RestauranteClient;

public class ListagemRestaurantesMain {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://api.algafood.local:8080");
		restauranteClient.listar().stream().forEach(restaurante -> System.out.println(restaurante));
	}
}
