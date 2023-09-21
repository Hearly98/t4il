package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		//1. Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
		//2. Crear un manejador de entidades 
		EntityManager em = fabrica.createEntityManager();
		//procesos
				//Usuario u = new Usuario(123, "Juan", "Perez", "jperez", "7854","2000/01/15", 1,1);
				Usuario u = new Usuario();
				u.setCod_usua(234);
				u.setNom_usua("Maria");
				u.setApe_usua("Lopez");
				u.setUsr_usua("mlopez");
				u.setCla_usua("marylm");
				u.setFna_usua("2005/08/10");
				u.setIdtipo(1);
				u.setEst_usua(1);
				//insert into tb_xxxx values(?,?........)
				//Si el proceso que quiero ejecutar es un: reg/act/elim --> necesitan : transacciones
				em.getTransaction().begin();
				em.persist(u);
				//update tb_xxx ser campo=? .... where ....
				em.merge(u);
				//delete from tb_xxx where
				em.remove(u);
				//select * from tb_xxx where id=?
				Usuario x = em.find(Usuario.class, 1);
				em.getTransaction().commit();
				System.out.println("REGISTRO OK");
				em.close();
		
	}
}
