package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A multithreaded chat room server. When a client connects the server requests
 * a screen name by sending the client the text "SUBMITNAME", and keeps
 * requesting a name until a unique one is received. After a client submits a
 * unique name, the server acknowledges with "NAMEACCEPTED". Then all messages
 * from that client will be broadcast to all other clients that have submitted a
 * unique screen name. The broadcast messages are prefixed with "MESSAGE".
 *
 * This is just a teaching example so it can be enhanced in many ways, e.g.,
 * better logging. Another is to accept a lot of fun commands, like Slack.
 */
public class ChatServer {
    
    // All client names, so we can check for duplicates upon registration.
    private static Set<String> names = new HashSet<>();

    // The set of all the print writers for all the clients, used for broadcast.
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        try (ServerSocket listener = new ServerSocket(59001)) {
            while (true) {
                Handler handler = new  Handler();
                pool.execute(handler.new Client(listener.accept()));
                pool.execute(handler.new Client(listener.accept()));
            }
        }
    }

    /**
     * The client handler task.
     */
    private static class Handler {
        
        private Client client1;
        private Client client2;
        
        
        private class Client implements Runnable {
            private Socket socket;
            private Scanner in;
            private PrintWriter out;
            private String name;
            
            public Client(Socket socket) {
                this.socket = socket;
            }
            
            public void run() {
                try {
                    in = new Scanner(socket.getInputStream());
                    out = new PrintWriter(socket.getOutputStream(), true);
                    name = in.nextLine();
                    
                    if(client1  == null) {
                        client1 = this;
                        client1.out.println( "MESSAGE You joined!");
                        System.out.println("User 1 Joined " + name);
                    } else   {
                        client2 = this;
                        client2.out.println( "MESSAGE You joined!");
//                        client1.out.println( "MESSAGE " +name+ ": has joined!");
                        System.out.println("User 2 Joined " + name);
                    }
                    while(in.hasNextLine()) {
                        String response = in.nextLine();
                        if(response.startsWith("MESSAGE ")) {
                            String message = response.substring(7);
                            client1.out.println("MESSAGE " + name + ":" + message);
                            client2.out.println("MESSAGE " + name + ":" + message);
                        } else if(response.startsWith("QUIT")) {
                            client1 = null;
                            client2 = null;
                        }
                        if( client1 == null && client2 == null) {
                            break;
                        }
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                    }
                }
            } 
        } 
    }
}