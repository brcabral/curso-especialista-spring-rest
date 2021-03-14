package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.core.validation.FileContentType;
import com.algaworks.algafood.core.validation.FileSize;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoInput {
	@NotNull
	@FileSize(max = "500KB")
	@FileContentType(allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	@ApiModelProperty(value = "Arquivo da foto do produto (máximo 500KB, apenas JPG e PNG)", required = true)
	private MultipartFile arquivo;

	@NotBlank
	@ApiModelProperty(value = "Descrição da foto do produto", required = true)
	private String descricao;
}
