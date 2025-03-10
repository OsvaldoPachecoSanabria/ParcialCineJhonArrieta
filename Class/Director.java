public class Director {
    private String nombre;

    public Director(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre == "!"
                || nombre == "@" || nombre == "#" || nombre == "$"
                || nombre == "%" || nombre == "^" || nombre == "&"
                || nombre == "*" || nombre == "(" || nombre == ")"
                || nombre == "-" || nombre == "_" || nombre == "+"
                || nombre == "=" || nombre == "[" || nombre == "]"
                || nombre == "{" || nombre == "}" || nombre == ";"
                || nombre == ":" || nombre == "'" || nombre == "\"") {
            throw new IllegalArgumentException("El nombre del director no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre == "!"
                || nombre == "@" || nombre == "#" || nombre == "$"
                || nombre == "%" || nombre == "^" || nombre == "&"
                || nombre == "*" || nombre == "(" || nombre == ")"
                || nombre == "-" || nombre == "_" || nombre == "+"
                || nombre == "=" || nombre == "[" || nombre == "]"
                || nombre == "{" || nombre == "}" || nombre == ";"
                || nombre == ":" || nombre == "'" || nombre == "\"") {
            throw new IllegalArgumentException("El nombre del director no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
