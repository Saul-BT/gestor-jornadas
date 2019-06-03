/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

import java.io.Serializable;
import java.text.Collator;

/**
 *
 * @author tarod
 */
public class Equipo implements Comparable<Equipo>, Serializable {
    private String nombre;
    private Integer partidosGanados;
    private Integer partidosEmpatados;
    private Integer partidosPerdidos;
    private Integer golesAFavor;
    private Integer golesEnContra;

    public Equipo() {}
    
    public Equipo(String nombre, Integer partidosGanados, Integer partidosEmpatados, Integer partidosPerdidos, Integer golesAFavor, Integer golesEnContra) {
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(Integer partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Integer getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(Integer partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public Integer getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(Integer partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public Integer getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(Integer golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public Integer getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(Integer golesEnContra) {
        this.golesEnContra = golesEnContra;
    }
    
    public Integer getPartidosJugados() {
        return partidosGanados + partidosEmpatados + partidosPerdidos;
    }
    
    public Integer getPuntosTotales() {
        return partidosEmpatados + partidosGanados * 3;
    }

    @Override
    public int compareTo(Equipo otroEquipo) {
        Collator ciCollator = Collator.getInstance();
        ciCollator.setStrength(Collator.SECONDARY);
        
        return ciCollator.compare(this.nombre, otroEquipo.nombre);
    }
}
