

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tic_tac_toe {

	public enum Player {
		X('X'), O('O');

		char value;
		

		Player(char value) {
			this.value = value;
		}
		
		Player(int val){
			this.value = value;
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int row_x;
		int row_y;
		int counter=0;
		Player turn = Player.X;
		
	//	System.out.println(master.value);
		Character[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		String[] columnNames = { "1", "2", "3", };
		
		JOptionPane.showMessageDialog(null, "Welcome to Tic Tac Toe");

		while (true) {

			JOptionPane.showMessageDialog(null, "It is the turn of Player " + turn.value);
			try {
				row_x = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row"));
				row_y = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column"));

				if (row_x <= board.length - 1 && row_y <= board[0].length - 1) {

					if (board[row_x][row_y] == ' ') {

						board[row_x][row_y] = turn.value;

					
						if (check_for_win(board) == false) {
							JOptionPane.showMessageDialog(null, "Player " + turn.value + " Wins");
							break;
						}
						
						counter +=1;
						if(counter == 9){
							JOptionPane.showMessageDialog(null, "Match Draw");
							break;
						}

						if (turn.value == 'X') {
							turn.value = 'O';
						}

						else {
							turn.value = 'X';
						}

					} else {
						JOptionPane.showMessageDialog(null, "The block is already filled");
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "Please enter the correct value for the row and column...........");
				}
			} catch (Exception e) {
			
				JOptionPane.showMessageDialog(null, "Please enter the correct value for the row and column!!!!!!!!");
			}

			DefaultTableModel model = new DefaultTableModel(board, columnNames);
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			
//
			//JOptionPane.showMessageDialog(null, board );

			JOptionPane.showMessageDialog(null, scrollPane, "Board", 1);

			// break;
		}

		DefaultTableModel model = new DefaultTableModel(board, columnNames);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		
//
		//JOptionPane.showMessageDialog(null, board );

		JOptionPane.showMessageDialog(null, scrollPane, "Board", 1);
		
		// for (int i = 0; i <= 0; i++) {
		// for (int j = 0; j <= 0; j++) {
		// // board[i][j] =
		// }
		//
		// }

		// Character[][] data = new Character[board.length][board[0].length];
		//JOptionPane.showMessageDialog(null, scrollPane, "Board", 1);

	}

	public static boolean check_for_win(Character board[][]) {

		boolean check = true;

		// Checking Horizontal
		for (int i = 0; i <= board.length-1; i++) {
			int j = 0;
//System.out.println(board[i][j]);
			if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] != ' ') {
				check = false;
				break;
			}

		}

		// Checking Vertical
		for (int j = 0; j <= board.length - 1; j++) {	
			int i = 0;
		//	System.out.println(board[i][j]);
			if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] != ' ') {
				check = false;
				break;

			}
		}

		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
			check = false;
		}

		if (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != ' ') {
			check = false;

		}

		return check;

	}
	


}
