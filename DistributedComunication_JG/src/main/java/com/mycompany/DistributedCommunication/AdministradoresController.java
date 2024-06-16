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
 * @author Jordi
 */

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/administradores")
public class AdministradoresController {
    
    // Inyecta una instancia de PedidoRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private AdministradoresRepository administradorRepository;
    
    
    // Maneja las solicitudes GET a /pedidos para obtener una lista de todas los pedidos
    @GetMapping
    public List<Administradores> getAllAdministradores() {
        // Llama al método findAll() del repositorio para obtener todas los pedidos
        return administradorRepository.findAll();
    }

    // Maneja las solicitudes GET a /administradores/{id} para obtener un admin  por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Administradores> getAdministradorById(@PathVariable int id) { 
        // Busca un admin por su ID
        Optional<Administradores> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(administrador.get());  
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       

    // Maneja las solicitudes POST a /pedidos para crear un nuevo pedido
    @PostMapping
    public Administradores createAdministrador(@RequestBody Administradores administrador) {
         // Guarda el nuevo pedido en la base de datos y lo devuelve en la respuesta
        return administradorRepository.save(administrador);
    }

    // Maneja las solicitudes PUT a /pedidos/{id} para actualizar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Administradores> updateAdministrador(@PathVariable int id, @RequestBody Administradores administradorDetails) {
        // Busca un pedido por su ID
        Optional<Administradores> administrador = administradorRepository.findById(id);
        // Si se encuentra el pedido, actualiza sus detalles y lo guarda
        if (administrador.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Administradores administradorToUpdate = administrador.get();
            // Actualiza el idTarjeta y el idUsuario del pedido con los detalles proporcionados en la solicitud
            administradorToUpdate.setId(administradorDetails. getId());
            // Guarda el pedido actualizado y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(administradorRepository.save(administradorToUpdate));
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    

    // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable int id) {
         // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
        Optional<Administradores> administrador = administradorRepository.findById(id);
        // Si se encuentra el pedido, la elimina de la base de datos
        if (administrador.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            administradorRepository.delete(administrador.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}
