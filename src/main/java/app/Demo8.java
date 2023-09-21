package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo8 {
	//Listado de todos los usuarios, segun un criterio (filtro)
	
	public static void main(String[] args) {
	
				//diseña la gui para hacer el login y cuando ponga en consola que usuario encontró
				//1. Obtener la conexion -> llamar a la unidad de persistencia
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
				//2. Crear un manejador de entidades 
				EntityManager em = fabrica.createEntityManager();
				
				//Select * from tb_usuarios --> lista
				int xtipo=1;
						String jpql= "select u from Usuario u where u.idtipo =:xtipo";
						List<Usuario> lstUsuarios = em.createQuery(jpql,Usuario.class).setParameter("xtipo", xtipo).getResultList();
						//Mostrar el contenido del listado
						for(Usuario u : lstUsuarios) {
							System.out.println("Codigo......: " + u.getCod_usua());
							System.out.println("Nombre......: " + u.getNom_usua()+ " " + u.getApe_usua());
							System.out.println("Tipo........: " + u.getIdtipo()+ "-" + u.getObjTipo().getDescripcion());
							System.out.println("---------------------------------");
						}
						em.close();
						
						//diseña la gui para hacer el login y cuando ponga en consola que usuario encontró
	}
}
