import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Producto> productos;
	private List<Vendedor> vendedores;
	private List<Venta> ventas;
	
	public Sistema() {
		productos = new ArrayList<Producto>();
		vendedores = new ArrayList<Vendedor>();
		ventas = new ArrayList<Venta>();
	}
	
	//METODOS DEL SISTEMA

	
	//Se podrán almacenar productos (código, nombre, precio, categoría)
	public Producto almacenarProducto(Long codigo,String nombre, Double precio, Categoria categoria) throws Exception {
		try {
			Producto producto = new Producto(codigo ,nombre, categoria, precio);
			this.getProductos().add(producto);
			return producto;
		}
		catch (Exception e) {
			throw new Exception("Error al querer almacenar un producto",e);
		}
	}
	
	//, vendedor (código, nombre, sueldo).
	public Vendedor almacenarVendedor(Long codigo,String nombre, Double sueldo) throws Exception{
		try {
			Vendedor vendedor = new Vendedor(codigo ,nombre,sueldo);
			this.getVendedores().add(vendedor);
			return vendedor;
		}
		catch (Exception e) {
			throw new Exception( "Error al querer almacenar un vendedor" ,e);
		}
	}
	
	//Al registrar una venta, se tendrá que relacionar el producto con el vendedor que realizo la venta. 
	//NO LE REGISTRO UN ID DE VENTA PORQUE ESTIMO QUE LA BASE DE DATOS LA GENERARÁ
	public Venta registrarUnaVenta(Vendedor unVendedor, List<ContadorDeProducto> productos) throws Exception{
		try {
			Venta venta = new Venta(unVendedor, productos);
			this.getVentas().add(venta);
			unVendedor.agregarVenta(venta);
			return venta;
		}
		catch (Exception e) {
			throw new Exception( "Error al querer registar una venta" ,e);
		}
	}
	
	//Debe implementarse distintos tipos de buscadores de productos, por ejemplo el buscar por categoría.
	public List<Producto> buscador(Filtro filtro) throws Exception{
		try {
			return this.getProductos().stream()
				.filter(p -> this.filtrarPorCategoria(p, filtro))
				.filter(p -> this.filtrarPorNombre(p, filtro))
				.filter(p -> this.filtrarPrecioMin(p, filtro))
				.filter(p -> this.filtrarPrecioMax(p, filtro))
				.collect(Collectors.toList());
			
			}
		catch (Exception e) {
			throw new Exception( "Error al filtrar productos",e );
		}
	}

	//GETTERS Y SETTERS
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public List<Vendedor> getVendedores() {
		return vendedores;
	}
	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	public List<Venta> getVentas() {
		return ventas;
	}
	
	//METODOS DEL FILTRO
	private boolean filtrarPrecioMax(Producto p, Filtro filtro) {
		return filtro.getPrecioMaximo() == null || filtro.getPrecioMaximo() > p.getPrecio();
	}

	private boolean filtrarPrecioMin(Producto p, Filtro filtro) {
		return filtro.getPrecioMinimo() == null || filtro.getPrecioMinimo() < p.getPrecio();
	}

	private boolean filtrarPorNombre(Producto p, Filtro filtro) {
		return filtro.getNombre() == null || p.getNombre().contains(filtro.getNombre());
	}

	private boolean filtrarPorCategoria(Producto p, Filtro filtro) {
		return filtro.getCategoria() == null || filtro.getCategoria().getNombre().equals(p.getCategoria().getNombre());

	}
}
