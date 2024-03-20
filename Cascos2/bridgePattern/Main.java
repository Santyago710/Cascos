import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> accesoriosElegidos = new ArrayList<>();

            CascoFactory cascoFactory = new CascoFactoryBasico(); // Cambio aquí

            int opcion;

            do {
                System.out.println("=== Menú ===");
                System.out.println("1. Pide tu casco");
                System.out.println("2. Mejora tu casco");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has elegido pedir tu casco:");
                        System.out.println("¿Qué tipo de casco tienes?");
                        System.out.println("1. Casco básico");
                        System.out.println("2. Casco standard");
                        System.out.println("3. Casco premium");
                        int tipoCasco = scanner.nextInt();

                        Casco cascoPedido = null;
                        switch (tipoCasco) {
                            case 1:
                                cascoFactory = new CascoFactoryBasico(); // Cambio aquí
                                cascoPedido = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            case 2:
                                cascoFactory = new CascoFactoryStandard(); // Cambio aquí
                                cascoPedido = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            case 3:
                                cascoFactory = new CascoFactoryPremium(); // Cambio aquí
                                cascoPedido = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            default:
                                System.out.println("Opción inválida. Selecciona una opción válida.");
                                break;
                        }

                        if (cascoPedido != null) {
                            System.out.println("¿Deseas agregar accesorios al casco?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            int opcionAccesorios = scanner.nextInt();
                            if (opcionAccesorios == 1) {
                                System.out.println("Elige hasta tres accesorios:");
                                System.out.println("1. Visera");
                                System.out.println("2. Luz trasera");
                                System.out.println("3. Sistema de ventilación");
                                System.out.print("Escribe el número del accesorio: ");
                                int accesorio1 = scanner.nextInt();
                                accesoriosElegidos.add(obtenerAccesorio(accesorio1));
                                System.out.print("Escribe el número del segundo accesorio (o 0 si no hay): ");
                                int accesorio2 = scanner.nextInt();
                                if (accesorio2 != 0) {
                                    accesoriosElegidos.add(obtenerAccesorio(accesorio2));
                                    System.out.print("Escribe el número del tercer accesorio (o 0 si no hay): ");
                                    int accesorio3 = scanner.nextInt();
                                    if (accesorio3 != 0) {
                                        accesoriosElegidos.add(obtenerAccesorio(accesorio3));
                                    }
                                }
                            }
                        }

                        if (!accesoriosElegidos.isEmpty()) {
                            System.out.println("Has pedido un casco " + cascoPedido.getClass().getSimpleName());
                            System.out.println("Con los siguientes accesorios:");
                            for (String accesorio : accesoriosElegidos) {
                                System.out.println("- " + accesorio);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Has elegido mejorar tu casco:");
                        System.out.println("¿Qué tipo de casco tienes?");
                        System.out.println("1. Casco básico");
                        System.out.println("2. Casco standard");
                        System.out.println("3. Casco premium");
                        int tipoCascoMejora = scanner.nextInt();

                        Casco cascoMejora = null;
                        switch (tipoCascoMejora) {
                            case 1:
                                cascoFactory = new CascoFactoryBasico(); // Cambio aquí
                                cascoMejora = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            case 2:
                                cascoFactory = new CascoFactoryStandard(); // Cambio aquí
                                cascoMejora = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            case 3:
                                cascoFactory = new CascoFactoryPremium(); // Cambio aquí
                                cascoMejora = cascoFactory.crearCasco(accesoriosElegidos);
                                break;
                            default:
                                System.out.println("Opción inválida. Selecciona una opción válida.");
                                break;
                        }

                        if (cascoMejora != null) {
                            System.out.println("¿Qué accesorios deseas agregar al casco?");
                            System.out.println("1. Visera");
                            System.out.println("2. Luz trasera");
                            System.out.println("3. Sistema de ventilación");
                            System.out.print("Escribe el número del accesorio: ");
                            int accesorioMejora = scanner.nextInt();
                            accesoriosElegidos.add(obtenerAccesorio(accesorioMejora));
                        }

                        if (!accesoriosElegidos.isEmpty()) {
                            System.out.println("Has mejorado tu casco " + cascoMejora.getClass().getSimpleName());
                            System.out.println("Con los siguientes accesorios:");
                            for (String accesorio : accesoriosElegidos) {
                                System.out.println("- " + accesorio);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                }
            } while (opcion != 3);
        }
    }

    private static String obtenerAccesorio(int opcion) {
        switch (opcion) {
            case 1:
                return "Visera";
            case 2:
                return "Luz trasera";
            case 3:
                return "Sistema de ventilación";
            default:
                return "Accesorio no válido";
        }
    }
}
