
package chess;

import java.awt.Color;

public class Player {
    
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private int index;   

    public static void Reset()
    {
        players[0] = new Player(1);
        players[1] = new Player(2);
        currentTurn = players[0];
    }
    public static Player GetCurrentPlayer()
    {
        return(currentTurn);
    }
    public static void SwitchTurn()
    {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }    
    
    Player(int _index)
    {
        index = _index;
    }
    public static Player getPlayer1()
    {
        return (players[0]);
    }
    public static Player getPlayer2()
    {
        return (players[1]);
    }

        
}