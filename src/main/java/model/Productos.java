package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {
		@Id
		private String id_prod;
		private String des_prod;
		private int stk_prod;
		private float pre_prod;
		private int idcategoria;
		private int est_prod;
		private int idproveedor;
		@ManyToOne
		@JoinColumn(name="idproveedor", insertable=false,updatable=false)
		private Proveedor objProveedor;
		@ManyToOne
		@JoinColumn(name="idcategoria", insertable=false, updatable=false)
		private Categorias objCategorias;
	}
