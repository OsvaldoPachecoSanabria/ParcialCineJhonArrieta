import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int duracion;
    private String clasificacion;
    private LocalDate fechaEstreno;
    private String genero;
    private String idiomaOriginal;
    private boolean subtitulosEspanol;
    private ArrayList<String> paisesOrigen;
    private ArrayList<Opinion> opiniones;
    private ArrayList<Actor> elenco;
    private ArrayList<Director> directores;

    public Pelicula(String titulo, int duracion, String clasificacion, LocalDate fechaEstreno, String genero,
            String idiomaOriginal, boolean subtitulosEspanol, ArrayList<String> paisesOrigen) {
        if (titulo == null || titulo.isEmpty()) {
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
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;
        this.subtitulosEspanol = subtitulosEspanol;
        this.paisesOrigen = paisesOrigen;
        this.opiniones = new ArrayList<>();
        this.elenco = new ArrayList<>();
        this.directores = new ArrayList<>();
    }

    // Getters y setters para los nuevos atributos
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public boolean isSubtitulosEspanol() {
        return subtitulosEspanol;
    }

    public void setSubtitulosEspanol(boolean subtitulosEspanol) {
        this.subtitulosEspanol = subtitulosEspanol;
    }

    public ArrayList<String> getPaisesOrigen() {
        return paisesOrigen;
    }

    public void setPaisesOrigen(ArrayList<String> paisesOrigen) {
        this.paisesOrigen = paisesOrigen;
    }

    // Métodos existentes
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
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

    public ArrayList<Actor> getElenco() {
        return elenco;
    }

    public void agregarActor(Actor actor) {
        this.elenco.add(actor);
    }

    public ArrayList<Director> getDirectores() {
        return directores;
    }

    public void agregarDirector(Director director) {
        this.directores.add(director);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                ", genero='" + genero + '\'' +
                ", idiomaOriginal='" + idiomaOriginal + '\'' +
                ", subtitulosEspanol=" + subtitulosEspanol +
                ", paisesOrigen=" + paisesOrigen +
                ", opiniones=" + opiniones +
                ", elenco=" + elenco +
                ", directores=" + directores +
                '}';
    }
}
