
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public abstract class PrestamoPrueba {
    private double monto;
    private double meses;
    private static final double INTERES_NOMINAL = (11.03) / (12 * 100);
    private double montoFinal;

    public PrestamoPrueba(double monto, double meses) {
        this.monto = monto;
        this.meses = meses;
        this.montoFinal = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMeses() {
        return meses;
    }

    public void setMeses(double meses) {
        this.meses = meses;
    }

    public double calcularSeguroIncendios() {
        return this.montoFinal * 0.00026;
    }

    public double calcularSeguroDesgravamen() {
        return getMonto() * 0.000572;
    }

    public double calcularInteres() {
        return getMonto() * INTERES_NOMINAL;
    }

    public abstract double sumarSeguros();

}
