package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestorPartidos {
    Collection<Partido> partidos;
     
    public GestorPartidos() {
        this.partidos = new LinkedList<>();
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    public Collection<Partido> buscarPartidoEquipoPorNombre(String nombre) {
        Predicate<Partido> condicion = partido ->
                partido.getEquipoLocal().equals(nombre) ||
                partido.getEquipoVisitante().equals(nombre);

        return partidos.stream().filter(condicion).collect(Collectors.toList());
    }


    public Collection<Partido> obtenerpartidosPorJuez(String numeroLicencia) {
        Collection<Partido> enfrentamientosJuez = new LinkedList<>();
        for (Partido enfrentamiento : partidos) {
            for (Juez juez : enfrentamiento.getJueces()) {
                if (juez.getLicencia().equals(numeroLicencia)) {
                    enfrentamientosJuez.add(enfrentamiento);
                }
            }
        }
        return enfrentamientosJuez;
    }
}