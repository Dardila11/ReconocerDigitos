
package modelo;

public class TestPrueba {

    //Cantidad de entradas */
    private int cantIn;

    //Cantidad de salidad 
    private int cantOut;

    // Numero de elementos en el conjunto 
    private int count;

    /* almacena los conjuntos */
    private java.util.Vector<Set> sets;

    private class Set {

        private int cantIn;
        // private int nIn;
        private int cantOut;
        //private int nOut;

        private double[] inputs;
        private double[] outputs;

        public Set(int cantIn, int cantOut) {
            inputs = new double[cantIn];
            outputs = new double[cantOut];
        }
    }

    public TestPrueba(int nIn, int nOut) {
        this.cantIn = nIn;
        this.cantOut = nOut;
        count = 0;
        sets = new java.util.Vector();
    }

    public void addTestPrueba(double[] inputs, double[] outputs) {
        Set s = new Set(cantIn, cantOut);
        s.inputs = inputs;
        s.outputs = outputs;
        sets.add(s);
        count++;
    }

    public int getCount() {
        return this.count;
    }

    public double[] getInputsAt(int pos) {
        return ((Set) sets.get(pos)).inputs;
    }

    public double[] getOutputsAt(int pos) {
        return ((Set) sets.get(pos)).outputs;
    }

}
