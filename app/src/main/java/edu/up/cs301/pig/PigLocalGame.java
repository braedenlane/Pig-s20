package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState offState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        offState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(offState.getTurn() == playerIdx) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction) {
            if(offState.getTurn() == 0) {
                offState.setScore0(offState.getScore0() + offState.getCurrentAdd());
                if(players.length == 2) {
                    offState.setTurn(1);
                }
            } else if(this.offState.getTurn() == 1) {
                offState.setScore1(offState.getScore1() + offState.getCurrentAdd());
                if(players.length == 2) {
                    offState.setTurn(0);
                }
            }
            offState.setCurrentAdd(0);
            return true;
        } else if(action instanceof PigRollAction) {
            offState.setDieVal((int)(1+(Math.random()*6)));
            if(offState.getDieVal() != 1) {
                offState.setCurrentAdd(offState.getCurrentAdd() + offState.getDieVal());
            } else {
                offState.setCurrentAdd(0);
                if (players.length == 2) {
                    if (offState.getTurn() == 0) {
                        offState.setTurn(1);
                    } else {
                        offState.setTurn(0);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(offState);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(offState.getScore0() >= 50) {
            return playerNames[0] + " has won the game with " + offState.getScore0() + " points. ";
        } else if(offState.getScore1() >= 50) {
            return playerNames[1] + " has won the game with " + offState.getScore1() + " points. ";
        } else {
            return null;
        }
    }

}// class PigLocalGame
