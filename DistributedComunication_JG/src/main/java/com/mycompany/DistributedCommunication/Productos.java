/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;
import javax.persistence.*;

/**
 *
 * @author Toti
 */

@Entity
public class Productos {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) 
  @Column(name = "id_producto")
  private int id_producto;  
  @Column(name = "nombre_producto")
  private String nombre;
  @Column(name = "categoria_producto")
  private String categoria;
  @Column(name = "precio_producto")
  private double precio;
  @Column(name = "cantidad_producto")
  private int cantidad;
  @Column(name = "fechaCreacion_producto")
  private Timestamp fechaCreacion;
  @Column(name = "fechaCaducidad_producto")
  private Date fechaCaducidad;
    
    public Productos (){
    }

    //GETTERS
    public int getId_producto() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    //SETTERS

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
    
    /*MÉTODOS DAO PARA ADAPTAR*/
    
    /*public double getPrecio(){
        return ProductoDAO.getProductoPrecio(this.nombre);
   }
   
   public void setPrecio(double nuevoPrecio){
        ProductoDAO.updateProductoPrecio(this.nombre,this.categoria, nuevoPrecio);
   }*/

    
  
    
}
