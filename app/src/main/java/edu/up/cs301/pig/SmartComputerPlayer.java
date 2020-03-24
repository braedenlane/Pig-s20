package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

public class SmartComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public SmartComputerPlayer(String name) {
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
        if(info instanceof PigGameState) {
            PigGameState state = (PigGameState) info;
            if (state.getTurn() != playerNum) {
                return;
            } else {
                if (playerNum == 0) {
                    if (state.getCurrentAdd() >= 50 - state.getScore0()) {
                        PigHoldAction action = new PigHoldAction(this);
                        game.sendAction(action);
                    } else {
                        if (state.getScore1() > state.getScore0() && (state.getScore1() - state.getScore0() > 10)) {
                            if (state.getCurrentAdd() >= state.getScore1() - state.getScore0()) {
                                PigHoldAction action = new PigHoldAction(this);
                                game.sendAction(action);
                            } else {
                                PigRollAction action = new PigRollAction(this);
                                game.sendAction(action);
                            }
                        } else {
                            if (state.getCurrentAdd() >= 10) {
                                PigHoldAction action = new PigHoldAction(this);
                                game.sendAction(action);
                            } else {
                                PigRollAction action = new PigRollAction(this);
                                game.sendAction(action);
                            }
                        }
                    }
                } else {
                    if (state.getCurrentAdd() >= 50 - state.getScore1()) {
                        PigHoldAction action = new PigHoldAction(this);
                        game.sendAction(action);
                    } else {
                        if (state.getScore0() > state.getScore1() && (state.getScore0() - state.getScore1() > 10)) {
                            if (state.getCurrentAdd() >= state.getScore0() - state.getScore1()) {
                                PigHoldAction action = new PigHoldAction(this);
                                game.sendAction(action);
                            } else {
                                PigRollAction action = new PigRollAction(this);
                                game.sendAction(action);
                            }
                        } else {
                            if (state.getCurrentAdd() >= 10) {
                                PigHoldAction action = new PigHoldAction(this);
                                game.sendAction(action);
                            } else {
                                PigRollAction action = new PigRollAction(this);
                                game.sendAction(action);
                            }
                        }
                    }
                }
            }
        }
    }//receiveInfo

}
