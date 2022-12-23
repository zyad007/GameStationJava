/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 *
 * @author adham
 */
public class Connect4Server {
        public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(59071)) {
            System.out.println("Connect Four Server is Running...");
            ExecutorService pool = Executors.newFixedThreadPool(200);
            while (true) {
                GameConnect4 game = new GameConnect4();
                pool.execute(game.new Player(listener.accept(), '1'));
                pool.execute(game.new Player(listener.accept(), '2'));
            }
        }
    }
    
} 
class GameConnect4 {
    // the game logic 
    
    private String[][] board ;
    private int counter[]={6,6,6,6,6,6,6} ;
    public GameConnect4()
    {   // constructor
        board = new String[6][7];   
    }
    Player currentPlayer;
    
    private String checkVerticalWinner()
   {
       String symbol = null ;
       
       for(int i=0 ; i<3 ; i++)
       {
           for(int j=0 ; j<7 ; j++ )
           {
               if((board[i][j]==board[i+1][j]) && (board[i][j]== board[i+2][j]) && (board[i][j] == board[i+3][j]))
               {
                  if(board[i][j]=="1")
                  {
                      return symbol="player1_wins";
                  }
                  else if(board[i][j]=="2")
                  {
                      return symbol="player2_wins";
                  }
               }
                
           }
       }
         return symbol="draw";
    }
     private String checkhorizontalWinner()
   {
       String symbol = null ;
       for(int i=0 ; i<6 ; i++)
       {
           for(int j=0 ; j<4 ; j++ )
           {
               if((board[i][j]==board[i][j+1]) && (board[i][j]== board[i][j+2]) && (board[i][j] == board[i][j+3]))
               {
                  if(board[i][j]=="1")
                  {
                      return symbol="player1_wins";
                  }
                  else if(board[i][j]=="2")
                  {
                      return symbol="player2_wins";
                  }
               }
               
           }
       }
         return symbol="draw";
    }
      private String checkLeftDaiagonalWinner()
   {
       String symbol = null ;
       for(int i=0 ; i<3 ; i++)
       {
           for(int j=0 ; j<4 ; j++ )
           {
               if((board[i][j]==board[i+1][j+1]) && (board[i][j]== board[i+2][j+2]) && (board[i][j] == board[i+3][j+3]))
               {
                  if(board[i][j]=="1")
                  {
                      return symbol="player1_wins";
                  }
                  else if(board[i][j]=="2")
                  {
                      return symbol="player2_wins";
                  }
               }
               
           }
       }
         return symbol="draw";
    }
      private String checkRightDaiagonalWinner()
   {
       String symbol = null ;
       for(int i=0 ; i<3 ; i++)
       {
           for(int j=4 ; j<0 ; j-- )
           {
               if((board[i][j]==board[i+1][j-1]) && (board[i][j]== board[i+2][j-2]) && (board[i][j] == board[i+3][j-3]))
               {
                  if(board[i][j]=="1")
                  {
                      return symbol="player1_wins";
                  }
                  else if(board[i][j]=="2")
                  {
                      return symbol="player2_wins";
                  }
               }
               
           }
       }
         return symbol="draw";
    }
    private int checkWinner()
    {
        if( (checkVerticalWinner()=="player1_wins") || (checkhorizontalWinner()=="player1_wins") || (checkLeftDaiagonalWinner()=="player1_wins") || (checkRightDaiagonalWinner()=="player1_wins"))
        {
          return 1 ;  
        }
        if( (checkVerticalWinner()=="player2_wins") || (checkhorizontalWinner()=="player2_wins") || (checkLeftDaiagonalWinner()=="player2_wins") || (checkRightDaiagonalWinner()=="player2_wins"))
        {
          return 2 ;  
        }
        else 
        {
            return 0 ;
        }
        
    }
    private boolean board_isFull()
    {   boolean isFull = true ;
        for(int i=0 ; i<6 ; i++)
        {
            for(int j=0 ; j<7 ; j++)
            {
                if(board[i][j] !="1" && board[i][j] !="2")
                {
                    isFull = false ;
                }
            }
        }
        return isFull ;
    }
    private int checkDraw()
    {
        if(board_isFull() && (checkWinner() != 1 || checkWinner() !=2)  )
        {
            return 1 ;
        }
        else
        {
            return 0 ;
        }
    }
    

    
    
    public int hasWinner() {
        if(currentPlayer.id == '2' && checkWinner()==1 ) return 1;
        if(currentPlayer.id == '1' && checkWinner()==2) return 1;
        if(checkDraw()==1) return -1 ;
        return 0;
    }
    
    public synchronized String move(int step, Player player) {
        if (player != currentPlayer) {
            throw new IllegalStateException("Not your turn");
        } else if (player.opponent == null) {
            throw new IllegalStateException("You don't have an opponent yet");
        } 
         int x = step ;
         
         int y = counter[step];
         if(y==0)
         {
            throw new IllegalStateException("Coloum is Full");
         }
          if(x>7)
         {
            throw new IllegalStateException("Worng input");
         }
         String S = ""+x+" "+y ;
        if(player.id == '1') {
           board[step][counter[step]] = "1" ;
          
           counter[step] = counter[step]-1 ;
           
         
        }else {
              board[step][counter[step]] = "2" ;
          
           
               counter[step]-- ;
           
          
        }
        
        currentPlayer = currentPlayer.opponent;
        return S ;
    }
    
    
    class Player implements Runnable{
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
            
            System.out.println("Player "+ id +" is here!");
            
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
                String Move = move(location, this);
                this.output.println("MOVED " + Move);
                opponent.output.println("OPPONENT_MOVED " + Move );
                if (hasWinner() == 1) {
                    output.println("VICTORY");
                    opponent.output.println("DEFEAT");
                }
            else if(hasWinner()==-1)
                    { output.println("TIE");
                        opponent.output.println("TIE");
                    
                   }
            } catch (IllegalStateException e) {
                output.println("MESSAGE " + e.getMessage());
            }
        }
    
}

}

 