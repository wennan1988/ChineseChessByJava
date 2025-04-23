package org.wen.chess.ui;

import com.pj.chess.chessmove.MoveNode;

import javax.swing.*;

/**
 * 棋子
 * */
abstract class ChessPiece extends JLabel {

    /**
     * 着法合理性判断
     */
    boolean legalMove(int play, MoveNode moveNode){

        return true;
    }
}
