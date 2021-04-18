package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.CidadeModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("CidadesModel")
public class CidadesModelOpenApi {
	private Links _links;
	private CidadesEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("CidadesEmbeddedModel")
	public class CidadesEmbeddedModelOpenApi {
		private List<CidadeModel> cidades;
	}
}
