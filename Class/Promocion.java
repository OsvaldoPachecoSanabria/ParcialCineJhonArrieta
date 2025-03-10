
public class Promocion {
    private String descripcion;

    public Promocion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción de la promoción no puede ser nula o vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción de la promoción no puede ser nula o vacía.");
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
