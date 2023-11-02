package org.example;

import org.example.model.entities.UI;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;
import org.example.model.entities.chess.ChessPiece;
import org.example.model.entities.chess.ChessPosition;
import org.example.model.exceptions.BoardException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
            Scanner scanner = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();

            while (true) {
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }

//        } catch (BoardException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }

    }
}