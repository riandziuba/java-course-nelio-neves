package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
