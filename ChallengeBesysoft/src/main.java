import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args)  {
		try {
			Sistema s = new Sistema();
			
			Vendedor v = s.almacenarVendedor(1L,"Robertino", 30D);
			Producto p = s.almacenarProducto(1L, "lapiz", 100D, Categoria.CATEGORIA1);
			
			ContadorDeProducto cp = new ContadorDeProducto(3,p);
			List<ContadorDeProducto> list = new ArrayList<ContadorDeProducto>();
			list.add(cp);
			
			Venta venta = s.registrarUnaVenta(v, list);
			
			Double comision = v.calcularComisionDeVenta(venta);
			
			System.out.println("La comision de la venta de 3 productos es de: " +comision);
			
			ContadorDeProducto cp2 = new ContadorDeProducto(1,p);
			List<ContadorDeProducto> list2 = new ArrayList<ContadorDeProducto>();
			list2.add(cp2);
			
			Venta venta2 = s.registrarUnaVenta(v, list2);
			
			Double comision2 = v.calcularComisionDeVenta(venta2);
			
			System.out.println("La comision de la venta de 1 producto es de: " +comision2);
			
			System.out.println("El total de comisiones de un vendedor es de : " +v.calcularTotalDeMisComisiones());
			
			Producto p2 = s.almacenarProducto(1L, "papel", 100D, Categoria.CATEGORIA2);
			
			Filtro b = new Filtro.FiltroBuilder().categoria(Categoria.CATEGORIA2).precioMaximo(200D).precioMinimo(60D).build();
			
			List<Producto> list3 = s.buscador(b);
			System.out.println("Resultado de busqueda por una categoria y precio: " +list3.size());
			System.out.println("Nombre del producto de la busqueda: " +list3.get(0).getNombre());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println( "Error en el sistema" );
			
		}
		
	}

}
