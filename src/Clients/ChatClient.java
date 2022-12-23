/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clients;

import GUI.jChat;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Zyad
 */
public class ChatClient {
    
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private jChat _jChat;
    
    public ChatClient(jChat js, String username) {
        _jChat = js;
        try{
        socket = new Socket("localhost", 59013);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        }catch(Exception e) {
            
        }
        
        out.println(username);
        
        new Thread(new Runnable() {
            public void run() {
                try {
                    handle();
                } catch (Exception ex) {
                    System.out.println("Play chatch");
                }
            }
        }).start();
    }
    
    private void handle() {
        while(in.hasNextLine()) {
            String responce = in.nextLine().substring(7);
            _jChat.pushMessage(responce.trim());
        }
    }
    
    public void MESSAGE(String message) {
        out.println("MESSAGE "+ message);
    }
    
    public void QUIT() {
        out.println("QUIT");
    }
}
