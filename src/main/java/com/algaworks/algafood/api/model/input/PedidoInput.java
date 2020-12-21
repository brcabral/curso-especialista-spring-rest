package com.algaworks.algafood.api.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoInput {
	@Valid
	@NotNull
	private RestauranteIdInput restaurante;

	@Valid
	@NotNull
	private EnderecoInput enderecoEntrega;

	@Valid
	@NotNull
	private FormaPagamentoIdInput formaPagamento;

	@Valid
	@NotNull
	@Size(min = 1)
	private List<ItemPedidoInput> itens;
}
