
import java.util.ArrayList;

public class Elenco {
    private ArrayList<Actor> actores;

    public Elenco() {
        this.actores = new ArrayList<>();
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    @Override
    public String toString() {
        return "Elenco{" +
                "actores=" + actores +
                '}';
    }
}
