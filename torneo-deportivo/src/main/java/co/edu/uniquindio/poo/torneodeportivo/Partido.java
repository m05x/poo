package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDateTime;
import java.util.Collection;

public class Partido {

    private final LocalDateTime FechaEncuentro;
    private final String EquipoLocal;
    private final String EquipoVisitante;
    private final Collection<Juez> jueces;
    private final int golesLocal;
    private final int golesVisitante;
    private EstadoPartido estadoPartido;
    private final Ubicacion ubicacion;
    private LocalDateTime FechaFinalizacion;
    public Partido(Ubicacion ubicacion, LocalDateTime FechaEncuentro, String EquipoLocal, String EquipoVisitante,
            Collection<Juez> jueces, int golesLocal, int golesVisitante, EstadoPartido estadoPartido, LocalDateTime FechaFinalizacion) {

        ASSERTION.assertion(FechaEncuentro != null, "La fecha de encuentro es requerida");
        ASSERTION.assertion(EquipoLocal != null && !EquipoLocal.isBlank(), "El equipo local es requerido");
        ASSERTION.assertion(EquipoVisitante != null && !EquipoVisitante.isBlank(), "El equipo visitante es requerido");
        ASSERTION.assertion(jueces != null && !jueces.isEmpty(), "El juez es requerido");
        ASSERTION.assertion(golesLocal >= 0, "El número de goles local no puede ser negativo");
        ASSERTION.assertion(golesVisitante >= 0, "El número de goles visitante no puede ser negativo");
        ASSERTION.assertion(estadoPartido != null, "El estado del partido es requerido");
        ASSERTION.assertion(FechaFinalizacion != null, "La fecha de finalizacion es requerida");



        this.ubicacion=ubicacion;
        this.FechaEncuentro = FechaEncuentro;
        this.EquipoLocal = EquipoLocal;
        this.EquipoVisitante = EquipoVisitante;
        this.jueces = jueces;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.estadoPartido = estadoPartido;
        this.FechaFinalizacion=FechaFinalizacion;

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

    public String iniciarPartido() {
        String mensaje = "";
        if (LocalDateTime.now().isAfter(FechaEncuentro)) {
            this.estadoPartido = EstadoPartido.EN_JUEGO;
            mensaje = "El partido está en juego";
        } else {
            mensaje = "No es oportuno";
        }
        return mensaje;
    }

    public String finalizarPartido() {
        String mensaje="";
        if (LocalDateTime.now().isAfter(FechaEncuentro)) {
            this.estadoPartido = EstadoPartido.FINALIZADO;
            mensaje= "El partido ha finalizado";
        } else {
            mensaje="No es oportuno";
        }
        return mensaje;
    }

    public void iniciarPartido(LocalDateTime fechaHoraPartido){

       
        if(LocalDateTime.now().isAfter(fechaHoraPartido)){
            this.estadoPartido = EstadoPartido.EN_JUEGO;
              
        }
        else {
            estadoPartido = EstadoPartido.PENDIENTE;
        }
        
    }

    public void partidoFinalizado(int golesLocal, int golesVisitante) {
        if (estadoPartido == EstadoPartido.EN_JUEGO) {
            if (golesLocal > golesVisitante) {

                estadoPartido = EstadoPartido.FINALIZADO;
            }
        } else {
            estadoPartido = EstadoPartido.PENDIENTE;
        }
    }

    public void partidoAplazado() {
        if (estadoPartido == EstadoPartido.EN_JUEGO) {
            estadoPartido = EstadoPartido.APLAZADO;
        } else {
            estadoPartido = EstadoPartido.PENDIENTE;
        }
    }

   

}

       

    


