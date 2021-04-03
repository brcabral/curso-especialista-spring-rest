package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.PermissaoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("PermissoesModel")
public class PermissoesModelOpenApi {
	private Links _links;
	private PermissoesEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("PermissoesEmbeddedModel")
	public class PermissoesEmbeddedModelOpenApi {
		private List<PermissaoModel> permissoes;
	}
}
