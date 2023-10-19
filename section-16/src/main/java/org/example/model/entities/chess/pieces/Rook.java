package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
