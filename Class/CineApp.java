import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CineApp {
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static ArrayList<Cine> cines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        agregarPelicula(scanner);
                        break;
                    case 2:
                        registrarFuncion(scanner);
                        break;
                    case 3:
                        mostrarCartelera();
                        break;
                    case 4:
                        agregarOpinion(scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 5.");
                scanner.next(); // Consumir la entrada no válida
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar una película");
        System.out.println("2. Registrar una función en una sala");
        System.out.println("3. Mostrar la cartelera");
        System.out.println("4. Agregar una opinión de usuario sobre una película");
        System.out.println("5. Salir del programa");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarPelicula(Scanner scanner) {
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        while (titulo == null || titulo.isEmpty()) {
            System.out.print("El título no puede ser nulo o vacío. Ingrese el título de la película: ");
            titulo = scanner.nextLine();
        }

        int duracion = 0;
        boolean duracionValida = false;
        while (!duracionValida) {
            System.out.print("Ingrese la duración de la película (en minutos): ");
            if (scanner.hasNextInt()) {
                duracion = scanner.nextInt();
                if (duracion > 0) {
                    duracionValida = true;
                } else {
                    System.out.println("La duración debe ser mayor a 0.");
                }
            } else {
                System.out.println("La duración debe ser un número.");
                scanner.next(); // Consumir el valor no válido
            }
        }
        scanner.nextLine(); // Consumir el salto de línea

        String clasificacion = "";
        boolean clasificacionValida = false;
        do {
            System.out.print(
                    "Ingrese la clasificación de la película (1: Apta todo público, 2: +9 años, 3: +15 años, 4: +18 años): ");
            if (scanner.hasNextInt()) {
                int opcionClasificacion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                switch (opcionClasificacion) {
                    case 1:
                        clasificacion = "Apta todo público";
                        clasificacionValida = true;
                        break;
                    case 2:
                        clasificacion = "+9 años";
                        clasificacionValida = true;
                        break;
                    case 3:
                        clasificacion = "+15 años";
                        clasificacionValida = true;
                        break;
                    case 4:
                        clasificacion = "+18 años";
                        clasificacionValida = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Las opciones válidas son: 1, 2, 3, 4.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 4.");
                scanner.next(); // Consumir el valor no válido
            }
        } while (!clasificacionValida);

        LocalDate fechaEstreno = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.print("Ingrese la fecha de estreno (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            try {
                fechaEstreno = LocalDate.parse(fechaStr);
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato YYYY-MM-DD.");
            }
        }

        Pelicula pelicula = new Pelicula(titulo, duracion, clasificacion, fechaEstreno);
        peliculas.add(pelicula);
        System.out.println("Película agregada exitosamente.");
    }

    private static void registrarFuncion(Scanner scanner) {
        System.out.print("Ingrese el nombre del cine: ");
        String nombreCine = scanner.nextLine();
        while (nombreCine == null || nombreCine.isEmpty() || !nombreCine.matches("[a-zA-Z0-9 ]+")) {
            System.out.print(
                    "El nombre del cine no puede ser nulo, vacío o contener caracteres especiales. Ingrese el nombre del cine: ");
            nombreCine = scanner.nextLine();
        }
        Cine cine = buscarCinePorNombre(nombreCine);
        if (cine == null) {
            cine = new Cine(nombreCine);
            cines.add(cine);
        }

        System.out.print("Ingrese el número de la sala: ");
        int numeroSala = scanner.nextInt();
        System.out.print("Ingrese la capacidad de la sala: ");
        int capacidadSala = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Sala sala = new Sala(numeroSala, capacidadSala);
        cine.agregarSala(sala);

        System.out.print("Ingrese el título de la película: ");
        String tituloPelicula = scanner.nextLine();
        Pelicula pelicula = buscarPeliculaPorTitulo(tituloPelicula);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        LocalDateTime horario = null;
        boolean horarioValido = false;
        while (!horarioValido) {
            System.out.print("Ingrese el horario de la función (YYYY-MM-DDTHH:MM, por ejemplo, 2025-03-10T14:30): ");
            String horarioStr = scanner.nextLine();
            try {
                horario = LocalDateTime.parse(horarioStr);
                horarioValido = true;
            } catch (Exception e) {
                System.out.println(
                        "Formato de fecha y hora inválido. Por favor, use el formato YYYY-MM-DDTHH:MM, por ejemplo, 2025-03-10T14:30.");
            }
        }

        Funcion funcion = new Funcion(pelicula, horario);
        sala.agregarFuncion(funcion);
        System.out.println("Función registrada exitosamente.");
    }

    private static void mostrarCartelera() {
        for (Cine cine : cines) {
            System.out.println("Cine: " + cine.getNombre());
            for (Sala sala : cine.getSalas()) {
                System.out.println("  Sala: " + sala.getNumero() + " (Capacidad: " + sala.getCapacidad() + ")");
                for (Funcion funcion : sala.getFunciones()) {
                    System.out.println("    " + funcion);
                }
            }
        }
    }

    private static void agregarOpinion(Scanner scanner) {
        System.out.print("Ingrese el título de la película: ");
        String tituloPelicula = scanner.nextLine();
        Pelicula pelicula = buscarPeliculaPorTitulo(tituloPelicula);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.print("Ingrese su comentario: ");
        String comentario = scanner.nextLine();
        System.out.print("Ingrese su calificación (Obra Maestra, Muy Buena, Buena, Regular, Mala): ");
        String calificacion = scanner.nextLine();

        Opinion opinion = new Opinion(comentario, calificacion);
        pelicula.agregarOpinion(opinion);
        System.out.println("Opinión agregada exitosamente.");
    }

    private static Cine buscarCinePorNombre(String nombre) {
        for (Cine cine : cines) {
            if (cine.getNombre().equalsIgnoreCase(nombre)) {
                return cine;
            }
        }
        return null;
    }

    private static Pelicula buscarPeliculaPorTitulo(String titulo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }
}
