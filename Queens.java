package main.java;
//N queens backtracking

//ISSUES NOT SOLVED
public class Queens {
	int num;
	boolean board[][];
	public boolean safety(int row,int col) {
		for(int i=0;i<num;i++) {
			if(board[row][i]==true || board[i][row]==true)
				return false;
		}
		if(row>=col)
			for(int i=0, j=row-col;i<num && j<num && i!=row && j!=col;i++,j++) {
				if(board[row][i]==true || board[i][row]==true)
					return false;
			}
		else
			for(int i=0,j=col-row;i<num && j<num && i!=row && j!=col;i++,j++) {
				if(board[row][i]==true || board[i][row]==true)
					return false;
			}
		for(int j=0,i=row+col;i<num && j<num && i!=row && j!=col;i--,j++) {
			if(board[row][i]==true || board[i][row]==true)
				return false;
		}
		return true;
	}
	public void backtrack(int row,int n) {
		for(int i=0;i<num;i++) {
			if(safety(row, i)) {
				board[row][i]=true;
				if(row==n-1) {
					printBoard();
					return;
				}
				else {
					backtrack(row+1, n);
					board[row][i]=false;
				}
			}
		}
	}
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==true)
					System.out.println("Queen at position:"+"("+i+","+j+")");
			}
		}
	}
	
	
	public static void main(String args[]) {
		int num=8;
		boolean board[][]=new boolean[num][num];
		for(int i=0;i<num;i++) {
			for(int j=1;j<num;j++) {
				board[i][j]=false;
			}
		}
		Queens q=new Queens();
		q.num=num;
		q.board=board;
		q.backtrack(0, num);
	}
}
