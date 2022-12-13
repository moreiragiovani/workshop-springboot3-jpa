package com.cursospring.br.entities;

import java.io.Serializable;
import java.util.Objects;

import com.cursospring.br.entities.pk.ItemProdutoPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemProdutoPk id = new ItemProdutoPk();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido () {
	}

	public ItemPedido(PedidoEntitie pedido, ProdutoEntitie produto, Integer quantidade, Double preco) {
		super();
		id.setPedidoPk(pedido);
		id.setProdutopk(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public PedidoEntitie getPedido() {
		return id.getPedidoPk();
	}
	
	public void setPedido(PedidoEntitie pedido) {
		id.setPedidoPk(pedido);
	}

	public ProdutoEntitie getProduto() {
		return id.getProdutopk();
	}
	
	public void setProduto(ProdutoEntitie produto) {
		id.setProdutopk(produto);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
