package org.wen.chess.ui;

import com.pj.chess.NodeLink;
import com.pj.chess.chessmove.MoveNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.pj.chess.ChessConstant.NOTHING;
import static com.pj.chess.ChessConstant.chessPlay;

/**
 * 事件监听器
 */
class EventListener implements ActionListener, WindowListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {
//        Button sour = (Button) e.getSource();
//        if (sour.getLabel().equals("悔棋")) {
//            if (moveHistory.getMoveNode() != null) {
//                MoveNode moveNode = moveHistory.getMoveNode();
//                unMoveNode(moveNode);
//                moveHistory = moveHistory.getLastLink();
//                turn_num--;
//                play = 1 - play; //交换双方
//            }
//        } else if (sour.getLabel().equals("立即走棋")) {
//            if (_AIThink != null) {
//                _AIThink.setStop();
//            }
//        }
    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent arg0) {

    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        System.exit(1);
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {

    }

    @Override
    public void windowIconified(WindowEvent arg0) {

    }

    @Override
    public void windowOpened(WindowEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        if(android[play]){
//            return;
//        }
        System.out.println("button pressed!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}