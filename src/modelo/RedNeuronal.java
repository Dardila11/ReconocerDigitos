
package modelo;

import java.lang.Math;

public abstract class RedNeuronal extends Object implements NeuronaEntrenadora {

    /* Configuraci�n de red neuronal */
    protected int numEntradas;
    protected int numSalidas;
    protected int numOcultas;

    /* control del aprendizaje */
    protected double learningRate;

    /* Matrices para almacenar valores de redes neuronales*/
    public double[] entradas;
    public double[] salidas;
    public double[] ocultas;

    /* Arrays utilizados para almacenar coeficientes */
    public double[][] pesosEntradaOculta;
    public double[][] pesosOcultaSalida;
   

    /* Utilizado para almacenar error del coeficiente hallado anteriormente */
    public double error;

    public RedNeuronal(int nEntradas, int nOcultas, int nSalidas) {
        this.numEntradas = nEntradas;
        this.numOcultas = nOcultas;
        this.numSalidas = nSalidas;

        this.entradas = new double[nEntradas + 1];

        // sesgo    
        this.ocultas = new double[nOcultas + 1];
        this.salidas = new double[nSalidas];

        this.entradas[nEntradas] = 1.0;
        this.ocultas[nOcultas] = 1.0;

        this.pesosOcultaSalida = new double[nOcultas + 1][nSalidas];
        this.pesosEntradaOculta = new double[nEntradas + 1][nOcultas];

        // Establecer la tasa de aprendizaje predeterminada
        this.learningRate = 0.3;

        // Establecer pesos aleatorios
        pesosAleatorios();

    }

    /**
     * Genera pesos aleatorios para hiddenToOutput & inputToHidden entere <-2;2>
     */
    private void pesosAleatorios() {
        for (int i = 0; i < numEntradas + 1; i++) {
            for (int j = 0; j < numOcultas; j++) {
                pesosEntradaOculta[i][j] = Math.random() * 4.0 - 2.0; // peso aleatorio entre -2 y 2 
            }
        }
        for (int i = 0; i < numOcultas + 1; i++) {
            for (int j = 0; j < numSalidas; j++) {
                pesosOcultaSalida[i][j] = Math.random() * 4.0 - 2.0;
            }
        }

    }

    public int getNumEntradas() {
        return numEntradas;
    }
    public int getNumSalidas() {
        return numSalidas;
    }
    public int getNumOcultas() {
        return numOcultas;
    }
    public double getError() {
        return error;
    }

    

    public void procesoAdelante(double[] input) {

        for (int i = 0; i < numEntradas; i++) {
            entradas[i] = input[i];
        }

        for (int i = 0; i < numOcultas; i++) {
            double sum = 0.0;

            for (int j = 0; j < numEntradas; j++) {
                sum += entradas[j] * pesosEntradaOculta[j][i];
            }
            ocultas[i] = FunSimuiD(sum);
        }

        for (int i = 0; i < numSalidas; i++) {
            double sum = 0.0;
            for (int j = 0; j < numOcultas; j++) {
                sum += ocultas[j] * pesosOcultaSalida[j][i];
            }

            salidas[i] = FunSimuiD(sum);
        }

    }
}
