/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clients;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Zyad
 */
public class ChatClient {
    public static void main(String[] args) {
        try{
        Socket socket = new Socket("localhost", 59001);
        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        Scanner scanner = new Scanner(System.in);
        
//        out.println("Zyad");
//        System.out.println(in.nextLine());
        
        new Thread(new Runnable() {
            public void run() {
                try {
                    while(in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
                } catch (Exception ex) {
                    System.out.println("Play chatch");
                }
            }
        }).start();
        
        while(scanner.hasNextLine()) {
            String message = scanner.nextLine();
            out.println(message);
        }
        
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
