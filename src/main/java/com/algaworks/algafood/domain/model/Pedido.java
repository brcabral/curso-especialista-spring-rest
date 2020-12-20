package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	private OffsetDateTime dataCriacao;

	@Column(name = "data_confirmacao", columnDefinition = "datetime")
	private OffsetDateTime dataConfirmacao;

	@Column(name = "data_cancelamento", columnDefinition = "datetime")
	private OffsetDateTime dataCancelamento;

	@Column(name = "data_entrega", columnDefinition = "datetime")
	private OffsetDateTime dataEntrega;

	@Embedded
	private Endereco enderecoEntrega;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;

	@ManyToOne
	@JoinColumn(name = "usuario_cliente_id", nullable = false)
	private Usuario cliente;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private FormaPagamento formaPagamento;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	public void calcularValorTotal() {
		this.subtotal = getItens().stream().map(item -> item.getPrecoTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void definirFrete() {
		setTaxaFrete(getRestaurante().getTaxaFrete());
	}

	public void atribuirPedidoAosItens() {
		getItens().forEach(item -> item.setPedido(this));
	}
}
