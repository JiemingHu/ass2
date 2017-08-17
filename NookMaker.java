package comp1110.ass2;

import java.util.Random;

/**
 * Created by Jieming on 2015/9/15.
 */
public class NookMaker {
    public static int[] random_num(){
        // The idea is to generate three nooks one by one according to the dictionaries we made in advance.
        int[][] pos_dic = {{2, 3}, {1, 3, 4, 5}, {1, 2, 5, 6}, {2, 5, 7, 8}, {2, 3, 4, 6, 8, 9}, {3, 5, 9, 10}, {4, 8, 11, 12}, {4, 5, 7, 9, 12, 13}, {5, 6, 8, 10, 13, 14}, {6, 9, 14, 15}, {7, 12}, {7, 8, 11, 13}, {8, 9, 12, 14}, {9, 10, 13, 15}, {10, 14}};
        int[] idx_dic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        // In each turn, generate a random number. The second and third ones have some restrictions.
        Random r = new Random();

        // The first random number, once it is generated, the numbers around it will be changed into 0, which means these positions with number 0 will not
        // generate nooks any more in the second and third turns.
        int r1 = r.nextInt(15) + 1;
        for (int i = 0; i < pos_dic[r1 - 1].length; i++) {
            for (int j = 0; j < 15; j++) {
                if (pos_dic[r1 - 1][i] == idx_dic[j]) {
                    idx_dic[j] = 0;
                    idx_dic[r1-1] = 0;
                }
            }
        }

        // The second turn
        int r2 = r.nextInt(15) + 1;
        while(idx_dic[r2-1]==0){
            r2 = r.nextInt(15)+1;
        }
        for (int i = 0; i < pos_dic[r2 - 1].length; i++) {
            for (int j = 0; j < 15; j++) {
                if (pos_dic[r2 - 1][i] == idx_dic[j]) {
                    idx_dic[j] = 0;
                    idx_dic[r2-1] = 0;
                }
            }
        }

        // The third turn
        int r3 = r.nextInt(15) + 1;
        while(idx_dic[r3-1]==0){
            r3 = r.nextInt(15)+1;
        }
        for (int i = 0; i < pos_dic[r3 - 1].length; i++) {
            for (int j = 0; j < 15; j++) {
                if (pos_dic[r3 - 1][i] == idx_dic[j]) {
                    idx_dic[j] = 0;
                    idx_dic[r3-1] = 0;
                }
            }
        }

        // There are six triangles to generate nooks, each one will generate three.
        int r4 = r.nextInt(6);
        int r5 = r.nextInt(6);
        int r6 = r.nextInt(6);
        int[] ran_idx = {r1,r2,r3,r4,r5,r6};
        return ran_idx;
    }
    public static String nook_make(){
        String[] num_dic1 = {"126","125","090","124","089","060","123","088","059","036","122","087","058","035","018"};
        String[] num_dic2 = {"008","021","020","040","039","038","065","064","063","062","096","095","094","093","092"};
        String[] num_dic3 = {"098","067","099","042","068","100","023","043","069","101","010","024","044","070","102"};
        String[] num_dic4 = {"108","107","075","106","074","048","105","073","047","027","104","072","046","026","012"};
        String[] num_dic5 = {"014","030","029","052","051","050","080","079","078","077","114","113","112","111","110"};
        String[] num_dic6 = {"116","082","117","054","083","118","032","055","084","119","016","033","056","085","120"};
        char[] ori_dic = {'A','B','C','D','E','F'};
        int[] random_idx1 = random_num();
        int[] random_idx2 = random_num();
        int[] random_idx3 = random_num();
        int[] random_idx4 = random_num();
        int[] random_idx5 = random_num();
        int[] random_idx6 = random_num();
        String nook_1 = num_dic1[random_idx1[0]-1]+ori_dic[random_idx1[3]]+num_dic1[random_idx1[1]-1]+ori_dic[random_idx1[4]]+num_dic1[random_idx1[2]-1]+ori_dic[random_idx1[5]];
        String nook_2 = num_dic2[random_idx2[0]-1]+ori_dic[random_idx2[3]]+num_dic2[random_idx2[1]-1]+ori_dic[random_idx2[4]]+num_dic2[random_idx2[2]-1]+ori_dic[random_idx2[5]];
        String nook_3 = num_dic3[random_idx3[0]-1]+ori_dic[random_idx3[3]]+num_dic3[random_idx3[1]-1]+ori_dic[random_idx3[4]]+num_dic3[random_idx3[2]-1]+ori_dic[random_idx3[5]];
        String nook_4 = num_dic4[random_idx4[0]-1]+ori_dic[random_idx4[3]]+num_dic4[random_idx4[1]-1]+ori_dic[random_idx4[4]]+num_dic4[random_idx4[2]-1]+ori_dic[random_idx4[5]];
        String nook_5 = num_dic5[random_idx5[0]-1]+ori_dic[random_idx5[3]]+num_dic5[random_idx5[1]-1]+ori_dic[random_idx5[4]]+num_dic5[random_idx5[2]-1]+ori_dic[random_idx5[5]];
        String nook_6 = num_dic6[random_idx6[0]-1]+ori_dic[random_idx6[3]]+num_dic6[random_idx6[1]-1]+ori_dic[random_idx6[4]]+num_dic6[random_idx6[2]-1]+ori_dic[random_idx6[5]];
        String nooks = nook_1+nook_2+nook_3+nook_4+nook_5+nook_6;
        return nooks;
    }

    public static void main(String[] args) {
        String nooks1 = nook_make();
        System.out.println(nooks1);
    }
}
