
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Fonction1 {
    static int[] obj = new int[2];
    Socket client;
    InputStream iso;
    ObjectInputStream messageret;
    public Fonction1(){}

    // initialiser le plateau de jeu
    public void initBoard(int[][] board) {
        for(int row=0 ; row < 7 ; row++ ) {
            for(int column=0 ; column < 7 ; column++ ) {
                board[row][column]=-1;
            }
        }
    }
    //Affichage du plateaux de jeu
    public void showBoard(int[][] board) {
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7");
        System.out.println();
        for(int row=0 ; row < 7 ; row++ ) {
            System.out.print((row+1)+"");
            for(int column=0 ; column < 7 ; column++ ) {
                if(board[row][column]==-1) {
                    System.out.print("\t"+"~");
                } else if(board[row][column]==0) {
                    System.out.print("\t"+"*");
                } else if(board[row][column]==1) {
                    System.out.print("\t"+"X");
                }
            }
            System.out.println(); System.out.println();
        }
    }

    public void initShips(int[][] ships){
        Random random = new Random();
        for(int ship=0 ; ship < 5 ; ship++){
            ships[ship][0]=random.nextInt(7);
            ships[ship][1]=random.nextInt(7);
            for(int last=0 ; last < ship ; last++){
                if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) ) {
                    while((ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1])) {
                        ships[ship][0]=random.nextInt(7);
                        ships[ship][1]=random.nextInt(7);
                    }
                }
            }
            System.out.println("ships[ship][0] :"+ships[ship][0]+1);
            System.out.println("ships[ship][1] :"+ships[ship][1]+1);
        }
    }

    public int[] shoot(int[] shoot){
        int[] mitifitra= new int[2];

        mitifitra[0]=shoot[0]-1;

        mitifitra[1]=shoot[1]-1;
        return mitifitra;
    }

    public boolean hit(int[] shoot, int[][] ships){
        for(int ship=0 ; ship<ships.length ; ship++){
            if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){
                System.out.printf("Touche! in (%d,%d)\n",shoot[0]+1,shoot[1]+1);
                return true;
            }
        }
        return false;
    }

    public void indice(int[] shoot, int[][] ships, int attempt){
        int row=0,
                column=0;
        for(int line=0 ; line < ships.length ; line++){
            if(ships[line][0]==shoot[0])
                row++;
            if(ships[line][1]==shoot[1])
                column++;
        }
        System.out.printf("\nAttempt %d: \nRow %d -> %d ships\n"+"Column %d -> %d ships\n",attempt,shoot[0]+1,row,shoot[1]+1,column);
    }

    public void changeboard(int[] shoot, int[][] ships, int[][] board){
        if(hit(shoot,ships))
            board[shoot[0]][shoot[1]]=1;
        else
            board[shoot[0]][shoot[1]]=0;
    }

    public int[] commClient(int[] mess, Socket client) {

this.setClient(client);
        Thre1 recevoir;
        try {

           // InputStream iso= client.getInputStream();
           // ObjectInputStream messageret = new ObjectInputStream(iso);


            recevoir = new Thre1(this,mess);

            recevoir.start();



          //  setObj((int[])messageret.readObject());





        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static int[] getObj() {
        return obj;
    }

    public static void setObj(int[] obj) {
        Fonction.obj = obj;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }
}

