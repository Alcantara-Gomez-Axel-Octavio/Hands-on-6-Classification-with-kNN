public class Punto {
    public double[] detalles;
    public String label;

    public Punto(double[] detalles, String label) {
        this.detalles = detalles;
        this.label = label;
    }

    public double[] getDetalles() {
        return detalles;
    }

    public String getLabel() {
        return label;
    }
}
