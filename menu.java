import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class menu extends JFrame implements ActionListener {

    private JLabel lbl;
    private JButton btnEdit;
    private JButton btnBorrar;
    private JButton btnAgregar;
    private JButton btnMostrar;
    Tarea tarea;
    ManejadorTareas LMT;

    public menu() {
        LMT=new ManejadorTareas();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MENU");
        setLayout(null);

        lbl = new JLabel("Inicio");
        lbl.setFont(new Font("Calibri", 2, 35));
        lbl.setBounds(170, 20, 200, 100);
        lbl.setVisible(true);
        add(lbl);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(255,0,0));
        btnBorrar.setBounds(10, 110, 100, 50);
        btnBorrar.setVisible(true);
        btnBorrar.addActionListener(this);
        add(btnBorrar);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(110, 110, 100, 50);
        btnMostrar.setVisible(true);
        btnMostrar.addActionListener(this);
        add(btnMostrar);

        btnEdit = new JButton("Editar");
        btnEdit.setBounds(210, 110, 100, 50);
        btnEdit.setVisible(true);
        btnEdit.setVisible(true);
        btnEdit.addActionListener(this);
        add(btnEdit);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(310, 110, 100, 50);
        btnAgregar.setVisible(true);
        btnAgregar.addActionListener(this);
        add(btnAgregar);

    }

    public void actionPerformed(ActionEvent e) {
        String mensaje;
        
        if (e.getSource() == btnBorrar) {
            // JOptionPane.showInputDialog(null,"caminar");
            mensaje = LMT.borrarTarea(
                    JOptionPane.showInputDialog(null, "Intrusca el elemento que desea eliminar", "Correr"));
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if (e.getSource() == btnAgregar) {
            mensaje = LMT
                    .agregarTarea(JOptionPane.showInputDialog(null, "Intrusca el elemento que desea agregar", "Correr"),
                            (JOptionPane.showConfirmDialog(null, "Esta va empezar una Tarea Si(Yes) o No(No)") == 1
                                    ? false
                                    : true));
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if (e.getSource() == btnEdit) {

            mensaje = LMT.editarTarea(LMT.getLista(),
                    JOptionPane.showInputDialog(null, "Intrusca el elemento que desea editar", "Correr"),
                    JOptionPane.showInputDialog(null, "Intrusca el nuevo Nombre", "Dormir"),
                    (JOptionPane.showConfirmDialog(null, "Esta va empezar una Tarea Si(Yes) o No(No)") == 1 ? false
                            : true));
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if (e.getSource() == btnMostrar) {
            mensaje = LMT.mostrarTareaTerminada();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public static void main(String[] args) {
        
        menu ventana = new menu();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setSize(420, 300);
    }
}