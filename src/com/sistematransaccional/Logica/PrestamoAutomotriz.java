/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistematransaccional.Logica;

/**
 *
 * @author oscar
 */
public class PrestamoAutomotriz extends Prestamo implements Calculador{
    private double montoEntrada; 
    private static final double INTERES_NOMINAL = (11.03)/(12*100);
    private static final double INTERES_ANUAL = (11.61)/(12*100);
    public PrestamoAutomotriz(double monto, int meses, double montoEntrada) {
        super(monto, meses);
        this.montoEntrada = montoEntrada;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    public void setMontoEntrada(double montoEntrada) {
        this.montoEntrada = montoEntrada;
    }
    
    @Override
    public double calcularFinanciador() {
        return getMonto() - this.montoEntrada;
    }

    @Override
    public double calcularCuotaFrances() {
        return ((calcularFinanciador()*INTERES_ANUAL)/(1-(Math.pow((1+INTERES_ANUAL), -getMeses()))))+calcularSeguroIncendio();
    }

    @Override
    public double calcularSeguroIncendio() {
        return calcularFinanciador()* 0.00026;
    }
}
