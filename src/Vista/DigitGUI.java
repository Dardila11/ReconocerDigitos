
package Vista;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import Controlador.BaseConocimiento;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import modelo.BackPropagationNN;


public class DigitGUI extends javax.swing.JFrame implements ChangeListener {
    
    // N�mero predeterminado de pasos para cada entrenamiento
    private int totalPasos = 10000;
    
    // Tecnica de aprendizaje basada en BackPropagations
    private BackPropagationNN nn;
    
    // Referencia a Knowledge Base responsable de leer los datos de d�gitos del archivo
    private BaseConocimiento kb;
    
    // Determina si la aplicaci�n est� en estado de reinicio ( no hay datos cargados en la estructura de la red neuronal )
    private boolean reset;
    
    /** Crea un nuevo formulario DigitGUI */
    public DigitGUI() {
        initComponents();
        barra_progreso.setVisible(false);
        barra_progreso.setMinimum(0);
        barra_progreso.setMaximum(100);
        barra_progreso.setStringPainted(true);

        // Set Reset state and disable given buttons
        updateBotones(true);

        //Establecer un nuevo estilo de representaci�n para componentes JTable
        for (int icol = 0; icol < 5; icol++) {
            TableColumn col = this.testDataTable.getColumnModel().getColumn(icol);
            col.setCellRenderer(new TablaNumeros());

            col = this.tbl_Datos.getColumnModel().getColumn(icol);
            col.setCellRenderer(new TablaNumeros());
        }

    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbl_Panel = new javax.swing.JTabbedPane();
        pnl_entrenar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barra_progreso = new javax.swing.JProgressBar();
        btn_Entrenar = new javax.swing.JButton();
        btn_cargarN = new javax.swing.JButton();
        lbl_Entrenamiento = new javax.swing.JLabel();
        lbl_Niteraciones = new javax.swing.JLabel();
        lbl_capasOcultas = new javax.swing.JLabel();
        pnl_prueba = new javax.swing.JPanel();
        testDataPane = new javax.swing.JScrollPane();
        testDataTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        recognizedDigit = new javax.swing.JLabel();
        btn_Reconocer = new javax.swing.JButton();
        recognizeStatusLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        pnl_agregar_patron = new javax.swing.JPanel();
        tbl_Datos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numeroCaso = new javax.swing.JComboBox();
        btn_caso = new javax.swing.JButton();
        btn_reiniciar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        numberOfCasesLabel = new javax.swing.JLabel();
        bnt_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Valores Entrenados"); // NOI18N

        jLabel2.setText("Numero de Iteraciones"); // NOI18N

        jLabel3.setText("Capas ocultas"); // NOI18N

        btn_Entrenar.setText("Start"); // NOI18N
        btn_Entrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EntrenarActionPerformed(evt);
            }
        });

        btn_cargarN.setText("Cargar digitos (0-9)"); // NOI18N
        btn_cargarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarNActionPerformed(evt);
            }
        });

        lbl_Entrenamiento.setText("0"); // NOI18N

        lbl_Niteraciones.setText("0"); // NOI18N

        lbl_capasOcultas.setText("0"); // NOI18N

        org.jdesktop.layout.GroupLayout pnl_entrenarLayout = new org.jdesktop.layout.GroupLayout(pnl_entrenar);
        pnl_entrenar.setLayout(pnl_entrenarLayout);
        pnl_entrenarLayout.setHorizontalGroup(
            pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_entrenarLayout.createSequentialGroup()
                .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_entrenarLayout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel3))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(pnl_entrenarLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnl_entrenarLayout.createSequentialGroup()
                                .add(btn_Entrenar)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(barra_progreso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))))
                .addContainerGap())
            .add(pnl_entrenarLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btn_cargarN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnl_entrenarLayout.createSequentialGroup()
                        .add(jLabel1)
                        .add(60, 60, 60)
                        .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lbl_Entrenamiento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .add(lbl_Niteraciones, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lbl_capasOcultas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_entrenarLayout.setVerticalGroup(
            pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_entrenarLayout.createSequentialGroup()
                .add(17, 17, 17)
                .add(btn_cargarN)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(lbl_Entrenamiento))
                .add(13, 13, 13)
                .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(lbl_Niteraciones))
                .add(16, 16, 16)
                .add(pnl_entrenarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(lbl_capasOcultas))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 49, Short.MAX_VALUE)
                .add(btn_Entrenar)
                .add(32, 32, 32)
                .add(barra_progreso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbl_Panel.addTab("Entrenar", pnl_entrenar);

        testDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)},
                { new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false),  new Boolean(false)}
            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        testDataTable.setShowHorizontalLines(false);
        testDataTable.setShowVerticalLines(false);
        testDataPane.setViewportView(testDataTable);

        jLabel4.setText("Digito Reconocido"); // NOI18N

        recognizedDigit.setFont(new java.awt.Font("Arial Narrow", 0, 48)); // NOI18N
        recognizedDigit.setText("?"); // NOI18N

        btn_Reconocer.setText("Reconocer"); // NOI18N
        btn_Reconocer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReconocerActionPerformed(evt);
            }
        });

        recognizeStatusLabel.setForeground(new java.awt.Color(204, 0, 0));
        recognizeStatusLabel.setText("La red debe ser entrenada antes de realizar el reconocimiento"); // NOI18N

        jLabel8.setText("entrada"); // NOI18N

        btn_limpiar.setText("Borrar"); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnl_pruebaLayout = new org.jdesktop.layout.GroupLayout(pnl_prueba);
        pnl_prueba.setLayout(pnl_pruebaLayout);
        pnl_pruebaLayout.setHorizontalGroup(
            pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_pruebaLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_pruebaLayout.createSequentialGroup()
                        .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(pnl_pruebaLayout.createSequentialGroup()
                                .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, btn_limpiar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, testDataPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .add(55, 55, 55)
                                .add(btn_Reconocer)))
                        .add(61, 61, 61)
                        .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(recognizedDigit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4)))
                    .add(recognizeStatusLabel))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        pnl_pruebaLayout.setVerticalGroup(
            pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_pruebaLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnl_pruebaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btn_Reconocer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(recognizedDigit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(testDataPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btn_limpiar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                .add(recognizeStatusLabel))
        );

        tbl_Panel.addTab("Prueba", pnl_prueba);

        tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Datos.setColumnSelectionAllowed(true);

        jLabel5.setText("Caso de prueba:"); // NOI18N

        jLabel6.setText("Resultado"); // NOI18N

        numeroCaso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        numeroCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroCasoActionPerformed(evt);
            }
        });

        btn_caso.setText("Agregar"); // NOI18N
        btn_caso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_casoActionPerformed(evt);
            }
        });

        btn_reiniciar.setText("Reiniciar"); // NOI18N
        btn_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reiniciarActionPerformed(evt);
            }
        });

        jLabel7.setText("N Casos de prueba:"); // NOI18N

        numberOfCasesLabel.setText("0"); // NOI18N

        bnt_limpiar.setText("Clear"); // NOI18N
        bnt_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_limpiarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnl_agregar_patronLayout = new org.jdesktop.layout.GroupLayout(pnl_agregar_patron);
        pnl_agregar_patron.setLayout(pnl_agregar_patronLayout);
        pnl_agregar_patronLayout.setHorizontalGroup(
            pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_agregar_patronLayout.createSequentialGroup()
                .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_agregar_patronLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(bnt_limpiar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .add(68, 68, 68))
                    .add(pnl_agregar_patronLayout.createSequentialGroup()
                        .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnl_agregar_patronLayout.createSequentialGroup()
                                .add(22, 22, 22)
                                .add(jLabel5))
                            .add(pnl_agregar_patronLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(tbl_Datos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(pnl_agregar_patronLayout.createSequentialGroup()
                        .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnl_agregar_patronLayout.createSequentialGroup()
                                .add(jLabel7)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(numberOfCasesLabel))
                            .add(numeroCaso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(28, 28, 28)
                        .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btn_reiniciar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .add(btn_caso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                .addContainerGap(118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnl_agregar_patronLayout.setVerticalGroup(
            pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_agregar_patronLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_agregar_patronLayout.createSequentialGroup()
                        .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(numeroCaso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btn_caso))
                        .add(17, 17, 17)
                        .add(pnl_agregar_patronLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(numberOfCasesLabel)
                            .add(btn_reiniciar)))
                    .add(tbl_Datos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bnt_limpiar)
                .add(38, 38, 38))
        );

        tbl_Datos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tbl_Datos.getColumnModel().getColumnCount() > 0) {
            tbl_Datos.getColumnModel().getColumn(0).setHeaderValue("");
            tbl_Datos.getColumnModel().getColumn(1).setHeaderValue("");
            tbl_Datos.getColumnModel().getColumn(2).setHeaderValue("");
            tbl_Datos.getColumnModel().getColumn(3).setHeaderValue("");
            tbl_Datos.getColumnModel().getColumn(4).setHeaderValue("");
        }

        tbl_Panel.addTab("Agregar Patron", pnl_agregar_patron);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(tbl_Panel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tbl_Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 274, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Cargar archivos responsables de ense�ar d�gitos decimales */
    private void btn_cargarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarNActionPerformed
        bnt_limpiarActionPerformed(evt);
        this.load("dec");
    }//GEN-LAST:event_btn_cargarNActionPerformed

    private void btn_EntrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EntrenarActionPerformed
        // Crear un nuevo hilo para el proceso de ense�anza
        Thread t = new Thread(nn);
        t.start(); // run thread

        updateLabels();
        this.recognizeButtonActivation(true);
    }//GEN-LAST:event_btn_EntrenarActionPerformed

    /****** Rutinas de manejo *******************************************/
    
    private void bnt_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_limpiarActionPerformed
        TableModel tm = this.tbl_Datos.getModel();

        for( int  col = 0; col < tbl_Datos.getColumnCount(); col++)
        for ( int row = 0; row < tbl_Datos.getRowCount(); row++ )
        tm.setValueAt(new Boolean(false), row, col);
    }//GEN-LAST:event_bnt_limpiarActionPerformed

    /** Ejecutar mientras se presiona el bot�n limpiar*/
    private void btn_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reiniciarActionPerformed

        numberOfCasesLabel.setText("0");
        lbl_capasOcultas.setText("0");
        lbl_Entrenamiento.setText("0");
        updateBotones(true);

        bnt_limpiar.doClick();
        btn_limpiar.doClick();
    }//GEN-LAST:event_btn_reiniciarActionPerformed


    private void btn_casoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_casoActionPerformed

        // If the neural network is not constructed then create it
        if (reset) {
            kb = new BaseConocimiento();
            kb.load("dec");
            /*String ruta = "///kb/dec/archivo.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            try {
                if (archivo.exists()) {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("El fichero de texto ya estaba creado.");
                } else {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("Acabo de crear el fichero de texto.");
                }
                bw.close();
            } catch (Exception e) {
            }*/
            nn = new BackPropagationNN(kb.getNumberOfInputs(), kb.getNumberOfInputs(), kb.getNumberOfOutputs());
        }

        double[] inputs = new double[kb.getNumberOfInputs()];

        int pos = 0;

        //Agregar nuevos caso caseDataTable (JTable)
        for (int irow = 0; irow < tbl_Datos.getRowCount(); irow++) {
            for (int icol = 0; icol < tbl_Datos.getColumnCount(); icol++) {
                Boolean value = (Boolean) this.tbl_Datos.getModel().getValueAt(irow, icol);
                boolean val = value.booleanValue();
                inputs[pos] = getDouble(val);
                pos++;
            }
        }

        double[] outputs = kb.binaryDigit((String) numeroCaso.getSelectedItem());

        // Configuraci�n de red neuronal
        nn.setSteps(totalPasos);
        nn.addCaso(inputs, outputs);

        // Detertar cambios
        nn.addChangeListener(this);

        updateBotones(false);
        updateLabels();
        this.recognizeButtonActivation(false);
    }//GEN-LAST:event_btn_casoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        TableModel tm = this.testDataTable.getModel();

        for( int  col = 0; col < testDataTable.getColumnCount(); col++)
        for ( int row = 0; row < testDataTable.getRowCount(); row++ )
        tm.setValueAt(new Boolean(false), row, col);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_ReconocerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReconocerActionPerformed

        double[] inputs = new double[kb.getNumberOfInputs()];

        int pos = 0;

        /**
         * optener los datos de Jtable y guardarlos en la matriz
         */
        for (int irow = 0; irow < testDataTable.getRowCount(); irow++) {
            for (int icol = 0; icol < testDataTable.getColumnCount(); icol++) {
                Boolean value = (Boolean) this.testDataTable.getModel().getValueAt(irow, icol);
                boolean val = value.booleanValue();
                inputs[pos] = getDouble(val);
                pos++;
            }
        }

        nn.procesoAdelante(inputs);

        /**
         * D�gito reconocido de salida
         */
        this.recognizedDigit.setText(String.valueOf(getDigit(nn.salidas)));
    }//GEN-LAST:event_btn_ReconocerActionPerformed

    private void numeroCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroCasoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroCasoActionPerformed

   
   
    
    
   
    private void load( String cat  ) {
        if ( reset ) {
                      
            kb = new BaseConocimiento();
            kb.load(cat);

            nn = new BackPropagationNN(kb.getNumberOfInputs(), kb.getNumberOfInputs(), kb.getNumberOfOutputs());
            nn.addChangeListener(this);
            nn.addTest(totalPasos, kb.getKB() );
       
            updateBotones(false);
            recognizeButtonActivation(false);
            updateLabels();
        }          
    }
    
    private void updateLabels() {
            this.lbl_Entrenamiento.setText(String.valueOf(nn.getNumCasoPrueba())  );           
            this.lbl_capasOcultas.setText(String.valueOf(nn.getNumOcultas()));
            this.numberOfCasesLabel.setText(String.valueOf(nn.getNumCasoPrueba() ) );
    }
    
    //Los botones de actualizaci�n se basan en la bandera de reinicio
    
    private void updateBotones(boolean value) {
        this.reset = value;
        btn_Reconocer.setEnabled(!reset);
        btn_Entrenar.setEnabled(!reset);
        btn_reiniciar.setEnabled(!reset);
    }
    
    /** Routine responsbile for managing state of "Recognize" button
     *  state boolean State deciding whether button is enabled or disabled
     */
    private void recognizeButtonActivation( boolean state ) {
        btn_Reconocer.setEnabled( state );
        
        if ( state ) {
            this.recognizeStatusLabel.setText("");
        } else {
            this.recognizeStatusLabel.setText("La red debe ser entrenada antes de realizar el reconocimiento");
        }
    }
    
    public void stateChanged( ChangeEvent e ) {
        
        // Calculate progreso
        int progreso = (int) ( ( ( 1.0 * ( nn.tasaActual + 2 ) / totalPasos ) ) * 100.0 ) ;
        
        // Establecer el valor actual de entrenamiento
        barra_progreso.setValue(progreso );
        barra_progreso.setString(String.valueOf(progreso ) + "%" );
        
       // this.lbl_Niteraciones.setText(String.valueOf(nn.cPasaActual+ 2) );
        this.lbl_Niteraciones.setText(String.valueOf(nn.tasaActual + 2));
        if(lbl_Niteraciones.getText().equals("10000")){
            JOptionPane.showMessageDialog(rootPane, "Carga finalizada!");
        }
    }     
    
   
    public double getDouble(boolean value ) {
        if ( value )
            return 1.0;
        
        return 0.0;
    }
    
    
    public int getDigit( double [] outputs ) {
        
        int value = 0;
        
        //Conversi�n de Bin a Int
        for ( int i = 0; i < 4; i++ ) {
            value += Math.round(outputs[i]) * Math.pow(2, i);
        }
        
        return value;
    }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra_progreso;
    private javax.swing.JButton bnt_limpiar;
    private javax.swing.JButton btn_Entrenar;
    private javax.swing.JButton btn_Reconocer;
    private javax.swing.JButton btn_cargarN;
    private javax.swing.JButton btn_caso;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_reiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_Entrenamiento;
    private javax.swing.JLabel lbl_Niteraciones;
    private javax.swing.JLabel lbl_capasOcultas;
    private javax.swing.JLabel numberOfCasesLabel;
    private javax.swing.JComboBox numeroCaso;
    private javax.swing.JPanel pnl_agregar_patron;
    private javax.swing.JPanel pnl_entrenar;
    private javax.swing.JPanel pnl_prueba;
    private javax.swing.JLabel recognizeStatusLabel;
    private javax.swing.JLabel recognizedDigit;
    private javax.swing.JTable tbl_Datos;
    private javax.swing.JTabbedPane tbl_Panel;
    private javax.swing.JScrollPane testDataPane;
    private javax.swing.JTable testDataTable;
    // End of variables declaration//GEN-END:variables
    
}
