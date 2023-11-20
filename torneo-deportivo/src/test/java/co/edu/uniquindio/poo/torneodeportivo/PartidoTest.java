package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PartidoTest {
     private static final Logger LOG = Logger.getLogger(PartidoTest.class.getName());

    @Test
        public void TorneoCompleto(){
            LOG.info("Inicio de prueba licencia no repetida...");
            
        }

    @Test
        public void TorneoCompleto2(){
            LOG.info("Inicio de prueba licencia no repetida...");
            
        }

    @Test
        public void TorneoCompleto3(){
            LOG.info("Inicio de prueba licencia no repetida...");
            
        }   

    @Test
    public void verificarEstadoPartidoEnJuego() {
        LOG.info("Inicio de prueba para verificar el estado del partido...");

        // Crear una lista de jueces para el partido
        Collection<Juez> jueces = new LinkedList<>();
        jueces.add(new Juez("Juan", "Perez", "juanperez1@gmail.com","3102938235",Genero.MASCULINO,"123456"));

        jueces.add(new Juez("Pedro", "Gomez","pedrogomez01@gmail.com","3201234567",Genero.MASCULINO,"123456"));

        // Crear un partido con estado EN_JUEGO
        Partido partido = new Partido(
            new Ubicacion("Estadio1", "Ciudad1"),
            LocalDateTime.now(),
            "EquipoLocal",
            "EquipoVisitante",
            jueces,
            3, // goles locales
            2, // goles visitantes
            EstadoPartido.EN_JUEGO,
            LocalDateTime.now().plusHours(2)
        );

        // Verificar que el estado del partido es EN_JUEGO
        assertEquals(EstadoPartido.EN_JUEGO, partido.getEstadoPartido(), "El estado del partido no es EN_JUEGO");
    }

    



}


