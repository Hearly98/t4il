package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo2 {
	//Listado de todos los usuarios
	
	public static void main(String[] args) {
		//1. Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
		//2. Crear un manejador de entidades 
		EntityManager em = fabrica.createEntityManager();
		
		//Select * from tb_usuarios --> lista
				String jpql= "select u from Usuario u";
				List<Usuario> lstUsuarios = em.createQuery(jpql,Usuario.class).getResultList();
				//Mostrar el contenido del listado
				for(Usuario u : lstUsuarios) {
					System.out.println("Codigo......: " + u.getCod_usua());
					System.out.println("Nombre......: " + u.getNom_usua()+ " " + u.getApe_usua());
					System.out.println("Tipo......: " + u.getIdtipo());
					System.out.println("---------------------------------");
				}
				em.close();
	}
}
