package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.model.input.CidadeInput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class CidadeInputDisassembler {
	@Autowired
	private ModelMapper modelMapper;

	public Cidade toDomainObject(CidadeInput cidadeInput) {
		return modelMapper.map(cidadeInput, Cidade.class);
	}

	public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
		// Como uma instancia de uma entidade gerenciada pelo JPA nao pode ter seu ID alterado,
		// é necessario instanciar uma nova cozinha, para evitar uma exception
		// identifier of an instance of com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
		cidade.setEstado(new Estado());
		modelMapper.map(cidadeInput, cidade);
	}
}