package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo9 {
	//Listado de todos los usuarios, segun un criterio (filtro)
	
	public static void main(String[] args) {
		String usuario=JOptionPane.showInputDialog("Ingrese Usuario: ");
		String clave=JOptionPane.showInputDialog("Ingrese Clave: ");
		//1. Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
		//2. Crear un manejador de entidades 
		EntityManager em = fabrica.createEntityManager();
		
		//Select * from tb_usuarios where usr_usua = ? and cla_usua = ? -->lista
		
				String jpql= "select u from Usuario u where  u.usr_usua = :xusr and u.cla_usua = :xcla";
				//consulta en la base de datos
				try {
					Usuario u = em.createQuery(jpql,Usuario.class).
							setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
					//Mostrar el contenido del listado
					JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNom_usua());
					//abrir la ventana principal
					FrmManteProd v = new FrmManteProd(); //creando una instancia en memoria
					v.setVisible(true); //mostrando ventana
					//dispose();
				}catch(Exception e) {//excepcion de Error
					JOptionPane.showMessageDialog(null, "Error: usuario o clave incorrecta");
				}
				em.close();
	}
}
