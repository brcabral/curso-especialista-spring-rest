package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.RestauranteBasicoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("RestaurantesBasicoModel")
public class RestaurantesBasicoModelOpenApi {
	private Links _links;
	private RestaurantesEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("RestaurantesEmbeddedModel")
	public class RestaurantesEmbeddedModelOpenApi {
		private List<RestauranteBasicoModel> restaurantes;
	}
}
