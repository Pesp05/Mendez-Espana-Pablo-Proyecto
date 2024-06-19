package com.salesianostriana.dam.mendezespanapabloproyecto.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Categoria;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Color;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.LineaVenta;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Producto;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Talla;
import com.salesianostriana.dam.mendezespanapabloproyecto.model.Usuario;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.categoria = :categoria")
	public List<Producto> productosPorCategoria(@Param("categoria") Categoria categoria);
	
	@Query("select p from Producto p where p.nombre ILIKE %:nombre%")
	public List<Producto> productosPorNombre(@Param("nombre") String nombre);
	
	@Query("select p.colores from Producto p where p.id = :idProducto")
	public List<Color> coloresPorIdProducto(@Param("idProducto") Long idProducto);
	
	@Query("select p.tallas from Producto p where p.id = :idProducto")
	public List<Talla> tallasPorIdProducto(@Param("idProducto") Long idProducto);
	
	@Query("select p.lineasVenta from Producto p where p.id = :idProducto")
	public List<LineaVenta> siProductoEnLineaDeVenta(@Param("idProducto") Long idProducto);
	
	@Query("""
			SELECT p
			FROM Producto p
			ORDER BY precioVenta
			LIMIT 6
			""")
    public List<Producto> buscar6MasBaratos();
	
	@Query("""
			SELECT p
			FROM Producto p
			JOIN LineaVenta lv ON p.id = lv.producto.id
			GROUP BY p.id 
			ORDER BY SUM(lv.cantidad) DESC
			LIMIT 3
			""")
	public List<Producto> buscar3MasVendidos();
	
	@Query("""
			SELECT u 
			FROM Usuario u
			JOIN Venta v ON u.id = v.usuario.id
			GROUP BY u.id
			ORDER BY COUNT(v.id) DESC
			LIMIT 1
			""")
	public Usuario bestUser();

	
}
