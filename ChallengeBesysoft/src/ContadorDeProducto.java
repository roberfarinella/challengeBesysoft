
public class ContadorDeProducto {
	private Long id;
	private Integer cantidad;
	private Producto producto;
	
	public ContadorDeProducto(int unaCantidad, Producto unProducto) {
		this.setCantidad(unaCantidad);
		this.setProducto(unProducto);
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
