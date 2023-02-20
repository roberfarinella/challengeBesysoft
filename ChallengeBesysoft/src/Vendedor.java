import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	private Long codigo;
	private Double sueldo;
	private String nombre;
	private List<Venta> ventas;
	
	public Vendedor(Long unID, String unNombre, Double unSueldo) {
		this.setCodigo(unID);
		this.setNombre(unNombre);
		this.setSueldo(unSueldo);
		ventas = new ArrayList<Venta>();
	}
	
	public Double calcularComisionDeVenta(Venta venta) throws Exception{
		try {
			/*Double totalVenta = venta.getProductos().stream()
					.reduce(0D,
							(subtotal, prod) -> subtotal + (prod.getProducto().getPrecio() * prod.getCantidad()), 
							Double::sum);
			
			int cantidadDeProductos = venta.getProductos().stream()
					.reduce(0,
							(subtotal, prod) -> subtotal + prod.getCantidad(), 
							Integer::sum);*/
			
			Double totalVenta = 0D;
			int cantidadDeProductos = 0;
			for (ContadorDeProducto contadorProducto :venta.getProductos()) {
				totalVenta+= contadorProducto.getProducto().getPrecio() * contadorProducto.getCantidad();
				cantidadDeProductos+= contadorProducto.getCantidad();
			}
			
			if (cantidadDeProductos > 2) {
				return (totalVenta * 0.1);
			}
			else {
				return (totalVenta * 0.05);
			}
		}
			catch (Exception e) {
				throw new Exception( "Error al querer calcular la comision de una venta",e );
		}
	}
	
	public Double calcularTotalDeMisComisiones() throws Exception{
		
		return this.getVentas().stream()
			.reduce(0D,
					(subtotal, venta) -> {
						try {
							return subtotal + this.calcularComisionDeVenta(venta);
						} catch (Exception e) {
							e.printStackTrace();
							System.err.println( "Error al querer sumar una comision de una venta, se devuelve 0 para esta venta" );
							return 0.0;
						}
					}, 
					Double::sum);	
	}
	
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long unCodigo) {
		this.codigo = unCodigo;
	}

	public List<Venta> getVentas() {
		return ventas;
	}
	
	public void agregarVenta(Venta v) {
		this.getVentas().add(v);
	}
}
