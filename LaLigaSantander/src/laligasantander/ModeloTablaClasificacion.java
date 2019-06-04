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
public class ModeloTablaClasificacion extends DefaultTableModel {
    private final Equipo[] losEquipos;

    public ModeloTablaClasificacion(Equipo[] losEquipos) {
        this.losEquipos = losEquipos;
    }

    @Override
    public int getRowCount() {
        return losEquipos != null ? losEquipos.length : 0;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int numeroColumna) {
        String[] titulos = {
            "NUMERO", "NOMBRE",
            "PJ", "PG", "PE", "PP",
            "GF", "GC", "PUNTOS"
        };
        
        return titulos[numeroColumna];
    }

    @Override
    public Class<?> getColumnClass(int numeroColumna) {
        Class[] clases = {
            Integer.class,
            String.class,
            Integer.class,
            Integer.class,
            Integer.class,
            Integer.class,
            Integer.class,
            Integer.class,
            Integer.class
        };
        
        return clases[numeroColumna];
    }

    @Override
    public boolean isCellEditable(int numeroFila, int numeroColumna) {
        return false;
    }

    @Override
    public Object getValueAt(int numeroFila, int numeroColumna) {
        Object[] datos = {
            numeroFila + 1,
            losEquipos[numeroFila].getNombre(),
            losEquipos[numeroFila].getPartidosJugados(),
            losEquipos[numeroFila].getPartidosGanados(),
            losEquipos[numeroFila].getPartidosEmpatados(),
            losEquipos[numeroFila].getPartidosPerdidos(),
            losEquipos[numeroFila].getGolesAFavor(),
            losEquipos[numeroFila].getGolesEnContra(),
            losEquipos[numeroFila].getPuntosTotales()
        };
        
        return datos[numeroColumna];
    }
}
