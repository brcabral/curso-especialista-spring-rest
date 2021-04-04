package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CozinhaInput")
public class CozinhaInputV2 {
	@NotBlank
	@ApiModelProperty(example = "Brasileira", required = true)
	private String nomeCozinha;
}
