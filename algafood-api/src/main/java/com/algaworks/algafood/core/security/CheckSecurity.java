package com.algaworks.algafood.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	public @interface Cozinhas {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarCozinhas()")
		public @interface PodeConsultar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_COZINHAS')")
		public @interface PodeEditar {
			//
		}
	}

	public @interface Restaurantes {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarRestaurantes()")
		public @interface PodeConsultar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeGerenciarCadastroRestaurantes()")
		public @interface PodeGerenciarCadastro {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeGerenciarFuncionamentoRestaurantes(#restauranteId)")
		public @interface PodeGerenciarFuncionamento {
			//
		}
	}

	public @interface Pedidos {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
		@PostAuthorize("hasAuthority('CONSULTAR_PEDIDOS') or "
				+ "@algaSecurity.usuarioAutenticadoIgual(returnObject.cliente.id) or "
				+ "@algaSecurity.gerenciaRestaurante(returnObject.restaurante.id)")
		public @interface PodeBuscar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podePesquisarPedidos(#filtro.clienteId, #filtro.restauranteId)")
		public @interface PodePesquisar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and isAuthenticated()")
		public @interface PodeCriar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeGerenciarPedidos(#codigoPedido)")
		public @interface PodeGerenciarPedidos {
			//
		}
	}

	public @interface FormasPagamento {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_FORMAS_PAGAMENTO')")
		public @interface PodeEditar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarFormasPagamento()")
		public @interface PodeConsultar {
			//
		}
	}

	public @interface Cidades {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_CIDADES')")
		public @interface PodeEditar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarCidades()")
		public @interface PodeConsultar {
			//
		}
	}

	public @interface Estados {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_ESTADOS')")
		public @interface PodeEditar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarEstados()")
		public @interface PodeConsultar {
			//
		}
	}

	public @interface UsuariosGruposPermissoes {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and @algaSecurity.usuarioAutenticadoIgual(#usuarioId)")
		public @interface PodeAlterarPropriaSenha {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and "
				+ "(hasAuthority('EDITAR_USUARIOS_GRUPOS_PERMISSOES') or @algaSecurity.usuarioAutenticadoIgual(#usuarioId))")
		public @interface PodeAlterarUsuario {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeEditarUsuariosGruposPermissoes()")
		public @interface PodeEditar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarUsuariosGruposPermissoes()")
		public @interface PodeConsultar {
			//
		}
	}

	public @interface Estatisticas {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("@algaSecurity.podeConsultarEstatisticas()")
		public @interface PodeConsultar {
			//
		}
	}
}
