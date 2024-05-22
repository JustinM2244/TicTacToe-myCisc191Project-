import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

public class CheckerPieceListener implements ActionListener
{
	private CheckerBoardModel model;
	private GameView view;
	private CheckerPiece checkerPiece;
	
	
	public CheckerPieceListener(CheckerBoardModel model, GameView view, CheckerPiece checkerPiece)
	{
		this.model = model;
		this.view = view;
		this.checkerPiece = checkerPiece;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{		
		if(model.getColor(checkerPiece.getRow(), checkerPiece.getColumn()) == null)
		{
			view.selectTile(checkerPiece);
		}	
		
		if(model.getPlayerTurn() == Color.black) 
		{
			if(model.getColor(checkerPiece.getRow(), checkerPiece.getColumn()) == Color.black)
			{
				try 
				{	
					if(model.getColor(checkerPiece.getRow() + 1, checkerPiece.getColumn() + 1) == Color.black 
						&& model.getColor(checkerPiece.getRow() + 1, checkerPiece.getColumn() - 1) == Color.black)
					{
						view.showAlert("This Piece Cant Move");
					}
					else
					{
						view.selectTile(checkerPiece);
					}	
				}	
				
				catch(ArrayIndexOutOfBoundsException a)
				{
					view.selectTile(checkerPiece);
				}		
			}
		
		}
		
		
		if(model.getPlayerTurn() == Color.red) 
		{	
			if(model.getColor(checkerPiece.getRow(), checkerPiece.getColumn()) == Color.red)
			{
				try 
				{						
					if( model.getColor(checkerPiece.getRow() - 1, checkerPiece.getColumn() - 1) == Color.red 
							&& model.getColor(checkerPiece.getRow() - 1, checkerPiece.getColumn() + 1) == Color.red)
					{
							view.showAlert("This Piece Cant Move");
					}
					else
					{
						view.selectTile(checkerPiece);
					}
				}
				
				catch(ArrayIndexOutOfBoundsException a)
				{
					view.selectTile(checkerPiece);
				}	
			}
		}
	}

	
}
