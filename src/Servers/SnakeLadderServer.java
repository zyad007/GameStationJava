/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A server for a multi-player tic tac toe game. Loosely based on an example in
 * Deitel and Deitel’s “Java How to Program” book. For this project I created a
 * new application-level protocol called TTTP (for Tic Tac Toe Protocol), which
 * is entirely plain text. The messages of TTTP are:
 *
 * Client -> Server MOVE <n> QUIT
 *
 * Server -> Client WELCOME <char> VALID_MOVE OTHER_PLAYER_MOVED <n>
 * OTHER_PLAYER_LEFT VICTORY DEFEAT TIE MESSAGE <text>
 */
public class SnakeLadderServer {

    public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(58901)) {
            System.out.println("Snake Stairs Server is Running...");
            ExecutorService pool = Executors.newFixedThreadPool(200);
            while (true) {
                GameSnakeLadder game = new GameSnakeLadder();
                pool.execute(game.new Player(listener.accept(), '1'));
                pool.execute(game.new Player(listener.accept(), '2'));
            }
        }
    }
}

class GameSnakeLadder {

    //3x3 = 36 steps
    private int locP1 = 1, locP2 = 1;
    private int FINISH_LOCATION = 100;
    private int[] snakeHeads = {17, 62, 64 , 98 , 95 ,87 , 93 , 54}; // Todo -> make a func that generates this randomly
    private int[] snakeTails = {7, 19, 60 , 79 , 75 , 36 , 73 ,34};
    private int[] ladderHeads = {38, 42, 99 , 84 , 14 , 31,67 , 91}; // Todo -> make a func that generates this randomly
    private int[] ladderTails = {1, 21 , 80 ,28 , 4 , 9 ,51,72};

    private int checkSnakeOrLadder(int location) {
        for (int i = 0; i < 3; i++) {
            if (location == snakeHeads[i]) {
                return snakeTails[i];
            }

            if (location == ladderTails[i]) {
                return ladderHeads[i];
            }
        }
        return location;
    }

    Player currentPlayer;

    public boolean hasWinner() {
        if (currentPlayer.id == '2' && locP1 >= FINISH_LOCATION) {
            return true;
        }
        if (currentPlayer.id == '1' && locP2 >= FINISH_LOCATION) {
            return true;
        }
        return false;
    }

    public synchronized void move(int step, Player player) {
        if (player != currentPlayer) {
            throw new IllegalStateException("Not your turn");
        } else if (player.opponent == null) {
            throw new IllegalStateException("You don't have an opponent yet");
        }

        if (player.id == '1') {
            locP1 += step;
            locP1 = checkSnakeOrLadder(locP1);
        } else {
            locP2 += step;
            locP2 = checkSnakeOrLadder(locP2);
        }

        currentPlayer = currentPlayer.opponent;
    }

    /**
     * A Player is identified by a character mark which is either 'X' or 'O'.
     * For communication with the client the player has a socket and associated
     * Scanner and PrintWriter.
     */
    class Player implements Runnable {

        char id;
        Player opponent;
        Socket socket;
        Scanner input;
        PrintWriter output;

        public Player(Socket socket, char id) {
            this.socket = socket;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                setup();
                processCommands();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (opponent != null && opponent.output != null) {
                    opponent.output.println("OTHER_PLAYER_LEFT");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

        private void setup() throws IOException {
            input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("WELCOME " + id);

            System.out.println("Player " + id + " is here!");

            if (id == '1') {
                currentPlayer = this;
                output.println("MESSAGE Waiting for opponent to connect");
            } else {
                opponent = currentPlayer;
                opponent.opponent = this;
                opponent.output.println("MESSAGE Your trun");
                output.println("MESSAGE Opponent trun");
            }
        }

        private void processCommands() {
            while (input.hasNextLine()) {
                String command = input.nextLine();
                if (command.startsWith("QUIT")) {
                    return;
                } else if (command.startsWith("MOVE")) {
                    processMoveCommand(Integer.parseInt(command.substring(5)));
                }
            }
        }

        private void processMoveCommand(int location) {
            try {
                move(location, this);
                this.output.println("MOVED " + ((this.id == '1') ? locP1 : locP2));
                opponent.output.println("OPPONENT_MOVED " + ((this.id == '1') ? locP1 : locP2));
                if (hasWinner()) {
                    output.println("VICTORY");
                    opponent.output.println("DEFEAT");
                }
            } catch (IllegalStateException e) {
                output.println("MESSAGE " + e.getMessage());
            }
        }
    }
}
