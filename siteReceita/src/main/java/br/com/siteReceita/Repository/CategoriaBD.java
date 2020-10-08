package br.com.siteReceita.Repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.siteReceita.Model.Categoria;

public class CategoriaBD implements Serializable {
	
	@Inject
	private EntityManager em;

	@Inject
	public CategoriaBD(EntityManager em) { 	}
	
	public void salvarCategoria( Categoria categoria) {
		try {
			this.em.merge(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Categoria> buscarCategorias() {
		
		String sql = "from Categoria";
		
		try {
			TypedQuery<Categoria> categorias = this.em.createQuery(sql, Categoria.class);
			
			return categorias.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	

}
