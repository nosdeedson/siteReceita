package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.siteReceita.Model.Usuario;

public class UsuarioBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	@Inject
	public UsuarioBD() {	}
	
	public void salvarUsuario( Usuario user) {
		try {
			this.em.merge(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
