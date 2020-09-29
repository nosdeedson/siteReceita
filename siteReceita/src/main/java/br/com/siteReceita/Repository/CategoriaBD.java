package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
	
	

}
