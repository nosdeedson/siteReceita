package br.com.siteReceita.conexaoBanco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class TesteConexao {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		// senha surfando user nosde
		try {
//			Persistence.createEntityManagerFactory("beyondschoolPU");
			 emf = Persistence.createEntityManagerFactory("siteReceitaPU");
			em = emf.createEntityManager();
//			EntityTransaction et = em.getTransaction();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " nao deu"+ e.getMessage());
		}
		finally {
			em.close();
			emf.close();
			JOptionPane.showMessageDialog(null, " ok");
		}

	}

}
