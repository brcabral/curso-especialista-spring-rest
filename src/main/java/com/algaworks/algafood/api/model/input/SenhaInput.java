package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaInput {
	@NotNull
	private String senhaAtual;

	@NotNull
	private String novaSenha;
}
