package org.example;

import org.example.model.entities.UI;
import org.example.model.entities.boardgame.Position;
import org.example.model.entities.chess.ChessMatch;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}