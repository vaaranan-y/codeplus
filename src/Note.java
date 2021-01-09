import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Note extends JPanel implements ActionListener, FocusListener, MouseListener, MouseWheelListener, WindowListener{

	private String title;
	private String reference;
	private String comment;
	private JButton editButton;
	private Note next;
	private Detail detailWindow;
	private JTextField commentBox;
	
	private int noteNumber;
	public static int numberOfNotes = 0;
	private JLabel refLink;
	
	public Note(String ref){
		setLayout(null);
		setSize(new Dimension(260,70));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		numberOfNotes++;
		noteNumber = numberOfNotes;
		title = "Note "+noteNumber;
		reference = ref;
		comment = "";
		detailWindow = new Detail(title,ref,comment, noteNumber);
		detailWindow.addWindowListener(this);
		
		commentBox = new JTextField("Comment Here");
		commentBox.setFont(new Font("Arial", Font.PLAIN, 10));
		commentBox.setForeground(Color.LIGHT_GRAY);
		commentBox.setLocation(2, 40);
		commentBox.setSize(100, 20);
		commentBox.addActionListener(this);
		commentBox.addFocusListener(this);
		commentBox.addMouseWheelListener(this);
		add(commentBox);
		
		JLabel header = new JLabel(title);
		header.setLocation(2, 0);
		header.setSize(100, 20);
		header.setFont(new Font("Arial", Font.BOLD, 15));
		add(header);
		
		refLink = new JLabel("Reference");
		refLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refLink.setLocation(2, 20);
		refLink.setSize(100, 20);
		refLink.setFont(new Font("Arial",Font.PLAIN,13));
		refLink.addMouseListener(this);
		add(refLink); 
		
		editButton = new JButton("Edit");
		editButton.setFont(new Font("Arial", Font.PLAIN,7));
		editButton.setSize(25, 12);
		editButton.setLocation(234, 1);
		editButton.addActionListener(this);
		add(editButton);
		
	}
	
	public void setComment(String edit)
	{
		comment = edit;
		detailWindow.setComment(comment);
	}
	
	
	public String getComment() {
		return comment;
	}
	
	public void setReference(String ref) {
		reference = ref;
	}
	
	public String getReference() {
		return reference;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commentBox) {
			comment = commentBox.getText();
			setComment(commentBox.getText());
		}
		else if(e.getSource()==editButton) {
			detailWindow.open();
			
			commentBox.setText(comment);
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==commentBox && (commentBox.getText().equals("")||commentBox.getText().equals("Comment Here"))){
			commentBox.setText(null);
			commentBox.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==commentBox) {
			if(commentBox.getText().equals("")) {
				commentBox.setForeground(Color.LIGHT_GRAY);
				commentBox.setText("Comment Here");
			}
			else {
				comment = commentBox.getText();
				setComment(comment);
				commentBox.setCaretPosition(0);
			}
			
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == refLink) {
			System.out.println(reference);
		}
		/*
		 * 
		Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
		reference = MainScreen.keys.get(noteNumber-1);
		int offset = MainScreen.textBox.getText().indexOf(reference);
        int length = reference.length();
        
        while(offset != -1){
        	try {
				MainScreen.textBox.getHighlighter().addHighlight(offset, offset + length, painter);
				offset = MainScreen.textBox.getText().indexOf(reference, offset + 1);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        }
		 */
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == detailWindow) {
			if(!detailWindow.getComment().equals(null)||!detailWindow.getComment().equals("")) {
				commentBox.setForeground(Color.BLACK);
				commentBox.setText(detailWindow.getComment());
				commentBox.setCaretPosition(0);
			}
			
			
			
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
