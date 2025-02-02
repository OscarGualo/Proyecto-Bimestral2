/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistematransaccional.Logica;

/**
 *
 * @author oscar
 */
public class CalculadoraDePagos {
    private double montoSoliticitado;
    private double costoArticulo ;
    private double plazo ; 

    public CalculadoraDePagos(double montoSoliticitado, double costoArticulo, double plazo) {
        this.montoSoliticitado = montoSoliticitado;
        this.costoArticulo = costoArticulo;
        this.plazo = plazo;
    }

    public double getMontoSoliticitado() {
        return montoSoliticitado;
    }

    public void setMontoSoliticitado(double montoSoliticitado) {
        this.montoSoliticitado = montoSoliticitado;
    }

    public double getCostoArticulo() {
        return costoArticulo;
    }

    public void setCostoArticulo(double costoArticulo) {
        this.costoArticulo = costoArticulo;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }
    public double calcularCapital(){
        return 0;
    }
    
}
