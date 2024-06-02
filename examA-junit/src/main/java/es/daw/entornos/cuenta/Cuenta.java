package es.daw.entornos.cuenta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cuenta bancaria con las funcionalidades básicas de consulta de saldo,
 * depósito, retiro y registro de movimientos.
 *
 * @author Rafael Nadal Parera
 */
public class Cuenta {

    /**
     * El saldo actual de la cuenta.
     */
    private double saldo;

    /**
     * Lista de movimientos asociados a la cuenta.
     */
    private List<Movimiento> movimientos;

    /**
     * Constructor de la cuenta.
     *
     * @param saldoInicial El saldo inicial de la cuenta.
     * @throws IllegalArgumentException Si el saldo inicial es negativo.
     */
    public Cuenta(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial debe ser positivo");
        }

        this.saldo = saldoInicial;
        this.movimientos = new ArrayList<>();
    }

    
    /**
     * Setea el saldo actual de la cuenta.
     * 
     * @param saldo El saldo actual.
     */
    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return El saldo actual.
     */
    public double getSaldo() {
        return saldo;
    }


    /**
     * Deposita la cantidad especificada en la cuenta.
     *
     * @param cantidad La cantidad a depositar.
     * @return `true` al final, si todo sale bien.
     * @throws IllegalArgumentException Si la cantidad a depositar es negativa.
     */
    public boolean depositar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva");
        }

        saldo += cantidad;
        registrarMovimiento(new Movimiento(LocalDate.now(), TipoMovimiento.DEPOSITO, cantidad));
        System.out.println("Se han depositado " + cantidad + " euros en la cuenta. Su nuevo saldo es: " + saldo);
        return true;
    }

    /**
     * Retira la cantidad especificada de la cuenta.
     *
     * @param cantidad La cantidad a retirar.
     * @return `true` al final, si todo sale bien.
     * @throws IllegalArgumentException Si la cantidad a retirar es negativa o mayor que el saldo actual.
     * @throws SaldoInsuficienteException Si el saldo es insuficiente para realizar la operación.
     */
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
        } else if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operación");
        }

        saldo -= cantidad;
        registrarMovimiento(new Movimiento(LocalDate.now(), TipoMovimiento.RETIRO, cantidad));
        System.out.println("Se han retirado " + cantidad + " euros de la cuenta. Su nuevo saldo es: " + saldo);
        return true;
    }

    /**
     * Registra un nuevo movimiento en la lista de movimientos de la cuenta.
     *
     * @param movimiento El movimiento a registrar.
     */
    public void registrarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    /**
     * Obtiene la lista de movimientos de la cuenta.
     *
     * @return La lista de movimientos.
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    /**
     * Vacía la cuenta, dejando el saldo en 0.
     *
     * @throws SaldoInsuficienteException Si la cuenta ya está vacía.
     */
    public void vaciarCuenta() {
        double saldoActual = getSaldo();

        if (saldoActual == 0) {
            throw new SaldoInsuficienteException("La cuenta ya está vacía");
        }
        else {
        	this.saldo = 0;
        }
    }
}

