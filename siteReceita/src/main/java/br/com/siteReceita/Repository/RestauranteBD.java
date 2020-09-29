package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.siteReceita.Model.Restaurante;

public class RestauranteBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	public RestauranteBD() { }
	
	public void salvarRestaurante( Restaurante restaurante) {
		this.em.merge(restaurante);
	}

	
}
