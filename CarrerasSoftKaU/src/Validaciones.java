
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author orlan
 */
public class Validaciones {

    public void validarNumeros(JTextField t, KeyEvent e) { // SOLO NUMEROS  
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.consume();
        }
    }
}
