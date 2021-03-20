package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import model.BotAbstractFactory;
import model.HumanPlayer;
import model.Level3Bot;
import model.P4BoardImpl;
import model.P4BoardItf;
import model.P4Player;
import model.Run;

public class Test {
	
	BotAbstractFactory factory=null;
    P4Player p2 = null;
    @BeforeClass
    public static void setUp() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        BotAbstractFactory factory = null;
        P4Player p2 = null;
    }
    
    @org.junit.Test
    public void testPlayer() {
        BotAbstractFactory factory = new Level3Bot();
        P4Player p2 = factory.create();

        String str= p2.getName();
        assertEquals(str,"Level3Bot");
    }
    
    @org.junit.Test
    public void runGame() {
    	P4BoardItf board = P4BoardImpl.createintance();
        BotAbstractFactory factory = new Level3Bot();


        P4Player p1 = factory.create();
        P4Player p2 = factory.create();
        board.init(p1, p2);
        Run.run(board);

    }

}
