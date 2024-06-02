package es.daw.entornos.cuenta;

/**
 * Representa los tipos de movimientos que se pueden realizar en una cuenta
 * bancaria.
 */
public enum TipoMovimiento {

	/**
	 * Indica que se ha realizado un depósito de dinero en la cuenta.
	 */
	DEPOSITO("Depósito de dinero"),

	/**
	 * Indica que se ha retirado dinero de la cuenta.
	 */
	RETIRO("Retiro de dinero"),

	/**
	 * Indica que se ha realizado una transferencia de dinero a otra cuenta.
	 */
	TRANSFERENCIA("Transferencia de dinero"),

	/**
	 * Indica que se ha recibido una transferencia de dinero de otra cuenta.
	 */
	RECEPCCION_TRANSFERENCIA("Recepción de transferencia");

	private final String descripcion;

	private TipoMovimiento(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la descripción del tipo de movimiento.
	 *
	 * @return La descripción del tipo de movimiento.
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
