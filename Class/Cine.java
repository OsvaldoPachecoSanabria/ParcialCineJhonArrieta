public class Cine {
    private String nombre;

    public Cine(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre == "!"
                || nombre == "@" || nombre == "#" || nombre == "$"
                || nombre == "%" || nombre == "^" || nombre == "&"
                || nombre == "*" || nombre == "(" || nombre == ")"
                || nombre == "-" || nombre == "_" || nombre == "+"
                || nombre == "=" || nombre == "[" || nombre == "]"
                || nombre == "{" || nombre == "}" || nombre == ";"
                || nombre == ":" || nombre == "'" || nombre == "\"") {
            throw new IllegalArgumentException("El nombre del cine no puede ser nulo o vacío.");
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
            throw new IllegalArgumentException("El nombre del cine no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }
}
