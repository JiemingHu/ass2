package comp1110.ass2;

import javafx.scene.control.Cell;

import java.util.Collection;
import java.util.*;
import java.lang.*;
import java.util.Arrays;

/**
 * Created by Jieming on 30/07/2015.
 */
public class HexGame {

    ArrayList Nook = new ArrayList();
    String nooks = "";
    public String end;
    public String start;
    //public String nooks;

    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    String game;

    /**
     * Construct HexGame from a string describing game state.
     *
     * @param game The initial state of the game, described as a string according to the assignment specification.
     */
    public HexGame(String game) {
        /* FIXME */

        this.game = game;
    }

    /**
     * Construct HexGame with a random game state that complies with the assignment specification.
     */
    public HexGame() {
        /* FIXME */
        Random c=new Random();
        Random s=new Random();

        String crannies;

        String Game;

        String start;

        String end;

        do {
            //create cranny;
            crannies="";

            for(int i=0;i<6;i++){
                crannies=crannies+Integer.toString(c.nextInt(7)+170+8*i);
            }

            nooks = NookMaker.nook_make();    // Make the nook string with my own method

            int x=s.nextInt(18);

            int y=s.nextInt(18);

            start=nooks.substring(x*4,x*4+4).substring(0,3);

            do{
                end=nooks.substring(y*4,y*4+4).substring(0,3);

            }while (end.equals(start));

            Game=crannies+nooks+start;


        }while (legitimateGame(Game)==false);


        this.start=start;
        this.end=end;
        game=Game;
    }

    /**
     * Determine whether a set of crannies are legal according to the assignment specification.
     *
     * @param crannies A string describing the crannies, encoded according to the assignment specification.
     * @return True if the crannies are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateCrannies(String crannies) {
        /* FIXME */
        boolean o = true;
        if (crannies.length() < 18) {
            o = false;
            return o;
        }
        String cranny1 = crannies.substring(15);
        String cranny2 = crannies.substring(12, 15);
        String cranny3 = crannies.substring(9, 12);
        String cranny4 = crannies.substring(6, 9);
        String cranny5 = crannies.substring(3, 6);
        String cranny6 = crannies.substring(0, 3);

        int a1 = Integer.parseInt(cranny1);
        int a2 = Integer.parseInt(cranny2);
        int a3 = Integer.parseInt(cranny3);
        int a4 = Integer.parseInt(cranny4);
        int a5 = Integer.parseInt(cranny5);
        int a6 = Integer.parseInt(cranny6);

        int[] a7 = {a1, a2, a3, a4, a5, a6};

        for (int j = 0; j < a7.length; j++) {
            if (a7[j] > 217 || a7[j] < 168) {
                o = false;
                return o;
            }
        }
        for (int i = 0; i < a7.length; i++) {
            for (int k = 0; k < a7.length; k++) {
                if (i != k) {
                    if (a7[i] == a7[k]) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 169, 176) && rangeInDefined(a7[k], 169, 176)) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 177, 184) && rangeInDefined(a7[k], 177, 184)) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 185, 192) && rangeInDefined(a7[k], 185, 192)) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 193, 200) && rangeInDefined(a7[k], 193, 200)) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 201, 208) && rangeInDefined(a7[k], 201, 208)) {
                        o = false;
                        return o;
                    }
                    if (rangeInDefined(a7[i], 210, 216) && rangeInDefined(a7[k], 210, 216)) {
                        o = false;
                        return o;
                    }
                }
            }
        }
        return true;


    }

    /**
     * Determine whether a set of nooks are legal according to the assignment specification.
     *
     * @param nooks A string describing the nooks, encoded according to the assignment specification.
     * @return True if the nooks are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateNooks(String nooks) {
        /* FIXME */
        int[][] pos_dic = {{2, 3}, {1, 3, 4, 5}, {1, 2, 5, 6}, {2, 5, 7, 8}, {2, 3, 4, 6, 8, 9}, {3, 5, 9, 10}, {4, 8, 11, 12}, {4, 5, 7, 9, 12, 13}, {5, 6, 8, 10, 13, 14}, {6, 9, 14, 15}, {7, 12}, {7, 8, 11, 13}, {8, 9, 12, 14}, {9, 10, 13, 15}, {10, 14}};
        int[] idx_dic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        char[] ori_dic = {'A', 'B', 'C', 'D', 'E', 'F'};
        String num_dic[][] = {
                {"008", "021", "020", "040", "039", "038", "065", "064", "063", "062", "096", "095", "094", "093", "092"},
                {"098", "067", "099", "042", "068", "100", "023", "043", "069", "101", "010", "024", "044", "070", "102"},
                {"108", "107", "075", "106", "074", "048", "105", "073", "047", "027", "104", "072", "046", "026", "012"},
                {"014", "030", "029", "052", "051", "050", "080", "079", "078", "077", "114", "113", "112", "111", "110"},
                {"116", "082", "117", "054", "083", "118", "032", "055", "084", "119", "016", "033", "056", "085", "120"},
                {"126", "125", "090", "124", "089", "060", "123", "088", "059", "036", "122", "087", "058", "035", "018"}
        };
        boolean flag = true;
        // This is to check whether the length is legal
        if (nooks.length() != 72) {
            flag = false;
        }

        // This is to check the orientation character is legal
        if (flag) {
            char[] ori_t = new char[18];
            int sum1 = 0;
            for (int i = 0; i < 18; i++) {
                ori_t[i] = nooks.charAt(4 * i + 3);
                for (int j = 0; j < 6; j++) {
                    if (ori_t[i] == ori_dic[j]) {
                        sum1 += 1;
                    }
                }
            }
            if (sum1 != 18) {
                flag = false;
            }
        }

        // This is to check whether the numbers are in six triangle zones
        String[] num_t = new String[18];
        if(flag) {
            int sum2 = 0;
            for (int i = 0; i < 18; i++) {
                num_t[i] = "" + nooks.charAt(4 * i) + nooks.charAt(4 * i + 1) + nooks.charAt(4 * i + 2);
                for (int m = 0; m < 15; m++) {
                    for (int n = 0; n < 6; n++) {
                        if (num_t[i].equals(num_dic[n][m])) {
                            sum2 += 1;
                        }
                    }
                }
            }
            if (sum2 != 18) {
                flag = false;
            }
        }

        // This is to check whether there are adjacent nooks
        if (flag) {
            for (int i = 0; i < 18; i++) {
                for (int m = 0; m < 15; m++) {
                    for (int n = 0; n < 6; n++) {
                        if (num_t[i].equals(num_dic[n][m])) {
                            for (int ii = 0; ii < 18; ii++) {
                                for (int k = 0; k < pos_dic[m].length; k++) {
                                    if (num_t[ii].equals(num_dic[n][pos_dic[m][k] - 1]) && ii != i) {
                                        flag = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // This is to check whether there are just 3 nooks in one triangle zone
        int[][] fsum = new int[6][1];
        if (flag) {
            for (int i = 0; i < 18; i++) {
                for (int m = 0; m < 15; m++) {
                    for (int n = 0; n < 6; n++) {
                        if (num_t[i].equals(num_dic[n][m])) {
                            fsum[n][0] += 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (fsum[i][0]!=3){
                flag = false;
            }
        }
        return flag; // the final result
        //return false;
    }

    /**
     * Determine whether a game state is legal according to the assignment specification.
     *
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @return True if the game state is correctly encoded and represents a legal game state, according to the assignment specification.
     */
    public static boolean legitimateGame(String game) {
        /* FIXME */
       // HashMap<Integer,Integer> HexMap1=new HashMap<Integer, Integer>();
        //HexMap1.put(0,169);HexMap1.put(1,170);HexMap1.put(2,171);HexMap1.put(3,172);HexMap1.put(4,173);HexMap1.put(5,174);HexMap1.put(6,175);HexMap1.put(7,176);HexMap1.put(8,177);

        String nook1 = game.substring(18, 21);
        String nook2 = game.substring(22, 25);
        String nook3 = game.substring(26, 29);
        String nook4 = game.substring(30, 33);
        String nook5 = game.substring(34, 37);
        String nook6 = game.substring(38, 41);
        String nook7 = game.substring(42, 45);
        String nook8 = game.substring(46, 49);
        String nook9 = game.substring(50, 53);
        String nook10 = game.substring(54, 57);
        String nook11 = game.substring(58, 61);
        String nook12 = game.substring(62, 65);
        String nook13 = game.substring(66, 69);
        String nook14 = game.substring(70, 73);
        String nook15 = game.substring(74, 77);
        String nook16 = game.substring(78, 81);
        String nook17 = game.substring(82, 85);
        String nook18 = game.substring(86, 89);

        String[] seperateNook = {nook1, nook2, nook3, nook4, nook5, nook6, nook7, nook8, nook9, nook10, nook11, nook12, nook13, nook14, nook15,
                nook16, nook17, nook18};
        String AllNook = game.substring(18, 90);
        String start = game.substring(90);
        ArrayList<String> player=new ArrayList<>();
        if (start.length() < 4) {                        // In this situation, the maximum number of players is 4.
            String player1 = start.substring(0, 3);
            player.add(player1);
            if (AllNook.contains(start)) {
            } else {
                return false;
            }
        } else {
            String player1 = start.substring(0, 3);
            String player2 = start.substring(3, 6);
            String player3 = start.substring(6, 9);
            String player4 = start.substring(9);
            String[] plays={player1,player2,player3,player4};
            player.add(player1);
            player.add(player2);
            player.add(player3);
            player.add(player4);
            for(String s:plays){
                player.remove(s);
                if(player.contains(s)){
                    return false;
                }
            }
        }

        for(int j=0;j<player.size();j++){
            for(int i=0;i<seperateNook.length;i++){
                if (player.get(j).equals(seperateNook[i])){
                }else {
                    if(minimalPath(game,Integer.valueOf(player.get(j)),Integer.valueOf(seperateNook[i]))==null){  // No minimal path, means no other paths
                        return false;
                    };
                }
            }
        }

        return true;
    }

    /**
     * Determine whether a given step is legal according to a given game state and the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param from The point from which the step starts
     * @param to The point to which step goes
     * @return True if the move is legal according to the assignment specification.
     */
    public static boolean legitimateStep(String game, int from, int to) {
        /* FIXME */
        int[] m=minimalPath(game,from,to);

        if(from!=Integer.valueOf(game.substring(90))){
            return false;
        }
        if(m==null){
            return false;
        }
        if(m.length>2){
            return false;
        }
        return true;
    }

    /**
     * Return a minimal path from start to goal.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param start The point from which the path must start
     * @param goal The point at which the path must end
     * @return An array of integers reflecting a minimal path from start to goal, each integer reflecting a node on the board, starting with the start, and ending with the goal.
     */
    public static int[] minimalPath(String game, int start, int goal) {
        /* FIXME */
        Step x=new Step();
        HashMap<String,String> Path=new HashMap();
        ArrayList<String> nextWay=new ArrayList<>();
        ArrayList<String> nextStep=new ArrayList<>();
        ArrayList<Integer> nextDir=new ArrayList<>();
        ArrayList<String> nextTurn=new ArrayList<>();
        String[] next;
        ArrayList<Integer> minimalpath=new ArrayList<>();
        int k=0;

        if(Integer.toString(start).length()<3){
            nextTurn.add("0"+Integer.toString(start)+"1");
        }else nextTurn.add(Integer.toString(start)+"1");//the first time

        do {
            next=x.avai(game, x.around(nextTurn.get(k).substring(0,3)), Integer.valueOf(nextTurn.get(k).substring(0,3)));

            for (String s:next){
                nextWay.add(s);
            }

            nextStep.clear();
            nextDir.clear();

            for(int i=0;i<nextWay.size();i++){
                if(nextWay.get(i).charAt(3)=='1'){
                    nextStep.add(nextWay.get(i));
                    nextDir.add(i);
                }
            }

            nextWay.clear();

            for(int i=0;i<nextStep.size();i++){

                String s=x.avai(game,x.around(nextStep.get(i).substring(0,3)),Integer.valueOf(nextStep.get(i).substring(0,3)))[nextDir.get(i)];
                String last;
                if(s.charAt(3)=='1'){
                    do{
                        last=s;
                        s=x.avai(game,x.around(s.substring(0,3)),Integer.valueOf(s.substring(0,3)))[nextDir.get(i)];
                    }while(s.charAt(3)=='1');
                }else last=nextStep.get(i);

                if(Integer.valueOf(last.substring(0, 3))==goal){
                    Path.put(last.substring(0, 3), nextTurn.get(k).substring(0, 3));
                    String mxj=last.substring(0,3);
                    minimalpath.clear();

                    while (Path.containsKey(mxj)){
                        minimalpath.add(Integer.valueOf(mxj));
                        mxj=Path.get(mxj);
                    }
                    minimalpath.add(start);

                    int[] output=new int[minimalpath.size()];
                    for(int a=0;a<minimalpath.size();a++){
                        output[a]=minimalpath.get(minimalpath.size()-1-a);
                    }

                    return output;
                }else {
                    if(nextTurn.contains(last)){
                    }else {
                        nextTurn.add(last);
                        Path.put(last.substring(0,3),nextTurn.get(k).substring(0,3));
                    }
                }
            }
            k++;
        }while (k<nextTurn.size());
        return null;
    }

    /**
     * Output the state of the game as a string, encoded according to the assignment specification
     * @return A string that reflects the game state, encoded according to the assignment specification.
     */
    public String toString() {
        /* FIXME */
        return game;
    }

}
