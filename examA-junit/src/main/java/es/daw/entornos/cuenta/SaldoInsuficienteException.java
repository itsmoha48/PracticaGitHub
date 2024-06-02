package es.daw.entornos.cuenta;

/**
 * Excepción que se lanza cuando el saldo de una cuenta es insuficiente para realizar una operación.
 */
public class SaldoInsuficienteException extends RuntimeException {

    /**
     * Constructor por defecto que establece un mensaje de error genérico.
     */
    public SaldoInsuficienteException() {
        super("Saldo insuficiente para realizar la operación");
    }

    /**
     * Constructor que permite especificar un mensaje de error más detallado.
     *
     * @param message El mensaje de error personalizado.
     */
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}