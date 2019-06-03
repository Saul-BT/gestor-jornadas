/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tarod
 */
public class ModeloTablaJornada extends DefaultTableModel {
    Partido[] losPartidos;

    public ModeloTablaJornada(Partido[] losPartidos) {
        this.losPartidos = losPartidos;
    }

    @Override
    public int getRowCount() {
        return losPartidos != null ? losPartidos.length : 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int numeroColumna) {
        String[] titulos = {
            "EQUIPO 1",
            "GOLES",
            "EQUIPO 2",
            "GOLES"
        };
        
        return titulos[numeroColumna];
    }

    @Override
    public Class<?> getColumnClass(int numeroColumna) {
        Class[] clases = {
            String.class,
            Integer.class,
            String.class,
            Integer.class
        };
        
        return clases[numeroColumna];
    }

    @Override
    public boolean isCellEditable(int numeroColumna, int numeroFila) {
        return false;
    }

    @Override
    public Object getValueAt(int numeroColumna, int numeroFila) {
        Object[] datos = {
            losPartidos[numeroFila].getEquipoLocal(),
            losPartidos[numeroFila].getResultadoLocal(),
            losPartidos[numeroFila].getEquipoContrincante(),
            losPartidos[numeroFila].getResultadoContrincante()
        };
        
        return datos[numeroColumna];
    }
}
