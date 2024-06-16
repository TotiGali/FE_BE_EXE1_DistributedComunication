/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;

/**
 *
 * @author anto_
 */


@Entity
public class Promociones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_promocion")
    private int idPromocion;
    @Column(name = "id_administrador")
    private int idAdministrador;
    @Column(name = "texto_promocion")
    private String textoPromocion;
    @Column(name = "precioDescuento_promocion")
    private double precioDescuento;
    @Column(name = "fechaInicio_promocion")
    private Date fechaInicio;
    @Column(name = "fechaFinal_promocion")
    private Date fechaFinal;
    
    public Promociones(){
   
    }
    
   //GETTERS
    public int getIdPromocion() {
        return idPromocion;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public String getTextoPromocion() {
        return textoPromocion;
    }

    public double getPrecioDescuento() {
        return precioDescuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }
    
    
    
    //SETTERS
    
    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void setTextoPromocion(String textoPromocion) {
        this.textoPromocion = textoPromocion;
    }

    public void setPrecioDescuento(double precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    
    
    
    //MÉTODOS PARA ADAPTAR de DAO
    
    /* public String getTextoPromocion(){
        return PromocionDAO.getPromocionTexto(this.fechaInicio, this.fechaFinal);
    }*/

    
    
}

