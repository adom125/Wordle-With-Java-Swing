import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.Border;

public class MyJPanel extends JPanel implements ActionListener, KeyListener, FocusListener
{
    private static int curRow = 0;
    private static int curColumn = 0;
    private static Wordle wordle = null;
    private static JTextField[][] textFields = new JTextField[6][5]; 
    private String pressedButton;
    private JButton theButton;
	
	
    public MyJPanel(String inNameButton, JButton inButton) throws FileNotFoundException
    {	             
	pressedButton = inNameButton;
	theButton = inButton;
	this.setBackground(Color.WHITE);
	wordle = new Wordle();
	//textFields = new JTextField[6][5];
       // curRow = 0;
	//curColumn = 0;
        this.setLayout (new GridLayout(6,5,3,3));
        
        for(int r = 0; r < textFields.length; r++)
        {
            for(int c = 0; c < textFields[0].length; c++)
            {
                textFields [r][c] = new JTextField(1);
                add(textFields[r][c]);
                textFields[r][c].setDocument(new EntryLimit());
                textFields[r][c].addActionListener(this);
                textFields[r][c].addKeyListener(this);
                textFields[r][c].addFocusListener(this); 
                textFields[r][c].setHorizontalAlignment(JTextField.CENTER);
                textFields[r][c].setFont(new Font("Helvetica", Font.BOLD, 25));
                textFields[r][c].setCaretColor(Color.WHITE);
            }
        }
       theButton.addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e)
	{
		String txt = e.getActionCommand();	
		
		if(txt.equals(pressedButton) && (wordle.getWinner() == true || wordle.getGameStatus() == true ))
		{
			System.out.println("New Game");
			curRow = 0;
			curColumn = 0;
			
			WordleGUITester.closeGame();
			try
			{
      			WordleGUITester genObj = new WordleGUITester();
			}
			catch (FileNotFoundException ex)  
			{
				// insert 
			}
		}
		else
		{
			textFields[curRow][curColumn].requestFocus();
		}
	
	}
	public void keyReleased(KeyEvent e) 
	{
		System.out.println("EVENT: KEY RELEASED. You RELEASED a key and the system called this method.\n");
		
	 	textFields[curRow][curColumn].setText(textFields[curRow][curColumn].getText().toUpperCase());

		 	textFields[curRow][curColumn].requestFocus();

		 		if(textFields[curRow][curColumn].getText().length() == 1 && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) //my computer made noise when i did this lol
		 		{
		                if(curColumn+1 < textFields[0].length)
		                {
		                	if(containsLetters(textFields[curRow][curColumn])== true)
		                	{
			 					curColumn++;			   

		                	}
		                	else
		                	{
		                		JOptionPane.showMessageDialog(this, "ERROR! Non-Letter Enetered.");
		                		textFields[curRow][curColumn].setText("");
		                	}
		                }
		                if(curColumn+1 == textFields[0].length && containsLetters(textFields[curRow][curColumn]) == false )
		                { 
		                	JOptionPane.showMessageDialog(this, "ERROR! Non-Letter Enetered.");
		                	textFields[curRow][curColumn].setText("");
		                }
		 		}
			 	textFields[curRow][curColumn].requestFocus();
			 	System.out.println("I just requested focus");

	}
	public void keyPressed(KeyEvent e) 
	{

		System.out.println("EVENT: KEY PRESSED. You PRESSED a key and the system called this method.\n");

		 if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE  && curColumn > 0)
		{
           
			if(textFields[curRow][curColumn].getText().length() == 1)
			{
				 textFields[curRow][curColumn].setText("");
				 textFields[curRow][curColumn].requestFocus();
			}
			else
			{
				curColumn--;				
			}
		}
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
        	
        	if(wordMaker().length() < 5) //for checking if the word is fully entered
        	{
        		JOptionPane.showMessageDialog(this, "Finish Entering The Word.");
        		curColumn--;
        		textFields[curRow][curColumn].setText("");
			 	textFields[curRow][curColumn].requestFocus();
        	}
        	if(Wordle.hasRepeats(wordMaker()) == true)
        	{
        		JOptionPane.showMessageDialog(this, "No Repeats Allowed.");

        	}
        	else
        	{
        		 if(curColumn + 1 >= textFields[0].length && curRow <= textFields.length-1 ) 
                 {
        			displayCorrectColor();
        			
           		  for(int c = 0; c < textFields[0].length; c++)
           		  {
           			  textFields[curRow][c].setEnabled(false);
           			  textFields[curRow][c].setDisabledTextColor(Color.WHITE);
           		  }
           		  if(curRow == textFields.length-1 && curColumn + 1 >= textFields[0].length && !(wordle.getAnswer().equals(wordMaker())) )
           		  {
           			wordle.gameIsOver(true); 
              		JOptionPane.showMessageDialog(this, "Game Over! The Word Was: " + wordle.getAnswer());
           		  }
           		 
                  if(wordle.getAnswer().equals(wordMaker()))
             	  {
                   		JOptionPane.showMessageDialog(this, "You Won."); 
                   		wordle.setWinner(true);
                   		textFields[curRow][curColumn].setFocusable(false);

                   		curRow++;
                   		curColumn = 0;

                   		for(int row = curRow; row < textFields.length; row++ )
                   		{
                   			for( int col = curColumn; col < textFields[0].length; col++)
                   			{
                   			  textFields[row][col].setEnabled(false);
                   			}
                   		}
                   		System.out.println(textFields[curRow][curColumn].hasFocus());
             	  }
                  curRow++;
                  curColumn = 0;//fix
                 }
        	}
        }
	}

	public void focusGained(FocusEvent e) 
	{ 
		Border borderObj = BorderFactory.createStrokeBorder(new BasicStroke(2));
		Component componentObj= (Component)e.getSource(); 
		((JComponent) componentObj).setBorder(borderObj);
	} 
	public void focusLost(FocusEvent e) 
	{ 
		Border bObj = BorderFactory.createStrokeBorder(new BasicStroke(1), Color.GRAY);
		Component compObj = (Component)e.getSource(); 
		((JComponent) compObj).setBorder(bObj);
	} 
	public void keyTyped(KeyEvent e) 
	{
		System.out.println("EVENT: KEY TYPED. You TYPED a key and the system called this method.\n");
		
	}
	public static void displayCorrectColor()
	{
		String inText = "";
		inText = wordMaker();
		
		for(int pos = 0; pos < inText.length(); pos++)
		{
			Color setField = wordle.checkPos((inText.substring(pos, pos+1)), pos);
			
			HelperClass.changeColor((inText.substring(pos, pos+1)), setField);
			
			textFields[curRow][pos].setBackground(setField);
		}
	}
	public static String wordMaker()
	{
		String word = "";
		for(int i = 0; i < textFields[0].length; i++)
		{
			word = word + textFields[curRow][i].getText();
		}
		return word;
	}
	public boolean containsLetters(JTextField inField)
	{
		String check = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if(check.indexOf(inField.getText())!= -1)
			return true;
		else 
			return false;
	}
	public static int getCurCol()
	{
		return curColumn;
	}

	public static int getCurRow() 
	{
		return curRow;
	}

	public static void decCurColumn() 
	{
		curColumn = curColumn - 1;
	}

	public static void incCurRow()
    {
        curRow = curRow + 1;
    }
    public static String getTheTxt()
    {
        return textFields[curRow][curColumn].getText();
    }
    public static void setLetter(String inLet)
    {       
    	textFields[curRow][curColumn].setText(inLet); 
    	if(HelperClass.enterPressed()== true && curColumn + 1 >= textFields[0].length && curRow + 1 < textFields.length )
    	{
    		System.out.println("going here");
    	}
    	else
    	{
    		if(curColumn + 1 < textFields[0].length)
    			curColumn++; 
    	}
	 	textFields[curRow][curColumn].requestFocus();

    }
    public static void clearMethod()
    {
        textFields[curRow][curColumn].setText(""); 
		textFields[curRow][curColumn].requestFocus();
    }
    
	public static int getTextFieldColLen()
	{
		return textFields[0].length;
	}

    public static void setCurColumn(int inNum)
    {
        curColumn = inNum;
    }
	public static int getTextFieldRowLen() 
	{
		return textFields.length;
	}

	public static void keyboardWinner()
	{
		 wordle.setWinner(true);
   		 textFields[curRow][curColumn].setFocusable(false);

          curRow++;
          curColumn = 0;
   		for(int row = curRow; row < textFields.length; row++ )
   		{
   			for( int col = curColumn; col < textFields[0].length; col++)
   			{
   			  textFields[row][col].setEnabled(false);
   			}
   		}		
	}

	public static void disableTextField(int c) 
	{
		 textFields[curRow][c].setEnabled(false);
	     textFields[curRow][c].setDisabledTextColor(Color.WHITE);		
	}

	public static void getWordleStatus(boolean b) 
	{
		wordle.gameIsOver(b);
	}

	public static String getWordleAnswer() 
	{
		return wordle.getAnswer();
	}

	public static void keyboardReqFocus()
	{
	 	textFields[curRow][curColumn].requestFocus();		
	}
}
	
