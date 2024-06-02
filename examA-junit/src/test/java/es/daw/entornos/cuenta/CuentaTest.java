package es.daw.entornos.cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {

	private Cuenta cuenta;

	//Se ejecuta siempre despues de cada test.
	@BeforeEach
	public void setUp() {
		cuenta = new Cuenta(1000);
	}

	@Test
	public void testCrearCuentaNegativa() {
		assertThrows(IllegalArgumentException.class, () ->  new Cuenta(-1000));
	}
	
	@Test
	public void testVerSaldo() {
		assertEquals(1000.0, cuenta.getSaldo());
	}
	
	@Test
	public void testEstablecerSaldo() {
		double cantidad = 100.0;
		cuenta.setSaldo(cantidad);
		assertEquals(cantidad, cuenta.getSaldo());
	}

	@Test
	public void testDepositar() {
		double cantidadADep = 200.0;
		boolean depositoExitoso = cuenta.depositar(cantidadADep);
		assertTrue(depositoExitoso);
		//Recuerda que la cuenta ya tiene 1000 de saldo
		assertEquals(1200.0, cuenta.getSaldo());

		//Se comprueba si se ha insertado el registro movimiento generado por el deposito
		Movimiento movimiento = new Movimiento(LocalDate.now(), TipoMovimiento.DEPOSITO, cantidadADep);
		assertTrue(cuenta.getMovimientos().contains(movimiento));
	}

	@Test
	public void testDepositarCantidadNegativa() {
		double cantidadInvalida = -100.0;
		assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(cantidadInvalida));
	}

	@Test
	public void testRetirarDinero() {
		double cantidadARetirar = 300.0;
		boolean retirar = cuenta.retirar(cantidadARetirar);
		assertTrue(retirar);
		//Recuerda que la cuenta ya tiene 1000 de saldo
		assertEquals(700.0, cuenta.getSaldo());

		//Se comprueba si se ha insertado el registro movimiento generado tras retirar dinero
		Movimiento movimiento = new Movimiento(LocalDate.now(), TipoMovimiento.RETIRO, cantidadARetirar);
		assertTrue(cuenta.getMovimientos().contains(movimiento));
	}

	@Test
	public void testRetirarCantidadNegativa() {
		double cantidadInvalida = -100.0;
		assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(cantidadInvalida));
	}

	@Test
	public void testRetirarCantidadExcesiva() {
		double cantidadExcesiva = 1500.0;
		assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar(cantidadExcesiva));
	}
	
	@Test
    public void testVaciarCuentaOk() {
        cuenta.vaciarCuenta();
        assertEquals(0.0, cuenta.getSaldo()); 
    }

    @Test
    public void testVaciarCuentaYaVacia() {
        cuenta.vaciarCuenta(); 
        assertThrows(SaldoInsuficienteException.class, () -> cuenta.vaciarCuenta()); // Intentar vaciarla de nuevo
    }
}
