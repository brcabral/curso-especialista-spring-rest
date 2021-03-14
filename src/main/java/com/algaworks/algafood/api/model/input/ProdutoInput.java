package com.algaworks.algafood.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {
	@NotNull
	@ApiModelProperty(example = "Espetinho de Cupim", required = true)
	private String nome;

	@NotNull
	@ApiModelProperty(example = "Acompanha farinha, mandioca e vinagrete", required = true)
	private String descricao;

	@NotNull
	@PositiveOrZero
	@ApiModelProperty(example = "12.50", required = true)
	private BigDecimal preco;

	@NotNull
	@ApiModelProperty(example = "true", required = true)
	private Boolean ativo;
}
