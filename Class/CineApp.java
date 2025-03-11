import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CineApp {
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static ArrayList<Cine> cines = new ArrayList<>();
    private static ArrayList<Actor> actores = new ArrayList<>();
    private static ArrayList<Director> directores = new ArrayList<>();
    private static ArrayList<Promocion> promociones = new ArrayList<>();

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
                        agregarActor(scanner);
                        break;
                    case 6:
                        agregarDirector(scanner);
                        break;
                    case 7:
                        agregarPromocion(scanner);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 8.");
                scanner.next(); // Consumir la entrada no válida
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar una película");
        System.out.println("2. Registrar una función en una sala");
        System.out.println("3. Mostrar la cartelera");
        System.out.println("4. Agregar una opinión de usuario sobre una película");
        System.out.println("5. Agregar un actor");
        System.out.println("6. Agregar un director");
        System.out.println("7. Agregar una promoción");
        System.out.println("8. Salir del programa");
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

        System.out.print("Ingrese el género de la película: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese el idioma original de la película: ");
        String idiomaOriginal = scanner.nextLine();

        System.out.print("¿La película tiene subtítulos en español? (s/n): ");
        boolean subtitulosEspanol = scanner.nextLine().equalsIgnoreCase("s");

        ArrayList<String> paisesOrigen = new ArrayList<>();
        System.out.print("Ingrese los países de origen de la película (separados por comas): ");
        String paisesStr = scanner.nextLine();
        for (String pais : paisesStr.split(",")) {
            paisesOrigen.add(pais.trim());
        }

        Pelicula pelicula = new Pelicula(titulo, duracion, clasificacion, fechaEstreno, genero, idiomaOriginal,
                subtitulosEspanol, paisesOrigen);

        // Agregar actores a la película
        System.out.print("¿Desea agregar actores a la película? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            boolean agregarMas = true;
            while (agregarMas) {
                System.out.print("Ingrese el nombre del actor: ");
                String nombreActor = scanner.nextLine();
                Actor actor = new Actor(nombreActor);
                pelicula.agregarActor(actor);
                System.out.print("¿Desea agregar otro actor? (s/n): ");
                respuesta = scanner.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");
            }
        }

        // Agregar directores a la película
        System.out.print("¿Desea agregar directores a la película? (s/n): ");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            boolean agregarMas = true;
            while (agregarMas) {
                System.out.print("Ingrese el nombre del director: ");
                String nombreDirector = scanner.nextLine();
                Director director = new Director(nombreDirector);
                pelicula.agregarDirector(director);
                System.out.print("¿Desea agregar otro director? (s/n): ");
                respuesta = scanner.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");
            }
        }

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

        // Agregar promociones a la función
        System.out.print("¿Desea agregar promociones a la función? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            boolean agregarMas = true;
            while (agregarMas) {
                System.out.print("Ingrese la descripción de la promoción: ");
                String descripcionPromocion = scanner.nextLine();
                Promocion promocion = new Promocion(descripcionPromocion);
                funcion.agregarPromocion(promocion);
                System.out.print("¿Desea agregar otra promoción? (s/n): ");
                respuesta = scanner.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");
            }
        }

        sala.agregarFuncion(funcion);
        System.out.println("Función registrada exitosamente.");
    }

    private static void mostrarCartelera() {
        if (cines.isEmpty()) {
            limpiarPantalla();
            System.out.println("No hay carteleras disponibles. Por favor, añada una cartelera.");
            return;
        }

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

    private static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla.");
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

    private static void agregarActor(Scanner scanner) {
        System.out.print("Ingrese el nombre del actor: ");
        String nombre = scanner.nextLine();
        while (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            System.out.print(
                    "El nombre del actor no puede ser nulo, vacío o contener caracteres especiales. Ingrese el nombre del actor: ");
            nombre = scanner.nextLine();
        }
        Actor actor = new Actor(nombre);
        actores.add(actor);
        System.out.println("Actor agregado exitosamente.");
    }

    private static void agregarDirector(Scanner scanner) {
        System.out.print("Ingrese el nombre del director: ");
        String nombre = scanner.nextLine();
        while (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            System.out.print(
                    "El nombre del director no puede ser nulo, vacío o contener caracteres especiales. Ingrese el nombre del director: ");
            nombre = scanner.nextLine();
        }
        Director director = new Director(nombre);
        directores.add(director);
        System.out.println("Director agregado exitosamente.");
    }

    private static void agregarPromocion(Scanner scanner) {
        System.out.print("Ingrese la descripción de la promoción: ");
        String descripcion = scanner.nextLine();
        while (descripcion == null || descripcion.isEmpty()) {
            System.out.print(
                    "La descripción de la promoción no puede ser nula o vacía. Ingrese la descripción de la promoción: ");
            descripcion = scanner.nextLine();
        }
        Promocion promocion = new Promocion(descripcion);
        promociones.add(promocion);
        System.out.println("Promoción agregada exitosamente.");
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
