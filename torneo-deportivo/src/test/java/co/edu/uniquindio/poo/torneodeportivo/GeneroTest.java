package co.edu.uniquindio.poo.torneodeportivo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class GeneroTest {
    private static final Logger LOG = Logger.getLogger(GeneroTest.class.getName());

    @Test
    public void testGeneroNoNuloEnTorneo() {
         LOG.info("Inicio de prueba que no permite un Genero nulo en Torneo");
        assertThrows(Throwable.class,()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,null));
        LOG.info("Fin de prueba que no permite un Genero nulo en Torneo");
    }
    
    @Test
    public void testGeneroNoNuloEnPersona() {
        LOG.info("Inicio de prueba que no permite un Genero nulo en Persona");
        assertThrows(Throwable.class,()-> new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", null));
        LOG.info("Fin de prueba que no permite un Genero nulo en Persona");
    }

    @Test
    public void testGeneroNoNuloEnJugador() {
        LOG.info("Inicio de prueba que no permite un Genero nulo en Jugador");
        assertThrows(Throwable.class,()-> new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",null,LocalDate.now().minusYears(15)));
        LOG.info("Fin de prueba que no permite un Genero nulo en Jugador");
    }

    @Test
    public void testUnSoloGeneroPorJugador(){
        LOG.info("Inicio de prueba que solo permite un Genero por Jugador");
        Jugador jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",Genero.MASCULINO,LocalDate.now().minusYears(15));
        assertThrows(Throwable.class,()-> jugador.setGenero(Genero.FEMENINO));
        LOG.info("Fin de prueba que solo permite un Genero por Jugador");
    }
}




           

    

    

