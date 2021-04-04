package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.CozinhaModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CozinhasModel")
public class CozinhasModelV2OpenApi {
	private Links _links;
	private PageModelV2OpenApi page;
	private CozinhasEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("CozinhasEmbeddedModel")
	public class CozinhasEmbeddedModelOpenApi {
		private List<CozinhaModel> cozinhas;
	}
}
