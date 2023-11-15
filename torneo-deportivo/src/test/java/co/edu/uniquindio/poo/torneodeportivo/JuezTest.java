package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class JuezTest {

    private static final Logger LOG = Logger.getLogger(JuezTest.class.getName());

    @Test
    public void testLicenciaNoRepetida() {
        LOG.info("Inicio de prueba licencia no repetida...");
        Juez juez1 = new Juez("Juan", "Perez","juanperez01@gmail.com","3101234567",Genero.MASCULINO,"123456");
        Juez juez2 = new Juez("Pedro", "Gomez","pedrogomez01@gmail.com","3201234567",Genero.MASCULINO,"123456");

        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,Genero.MIXTO);
        torneo.registrarJuez(juez1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            torneo.registrarJuez(juez2); // intenta registrar un juez con una licencia ya en uso
        });

        String expectedMessage = "La licencia ya está en uso";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        LOG.info("Fin de prueba licencia no repetida...");
    }
    
    @Test
    public void testLicenciaNoNula() {
        LOG.info("Inicio de prueba licencia no nula...");
        assertThrows(IllegalArgumentException.class, () -> {
            new Juez("Juan", "Perez","juanperez01@gmail.com","3101234567",Genero.MASCULINO,null); // intenta crear un juez con licencia nula
        });

        LOG.info("Fin de prueba licencia no nula...");
    }
    
}
    

