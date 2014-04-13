/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kimchi
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getx method, of class Board.
     */
    @Test
    public void testGetx() {
        System.out.println("getx");
        Board instance = new Board(5,5);
        
        int expResult = 5;
        int expResult2 = 6;
        int result = instance.getx();
        assertEquals(expResult, result);
        assertFalse(expResult2 == result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of gety method, of class Board.
     */
    @Test
    public void testGety() {
        System.out.println("gety");
        Board instance = new Board(5,5);
        int expResult = 5;
        int expResult2 = 6;
        int result = instance.gety();
        assertEquals(expResult, result);
        assertFalse(expResult2 == result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of applyMovementPath method, of class Board.
     */
    @Test
    public void testApplyMovementPath() {
        System.out.println("applyMovementPath");
        BattleShip bs = new BattleShip(1,2,"S");
        String path = "LRR";
        Board instance = new Board(5,5);        
        instance.addBShip(bs);
        instance.applyMovementPath(bs, path);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setBshipStatus method, of class Board.
     */
    @Test
    public void testSetBshipStatus() {
        System.out.println("setBshipStatus");
        int ind = 0;
        boolean stat = false;
        
        BattleShip bs = new BattleShip(1,2,"S");
        Board instance = new Board(4,4);
        instance.addBShip(bs);
        boolean b = instance.getBshipStatus(ind);                
        instance.setBshipStatus(ind, true);
        assertEquals(instance.getBshipStatus(ind), true);
        stat = false;
        instance.setBshipStatus(ind, stat);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getBshipStatus(ind), false);
        
    }

    /**
     * Test of getBshipStatus method, of class Board.
     */
    @Test
    public void testGetBshipStatus() {
        System.out.println("getBshipStatus");
        
        BattleShip bs = new BattleShip(1,2,"S");
        
        int ind = 0;
        Board instance = new Board(4,4);
        instance.addBShip(bs);
                
        boolean result = instance.getBshipStatus(ind);
        assertEquals(result, true);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of addBShip method, of class Board.
     */
    @Test
    public void testAddBShip() {
        System.out.println("addBShip");
        BattleShip ship = null;
        Board instance = new Board(2,2);
        instance.addBShip(ship);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getBShipList().size(), 1);
        instance.addBShip(ship);        
        assertEquals(instance.getBShipList().size(), 2);
    }

    /**
     * Test of getBShipList method, of class Board.
     */
    @Test
    public void testGetBShipList() {
        System.out.println("getBShipList");
        Board instance = new Board(5,3);
        BattleShip ship = null;
        ArrayList<BattleShip> expResult = new ArrayList<>();
        expResult.add(ship);
        Vector<BattleShip> result = instance.getBShipList();
        
        result.add(ship);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setBShipList method, of class Board.
     */
    @Test
    public void testSetBShipList() {
        System.out.println("setBShipList");
        Vector<BattleShip> list = null;
        Board instance = new Board(4,4);
        instance.setBShipList(list);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(list, instance.getBShipList());
    }

    /**
     * Test of initialize method, of class Board.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Board instance = new Board(5,7);
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getx(), 5);
        assertEquals(instance.gety(), 7);
    }

    /**
     * Test of printBoard method, of class Board.
     */
    @Test
    public void testPrintBoard() {
        System.out.println("printBoard");
        Board instance = null;
        instance.printBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    
}
