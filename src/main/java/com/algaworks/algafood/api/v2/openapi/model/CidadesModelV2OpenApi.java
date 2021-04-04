package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v2.model.CidadeModelV2;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("CidadesModel")
public class CidadesModelV2OpenApi {
	private Links _links;
	private CidadesEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("CidadesEmbeddedModel")
	public class CidadesEmbeddedModelOpenApi {
		private List<CidadeModelV2> cidades;
	}
}
