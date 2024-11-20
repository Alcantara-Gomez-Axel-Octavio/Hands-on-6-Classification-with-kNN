
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KNN {

    private int k;  // Número de vecinos más cercanos

    public KNN(int k) {
        this.k = k;
    }

    // Método para calcular la distancia euclidiana entre dos puntos
    private double calcularDistancia(double[] detalles1, double[] detalles2) {
        double suma = 0.0;
        for (int i = 0; i < detalles1.length; i++) {
            suma += Math.pow(detalles1[i] - detalles2[i], 2);
        }
        return Math.sqrt(suma);
    }

    // Método para obtener los k vecinos más cercanos
    private List<Punto> obtenerVecinosMasCercanos(List<Punto> puntos, Punto nuevoPunto) {
        List<Punto> vecinos = new ArrayList<>(puntos);

        // Ordenar la lista de puntos por distancia al nuevo punto
        vecinos.sort(Comparator.comparingDouble(p -> calcularDistancia(p.getDetalles(), nuevoPunto.getDetalles())));

        // Retornar los k vecinos más cercanos
        return vecinos.subList(0, k);
    }

    // Método para hacer una predicción de la clase del nuevo punto
    public String predecirClase(List<Punto> puntos, Punto nuevoPunto) {
        List<Punto> vecinosCercanos = obtenerVecinosMasCercanos(puntos, nuevoPunto);
        
        // Contar las etiquetas de los vecinos para encontrar la clase con mayoría
        int countClase1 = 0;
        int countClase0 = 0;
        for (Punto vecino : vecinosCercanos) {
            if (vecino.getLabel().equals("1")) {  // Compara con "1" para la clase positiva
                countClase1++;
            } else {
                countClase0++;
            }
        }
        
        // Retornar la clase con mayor cantidad de vecinos
        return (countClase1 > countClase0) ? "1" : "0";
    }
}
