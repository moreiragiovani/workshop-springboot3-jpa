package com.cursospring.br.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class ProdutoEntitie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<CategoriaEntitie> categorias = new HashSet<>();
	
	@OneToMany(mappedBy = "id.produtoPk")
	private Set<ItemPedido> itemProdutos = new HashSet<>();
	
	public ProdutoEntitie () {
	}

	public ProdutoEntitie(Long id, String nome, String descricao, Double preco, String imgUrl) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	@JsonIgnore
	public Set<PedidoEntitie> getItemProdutos(){
		Set<PedidoEntitie> set = new HashSet<>();
		for(ItemPedido x: itemProdutos) {
			set.add(x.getPedido());
		}
		return set;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<CategoriaEntitie> getCategorias() {
		return categorias;
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
		ProdutoEntitie other = (ProdutoEntitie) obj;
		return Objects.equals(id, other.id);
	}
}
