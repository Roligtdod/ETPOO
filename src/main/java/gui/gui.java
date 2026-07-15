package gui;

import data.GestorDatos;
import model.GuiaTuristico;
import model.OperadorTransporte;
import model.Recurso;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gui extends JFrame {

    private ArrayList<Recurso> listaRecursos = new ArrayList<>();


    public gui() {
        super("Tours");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(950, 600);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Guia Turistico", PanelGuia());
        tabs.addTab("Transportistas", PanelTransportista());
        tabs.addTab("Proveedores", PanelProveedores());
        setContentPane(tabs);
    }

    private JTextArea crearTextArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        return area;
    }

    private JPanel PanelGuia() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField telefono = new JTextField();
        JTextField mail = new JTextField();
        JTextField cargo = new JTextField();
        JTextField especialidad = new JTextField();
        JTextField sueldo = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2, 1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del trabajador"));

        panel.add(new JLabel("ID:")); panel.add(id);
        panel.add(new JLabel("Nombre:")); panel.add(nombre);
        panel.add(new JLabel("Telefono:")); panel.add(telefono);
        panel.add(new JLabel("Mail:")); panel.add(mail);
        panel.add(new JLabel("Cargo:")); panel.add(cargo);
        panel.add(new JLabel("Especialidad:")); panel.add(especialidad);
        panel.add(new JLabel("Sueldo:")); panel.add(sueldo);
        add(panel);

        JPanel textArea = new JPanel(new BorderLayout());
        JTextArea areaG = crearTextArea();

        textArea.add(panel, BorderLayout.NORTH);
        textArea.add(areaG , BorderLayout.CENTER);

        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(e -> {
            try{
                if (id.getText().isEmpty() || nombre.getText().isEmpty() || telefono.getText().isEmpty() || mail.getText().isEmpty() || cargo.getText().isEmpty() || especialidad.getText().isEmpty() || sueldo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Faltan datos");
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Sueldo debe ser un numero");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error");
            }
            GuiaTuristico guia = new GuiaTuristico(id.getText(), nombre.getText(), telefono.getText(), mail.getText(), cargo.getText(), especialidad.getText(), Integer.parseInt(sueldo.getText()));
            listaRecursos.add(guia);
            GestorDatos.escribirArchivo("datos.txt", guia.toString()); //atributo nombre del archivo y texto a escribir en el txt
            areaG.append(guia.registrar());
        });
        JButton botonLeer = new JButton("Leer");
        botonLeer.addActionListener(e -> {
            areaG.setText("");
            String texto = GestorDatos.leerArchivoGuia("datos.txt");
            areaG.setText(texto);
        });

        panel.add(botonRegistrar, BorderLayout.SOUTH);
        panel.add(botonLeer, BorderLayout.SOUTH);




        return textArea;
    }
    private JPanel PanelTransportista() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField telefono = new JTextField();
        JTextField mail = new JTextField();
        JTextField licencia = new JTextField();
        JTextField fVencimiento = new JTextField();
        JTextField sueldo = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2, 1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del transportista"));

        panel.add(new JLabel("ID:")); panel.add(id);
        panel.add(new JLabel("Nombre:")); panel.add(nombre);
        panel.add(new JLabel("Telefono:")); panel.add(telefono);
        panel.add(new JLabel("Mail:")); panel.add(mail);
        panel.add(new JLabel("Tipo de licencia:")); panel.add(licencia);
        panel.add(new JLabel("Fecha de vencimiento de licencia:")); panel.add(fVencimiento);
        panel.add(new JLabel("Sueldo:")); panel.add(sueldo);
        add(panel);

        JPanel textArea = new JPanel(new BorderLayout());
        JTextArea areaG = crearTextArea();

        textArea.add(panel, BorderLayout.NORTH);
        textArea.add(areaG , BorderLayout.CENTER);

        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(e -> {
            try{
                if (id.getText().isEmpty() || nombre.getText().isEmpty() || telefono.getText().isEmpty() || mail.getText().isEmpty() || licencia.getText().isEmpty() || fVencimiento.getText().isEmpty() || sueldo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Faltan datos");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Error");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error");
            }
            OperadorTransporte transporte = new OperadorTransporte(id.getText(), nombre.getText(), telefono.getText(), mail.getText(), licencia.getText(), fVencimiento.getText(), Integer.parseInt(sueldo.getText()));
            listaRecursos.add(transporte);
            GestorDatos.escribirArchivo("datos.txt", transporte.toString()); //atributo nombre del archivo y texto a escribir en el txt
            areaG.append(transporte.registrar());
        });

        JButton botonLeer = new JButton("Leer");
        botonLeer.addActionListener(e -> {
            areaG.setText("");
            String texto = GestorDatos.leerArchivoTransportista("datos.txt");
            areaG.setText(texto);
        });
        panel.add(botonRegistrar, BorderLayout.SOUTH);
        panel.add(botonLeer, BorderLayout.SOUTH);

        return textArea;
    }
    private JPanel PanelProveedores() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField telefono = new JTextField();
        JTextField mail = new JTextField();
        JTextField tipo = new JTextField();
        JTextField servicio = new JTextField();
        JTextField direccion = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2, 1, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del proveedor"));

        panel.add(new JLabel("ID:")); panel.add(id);
        panel.add(new JLabel("Nombre:")); panel.add(nombre);
        panel.add(new JLabel("Telefono:")); panel.add(telefono);
        panel.add(new JLabel("Mail:")); panel.add(mail);
        panel.add(new JLabel("Tipo:")); panel.add(tipo);
        panel.add(new JLabel("Servicio:")); panel.add(servicio);
        panel.add(new JLabel("Dirección:")); panel.add(direccion);
        add(panel);

        JPanel textArea = new JPanel(new BorderLayout());
        JTextArea areaG = crearTextArea();

        textArea.add(panel, BorderLayout.NORTH);
        textArea.add(areaG , BorderLayout.CENTER);
        panel.add(new JButton("Registrar"), BorderLayout.SOUTH);
        panel.add(new JButton("Leer"), BorderLayout.SOUTH);

        return textArea;
    } //faltan los botones de leer y registrar
}
