/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ws_soap_sri.modelo;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Rolando Cachipuendo
 */
@Entity(noClassnameStored = true, value = "contribuyentegenerico")
public class ContribuyenteGenerico {
    
    @Property("nombre")    
    private String nombre;
    @Property("apellido") 
    private String apellido;
    @Property("tipo")
    private String tipo;
    @Property("actividadEconomica")
    private String actividadEconomica;

    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    @Override
    public String toString() {
        return "ContribuyenteGenerico{" + "nombre=" + nombre + ", apellido=" + apellido + ", tipo=" + tipo + ", actividadEconomica=" + actividadEconomica + '}';
    }
    
    
    
}
