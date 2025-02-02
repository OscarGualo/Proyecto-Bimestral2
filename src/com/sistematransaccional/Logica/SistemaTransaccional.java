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
    
        PrestamoAuto p1 = new PrestamoAuto(10000, 36, 5000);
        double capitalFinal ;
        
         for(int i = 0  ;i< 36 ; i++){
              System.out.println(p1.calcularCapital());
             
              System.out.println(p1.calcularInteres());
              
             System.out.println(p1.calcularSumaSeguro());
             System.out.println(p1.calcularCuotaFrances());
             System.out.println(p1.getMontoFinal());
             System.out.println(p1.calcularSumaIntereses());
         }
            
            
             
      
        
    }
    
}
