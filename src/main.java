
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kimchi
 */
public class main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Preliminary phase Initialized");
        System.out.println("=============================");

        Driver d = new Driver();
        Board myBoard = d.createBoard();
        System.out.println("Board Created");
        myBoard.initialize();
        //myBoard.printBoard();
        System.out.println("Board Initialized");

        System.out.println("Phase 1: Get Ready!");
        int numPlayers = d.enterNumPlayers();

        System.out.println(numPlayers + " Battleships have entered the Board");
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Battleship: " + (i + 1));
            move place = d.enterLocationAndDirection();
            BattleShip bs = new BattleShip(place.getX(), place.getY(), place.getDir());
            if (!myBoard.getBShipList().contains(bs)) {
                myBoard.addBShip(bs);
            } else {
                System.out.println("Ignored placing Battleship: " + bs.toString() + " as another exists on that location.");
            }
        }
        System.out.println("Phase 2: Game Begins!");
        int round = 1;
        while (true) {
            System.out.println("Round: " + round + " Begins.");
            BattleShip bs2;
            for (BattleShip bs : myBoard.getBShipList()) {
                if (bs.getStatus() == true) {
                    System.out.println("Player: " + bs.toString() + ", would you like to move(m) or shoot(s)?");
                    Scanner sc = new Scanner(System.in);
                    String response = sc.next();
                    if (response.toLowerCase().equals("m")) {
                        String move = d.move();
                        myBoard.applyMovementPath(bs, move);
                    } else if (response.toLowerCase().equals("s")) {
                        action shoot = d.shoot();
                        bs2 = new BattleShip(shoot.x, shoot.y, "");
                        if (myBoard.getBShipList().contains(bs2)) {
                            if (bs2.getX() == bs.getX() && bs2.getY() == bs.getY()) {
                                System.out.println("You have shot yourself at location: " + bs2.location());
                            } else {
                                System.out.println("Good Shot! You have shot a Battleship at location: " + bs2.location());
                            }
                            myBoard.setBshipStatus(myBoard.getBShipList().indexOf(bs2), false);
                        }
                    } else {
                        System.out.println("Command not recognized. Battleship: " + bs.toString() + " on Standby...");
                    }
                } else {
                    System.out.println("Battleship at location: " + bs.location() + " has been shot. Skipping...");
                }
            }
            System.out.println("Round: " + round + " Completed.");

            int numRemaining = 0;
            int winner = 0;
            for (BattleShip bs : myBoard.getBShipList()) {
                if (bs.getStatus() == true) {
                    numRemaining++;
                } else {
                    winner = myBoard.getBShipList().indexOf(bs);
                }
            }
            if (numRemaining == 1) {
                System.out.println("Battleship at location: " + myBoard.getBShipList().get(winner).location() + " wins!!!");
                break;
            }
            round++;
        }
    }

    /**
     *
     */
    public static class action {

        private int x, y;

        /**
         *
         * @param x
         * @param y
         */
        public action(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         *
         * @return
         */
        public int getX() {
            return this.x;
        }

        /**
         *
         * @return
         */
        public int getY() {
            return this.y;
        }

        /**
         *
         * @param x
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         *
         * @param y
         */
        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     *
     */
    public static class shoot extends action {

        /**
         *
         * @param x
         * @param y
         */
        public shoot(int x, int y) {
            super(x, y);
        }
    }

    /**
     *
     */
    public static class move extends action {

        private String dir;

        /**
         *
         * @param x
         * @param y
         * @param dir
         */
        public move(int x, int y, String dir) {
            super(x, y);
            this.dir = dir;
        }

        /**
         *
         * @return
         */
        public String getDir() {
            return this.dir;
        }

        /**
         *
         * @param dir
         */
        public void setDir(String dir) {
            this.dir = dir;
        }
    }

}
