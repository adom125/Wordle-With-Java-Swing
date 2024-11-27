import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelperClass extends JPanel implements ActionListener
{
    private final String BUTTONTXT = "PLAY AGAIN";
    private String gameName;
    private JButton playButton;
    private JPanel thePanel;
    private JPanel otherPanel;
    private JPanel keyPanel;
    private static boolean isEnterPressed = false;
    private JPanel addAllPanel;
    private static JButton [][] keyMatrix = new JButton[3][10];

    
	public HelperClass(JButton [][] inMat)
	{
		playButton = new JButton(BUTTONTXT);
        thePanel = new JPanel();
        keyMatrix = inMat;
    	keyPanel = new JPanel();

    	addAllPanel = new JPanel();
    	addAllPanel.setLayout(new BorderLayout());
    	
    	keyMatrix[0][0] = new JButton("Q");
    	keyMatrix[0][1] = new JButton("W");
    	keyMatrix[0][2] = new JButton("E");
    	keyMatrix[0][3] = new JButton("R");
    	keyMatrix[0][4] = new JButton("T");
    	keyMatrix[0][5] = new JButton("Y");
    	keyMatrix[0][6] = new JButton("U");
    	keyMatrix[0][7] = new JButton("I");
    	keyMatrix[0][8] = new JButton("O");
    	keyMatrix[0][9] = new JButton("P");
    	keyMatrix[1][0] = new JButton("A");
    	keyMatrix[1][1] = new JButton("S");
    	keyMatrix[1][2] = new JButton("D");
    	keyMatrix[1][3] = new JButton("F");
    	keyMatrix[1][4] = new JButton("G");
    	keyMatrix[1][5] = new JButton("H");
    	keyMatrix[1][6] = new JButton("J");
    	keyMatrix[1][7] = new JButton("K");
    	keyMatrix[1][8] = new JButton("L");
    	keyMatrix[1][9] = new JButton("");
    	keyMatrix[2][0] = new JButton("ENTER");
    	keyMatrix[2][1] = new JButton("Z");
    	keyMatrix[2][2] = new JButton("X");
    	keyMatrix[2][3] = new JButton("C");
    	keyMatrix[2][4] = new JButton("V");
    	keyMatrix[2][5] = new JButton("B");
    	keyMatrix[2][6] = new JButton("N");
    	keyMatrix[2][7] = new JButton("M");
    	keyMatrix[2][8] = new JButton("<");
    	keyMatrix[2][9] = new JButton("");
    	for(int r = 0; r < keyMatrix.length; r++)
    	{
    		for(int c = 0; c < keyMatrix[0].length; c++)
    		{
    			keyMatrix[r][c].setBackground(Color.WHITE);
    			keyMatrix[r][c].setFont(new Font("Helvetica", Font.BOLD, 15));
    			if(r == 2 && c == 0)
    			{
        			keyMatrix[r][c].setFont(new Font("Helvetica", Font.BOLD, 13));
    			}
    			 if(r == 1 && c != 9)
    			{
    				keyPanel.add(keyMatrix[r][c]);   
    	  		    keyMatrix[r][c].addActionListener(this);
    			}
    			 if(c == 9 && r < 1)
    			{
    				keyPanel.add(keyMatrix[r][c]); 
     		        keyMatrix[r][c].addActionListener(this);

    			}
    			 if(r != 1 && c != 9)
    			{
    				keyPanel.add(keyMatrix[r][c]);   
     		        keyMatrix[r][c].addActionListener(this);
    			}
    			
    		}
    	}
    	playButton.setBackground(Color.WHITE);
        thePanel.add(playButton);
	}
    public HelperClass(String inName)
    {
        gameName = inName;
        otherPanel = new JPanel();
        JLabel theLabel = new JLabel(inName, JLabel.CENTER);
        theLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        otherPanel.add(theLabel);
    }
 
    public JPanel addingKey()
    {
    	return keyPanel;
    }
    public String getNameButton()
   {
    	return BUTTONTXT;
   }
    public JButton getButton()
    {
    	return playButton;
    }

	public JPanel addingButton ()
    {
		addAllPanel.add(keyPanel, BorderLayout.CENTER);
		addAllPanel.add(thePanel, BorderLayout.SOUTH);
    	addAllPanel.setPreferredSize(new Dimension(100,155));
        return addAllPanel;
    }
    
    public JPanel addingGameName()
    {
        return otherPanel;
    }
	
	public static void changeColor(String inStr, Color inColor)
	{
		String str = inStr;
		for(int r = 0; r < keyMatrix.length; r ++)
		{
			for(int c = 0; c < keyMatrix[0].length; c++)
				if(keyMatrix[r][c].getText().equals(inStr))
				{
					keyMatrix[r][c].setBackground(inColor);
				}
		}
		
	}
	public void actionPerformed (ActionEvent e)
	{
		String txt = e.getActionCommand();	
		
		if(txt.equals("Q"))
		{
			MyJPanel.setLetter("Q");
		}
		if(txt.equals("W"))
		{
			MyJPanel.setLetter("W");
		}
		if(txt.equals("E"))
		{
			MyJPanel.setLetter("E");
		}
		if(txt.equals("R"))
		{
			MyJPanel.setLetter("R");
		}
		if(txt.equals("T"))
		{
			MyJPanel.setLetter("T");
		}
		if(txt.equals("Y"))
		{
			MyJPanel.setLetter("Y");
		}
		if(txt.equals("U"))
		{
			MyJPanel.setLetter("U");
		}
		if(txt.equals("I"))
		{
			MyJPanel.setLetter("I");
		}
		if(txt.equals("O"))
		{
			MyJPanel.setLetter("O");
		}
		if(txt.equals("P"))
		{
			MyJPanel.setLetter("P");
		}
		if(txt.equals("A"))
		{
			MyJPanel.setLetter("A");
		}
		if(txt.equals("S"))
		{
			MyJPanel.setLetter("S");
		}
		if(txt.equals("D"))
		{
			MyJPanel.setLetter("D");
		}
		if(txt.equals("F"))
		{
			MyJPanel.setLetter("F");
		}
		if(txt.equals("G"))
		{
			MyJPanel.setLetter("G");
		}
		if(txt.equals("H"))
		{
			MyJPanel.setLetter("H");
		}
		if(txt.equals("J"))
		{
			MyJPanel.setLetter("J");
		}
		if(txt.equals("K"))
		{
			MyJPanel.setLetter("K");
		}
		if(txt.equals("L"))
		{
			MyJPanel.setLetter("L");
		}
		if(txt.equals("Z"))
		{
			MyJPanel.setLetter("Z");
		}
		if(txt.equals("X"))
		{
			MyJPanel.setLetter("X");
		}
		if(txt.equals("C"))
		{
			MyJPanel.setLetter("C");
		}
		if(txt.equals("V"))
		{
			MyJPanel.setLetter("V");
		}
		if(txt.equals("B"))
		{
			MyJPanel.setLetter("B");
		}
		if(txt.equals("N"))
		{
			MyJPanel.setLetter("N");
		}
		if(txt.equals("M"))
		{
			MyJPanel.setLetter("M");
		}
		 if(txt.equals("<")  && MyJPanel.getCurCol() >= 0)
			{
	           System.out.println("in method");
				if(MyJPanel.getTheTxt().length() == 1)
				{
                    MyJPanel.clearMethod();
					 
				}
				else
				{
					if(MyJPanel.getCurCol() > 0 )
					{
						MyJPanel.decCurColumn();
					}
				}
				MyJPanel.keyboardReqFocus();
			}
	        if(txt.equals("ENTER"))
	        {

	        	if(MyJPanel.wordMaker().length() < 5) 
	        	{
	        		JOptionPane.showMessageDialog(this, "Finish Entering The Word.");
	        		MyJPanel.decCurColumn();
	        		MyJPanel.clearMethod();
	        	}
	        	
	        	if(Wordle.hasRepeats(MyJPanel.wordMaker()) == true)
	        	{
	        		JOptionPane.showMessageDialog(this, "No Repeats Allowed.");

	        	}
	        	else
	        	{
	        		isEnterPressed = true;
	        		 if(MyJPanel.getCurCol() + 1 >= MyJPanel.getTextFieldColLen() && MyJPanel.getCurRow() <= MyJPanel.getTextFieldRowLen()-1 ) 
	                 {
	        			MyJPanel.displayCorrectColor();
	        			
	        			for(int c = 0; c < MyJPanel.getTextFieldColLen(); c++)
	        			{
	           			  	MyJPanel.disableTextField(c);
	           			 
	           		  	}
	           		  	if(MyJPanel.getCurRow() == MyJPanel.getTextFieldRowLen()-1 && MyJPanel.getCurCol() + 1 >= MyJPanel.getTextFieldColLen() && !(MyJPanel.getWordleAnswer().equals(MyJPanel.wordMaker())) )
	           		  	{
	           		  		MyJPanel.getWordleStatus(true);
	           		  		JOptionPane.showMessageDialog(this, "Game Over! The Word Was: " + MyJPanel.getWordleAnswer());
	           		  	}
	           		 
	           		  	if(MyJPanel.getWordleAnswer().equals(MyJPanel.wordMaker()))
	           		  	{
	           		  		JOptionPane.showMessageDialog(this, "You Won."); 
	           		  		MyJPanel.keyboardWinner();
	                   		
	           		  	}
	                  MyJPanel.incCurRow();
	                  MyJPanel.setCurColumn(0);//fix
	                 }
	        	}
	        }
	}
	public static boolean enterPressed()
	{
		return isEnterPressed;
	}
	
}