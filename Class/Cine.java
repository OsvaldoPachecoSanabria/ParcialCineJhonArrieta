import java.util.ArrayList;

public class Cine {
    private String nombre;
    private ArrayList<Sala> salas;

    public Cine(String nombre) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException(
                    "El nombre del cine no puede ser nulo, vacío o contener caracteres especiales.");
        }
        this.nombre = nombre;
        this.salas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException(
                    "El nombre del cine no puede ser nulo, vacío o contener caracteres especiales.");
        }
        this.nombre = nombre;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void agregarSala(Sala sala) {
        this.salas.add(sala);
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", salas=" + salas +
                '}';
    }
}
