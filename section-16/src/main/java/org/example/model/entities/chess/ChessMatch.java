package org.example.model.entities.chess;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Piece;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.pieces.King;
import org.example.model.entities.chess.pieces.Rook;
import org.example.model.exceptions.ChessException;

public class ChessMatch {
    Board board;
    int turn;
    Color currentPlayer;


    public ChessMatch() {
        this.board = new Board(8,8);
        this.turn = 1;
        this.currentPlayer = Color.WHITE;
        this.initialSetup();
    }

    private void nextTurn() {
        turn++;
        this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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

    private void placeNewPiece(char column, int row, ChessPiece chessPiece) {
        board.placePiece(chessPiece, new ChessPosition(row, column).toPosition());
    }

    private void initialSetup() {
        this.placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        this.placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        this.placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        this.placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        this.placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        this.placeNewPiece('d', 1, new King(board, Color.WHITE));

        this.placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        this.placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        this.placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        this.placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        this.placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        this.placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        this.validateSourcePosition(source);
        this.validateTargetPosition(source, target);
        Piece capturedPiece = this.makeMove(source, target);
        this.nextTurn();
        return (ChessPiece) capturedPiece;
    }

    public void validateTargetPosition(Position source, Position target) {
        if (!this.board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target) {
        Piece piece = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(piece, target);
        return capturedPiece;
    }

    public void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (this.currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
           throw new ChessException("The chosen piece it's not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible move for the chosen piece");
        }
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
         Position position = sourcePosition.toPosition();
         this.validateSourcePosition(position);
         return this.board.piece(position).possibleMoves();
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

}
