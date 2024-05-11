package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0, 0);

        position.setValues(this.position.getRow() - 1, this.position.getColumn() -1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
            position.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && this.isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
            position.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && this.isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
            position.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && this.isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
            position.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && this.isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }
        return moves;
    }
}
