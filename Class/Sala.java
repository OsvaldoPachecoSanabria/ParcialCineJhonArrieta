import java.util.ArrayList;

public class Sala {
    private int numero;
    private int capacidad;
    private ArrayList<Funcion> funciones;

    public Sala(int numero, int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad de la sala debe ser mayor a 0.");
        }
        this.numero = numero;
        this.capacidad = capacidad;
        this.funciones = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad de la sala debe ser mayor a 0.");
        }
        this.capacidad = capacidad;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    public void agregarFuncion(Funcion funcion) {
        this.funciones.add(funcion);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numero=" + numero +
                ", capacidad=" + capacidad +
                ", funciones=" + funciones +
                '}';
    }
}
