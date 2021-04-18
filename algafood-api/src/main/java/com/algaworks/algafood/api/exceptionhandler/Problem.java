package com.algaworks.algafood.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
public class Problem {
	@ApiModelProperty(example = "400", position = 1)
	private Integer status;

	@ApiModelProperty(example = "https://algafood.com.br/dados-invalidos", position = 10)
	private String type;

	@ApiModelProperty(example = "Dados inválidos", position = 15)
	private String title;

	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 20)
	private String detail;

	@ApiModelProperty(example = "2021-03-07T23:23:58.70844Z", position = 5)
	private OffsetDateTime timestamp;

	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 25)
	private String userMessage;

	@ApiModelProperty(value = "Lista de objetos ou campos que geraram o erro (opcional)", position = 30)
	private List<Object> objects;

	@Getter
	@Builder
	@ApiModel("ObjetoProblema")
	public static class Object {
		@ApiModelProperty(example = "preco")
		private String name;

		@ApiModelProperty(example = "O preço é obrigatório")
		private String userMessage;
	}

}
