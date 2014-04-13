/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimchi
 */
public class BattleShip {

    private int x, y;
    private String direction = "";
    private boolean status = true;

    /**
     *
     * @param x
     * @param y
     * @param direction
     */
    public BattleShip(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction.toLowerCase();
    }

    /**
     *
     * @return
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
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

    /**
     *
     * @return
     */
    public String location() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     *
     * @return
     */
    public String getDirection() {
        return this.direction.toLowerCase();
    }

    /**
     *
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction.toLowerCase();
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ") " + this.getDirection();
    }

    @Override
    public boolean equals(Object bs) {
        boolean eq = false;
        if (bs instanceof BattleShip) {
            BattleShip bs1 = (BattleShip) bs;
            eq = bs1.hashCode() == this.hashCode();
        }
        return eq;
    }

    @Override
    public int hashCode() {
        String hc = "(" + this.x + ", " + this.y + ") ";
        return hc.hashCode();
    }

}
