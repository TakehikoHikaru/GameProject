package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Frame extends Canvas {

    public static JFrame frame;
    public static int winWidth = 600;
    public static int winHeight = 600;
    public static int winScale = 1;

    public void newFrame(KeyListener keyBoard){
        addKeyListener(keyBoard);
        this.setPreferredSize(new Dimension(winWidth * winScale, winHeight * winScale));
        initFrame();
    }

    public void initFrame(){
        //cria a janela
        frame = new JFrame("ProjectFac");
        //adiciona as configurações na janela
        frame.add(this);
        //Set configurações da janela
        frame.setResizable(false);
        frame.pack();
        frame.requestFocus();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
