import java.util.List;

public class Venta {
	private Long Id;
	private Vendedor vendedor;
	private List<ContadorDeProducto> productos;
	
	public Venta( Vendedor unVendedor, List<ContadorDeProducto> unosProductos) {
		this.setProductos(unosProductos);
		this.setVendedor(unVendedor);
	}
	
	public List<ContadorDeProducto> getProductos() {
		return productos;
	}
	public void setProductos(List<ContadorDeProducto> productos) {
		this.productos = productos;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
}
