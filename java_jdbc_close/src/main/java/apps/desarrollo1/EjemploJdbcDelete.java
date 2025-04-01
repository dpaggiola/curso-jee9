package apps.desarrollo1;

import apps.desarrollo1.modelo.Producto;
import apps.desarrollo1.repositorio.ProductoRepositorioImpl;
import apps.desarrollo1.repositorio.Repositorio;
import apps.desarrollo1.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        System.out.println("=========== listar ===========");
        repositorio.listar().forEach(System.out::println);

        System.out.println("=========== obtener por id ===========");
        System.out.println(repositorio.porId(2L));

        System.out.println("=========== Eliminar producto ===========");
        repositorio.eliminar(3L);
        System.out.println("Producto eliminado con éxito");
        repositorio.listar().forEach(System.out::println);
    }
}
