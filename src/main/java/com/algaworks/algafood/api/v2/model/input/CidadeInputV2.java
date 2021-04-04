package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInputV2 {
	@NotBlank
	@ApiModelProperty(example = "Uberlândia", required = true)
	private String nomeCidade;

	@NotNull
	@ApiModelProperty(example = "1", required = true)
	private Long idEstado;
}
