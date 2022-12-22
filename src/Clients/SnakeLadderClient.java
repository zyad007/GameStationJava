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

/**
 *
 * @author Zyad
 */
public class SnakeLadderClient {
    
//    private static SnakeLadderClient single_instance = null;
//    
//    public static SnakeLadderClient getInstance(jSnakeLadder ssg) {
//        if( single_instance == null) single_instance = new SnakeLadderClient(ssg);
//        return single_instance;
//    }
//    
//    public static void disposeInstance() {
//        single_instance = null;
//    }
    
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    
    public SnakeLadderClient(jSnakeLadder ssg) {
        _jSnakeLadder = ssg;
        try{
        socket = new Socket("localhost", 58901);
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
            String response = in.nextLine(); //WLECOME  {id}
            char mark = response.charAt(8);
            char opponentMark = mark == '1' ? '2' : '1';
            System.out.println("Snake Stairs: Player " + mark);
            while (in.hasNextLine()) {
                response = in.nextLine();
                
                if (response.startsWith("MOVED")) {
                    
                    int location = Integer.parseInt(response.substring(6));
                    _jSnakeLadder.setTextMessage("You moved to: " + location);
                    _jSnakeLadder.setPlayerLocation(location);
                    
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    
                    int loc = Integer.parseInt(response.substring(15));
                    _jSnakeLadder.setTextMessage("Opponent moved to: "+loc+", your turn");
                    _jSnakeLadder.setOponentLocation(loc);
                    
                } else if (response.startsWith("MESSAGE")) {
                    
                    _jSnakeLadder.setTextMessage(response.substring(8));
                    
                } else if (response.startsWith("VICTORY")) {
                    
                    _jSnakeLadder.showDialog("Winner Winner");
                    break;
                    
                } else if (response.startsWith("DEFEAT")) {
                    
                    _jSnakeLadder.showDialog("Sorry you lost");
                    break;
                    
                } else if (response.startsWith("OTHER_PLAYER_LEFT")) {
                    
                   _jSnakeLadder.showDialog("Other player left");
                    break;
                }
            }
            out.println("QUIT");
            _jSnakeLadder.quitGame();
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
    
    private jSnakeLadder _jSnakeLadder;
}
