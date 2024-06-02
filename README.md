Proyecto de Gestión de Cuentas Bancarias
Este proyecto es una aplicación simple de gestión de cuentas bancarias que permite realizar operaciones básicas como depósitos, retiros y consultar el saldo, además de mantener un registro de todos los movimientos realizados en la cuenta.

Descripción
El proyecto consiste en varias clases que modelan el funcionamiento de una cuenta bancaria:

Cuenta: Representa una cuenta bancaria con funcionalidades básicas.
Movimiento: Representa un movimiento o transacción en la cuenta bancaria.
SaldoInsuficienteException: Excepción personalizada que se lanza cuando el saldo es insuficiente para realizar una operación.
TipoMovimiento: Enumeración que define los tipos de movimientos (DEPÓSITO y RETIRO).
Estructura del Proyecto
El proyecto está organizado en el paquete es.daw.entornos.cuenta y contiene las siguientes clases:

Clase Cuenta
La clase Cuenta representa una cuenta bancaria con las funcionalidades básicas de consulta de saldo, depósito, retiro y registro de movimientos. Contiene los siguientes atributos y métodos principales:

Atributos:

saldo: Representa el saldo actual de la cuenta.
movimientos: Lista de movimientos asociados a la cuenta.
Constructores:

Cuenta(double saldoInicial): Crea una nueva instancia de Cuenta con un saldo inicial positivo.
Métodos:

setSaldo(double saldo): Establece el saldo actual de la cuenta.
getSaldo(): Obtiene el saldo actual de la cuenta.
depositar(double cantidad): Deposita la cantidad especificada en la cuenta.
retirar(double cantidad): Retira la cantidad especificada de la cuenta.
registrarMovimiento(Movimiento movimiento): Registra un nuevo movimiento en la lista de movimientos de la cuenta.
getMovimientos(): Obtiene la lista de movimientos de la cuenta.
vaciarCuenta(): Vacía la cuenta, dejando el saldo en 0.
Clase Movimiento
La clase Movimiento representa una transacción o movimiento dentro de una cuenta bancaria. Cada movimiento incluye la fecha en que se realizó, el tipo de movimiento (depósito o retiro), y la cantidad de dinero involucrada. Contiene los siguientes atributos y métodos principales:

Atributos:

fecha: Almacena la fecha en la que se realizó el movimiento.
tipoMovimiento: Indica el tipo de movimiento realizado (por ejemplo, depósito o retiro).
cantidad: Representa la cantidad de dinero involucrada en el movimiento.
Constructores:

Movimiento(LocalDate fecha, TipoMovimiento tipoMovimiento, double cantidad): Crea un nuevo movimiento con los datos especificados.
Métodos:

getFecha(): Obtiene la fecha del movimiento.
setFecha(LocalDate fecha): Establece la fecha del movimiento.
getTipoMovimiento(): Obtiene el tipo de movimiento.
setTipoMovimiento(TipoMovimiento tipoMovimiento): Establece el tipo de movimiento.
getCantidad(): Obtiene la cantidad de dinero involucrada en el movimiento.
setCantidad(double cantidad): Establece la cantidad de dinero involucrada en el movimiento.
Clase SaldoInsuficienteException
La clase SaldoInsuficienteException es una excepción personalizada que se lanza cuando se intenta realizar una operación en una cuenta bancaria y el saldo de la cuenta es insuficiente para completar dicha operación. Esta clase extiende de RuntimeException y contiene el siguiente constructor principal:

Constructores:
SaldoInsuficienteException(String mensaje): Crea una nueva instancia de SaldoInsuficienteException con el mensaje de error especificado.
Enumeración TipoMovimiento
La enumeración TipoMovimiento define los tipos de movimientos que se pueden realizar en una cuenta bancaria. Es utilizada para especificar si un movimiento es un depósito o un retiro. Contiene los siguientes valores:

Valores:
DEPOSITO: Representa un movimiento de depósito en la cuenta.
RETIRO: Representa un movimiento de retiro de la cuenta.
Ejemplo de Uso
Un ejemplo típico de uso del proyecto incluiría la creación de una cuenta, la realización de depósitos y retiros, la consulta del saldo actual y la visualización de los movimientos realizados.
