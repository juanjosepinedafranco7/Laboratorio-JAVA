package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import entidades.Estudiante;
import logica.Procesos;
import logica.ModeloDatos;

public class VentanaPromedio extends JFrame implements ActionListener {
    JLabel etiTitulo, etiRes;
    JTextField txtNombre, txtMateria, txtDocumento, txtN1, txtN2, txtN3;
    JButton btnCalcular, btnLimpiar, btnEliminar, btnActualizar, btnVerLista;
    
    ModeloDatos miData = new ModeloDatos();
    Procesos miProceso = new Procesos();

    public VentanaPromedio() {
        setTitle("Sistema de Notas - Actividad Pag 15");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        etiTitulo = new JLabel("CONTROL DE NOTAS");
        etiTitulo.setBounds(150, 10, 200, 30);
        add(etiTitulo);

        // Campos de texto (Resumidos para el ejemplo)
        txtDocumento = crearCampo("Documento:", 50);
        txtNombre = crearCampo("Nombre:", 90);
        txtMateria = crearCampo("Materia:", 130);
        txtN1 = crearCampo("Nota 1:", 170);
        txtN2 = crearCampo("Nota 2:", 210);
        txtN3 = crearCampo("Nota 3:", 250);

        etiRes = new JLabel("Resultado: ");
        etiRes.setBounds(50, 300, 300, 30);
        etiRes.setFont(new Font("Arial", Font.BOLD, 16));
        add(etiRes);

        btnCalcular = new JButton("Calcular y Guardar");
        btnCalcular.setBounds(50, 350, 150, 30);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(210, 350, 100, 30);
        btnEliminar.addActionListener(this);
        add(btnEliminar);

        btnVerLista = new JButton("Ver Lista");
        btnVerLista.setBounds(320, 350, 100, 30);
        btnVerLista.addActionListener(this);
        add(btnVerLista);
    }

    private JTextField crearCampo(String label, int y) {
        JLabel l = new JLabel(label);
        l.setBounds(50, y, 100, 25);
        add(l);
        JTextField t = new JTextField();
        t.setBounds(150, y, 150, 25);
        add(t);
        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            double n1 = Double.parseDouble(txtN1.getText());
            double n2 = Double.parseDouble(txtN2.getText());
            double n3 = Double.parseDouble(txtN3.getText());
            double prom = miProceso.calcularPromedio(n1, n2, n3);

            // ACTIVIDAD PUNTO 3: Color Rojo si pierde (< 3.5)
            etiRes.setText("Promedio: " + String.format("%.2f", prom));
            if (prom < 3.5) {
                etiRes.setForeground(Color.RED);
            } else {
                etiRes.setForeground(Color.BLACK);
            }

            Estudiante est = new Estudiante();
            est.setDocumento(txtDocumento.getText());
            est.setNombre(txtNombre.getText());
            est.setPromedio(prom);
            miData.registrarEstudiante(est);
        }

        if (e.getSource() == btnEliminar) {
            miData.eliminarEstudiante(txtDocumento.getText());
        }

        if (e.getSource() == btnVerLista) {
            // ACTIVIDAD PUNTO 7: Nueva ventana independiente
            VentanaLista lista = new VentanaLista(miData.getMap());
            lista.setVisible(true);
        }
    }
}