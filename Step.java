package comp1110.ass2;

/**
 * Created by Jieming on 24/08/15.
 */
import java.util.*;

public class Step {
    //this part is for the test
    public static void main(String[] args) {
        Step a=new Step();
        int[] m=a.around("169");

        String[] x=new String[6];

        String[] output=a.avai("171178187194205215093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D093",m,169);

        for(int i=0;i<m.length;i++){
            System.out.println(m[i]);
            System.out.println(output[i]);
        }
    }

    public static int[] getcranny(String game) {
        String cranny1 = game.substring(15, 18);
        String cranny2 = game.substring(12, 15);
        String cranny3 = game.substring(9, 12);
        String cranny4 = game.substring(6, 9);
        String cranny5 = game.substring(3, 6);
        String cranny6 = game.substring(0, 3);

        int a1 = Integer.parseInt(cranny1);
        int a2 = Integer.parseInt(cranny2);
        int a3 = Integer.parseInt(cranny3);
        int a4 = Integer.parseInt(cranny4);
        int a5 = Integer.parseInt(cranny5);
        int a6 = Integer.parseInt(cranny6);

        int[] seperateCranny = {a1, a2, a3, a4, a5, a6};
        return seperateCranny;
    }

    public static String[] getnook(String game) {
        String nook1 = game.substring(18, 22);
        String nook2 = game.substring(22, 26);
        String nook3 = game.substring(26, 30);
        String nook4 = game.substring(30, 34);
        String nook5 = game.substring(34, 38);
        String nook6 = game.substring(38, 42);
        String nook7 = game.substring(42, 46);
        String nook8 = game.substring(46, 50);
        String nook9 = game.substring(50, 54);
        String nook10 = game.substring(54, 58);
        String nook11 = game.substring(58, 62);
        String nook12 = game.substring(62, 66);
        String nook13 = game.substring(66, 70);
        String nook14 = game.substring(70, 74);
        String nook15 = game.substring(74, 78);
        String nook16 = game.substring(78, 82);
        String nook17 = game.substring(82, 86);
        String nook18 = game.substring(86, 90);

        String[] seperateNook = {nook1, nook2, nook3, nook4, nook5, nook6, nook7, nook8, nook9, nook10, nook11, nook12, nook13, nook14, nook15,
                nook16, nook17, nook18};
        return seperateNook;
    }

    public static int judgeAreas(String game) {
        int startgame = Integer.valueOf(game);
        int area=0;
        Integer[] xiangxian1=new Integer[]{8,20,21,38,39,40,62,63,64,65,92,93,94,95,96,128,129,130,131,132,133,170,171,172,173,174,175,176};
        List area1=new ArrayList();
        area1=Arrays.asList(xiangxian1);
        Integer[] xiangxian2=new Integer[]{10,24,44,70,102,23,43,69,101,42,68,100,67,98,99,135,136,137,138,139,140,178,179,180,181,182,183,184};
        List area2=new ArrayList();
        area2=Arrays.asList(xiangxian2);
        Integer[] xiangxian3=new Integer[]{104,105,106,108,107,72,73,74,75,46,47,48,26,27,12,142,143,144,145,146,147,186,187,188,189,190,191,192};
        List area3=new ArrayList();
        area3=Arrays.asList(xiangxian3);
        Integer[] xiangxian4=new Integer[]{110,111,112,113,114,77,78,79,80,50,51,52,29,30,14,149,150,151,152,153,154,194,195,196,197,198,199,200};
        List area4=new ArrayList();
        area4=Arrays.asList(xiangxian4);
        Integer[] xiangxian5=new Integer[]{116,117,118,119,120,82,83,84,85,54,55,56,32,33,16,156,157,158,159,160,161,202,203,204,205,206,207,208};
        List area5=new ArrayList();
        area5=Arrays.asList(xiangxian5);
        Integer[] xiangxian6=new Integer[]{122,123,124,125,87,88,89,58,59,35,163,164,165,166,167,210,211,212,213,214,215};
        List area6=new ArrayList();
        area6=Arrays.asList(xiangxian6);

        Integer[] xiangxian7=new Integer[]{1,7,19,37,61,91,127,169};
        List area7=new ArrayList();
        area7=Arrays.asList(xiangxian7);
        Integer[] xiangxian8=new Integer[]{2,9,22,41,66,97,134,177};
        List area8=new ArrayList();
        area8=Arrays.asList(xiangxian8);
        Integer[] xiangxian9=new Integer[]{3,11,25,45,71,103,141,185};
        List area9=new ArrayList();
        area9=Arrays.asList(xiangxian9);
        Integer[] xiangxian10=new Integer[]{4,13,28,49,76,109,148,193};
        List area10=new ArrayList();
        area10=Arrays.asList(xiangxian10);
        Integer[] xiangxian11=new Integer[]{5,15,31,53,81,115,155,201};
        List area11=new ArrayList();
        area11=Arrays.asList(xiangxian11);
        Integer[] xiangxian12=new Integer[]{6,17,34,57,86,121,162,209};
        List area12=new ArrayList();
        area12=Arrays.asList(xiangxian12);

        Integer[] xiangxian13=new Integer[]{18,36,60,90,126,168,216};
        List area13=new ArrayList();
        area13=Arrays.asList(xiangxian13);

        if(area1.contains(startgame)) area=1;
        if(area2.contains(startgame)) area=2;
        if(area3.contains(startgame)) area=3;
        if(area4.contains(startgame)) area=4;
        if(area5.contains(startgame)) area=5;
        if(area6.contains(startgame)) area=6;
        if(area7.contains(startgame)) area=7;
        if(area8.contains(startgame)) area=8;
        if(area9.contains(startgame)) area=9;
        if(area10.contains(startgame)) area=10;
        if(area11.contains(startgame)) area=11;
        if(area12.contains(startgame)) area=12;
        if(area13.contains(startgame)) area=13;
        return area;
    }

    public static int judgeRings(String game) {
        int startgame = Integer.valueOf(game);
        Collection quan1 = new ArrayList();
        for (int i = 1; i < 7; i++) {
            quan1.add(i);
        }
        Collection quan2 = new ArrayList();
        for (int i = 7; i < 19; i++) {
            quan2.add(i);
        }
        Collection<Integer> quan3 = new ArrayList();
        for (int i = 19; i < 37; i++) {
            quan3.add(i);
        }
        Collection<Integer> quan4 = new ArrayList<Integer>();
        for (int i = 37; i < 61; i++) {
            quan4.add(i);
        }
        Collection<Integer> quan5 = new ArrayList<Integer>();
        for (int i = 61; i < 91; i++) {
            quan5.add(i);
        }
        Collection<Integer> quan6 = new ArrayList<Integer>();
        for (int i = 91; i < 127; i++) {
            quan6.add(i);
        }
        Collection<Integer> quan7 = new ArrayList<Integer>();
        for (int i = 127; i < 169; i++) {
            quan7.add(i);
        }
        Collection<Integer> quan8 = new ArrayList<Integer>();
        for (int i = 169; i < 217; i++) {
            quan8.add(i);
        }

        int quanshu = 0;
        if (quan1.contains(startgame)) {
            quanshu=1;
        }
        if (quan2.contains(startgame)) {
            quanshu= 2;
        }
        if (quan3.contains(startgame)) {
            quanshu= 3;
        }
        if (quan4.contains(startgame)) {
            quanshu= 4;
        }
        if (quan5.contains(startgame)) {
            quanshu= 5;
        }
        if (quan6.contains(startgame)) {
            quanshu= 6;
        }
        if (quan7.contains(startgame)) {
            quanshu= 7;
        }
        if (quan8.contains(startgame)) {
            quanshu= 8;
        }
        return quanshu;
    }

    public static int[] around(String positio){
        Step a=new Step();
        int n=a.judgeAreas(positio);//xianxian
        int m=a.judgeRings(positio);//quanshu
        int[] result={4,5,6,1,2,3};
        int position= Integer.parseInt(positio);

        switch (n){
            case 1:
                result[2]=position-1;
                result[5]=position+1;
                result[0]=position-m*0-(m-1)*6;
                result[1]=position-m*1-(m-1)*5;
                result[3]=position+m*6+(m+1)*0;
                result[4]=position+m*5+(m+1)*1;
                break;
            case 2:
                result[3]=position-1;
                result[0]=position+1;
                result[1]=position-m*1-(m-1)*5;
                result[2]=position-m*2-(m-1)*4;
                result[4]=position+m*5+(m+1)*1;
                result[5]=position+m*4+(m+1)*2;
                break;
            case 3:
                result[4]=position-1;
                result[1]=position+1;
                result[2]=position-m*2-(m-1)*4;
                result[3]=position-m*3-(m-1)*3;
                result[5]=position+m*4+(m+1)*2;
                result[0]=position+m*3+(m+1)*3;
                break;
            case 4:
                result[5]=position-1;
                result[2]=position+1;
                result[3]=position-m*3-(m-1)*3;
                result[4]=position-m*4-(m-1)*2;
                result[0]=position+m*3+(m+1)*3;
                result[1]=position+m*2+(m+1)*4;
                break;
            case 5:
                result[0]=position-1;
                result[3]=position+1;
                result[4]=position-m*4-(m-1)*2;
                result[5]=position-m*5-(m-1)*1;
                result[1]=position+m*2+(m+1)*4;
                result[2]=position+m*1+(m+1)*5;
                break;
            case 6:
                result[1]=position-1;
                result[4]=position+1;
                result[5]=position-m*5-(m-1)*1;
                result[0]=position-m*6-(m-1)*0;
                result[2]=position+m*1+(m+1)*5;
                result[3]=position+m*0+(m+1)*6;
                break;
            case 7:
                result[0]=position-(m-1)*6;
                result[1]=position+m*6-1;
                result[2]=position+m*6+(m+1)*6-1;
                result[3]=position+m*6;
                result[4]=position+m*6+1;
                result[5]=position+1;
                if(position==1){
                    result[0]=0;
                }
                break;
            case 8:
                result[2]=position-1;
                result[0]=position+1;
                result[4]=position+m*5+(m+1)*1;
                result[3]=position+m*5+(m+1)*1-1;
                result[5]=position+m*5+(m+1)*1+1;
                result[1]=position-m*1-(m-1)*5;
                if(position==2){
                    result[1]=0;
                }
                break;
            case 9:
                result[3]=position-1;
                result[1]=position+1;
                result[5]=position+m*4+(m+1)*2;
                result[4]=position+m*4+(m+1)*2-1;
                result[0]=position+m*4+(m+1)*2+1;
                result[2]=position-m*2-(m-1)*4;
                if(position==3){
                    result[2]=0;
                }
                break;
            case 10:
                result[4]=position-1;
                result[2]=position+1;
                result[0]=position+m*3+(m+1)*3;
                result[5]=position+m*3+(m+1)*3-1;
                result[1]=position+m*3+(m+1)*3+1;
                result[3]=position-m*3-(m-1)*3;
                if(position==4){
                    result[3]=0;
                }
                break;
            case 11:
                result[5]=position-1;
                result[3]=position+1;
                result[1]=position+m*2+(m+1)*4;
                result[0]=position+m*2+(m+1)*4-1;
                result[2]=position+m*2+(m+1)*4+1;
                result[4]=position-m*4-(m-1)*2;
                if(position==5){
                    result[4]=0;
                }
                break;
            case 12:
                result[0]=position-1;
                result[4]=position+1;
                result[2]=position+m*1+(m+1)*5;
                result[1]=position+m*1+(m+1)*5-1;
                result[3]=position+m*1+(m+1)*5+1;
                result[5]=position-m*5-(m-1)*1;
                if(position==6){
                    result[5]=0;
                }
                break;

            case 13:
                result[1]=position-1;
                result[5]=position-m*6-(m-1)*6+1;
                result[4]=position-m*5-(m-1)*1;
                result[0]=position-m*6-(m-1)*0;
                result[2]=position+m*1+(m+1)*5;
                result[3]=position+m*0+(m+1)*6;
                break;
        }


        return result;
    }

    public static String[] avai(String game,int[] a,int start){
        Step b=new Step();
        int[] cranny=b.getcranny(game);

        String[] nook=b.getnook(game);
        String[] nookdir=new String[18];
        int[] nooknum=new int[18];

        String[] around=new String[6];
        for (int k=0;k<a.length;k++){
            if(a[k]<10){
                around[k]="00"+Integer.toString(a[k])+1;
            }else if(a[k]<100){
                around[k]="0"+Integer.toString(a[k])+1;
            }else around[k]=Integer.toString(a[k])+1;
        }


        for(int i=0;i<nook.length;i++){
            nookdir[i]=nook[i].substring(3);
            nooknum[i]=Integer.parseInt(nook[i].substring(0, 3));
        }

        for(int j=0;j<nooknum.length;j++){

            if(start==nooknum[j]){

                if(nookdir[j].equals("A")){
                    around[2]=around[2].substring(0,3)+"0";
                    around[3]=around[3].substring(0,3)+"0";
                    around[4]=around[4].substring(0,3)+"0";
                }else if(nookdir[j].equals("B")){
                    around[3]=around[3].substring(0,3)+"0";
                    around[4]=around[4].substring(0,3)+"0";
                    around[5]=around[5].substring(0,3)+"0";
                }else if(nookdir[j].equals("C")){
                    around[4]=around[4].substring(0,3)+"0";
                    around[5]=around[5].substring(0,3)+"0";
                    around[0]=around[0].substring(0,3)+"0";
                }else if(nookdir[j].equals("D")){
                    around[5]=around[5].substring(0,3)+"0";
                    around[0]=around[0].substring(0,3)+"0";
                    around[1]=around[1].substring(0,3)+"0";
                }else if(nookdir[j].equals("E")){
                    around[0]=around[0].substring(0,3)+"0";
                    around[1]=around[1].substring(0,3)+"0";
                    around[2]=around[2].substring(0,3)+"0";
                }else if(nookdir[j].equals("F")){
                    around[3]=around[3].substring(0,3)+"0";
                    around[1]=around[1].substring(0,3)+"0";
                    around[2]=around[2].substring(0,3)+"0";
                }
            }
        }

        for(int l=0;l<around.length;l++){
            for(int m=0;m<nooknum.length;m++){
                if(a[l]==nooknum[m]){
                    if(l==0){
                        if(nookdir[m].equals("F")||nookdir[m].equals("A")||nookdir[m].equals("B")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }else if(l==1){
                        if(nookdir[m].equals("A")||nookdir[m].equals("B")||nookdir[m].equals("C")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }else if(l==2){
                        if(nookdir[m].equals("B")||nookdir[m].equals("C")||nookdir[m].equals("D")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }else if(l==3){
                        if(nookdir[m].equals("C")||nookdir[m].equals("D")||nookdir[m].equals("E")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }else if(l==4){
                        if(nookdir[m].equals("D")||nookdir[m].equals("E")||nookdir[m].equals("F")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }else if(l==5){
                        if(nookdir[m].equals("E")||nookdir[m].equals("F")||nookdir[m].equals("A")){
                            around[l]=around[l].substring(0,3)+"0";
                        }
                    }
                }
            }
        }

        for(int n=0;n<cranny.length;n++){
            for(int o=0;o<a.length;o++){
                if((start==cranny[n]&&a[o]==cranny[n]+1)||(start==cranny[n]+1&&a[o]==cranny[n])){
                    around[o]=around[o].substring(0,3)+"0";
                }
            }
        }

        for(int p=0;p<a.length;p++){
            if(a[p]>216){
                around[p]=around[p].substring(0,3)+"0";
            }
        }
        return around;
    }

}

