/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPersonaTipo;
/**
 *
 * @author visitante
 */
public class clsPersonaTipo {
    private static int IdPersona;
    private static String NombrePersona;
    private static String EstatusPersona;

    public clsPersonaTipo() {
    }

    public static int getIdPersona() {
        return IdPersona;
    }

    public static void setIdPersona(int IdPersona) {
        clsPersonaTipo.IdPersona = IdPersona;
    }

    public static String getNombrePersona() {
        return NombrePersona;
    }

    public static void setNombrePersona(String NombrePersona) {
        clsPersonaTipo.NombrePersona = NombrePersona;
    }

    public static String getEstatusPersona() {
        return EstatusPersona;
    }

    public static void setEstatusPersona(String EstatusPersona) {
        clsPersonaTipo.EstatusPersona = EstatusPersona;
    }
    
 @Override
    public String toString() {
        return "clsPersonaTipo{" + "IdPersona=" + IdPersona + ", NombrePersona=" + NombrePersona + ", EstatusPersona=" + EstatusPersona + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPersonaTipo getBuscarInformacionPersonaPorNombre(clsPersonaTipo persona)
    {
        daoPersonaTipo daopersona= new daoPersonaTipo ();
        return daopersona.consultaPersonaPorNombre(persona);
    }
    public clsPersonaTipo getBuscarInformacionPersonaPorId(clsPersonaTipo persona)
    {
        daoPersonaTipo daopersona = new daoPersonaTipo();
        return daopersona.consultaPersonaPorId(persona);
    }    
    public List<clsPersonaTipo> getListadoPersona()
    {
        daoPersonaTipo daopersona = new daoPersonaTipo();
        List<clsPersonaTipo> listadoUsuarios = daopersona.consultaPersona();
        return listadoUsuarios;
    }
    public int setBorrarPersona(clsPersonaTipo persona)
    {
        daoPersonaTipo daopersona = new daoPersonaTipo();
        return daopersona.borrarPersona(persona);
    }          
    public int setIngresarPersona(clsPersonaTipo persona)
    {
        daoPersonaTipo daopersona = new daoPersonaTipo();
        return daopersona.ingresaPersona(persona);
    }              
    public int setModificarPersona(clsPersonaTipo persona)
    {
        daoPersonaTipo daopersona = new daoPersonaTipo();
        return daopersona.actualizaPersona(persona);
    }              
}
