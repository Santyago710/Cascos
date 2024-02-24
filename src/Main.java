import java.util.Scanner;

class CascoBuilder {
    private static CascoBuilder instance;
    private String color;
    private String diseño;
    private String visor;

    private CascoBuilder() {}

    public static CascoBuilder getInstance() {
        if (instance == null) {
            instance = new CascoBuilder();
        }
        return instance;
    }

    public CascoBuilder color(String color) {
        this.color = color;
        return this;
    }

    public CascoBuilder diseño(String diseño) {
        this.diseño = diseño;
        return this;
    }

    public CascoBuilder visor(String visor) {
        this.visor = visor;
        return this;
    }

    public String getColor() {
        return color;
    }

    public String getDiseño() {
        return diseño;
    }

    public String getVisor() {
        return visor;
    }

    public Casco build() {
        return new Casco(this);
    }
}

class Casco {
    private String color;
    private String diseño;
    private String visor;

    public Casco(CascoBuilder builder) {
        this.color = builder.getColor();
        this.diseño = builder.getDiseño();
        this.visor = builder.getVisor();
    }

    public String getColor() {
        return color;
    }

    public String getDiseño() {
        return diseño;
    }

    public String getVisor() {
        return visor;
    }

    public String toString() {
        return "Casco{" +
                "color='" + color + '\'' +
                ", diseño='" + diseño + '\'' +
                ", visor='" + visor + '\'' +
                '}';
    }
}

interface CascoFactory {
    Casco crearCasco();
}

class CascoIntegralFactory implements CascoFactory {
    @Override
    public Casco crearCasco() {
        return CascoBuilder.getInstance()
                .color("Rojo")
                .diseño("Estampado")
                .visor("Transparente")
                .build();
    }
}

class CascoAbatibleFactory implements CascoFactory {
    @Override
    public Casco crearCasco() {
        return CascoBuilder.getInstance()
                .color("Azul")
                .diseño("Liso")
                .visor("Oscuro")
                .build();
    }
}

class CascoJetFactory implements CascoFactory {
    @Override
    public Casco crearCasco() {
        return CascoBuilder.getInstance()
                .color("Negro")
                .diseño("Rayas")
                .visor("Espejo")
                .build();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a Casco a tu Estilo");
        System.out.println("1. Compra tu casco");
        System.out.println("2. Personaliza tu casco");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarMenuCompra(scanner);
                break;
            case 2:
                mostrarMenuPersonalizacion(scanner);
                break;
            case 3:
                System.out.println("Gracias por visitar nuestra página. ¡Vuelve pronto!");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void mostrarMenuCompra(Scanner scanner) {
        System.out.println("Tipos de cascos:");
        System.out.println("1. Integral - $100.000 cop");
        System.out.println("2. Abatible - $120.000 cop");
        System.out.println("3. Jet - $80.000 cop");
        System.out.println("4. Modular - $140.000 cop");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Has elegido un casco Integral - $100.000 cop");
                System.out.println("¿Deseas personalizar este casco? (S/N)");
                char personalizar = scanner.next().charAt(0);
                if (personalizar == 'S' || personalizar == 's') {
                    mostrarMenuPersonalizacion(scanner);
                }
                if (personalizar == 'N' || personalizar == 'n') {
                    System.out.println("Has comprado un casco integral");
                    System.out.println("gracias por tu compra vuelve pronto");
                }
                break;
            case 2:
                System.out.println("Has elegido un casco Abatible - $120.000 cop");
                System.out.println("¿Deseas personalizar este casco? (S/N)");
                personalizar = scanner.next().charAt(0);
                if (personalizar == 'S' || personalizar == 's') {
                    mostrarMenuPersonalizacion(scanner);
                }
                if (personalizar == 'N' || personalizar == 'n') {
                    System.out.println("Has comprado un casco Abatible");
                    System.out.println("gracias por tu compra vuelve pronto");
                }
                break;
            case 3:
                System.out.println("Has elegido un casco Jet - $80.000 cop");
                System.out.println("¿Deseas personalizar este casco? (S/N)");
                personalizar = scanner.next().charAt(0);
                if (personalizar == 'S' || personalizar == 's') {
                    mostrarMenuPersonalizacion(scanner);
                }
                if (personalizar == 'N' || personalizar == 'n') {
                    System.out.println("Has comprado un casco Jet");
                    System.out.println("gracias por tu compra vuelve pronto");
                }
                break;
            case 4:
                System.out.println("Has elegido un casco Modular - $140.000 cop");
                System.out.println("¿Deseas personalizar este casco? (S/N)");
                personalizar = scanner.next().charAt(0);
                if (personalizar == 'S' || personalizar == 's') {
                    mostrarMenuPersonalizacion(scanner);
                }
                if (personalizar == 'N' || personalizar == 'n') {
                    System.out.println("Has comprado un casco Modular");
                    System.out.println("gracias por tu compra vuelve pronto");
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void mostrarMenuPersonalizacion(Scanner scanner) {
        System.out.println("Personaliza tu casco:");
        System.out.println("1. Color");
        System.out.println("2. Diseño");
        System.out.println("3. Visor");
        System.out.println("4. Otra característica");
    
        int opcion = scanner.nextInt();
        int contador = 0; // Contador para el número de opciones seleccionadas
        String color = "";
        String diseño = "";
        String visor = "";
        String otraCaracteristica = "";
    
        while (opcion != 0) { // Mientras la opción no sea 0 (salir)
            switch (opcion) {
                case 1:
                    System.out.println("Elige el color:");
                    System.out.println("1. Rojo");
                    System.out.println("2. Azul");
                    System.out.println("3. Negro");
                    int colorOpcion = scanner.nextInt();
                    switch (colorOpcion) {
                        case 1:
                            color = "Rojo";
                            break;
                        case 2:
                            color = "Azul";
                            break;
                        case 3:
                            color = "Negro";
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    contador++;
                    break;
                case 2:
                    System.out.println("Elige el diseño:");
                    System.out.println("1. Liso");
                    System.out.println("2. Estampado");
                    System.out.println("3. Rayas");
                    int diseñoOpcion = scanner.nextInt();
                    switch (diseñoOpcion) {
                        case 1:
                            diseño = "Liso";
                            break;
                        case 2:
                            diseño = "Estampado";
                            break;
                        case 3:
                            diseño = "Rayas";
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    contador++;
                    break;
                case 3:
                    System.out.println("Elige el color del visor:");
                    System.out.println("1. Transparente");
                    System.out.println("2. Oscuro");
                    System.out.println("3. Espejo");
                    int visorOpcion = scanner.nextInt();
                    switch (visorOpcion) {
                        case 1:
                            visor = "Transparente";
                            break;
                        case 2:
                            visor = "Oscuro";
                            break;
                        case 3:
                            visor = "Espejo";
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    contador++;
                    break;
                    case 4:
                    System.out.println("Elige la característica que deseas personalizar:");
                    System.out.println("1. Casco");
                    System.out.println("2. Visor");
                    System.out.println("3. Diseño");
                    int caracteristicaOpcion = scanner.nextInt();
                    switch (caracteristicaOpcion) {
                        case 1:
                            System.out.println("Introduce la característica del casco:");
                            otraCaracteristica = scanner.next();
                            System.out.println("Has seleccionado personalizar el casco con la característica: " + otraCaracteristica);
                            contador++;
                            break;
                        case 2:
                            System.out.println("Introduce la característica del visor:");
                            otraCaracteristica = scanner.next();
                            System.out.println("Has seleccionado personalizar el visor con la característica: " + otraCaracteristica);
                            contador++;
                            break;
                        case 3:
                            System.out.println("Introduce la característica del diseño:");
                            otraCaracteristica = scanner.next();
                            System.out.println("Has seleccionado personalizar el diseño con la característica: " + otraCaracteristica);
                            contador++;
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    break;
                
            }
    
            if (contador == 3) { // Si el usuario ha seleccionado 3 opciones
                System.out.println("Gracias por comprar en Casco a tu Estilo. ¡Vuelve pronto!");
                System.out.println("Has personalizado tu casco con los siguientes detalles:");
                System.out.println("Color: " + color);
                System.out.println("Diseño: " + diseño);
                System.out.println("Visor: " + visor);
                System.out.println("Otra característica: " + otraCaracteristica);
                break; // Salir del bucle
            }
    
            System.out.println("Se ha guardado la personalización.");
            System.out.println("Personaliza tu casco:");
            System.out.println("1. Color");
            System.out.println("2. Diseño");
            System.out.println("3. Visor");
            System.out.println("4. Otra característica");
            System.out.println("0. Salir");
    
            opcion = scanner.nextInt();
        }
    }
    
}
