package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInput {
	@NotNull
	private String cep;

	@NotNull
	private String logradouro;

	@NotNull
	private String numero;

	private String complemento;

	@NotNull
	private String bairro;

	@Valid
	@NotNull
	private CidadeIdInput cidade;
}
