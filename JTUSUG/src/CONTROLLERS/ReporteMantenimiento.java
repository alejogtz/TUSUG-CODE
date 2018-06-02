/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import GUI.Fachada;
import GUI.GUIReporteManten;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Alekhius
 */
public class ReporteMantenimiento {
    Connection conn;
    GUIReporteManten gui;
    private String      solicitante, responsable, solicitud, areaTrabajo, prioridad,
                        tipoMantenimiento, direccion, telefono, email;
    private String      codAutobus, marca, matricula, condiciones, descripcion,
                        plazoEntrega;
    
    public ReporteMantenimiento(GUIReporteManten interfaz){
        this.gui = interfaz;
        conn     = Conexion.getConexion();
    }
 
    public void generarReporte() {
        // Validacion
        if (!Fachada.isSomeEmpty(gui.txt_responsable, gui.txt_solicitante, gui.txt_areaTrabajo,
                            gui.txt_prioridad, gui.txt_tipoManten, gui.txt_direccion, gui.txt_telefono, 
                            gui.txt_email, gui.txt_descripGenerica,
                            gui.txt_marca, gui.txt_matricula, gui.txt_condiTecn)){
        // Generar documento PDF
        
        // Guardar direccion del documento
        
        }
        
    }

    public void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
