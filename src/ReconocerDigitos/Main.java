

package ReconocerDigitos;

import Controlador.BaseConocimiento;
import modelo.BackPropagationNN;
import modelo.TestPrueba;
import Vista.DigitGUI;


public class Main {
    
   
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DigitGUI().setVisible(true);
            }
        });
    }
    
}
