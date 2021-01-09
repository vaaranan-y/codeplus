import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Detail extends JFrame implements ActionListener{
	
	private String title;
	private String code;
	private String comment;
	private JTextArea selectedCode;
	private JTextArea noteComment;
	private JButton deleteButton;
	private int noteNumber;
	
	public Detail(String title, String code, String comment, int noteNumber) {
		this.title= title;
		this.code = code;
		this.comment = comment;
		this.noteNumber = noteNumber;
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		setSize(550,350);
		setTitle(this.title);
		
		JLabel codeLabel = new JLabel("Code:");
		codeLabel.setLocation(50, 25);
		codeLabel.setSize(70, 20);
		codeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(codeLabel);
		selectedCode = new JTextArea(code);
		selectedCode.setRows(5);
		selectedCode.setColumns(10);
		JScrollPane codeScroller = new JScrollPane(selectedCode);
		codeScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		codeScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		codeScroller.setBounds(125, 25, 300, 100);
		setLocation(0,0);
		panel.add(codeScroller);
		
		JLabel commentLabel = new JLabel("Comment:");
		commentLabel.setLocation(50, 150);
		commentLabel.setSize(70, 20);
		commentLabel.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(commentLabel);
		noteComment = new JTextArea(comment);
		//noteComment.addActionListener(this);
		noteComment.setRows(5);
		noteComment.setColumns(10);
		noteComment.setLineWrap(true);
		noteComment.setWrapStyleWord(true);
		JScrollPane noteScroller = new JScrollPane(noteComment);
		noteScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		noteScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		noteScroller.setBounds(125, 150, 300, 100);
		setLocation(0,0);
		panel.add(noteScroller);
		
		deleteButton = new JButton("Delete");
		deleteButton.setSize(100, 25);
		deleteButton.setLocation(450,0);
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 10));
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		
		
	}
	
	public void open() {
		setLocation(400, 250);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void  setComment(String newComment){
		comment = newComment;
		noteComment.setText(comment);
	}
	
	public String  getComment(){
		comment = noteComment.getText();
		return comment;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deleteButton) {
			System.out.println(noteNumber);
			MainScreen.noteAreaPanel.remove(MainScreen.notes.get(noteNumber - 1));
			MainScreen.notes.remove(noteNumber - 1); 
			MainScreen.noteAreaPanel.repaint();
			for(int i = noteNumber - 1; i < MainScreen.notes.size(); i++){
				MainScreen.notes.get(i).setLocation(0, i*68);
			}
			MainScreen.noteAreaPanel.repaint();
			Note.numberOfNotes -= 1;
			dispose();
			
		}
		
	}
}
