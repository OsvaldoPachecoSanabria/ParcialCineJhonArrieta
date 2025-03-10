import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int duracion;
    private String clasificacion;
    private LocalDate fechaEstreno;
    private ArrayList<Opinion> opiniones;

    public Pelicula(String titulo, int duracion, String clasificacion, LocalDate fechaEstreno) {
        if (titulo == null || titulo.isEmpty() || titulo == "!"
                || titulo == "@" || titulo == "#" || titulo == "$"
                || titulo == "%" || titulo == "^" || titulo == "&"
                || titulo == "*" || titulo == "(" || titulo == ")"
                || titulo == "-" || titulo == "_" || titulo == "+"
                || titulo == "=" || titulo == "[" || titulo == "]"
                || titulo == "{" || titulo == "}" || titulo == ";"
                || titulo == ":" || titulo == "'" || titulo == "\"") {
            throw new IllegalArgumentException("El título de la película no puede ser nulo o vacío.");
        }
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración de la película debe ser mayor a 0.");
        }
        if (!clasificacion.equals("Apta todo público") && !clasificacion.equals("+9 años") &&
                !clasificacion.equals("+15 años") && !clasificacion.equals("+18 años")) {
            throw new IllegalArgumentException("Clasificación inválida.");
        }
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.fechaEstreno = fechaEstreno;
        this.opiniones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || titulo == "!"
                || titulo == "@" || titulo == "#" || titulo == "$"
                || titulo == "%" || titulo == "^" || titulo == "&"
                || titulo == "*" || titulo == "(" || titulo == ")"
                || titulo == "-" || titulo == "_" || titulo == "+"
                || titulo == "=" || titulo == "[" || titulo == "]"
                || titulo == "{" || titulo == "}" || titulo == ";"
                || titulo == ":" || titulo == "'" || titulo == "\"") {
            throw new IllegalArgumentException("El título de la película no puede ser nulo o vacío.");
        }
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración de la película debe ser mayor a 0.");
        }
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        if (!clasificacion.equals("Apta todo público") && !clasificacion.equals("+9 años") &&
                !clasificacion.equals("+15 años") && !clasificacion.equals("+18 años")) {
            throw new IllegalArgumentException("Clasificación inválida.");
        }
        this.clasificacion = clasificacion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }

    public void agregarOpinion(Opinion opinion) {
        this.opiniones.add(opinion);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                ", opiniones=" + opiniones +
                '}';
    }
}
