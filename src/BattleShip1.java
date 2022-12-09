
import java.io.IOException;
import java.net.Socket;

public class BattleShip1 {
    int attempts = 1;
    int[] mitifitra= new int[2];
    Socket client = null;

     int[] val= new int[2];
    static Fonction1 fonc= new Fonction1();

    public BattleShip1() throws Exception {
    }

    public void alefa(int[] shoot) throws IOException {


        Fonction fcnt = new Fonction();
        int[][] board = new int[7][7];		// le plateau de jeu
        int[][] ships = new int[5][2];
        int     					// essaye
                shipTouched;					// bateau touche

        fcnt.initBoard(board);
        fcnt.initShips(ships);

        System.out.println();

  attempts = 1;
            fcnt.showBoard(board);

            mitifitra=fcnt.shoot(shoot);
            if(client == null) {
                client = new Socket("localhost", 9124);
            }
        val=fonc.commClient(mitifitra,client);
            if(fcnt.hit(fcnt.getObj(),ships)){
                fcnt.indice(fcnt.getObj(),ships,attempts);

            }
            else
                fcnt.indice(fcnt.getObj(),ships,attempts);

            fcnt.changeboard(fcnt.getObj(),ships,board);

    attempts++;

        //System.out.println("\n\n\nYou Lose the game ");
        //fcnt.showBoard(board);
    }

    public  int[] getMitifitra() {
        return mitifitra;
    }

    public  void setMitifitra(int[] mitifitra) {
        BattleShip.mitifitra = mitifitra;
    }


}
