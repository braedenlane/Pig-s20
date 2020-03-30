package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    public int turn;
    public int score0;
    public int score1;
    public int currentAdd;
    public int dieVal;

    public PigGameState() {
        this.turn = 0;
        this.score0 = 0;
        this.score1 = 0;
        this.currentAdd = 0;
        this.dieVal = 1;
    }

    public PigGameState(PigGameState p) {
        this.turn = p.turn;
        this.score0 = p.score0;
        this.score1 = p.score1;
        this.currentAdd = p.currentAdd;
        this.dieVal = p.dieVal;
    }

    public int getTurn() {
        return this.turn;
    }

    public int getScore0() {
        return this.score0;
    }

    public int getScore1() {
        return this.score1;
    }

    public int getCurrentAdd() {
        return this.currentAdd;
    }

    public int getDieVal() {
        return this.dieVal;
    }

    public void setTurn(int i) {
        this.turn = i;
    }

    public void setScore0(int i) {
        this.score0 = i;
    }

    public void setScore1(int i) {
        this.score1 = i;
    }

    public void setCurrentAdd(int i) {
        this.currentAdd = i;
    }

    public void setDieVal(int i) {
        this.dieVal = i;
    }


}
