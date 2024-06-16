/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Jordi
 */


@Entity
@Table(name = "producto_promocion_pedido")
@IdClass(ProductoPromocionPedidoId.class)
public class ProductoPromocionPedido  implements Serializable {

 
    @Id
    @Column(name = "id_producto")
    private int idProducto;

    @Id
    @Column(name = "id_promocion")
    private int idPromocion;

    @Id
    @Column(name = "id_pedido")
    private int idPedido;

    private int cantidad;

    // Constructor por defecto
    public ProductoPromocionPedido() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}