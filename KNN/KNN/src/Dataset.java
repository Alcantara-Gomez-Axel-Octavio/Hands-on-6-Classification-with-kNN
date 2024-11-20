import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dataset {
    public static List<String> headers = new ArrayList<>();  // Almacena los encabezados del CSV

    public static List<Punto> loadData(String filePath) {
        List<Punto> puntos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Omitir la primera línea (encabezado)
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Última columna como etiqueta, el resto como detalles
                double[] detalles = new double[values.length - 1];
                for (int i = 0; i < values.length - 1; i++) {
                    detalles[i] = Double.parseDouble(values[i]);
                }
                
                String label = values[values.length - 1]; // Etiqueta
                puntos.add(new Punto(detalles, label));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puntos;
    }
    


    // Método para imprimir los datos cargados con encabezado
    public static void printData(List<Punto> Puntos) {

        if (Puntos.isEmpty()) {
            System.out.println("No se han cargado datos.");
            return;
        }

        // Imprimir encabezado
        for (String header : headers) {
            System.out.print(header + "\t");
        }

        System.out.println();

        // Imprimir los valores de cada Punto
        for (Punto point : Puntos) {
           
            System.out.print(point.getLabel() + "\t");  // Imprime la etiqueta (is_genuine)
            for (double detalle : point.getDetalles()) {
                System.out.print(detalle + "\t");
            }
            System.out.println();
        }
    }
}
