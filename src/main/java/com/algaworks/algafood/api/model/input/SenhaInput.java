package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaInput {
	@NotNull
	@ApiModelProperty(example = "123", required = true)
	private String senhaAtual;

	@NotNull
	@ApiModelProperty(example = "123", required = true)
	private String novaSenha;
}
