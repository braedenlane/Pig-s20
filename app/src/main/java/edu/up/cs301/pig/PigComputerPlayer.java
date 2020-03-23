package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.Game;
import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState state = (PigGameState)info;
        if(state.getTurn() != playerNum) {
            return;
        } else {
            int chance = (int)(1+(Math.random()*2));
            if(chance == 1) {
                PigRollAction action = new PigRollAction(this);
                game.sendAction(action);
            } else {
                PigHoldAction action = new PigHoldAction(this);
                game.sendAction(action);
            }
        }
    }//receiveInfo

}
