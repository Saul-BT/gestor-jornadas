/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tarod
 */
public class GestoraEquipo {

    private final Equipo[] losEquipos;

    public GestoraEquipo(Equipo[] losEquipos) {
        this.losEquipos = losEquipos;
    }

    public Partido[] generarPartidos() {
        List<Equipo> listaEquipos = Arrays.asList(losEquipos);
        Collections.shuffle(listaEquipos);
        int numeroDeEquipos = losEquipos.length;
        Partido[] losPartidos = new Partido[numeroDeEquipos / 2];

        for (int i = 0, n = 0; i < numeroDeEquipos; i++, n++) {
            Equipo equipoActualLocal = listaEquipos.get(i);
            Equipo equipoActualContrincante = listaEquipos.get(++i);
            int resultadoLocal = generaAletorio(4), resultadoContrincante = generaAletorio(4);
            
            losPartidos[n] = new Partido(equipoActualLocal, resultadoLocal,
                    equipoActualContrincante, resultadoContrincante);
            
            actualizaEquipo(equipoActualLocal, resultadoLocal, resultadoContrincante);
            actualizaEquipo(equipoActualContrincante, resultadoLocal, resultadoContrincante);
        }

        return losPartidos;
    }

    private void actualizaEquipo(Equipo equipoActual, int golesAFavor, int golesEnContra) {
        boolean localGano = golesAFavor > golesEnContra;
        boolean localPerdio = golesAFavor < golesEnContra;

        equipoActual.setGolesAFavor(equipoActual.getGolesAFavor() + golesAFavor);
        equipoActual.setGolesEnContra(equipoActual.getGolesEnContra() + golesEnContra);

        if (localGano) {
            equipoActual.setPartidosGanados(equipoActual.getPartidosGanados() + 1);
        } else if (localPerdio) {
            equipoActual.setPartidosPerdidos(equipoActual.getPartidosPerdidos() + 1);
        } else { // Si han empatado
            equipoActual.setPartidosEmpatados(equipoActual.getPartidosEmpatados() + 1);
        }
    }

    private int generaAletorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public Equipo[] getLosEquipos() {
        return losEquipos;
    }
}
