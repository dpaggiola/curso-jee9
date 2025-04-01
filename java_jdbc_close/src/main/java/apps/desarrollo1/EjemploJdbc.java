package apps.desarrollo1;

import apps.desarrollo1.modelo.Categoria;
import apps.desarrollo1.modelo.Producto;
import apps.desarrollo1.repositorio.ProductoRepositorioImpl;
import apps.desarrollo1.repositorio.Repositorio;
import apps.desarrollo1.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));

            System.out.println("=========== insertar nuevo producto ===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecánico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);

            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);
    }
}
