package org.example.model.entities.chess;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Piece;
import org.example.model.entities.boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
     public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
         ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
         return piece != null && piece.getColor() != this.getColor();
    }
}
