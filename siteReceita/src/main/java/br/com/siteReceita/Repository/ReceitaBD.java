package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.siteReceita.Model.Receita;

public class ReceitaBD implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	@Inject
	public ReceitaBD(EntityManager em) {	}



	public void salvarReceita(Receita receita) {
		try {
			this.em.merge(receita);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
