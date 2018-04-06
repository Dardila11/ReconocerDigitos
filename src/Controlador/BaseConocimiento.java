

package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import modelo.TestPrueba;

public class BaseConocimiento {

    /**
     * Clase responsable de almacenar datos para una estructura de un solo
     * digito
     */
    private class NeuronaDatos {

        private double[] entradas;
        // Literal valor
        private String valor;

        //Constructor por defecto 
        public NeuronaDatos(double[] inputs, String value) {
            this.entradas = inputs;
            this.valor = value;
        }

    }

    private int width = 0;
    private int height = 0;

    //  Numeros de salida de la neurona 2 a la 4 simbolos
    private static final int cantDigitos = 4;

    private TestPrueba knowledgeBase;

    /**
     * crear instancioas de BaseConocimiento
     */
    public BaseConocimiento() {
    }

    /**
     * Metodo responsable de cargar los datos desde el directorio. El directorio
     * tiene los datos para el entrenamiento
     *
     */
    public void load(String cat) {

        File f = new File("kb/" + cat + "/");

        //Cargar la ruta del archivo
        loadFileHeader(new File("kb/" + cat + "/0.txt"));

        // Crear e inicializar la BaseConocimiento
        knowledgeBase = new TestPrueba(width * height, cantDigitos);

        // 
        FileFilter ff = new FileFilter() {

            // se aceptan solo archivos con .ns extension
            public boolean accept(File f) {
                String name = f.getName();
                String extension = name.substring(name.indexOf(".") + 1);

                if (extension.equals("txt")) {
                    return true;
                }

                return false;
            }

            // Override metodo para la descripcion 
            public String getDescription() {
                return "Archivo de origen";
            }
        };

        // listar los archivos del directorio
        File[] fileList = f.listFiles(ff);

        try {
            for (int i = 0; i < fileList.length; i++) {

                // archivo actual
                String currentFile = fileList[i].getCanonicalPath();

                // Leer el archivo
                NeuronaDatos nd = this.readNerualSourceFile(currentFile);
                //Se agrega la info a Base de conocimiento
                knowledgeBase.addTestPrueba(nd.entradas, binaryDigit(nd.valor));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFileHeader(File f) {
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            // Obtener ancho y alto desde el archivo
            width = Integer.valueOf(br.readLine()).intValue();
            height = Integer.valueOf(br.readLine()).intValue();

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo utilizado para leer datos del archivo .text �nico
     *
     */
    public NeuronaDatos readNerualSourceFile(String fileName) {

        String record = null;
        int recCount = 0;

        String characterVal = "";

        double[] data;

        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            record = new String();

            // Leer informaci�n del archivo desde la cabeza
            width = Integer.valueOf(br.readLine()).intValue();
            height = Integer.valueOf(br.readLine()).intValue();
            characterVal = br.readLine();

            data = new double[width * height];

            // Leer datos l�nea por l�nea
            while ((record = br.readLine()) != null) {

                for (int i = 0; i < record.length(); i++) {
                    char ch = record.charAt(i);
                    String str = String.valueOf(ch);
                    data[recCount] = Double.parseDouble(str);
                    recCount++;
                }
            }

            // Crear un nuevo objeto NeuronaDatos
            NeuronaDatos nd = new NeuronaDatos(data, characterVal);
            return nd;

        } catch (IOException e) {
            // catch possible io errors from readLine()
            System.out.println("Lo siento,Error IOException!");
            e.printStackTrace();
        }
        return null;

    }

    public TestPrueba getKB() {
        return knowledgeBase;
    }

    public int getNumberOfInputs() {
        return width * height;
    }

    public int getNumberOfOutputs() {
        return this.cantDigitos;
    }

    //Convierte una representaci�n de cadena de decimal a n�mero binario 
    public double[] binaryDigit(String d) {

        Integer digit = Integer.valueOf(d);

        double output[] = new double[cantDigitos];

        for (int i = 0; i < cantDigitos; i++) {
            int rest = digit % 2;
            digit = digit / 2;
            output[i] = rest;
        }
        return output;
    }
}
