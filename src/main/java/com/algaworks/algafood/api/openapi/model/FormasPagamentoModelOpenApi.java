package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.FormaPagamentoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("FormasPagamentoModel")
public class FormasPagamentoModelOpenApi {
	private Links _links;
	private FormasPagamentoEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("FormasPagamentoEmbeddedModel")
	public class FormasPagamentoEmbeddedModelOpenApi {
		private List<FormaPagamentoModel> formasPagamento;
	}
}
