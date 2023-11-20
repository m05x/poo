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
         Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)0, 0, TipoTorneo.LOCAL, Genero.MIXTO);
    
         assertThrows(Throwable.class, () -> {
        torneo.setGenero(null); // intenta establecer el género a null
        });
         LOG.info("Fin de prueba de Genero de Jugador");
    }
    
    
    @Test
    public void testGeneroEnJugador() {
        LOG.info("Inicio de prueba de Genero de Jugador");
        Jugador jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",Genero.MASCULINO ,LocalDate.now().minusYears(15));
        assertThrows(Throwable.class, () -> {
        jugador.setGenero(Genero.FEMENINO); // intenta cambiar el género
    });
    LOG.info("Fin de prueba de Genero de Jugador");
    }




    @Test
    public void testGeneroEnPersona() {
        LOG.info("Inicio de prueba de Genero de Persona");
        Persona persona = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", Genero.MASCULINO);
        assertThrows(Throwable.class, () -> {
            persona.setGenero(null);
        });                                     //se intenta cambiar el genero a null
        LOG.info("Fin de prueba de Genero de Persona");
    }
    
}
