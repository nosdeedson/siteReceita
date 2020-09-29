package br.com.siteReceita.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionType;

@Entity
@Table(name = "receita")
public class Receita implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Categoria categoria;
	private String ingrediente;
	private String nome;
	private String modoPreparo;
	private Restaurante restaurante;
	private Usuario user;
	//private byte[] foto;
	private List<byte[]> fotos = new ArrayList<byte[]>();
	
	public Receita() {}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name= "ingrediente", nullable = false)
	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Column(name= "nome", nullable = false, length = 30)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name= "modo_preparo", nullable = false)
	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	@OneToOne	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@OneToOne
	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@ManyToOne
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	@Lob
	@ElementCollection
	@CollectionTable(name = "foto")
	@JoinColumn(name = "id")
	public List<byte[]> getFotos() {
		return fotos;
	}

	public void setFotos(List<byte[]> fotos) {
		this.fotos = fotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
