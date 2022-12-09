import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;

public class j1Frame extends JFrame {
   static j1Panel[] pan;

    public j1Frame() throws Exception {
        JFrame f = new JFrame();
        GridLayout layout = new GridLayout(7,7);
        Border bor  = new LineBorder(Color.BLACK);
      pan = new j1Panel[49];

        f.setLayout(layout);
            int x = 1;
            int y =1;
            for (int i =0;i< 49;i++) {
                pan[i] = new j1Panel();
                pan[i].setIndice(i);
                pan[i].setXpos(x);
                pan[i].setYpos(y);
                if(x == 7){
                    x=0;
                    y = y + 1;
                }
                x++;
            pan[i].setBackground(Color.blue);
            pan[i].setBorder(bor);
            pan[i].addMouseListener(new j1mouseListner(this));
            f.add(pan[i]);
        }
            f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public j1Panel[] getPan() {
        return pan;
    }

    public void setPan(j1Panel[] pant) {
        pan = pant;
    }

    public static void main(String[] args) throws Exception {
        new j1Frame();
    }
}

/*

*/

