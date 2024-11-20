import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\catss\\Desktop\\7mo\\Avina\\KNN\\KNN\\diabetes.csv";
        List<Punto> puntos = Dataset.loadData(filePath);
        
        
        KNN knn = new KNN(3);
        
        // Punto de prueba para predecir su clase
        //double[] detallesPrueba = {6, 148, 72, 35, 0, 33.6, 0.627, 50};
        double[] detallesPrueba = {1,85,66,29,0,26.6,0.351,31};
        Punto puntoPrueba = new Punto(detallesPrueba, ""); 

    
        // Realizar la predicción
        String clasePredicha = knn.predecirClase(puntos, puntoPrueba);
        System.out.println("La clase predicha para el punto de prueba es: " + clasePredicha);

        
    }
}
