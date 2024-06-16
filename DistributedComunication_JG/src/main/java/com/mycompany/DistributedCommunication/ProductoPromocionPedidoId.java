/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jordi
 */

public class ProductoPromocionPedidoId implements Serializable {

    private int idProducto;
    private int idPromocion;
    private int idPedido;

    // Constructor por defecto
    public ProductoPromocionPedidoId() {
    }

    // Constructor con parámetros
    public ProductoPromocionPedidoId(int idProducto, int idPromocion, int idPedido) {
        this.idProducto = idProducto;
        this.idPromocion = idPromocion;
        this.idPedido = idPedido;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoPromocionPedidoId that = (ProductoPromocionPedidoId) o;
        return idProducto == that.idProducto && idPromocion == that.idPromocion && idPedido == that.idPedido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idPromocion, idPedido);
    }
}


