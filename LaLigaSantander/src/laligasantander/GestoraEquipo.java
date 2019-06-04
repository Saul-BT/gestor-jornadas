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
            Partido partidoActual = new Partido(listaEquipos.get(i), generaAletorio(4),
                    listaEquipos.get(++i), generaAletorio(4));
            losPartidos[n] = partidoActual;
            procesarPartido(partidoActual);
        }

        return losPartidos;
    }

    private void procesarPartido(Partido partidoActual) {
        Equipo equipoLocal = partidoActual.getEquipoLocal();
        Equipo equipoContrincante = partidoActual.getEquipoContrincante();
        int resultadoLocal = partidoActual.getResultadoLocal();
        int resultadoContrincante = partidoActual.getResultadoContrincante();
        boolean localGano = resultadoLocal > resultadoContrincante;
        boolean localPerdio = resultadoLocal < resultadoContrincante;

        equipoLocal.setGolesAFavor(equipoLocal.getGolesAFavor() + resultadoLocal);
        equipoLocal.setGolesEnContra(equipoLocal.getGolesEnContra() + resultadoContrincante);
        equipoContrincante.setGolesAFavor(equipoContrincante.getGolesAFavor() + resultadoLocal);
        equipoContrincante.setGolesEnContra(equipoContrincante.getGolesEnContra() + resultadoContrincante);

        if (localGano) {
            equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados() + 1);
            equipoContrincante.setPartidosPerdidos(equipoLocal.getPartidosPerdidos() + 1);
        } else if (localPerdio) {
            equipoContrincante.setPartidosGanados(equipoContrincante.getPartidosGanados() + 1);
            equipoLocal.setPartidosPerdidos(equipoLocal.getPartidosPerdidos() + 1);
        } else { // Si han empatado
            equipoLocal.setPartidosEmpatados(equipoLocal.getPartidosEmpatados()+ 1);
            equipoContrincante.setPartidosEmpatados(equipoContrincante.getPartidosEmpatados()+ 1);
        }
    }

    private int generaAletorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public Equipo[] getLosEquipos() {
        return losEquipos;
    }
}
