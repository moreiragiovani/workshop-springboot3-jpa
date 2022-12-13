package com.cursospring.br.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.cursospring.br.entities.PedidoEntitie;
import com.cursospring.br.entities.ProdutoEntitie;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemProdutoPk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private PedidoEntitie pedidoPk;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private ProdutoEntitie produtopk;
	
	
	public PedidoEntitie getPedidoPk() {
		return pedidoPk;
	}
	public void setPedidoPk(PedidoEntitie pedidoPk) {
		this.pedidoPk = pedidoPk;
	}
	public ProdutoEntitie getProdutopk() {
		return produtopk;
	}
	public void setProdutopk(ProdutoEntitie produtopk) {
		this.produtopk = produtopk;
	}
	@Override
	public int hashCode() {
		return Objects.hash(pedidoPk, produtopk);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemProdutoPk other = (ItemProdutoPk) obj;
		return Objects.equals(pedidoPk, other.pedidoPk) && Objects.equals(produtopk, other.produtopk);
	}
}
