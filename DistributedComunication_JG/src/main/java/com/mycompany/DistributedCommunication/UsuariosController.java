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
@RequestMapping("/usuarios")
public class UsuariosController {
    
    // Inyecta una instancia de ProductosRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    // Maneja las solicitudes GET a /productos para obtener una lista de todas los productos
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
         // Llama al método findAll() del repositorio para obtener todos los productos
        return usuariosRepository.findAll();
    }

    // Maneja las solicitudes GET a /productos/{id} para obtener un producto específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable int id) {   // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un producto por su ID
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {  //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            // Si se encuentra el producto, devuelve una respuesta HTTP 200 (OK) con el producto encontrado
            return ResponseEntity.ok(usuario.get());  
         //El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el producto, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    // Maneja las solicitudes POST a /productos para crear un nuevo producto
    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        // Guarda el nuevo usuario en la base de datos y lo devuelve en la respuesta
        return usuariosRepository.save(usuario);
    }

    // Maneja las solicitudes PUT a /usuarios/{id} para actualizar un usuario existente
    /*@PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateProducto(@PathVariable int id, @RequestBody Usuarios usuarioDetails) {
        // Busca un producto por su ID
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        // Si se encuentra el producto, actualiza sus detalles y lo guarda
        if (usuario.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Usuarios usuariooToUpdate = usuario.get();
            // Actualiza el nombre y el precio del producto con los detalles proporcionados en la solicitud
            usuarioToUpdate.setNombre(usuarioDetails. getNombre());
            usuarioToUpdate.setPrecio(usuarioDetails.getPrecio());
            // Guarda el producto actualizado y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(usuariosRepository.save(usuarioToUpdate));
        } else {
             // Si no se encuentra el producto, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }*/

    // Maneja las solicitudes DELETE a /usuarios/{id} para eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        // Maneja las solicitudes DELETE a /productos/{id} para eliminar un producto por su ID
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        // Si se encuentra el usuario, la elimina de la base de datos
        if (usuario.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío
            usuariosRepository.delete(usuario.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el usuario, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}
