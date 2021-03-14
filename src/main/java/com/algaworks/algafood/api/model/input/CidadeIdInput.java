package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeIdInput {
	@NotNull
	@ApiModelProperty(example = "1", required = true)
	private Long id;
}
