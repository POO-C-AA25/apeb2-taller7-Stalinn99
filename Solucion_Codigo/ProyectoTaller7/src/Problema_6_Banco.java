import java.util.ArrayList;

public class Problema_6_Banco {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new Cheque("CHQ-902", "Juan Pérez");
        CuentaBancaria cuenta2 = new Ahorro("AHO-031", "María García");
        CuentaBancaria cuenta3 = new Platino("AHP-002", "Pedro Pascal");

        cuenta1.depositar(1000);
        cuenta2.depositar(500);
        cuenta3.depositar(800);
        ((Ahorro) cuenta2).calcularInteres();
        ((Platino) cuenta3).calcularInteres();
        cuenta1.retirar(500);
        cuenta2.retirar(200);
        cuenta3.retirar(200);

        Banco banco = new Banco();
        banco.agregarCuenta(cuenta1);
        banco.agregarCuenta(cuenta2);
        banco.agregarCuenta(cuenta3);
        banco.mostrarEstadosCuenta();
    }
}

class CuentaBancaria {
    public String numeroCuenta;
    public String nombreCliente;
    public double saldo;
    public String tipoCuenta;

    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = 0.0;
        this.tipoCuenta = null;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.printf("Se ha agregado %.2f a la cuenta de %s\n", cantidad, nombreCliente);
        } else {
            System.out.println("No se puede agregar 0 dólares.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            saldo -= cantidad;
            System.out.printf("Se ha retirado %.2f de la cuenta %s. Saldo actual: %.2f\n", cantidad, nombreCliente,
                    saldo);
        } else {
            System.out.println("No puedes retirar 0 dólares.");
        }
    }
}

class Cheque extends CuentaBancaria {
    public Cheque(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tipoCuenta = "Cheque";
    }

    @Override
    public void retirar(double cantidad) {
        super.retirar(cantidad);
    }
}

class Ahorro extends CuentaBancaria {
    public double interes = 0.05;

    public Ahorro(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tipoCuenta = "Ahorros";
    }

    public void calcularInteres() {
        double interesTotal = saldo * interes;
        depositar(interesTotal);
        System.out.printf("Interés del %.2f%% aplicado. Saldo actual: %.2f\n", (interes * 100), saldo);
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (saldo - cantidad >= 0) {
                super.retirar(cantidad);
            } else {
                System.out.println("No puede retirar un monto mayor a su saldo.");
            }
        }
    }
}

class Platino extends CuentaBancaria {
    public double interes = 0.10;

    public Platino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tipoCuenta = "Platino";
    }

    public void calcularInteres() {
        double interesTotal = saldo * interes;
        depositar(interesTotal);
        System.out.printf("Interés Platino del %.2f%% aplicado. Saldo actual: %.2f\n", (interes * 100), saldo);
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            saldo -= cantidad;
            System.out.printf("Se ha retirado %.2f de la cuenta %s. Saldo actual: %.2f\n", cantidad, nombreCliente,
                    saldo);
        } else {
            System.out.println("No puedes retirar 0 dólares.");
        }
    }

}

class Banco {
    public ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public void mostrarEstadosCuenta() {
        System.out.println("\n=== ESTADOS DE CUENTA DEL BANCO ===");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.printf("Cliente: %s\n", cuenta.nombreCliente);
            System.out.printf("Número de cuenta: %s\n", cuenta.numeroCuenta);
            System.out.printf("Balance actual: %.2f\n", cuenta.saldo);
            System.out.printf("Tipo de cuenta: %s\n", cuenta.tipoCuenta);
            System.out.println("---------------------------");
        }
    }
}
