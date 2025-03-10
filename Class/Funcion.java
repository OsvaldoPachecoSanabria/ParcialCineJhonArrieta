import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcion {
    private Pelicula pelicula;
    private LocalDateTime horario;
    private ArrayList<Promocion> promociones;

    public Funcion(Pelicula pelicula, LocalDateTime horario) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.promociones = new ArrayList<>();
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

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

    public void agregarPromocion(Promocion promocion) {
        this.promociones.add(promocion);
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "pelicula=" + pelicula +
                ", horario=" + horario +
                ", promociones=" + promociones +
                '}';
    }
}
