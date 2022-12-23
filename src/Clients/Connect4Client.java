/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clients;
import GUI.Games.jSnakeLadder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author adham
 */
public class Connect4Client {
     private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private jSnakeLadder _jConnect4; // TO BE FOR CONNECT 4
    
    public Connect4Client(jSnakeLadder ssg) {
        _jConnect4 = ssg;
        try{
        socket = new Socket("localhost", 59071);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        }catch(Exception e) {
            
        }
        
        new Thread(new Runnable() {
            public void run() {
                try {
                    play();
                } catch (Exception ex) {
                    System.out.println("Play chatch");
                }
            }
        }).start();
    }
        public void play() throws Exception {
        try {
            String response = in.nextLine();
            char mark = response.charAt(8);
            char opponentMark = mark == '1' ? '2' : '1';
            System.out.println("Connect 4 player: Player " + mark);
            while (in.hasNextLine()) {
                response = in.nextLine();
                
                if (response.startsWith("MOVED")) {
                    String string_number = response.substring(6) ;
                    StringTokenizer st = new StringTokenizer(string_number);
                    int rows , coloums ;
                    rows = Integer.parseInt(st.nextToken());
                    coloums = Integer.parseInt(st.nextToken());
                    
                    
                    _jConnect4.setTextMessage("You moved to: " + rows +" "+coloums);
                    _jConnect4.setPlayerLocation(rows , coloums); // MUST TAKE ROW AND COL In jConnect4
                    
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    
                    
                    String string_number = response.substring(15);
                    StringTokenizer st2 = new StringTokenizer(string_number);
                    int rows , coloums ;
                    rows = Integer.parseInt(st2.nextToken());
                    coloums = Integer.parseInt(st2.nextToken());
                    _jConnect4.setTextMessage("Opponent moved to: "+rows+" "+coloums+", your turn");
                    _jConnect4.setOponentLocation(rows , coloums); // MUST TAKE ROW ANC COL IN jConnect4
                    
                } else if (response.startsWith("MESSAGE")) {
                    
                    _jConnect4.setTextMessage(response.substring(8));
                    
                } else if (response.startsWith("VICTORY")) {
                    
                    _jConnect4.showDialog("Winner Winner");
                    break;
                    
                } else if (response.startsWith("DEFEAT")) {
                    
                    _jConnect4.showDialog("Sorry you lost");
                    break;
                    
                } else if (response.startsWith("OTHER_PLAYER_LEFT")) {
                    
                   _jConnect4.showDialog("Other player left");
                    break;
                }
            }
            out.println("QUIT");
            _jConnect4.quitGame();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    public void MOVE(int step) {
        out.println("MOVE "+ step);
    }
    
    public void QUIT() {
        out.println("QUIT");
    }    
    
}
