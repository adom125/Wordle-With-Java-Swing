import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class EntryLimit extends PlainDocument
{
	private final int WORDLENRESTRICTION = 1;
	
	public void insertString( int offs, String inStr, AttributeSet a)throws BadLocationException
	{
		if((inStr.length() + this.getLength()) == WORDLENRESTRICTION)
		{
			super.insertString(offs, inStr, a);
		}
	}
}

