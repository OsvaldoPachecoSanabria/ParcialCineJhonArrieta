import java.util.ArrayList;

public class Cine {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Sala> salas;

    public Cine(String nombre, String direccion, String telefono) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException(
                    "El nombre del cine no puede ser nulo, vacío o contener caracteres especiales.");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección del cine no puede ser nula o vacía.");
        }
        if (telefono == null || telefono.isEmpty() || !telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "El teléfono del cine no puede ser nulo, vacío o contener caracteres no numéricos.");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección del cine no puede ser nula o vacía.");
        }
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty() || !telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "El teléfono del cine no puede ser nulo, vacío o contener caracteres no numéricos.");
        }
        this.telefono = telefono;
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
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", salas=" + salas +
                '}';
    }
}
