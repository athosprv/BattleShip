
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kimchi
 */
public class Driver {

    private Board tmp;

    /**
     *
     * @return
     */
    public int enterNumPlayers() {
        Integer num = -1;
        
        while (true) {
            try{
            Scanner sc = new Scanner(System.in).useDelimiter("[ ,\r\n]");
            System.out.println("Please enter number of players: (2 - " + (tmp.getx() - 1) + ")");
            num = sc.nextInt();
            sc.nextLine();
            if ((num >= 2) && num < (tmp.getx())) 
            {
                break;
            }
            }catch(Exception e){}
        }        
        return num;
    }
    /**
     *
     * @return
     */
    public main.move enterLocationAndDirection() {
        
        Integer x = -1;
        Integer y = -1;
        String dir = "";
        
        while(true) {
            try{
            Scanner sc = new Scanner(System.in).useDelimiter("[ ,\r\n]");
            System.out.println("Please enter player coordinates and direction (N/S/E/W)separated by a comma. EX: '2,4,N'");
            x = sc.nextInt();
            y = sc.nextInt();
            dir = sc.next().toLowerCase();
            sc.nextLine();
            if (dir.matches("[nsew]")) {
                break;    
            }
            }catch(Exception e){}
        }        
        return new main.move(x, y, dir);
    }

    /**
     *
     * @return
     */
    public main.shoot shoot() {        
        Integer x = -1;
        Integer y = -1;
        
        while(true) {
            try{
            Scanner sc = new Scanner(System.in).useDelimiter("[ ,\r\n]");
            System.out.println("Please enter shooting coordinates. EX: '1,3'");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            break;
            }catch(Exception e){}
        }         
        return new main.shoot(x, y);
        
    }

    /**
     *
     * @return
     */
    public String move() {
        

        String move = "";
        while(true)
        {
        try {
            Scanner sc = new Scanner(System.in).useDelimiter("[ ,\r\n]");
            System.out.println("Please enter player movement pattern specified by M(move), L(left) or R(right). EX: 'LMLMLMLMM'");
            move = sc.next().toLowerCase();
            sc.nextLine();
            if (move.matches("[mlr]*")) {
                break;
            }
        } catch (Exception E) {
        }}
        return move;
    }

    /**
     *
     * @return
     */
    public Board createBoard() {
        
        Integer x = -1;
        Integer y = -1;
        while(true){
        try {
            Scanner sc = new Scanner(System.in).useDelimiter("[ ,\r\n]");
            System.out.println("Please enter board dimensions separated by a comma. EX:'2,4' and 2x2 or larger.");
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            if (x > 2 && y > 2) {                
                break;
            }
        } catch (Exception E) {}}
        tmp = new Board(x, y);
        return tmp;
    }

}
