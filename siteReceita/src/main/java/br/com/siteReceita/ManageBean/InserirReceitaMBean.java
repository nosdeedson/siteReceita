package br.com.siteReceita.ManageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import br.com.siteReceita.Model.Categoria;
import br.com.siteReceita.Repository.CategoriaBD;

@Named
@javax.faces.view.ViewScoped
public class InserirReceitaMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Categoria categoria;
	
	@Inject
	private CategoriaBD categoriasBD;
	
	@Inject
	private EntityManager em;
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	
	public void salvar() {
		EntityTransaction et = this.em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			et.begin();
			//categoria.setNome("massas");
			//categoriasBD.salvarCategoria(categoria);
			et.commit();
			context.addMessage(null, new FacesMessage("Categoria adicionada!!" ));
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			e.printStackTrace();
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		} finally {
			categoria = new Categoria();
		}
		
	}

	public void buscarCategorias() {
		
		categorias = categoriasBD.buscarCategorias();
		
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
}
