package org.example.model.entities.chess;

import org.example.model.entities.boardgame.Board;
import org.example.model.entities.boardgame.Piece;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.pieces.*;
import org.example.model.exceptions.ChessException;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;

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

    public boolean isCheck() {
        return check;
    }

    public boolean isCheckMate() {
        return checkMate;
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

    private Color opponent(Color color) {
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    List<Piece> getPiecesOfColor(Color color) {
        return piecesOnTheBoard.stream().filter(piece -> ((ChessPiece) piece).getColor().equals(color)).toList();
    }

    private ChessPiece king(Color color) {
        List<Piece> list = this.getPiecesOfColor(color);
        for (Piece piece : list) {
            if (piece instanceof King) {
                return (ChessPiece) piece;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = this.king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = this.getPiecesOfColor(this.opponent(color));

        for (Piece piece : opponentPieces) {
            boolean [][] possibleMoves = piece.possibleMoves();
            if(possibleMoves[kingPosition.getRow()][kingPosition.getColumn()]) return true;
        }

        return false;
    }

    public boolean testCheckMate(Color color) {

        if (!testCheck(color)) {
            return false;
        }

        List<Piece> pieces = this.getPiecesOfColor(color);
        for (Piece piece : pieces) {
            boolean [][] possibleMoves = piece.possibleMoves();
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    if (possibleMoves[i][j]) {
                        Position source = ((ChessPiece) piece).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean checkMateVerify = this.testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if (!checkMateVerify) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece) {
        board.placePiece(chessPiece, new ChessPosition(row, column).toPosition());
        piecesOnTheBoard.add(chessPiece);
    }

    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE, this));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK, this));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        this.validateSourcePosition(source);
        this.validateTargetPosition(source, target);
        Piece capturedPiece = this.makeMove(source, target);

        if (testCheck(currentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }

        ChessPiece movedPiece = (ChessPiece) this.board.piece(target);

        this.check = testCheck(opponent(currentPlayer));

        this.checkMate = testCheckMate(opponent(currentPlayer));


        if (!this.checkMate) this.nextTurn();

        this.enPassantVulnerable = null;
        if(movedPiece instanceof Pawn && (target.getRow() == source.getRow() + 2 || target.getRow() == source.getRow() - 2)) {
            this.enPassantVulnerable = movedPiece;
        }

        return (ChessPiece) capturedPiece;
    }

    public void validateTargetPosition(Position source, Position target) {
        if (!this.board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece piece = (ChessPiece) board.removePiece(source);
        piece.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(piece, target);
        if (capturedPiece != null) {
            capturedPieces.add(capturedPiece);
            piecesOnTheBoard.remove(capturedPiece);
        }

        if (piece instanceof King) {
            if (target.getColumn() == source.getColumn() + 2) {
                Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
                Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
                ChessPiece rook = (ChessPiece) this.board.removePiece(sourceRook);
                this.board.placePiece(rook, targetRook);
                rook.increaseMoveCount();
            } else if (target.getColumn() == source.getColumn() - 2) {
                Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
                Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
                ChessPiece rook = (ChessPiece) this.board.removePiece(sourceRook);
                this.board.placePiece(rook, targetRook);
                rook.increaseMoveCount();
            }
        }

        if (piece instanceof Pawn) {
            if (capturedPiece == null) {
                if (target.getColumn() == source.getColumn() + 1) {
                    Position opponentPosition = new Position(source.getRow(), source.getColumn() + 1);
                    capturedPiece = this.board.removePiece(opponentPosition);
                    capturedPieces.add(capturedPiece);
                    piecesOnTheBoard.remove(capturedPiece);
                } else if (target.getColumn() == source.getColumn() - 1) {
                    Position opponentPosition = new Position(source.getRow(), source.getColumn() - 1);
                    capturedPiece = this.board.removePiece(opponentPosition);
                    capturedPieces.add(capturedPiece);
                    piecesOnTheBoard.remove(capturedPiece);
                }
            }
        }

        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece piece = (ChessPiece) board.removePiece(target);
        piece.decreaseMoveCount();
        board.placePiece(piece, source);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }

        if (piece instanceof King) {
            if (target.getColumn() == source.getColumn() + 2) {
                Position sourceRook = new Position(source.getRow(), source.getColumn() + 3);
                Position targetRook = new Position(source.getRow(), source.getColumn() + 1);
                ChessPiece rook = (ChessPiece) this.board.removePiece(targetRook);
                this.board.placePiece(rook, sourceRook);
                rook.decreaseMoveCount();
            } else if (target.getColumn() == source.getColumn() - 2) {
                Position sourceRook = new Position(source.getRow(), source.getColumn() - 4);
                Position targetRook = new Position(source.getRow(), source.getColumn() - 1);
                ChessPiece rook = (ChessPiece) this.board.removePiece(targetRook);
                this.board.placePiece(rook, sourceRook);
                rook.decreaseMoveCount();
            }
        }

        if (piece instanceof Pawn) {
            if (capturedPiece == enPassantVulnerable) {
                ChessPiece opponentPawn = (ChessPiece) this.board.removePiece(target);
                if (target.getColumn() == source.getColumn() + 1) {
                    Position opponentPosition = new Position(source.getRow(), source.getColumn() + 1);
                    this.board.placePiece(opponentPawn, opponentPosition);
                } else if (target.getColumn() == source.getColumn() - 1) {
                    Position opponentPosition = new Position(source.getRow(), source.getColumn() - 1);
                    this.board.placePiece(opponentPawn, opponentPosition);
                }
            }
        }
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

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }
}
