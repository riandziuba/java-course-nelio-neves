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

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
        board.placePiece(new King(board, Color.WHITE), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }

}
