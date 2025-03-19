package apps.desarrollo1;

import apps.desarrollo1.modelo.Producto;
import apps.desarrollo1.repositorio.ProductoRepositorioImpl;
import apps.desarrollo1.repositorio.Repositorio;
import apps.desarrollo1.util.ConexionBaseDatos;

import javax.xml.transform.Result;
import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porId(2L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
