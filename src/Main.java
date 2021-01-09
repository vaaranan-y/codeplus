import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
	
	private CardLayout panels;
	private Container contentPane;
	public static MainScreen mainScreen;
	
	public Main(){
		/*
		 * panels = new CardLayout();
		contentPane = getContentPane();
		contentPane.setLayout(panels);
		
		mainScreen = new MainScreen();
		contentPane.add(mainScreen);
		 */
		
		setContentPane(new MainScreen());
		pack();
		setResizable(false);
		setTitle("Code Plus");
		setSize(1000,630);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Main();
	}
}