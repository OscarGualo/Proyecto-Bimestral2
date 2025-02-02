/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistematransaccional.Logica;

/**
 *
 * @author oscar
 */
public abstract class PrestamoLogic implements Calculador{
   private double monto ;
    private int meses; 

    public PrestamoLogic(double monto, int meses) {
        this.monto = monto;
        this.meses = meses;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
    
}
