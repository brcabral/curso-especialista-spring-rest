package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
	@NotNull
	@ApiModelProperty(example = "João da Silva", required = true)
	private String nome;

	@Email
	@NotNull
	@ApiModelProperty(example = "joao.ger@algafood.com.br", required = true)
	private String email;
}
