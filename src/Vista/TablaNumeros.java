

package Vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Clase responsable del Jtable que se encarga de visualziar el numero en
 * pantalla
 */
public class TablaNumeros extends JLabel implements TableCellRenderer {
    // Este m�todo se llama cada vez que una celda en una columna

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        //  el valor contendio en la celda es (rowIndex, vColIndex)
        this.setOpaque(true);

        if (value != null) {
            Boolean val = (Boolean) value;
            if (val.booleanValue()) {
                this.setBackground(new Color(0, 0, 0));
            } else {
                this.setBackground(new Color(255, 255, 255));
            }
        } else {
            this.setBackground(new Color(255, 255, 255));
        }

        // como la tabla optiene los valores se necesita retornarlos
        return this;
    }
}
