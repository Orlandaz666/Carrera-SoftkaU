
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author orlan
 */
public final class Ventana extends JFrame implements ActionListener, KeyListener {

    JProgressBar carro1, carro2, carro3;
    JButton dados, resetear, cerrar;
    JTextField meta;
    JPanel pt, p1, p2, p3, p4;
    JRadioButton c1, c2, c3;
    ButtonGroup g;
    JLabel car1, car2, car3, resultados;
    JTextArea posiciones;
    JScrollPane sc;
    TitledBorder Meta, Competidores, Acciones, TamañoPista, Ganadores, Resultados;
    ImageIcon ib;
    Border borwhite;

    int avanceDados, contCar1, contCar2, contCar3;
    String nom1, nom2, nom3, contenido;

    Validaciones val = new Validaciones();

    File file;
    FileWriter fw;
    BufferedWriter bw;

    Ventana() {
        setTitle("Carreras Carros");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        borwhite = BorderFactory.createLineBorder(Color.white);

        Competidores = new TitledBorder("Competidores");
        Meta = new TitledBorder("Meta");
        Acciones = new TitledBorder("Acciones");
        TamañoPista = new TitledBorder("Pista (Mts)");
        Ganadores = new TitledBorder("Ganadores");
        Resultados = new TitledBorder("Resultados");

        pt = new JPanel();
        pt.setLayout(new BoxLayout(pt, BoxLayout.Y_AXIS));

        p1 = new JPanel();
        p1.setBackground(Color.BLACK);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder(borwhite, Competidores.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
        setPreferredSize(new Dimension(8, 5));

        p2 = new JPanel();
        p2.setBackground(Color.BLACK);
        p2.setBorder(BorderFactory.createTitledBorder(borwhite, Meta.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
        p2.setPreferredSize(new Dimension(1, 5));

        p3 = new JPanel();
        p3.setBackground(Color.BLACK);
        p3.setBorder(BorderFactory.createTitledBorder(borwhite, Ganadores.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
        p3.setPreferredSize(new Dimension(20, 5));

        p4 = new JPanel();
        p4.setBackground(Color.BLACK);
        p4.setBorder(BorderFactory.createTitledBorder(borwhite, Acciones.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
        p4.setPreferredSize(new Dimension(1, 5));

        c1 = new JRadioButton("Carro 1:");
        c1.setBounds(45, 30, 80, 20);
        c1.setBackground(Color.BLACK);
        c1.setForeground(Color.WHITE);
        c2 = new JRadioButton("Carro 2: ");
        c2.setBounds(45, 80, 80, 20);
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);
        c3 = new JRadioButton("Carro 3: ");
        c3.setBounds(45, 130, 80, 20);
        c3.setBackground(Color.BLACK);
        c3.setForeground(Color.WHITE);

        g = new ButtonGroup();

        g.add(c1);
        g.add(c2);
        g.add(c3);

        carro1 = new JProgressBar();
        carro1.setBounds(130, 30, 280, 20);
        carro1.setForeground(Color.RED);
        carro1.setBackground(Color.BLACK);
        carro2 = new JProgressBar();
        carro2.setBounds(130, 80, 280, 20);
        carro2.setForeground(Color.BLUE);
        carro2.setBackground(Color.BLACK);
        carro3 = new JProgressBar();
        carro3.setBounds(130, 130, 280, 20);
        carro3.setForeground(Color.YELLOW);
        carro3.setBackground(Color.BLACK);

        car1 = new JLabel("-");
        car1.setBounds(420, 30, 50, 20);
        car1.setForeground(Color.WHITE);
        car2 = new JLabel("-");
        car2.setBounds(420, 80, 50, 20);
        car2.setForeground(Color.WHITE);
        car3 = new JLabel("-");
        car3.setBounds(420, 130, 50, 20);
        car3.setForeground(Color.WHITE);

        meta = new JTextField(10);
        meta.setBackground(Color.BLACK);
        meta.setBorder(BorderFactory.createTitledBorder(borwhite, TamañoPista.getTitle(), TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
        meta.setForeground(Color.WHITE);
        meta.setFont(new Font("", Font.PLAIN, 30));
        meta.addKeyListener(this);

        posiciones = new JTextArea(2, 15);
        posiciones.setBackground(Color.BLACK);
        posiciones.setFont(new Font("", Font.PLAIN, 15));
        posiciones.setBorder(BorderFactory.createTitledBorder(borwhite, Resultados.getTitle(), TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
        posiciones.setForeground(Color.WHITE);
        posiciones.setEditable(false);

        sc = new JScrollPane(posiciones);

        resultados = new JLabel();

        ib = new ImageIcon("test\\Imagenes\\Random.png");
        dados = new JButton("", ib);
        dados.addActionListener(this);
        dados.setBackground(Color.WHITE);

        ib = new ImageIcon("test\\Imagenes\\Resetear.jpg");
        resetear = new JButton("", ib);
        resetear.addActionListener(this);
        resetear.setBackground(Color.WHITE);

        ib = new ImageIcon("test\\Imagenes\\Cerrar.png");
        cerrar = new JButton("", ib);
        cerrar.addActionListener(this);
        cerrar.setBackground(Color.WHITE);

        add(pt);
        pt.add(p1);
        pt.add(p2);
        pt.add(p3);
        pt.add(p4);

        p1.add(carro1);
        p1.add(carro2);
        p1.add(carro3);
        p1.add(c1);
        p1.add(c2);
        p1.add(c3);
        p1.add(car1);
        p1.add(car2);
        p1.add(car3);

        p2.add(meta);

        p3.add(sc);

        p4.add(dados);
        p4.add(resetear);
        p4.add(cerrar);

        registrarNombres();

    }

    public void registro() {

        try {

            file = new File("test\\Registro\\Registro.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

        } catch (Exception p) {
            p.printStackTrace();
        }
    }

    public void dadosRandom() {
        avanceDados = (int) Math.round(Math.random() * 5 + 1);
    }

    public void registrarNombres() {
        nom1 = JOptionPane.showInputDialog("Digite Nick(---) del Corredor #1");
        nom2 = JOptionPane.showInputDialog("Digite Nick(---) del Corredor #2");
        nom3 = JOptionPane.showInputDialog("Digite Nick(---) del Corredor #3");
        c1.setText(nom1);
        c2.setText(nom2);
        c3.setText(nom3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (meta.getText().length() == 0 && dados == e.getSource()) {
                JOptionPane.showMessageDialog(null, "Digite El Tamaño De La Pista ");
                meta.setText(null);
                g.clearSelection();

            } else if (meta.getText().length() < 4 && dados == e.getSource()) {
                JOptionPane.showMessageDialog(null, "Digite Un Tamaño Mayor a 999 Mts");
                meta.setText(null);
                g.clearSelection();

            } else if (dados == e.getSource() && c1.isSelected()) {
                meta.setEditable(false);
                dadosRandom();
                carro1.setValue(carro1.getValue() + (avanceDados * 100));
                car1.setText("+" + (avanceDados * 100));
                carro1.setMaximum(Integer.parseInt(meta.getText().trim()));
                contCar1++;
                if (carro1.getValue() >= carro1.getMaximum()) {
                    registro();
                    bw.append("\n=====//=====//=====//=====//=====//=====//=====//");
                    bw.append("\n" + nom1 + " es el ganador.... \n" + nom2 + " y " + nom3 + " han perdido.");
                    bw.close();
                    posiciones.append("\n" + nom1 + " es el ganador....");
                    JOptionPane.showMessageDialog(null, nom1 + " ha Ganado la Carrera");
                    carro1.setValue(0);
                    carro1.setMaximum(0);
                    carro2.setValue(0);
                    carro2.setMaximum(0);
                    carro3.setValue(0);
                    carro3.setMaximum(0);
                    car1.setText("-");
                    car2.setText("-");
                    car3.setText("-");
                    g.clearSelection();
                    c1.setText(null);
                    c2.setText(null);
                    c3.setText(null);
                    meta.setText(null);
                    meta.setEditable(true);
                    registrarNombres();

                }

            } else if (dados == e.getSource() && c2.isSelected()) {
                dadosRandom();
                carro2.setValue(carro2.getValue() + (avanceDados * 100));
                car2.setText("+" + (avanceDados * 100));
                carro2.setMaximum(Integer.parseInt(meta.getText().trim()));
                contCar2++;
                if (carro2.getValue() >= carro2.getMaximum()) {
                    registro();
                    bw.append("\n=====//=====//=====//=====//=====//=====//=====//");
                    bw.append("\n" + nom2 + " es el ganador.... \n" + nom1 + " y " + nom3 + " han perdido.");
                    bw.close();
                    posiciones.append("\n" + nom2 + " es el ganador....");
                    JOptionPane.showMessageDialog(null, nom2 + " ha Ganado la Carrera");
                    carro1.setValue(0);
                    carro1.setMaximum(0);
                    carro2.setValue(0);
                    carro2.setMaximum(0);
                    carro3.setValue(0);
                    carro3.setMaximum(0);
                    car1.setText("-");
                    car2.setText("-");
                    car3.setText("-");
                    g.clearSelection();
                    c1.setText(null);
                    c2.setText(null);
                    c3.setText(null);
                    meta.setText(null);
                    meta.setEditable(true);
                    registrarNombres();
                }

            } else if (dados == e.getSource() && c3.isSelected()) {
                dadosRandom();
                carro3.setValue(carro3.getValue() + (avanceDados * 100));
                car3.setText("+" + (avanceDados * 100));
                carro3.setMaximum(Integer.parseInt(meta.getText().trim()));
                contCar3++;
                if (carro3.getValue() >= carro3.getMaximum()) {
                    registro();
                    bw.append("\n=====//=====//=====//=====//=====//=====//=====//");
                    bw.append("\n" + nom3 + " es el ganador.... \n" + nom1 + " y " + nom2 + " han perdido.");
                    bw.close();
                    posiciones.append("\n" + nom3 + " es el ganador....");
                    JOptionPane.showMessageDialog(null, nom3 + " ha Ganado la Carrera");
                    carro1.setValue(0);
                    carro1.setMaximum(0);
                    carro2.setValue(0);
                    carro2.setMaximum(0);
                    carro3.setValue(0);
                    carro3.setMaximum(0);
                    car1.setText("-");
                    car2.setText("-");
                    car3.setText("-");
                    g.clearSelection();
                    c1.setText(null);
                    c2.setText(null);
                    c3.setText(null);
                    meta.setText(null);
                    meta.setEditable(true);
                    registrarNombres();
                } else {
//                JOptionPane.showMessageDialog(null, " Error!!!!");
                }

            }

        } catch (Exception a) {

        }

        if (resetear == e.getSource()) {
            carro1.setValue(0);
            carro1.setMaximum(0);
            carro2.setValue(0);
            carro2.setMaximum(0);
            carro3.setValue(0);
            carro3.setMaximum(0);
            car1.setText("-");
            car2.setText("-");
            car3.setText("-");
            g.clearSelection();
            meta.setText(null);
            meta.setEditable(true);
        }

        if (cerrar == e.getSource()) {
            System.exit(0);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        val.validarNumeros(meta, e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
