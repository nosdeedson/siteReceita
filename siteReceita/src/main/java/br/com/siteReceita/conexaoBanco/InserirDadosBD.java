package br.com.siteReceita.conexaoBanco;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.siteReceita.Model.Categoria;
import br.com.siteReceita.Model.Comentario;
import br.com.siteReceita.Model.Favorito;
import br.com.siteReceita.Model.Receita;
import br.com.siteReceita.Model.Restaurante;
import br.com.siteReceita.Model.Usuario;

public class InserirDadosBD implements Serializable {
	
	public static void inserir( EntityManager em) {
		
		Usuario user = new Usuario();
		user.setEmail("teste@email.com");
		user.setNome("Joao da Silva");
		
		Categoria categoria = new Categoria();
		categoria.setNome("massa");
		
		Restaurante restaurante = new Restaurante();
		restaurante.setEndereco("rua sem nome, centro.");
		restaurante.setNome("Restaurante da tia");
		
		Receita receita = new Receita();
		
		receita.setCategoria(categoria);
		receita.setIngrediente("macarrão, massa de tomate, queijo, 500 gr de peito de frango");
		receita.setNome("Macarrão com frango");
		receita.setModoPreparo("tempere o frango com alho e limão, deixe descansar por um dia, "
				+ "coloque o frango para cozinhar, quando a água ferve adicione o macarrão, "
				+ "cozinhe por seis minutos, prepare o molho a gosto.");
		receita.setUser(user);
		receita.setRestaurante(restaurante);
		
//		Path path = FileSystems.getDefault().getPath("/home/edson/Imagens/teste.jpg");
//		Path path1 = FileSystems.getDefault().getPath("/home/edson/Imagens/teste2.jpg");
//		try {
//			List<byte[]> imgs = new ArrayList<byte[]>();
//			byte[] foto = Files.readAllBytes(path);
//			byte[] foto1 = Files.readAllBytes(path);
//			imgs.add(foto);
//			imgs.add(foto1);
//			receita.setFotos(imgs);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
				
		Favorito favorito = new Favorito();
		favorito.setReceita(receita);
		favorito.setUser(user);
		
		Comentario comentario = new Comentario();
		
		comentario.setUser(user);
		comentario.setReceita(receita);
		comentario.setComentario("receita muito boa para o dia a dia");
		
		
		em.persist(user);
		em.persist(categoria);
		em.persist(restaurante);
		em.persist(receita);
		em.persist(comentario);
		em.persist(favorito);
		
		
		Usuario user1 = new Usuario();
		user1.setEmail("jose@email.com");
		user1.setNome("Jose da Silva");
		
		Categoria categoria1 = new Categoria();
		categoria1.setNome("bebida");
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setEndereco("rua sem nome, centro.");
		restaurante1.setNome("Restaurante da tia");
		
		Receita receita1 = new Receita();
		
		receita1.setCategoria(categoria1);
		receita1.setIngrediente("cachaça, limão, acuçar");
		receita1.setNome("capirinha");
		receita1.setModoPreparo("acho que é só misturar");
		receita.setUser(user1);
		receita.setRestaurante(restaurante1);
		
		Favorito favorito1 = new Favorito();
		favorito.setReceita(receita1);
		favorito.setUser(user1);
		
		Comentario comentario1 = new Comentario();
		
		comentario1.setUser(user1);
		comentario1.setReceita(receita1);
		comentario1.setComentario("bem com moderação e muito forte.");
		
		
		em.persist(user1);
		em.persist(categoria1);
		em.persist(restaurante1);
		em.persist(receita1);
		em.persist(comentario1);
		em.persist(favorito1);
		
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siteReceitaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			inserir(em);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
	}

}
