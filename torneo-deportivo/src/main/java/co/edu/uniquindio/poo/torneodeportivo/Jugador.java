/**
 * Clase que agrupa los datos de un Jugador
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.Period;

public class Jugador extends Persona {
    private final LocalDate fechaNacimiento;
    private Genero genero;

    public Jugador(String nombre, String apellido, String email, String celular,Genero genero, LocalDate fechaNacimiento) {
        super(nombre, apellido, email, celular, genero);
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }

    public void setGenero(Genero genero) {
    assert genero != null : "El género es requerido";
        this.genero = genero;
    }
    
    public Genero getGenero() {
         return this.genero;
    }
}
