package org.example;

import org.example.model.entities.UI;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;
import org.example.model.exceptions.BoardException;

public class Main {
    public static void main(String[] args) {
//        try {
            ChessMatch chessMatch = new ChessMatch();
            UI.printBoard(chessMatch.getPieces());
//        } catch (BoardException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }

    }
}