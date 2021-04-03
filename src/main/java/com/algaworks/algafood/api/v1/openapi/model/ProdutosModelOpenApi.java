package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.ProdutoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("ProdutosModel")
public class ProdutosModelOpenApi {
	private Links _links;
	private ProdutosEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("ProdutosEmbeddedModel")
	public class ProdutosEmbeddedModelOpenApi {
		private List<ProdutoModel> produtos;
	}
}
