/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

/**
 *
 * @author jordi
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;


/**
 *
 * @author Administrador
 */

public interface PedidoRepository extends JpaRepository<Pedido, Integer>  { 
    List<Pedido> findByIdUsuario(Integer idUsuario);
    
   @Query(value = "SELECT sum(t1.precio_total) as precio_final, t1.id_pedido from( SELECT ((ta.cantidad*tb.precio_producto)-(ta.cantidad*tb.precio_producto*tc.precioDescuento_promocion)) as precio_total, ta.id_pedido from producto_promocion_pedido ta inner join productos tb on ta.id_producto = tb.id_producto inner join promociones tc on ta.id_promocion = tc.id_promocion where id_pedido = :id_pedido) as t1 group by id_pedido",
             nativeQuery = true)
             Double calcularPrecioPedido(@Param("id_pedido") int id_pedido);
     }

