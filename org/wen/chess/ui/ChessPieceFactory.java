package org.wen.chess.ui;

import javax.swing.*;

/**
 * Æå×Ó¹¤³§
 */
final class ChessPieceFactory {

    static JLabel createChessPiece(char name) {
        JLabel chessPiece = null;

        switch (name) {
            case 'r':
            case 'R':
                chessPiece = new Chariot();
                break;
            case 'n':
            case 'N':
                chessPiece = new Horse();
                break;
            case 'b':
            case 'B':
                chessPiece = new Elephant();
                break;
            case 'a':
            case 'A':
                chessPiece = new Guardian();
                break;
            case 'k':
            case 'K':
                chessPiece = new General();
                break;
            case 'c':
            case 'C':
                chessPiece = new Cannon();
                break;
            case 'p':
            case 'P':
                chessPiece = new Soldier();
                break;
            default:
                chessPiece = new JLabel();
                break;
        }

        return chessPiece;
    }
}
