/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laligasantander;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarod
 */
public class GestoraAlmacenamiento {

    private static final String NOMBRE = "data.xml";

    public static Equipo[] leerEquipos() {
        Equipo[] losEquipos = null;

        try (XMLDecoder lector = new XMLDecoder(new FileInputStream(NOMBRE))) {
            losEquipos = (Equipo[]) lector.readObject();

            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return losEquipos;
    }

    public static boolean escribirEquipos(Equipo[] losEquipos) {
        boolean escritoCorrectamente = false;

        try (XMLEncoder escritor = new XMLEncoder(new FileOutputStream(NOMBRE))) {
            escritor.writeObject(losEquipos);
            escritoCorrectamente = true;

            escritor.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return escritoCorrectamente;
    }
}
