
public class Filtro {
	private final String nombre;
	private final Categoria categoria;
	private final Double precioMaximo;
	private final Double precioMinimo;
	
	private Filtro(FiltroBuilder builder) {
		this.categoria = builder.categoria;
		this.nombre = builder.nombre;
		this.precioMaximo = builder.precioMaximo;
		this.precioMinimo = builder.precioMinimo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecioMaximo() {
		return precioMaximo;
	}

	public Double getPrecioMinimo() {
		return precioMinimo;
	}
	
	public static class FiltroBuilder {
		private  String nombre;
		private  Categoria categoria;
		private  Double precioMaximo;
		private  Double precioMinimo;
		
		public FiltroBuilder nombre(String unNombre) {
			this.nombre = unNombre;
			return this;
		}
		
		public FiltroBuilder categoria(Categoria unCategoria) {
			this.categoria = unCategoria;
			return this;
		}
		
		public FiltroBuilder precioMaximo(Double precio) {
			this.precioMaximo = precio;
			return this;
		}
		
		public FiltroBuilder precioMinimo(Double precio) {
			this.precioMinimo = precio;
			return this;
		}
		
		public Filtro build() {
			Filtro filtro = new Filtro(this);
			return filtro;
		}

	}

}
