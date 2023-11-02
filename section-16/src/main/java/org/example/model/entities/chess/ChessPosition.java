package org.example.model.entities.chess;

import org.example.model.entities.boardgame.Position;
import org.example.model.exceptions.ChessException;

import java.util.InputMismatchException;

public class ChessPosition {
    private char column;
    private int row;
    public ChessPosition(int row, char column) {
        try {

        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are a1 to h8");
        }
        if (column < 'a' && column > 'h' && row < 1 && row > 8) {
            throw new ChessException("Error Instancing ChessPosition. Valid values are from a1 to h8");
        }
        this.row = row;
        this.column = column;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition() {
        return new Position(8 - this.row, this.column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition( 8 - position.getRow(), (char)('a' + position.getColumn()));
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
