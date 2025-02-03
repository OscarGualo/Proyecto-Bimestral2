package com.sistematransaccional.Logica;

public class PrestamoUno extends PrestamoPrueba implements MetodoFrances {

    // Tasa de interés anual (11.61% anual convertida a tasa mensual)
    private static final double INTERES_ANUAL = 11.61 / (12 * 100);
    private double saldoPendiente;  // Se actualiza conforme se amortiza
    private double saldoFinal; 
    public PrestamoUno(double monto, double meses) {
        super(monto, meses);
        // Inicialmente, el saldo pendiente es igual al monto del préstamo
        this.saldoPendiente = getMonto();
        this.saldoFinal = monto;
    }

    // 1. Método para calcular la cuota fija (utilizando la fórmula francesa)
    @Override
    public double calcularCuotaFija() {
        double cuota = calcularSeguroIncendios()+( saldoFinal* INTERES_ANUAL) / (1 - Math.pow(1 + INTERES_ANUAL, -getMeses()));
        // Si se requieren los seguros en la cuota, se pueden sumar aquí (comentado por ahora)
        // cuota += calcularSeguroIncendios() + calcularSeguroDesgravamen();
        return cuota;
    }

    // 2. Método para calcular el interés del período actual usando el saldo pendiente
    public double calcularInteresPeriodo() {
        return saldoPendiente * INTERES_ANUAL;
    }

    // 3. Método para calcular la amortización del período.
    // Se toma la cuota fija y se le resta el interés y los seguros.
    // Se ajusta para que la amortización no exceda el saldo pendiente.
    public double calcularAmortizacionPeriodo() {
        double cuotaFija = calcularCuotaFija();
        double interes = calcularInteresPeriodo();
        // Se suman los seguros si se desean incluir en la cuota (aquí se restan)
        double seguros = calcularSeguroIncendios() + calcularSeguroDesgravamen();
        double amortizacion = cuotaFija - interes - seguros;
        if (amortizacion > saldoPendiente) {
            amortizacion = saldoPendiente;
        }
        return amortizacion;
    }

    // 4. Método para calcular el nuevo saldo tras aplicar la amortización
    public double calcularNuevoSaldo() {
        double amortizacion = calcularAmortizacionPeriodo();
        double nuevoSaldo = saldoPendiente - amortizacion;
        if (nuevoSaldo < 0) {
            nuevoSaldo = 0;
        }
        // Actualizamos el saldo pendiente para el siguiente cálculo
        saldoPendiente = nuevoSaldo;
        setMonto(nuevoSaldo);
        return nuevoSaldo;
    }

    
    
   
}
