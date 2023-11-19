package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDateTime;
import java.util.Collection;

public class Partidos {
    private final String LugarEncuentro;
    private final LocalDateTime FechaEncuentro;
    private final String EquipoLocal;
    private final String EquipoVisitante;
    private final Collection<Juez> jueces;
    private final int golesLocal;
    private final int golesVisitante;
    private final EstadoPartido estadoPartido;

    public Partidos(final String LugarEncuentro, final LocalDateTime FechaEncuentro, final String EquipoLocal, final String EquipoVisitante,
            final Collection<Juez> jueces, final int golesLocal, final int golesVisitante, final EstadoPartido estadoPartido) {

        ASSERTION.assertion(LugarEncuentro != null && !LugarEncuentro.isBlank(), "El lugar de encuentro es requerido");
        ASSERTION.assertion(FechaEncuentro != null, "La fecha de encuentro es requerida");
        ASSERTION.assertion(EquipoLocal != null && !EquipoLocal.isBlank(), "El equipo local es requerido");
        ASSERTION.assertion(EquipoVisitante != null && !EquipoVisitante.isBlank(), "El equipo visitante es requerido");
        ASSERTION.assertion(jueces != null && !jueces.isEmpty(), "El juez es requerido");
        ASSERTION.assertion(golesLocal >= 0, "El número de goles local no puede ser negativo");
        ASSERTION.assertion(golesVisitante >= 0, "El número de goles visitante no puede ser negativo");
        ASSERTION.assertion(estadoPartido != null, "El estado del partido es requerido");

        this.LugarEncuentro = LugarEncuentro;
        this.FechaEncuentro = FechaEncuentro;
        this.EquipoLocal = EquipoLocal;
        this.EquipoVisitante = EquipoVisitante;
        this.jueces = jueces;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.estadoPartido = estadoPartido;

    }

    public String getLugarEncuentro() {
        return LugarEncuentro;
    }

    public LocalDateTime getFechaEncuentro() {
        return FechaEncuentro;
    }

    public String getEquipoLocal() {
        return EquipoLocal;
    }

    public String getEquipoVisitante() {
        return EquipoVisitante;
    }

    public Collection<Juez> getJueces() {
        return jueces;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public EstadoPartido getEstadoPartido() {
        return estadoPartido;
    }
    
    
}
