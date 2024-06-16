/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DistributedCommunication;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

/**
 *
 * @author Jordi
 */
public interface AdministradoresRepository extends JpaRepository<Administradores, Integer> {

    public void save(int id);
    
}
