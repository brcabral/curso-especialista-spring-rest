package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.UsuarioModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("UsuariosModel")
public class UsuariosModelOpenApi {
	private Links _links;
	private UsuariosEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("UsuariosEmbeddedModel")
	public class UsuariosEmbeddedModelOpenApi {
		private List<UsuarioModel> usuarios;
	}
}
