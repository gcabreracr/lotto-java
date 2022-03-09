package modelo;

import forms.ConfiguraTkt;
import forms.ConsultaEstado;
import forms.ConsultaPremios;
import forms.LiqDiaria;
import forms.Login;
import forms.TktsEmitidos;
import forms.VentaTkts;

public class Variables {

    // IP
    public static String URL_SERVER = "";
    public static String URL_API = "";
    public static String IP_DB = "";
    public static String DB_NAME = "";

    // Variables estaticas para el control del usuario durante la ejecucion del programa
    public static int mCODUSU; // Codigo usuario
    public static String mIDUSU = null; // ID usuario
    public static String mNOMUSU; // Nombre usuario
    public static int mTIPOUSU; // Tipo usuario   
    public static int mAGEUSU; // Codigo agencia usuario
    public static String mNOMAGEUSU; // Nombre agencia usuario   
    public static String mDBUSUARIO; // Base datos usuario
    public static String TIT_TKT = ""; // Titulo tiquete
    public static String MSG_TKT = ""; // Mensaje de tiquete
    public static String NOM_IMP = "";

    // Variable para validacion de largos de campos JTextField
    // Control singleton de apertura de ventanas
    public static Login frmLogin = null;
    public static VentaTkts frmVtaTkts = null;
    public static LiqDiaria frmLiqDia = null;
    public static TktsEmitidos frmTktsEmi = null;
    public static ConsultaEstado frmConEstado = null;
    public static ConsultaPremios frmConPremios = null;
    public static ConfiguraTkt frmConTkt = null;
    
    
}
