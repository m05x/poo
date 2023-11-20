package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Ubicacion {
    private final String nombre;
    private final String ubicacion;

    public Ubicacion (String nombre, String ubicacion){
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "el nombre es requerido");
        ASSERTION.assertion(ubicacion != null && !ubicacion.isBlank(), "La ubicacion es requerida");
        this.nombre=nombre;
        this.ubicacion=ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
}
