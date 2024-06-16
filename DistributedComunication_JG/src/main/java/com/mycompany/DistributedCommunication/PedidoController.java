/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

// Importa las anotaciones y clases necesarias de Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jordi
 */

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController

// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/pedido")
public class PedidoController {
    
    // Inyecta una instancia de PedidoRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProductoPromocionPedidoRepository productoPromocionPedidoRepository;
    
    // Maneja las solicitudes GET a /pedidos para obtener una lista de todas los pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        // Llama al método findAll() del repositorio para obtener todas las personas
        return pedidoRepository.findAll();
    }
    
    // Maneja las solicitudes GET a /pedidos/{id} para obtener un pedido específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) { 
        // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un pedido por su ID
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        // Si se encuentra el pedido, devuelve una respuesta HTTP 200 (OK) con el pedido encontrado
        if (pedido.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(pedido.get());  
        // El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) 
        //y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
        
    @GetMapping("idUsuario/{idUsuario}")
    public ResponseEntity<List<Pedido>> getPedidoByIdUsuario(@PathVariable int idUsuario){
        List<Pedido> pedido = pedidoRepository.findByIdUsuario(idUsuario);
        
        if(pedido.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pedido);
        }
    }
    
    @GetMapping("cantidad/{id_pedido}")
    public ResponseEntity<Integer> calcularCantidadPedido(@PathVariable int id_pedido){
        Integer cantidad = productoPromocionPedidoRepository.calcularCantidadPedido(id_pedido);
        
        if(cantidad != null){
            return ResponseEntity.ok(cantidad);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    // Maneja las solicitudes POST a /pedidos para crear un nuevo pedido
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
         // Guarda el nuevo pedido en la base de datos y lo devuelve en la respuesta
        return pedidoRepository.save(pedido);
    }

    // Maneja las solicitudes PUT a /pedidos/{id} para actualizar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido pedidoDetails) {
        Pedido pedidoToUpdate = pedidoRepository.findById(id).orElse(null);
        if (pedidoToUpdate != null) {
            pedidoToUpdate.setIdPedido(pedidoDetails.getIdPedido());
            pedidoToUpdate.setCantidad_pedido(pedidoDetails.getCantidad_pedido());
            return ResponseEntity.ok(pedidoRepository.save(pedidoToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //solicitut PUT per actualitzar la quantitat del pedido
    @PutMapping("/actualizar-cantidad/{idPedido}")
    public ResponseEntity<Pedido> actualizarCantidadPedido(@PathVariable int idPedido) {
        Integer nuevaCantidad = productoPromocionPedidoRepository.calcularCantidadPedido(idPedido);
        if (nuevaCantidad != null) {
            Pedido pedidoToUpdate = pedidoRepository.findById(idPedido).orElse(null);
            if (pedidoToUpdate != null) {
                pedidoToUpdate.setCantidad_pedido(nuevaCantidad);
                return ResponseEntity.ok(pedidoRepository.save(pedidoToUpdate));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id) {
         // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        // Si se encuentra el pedido, la elimina de la base de datos
        if (pedido.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            pedidoRepository.delete(pedido.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    //solicitut PUT per actualitzar el preu del pedido
    @PutMapping("/actualizar-precio/{id_pedido}")
    public ResponseEntity<Pedido> calcularPrecioPedido(@PathVariable int id_pedido, @RequestBody Pedido pedidoDetails){

        Double precio = pedidoRepository.calcularPrecioPedido(id_pedido);
         if (precio != null) {
            Pedido pedidoToUpdate = pedidoRepository.findById(id_pedido).orElse(null);
            if (pedidoToUpdate != null) {
                pedidoToUpdate.setPrecioTotalPedido(precio);
                return ResponseEntity.ok(pedidoRepository.save(pedidoToUpdate));
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
 