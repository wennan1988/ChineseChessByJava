package org.wen.chess.ui;

import com.pj.chess.chessmove.MoveNode;

import javax.swing.*;

/**
 * ����
 * */
abstract class ChessPiece extends JLabel {

    /**
     * �ŷ��������ж�
     */
    boolean legalMove(int play, MoveNode moveNode){

        return true;
    }
}
