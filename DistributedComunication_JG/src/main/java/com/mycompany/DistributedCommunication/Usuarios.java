/*Autora: Antonella Alares*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

import java.sql.Timestamp;
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
public class Usuarios {
    @Id
    @Column(name = "id_usuario")
    private int id_usuario;
    
    public Usuarios (){
    
    }

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id_usuario;
    }
    
    
}
