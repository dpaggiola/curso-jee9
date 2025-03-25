package apps.desarrollo1;

import apps.desarrollo1.modelo.Categoria;
import apps.desarrollo1.modelo.Producto;
import apps.desarrollo1.repositorio.ProductoRepositorioImpl;
import apps.desarrollo1.repositorio.Repositorio;
import apps.desarrollo1.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== editar nuevo producto ===========");
            Producto producto = new Producto();
            producto.setId(4L);
            producto.setNombre("Teclado Corsair K95 mecánico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("Producto editado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
