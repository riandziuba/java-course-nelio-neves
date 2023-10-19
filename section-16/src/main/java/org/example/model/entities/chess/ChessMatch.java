package org.example.model.entities.chess;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.pieces.King;
import org.example.model.entities.chess.pieces.Rook;

public class ChessMatch {
    Board board;

    public ChessMatch() {
        this.board = new Board(8,8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return chessPieces;
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece) {
        board.placePiece(chessPiece, new ChessPosition(row, column).toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece('a' , 8, new Rook(board, Color.WHITE));
        this.placeNewPiece('e', 8, new King(board, Color.WHITE));
        this.placeNewPiece('e', 1, new King(board, Color.WHITE));
    }

}
