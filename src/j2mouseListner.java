import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class j2mouseListner implements MouseListener {
    j2Frame fr ;
    BattleShip1 bs = new BattleShip1();
    int[] shoot;


    public j2mouseListner(j2Frame fr) throws Exception {
        fr = fr;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shoot  = new int[2];
        j2Panel koto= (j2Panel)e.getSource();
        shoot[0] = koto.getXpos();
        shoot[1] = koto.getYpos();
        try {
            bs.alefa(shoot);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      /*  for (int i = 0; i < 49; i++) {
            System.out.println(fr.getPan()[i].getXpos());
            System.out.println(fr.getPan()[i].getYpos());
        }*/

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

