package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0, 0);
        if (this.getColor().equals(Color.WHITE)) {
            position.setValues(this.position.getRow() - 1, this.position.getColumn());
            if (this.getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() - 2, this.position.getColumn());
            Position auxPosition =  new Position(this.position.getRow() - 1, this.position.getColumn());
            if (this.getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && this.getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && this.getMoveCount() == 0) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
            if (this.getBoard().positionExists(position) && getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        } else {
            position.setValues(this.position.getRow() + 1, this.position.getColumn());
            if (this.getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() + 2, this.position.getColumn());
            Position auxPosition =  new Position(this.position.getRow() + 1, this.position.getColumn());
            if (this.getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && this.getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && this.getMoveCount() == 0) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
            if (this.getBoard().positionExists(position) && getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        }
        if (this.getBoard().positionExists(position) && getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        return moves;
    }

    @Override
    public String toString() {
        return "p";
    }
}
