package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.siteReceita.Model.Favorito;

public class FavoritoBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public FavoritoBD() {}
	
	public void salvarFavorito(Favorito favorito) {
		
		try {
			this.em.merge(favorito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
