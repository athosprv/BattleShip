/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class BattleShipTest {
    
    private BattleShip bs;
    
    public BattleShipTest() {
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
     * Test of getStatus method, of class BattleShip.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");          
        bs = new BattleShip(1,2,"n");
                
        assertEquals(bs.getStatus(), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class BattleShip.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        
        bs = new BattleShip(1,2,"n");
        bs.setStatus(false);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getStatus(), false);
    }

    /**
     * Test of getX method, of class BattleShip.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        bs = new BattleShip(1,2,"n");
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getX(), 1);
    }

    /**
     * Test of getY method, of class BattleShip.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");

        bs = new BattleShip(1,2,"n");
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getY(), 2);
    }

    /**
     * Test of setX method, of class BattleShip.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");

        bs = new BattleShip(3,4,"n");
        bs.setX(5);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getX(), 5);
    }

    /**
     * Test of setY method, of class BattleShip.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");

        bs = new BattleShip(3,4,"n");
        bs.setY(5);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getY(), 5);
    }

    /**
     * Test of location method, of class BattleShip.
     */
    @Test
    public void testLocation() {
        System.out.println("location");

        bs = new BattleShip(3,4,"N");
        String loc = bs.location();
        String testLoc = "(" + bs.getX() + ", " + bs.getY() + ")";     
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.location(), testLoc);        
    }

    /**
     * Test of getDirection method, of class BattleShip.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");

        bs = new BattleShip(3,4,"n");
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getDirection(), "n");        
        
    }

    /**
     * Test of setDirection method, of class BattleShip.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");

        bs = new BattleShip(3,4,"n");
        bs.setDirection("s");
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(bs.getDirection(), "s");
        //assertNotEquals(bs.getDirection(), "u");
    }

    /**
     * Test of toString method, of class BattleShip.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        bs = new BattleShip(3,4,"n");
        
        String ts = "(" + bs.getX() + ", " + bs.getY() + ") "+ bs.getDirection();                
        assertEquals(ts, bs.toString());
    }

    /**
     * Test of equals method, of class BattleShip.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        bs = new BattleShip(3,4,"n");
        BattleShip bs2 = new BattleShip(3,4,"n");
        
        assertEquals(bs, bs2);        
    }

    /**
     * Test of hashCode method, of class BattleShip.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        bs = new BattleShip(3,4,"n");
        BattleShip bs2 = new BattleShip(3,5,"n");
        BattleShip bs3 = new BattleShip(3,4,"n");
        
        assertEquals(bs, bs3); 
        assertFalse(bs.hashCode() == bs2.hashCode()); 
        
        
    }
    
}
