package comp1110.ass2;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jieming on 2015/9/16.
 */
public class myTest {
    public String crannies="";
    public String nooks="";
    public myTest() {
        Random c = new Random();
        Random n = new Random();
        String num_dic[][] = {
                {"008", "021", "020", "040", "039", "038", "065", "064", "063", "062", "096", "095", "094", "093", "092"},
                {"098", "067", "099", "042", "068", "100", "023", "043", "069", "101", "010", "024", "044", "070", "102"},
                {"108", "107", "075", "106", "074", "048", "105", "073", "047", "027", "104", "072", "046", "026", "012"},
                {"014", "030", "029", "052", "051", "050", "080", "079", "078", "077", "114", "113", "112", "111", "110"},
                {"116", "082", "117", "054", "083", "118", "032", "055", "084", "119", "016", "033", "056", "085", "120"},
                {"126", "125", "090", "124", "089", "060", "123", "088", "059", "036", "122", "087", "058", "035", "018"}
        };
        String dir[] = {"A", "B", "C", "D", "E", "F"};

            //create cranny;

            for (int i = 0; i < 6; i++) {
                crannies = crannies + Integer.toString(c.nextInt(7) + 170 + 8 * i);
            }
            //create nook

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    nooks = nooks + num_dic[i][n.nextInt(15)] + dir[n.nextInt(6)];
                    n.nextInt(15);
                }
            }

    }


    @Test
    public void testNooks(){
        assertTrue("incorrect Nooks: " + nooks, HexGame.legitimateNooks(nooks));
        assertTrue("incorrect Nooks: " + nooks, HexGame.legitimateNooks("093D094D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D"));
    }

    @Test
    public void testCrannies(){
        assertTrue("incorrect crannies: " + crannies, HexGame.legitimateCrannies(crannies));
        assertTrue("incorrect crannies: " + crannies, HexGame.legitimateCrannies("171178187194205215"));
    }

}

