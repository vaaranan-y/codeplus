import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.BadLocationException;




public class MainScreen extends JPanel implements ActionListener{

	
	public static JPanel textAreaPanel;
	public static JTextArea textArea;
	
	public static JPanel noteAreaPanel;
	private JLabel noteHeader;
	private JButton addButton;
	public static ArrayList<Note> notes;	
	private int length;	
	public MainScreen() {
		
		setLayout(null);
		setSize(1000,600);
		notes = new ArrayList<>();
		length = 490;
		
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(null);
		textAreaPanel.setSize(720,630);
		textAreaPanel.setLocation(280,0);
		
        textArea = new JTextArea("public static void main(String[] args){\n\n}");
        textArea.setRows(45);
        textArea.setColumns(45);
        textArea.setLocation(0, 0);
        textArea.setFont(new Font("Courier", Font.PLAIN, 15));
        
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScrollPane.setBounds(0, 0, 720, 630);
        textAreaPanel.add(textScrollPane);
        TextLineNumber tln = new TextLineNumber(textArea);
        textScrollPane.setRowHeaderView(tln);
        add(textAreaPanel);
		
        noteHeader = new JLabel("Notes", SwingConstants.CENTER);
        noteHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1 ));
        noteHeader.setSize(280,70);
        noteHeader.setFont(new Font("Arial", Font.BOLD, 15));
        noteHeader.setLocation(0, 0);
        add(noteHeader);
        
		noteAreaPanel = new JPanel();
		noteAreaPanel.setPreferredSize(new Dimension(280,length));
		noteAreaPanel.setLayout(null);

        JScrollPane noteScrollPane = new JScrollPane(noteAreaPanel);
        noteScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        noteScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        noteScrollPane.setBounds(0, 70, 280, 470);
        noteScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(noteScrollPane);
        
        addButton = new JButton("ADD");
		addButton.setSize(280,70);
        addButton.setLocation(0, 540);
        addButton.addActionListener(this);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(addButton);
		
	}
	
	public void actionPerformed(ActionEvent e) 
    {
		if(e.getSource() == addButton)
        {
			String reference = textArea.getSelectedText();
			if (reference == null)
			{
				reference = "";
			}
			
			Note newNote = new Note(reference);
			notes.add(newNote);
	        newNote.setLocation(0, (Note.numberOfNotes-1)*68);
			noteAreaPanel.add(newNote);
            repaint();
            
            if(Note.numberOfNotes >= 6) {
	        	length += 70;
	        	noteAreaPanel.setPreferredSize(new Dimension(280,length));
	        }
			revalidate();
            
            int caretpos = textArea.getCaretPosition();
            try {
				int lineNumber = textArea.getLineOfOffset(caretpos);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            

        }
		
    }
		
}
