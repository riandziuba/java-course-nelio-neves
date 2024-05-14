package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

        if (this.position.getRow() == 3) {
            Position leftPosition = new Position(this.position.getRow(), this.position.getColumn() - 1);
            if (getBoard().positionExists(leftPosition) && isThereOpponentPiece(leftPosition) && this.chessMatch.getEnPassantVulnerable() == this.getBoard().piece(leftPosition)) {
                moves[leftPosition.getRow() - 1][leftPosition.getColumn()] = true;
            }

            Position rightPosition = new Position(this.position.getRow(), this.position.getColumn() + 1);
            if (getBoard().positionExists(rightPosition) && isThereOpponentPiece(rightPosition) && this.chessMatch.getEnPassantVulnerable() == this.getBoard().piece(rightPosition)) {
                moves[rightPosition.getRow() - 1][rightPosition.getColumn()] = true;
            }
        }

        if (this.position.getRow() == 4) {
            Position leftPosition = new Position(this.position.getRow(), this.position.getColumn() - 1);
            if (getBoard().positionExists(leftPosition) && isThereOpponentPiece(leftPosition) && this.chessMatch.getEnPassantVulnerable() == this.getBoard().piece(leftPosition)) {
                moves[leftPosition.getRow() + 1][leftPosition.getColumn()] = true;
            }

            Position rightPosition = new Position(this.position.getRow(), this.position.getColumn() + 1);
            if (getBoard().positionExists(rightPosition) && isThereOpponentPiece(rightPosition) && this.chessMatch.getEnPassantVulnerable() == this.getBoard().piece(rightPosition)) {
                moves[rightPosition.getRow() + 1][rightPosition.getColumn()] = true;
            }
        }

        return moves;
    }

    @Override
    public String toString() {
        return "p";
    }
}
