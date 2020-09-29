package br.com.siteReceita.Repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.siteReceita.Model.Comentario;

public class ComentarioBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	public ComentarioBD() { }
	
	
	public void salvarComentario( Comentario comentario) {
		try {
			this.em.merge(comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
