
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class PrestamoDos extends PrestamoPrueba implements MetodoAleman {
    private double capitalFija;
    private double montoFinal;

    public PrestamoDos(double monto, double meses) {
        super(monto, meses);
        this.capitalFija = calcularCapitalFija();
        this.montoFinal = monto;
    }

    public double capitalFija() {
        return montoFinal / getMeses();
    }

    @Override
    public double calcularCapitalFija() {
        return getMonto() / getMeses();
    }

    @Override
    public double calcularCuota() {
        double cuotaTotal;
        cuotaTotal = capitalFija + calcularInteres() + calcularSeguroDesgravamen();
        return cuotaTotal;
    }

    public double calcularSaldoFinal() {
        double saldoInicial = getMonto();
        double saldoFinal = saldoInicial - this.capitalFija;
        setMonto(saldoFinal);
        return saldoFinal;
    }

    @Override
    public double sumarSeguros() {
        return calcularSeguroDesgravamen() + calcularSeguroIncendios();
    }

}
