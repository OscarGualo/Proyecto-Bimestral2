/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistematransaccional.Logica;

/**
 *
 * @author oscar
 */
public class SistemaTransaccional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       Prestamo p1 = new PrestamoAutomotriz(10000, 36, 5000);
        System.out.println(p1.calcularCuotaFrances());
    }
    
}
