package space.demihypercube.calculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class Main 
{
	
	public static void main(String args[])
	{
		
		//Creates the JFrame and configures it.
		JFrame window = new JFrame("Calculator");
		window.setSize(670, 110);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		window.setResizable(false);
		
		//Creates the JPanel.
		JPanel panel = new JPanel();
		window.add(panel);
		
		//Creates the first text box.
		JTextPane textPane = new JTextPane(new DefaultStyledDocument() {
		    @Override
		    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		        if ((getLength() + str.length()) <= 20) {
		            super.insertString(offs, str, a);
		        }
		        else {
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		textPane.setPreferredSize(new Dimension(20, 20));
		panel.add(textPane);
		
		//This will make the window appear.
		window.setVisible(true);
	}
}