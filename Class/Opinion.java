
public class Opinion {
    private String comentario;
    private String calificacion;

    public Opinion(String comentario, String calificacion) {
        if (calificacion == null || calificacion.isEmpty() ||
                (!calificacion.equals("Obra Maestra") && !calificacion.equals("Muy Buena") &&
                        !calificacion.equals("Buena") && !calificacion.equals("Regular") &&
                        !calificacion.equals("Mala"))) {
            throw new IllegalArgumentException("Calificación inválida.");
        }
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        if (calificacion == null || calificacion.isEmpty() ||
                (!calificacion.equals("Obra Maestra") && !calificacion.equals("Muy Buena") &&
                        !calificacion.equals("Buena") && !calificacion.equals("Regular") &&
                        !calificacion.equals("Mala"))) {
            throw new IllegalArgumentException("Calificación inválida.");
        }
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "comentario='" + comentario + '\'' +
                ", calificacion='" + calificacion + '\'' +
                '}';
    }
}
