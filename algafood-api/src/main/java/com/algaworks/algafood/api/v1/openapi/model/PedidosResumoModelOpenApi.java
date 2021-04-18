package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.PedidoResumoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("PedidosResumoModel")
public class PedidosResumoModelOpenApi {
	private Links _links;
	private PageModelOpenApi page;
	private PedidosResumoEmbeddedModelOpenApi _embedded;

	@Data
	@ApiModel("PedidosResumoEmbeddedModel")
	public class PedidosResumoEmbeddedModelOpenApi {
		private List<PedidoResumoModel> pedidos;
	}
}