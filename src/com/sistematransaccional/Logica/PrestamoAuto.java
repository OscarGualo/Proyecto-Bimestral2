/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistematransaccional.Logica;

/**
 *
 * @author oscar
 */
public class PrestamoAuto extends PrestamoLogic {
    private double montoEntrada; 
    private static final double INTERES_NOMINAL = (11.03) / (12 * 100); // 11.03% nominal anual
    private static final double INTERES_ANUAL = (11.61) / (12 * 100); // 11.61% anual
    private double montoFinal;
    private final double montoOriginal;
    private double capitalFinal;
 
    // Constructor
    public PrestamoAuto(double monto, int meses, double montoEntrada) {
        super(monto, meses);
        this.montoEntrada = montoEntrada;
        this.montoFinal = monto - montoEntrada; // Calcular montoFinal
        this.montoOriginal = montoFinal;
    }
    public PrestamoAuto(double monto, int meses){
        super(monto, meses);
        this.montoFinal = monto;
        this.montoOriginal = monto;
       
    }

    public double getCapitalFinal() {
        return capitalFinal;
    }

    public void setCapitalFinal(double capitalFinal) {
        this.capitalFinal = capitalFinal;
    }
    
    // Métodos de acceso y modificación
    @Override
    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    public void setMontoEntrada(double montoEntrada) {
        this.montoEntrada = montoEntrada;
    }

    // Calcular cuota según el sistema francés
    @Override
    public double calcularCuotaFrances() {
        double cuotaFrances = (montoOriginal * INTERES_ANUAL) / (1 - Math.pow(1 + INTERES_ANUAL, -getMeses()));
        return cuotaFrances + calcularSeguroIncendio();
    }

    // Seguro incendio
    public double calcularSeguroIncendio() {
        return montoOriginal * 0.00026;
    }

    // Calcular interés mensual
    public double calcularInteres() {
        return getMontoFinal() * INTERES_NOMINAL;
    }

    // Saldo total pendiente
    public double saldoTotal() {
        double saldoTotal = montoFinal - calcularCuotaFrances();
        setMontoFinal(saldoTotal);
        return saldoTotal;
    }

    // Seguro de desgravamen
    public double calcularSeguroDesgravemen() {
        return montoFinal * 0.000572;
    }
    public double calcularCapital() {
       
        return calcularCuotaFrances() - calcularInteres() - calcularSeguroDesgravemen() - calcularSeguroIncendio();
    }
  public double calcularSumaSeguro(){
      return calcularSeguroDesgravemen() + calcularSeguroIncendio();
  }
 public double calcularSumaIntereses(){
     double suma = calcularInteres();
     double finalsum= 0;
     for(int i = 0 ;i< getMonto() ; i++){
         finalsum =+ suma;
     }
     return finalsum;
 }
      
}

