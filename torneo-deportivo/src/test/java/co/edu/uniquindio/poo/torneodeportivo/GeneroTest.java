package co.edu.uniquindio.poo.torneodeportivo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class GeneroTest {
    private static final Logger LOG = Logger.getLogger(GeneroTest.class.getName());
    @Test
    
    public void testGeneroMasculino() {
        LOG.info("Inicio de prueba de GeneroMasculino");
        assertEquals(Genero.MASCULINO, Genero.valueOf("MASCULINO"));
        LOG.info("Fin de prueba de GeneroMasculino");
    }

    @Test
    public void testGeneroFemenino() {
        LOG.info("Inicio de prueba de GeneroFemenino");
        assertEquals(Genero.FEMENIMO, Genero.valueOf("FEMENIMO"));
        LOG.info("Fin de prueba de GeneroFemenino");
    }

    @Test
    public void testGeneroMixto() {
        LOG.info("Inicio de prueba de GeneroMixto");
        assertEquals(Genero.MIXTO, Genero.valueOf("MIXTO"));
        LOG.info("Fin de prueba de GeneroMixto");
    }

    @Test
    public void testGeneroNoNulo() {
        LOG.info("Inicio de prueba de GeneroNoNulo");
        Exception exception = assertThrows(NullPointerException.class, () -> {
             Genero.valueOf(null);
        });

        String expectedMessage = "Genero no puede ser nulo";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        LOG.info("Fin de prueba de GeneroNoNulo");
    }
    
    @Test
public void testGeneroEnTorneo() {
    LOG.info("Inicio de pureba de Genero de Torneo");
    Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 1), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,Genero.MIXTO);
    assertThrows(IllegalArgumentException.class, () -> {
        torneo.setGenero(Genero.MASCULINO); // intenta cambiar el género
    });
    LOG.info("Fin de prueba de Genero de Torneo");
}

@Test
public void testGeneroEnJugador() {
    LOG.info("Inicio de prueba de Genero de Jugador");
    Jugador jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",Genero.MASCULINO ,LocalDate.now().minusYears(15));
    assertThrows(IllegalArgumentException.class, () -> {
        jugador.setGenero(Genero.FEMENIMO); // intenta cambiar el género
    });
    LOG.info("Fin de prueba de Genero de Jugador");
}



    @Test
    public void testGeneroEnPersona() {
        LOG.info("Inicio de prueba de Genero de Persona");
        Persona persona = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", Genero.MASCULINO);
        assertThrows(IllegalArgumentException.class, () -> {
            persona.setGenero(null);
        });
        LOG.info("Fin de prueba de Genero de Persona");
    }

    public class PersonaTest {
    
        @Test
        public void testUnSoloGeneroPorPersona() {
            LOG.info("Inicio de prueba que solo permite un GeneroPorPersona");
            Persona persona = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300", Genero.MASCULINO);
            persona.setGenero(Genero.MASCULINO);
            
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                persona.setGenero(Genero.FEMENIMO);
            });
    
            String expectedMessage = "La persona ya tiene un género asignado";
            String actualMessage = exception.getMessage();
    
            assertTrue(actualMessage.contains(expectedMessage));
            LOG.info("Fin de prueba que solo permite un GeneroPorPersona");
        }

    }

    
}
