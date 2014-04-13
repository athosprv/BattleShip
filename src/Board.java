
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kimchi
 */
public class Board  {

    private int x, y;
    private Object[][] board;
    private Vector<BattleShip> BShipList = new Vector<BattleShip>();

    /**
     *
     * @param x
     * @param y
     */
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getx() {
        return this.x;
    }

    /**
     *
     * @return
     */
    public int gety() {
        return this.y;
    }
    
    /**
     *
     * @param bs
     * @param path
     */
    public void applyMovementPath(BattleShip bs, String path) {
        String start = bs.toString();
        BattleShip bs2 = new BattleShip(bs.getX(), bs.getY(), bs.getDirection());

        for (int i = 0; i < path.toLowerCase().length(); i++) {
            boolean move = (path.length() - 1) == i;

            switch (path.charAt(i)) {
                case 'm':
                    bs2 = moveForward(bs2, (move));
                    System.out.println("Moving forward." + bs2.toString());
                    break;
                case 'r':
                    bs2 = turn(bs2, 'r');
                    System.out.println("Turning Right." + bs2.toString());
                    break;
                case 'l':
                    bs2 = turn(bs2, 'l');
                    System.out.println("Turning Left." + bs2.toString());
                    break;
                default:
                    System.out.println("Invalid action. Stopping");
                    break;

            }

        }
        if(this.BShipList.size()>0)
            System.out.println("Battleship originating from: " + start + " has now stopped at: " + this.BShipList.get(this.BShipList.indexOf(bs2)).toString());
        else
            System.out.println("No Ships on the Board");
    }

    /**
     *
     * @param ind
     * @param stat
     */
    public void setBshipStatus(int ind, boolean stat) {
        if(this.BShipList.size()>0)
        this.BShipList.get(ind).setStatus(stat);
    }

    /**
     *
     * @param ind
     * @return
     */
    public boolean getBshipStatus(int ind) {
        return this.BShipList.get(ind).getStatus();
    }

    /**
     *
     * @param ship
     */
    public void addBShip(BattleShip ship) {
        this.BShipList.add(ship);
    }

    /**
     *
     * @return
     */
    public Vector<BattleShip> getBShipList() {
        return this.BShipList;
    }

    /**
     *
     * @param list
     */
    public void setBShipList(Vector<BattleShip> list) {
        this.BShipList = list;
    }

    /**
     *
     */
    public void initialize() {
        this.board = new String[this.x][this.y];
        /* for(int i = 0; i<x; i++)
         for(int j = 0; j<y; j++)
         board[i][j] = (Object)(i+j + "");
        
         System.out.println(board[2][4]);*/
        for (Object[] row : this.board) {
            Arrays.fill(row, "*");
        }
    }

    /**
     *
     */
    public void printBoard() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private BattleShip moveForward(BattleShip bs, boolean lastMove) {

        BattleShip bs2 = new BattleShip(bs.getX(), bs.getY(), bs.getDirection());
        String direction = bs.getDirection().toLowerCase();
        switch (direction) {
            case "n":

                if (this.getBShipList().contains(new BattleShip(bs.getX() - 1, bs.getY(), ""))) {
                    if (lastMove == true) {
                        System.out.println("Another Battle ship exists at: " + bs.location() + ". Stopping");
                    }
                }
                if ((bs.getX() - 1) >= 0) {
                    bs2 = new BattleShip((bs.getX() - 1), bs.getY(), bs.getDirection());
                } else {
                    System.out.println("Attempting to move outside map. Action Cancelled.");
                }
                break;
            case "s":
                if (this.getBShipList().contains(new BattleShip(bs.getX() + 1, bs.getY(), ""))) {
                    if (lastMove == true) {
                        System.out.println("Another Battle ship exists at: " + bs.location() + ". Stopping");
                    }
                }
                if ((bs.getX() + 1) <= (this.getx() - 1)) {
                    bs2 = new BattleShip((bs.getX() + 1), bs.getY(), bs.getDirection());

                } else {
                    System.out.println("Attempting to move outside map. Action Cancelled.");
                }

                break;
            case "e":
                if (this.getBShipList().contains(new BattleShip(bs.getY() + 1, bs.getY(), ""))) {
                    if (lastMove == true) {
                        System.out.println("Another Battle ship exists at: " + bs.location() + ". Stopping");
                    }
                }
                if ((bs.getY() + 1) <= (this.gety() - 1)) {
                    bs2 = new BattleShip(bs.getX(), (bs.getY() + 1), bs.getDirection());
                } else {
                    System.out.println("Attempting to move outside map. Action Cancelled.");
                }
                break;
            case "w":
                if (this.getBShipList().contains(new BattleShip(bs.getY() - 1, bs.getY(), ""))) {
                    if (lastMove == true) {
                        System.out.println("Another Battle ship exists at: " + bs.location() + ". Stopping");
                    }
                }
                if ((bs.getY() - 1) >= 0) {
                    bs2 = new BattleShip(bs.getX(), (bs.getY() - 1), bs.getDirection());
                } else {
                    System.out.println("Attempting to move outside map. Action Cancelled.");
                }
                break;
        }
        this.BShipList.set(this.BShipList.indexOf(bs), bs2);
        return bs2;
    }

    private BattleShip turn(BattleShip bs, char turn) {

        BattleShip bs2 = new BattleShip(bs.getX(), bs.getY(), bs.getDirection());
        String direction = bs.getDirection();
        switch (direction.toLowerCase()) {
            case "n":
                if (turn == 'r') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "e");
                } else if (turn == 'l') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "w");
                }
                break;
            case "s":
                if (turn == 'r') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "w");
                } else if (turn == 'l') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "e");
                }

                break;
            case "e":
                if (turn == 'r') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "s");
                } else if (turn == 'l') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "n");
                }

                break;
            case "w":
                if (turn == 'r') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "n");
                } else if (turn == 'l') {
                    bs2 = new BattleShip(bs.getX(), bs.getY(), "s");
                }

                break;
        }
        this.BShipList.set(this.BShipList.indexOf(bs), bs2);
        return bs2;
    }
}
