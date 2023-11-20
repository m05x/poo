package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;


public class Juez extends Persona {
    private final String licencia;

    public Juez(String nombre, String apellido, String email, String celular, Genero genero, String licencia) {
        super(nombre, apellido, email, celular, genero);
        this.licencia = licencia;
        ASSERTION.assertion(licencia != null && !licencia.isBlank(), "La licencia es requerida");

    }

    public String getLicencia() {
        return licencia;
    }


}
