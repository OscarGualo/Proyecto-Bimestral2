
import com.sistematransaccional.Logica.PrestamoUno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class Principal {
     public static void main(String[] args) {
     
     PrestamoUno n1 = new PrestamoUno(5000, 36);
     for(int i = 0 ; i< 36; i++){
         System.out.println(i+1);
         System.out.println(n1.calcularAmortizacionPeriodo());
         System.out.println(n1.calcularInteres());
         System.out.println(n1.calcularNuevoSaldo());
         System.out.println(n1.calcularSeguroDesgravamen());
         System.out.println(n1.calcularSeguroIncendios());
         System.out.println(n1.calcularCuotaFija());
     }   
     
       
         
        
     }
     
}
