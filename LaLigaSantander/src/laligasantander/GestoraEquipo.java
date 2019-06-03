/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tarod
 */
public class GestoraEquipo extends ArrayList<Equipo> {
    private final Equipo[] losEquipos;

    public GestoraEquipo(Equipo[] losEquipos) {
        this.losEquipos = losEquipos;
    }
    
    public Partido[] generarPartidos() {
        Collections.shuffle(this);
        int numeroDeEquipos = this.size();
        Partido[] losPartidos = new Partido[numeroDeEquipos / 2];
        
        for(int i = 0, n = 0; i < numeroDeEquipos; i++, n++)
            losPartidos[n] = new Partido(this.get(i), generaAletorio(4),
                                                            this.get(++i), generaAletorio(4));
        
        return losPartidos;
    }
    
    private int generaAletorio(int maximo) {
        return (int) (Math.random() * maximo);
    }
}
