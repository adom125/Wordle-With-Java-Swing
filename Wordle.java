import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Wordle {
    private String strAns;
    private Boolean winnerStat;
    private Boolean curStatus;
    private ArrayList<String> randomWords;

    public Wordle() throws FileNotFoundException 
    {
        randomWords = new ArrayList<String>();
        
         randomWords.add("PLACE");
         randomWords.add("CRUSH");
         randomWords.add("RELAX");
         randomWords.add("PAUSE");
          randomWords.add("CANOE");
          randomWords.add("MEDIA");
          randomWords.add("HAUNT");
          randomWords.add("FRAUD");
          randomWords.add("SHADE");
          randomWords.add("PLANE");
          randomWords.add("ACTOR");
          randomWords.add("TRAIN");
          randomWords.add("ZEBRA");
          randomWords.add("TACOS");
          randomWords.add("PASTE");
          randomWords.add("NOISE");
          randomWords.add("SNACK");
          randomWords.add("DREAM");
          randomWords.add("STEAM");
          randomWords.add("BRAVE");
          randomWords.add("BRICK");
          randomWords.add("CLAMS");
          randomWords.add("HOTEL");
          randomWords.add("CABIN");
          randomWords.add("IDEAL");
          randomWords.add("PEACH");
          randomWords.add("LASER");
          randomWords.add("INDEX");
          randomWords.add("BREAK");
          randomWords.add("WHALE");
          randomWords.add("VOCAL");
          randomWords.add("CHASE");
          randomWords.add("FOCAL");
          randomWords.add("VAGUE");
          
          randomWords.add("SEDAN");
          randomWords.add("ALTER");
          randomWords.add("ADULT");
          randomWords.add("LUNCH");
          randomWords.add("RUGBY");
          randomWords.add("CLOWN");
          randomWords.add("EARTH");
          
          randomWords.add("SALTY");
         randomWords.add("WALTZ");
         randomWords.add("MANGO");
         randomWords.add("MOCHA");
         randomWords.add("MODEL");
       
         randomWords.add("VEGAN");
         randomWords.add("BASIL");
 
        int index = (int) (Math.random()*randomWords.size());
        strAns = randomWords.get(index);
          
        winnerStat = false;
        curStatus = false;
    }

    public void setWinner(Boolean inBool)
    {
        winnerStat = inBool;
    }

    public void gameIsOver(Boolean inBoolExp)
    {
        curStatus = inBoolExp;
    }

    public Boolean getGameStatus()
    {
        return curStatus;
    }

    public Boolean getWinner() 
    {
        return winnerStat;
    }

    public String getAnswer()
    {
        return strAns;
    }

    public static boolean hasRepeats(String inStr)
    {
        int repeatCount = 0;
        System.out.println(inStr);
        for (int i = 0; i < inStr.length() - 1; i++) 
        {
            String check = inStr.substring(i, i + 1);
            for (int j = i + 1; j < inStr.length(); j++) 
            {
                if (inStr.substring(j).indexOf(check) != -1)
                {
                    repeatCount++;
                }
            }
        }
        if (repeatCount > 0) {
            return true;
        } else 
        {
            return false;

        }
    }

    public Color checkPos(String letter, int position) {
        if (letter.equals(strAns.substring(position, position + 1))) {
            return new Color(108, 169, 101);
        } else if (strAns.indexOf(letter) == -1) {
            return new Color(120, 124, 127);
        } else if (strAns.indexOf(letter) != -1) {
            return new Color(200, 182, 83);
        }
        return new Color(120, 124, 127);
    }

}
