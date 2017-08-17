package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jieming on 26/09/15.
 */
public class Move {
    public static void main(String[] args) {
        ArrayList output=move("176183190197208211089E036E123B062E040A008E010F069E099E074D027F104E052F113B050B118F082C033E",2);

        System.out.println(output);

    }

    public static ArrayList move(String game, int start){

        Step x=new Step();
        ArrayList<String> nextWay=new ArrayList<>();
        ArrayList<String> nextStep=new ArrayList<>();
        ArrayList<Integer> nextDir=new ArrayList<>();
        ArrayList<String> nextTurn=new ArrayList<>();
        String[] next;
        int k=0;

        if(Integer.toString(start).length()==2){
            nextTurn.add("0"+Integer.toString(start)+"1");
        }else if(Integer.toString(start).length()==1){
            nextTurn.add("00"+Integer.toString(start)+"1");
        }else nextTurn.add(Integer.toString(start)+"1");//the first time


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

                if(nextTurn.contains(last)){
                }else {
                    nextTurn.add(last);
                }
            }

        nextTurn.remove(0);

        ArrayList<String> result=new ArrayList<>();
        for (int i=0;i<nextTurn.size();i++){
            result.add(nextTurn.get(i).substring(0,3));
        }
        return result;
    }
}
