package es.daw.entornos.cuenta;

import java.time.LocalDate;
import java.util.Objects;

public class Movimiento {
	
    /**
     * Almacena la fecha en la que se realizó el movimiento.
     */
    private LocalDate fecha;

    /**
     * Indica el tipo de movimiento realizado.
     */
    private TipoMovimiento tipoMovimiento;

    /**
     * Representa la cantidad de dinero involucrada en el movimiento.
     */
    private double cantidad;

	/**
	 * Crea un nuevo movimiento con los datos especificados.
	 *
	 * @param fecha          La fecha en la que se realizó el movimiento.
	 * @param tipoMovimiento El tipo de movimiento.
	 * @param cantidad       La cantidad de dinero involucrada.
	 */
	public Movimiento(LocalDate fecha, TipoMovimiento tipoMovimiento, double cantidad) {
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la fecha del movimiento.
	 *
	 * @return La fecha del movimiento.
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha del movimiento.
	 *
	 * @param fecha La nueva fecha del movimiento.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el tipo de movimiento.
	 *
	 * @return El tipo de movimiento.
	 */
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * Establece el tipo de movimiento.
	 *
	 * @param tipoMovimiento El nuevo tipo de movimiento.
	 */
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * Obtiene la cantidad de dinero involucrada en el movimiento.
	 *
	 * @return La cantidad de dinero.
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad de dinero involucrada en el movimiento.
	 *
	 * @param cantidad La nueva cantidad de dinero.
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, fecha, tipoMovimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Objects.equals(fecha, other.fecha) && tipoMovimiento == other.tipoMovimiento;
	}
}
