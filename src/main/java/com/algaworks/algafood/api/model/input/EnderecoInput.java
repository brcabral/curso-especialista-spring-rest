package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInput {
	@NotNull
	@ApiModelProperty(example = "38400-000", required = true)
	private String cep;

	@NotNull
	@ApiModelProperty(example = "Rua Floriano Peixoto", required = true)
	private String logradouro;

	@NotNull
	@ApiModelProperty(example = "\"1500\"", required = true)
	private String numero;

	@ApiModelProperty(example = "Apto 901")
	private String complemento;

	@NotNull
	@ApiModelProperty(example = "Centro", required = true)
	private String bairro;

	@Valid
	@NotNull
	private CidadeIdInput cidade;
}
