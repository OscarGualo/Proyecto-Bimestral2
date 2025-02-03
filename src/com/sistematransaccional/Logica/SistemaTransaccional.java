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
    PrestamoDos p2 = new PrestamoDos(5000, 36);
          for(int i = 0 ;i< 36; i++){
              System.out.println(i+1);
                System.out.println(p2.calcularSaldoFinal());
               System.out.println(p2.calcularCapitalFija());
               System.out.println(p2.capitalFija());
         System.out.println(p2.calcularInteres());
         System.out.println(p2.calcularCuota());
              System.out.println(p2.calcularSeguroDesgravamen());
              System.out.println(p2.calcularSeguroIncendios());
       
        
          }
        
    }
    
}
