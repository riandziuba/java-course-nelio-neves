package org.example;

import org.example.model.entities.UI;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.ChessPosition;
import org.example.model.exceptions.BoardException;
import org.example.model.exceptions.ChessException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
            Scanner scanner = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            List<ChessPiece> captured = new ArrayList<>();

            while (!chessMatch.isCheckMate()) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch, captured);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(scanner);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(scanner);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }

                    if(chessMatch.getPromotedPiece() != null) {
                        System.out.print("Enter piece for promotion: (B,N,Q,R) ");
                        String type = scanner.nextLine();
                        chessMatch.replacePromotedPiece(type);
                    }
                } catch (ChessException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            }

            UI.clearScreen();
            UI.printMatch(chessMatch, captured);

//        } catch (BoardException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }

    }
}