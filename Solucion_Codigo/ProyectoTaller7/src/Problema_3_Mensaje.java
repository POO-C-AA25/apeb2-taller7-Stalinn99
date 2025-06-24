public class Problema_3_Mensaje {
    public static void main(String[] args) {
        Movil remitente = new Movil(987654321, "Juan Perez");
        Movil destinatario = new Movil(123456789, "Pedro Martinez");

        System.out.println("Probando el envío de un SMS");
        SMS miSms = new SMS(remitente, destinatario, "Hola Mundo");
        miSms.enviarSMS();
        miSms.visualizarSMS();
        System.out.println("\n========================================\n");

        System.out.println("Probando el envío de un MMS");
        MMS miMms = new MMS(remitente, destinatario, "foto_vacaciones.jpg");
        miMms.enviarMMS();
        miMms.visualizarMMS();
    }
}

class Mensaje {
    public Movil remitente;
    public Movil destinatario;

    public Mensaje() {
    }

    public Mensaje(Movil remitente, Movil destinatario) {
        this.destinatario = destinatario;
        this.remitente = remitente;
    }

    public void enviar() {
        System.out.println("Mensaje a enviar");
    }

    public void recibir() {
        System.out.println("Visor del mensaje");
        System.out.printf("De: %15s", remitente.toString());
        System.out.printf("Para: %15s", destinatario.toString());
        System.out.println("-".repeat(destinatario.toString().length()));
    }
}

class SMS extends Mensaje {
    public String texto;

    public SMS(Movil remitente, Movil destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    public void enviarSMS() {
        System.out.printf("Enviando SMS de [%10s] a [%10s]", remitente.numero, destinatario.numero);
        System.out.println("¡SMS Enviado!");
    }

    public void visualizarSMS() {
        System.out.println("----- Visualizando SMS -----");
        System.out.println("De: " + remitente.toString());
        System.out.println("Para: " + destinatario.toString());
        System.out.println("Mensaje: " + texto);
        System.out.println("--------------------------");
    }
}

class MMS extends Mensaje {
    public String nombreImagen;

    public MMS(Movil remitente, Movil destinatario, String nombreImagen) {
        super(remitente, destinatario);
        this.nombreImagen = nombreImagen;
    }

    public void enviarMMS() {
        System.out.printf("Enviando MMS de [%10s] a [%10s]", remitente.numero, destinatario.numero);
        System.out.println("¡MMS Enviado!");
    }

    public void visualizarMMS() {
        System.out.println("----- Visualizando MMS -----");
        System.out.printf("\nDe: %15s ", remitente.toString());
        System.out.printf("\nPara: %15s", destinatario.toString());
        System.out.printf("\nMensaje: %15s", nombreImagen);
        System.out.println();
        System.out.println("-".repeat(nombreImagen.length()));
    }
}

class Movil {
    public int numero;
    public String nombre;

    public Movil(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Movil [numero=" + numero + ", nombre=" + nombre + "]";
    }

}
