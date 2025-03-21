package apps.desarrollo1;

import apps.desarrollo1.modelo.Producto;
import apps.desarrollo1.repositorio.ProductoRepositorioImpl;
import apps.desarrollo1.repositorio.Repositorio;
import apps.desarrollo1.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== insertar nuevo producto ===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado mecánico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
