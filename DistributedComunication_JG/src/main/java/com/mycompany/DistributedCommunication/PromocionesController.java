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
@RequestMapping("/promociones")
public class PromocionesController {
    
    // Inyecta una instancia de PedidoRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private PromocionesRepository promocionRepository;
    
    
    
    // Maneja las solicitudes GET a /pedidos para obtener una lista de todas los pedidos
    @GetMapping
    public List<Promociones> getAllPromociones() {
        // Llama al método findAll() del repositorio para obtener todas los pedidos
        return promocionRepository.findAll();
    }

    // Maneja las solicitudes GET a /pedidos/{id} para obtener un pedido específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Promociones> getPromocionById(@PathVariable int id) { // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un pedido por su ID
        Optional<Promociones> promocion = promocionRepository.findById(id);
        // Si se encuentra el pedido, devuelve una respuesta HTTP 200 (OK) con el pedido encontrado
        if (promocion.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(promocion.get());  
         // El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    

    // Maneja las solicitudes POST a /pedidos para crear un nuevo pedido
   /* @PostMapping
    public Personas createPersona(@RequestBody Personas persona) {
         // Guarda el nuevo pedido en la base de datos y lo devuelve en la respuesta
        return personaRepository.save(persona);
    }
*/
    // Maneja las solicitudes PUT a /pedidos/{id} para actualizar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Promociones> updatePromocion(@PathVariable int id, @RequestBody Promociones promocionDetails) {
        // Busca un pedido por su ID
        Optional<Promociones> promocion = promocionRepository.findById(id);
        // Si se encuentra el pedido, actualiza sus detalles y lo guarda
        if (promocion.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Promociones promocionToUpdate = promocion.get();
            // Actualiza el idTarjeta y el idUsuario del pedido con los detalles proporcionados en la solicitud
            promocionToUpdate.setTextoPromocion((promocionDetails.getTextoPromocion()));
            promocionToUpdate.setPrecioDescuento(promocionDetails.getPrecioDescuento());
            // Guarda el pedido actualizado y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(promocionRepository.save(promocionToUpdate));
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    

    // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable int id) {
         // Maneja las solicitudes DELETE a /pedidos/{id} para eliminar un pedido por su ID
        Optional<Promociones> promocion = promocionRepository.findById(id);
        // Si se encuentra el pedido, la elimina de la base de datos
        if (promocion.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            promocionRepository.delete(promocion.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el pedido, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    // Maneja las solicitudes POST a /pedidos para crear un nuevo pedido
    @PostMapping
    public Promociones createPromocion(@RequestBody Promociones promocion) {
         // Guarda el nuevo pedido en la base de datos y lo devuelve en la respuesta
        return promocionRepository.save(promocion);
    }
    
    
    
    
}
