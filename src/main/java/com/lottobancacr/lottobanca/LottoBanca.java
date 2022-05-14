/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottobancacr.lottobanca;

import forms.Splash;
import forms.Inicio;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import metodos.PoolConexion;
import metodos.Propiedades;
import modelo.Variables;

/**
 *
 * @author Gonzalo Cabrera
 */
public class LottoBanca {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, InterruptedException {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(LottoBanca.class.getName()).log(Level.SEVERE, null, ex);
        }

        Splash splash = new Splash();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        
        
        Propiedades prop = new Propiedades();

        try {
            prop.ipServidor();
            splash.lblMensaje.setText("Conectando con base de datos - IP: " + Variables.IP_DB + " - URL: " + Variables.URL_SERVER);

           try {
                Connection con = PoolConexion.getInstance().getConnection();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(splash, "Error de coneccion" + ex.toString());
                Logger.getLogger(LottoBanca.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            }

        } catch (IOException ex) {
            Logger.getLogger(LottoBanca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(splash, "Error al leer archivo de configuracion");
            //splash.dispose();
            System.exit(0);
        } finally {
            splash.dispose();
        }
       
        splash.setVisible(false);

        new Inicio();
    }

}
