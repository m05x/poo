package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class JuezTest {

    private static final Logger LOG = Logger.getLogger(JuezTest.class.getName());

    @Test
    public void testDatosJuezCompletos(){
     LOG.info("Inicio de prueba Juez con datos completos...");
     Juez juez = new Juez ("Juan", "Perez", "juanperez1@gmail.com","3102938235",Genero.MASCULINO,"123456");

        assertEquals("Juan",juez.getNombre());
        assertEquals("Perez",juez.getApellido());
        assertEquals("juanperez1@gmail.com",juez.getEmail());
        assertEquals("3102938235",juez.getCelular());
        assertEquals(Genero.MASCULINO,juez.getGenero());
        assertEquals("123456",juez.getLicencia());
        LOG.info("Fin de prueba datos completos...");

    }
    
    @Test
    public void testLicenciaNoRepetida() {
        LOG.info("Inicio de prueba licencia no repetida...");
        var juez1 = new Juez("Juan", "Perez","juanperez01@gmail.com","3101234567",Genero.MASCULINO,"123456");
        var juez2 = new Juez("Pedro", "Gomez","pedrogomez01@gmail.com","3201234567",Genero.MASCULINO,"123456");

        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,Genero.MIXTO);
        torneo.registrarJuez(juez1);

        assertThrows(Throwable.class, () -> {
            torneo.registrarJuez(juez2);
            LOG.info("Fin de prueba registrarJugadoresRepetidosTorneo...");   // intenta registrar un juez con una licencia ya en uso
        });

    }
    
    @Test
    public void testLicenciaNula() {
        LOG.info("Inicio de prueba licencia no nula...");
        assertThrows(Throwable.class, () -> {
            new Juez("Juan", "Perez","juanperez01@gmail.com","3101234567",Genero.MASCULINO,null); // intenta crear un juez con licencia nula
        });

        LOG.info("Fin de prueba licencia no nula...");
    }
}