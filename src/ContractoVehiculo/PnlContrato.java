/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ContractoVehiculo;

import Clientes.GestorClientes;
import ContractoVehiculo.GestorContratos;
import Empleados.GestorEmpleados;
import Reserva.GestorReservas;
import Vehiculos.GestorVehiculos;
import Clientes.Cliente;
import ContractoVehiculo.ContratoVehiculo;
import Empleados.Empleado;
import Reserva.Reserva;
import Clases.Vehiculo;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wen
 */
public class PnlContrato extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    private String cedulaSeleccionada = null;
    private GestorReservas gestorReservas = new GestorReservas();

    private GestorClientes gestorC = new GestorClientes();
    private GestorVehiculos gestV = new GestorVehiculos();
    private GestorEmpleados gestE = new GestorEmpleados();
    private GestorContratos gestC = new GestorContratos();

    /**
     * Creates new form PnlClientes
     */
    public PnlContrato(GestorReservas gestorReservas, GestorClientes gestorC, GestorVehiculos gestV, GestorEmpleados gestE, GestorContratos gestC) {
        initComponents();
        this.gestorReservas = gestorReservas;
        this.gestorC = gestorC;
        this.gestV = gestV;
        this.gestE = gestE;
        this.gestC = gestC;

        iniciarTabla();

        txtFechaInicio.setText("yyyy-MM-dd");
        txtFechaInicio.setForeground(Color.GRAY);
        txtFechaInicio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtFechaInicio.getText().isEmpty()) {
                    txtFechaInicio.setText("yyyy-MM-dd");
                    txtFechaInicio.setForeground(Color.GRAY);
                }
            }
        });

        txtFechaFinal.setText("yyyy-MM-dd");
        txtFechaFinal.setForeground(Color.GRAY);
        txtFechaFinal.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtFechaFinal.getText().isEmpty()) {
                    txtFechaFinal.setText("yyyy-MM-dd");
                    txtFechaFinal.setForeground(Color.GRAY);
                }
            }
        });

     
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = jTable1.getSelectedRow();
                if (fila >= 0) {

                    cedulaSeleccionada = jTable1.getValueAt(fila, 0).toString();

                    if (evt.getClickCount() == 2) {

                    }
                }
            }
        });

        cargarCombos();

        actualizarTabla();

    }

    private void cargarCombos() {
        // Limpiar primero
        cmbClientes.removeAllItems();
        cmbVehiculos.removeAllItems();

        // Cargar clientes (mostrando la cédula en el combo)
        for (Cliente c : gestorC.listarClientes()) {
            cmbClientes.addItem(c.getCedula());
        }

        // Cargar vehículos (mostrando tipo + placa en el combo)
        for (Vehiculo v : gestV.listarVehiculos()) {
            cmbVehiculos.addItem(v.getTipo() + " - " + v.getPlaca());
        }

        for (Empleado e : gestE.listarEmpleados()) {
            cmbEmpleado.addItem(e.getCedula());
        }

    }

    private void iniciarTabla() {

        String[] columnas = {"N° Contrato", "Cédula", "Nombre", "Edad", "Teléfono", "Correo",
            "Tipo Vehículo", "Placa", "Empleado", "Fecha Inicio", "Fecha Fin",
            "Monto", "Estado"};

        modeloTabla = new javax.swing.table.DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTable1.setModel(modeloTabla);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);

        for (ContratoVehiculo contrato : gestC.listarContratos()) {
            Object[] fila = {
                contrato.getNumeroContrato(),
                contrato.getCliente().getCedula(),
                contrato.getCliente().getNombre(),
                contrato.getCliente().getEdad(),
                contrato.getCliente().getTelefono(),
                contrato.getCliente().getCorreo(),
                contrato.getVehiculo().getTipo(),
                contrato.getVehiculo().getPlaca(),
                contrato.getEmpleado().getNombre(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getMonto(),
                contrato.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbVehiculos = new javax.swing.JComboBox<>();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jDialog3 = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmbEstado1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        Nombre1 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        Nombre2 = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jDialog1.setMinimumSize(new java.awt.Dimension(585, 431));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTRATO");
        jLabel2.setMaximumSize(new java.awt.Dimension(70, 100));
        jLabel2.setMinimumSize(new java.awt.Dimension(70, 100));
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel5.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jButton6.setText("Crear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel7, java.awt.BorderLayout.SOUTH);
        jPanel7.getAccessibleContext().setAccessibleParent(jDialog1);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel16.setText("CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel16, gridBagConstraints);

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(cmbClientes, gridBagConstraints);

        jLabel17.setText("Tipo Vehiculo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel17, gridBagConstraints);

        cmbVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(cmbVehiculos, gridBagConstraints);

        cmbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(cmbEmpleado, gridBagConstraints);

        jLabel18.setText("EMPLEADO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel18, gridBagConstraints);

        jLabel3.setText("FECHA INICIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(txtFechaInicio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(txtFechaFinal, gridBagConstraints);

        jLabel4.setText("FECHA FINAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel4, gridBagConstraints);

        jLabel20.setText("ESTADO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel20, gridBagConstraints);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado", "Cancelado" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(cmbEstado, gridBagConstraints);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);
        jPanel6.getAccessibleContext().setAccessibleParent(jDialog1);

        jDialog1.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jDialog3.setMinimumSize(new java.awt.Dimension(585, 431));

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONTRATO");
        jLabel6.setMaximumSize(new java.awt.Dimension(70, 100));
        jLabel6.setMinimumSize(new java.awt.Dimension(70, 100));
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel13.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel13, java.awt.BorderLayout.NORTH);

        jPanel14.setLayout(new java.awt.GridBagLayout());

        jButton8.setText("ACTUALIZAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton8, new java.awt.GridBagConstraints());

        jPanel12.add(jPanel14, java.awt.BorderLayout.SOUTH);

        jPanel15.setLayout(new java.awt.GridBagLayout());

        txtId.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel15.add(txtId, gridBagConstraints);

        jLabel8.setText("ID CONTRATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel15.add(jLabel8, gridBagConstraints);

        jLabel24.setText("ESTADO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel15.add(jLabel24, gridBagConstraints);

        cmbEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Finalizado", "Cancelado" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel15.add(cmbEstado1, gridBagConstraints);

        jPanel12.add(jPanel15, java.awt.BorderLayout.CENTER);

        jDialog3.getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(400, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 150));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTRATOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel4.add(jLabel1, gridBagConstraints);

        Nombre.setText("NUMERO CONTRATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(Nombre, gridBagConstraints);

        txtBuscar.setMinimumSize(new java.awt.Dimension(100, 30));
        txtBuscar.setPreferredSize(new java.awt.Dimension(100, 30));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtBuscar, gridBagConstraints);

        Nombre1.setText("Vehiculo Placa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(Nombre1, gridBagConstraints);

        txtBuscar1.setMinimumSize(new java.awt.Dimension(100, 30));
        txtBuscar1.setPreferredSize(new java.awt.Dimension(100, 30));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtBuscar1, gridBagConstraints);

        Nombre2.setText("CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(Nombre2, gridBagConstraints);

        txtBuscar2.setMinimumSize(new java.awt.Dimension(100, 30));
        txtBuscar2.setPreferredSize(new java.awt.Dimension(100, 30));
        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtBuscar2, gridBagConstraints);

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setMinimumSize(new java.awt.Dimension(72, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 40));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setBackground(new java.awt.Color(153, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setText("REFRESCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jPanel3.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.crearContrato();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        buscarContrato();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un contrato para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

// Obtener el contrato seleccionado
            ContratoVehiculo contrato = gestC.listarContratos().get(fila);
            if (contrato == null) {
                JOptionPane.showMessageDialog(this, "Contrato no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!"Activo".equalsIgnoreCase(contrato.getEstado())) {
                JOptionPane.showMessageDialog(this, "Solo se pueden editar contratos con estado 'Activo'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cmbEstado1.setSelectedItem(contrato.getEstado());
            this.txtId.setText(String.valueOf(contrato.getNumeroContrato()));
            jDialog3.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reserva r = gestorReservas.listarReservas().get(fila);

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que desea eliminar la reserva del cliente " + r.getCliente().getNombre() + "?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            try {
                // Solo eliminar si no está confirmada
                if (r.isConfirmada()) {
                    throw new Exception("No se puede eliminar una reserva confirmada.");
                }
                gestorReservas.cancelarReserva(r); // Implementar este método en GestorReservas
                actualizarTabla(); // Refrescar la tabla de reservas
                JOptionPane.showMessageDialog(this, "Reserva eliminada con éxito.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String estadoSeleccionado = (String) cmbEstado1.getSelectedItem();
        int idContrato = Integer.parseInt(this.txtId.getText());
        ContratoVehiculo contrato = gestC.buscarContrato(idContrato);

        try {
            if ("Finalizado".equals(estadoSeleccionado)) {
                gestC.finalizarContrato(contrato.getNumeroContrato());
                JOptionPane.showMessageDialog(this, "Contrato finalizado correctamente.");
            } else if ("Cancelado".equals(estadoSeleccionado)) {
                gestC.cancelarContrato(contrato.getNumeroContrato());
                JOptionPane.showMessageDialog(this, "Contrato cancelado correctamente.");
            }

          
            actualizarTabla();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed
  private void buscarContrato() {
    String txtNumero = this.txtBuscar.getText().trim();
    String txtCliente = txtBuscar1.getText().trim();
    String txtVehiculo = txtBuscar2.getText().trim();

    modeloTabla.setRowCount(0);

    for (ContratoVehiculo contrato : gestC.listarContratos()) {
        boolean coincideNumero = txtNumero.isEmpty() || 
            String.valueOf(contrato.getNumeroContrato()).equals(txtNumero);

        boolean coincideCliente = txtCliente.isEmpty() || 
            contrato.getCliente().getNombre().toLowerCase().contains(txtCliente) ||
            contrato.getCliente().getCedula().toLowerCase().contains(txtCliente);

        boolean coincideVehiculo = txtVehiculo.isEmpty() || 
            contrato.getVehiculo().getTipo().toLowerCase().contains(txtVehiculo) ||
            contrato.getVehiculo().getPlaca().toLowerCase().contains(txtVehiculo);

        if (coincideNumero && coincideCliente && coincideVehiculo) {
            Object[] fila = {
                contrato.getNumeroContrato(),
                contrato.getCliente().getCedula(),
                contrato.getCliente().getNombre(),
                contrato.getCliente().getEdad(),
                contrato.getCliente().getTelefono(),
                contrato.getCliente().getCorreo(),
                contrato.getVehiculo().getTipo(),
                contrato.getVehiculo().getPlaca(),
                contrato.getEmpleado().getNombre(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getMonto(),
                contrato.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }

    if (modeloTabla.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this,
            "No se encontraron contratos con esos criterios.",
            "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}


    

    private void crearContrato() {
        try {
            // Obtener cliente
            String cedulaCliente = (String) cmbClientes.getSelectedItem();
            Cliente cliente = gestorC.buscarCliente(cedulaCliente);
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener vehículo
            String vehiculoStr = (String) cmbVehiculos.getSelectedItem();
            String placa = vehiculoStr.split(" - ")[1];
            Vehiculo vehiculo = gestV.buscarVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "Vehículo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener empleado
            String cedulaEmpleado = (String) cmbEmpleado.getSelectedItem();
            Empleado empleado = gestE.buscarEmpleado(cedulaEmpleado);
            if (empleado == null) {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Fechas
            LocalDate inicio;
            LocalDate fin;
            try {
                inicio = LocalDate.parse(txtFechaInicio.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                fin = LocalDate.parse(txtFechaFinal.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fechas inválido. Use yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fin.isBefore(inicio)) {
                JOptionPane.showMessageDialog(this, "La fecha final debe ser posterior a la inicial", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String estado = (String) cmbEstado.getSelectedItem();

            double tarifaDiaria = 50.0;
            ContratoVehiculo contrato = new ContratoVehiculo(
                    cliente, vehiculo, empleado, inicio, fin, tarifaDiaria
            );
            contrato.setEstado(estado);

            gestC.crearContrato(contrato);

            JOptionPane.showMessageDialog(this,
                    "Contrato creado con éxito.\n" + contrato.mostrarInfo(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            jDialog1.setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear el contrato: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        this.actualizarTabla();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstado1;
    private javax.swing.JComboBox<String> cmbVehiculos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
