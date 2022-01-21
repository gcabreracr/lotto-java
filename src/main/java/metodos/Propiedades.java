/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Variables;

/**
 *
 * @author Usuario
 */
public class Propiedades extends Properties{

    File archivo;
    //Properties prop;

    public Propiedades() {
        this.archivo = new File("config.properties");
        //this.prop = new Properties();
    }

    public void crearArchivo() throws FileNotFoundException, IOException {

        try (OutputStream outputStream = new FileOutputStream(archivo)) {
            setProperty("db.usuario", "");
            store(outputStream, "Config");
        }

    }

    public void ipServidor() throws FileNotFoundException, IOException {

        try (InputStream inputStream = new FileInputStream(archivo)) {
            load(inputStream);
            Variables.URL_SERVER = getProperty("db.url.server");
            Variables.URL_API = getProperty("db.url.server") + "/api.php";
            Variables.IP_DB = "jdbc:mysql://" + getProperty("db.ip.server") + ":3306/";
            Variables.DB_NAME = getProperty("db.name");
        }

    }

    public String leerUsuario() throws FileNotFoundException, IOException {

        String usuario;
        try (InputStream inputStream = new FileInputStream(archivo)) {
            load(inputStream);
            usuario = getProperty("ultimo.usuario");
        }
        return usuario;
    }

    public void updateUsuario(String codUsuario) {

        try (InputStream inputStream = new FileInputStream(archivo)) {
            load(inputStream);

            try (OutputStream outputStream = new FileOutputStream(archivo)) {
                setProperty("ultimo.usuario", codUsuario);
                store(outputStream, "Config");
            }
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
