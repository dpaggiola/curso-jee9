package apps.desarrollo1.modelo;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;

    public Producto() {
    }

    public Producto(Long id, Date fechaRegistro, String nombre, Integer precio) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
