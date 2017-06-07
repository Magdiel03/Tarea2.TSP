package clases;

import static clases.Permutacion.generar_vecino;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) {
        //leer un TXT
        TSP tsp;
        tsp = new TSP();
        //LLama a la funcion creada en otra clase para poder leer archivos 
        archivos a = new archivos();
        // se copia la ruta del archivo donde esta guerdado en este caso el tsp fue modificado y llamado prueba y se encuentra en el escritorio 
        String s1 = a.leerTxt("C:\\Users\\Magdiel\\Desktop\\prueba.txt");

        StringTokenizer string = new StringTokenizer(s1, "#");
        int totalDatos = string.countTokens();
        String[] datos = new String[totalDatos];
        //int i=0;
        while (string.hasMoreTokens()) {
            String str = string.nextToken();
            // encuentra el nombre y lo agrega a una nueva variable    
            if (str.equals("NAME: ")) {
                String str2 = string.nextToken();
                System.out.println("Nombre de archivo: " + str2);
                tsp.setName(str2);
            }
            // guardamos el tipo  
            if (str.equals("TYPE: ")) {
                String str3 = string.nextToken();
                System.out.println("Tipo del archivo: " + str3);
                tsp.setType(str3);
            }

            if (str.equals("COMMENT: ")) {
                String str4 = string.nextToken();
                System.out.println("Comentario: " + str4);
                tsp.setComment(str4);
            }

            if (str.equals("DIMENSION: ")) {
                String str5 = string.nextToken();
                System.out.println("Dimension: " + str5);
                tsp.setDimension(str5);
            }

            if (str.equals("EDGE_WEIGHT_TYPE: ")) {
                String str6 = string.nextToken();
                System.out.println("EDGE_WEIGHT_TYPE: " + str6);
                tsp.setEdgeWeightType(str6);
            }

            if (str.equals("EDGE_WEIGHT_FORMAT: ")) {
                String str7 = string.nextToken();
                System.out.println("EDGE_WEIGHT_FORMAT:" + str7);
                tsp.setEdgeWeightFormat(str7);
            }

            if (str.equals("DISPLAY_DATA_TYPE: ")) {
                String str8 = string.nextToken();
                System.out.println("DISPLAY_DATA_TYPE : " + str8);
                tsp.setDisplayDataType(str8);
            }
            //Para la Matriz
            if (str.equals("EDGE_WEIGHT_SECTION")) {
                String str9 = string.nextToken();
                double[][] distancia = new double[29][29];
                StringTokenizer nuevo = new StringTokenizer(str9);
                for (int x = 0; x < distancia.length; x++) {
                    for (int y = 0; y < distancia[x].length; y++) {
                        //System.out.print(nuevo.nextToken()+ " ");
                        distancia[x][y] = Double.parseDouble(nuevo.nextToken());
                    }
                    //System.out.println(); 
                }

                //System.out.println(distancia[28][28]);
                //Pruebas
                tsp.setDistancia(distancia);
                double m[][] = tsp.getDistancia();
                //System.out.println(m[0][1]); esta fue una prueba
               
                // Generar caminos aleatorios 
                int valor = 0;
                int[] ciudadesoriginal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
                // MUESTRA LA MATRIZ CON LAS REINAS ORIGINALES PARA LAS CUALES SE BUSCARAN EL VECINO     
                int[] nuevaruta = ciudadesoriginal;
                System.out.println("ruta original: " + Arrays.toString(nuevaruta));
                //SE PIDE POR PANTALLAS LOS VECINOS QUE QUIERE GENERAR 
                int n;
                System.out.println("Por favor introduzca la cantidad de permutaciones a generar");
                Scanner lector = new Scanner(System.in);
                n = lector.nextInt();
                for (int i = 0; i < n; i++) {
                    generar_vecino(nuevaruta);
                    // FINALMENTE SE MUESTRAN TODOS LOS VECINOS GENERADOS 
                    System.out.println("Permutacion: " + Arrays.toString(nuevaruta));
                    // System.out.println("Permutacion: " + (nuevaruta[1]));
                }
                // Generamos el costo 

                double suma = 0;
                //  System.out.println(""+nuevaruta.length);
                //System.out.println(""+m[0].length);
                int i = 0;
                while (i < nuevaruta.length - 1) {
                    int calculo1 = nuevaruta[i + 1] - 1;
                    int calculo2 = nuevaruta[i] - 1;
                    double calculocosto = m[calculo1][calculo2];
                    suma = suma + calculocosto;
                    i++;
                }
                // Entrega el costo 
                System.out.println("El costo total es ; " + suma);

            }
        }
    }
}
