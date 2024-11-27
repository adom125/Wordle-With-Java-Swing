import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class WordleGUITester
{
      private static JFrame frameObj;
   
	  public WordleGUITester() throws FileNotFoundException
	  {
	      frameObj = new JFrame();
	      frameObj.setTitle("Wordle");
	      frameObj.setSize(530, 700);
              frameObj.setLocation(350,60);
           
	      HelperClass helperObj = new HelperClass(new JButton[3][10]);
              HelperClass otherHelp = new HelperClass("WORDLE");
	      MyJPanel panelObj = new MyJPanel(helperObj.getNameButton(), helperObj. getButton());
	      frameObj.setLayout(new BorderLayout());
	      frameObj.add(helperObj.addingButton(), BorderLayout.SOUTH);
              frameObj.add(otherHelp.addingGameName() , BorderLayout.NORTH);
	      frameObj.add(panelObj, BorderLayout.CENTER); 
	      frameObj.setVisible(true);
              frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	  public static void main(String[] args) throws FileNotFoundException 
	  {
	  	  WordleGUITester runWordle = new WordleGUITester();
	  }

          public static void closeGame()
          {
                  frameObj.setVisible(false);
          }
}
