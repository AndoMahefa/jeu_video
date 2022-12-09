import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
	int attempts =1;
	static int[] mitifitra= new int[2];
	 int[] val= new int[2];

	static Fonction fonc = new Fonction();

	public BattleShip() throws Exception {
	}

	public  void alefa(int[] shoot) throws IOException {


		Fonction fcnt = new Fonction();
		int[][] board = new int[7][7];		// le plateau de jeu
		int[][] ships = new int[5][2];
		int     					// essaye
			shipTouched;					// bateau touche

		fcnt.initBoard(board);
		fcnt.initShips(ships);

		System.out.println();

			fcnt.showBoard(board);
			mitifitra=fcnt.shoot(shoot);


		val=fonc.commServeur(mitifitra);
			if(fcnt.hit(fcnt.getObj(),ships)){
				fcnt.indice(fcnt.getObj(),ships,attempts);

			}
			else
				fcnt.indice(fcnt.getObj(),ships,attempts);

			fcnt.changeboard(fcnt.getObj(),ships,board);
		attempts++;
		//	System.out.println("\n\n\nYou lose the game ");
	//	fcnt.showBoard(board);
	}

	public int[] getMitifitra() {
		return mitifitra;
	}

	public  void setMitifitra(int[] mitifitra) {
		this.mitifitra = mitifitra;
	}


}