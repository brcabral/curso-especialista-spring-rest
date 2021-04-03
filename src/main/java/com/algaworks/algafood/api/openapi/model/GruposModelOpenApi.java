package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.GrupoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("GruposModel")
public class GruposModelOpenApi {
	private Links _links;
	private GruposEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("GruposEmbeddedModel")
	public class GruposEmbeddedModelOpenApi {
		private List<GrupoModel> grupos;
	}
}
