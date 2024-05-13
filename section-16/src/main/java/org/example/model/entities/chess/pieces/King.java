package org.example.model.entities.chess.pieces;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
        return piece == null || piece.getColor() != this.getColor();
    }

    @Override
    public String toString() {
        return "K";
    }

    public boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
        return piece != null && piece.getColor() == this.getColor() && piece instanceof Rook && piece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0, 0);

        position.setValues(this.position.getRow() - 1, this.position.getColumn());
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn());
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(position) && this.canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        if (this.getMoveCount() == 0 && !this.chessMatch.isCheck()) {
            Position positionRook1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
            if (this.testRookCastling(positionRook1)) {
                Position positionCastling1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position positionCastling2 = new Position(this.position.getRow(), this.position.getColumn() + 2);
                if (this.getBoard().piece(positionCastling1) == null && this.getBoard().piece(positionCastling2) == null) {
                    moves[this.position.getRow()][this.position.getColumn() + 2] = true;
                }
            }

            Position positionRook2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
            if (this.testRookCastling(positionRook2)) {
                Position positionCastling1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position positionCastling2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position positionCastling3 = new Position(this.position.getRow(), this.position.getColumn() - 3);
                if (this.getBoard().piece(positionCastling1) == null && this.getBoard().piece(positionCastling2) == null && this.getBoard().piece(positionCastling3) == null) {
                    moves[this.position.getRow()][this.position.getColumn() - 2] = true;
                }
            }
        }

        return moves;
    }
}
