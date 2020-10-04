package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private BigDecimal subtotal;

	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@CreationTimestamp
	@Column(name = "data_criacao", columnDefinition = "datetime")
	private LocalDateTime dataCriacao;

	@Column(name = "data_confirmacao", columnDefinition = "datetime")
	private LocalDateTime dataConfirmacao;

	@Column(name = "data_cancelamento", columnDefinition = "datetime")
	private LocalDateTime dataCancelamento;

	@Column(name = "data_entrega", columnDefinition = "datetime")
	private LocalDateTime dataEntrega;

	@Embedded
	private Endereco enderecoEntrega;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;

	@ManyToOne
	@JoinColumn(name = "usuario_cliente_id", nullable = false)
	private Usuario cliente;

	private StatusPedido status;

	@ManyToOne
	@JoinColumn(nullable = false)
	private FormaPagamento formaPagamento;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();
}