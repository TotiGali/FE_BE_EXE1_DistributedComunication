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
 * @author Toti
 */

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/productos")
public class ProductosController {
    
    // Inyecta una instancia de ProductosRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private ProductosRepository productosRepository;

    // Maneja las solicitudes GET a /productos para obtener una lista de todas los productos
    @GetMapping
    public List<Productos> getAllProductos() {
         // Llama al método findAll() del repositorio para obtener todos los productos
        return productosRepository.findAll();
    }

    // Maneja las solicitudes GET a /productos/{id} para obtener un producto específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable int id) {   // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un producto por su ID
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()) {  //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            // Si se encuentra el producto, devuelve una respuesta HTTP 200 (OK) con el producto encontrado
            return ResponseEntity.ok(producto.get());  
         //El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el producto, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    // Maneja las solicitudes POST a /productos para crear un nuevo producto
    @PostMapping
    public Productos createProducto(@RequestBody Productos producto) {
        // Guarda el nuevo producto en la base de datos y lo devuelve en la respuesta
        return productosRepository.save(producto);
    }

    // Maneja las solicitudes PUT a /productos/{id} para actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable int id, @RequestBody Productos productoDetails) {
        // Busca un producto por su ID
        Optional<Productos> producto = productosRepository.findById(id);
        // Si se encuentra el producto, actualiza sus detalles y lo guarda
        if (producto.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Productos productoToUpdate = producto.get();
            // Actualiza el nombre y el precio del producto con los detalles proporcionados en la solicitud
            productoToUpdate.setNombre(productoDetails. getNombre());
            productoToUpdate.setPrecio(productoDetails.getPrecio());
            // Guarda el producto actualizado y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(productosRepository.save(productoToUpdate));
        } else {
             // Si no se encuentra el producto, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    // Maneja las solicitudes DELETE a /productos/{id} para eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        // Maneja las solicitudes DELETE a /productos/{id} para eliminar un producto por su ID
        Optional<Productos> producto = productosRepository.findById(id);
        // Si se encuentra el producto, la elimina de la base de datos
        if (producto.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío
            productosRepository.delete(producto.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el producto, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}
