
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Thre extends Thread{
    Fonction fonc;
    int[] messag;

    public Thre(Fonction fonct, int[] mess) throws IOException {
        fonc = fonct;
        this.messag = messag;

    }


    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9124);
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            ObjectInputStream message = new ObjectInputStream(is);
            OutputStream os = client.getOutputStream();
            ObjectOutputStream messa = new ObjectOutputStream(os);


while(true) {

    fonc.setObj((int[]) message.readObject());

    messa.writeObject(this.messag);
    fonc.setObj((int[]) message.readObject());

}

            } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
