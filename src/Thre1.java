
import java.io.*;

public class Thre1 extends Thread{
    Fonction1 fonc;
    int[] mess;


    @Override
    public void run() {
        try {
            OutputStream os = fonc.client.getOutputStream();
            ObjectOutputStream message = new ObjectOutputStream(os);
            fonc.iso = fonc.client.getInputStream();
            fonc.messageret = new ObjectInputStream(fonc.iso);

            message.writeObject(this.mess);
            if ((int[]) fonc.messageret.readObject()!= null){
                fonc.setObj((int[]) fonc.messageret.readObject());
            }else

            fonc.setObj((int[]) fonc.messageret.readObject());
            message.writeObject(this.mess);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Thre1(Fonction1 fonct, int[] mess) {
        fonc = fonct;
        this.mess = mess;
    }
}

