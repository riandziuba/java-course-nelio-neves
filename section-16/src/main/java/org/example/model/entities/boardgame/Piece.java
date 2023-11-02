package org.example.model.entities.boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return this.possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] moves = this.possibleMoves();

        for (boolean[] row : moves) {
            for (boolean move : row) {
                if (move)
                    return true;
            }
        }
        return false;
    }
}
