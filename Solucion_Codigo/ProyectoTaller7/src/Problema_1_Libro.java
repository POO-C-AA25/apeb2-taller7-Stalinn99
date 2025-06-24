import java.util.ArrayList;

public class Problema_1_Libro {
    public static void main(String[] args) {
        Palabra p1 = new Palabra("La");
        Palabra p2 = new Palabra("computadora");
        Palabra p3 = new Palabra("es");
        Palabra p4 = new Palabra("útil");
        Sentencia s1 = new Sentencia();
        s1.agregarPalabra(p1);
        s1.agregarPalabra(p2);
        s1.agregarPalabra(p3);
        s1.agregarPalabra(p4);
        Parrafo parrafo1 = new Parrafo();
        parrafo1.agregarSentencia(s1);
        Figura figura1 = new Figura("Figura de arquitectura de computadoras");
        Tabla tabla1 = new Tabla("Tabla de comparación entre dispositivos");
        Lista lista1 = new Lista("Elementos: CPU, RAM, Disco");
        Vineta v1 = new Vineta("• Esto es una viñeta");
        Seccion seccion1 = new Seccion("Introducción");
        seccion1.agregarComponente(parrafo1);
        seccion1.agregarComponente(figura1);
        seccion1.agregarComponente(tabla1);
        seccion1.agregarComponente(lista1);
        seccion1.agregarComponente(v1);
        Capitulo capitulo1 = new Capitulo("Capítulo 1: Fundamentos");
        capitulo1.agregarSeccion(seccion1);
        capitulo1.mostrar();
    }
}

class Palabra {
    public String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }
}

class Sentencia {
    public ArrayList<Palabra> palabras;

    public Sentencia() {
        palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra palabra) {
        palabras.add(palabra);
    }

    public void mostrar() {
        for (Palabra p : palabras) {
            System.out.print(p.texto + " ");
        }
        System.out.println();
    }
}

class Componente {
    public void mostrar() {
    }
}

class Parrafo extends Componente {
    public ArrayList<Sentencia> sentencias;

    public Parrafo() {
        sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Sentencia sentencia) {
        sentencias.add(sentencia);
    }

    public void mostrar() {
        System.out.print("    Párrafo: ");
        for (Sentencia s : sentencias) {
            s.mostrar();
        }
    }
}

class Figura extends Componente {
    public String descripcion;

    public Figura(String descripcion) {
        this.descripcion = descripcion;
    }

    public void mostrar() {
        System.out.printf("    Figura: %s\n", descripcion);
    }
}

class Tabla extends Componente {
    public String titulo;

    public Tabla(String titulo) {
        this.titulo = titulo;
    }

    public void mostrar() {
        System.out.printf("    Tabla: %s\n", titulo);
    }
}

class Lista extends Componente {
    public String contenido;

    public Lista(String contenido) {
        this.contenido = contenido;
    }

    public void mostrar() {
        System.out.printf("    Lista: %s\n", contenido);
    }
}

class Vineta extends Componente {
    public String texto;

    public Vineta(String texto) {
        this.texto = texto;
    }

    public void mostrar() {
        System.out.printf("    Viñeta: %s\n", texto);
    }
}

class Seccion {
    public String titulo;
    public ArrayList<Componente> componentes;

    public Seccion(String titulo) {
        this.titulo = titulo;
        componentes = new ArrayList<>();
    }

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }

    public void mostrar() {
        System.out.println("  Sección: " + titulo);
        for (Componente c : componentes) {
            c.mostrar();
        }
    }
}

class Capitulo {
    public String titulo;
    public ArrayList<Seccion> secciones;

    public Capitulo(String titulo) {
        this.titulo = titulo;
        secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion) {
        secciones.add(seccion);
    }

    public void mostrar() {
        System.out.println("Título del capítulo: " + titulo);
        for (Seccion s : secciones) {
            s.mostrar();
        }
    }
}
