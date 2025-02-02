package com.sistematransaccional.Logica;


import com.sistematransaccional.Logica.MetodoAleman;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class PrestamoDos extends PrestamoPrueba implements MetodoAleman{

    public PrestamoDos(double monto, double meses) {
        super(monto, meses);
    }

    @Override
    public double calcularCapitalFija() {
        return getMonto() / getMeses();
    }
    
}
