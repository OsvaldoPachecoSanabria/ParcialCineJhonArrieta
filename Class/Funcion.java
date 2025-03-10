
import java.time.LocalDateTime;

public class Funcion {
    private Pelicula pelicula;
    private LocalDateTime horario;

    public Funcion(Pelicula pelicula, LocalDateTime horario) {
        this.pelicula = pelicula;
        this.horario = horario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "pelicula=" + pelicula +
                ", horario=" + horario +
                '}';
    }
}
