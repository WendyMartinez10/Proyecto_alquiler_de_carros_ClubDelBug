/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Secundarias;

import BaseDeDatos.GestorClientes;
import BaseDeDatos.GestorContratos;
import BaseDeDatos.GestorEmpleados;
import BaseDeDatos.GestorReservas;
import BaseDeDatos.GestorVehiculos;
import Clases.Cliente;
import Clases.ContratoVehiculo;
import Clases.Empleado;
import Clases.Reserva;
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
 * @author AsusVivobook
 */
public class PnlReservas extends javax.swing.JPanel {

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
    public PnlReservas(GestorReservas gestorReservas, GestorClientes gestorC, GestorVehiculos gestV, GestorEmpleados gestE, GestorContratos gestC) {
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

        txtBuscar1.setText("yyyy-MM-dd");
        txtBuscar1.setForeground(Color.GRAY);
        txtBuscar1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtBuscar1.getText().isEmpty()) {
                    txtBuscar1.setText("yyyy-MM-dd");
                    txtBuscar1.setForeground(Color.GRAY);
                }
            }
        });

        txtBuscar2.setText("yyyy-MM-dd");
        txtBuscar2.setForeground(Color.GRAY);
        txtBuscar2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtBuscar2.getText().isEmpty()) {
                    txtBuscar2.setText("yyyy-MM-dd");
                    txtBuscar2.setForeground(Color.GRAY);
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

        for (Vehiculo v : gestV.listarVehiculos()) {
            cmbVehiculos1.addItem(v.getPlaca());
        }
    }

    private void iniciarTabla() {

        String[] columnas = {
            "Cédula", "Nombre", "Edad", "Teléfono", "Correo",
            "Tipo Vehículo", "Placa Vehículo", "Fecha Inicio", "Fecha Fin", "Confirmada"
        };

        // Crear modelo de tabla no editable
        modeloTabla = new javax.swing.table.DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita edición directa
            }
        };

        jTable1.setModel(modeloTabla);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);

        for (Reserva reserva : gestorReservas.listarReservas()) {
            Object[] fila = {
                reserva.getCliente().getCedula(),
                reserva.getCliente().getNombre(),
                reserva.getCliente().getEdad(),
                reserva.getCliente().getTelefono(),
                reserva.getCliente().getCorreo(),
                reserva.getVehiculo().getTipo(),
                reserva.getVehiculo().getPlaca(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                reserva.isConfirmada() ? "Sí" : "No"
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
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cmbVehiculos1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
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
        btnConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jDialog1.setMinimumSize(new java.awt.Dimension(585, 431));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESERVAR");
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

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);
        jPanel6.getAccessibleContext().setAccessibleParent(jDialog1);

        jDialog1.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jDialog2.setMinimumSize(new java.awt.Dimension(585, 431));

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("RESERVAR");
        jLabel5.setMaximumSize(new java.awt.Dimension(70, 100));
        jLabel5.setMinimumSize(new java.awt.Dimension(70, 100));
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel9.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7, new java.awt.GridBagConstraints());

        jPanel8.add(jPanel10, java.awt.BorderLayout.SOUTH);

        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel19.setText("PLACA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel11.add(jLabel19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel11.add(cmbVehiculos1, gridBagConstraints);

        jPanel8.add(jPanel11, java.awt.BorderLayout.CENTER);

        jDialog2.getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(400, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 150));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESERVAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel4.add(jLabel1, gridBagConstraints);

        Nombre.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(Nombre, gridBagConstraints);

        txtCedula.setMinimumSize(new java.awt.Dimension(100, 30));
        txtCedula.setPreferredSize(new java.awt.Dimension(100, 30));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(txtCedula, gridBagConstraints);

        Nombre1.setText("Fecha Inicio");
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

        Nombre2.setText("Fecha Inicio");
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

        btnConfirmar.setBackground(new java.awt.Color(255, 255, 102));
        btnConfirmar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar);

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

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.crearReserva();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        buscarReserva();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Obtener la reserva seleccionada (asumiendo que tienes una lista de reservas)
        Reserva r = gestorReservas.listarReservas().get(fila);
        if (r == null) {
            JOptionPane.showMessageDialog(this, "Reserva no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Llenar solo el combo de tipo de vehículo
        cmbVehiculos1.setSelectedItem(r.getVehiculo().getTipo());

// Mostrar diálogo para actualizar
        jDialog2.setVisible(true);

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        actualizarReserva();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para confirmar");
            return;
        }

        try {
            String cedula = (String) modeloTabla.getValueAt(fila, 0);
           String placa = (String) modeloTabla.getValueAt(fila, 6);


            Reserva reservaSeleccionada = null;
            for (Reserva r : gestorReservas.listarReservas()) {
                if (r.getCliente().getCedula().equals(cedula)
                        && r.getVehiculo().getPlaca().equals(placa)
                        && !r.isConfirmada()) {
                    reservaSeleccionada = r;
                    break;
                }
            }

            if (reservaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "La reserva ya fue confirmada o no existe.");
                return;
            }

          
            reservaSeleccionada.confirmar();

            // Obtener un empleado al azar
            Empleado empleadoAsignado = gestE.obtenerEmpleadoAleatorio();

            double tarifaDiaria = 50.0;
            ContratoVehiculo contrato = new ContratoVehiculo(
                    reservaSeleccionada.getCliente(),
                    reservaSeleccionada.getVehiculo(),
                    empleadoAsignado,
                    reservaSeleccionada.getFechaInicio(),
                    reservaSeleccionada.getFechaFin(),
                    tarifaDiaria
            );

            JOptionPane.showMessageDialog(this,
                    "Reserva confirmada y asignada a empleado: " + empleadoAsignado.getNombre()
                    + "\n" + contrato.mostrarInfo(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            
            gestC.crearContrato(contrato);
            actualizarTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al confirmar reserva: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed
    private void buscarReserva() {
        String cedula = txtCedula.getText().trim();
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        try {
            if (!txtBuscar1.getText().trim().isEmpty()) {
                fechaInicio = LocalDate.parse(txtBuscar1.getText().trim());
            }
        } catch (Exception e) {
            fechaInicio = null;
        }

        try {
            if (!txtBuscar2.getText().trim().isEmpty()) {
                fechaFin = LocalDate.parse(txtBuscar2.getText().trim());
            }
        } catch (Exception e) {
            fechaFin = null;
        }

        ArrayList<Reserva> resultados = gestorReservas.buscarReservas(cedula, fechaInicio, fechaFin);

        modeloTabla.setRowCount(0);
        for (Reserva reserva : resultados) {
            Object[] fila = {
                reserva.getCliente().getCedula(),
                reserva.getCliente().getNombre(),
                reserva.getCliente().getEdad(),
                reserva.getCliente().getTelefono(),
                reserva.getCliente().getCorreo(),
                reserva.getVehiculo().getTipo(),
                reserva.getVehiculo().getPlaca(),
                reserva.getFechaInicio(),
                reserva.getFechaFin(),
                reserva.isConfirmada() ? "Sí" : "No"
            };
            modeloTabla.addRow(fila);
        }

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron reservas con esos criterios.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void actualizarReserva() {
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reserva r = gestorReservas.listarReservas().get(fila);

        String vehiculoSeleccionado = (String) cmbVehiculos.getSelectedItem();

        if (vehiculoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vehículo válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vehiculo v = gestV.buscarVehiculo(vehiculoSeleccionado);

        if (v == null) {
            JOptionPane.showMessageDialog(this, "Vehículo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            r.setVehiculo(v);
            JOptionPane.showMessageDialog(this, "Reserva actualizada con éxito.");
            actualizarTabla(); // Refrescar tabla de reservas
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearReserva() {
        try {
            // Obtener cliente
            String cedulaCliente = (String) cmbClientes.getSelectedItem();
            if (cedulaCliente == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = gestorC.buscarCliente(cedulaCliente);
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener vehículo
            String vehiculoStr = (String) cmbVehiculos.getSelectedItem();
            if (vehiculoStr == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String placa = vehiculoStr.split(" - ")[1]; // extrae la placa
            Vehiculo vehiculo = gestV.buscarVehiculo(placa);
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "Vehículo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener fechas
            LocalDate inicio = LocalDate.parse(txtFechaInicio.getText().trim());
            LocalDate fin = LocalDate.parse(this.txtFechaFinal.getText().trim());

            if (inicio.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser menor a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!fin.isAfter(inicio)) {
                JOptionPane.showMessageDialog(this, "La fecha de fin debe ser posterior a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (inicio.until(fin).getDays() > 30) {
                JOptionPane.showMessageDialog(this, "La reserva no puede durar más de 30 días.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar disponibilidad del vehículo
            for (Reserva r : gestorReservas.listarReservas()) {
                if (r.getVehiculo().getPlaca().equals(placa)) {
                    if (!(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getFechaFin()))) {
                        JOptionPane.showMessageDialog(this, "El vehículo no está disponible en esas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Crear reserva y agregar a la lista/Queue
            Reserva nuevaReserva = new Reserva(cliente, vehiculo, inicio, fin);
            gestorReservas.crearReserva(nuevaReserva); // método en tu gestorReservas

            this.actualizarTabla();// refresca JTable
            JOptionPane.showMessageDialog(this, "Reserva creada con éxito.");
            this.jDialog1.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al crear la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbVehiculos;
    private javax.swing.JComboBox<String> cmbVehiculos1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
