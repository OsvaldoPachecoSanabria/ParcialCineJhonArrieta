
public class Actor {
    private String nombre;

    public Actor(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del actor no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del actor no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
