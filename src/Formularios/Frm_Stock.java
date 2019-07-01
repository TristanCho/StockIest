package Formularios;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import logica.Cls_Stock;

public class Frm_Stock extends javax.swing.JFrame {

    private final Cls_Stock CS;
    int num = 0;

    public Frm_Stock() {
        initComponents();
        CS = new Cls_Stock();
        listar();
        this.setLocationRelativeTo(null);

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/monster.png"));

        return retValue;
    }

    private void listar() {
        jtb_datos.setModel(CS.getDatos());
    }

    private void limpiar() {
        jta_observaciones.setText("");
        jtf_serie.setText("");
        jtf_mac.setText("");
        jcb_huellaSi.setSelected(false);
        jcb_huellaNo.setSelected(false);
        jcb_proximidad.setSelectedIndex(0);
        jcb_releSi.setSelected(false);
        jcb_releNo.setSelected(false);
        jcb_tecnico.setSelectedIndex(0);
        jcb_estadoCorrecto.setSelected(false);
        jcb_estadoAveriado.setSelected(false);
        jcb_fabricante.setSelectedIndex(0);
        jcb_modelo.setSelectedIndex(0);
        jlb_info.setText("");
        jcb_fabricante.requestFocus();

    }

    private void guardar() {

        String fabricante = jcb_fabricante.getSelectedItem().toString();
        String modelo = jcb_modelo.getSelectedItem().toString();
        String serie = jtf_serie.getText();
        String mac = jtf_mac.getText();
        String huella = null;
        String proximidad = jcb_proximidad.getSelectedItem().toString();
        String rele = null;
        String tecnico = jcb_tecnico.getSelectedItem().toString();
        String estado = null;
        String observaciones = jta_observaciones.getText();

        if (jcb_huellaSi.isSelected()) {
            jcb_huellaNo.setSelected(false);
            huella = "Si";
        } 
        else if(jcb_huellaNo.isSelected()) {
            jcb_huellaSi.setSelected(false);
            huella = "No";
        }else{
               JOptionPane.showMessageDialog(null, "Revise Huella");
                num = 1;
                }

        if (jcb_huellaNo.isSelected()) {
            jcb_huellaSi.setSelected(false);
            huella = "No";
        } else if(jcb_releSi.isSelected()){
            jcb_releNo.setSelected(false);
            rele = "Si";
        }       
         else {
            JOptionPane.showMessageDialog(null, "Revise Huella");
                num = 1;
        }
        if (jcb_releNo.isSelected()) {
            jcb_releSi.setSelected(false);
            rele = "No";
        } else {
        }
        if (jcb_estadoCorrecto.isSelected()) {
            jcb_estadoAveriado.setSelected(false);
            estado = "Correcto";
        } else {
        }
        if (jcb_estadoAveriado.isSelected()) {
            jcb_estadoCorrecto.setSelected(false);
            estado = "Averiado";
        } else {
        }

        switch (fabricante) {
            case "Seleccione Fabricante":
                JOptionPane.showMessageDialog(null, "Seleccione un Fabricante");
                num = 1;
                break;
        }

        switch (modelo) {
            case "Seleccione Modelo":
                JOptionPane.showMessageDialog(null, "Seleccione un Modelo");
                num = 1;// con cero se hace update y con 1 NO se hace
                //limpiar();
                listar();
                break;

            case "ML-7":
            case "ML-10":
            case "ML-15":
            case "ML-20":
            case "ML-900":
            case "Benzing 9320":
            case "Benzing Time":
            case "B-ECO":
            case "Bedanet 9320":
            case "Bedanet 9510":
            case "B-net 9320":
            case "BioStation L2":
            case "BioEntry Plus":
            case "BioLiteSolo":
            case "BioEntry W":
            case "BioLiteNet":
            case "SECURE I/O":
            case "BSM-OC":
            case "D-STATION":
            case "XPASS SLIM":
            case "BioPad Android":
            case "UA-400":
            case "iCLOCK 560":

                //JOptionPane.showMessageDialog(null, "coincide con modelos");// cambiar por mensaje de INFO
                num = 0;// con cero se hace update y con 1 NO se hace
                //limpiar();
                listar();
                break;

        }

        switch (serie) {
            case "":
                JOptionPane.showMessageDialog(null, "Número de Serie inválido");
                num = 1;
                break;
        }
        

        if (num == 0) {
            int respuesta = CS.insertDatos(fabricante, modelo, serie, mac, huella, proximidad, rele, tecnico, estado, observaciones);
            System.out.println("fabricante: "+fabricante+",modelo: "+modelo+",serie:"+serie+",mac:"+mac+",huella:"+huella+",proximidad:"+proximidad+",rele:"+rele+",tecnico:"+tecnico+",estado:"+estado+",observaciones:"+observaciones);
            if (respuesta > 0) {
                System.out.println("fabricante: "+fabricante+",modelo: "+modelo+",serie:"+serie+",mac:"+mac+",huella:"+huella+",proximidad:"+proximidad+",rele:"+rele+",tecnico:"+tecnico+",estado:"+estado+",observaciones:"+observaciones);
                listar();
                limpiar();
                jlb_info.setText("Registro guardadooooooo");
            }
        } else {
System.out.println("fabricante: "+fabricante+",modelo: "+modelo+",serie:"+serie+",mac:"+mac+",huella:"+huella+",proximidad:"+proximidad+",rele:"+rele+",tecnico:"+tecnico+",estado:"+estado+",observaciones:"+observaciones);
            int respuesta = CS.updateDatos(fabricante, modelo, serie, mac, huella, proximidad, rele, tecnico, estado, observaciones);
            if (respuesta > 0) {
                System.out.println("fabricante: "+fabricante+",modelo: "+modelo+",serie:"+serie+",mac:"+mac+",huella:"+huella+",proximidad:"+proximidad+",rele:"+rele+",tecnico:"+tecnico+",estado:"+estado+",observaciones:"+observaciones);
                listar();
                //limpiar();
                num = 0;
                jlb_info.setText("Registro Actualizado");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcb_fabricante = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcb_modelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcb_proximidad = new javax.swing.JComboBox<>();
        jtf_serie = new javax.swing.JTextField();
        jtf_mac = new javax.swing.JTextField();
        jcb_tecnico = new javax.swing.JComboBox<>();
        jbt_nuevo = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_datos = new javax.swing.JTable();
        jcb_huellaNo = new javax.swing.JCheckBox();
        jcb_huellaSi = new javax.swing.JCheckBox();
        jcb_releSi = new javax.swing.JCheckBox();
        jcb_releNo = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jcb_estadoCorrecto = new javax.swing.JCheckBox();
        jcb_estadoAveriado = new javax.swing.JCheckBox();
        jbt_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_observaciones = new javax.swing.JTextArea();
        jlb_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1473, 721));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Univers 55", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Terminales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setRequestFocusEnabled(false);

        jLabel2.setText("Fabricante");

        jcb_fabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Fabricante", "Digitek", "Kaba", "Suprema", "ZKTeco" }));
        jcb_fabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_fabricanteActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo");

        jcb_modelo.setModel(lista_defecto_jcb_modelo);
        jcb_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_modeloActionPerformed(evt);
            }
        });

        jLabel4.setText("Serie");

        jLabel5.setText("MAC");

        jLabel6.setText("Huella");

        jLabel7.setText("Proximidad");

        jLabel8.setText("Relé");

        jLabel10.setText("Técnico");

        jLabel11.setText("Observaciones:");

        jcb_proximidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No" }));
        jcb_proximidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_proximidadActionPerformed(evt);
            }
        });

        jtf_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_serieActionPerformed(evt);
            }
        });

        jtf_mac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_macActionPerformed(evt);
            }
        });

        jcb_tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Técnico", "CRISTHIAN LLANOS", "SANTIAGO MONLEÓN", "CARLOS ALGARRA" }));

        jbt_nuevo.setText("Nuevo");
        jbt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_nuevoActionPerformed(evt);
            }
        });

        jbt_guardar.setText("Guardar");
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jtb_datos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtb_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_datos.setFocusable(false);
        jtb_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtb_datos);

        jcb_huellaNo.setText("NO");
        jcb_huellaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_huellaNoActionPerformed(evt);
            }
        });

        jcb_huellaSi.setText("SI");
        jcb_huellaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_huellaSiActionPerformed(evt);
            }
        });

        jcb_releSi.setText("SI");
        jcb_releSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_releSiActionPerformed(evt);
            }
        });

        jcb_releNo.setText("NO");
        jcb_releNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_releNoActionPerformed(evt);
            }
        });

        jLabel12.setText("Estado");

        jcb_estadoCorrecto.setText("Correcto");
        jcb_estadoCorrecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_estadoCorrectoActionPerformed(evt);
            }
        });

        jcb_estadoAveriado.setText("Averiado");
        jcb_estadoAveriado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_estadoAveriadoActionPerformed(evt);
            }
        });

        jbt_eliminar.setText("Eliminar");
        jbt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_eliminarActionPerformed(evt);
            }
        });

        jta_observaciones.setColumns(20);
        jta_observaciones.setRows(5);
        jScrollPane1.setViewportView(jta_observaciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jcb_huellaSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcb_huellaNo))
                                    .addComponent(jtf_mac, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jcb_releSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcb_releNo))
                                    .addComponent(jcb_tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_estadoCorrecto)
                                    .addComponent(jcb_estadoAveriado)
                                    .addComponent(jtf_serie, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jcb_proximidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcb_fabricante, 0, 196, Short.MAX_VALUE)
                                    .addComponent(jcb_modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(355, 355, 355)
                                .addComponent(jlb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jbt_nuevo)
                                    .addGap(52, 52, 52)
                                    .addComponent(jbt_guardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbt_eliminar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1122, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcb_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcb_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jlb_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtf_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtf_mac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcb_huellaNo)
                            .addComponent(jcb_huellaSi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcb_proximidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcb_releSi)
                            .addComponent(jcb_releNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jcb_tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jcb_estadoCorrecto))
                        .addGap(3, 3, 3)
                        .addComponent(jcb_estadoAveriado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_nuevo)
                    .addComponent(jbt_guardar)
                    .addComponent(jbt_eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String defecto_jcb_modelo[] = {"Seleccione Fabricante"};
    String digitek[] = {"Seleccione Modelo", "ML-7", "ML-10", "ML-15", "ML-20", "ML-900"};
    String digitek_proximidad[] = {"No","Baja Frecuencia","Mifare","HID"};
    String kaba[] = {"Seleccione Modelo", "Benzing 9320", "Benzing Time", "B-ECO", "Bedanet 9320", "Bedanet 9510", "B-net 9320"};
    String suprema[] = {"Seleccione Modelo", "BioStation L2", "BioEntry Plus", "BioLiteSolo", "BioEntry W", "BioLiteNet", "SECURE I/O", "BSM-OC", "D-STATION", "XPASS SLIM"};
    String zkteco[] = {"Seleccione Modelo", "BioPad Android", "UA-400", "iCLOCK 560"};
    
    DefaultComboBoxModel lista_defecto_jcb_modelo = new DefaultComboBoxModel(defecto_jcb_modelo);
    DefaultComboBoxModel lista_digitek = new DefaultComboBoxModel(digitek);
    DefaultComboBoxModel lista_digitek_proximidad = new DefaultComboBoxModel(digitek_proximidad);
    DefaultComboBoxModel lista_kaba = new DefaultComboBoxModel(kaba);
    DefaultComboBoxModel lista_suprema = new DefaultComboBoxModel(suprema);
    DefaultComboBoxModel lista_zkteco = new DefaultComboBoxModel(zkteco);

    public void actualizador_de_modelos() {
        String fabricante = jcb_fabricante.getSelectedItem().toString();
        switch (fabricante) {
            case "Kaba":
                jcb_modelo.setModel(lista_kaba);
                jcb_releNo.setSelected(true);
                jcb_releSi.setSelected(false);
                break;
            case "Digitek":
                jcb_modelo.setModel(lista_digitek);
                jcb_proximidad.setModel(lista_digitek_proximidad);
                jcb_releSi.setSelected(true);
                break;
            case "Suprema":
                jcb_modelo.setModel(lista_suprema);
                jcb_releSi.setSelected(true);
                break;
            case "ZKTeco":
                jcb_modelo.setModel(lista_zkteco);
                jcb_releSi.setSelected(true);
                break;
            case "Seleccione Fabricante":
                jcb_modelo.setModel(lista_defecto_jcb_modelo);
                jcb_proximidad.setModel(lista_defecto_jcb_modelo);
                break;
            default:
                jcb_modelo.setModel(lista_defecto_jcb_modelo);
                break;
        }
        jcb_modelo.setSelectedIndex(0);
    }


    private void jcb_fabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_fabricanteActionPerformed
        actualizador_de_modelos();
    }//GEN-LAST:event_jcb_fabricanteActionPerformed

    private void jcb_huellaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_huellaSiActionPerformed
        String huellaSi;
        String huellaNo;
        if (jcb_huellaSi.isSelected()) {
            jcb_huellaNo.setSelected(false);
            huellaSi = "Si";
        }
    }//GEN-LAST:event_jcb_huellaSiActionPerformed

    private void jcb_huellaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_huellaNoActionPerformed
        String huellaSi;
        String huellaNo;
        if (jcb_huellaNo.isSelected()) {
            jcb_huellaSi.setSelected(false);
            huellaNo = "No";
        }
    }//GEN-LAST:event_jcb_huellaNoActionPerformed

    private void jcb_releSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_releSiActionPerformed
        String releSi;
        String releNo;
        if (jcb_releSi.isSelected()) {
            jcb_releNo.setSelected(false);
            releSi = "Si";
        } 
        if (jcb_releNo.isSelected()) {
            jcb_releSi.setSelected(false);
            releNo = "No";
        } 
    }//GEN-LAST:event_jcb_releSiActionPerformed

    private void jcb_releNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_releNoActionPerformed
        String releSi;
        String releNo;
        if (jcb_releNo.isSelected()) {
            jcb_releSi.setSelected(false);
            releNo = "No";
        }
        if (jcb_releSi.isSelected()) {
            jcb_releNo.setSelected(false);
            releSi = "Si";
        }
    }//GEN-LAST:event_jcb_releNoActionPerformed

    private void jbt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_guardarActionPerformed
        if (ValidarFormulario()){
            guardar();
        }else{
             JOptionPane.showMessageDialog(null, "Formato de MAC incorrecto");
        }

    }//GEN-LAST:event_jbt_guardarActionPerformed

    private boolean ValidarFormulario(){
      Boolean validMac = false;  
      Boolean validFabricante = true;
      Boolean validModelo = true;
      // String to be scanned to find the pattern.
      String line = jtf_mac.getText();
      String pattern = "^(([a-fA-F0-9]{2}(-)){5}[a-fA-F0-9]{2}|([a-fA-F0-9]{2}(:)){5}[a-fA-F0-9]{2})$";
      
      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find()) {
        validMac = true;    
      }
     
         
    return validMac && validFabricante && validModelo;
    }
    private void jbt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_nuevoActionPerformed
        listar();
        limpiar();
        num = 0;
    }//GEN-LAST:event_jbt_nuevoActionPerformed


    private void jcb_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_modeloActionPerformed

    private void jcb_proximidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_proximidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_proximidadActionPerformed

    private void jtb_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_datosMouseClicked
        int row = jtb_datos.getSelectedRow();

        jcb_fabricante.setSelectedItem(jtb_datos.getValueAt(row, 0).toString());
        jcb_modelo.setSelectedItem(jtb_datos.getValueAt(row, 1).toString());
        jtf_serie.setText(jtb_datos.getValueAt(row, 2).toString());
        jtf_mac.setText(jtb_datos.getValueAt(row, 3).toString());
        String huella = jtb_datos.getValueAt(row, 4).toString();
        jcb_proximidad.setSelectedItem(jtb_datos.getValueAt(row, 5).toString());
        String rele = jtb_datos.getValueAt(row, 6).toString();
        jcb_tecnico.setSelectedItem(jtb_datos.getValueAt(row, 7).toString());
        String estado = jtb_datos.getValueAt(row, 8).toString();
        jta_observaciones.setText(jtb_datos.getValueAt(row, 9).toString());
        //String macv2 = jtb_datos.getValueAt(row, 3).toString();

        if (huella.equals("Si")) {
            jcb_huellaSi.setSelected(true);
            jcb_huellaNo.setSelected(false);
        } else {

        }
        if (huella.equals("No")) {
            jcb_huellaNo.setSelected(true);
            jcb_huellaSi.setSelected(false);
        } else {

        }
        if (rele.equals("Si")) {
            jcb_releSi.setSelected(true);
            jcb_releNo.setSelected(false);
        } else {

        }
        if (rele.equals("No")) {
            jcb_releNo.setSelected(true);
            jcb_releSi.setSelected(false);
        } else {

        }
        if (estado.equals("Correcto")) {
            jcb_estadoCorrecto.setSelected(true);
            jcb_estadoAveriado.setSelected(false);
        } else {

        }
        if (estado.equals("Averiado")) {
            jcb_estadoAveriado.setSelected(true);
            jcb_estadoCorrecto.setSelected(false);
        } else {

        }
        num = 1;
    }//GEN-LAST:event_jtb_datosMouseClicked

    private void jbt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_eliminarActionPerformed
        int fila = jtb_datos.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un Registro de la tabla");
        } else {
            if (CS.deleteDatos(jtb_datos.getValueAt(jtb_datos.getSelectedRow(), 2).toString()) > 0) {
                System.out.println("Contador fila= " + fila);
                listar();
                limpiar();

                num = 0;
            }
        }
    }//GEN-LAST:event_jbt_eliminarActionPerformed

    private void jcb_estadoCorrectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_estadoCorrectoActionPerformed
        String estado;

        if (jcb_estadoCorrecto.isSelected()) {
            jcb_estadoAveriado.setSelected(false);
            estado = "Correcto";
        } else if(jcb_estadoCorrecto.isSelected() && jcb_estadoAveriado.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccione sólo un Estado ");
        }else if(jcb_estadoAveriado.isSelected() == false&&jcb_estadoCorrecto.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Seleccione un estado");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR DE ESTADO");
        }


    }//GEN-LAST:event_jcb_estadoCorrectoActionPerformed

    private void jcb_estadoAveriadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_estadoAveriadoActionPerformed
        String estado;
 
        if (jcb_estadoAveriado.isSelected()) {
            jcb_estadoCorrecto.setSelected(false);
            estado = "Averiado";
        }
        else if(jcb_estadoCorrecto.isSelected() && jcb_estadoAveriado.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccione sólo un Estado");
        }else if(jcb_estadoAveriado.isSelected() == false&&jcb_estadoCorrecto.isSelected() == false){
            JOptionPane.showMessageDialog(null, "Seleccione un estado");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR DE ESTADO");
        }
    }//GEN-LAST:event_jcb_estadoAveriadoActionPerformed

    private void jtf_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_serieActionPerformed

    private void jtf_macActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_macActionPerformed

    }//GEN-LAST:event_jtf_macActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbt_eliminar;
    private javax.swing.JButton jbt_guardar;
    private javax.swing.JButton jbt_nuevo;
    private javax.swing.JCheckBox jcb_estadoAveriado;
    private javax.swing.JCheckBox jcb_estadoCorrecto;
    private javax.swing.JComboBox<String> jcb_fabricante;
    private javax.swing.JCheckBox jcb_huellaNo;
    private javax.swing.JCheckBox jcb_huellaSi;
    private javax.swing.JComboBox<String> jcb_modelo;
    private javax.swing.JComboBox<String> jcb_proximidad;
    private javax.swing.JCheckBox jcb_releNo;
    private javax.swing.JCheckBox jcb_releSi;
    private javax.swing.JComboBox<String> jcb_tecnico;
    private javax.swing.JLabel jlb_info;
    private javax.swing.JTextArea jta_observaciones;
    private javax.swing.JTable jtb_datos;
    private javax.swing.JTextField jtf_mac;
    private javax.swing.JTextField jtf_serie;
    // End of variables declaration//GEN-END:variables
}
