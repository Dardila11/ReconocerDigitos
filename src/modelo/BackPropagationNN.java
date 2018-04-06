
package modelo;

import javax.swing.event.*;
import java.util.*;

public class BackPropagationNN extends RedNeuronal implements Runnable {

    /* Cargar los valores entrenados */
    public int tasaActual;
    //Lista enlazada para referencias
    private LinkedList listenerList;

    /* N�mero total de pasos */
    private int pasos;

    /* TestSets - se utiliza para ense�ar la red*/
    private TestPrueba tp;

    private int nEntradas;
    private int nSalidas;

    /**
     * Crear una nueva instancia de BackPropagationNN
     */
    public BackPropagationNN(int nInputs, int nHidden, int nOutputs) {
        super(nInputs, nHidden, nOutputs);

        this.nEntradas = nInputs;
        this.nSalidas = nOutputs;

        listenerList = new LinkedList();
    }

    public void addTest(int steps, TestPrueba ts) {
        this.pasos = steps;
        this.tp = ts;
    }

    //Establezca el n�mero de pasos para realizar mientras aprende
    public void setSteps(int steps) {
        this.pasos = steps;
    }

    // Agregar conjunto de casos espec�fico a la base de conocimiento de la red neuronal.
    public void addCaso(double[] inputs, double[] outputs) {

        if (tp == null) {
            tp = new TestPrueba(nEntradas, nSalidas);
        }

        this.tp.addTestPrueba(inputs, outputs);
    }

    public void run() {
        RealizarEntrenamiento(pasos, tp);
    }

    // Ense�e a la red y configure los pesos de las neuronas
    public void RealizarEntrenamiento(int steps, TestPrueba ts) {

        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < ts.getCount(); j++) {
                //avanzar a trav�s de la red (pass forward)
                procesoAdelante(ts.getInputsAt(j));
                //Cambio de pesos (pass back)
                PropagacionRed(ts.getOutputsAt(j));

            }
            EstadoCambiado();
            tasaActual = i;

            // Pausar hilo para volver a dibujar GUI
            try {
                Thread.sleep(1);
            } // Duerme el proceso un segundo para visualizar cambios
            catch (InterruptedException ex) {
            }
        }

    }

    // Iteraci�n de ense�anza  BackPropagations
    public void PropagacionRed(double[] target) {
        //optener los valores de inicio
        double[] delta_hidden = new double[numOcultas + 1];
        double[] delta_outputs = new double[numSalidas];

        // Obtenga el valor delta para la capa de salida
        for (int i = 0; i < numSalidas; i++) {
            delta_outputs[i] = salidas[i] * (1.0 - salidas[i]) * (target[i] - salidas[i]);
        }
        // Obtenga el valor delta para la capa oculta
        for (int i = 0; i < numOcultas + 1; i++) {
            double error = 0.0;
            for (int j = 0; j < numSalidas; j++) {
                error += pesosOcultaSalida[i][j] * delta_outputs[j];
            }
            delta_hidden[i] = ocultas[i] * (1.0 - ocultas[i]) * error;
        }
        // Ahora actualice los pesos entre la capa oculta y la de salida
        for (int i = 0; i < numSalidas; i++) {
            for (int j = 0; j < numOcultas + 1; j++) {
                pesosOcultaSalida[j][i] += learningRate * delta_outputs[i] * ocultas[j];
            }
        }
        // Ahora actualiza los pesos entre la entrada y la capa oculta
        for (int i = 0; i < numOcultas; i++) {
            for (int j = 0; j < numEntradas + 1; j++) {
                pesosEntradaOculta[j][i] += learningRate * delta_hidden[i] * entradas[j];
            }
        }
    }

    //Funci�n sigmoidea utilizada 
    public double FunSimuiD(double value) {
        return 1.0 / (1.0 + Math.pow(Math.E, -value));
    }

    public void addChangeListener(ChangeListener l) {
        listenerList.add(l);
    }

    protected void EstadoCambiado() {

        ChangeEvent event = new ChangeEvent(this);
        LinkedList listeners = listenerList;

        Iterator it = listeners.iterator();

        while (it.hasNext()) {
            Object o = it.next();
            ((ChangeListener) o).stateChanged(event);
        }
    }

    //Retorna el n�mero de casos de prueba en la base de conocimiento
    public int getNumCasoPrueba() {
        return this.tp.getCount();
    }

}
