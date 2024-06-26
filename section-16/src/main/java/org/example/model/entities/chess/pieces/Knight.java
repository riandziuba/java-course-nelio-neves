package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class Knight extends ChessPiece{
    public Knight(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
        return piece == null || piece.getColor() != this.getColor();
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0, 0);

        position.setValues(this.position.getRow() - 2, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 2);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }
        return moves;
    }
}
