package br.com.siteReceita.ManageBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.siteReceita.Model.Categoria;
import br.com.siteReceita.Model.Receita;
import br.com.siteReceita.Repository.CategoriaBD;
import br.com.siteReceita.Repository.ReceitaBD;

@Named
@javax.faces.view.ViewScoped
public class InserirReceitaMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Receita receita;
	
	@Inject
	private ReceitaBD receitaBD;
	
	@Inject
	private EntityManager em;
	

	@Inject
	private CategoriaBD c;
	
	@Inject
	private Categoria cat;
	
	public void salvar() {
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			c.salvarCategoria(cat);
			
			et.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	
}
