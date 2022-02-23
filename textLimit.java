import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Set a limit for the text fields in the JFrames
 */
public class textLimit extends PlainDocument {
	
	private int limit;
	
	/**
	 * set the limit number
	 */
	   textLimit(int limit) {
	      super();
	      this.limit = limit;}
	   
	   
	   /**
	    * prevent user from typing more than the limit by override insertString
	    */
	   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	      if (str == null)
	         return;
	      if ((getLength() + str.length()) <= limit) {
	         super.insertString(offset, str, attr);
	      }
	   }   
}
	

