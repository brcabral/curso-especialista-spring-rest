package com.algaworks.algafood.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	public @interface Cozinhas {
		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
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
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
		public @interface PodeConsultar {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_RESTAURANTES')")
		public @interface PodeGerenciarCadastro {
			//
		}

		@Target(METHOD)
		@Retention(RUNTIME)
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and "
				+ "(hasAuthority('EDITAR_RESTAURANTES') or @algaSecurity.gerenciaRestaurante(#restauranteId))")
		public @interface PodeGerenciarFuncionamento {
			//
		}
	}
}
