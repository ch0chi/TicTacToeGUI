import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {
	private JButton[][] button = new JButton[3][3];
	
	TicTacToe ticTacToe = new TicTacToe();
	public Interface(){
		makeBoard();
		
	}
	public static void main(String[]args){
		Interface board = new Interface();
	}
	public void makeBoard(){
		JFrame board = new JFrame("Tic Tac Toe");
		board.setSize(500, 500);
		board.setLayout(new GridLayout(3,3));
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int place = 1;
		for(int row = 0; row<3;row++){
			for(int col=0; col<3;col++){
				button[row][col]=new JButton("");
				button[row][col].setBackground(Color.RED);
				button[row][col].setFont(new Font("",Font.PLAIN, 100));
				//button[row][col].setName(Integer.toString(place));
				button[row][col].setName("Location" + row + col );
				button[row][col].addActionListener(new Listener(row,col));
				board.add(button[row][col]);
				place+= 1;
			}
		}
		board.setVisible(true);
		
	}
	private class Listener implements ActionListener{
		private int row;
		private int col;
		//for testing purposes only
		private int clickCount =0;
	
	
	public Listener(int i, int j){
		row=i;
		col=j;
	}
	
	
	public void actionPerformed (ActionEvent e) {
		buttonPress(row,col);
		
		
	}
}
	public void buttonPress(int row, int col){
		ticTacToe.setMark(row,col);
		
		if(ticTacToe.getLocation(row,col)==TicTacToe.Mark.XMARK){
			button[row][col].setText("X");
			
		}
		else if(ticTacToe.getLocation(row,col)==TicTacToe.Mark.OMARK){
			button[row][col].setText("O");
			
		}
		
		if(ticTacToe.checkForWinner()==TicTacToe.Status.XWIN){
			int delay = 50;
			ActionListener taskPerformer = new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					JOptionPane.showMessageDialog(null,"The winner is X","Game Over",JOptionPane.INFORMATION_MESSAGE);
				}
			};
			Timer myTimer = new Timer(delay, taskPerformer);
	        myTimer.setRepeats(false);
	        myTimer.start();
		}
	
	else if(ticTacToe.checkForWinner()==TicTacToe.Status.OWIN){
		int delay= 50;
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JOptionPane.showMessageDialog(null,"The winner is O", "Game Over",JOptionPane.INFORMATION_MESSAGE);
			}
		};
		Timer myTimer = new Timer(delay, taskPerformer);
        myTimer.setRepeats(false);
        myTimer.start();
	}
	else if(ticTacToe.checkForWinner()==TicTacToe.Status.TIE){
		int delay=50;
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"The winner is TIE", "Game Over",JOptionPane.INFORMATION_MESSAGE);
			}
		};
		Timer myTimer = new Timer(delay, taskPerformer);
        myTimer.setRepeats(false);
        myTimer.start();
		
	}
	
	
	}	


}
