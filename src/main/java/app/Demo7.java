package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;
import model.Usuario;

public class Demo7 {
	//Listado de todos los productos, mostrando el tipo de producto
	
	public static void main(String[] args) {
		//1. Obtener la conexion -> llamar a la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
		//2. Crear un manejador de entidades 
		EntityManager em = fabrica.createEntityManager();
		
		//Select * from tb_productos --> lista
				String jpql= "select p from Productos p";
				List<Productos> lstProductos = em.createQuery(jpql, Productos.class).getResultList();
				for(Productos p : lstProductos) {
					System.out.println("Codigo: ................" + p.getId_prod());
					System.out.println("Descripcion:............" + p.getDes_prod());
					System.out.println("Stock:.................." + p.getStk_prod());
					System.out.println("Precio:................." + p.getPre_prod());
					System.out.println("Categoria:.............." + p.getObjCategorias().getDescripcion());
					System.out.println("Estado del producto:...." + p.getEst_prod());
					System.out.println("Proveedor:.............." + p.getObjProveedor().getNombre_rs());
				}
				em.close();
	}
}
