
public class Producto {
	private Long codigo;
	private Double precio;
	private String nombre;
	private Categoria categoria;
	
	public Producto(Long unCodigo, String unNombre, Categoria unaCategoria, Double unPrecio) {
		this.setCategoria(unaCategoria);
		this.setCodigo(unCodigo);
		this.setNombre(unNombre);
		this.setPrecio(unPrecio);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long unCodigo) {
		this.codigo = unCodigo;
	}
}
