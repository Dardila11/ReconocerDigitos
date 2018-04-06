package modelo;

//Interfaz de red neuronal que define las operaciones basicas
public interface NeuronaEntrenadora {

    public double FunSimuiD(double val);

    public void PropagacionRed(double[] target);

    public void RealizarEntrenamiento(int steps, TestPrueba ts);
}
