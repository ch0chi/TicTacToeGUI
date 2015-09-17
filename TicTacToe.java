import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class TicTacToe extends JFrame{
	


	public enum Mark{XMARK, OMARK, EMPTY};
	public enum Status{XWIN, OWIN, TIE, ONGOING};
	
	private boolean turn = true;
	private Mark[][] board = new Mark[3][3];
	
	
	public TicTacToe() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++){
				board[row][column] = Mark.EMPTY;
			}
		}
	}
	
public void displayBoard(){
		

		
		
		
		for (int row=0; row<board.length;row++){
			for (int col=0;col<board[0].length;col++){
				System.out.print("\t"+board[row][col]);
				//print bar
				if (col== 0 || col==1){
					
				}
			}
			if (row ==0 || row ==1){
				
			
			
			}
		} 
	}
	
	
	
	public void clearTheBoard(){
		for(int row=0; row<3;row++){
			for(int col =0; col < 3; col++){
				board[row][col]=Mark.EMPTY;
			}
		}
		turn = true;
	}

	public void setMark(int x, int y){
		if(board[x][y]==Mark.EMPTY){
			if(turn == true){
				board[x][y]=Mark.XMARK;
				turn = false;
				
				
			}
			else if(turn == false){
				board[x][y]=Mark.OMARK;
				
				
				turn = true;
			}
		}
	}
	
	public Mark getLocation(int row, int col){
		Mark mark = board[row][col];
		
		return mark;
	}
	
	
	

	
public Status checkForWinner(){
	
		
	
			for (int i = 0; i < 3; i++){
				//check if horizontal
				if(board[i][0] == board[i][1] && board [i][1]==board[i][2]){
					Mark mark = getLocation(i,0);
					if(mark == Mark.XMARK){
						return Status.XWIN;
					}else if (mark == Mark.OMARK){
						return Status.OWIN;
					}else{
						return Status.ONGOING;
					}
				}
			}
			
				//check if vertical
			for(int i = 0; i <3;i++){
				if(board[0][i] == board[1][i] && board[0][i]==board[2][i]){
					Mark mark = getLocation(0,i);
					if(mark == Mark.XMARK){
						return Status.XWIN;
					}else if (mark == Mark.OMARK){
						return Status.OWIN;
					}else{
						return Status.ONGOING;
					}
				}
			}
				
			//check if diagonal
			for(int i =0; i<3;i++){
			if(board[0][0]==board[1][1] && board[0][0] == board[2][2]){
				Mark mark = getLocation(0,0);
				if(mark== Mark.XMARK){
					return Status.XWIN;
				}else if (mark == Mark.OMARK){
					return Status.OWIN;
				}else{
					return Status.ONGOING;
				}
					}
			}
			
			//check if reverse diagonal
			for(int i=0;i<3;i++){
				if(board[0][2]==board[1][1] && board[1][1]== board[0][2]){
					Mark mark = getLocation(0,2);
					if(mark== Mark.XMARK){
						return Status.XWIN;
					}else if (mark == Mark.OMARK){
						return Status.OWIN;
					}else{
						return Status.ONGOING;
					}
				}
		}
			
			
			
		 
			//check draw
		    for (int i = 0; i < 3; i++)
		    {
		        for (int j = 0; j < 3; j++)
		        {
		            if (board[i][j] != Mark.XMARK && board[i][j] != Mark.OMARK && board[i][j] !=Mark.EMPTY)
		            {
		                return Status.TIE;
		            }
		        }
		    }
		   
		   
		    return Status.ONGOING;
		}
		  
			
	
}
	