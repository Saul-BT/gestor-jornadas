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
        
        for(int i = 0, n = 0; i < numeroDeEquipos; i++, n++)
            losPartidos[n] = new Partido(listaEquipos.get(i), generaAletorio(4),
                                                            listaEquipos.get(++i), generaAletorio(4));
        
        return losPartidos;
    }
    
    private int generaAletorio(int maximo) {
        return (int) (Math.random() * maximo);
    }
    
    public Equipo[] getLosEquipos() {
        return losEquipos;
    }
}
