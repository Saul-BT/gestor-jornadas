/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

/**
 *
 * @author tarod
 */
public class Partido {
    private final Equipo equipoLocal;
    private final Integer resultadoLocal;
    private final Equipo equipoContrincante;
    private final Integer resultadoContrincante;

    public Partido(Equipo equipoLocal, Integer resultadoLocal, Equipo equipoContrincante, Integer resultadoContrincante) {
        this.equipoLocal = equipoLocal;
        this.resultadoLocal = resultadoLocal;
        this.equipoContrincante = equipoContrincante;
        this.resultadoContrincante = resultadoContrincante;
    }
}
