package edu.up.cs301.pig;

import org.junit.Test;

import static org.junit.Assert.*;

public class PigGameStateTest {

    @Test
    public void getTurn() {
        PigGameState gs = new PigGameState();
        gs.turn = 0;
        assertEquals(0, gs.getTurn());
    }

    @Test
    public void getScore0() {
        PigGameState gs = new PigGameState();
        gs.score0 = 20;
        assertEquals(20, gs.getScore0());
    }

    @Test
    public void getScore1() {
        PigGameState gs = new PigGameState();
        gs.score1 = 30;
        assertEquals(30, gs.getScore1());
    }

    @Test
    public void getCurrentAdd() {
        PigGameState gs = new PigGameState();
        gs.currentAdd = 12;
        assertEquals(12, gs.getCurrentAdd());
    }

    @Test
    public void getDieVal() {
        PigGameState gs = new PigGameState();
        gs.dieVal = 5;
        assertEquals(5, gs.getDieVal());
    }

    @Test
    public void setTurn() {
        PigGameState gs = new PigGameState();
        gs.turn = 0;
        assertEquals(0, gs.getTurn());
        gs.setTurn(1);
        assertEquals(1, gs.getTurn());
    }

    @Test
    public void setScore0() {
        PigGameState gs = new PigGameState();
        gs.score0 = 20;
        assertEquals(20, gs.getScore0());
        gs.setScore0(25);
        assertEquals(25, gs.getScore0());
    }

    @Test
    public void setScore1() {
        PigGameState gs = new PigGameState();
        gs.score1 = 30;
        assertEquals(30, gs.getScore1());
        gs.setScore1(35);
        assertEquals(35, gs.getScore1());
    }

    @Test
    public void setCurrentAdd() {
        PigGameState gs = new PigGameState();
        gs.currentAdd = 12;
        assertEquals(12, gs.getCurrentAdd());
        gs.setCurrentAdd(17);
        assertEquals(17, gs.getCurrentAdd());
    }

    @Test
    public void setDieVal() {
        PigGameState gs = new PigGameState();
        gs.dieVal = 5;
        assertEquals(5, gs.getDieVal());
        gs.setDieVal(3);
        assertEquals(3, gs.getDieVal());
    }
}