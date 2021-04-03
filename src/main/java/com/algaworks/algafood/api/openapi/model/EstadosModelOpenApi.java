package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.EstadoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("EstadosModel")
public class EstadosModelOpenApi {
	private Links _links;
	private EstadosEmbeddedModelOpenApi _embedded;

	@ApiModel("EstadosEmbeddedModel")
	@Data
	public class EstadosEmbeddedModelOpenApi {
		private List<EstadoModel> estados;
	}
}
