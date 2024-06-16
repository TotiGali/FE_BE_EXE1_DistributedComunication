/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

/**
 *
 * @author jordi
 */
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;

@Entity
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_persona")
    private int id_persona;
    @Column(name = "nombre_persona")
    private String nombre;
    @Column(name = "apellido_persona")
    private String apellido;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "correo_persona")
    private String correo;
    @Column(name = "telefono_persona")
    private int telefono;
    @Column(name = "contrasena_persona")
    private String contrasena;
    @Column(name = "fechaNacimiento_persona")
    private Date fechaNacimiento;
    @Column(name = "direccion_persona")
    private String direccion;
    @Column(name = "fechaCreacion_persona")
    private Timestamp fechaCreacion;
    
    
    public Personas (){
        
    }
    
    //GETTERS
    
    public int getId_persona() {
        return id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }
    
    //SETTERS
    
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
   
    
    
    
    
     /*MÉTODOS DAO PARA ADAPTAR*/
   /* public String getCorreo(){
        return PersonaDAO.getPersonaCorreo(this.nombre, this.apellido);
    }
    
     public String getTipo(){
        return PersonaDAO.getTipo(this.id_persona);
    }
     
     
   
   public void setCorreo(String nuevoCorreo){
   PersonaDAO.updatePersonaCorreo(this.nombre,this.apellido, nuevoCorreo);
   }
   
   
   public static void CrearAsignarPersona(int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion){
   PersonaDAO.insertPersona(id_persona, nombre, apellido, tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }
   
   public static void insertPersonaEnTablaCorrecta(int id_persona){
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }*/

    

    
    
}