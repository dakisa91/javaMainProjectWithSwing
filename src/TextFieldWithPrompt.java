
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.FocusManager;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ForTheWind
 */
public class TextFieldWithPrompt extends JTextField{
 
	private String label;
	
	public TextFieldWithPrompt(String st)
	{ 
		this.label = st; 
	}
	
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
 
        if(getText().isEmpty() && ! (FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setBackground(Color.gray);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.drawString(label, 5, 18); //figure out x, y from font's FontMetrics and size of component.
            g2.dispose();
        }
      }
	
}
