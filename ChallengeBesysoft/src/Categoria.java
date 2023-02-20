
public enum Categoria {
	CATEGORIA1("categoria 1"),
	CATEGORIA2("categoria 2"),
	CATEGORIA3("categoria 3");
	
	private String nombre;

	public String getNombre() { return nombre; }
	
	Categoria(String unNombre){
		this.nombre = unNombre;
	}

}
