package org.wen.chess.ui;

import com.pj.chess.NodeLink;
import com.pj.chess.chessmove.MoveNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.pj.chess.ChessConstant.NOTHING;
import static com.pj.chess.ChessConstant.chessPlay;

/**
 * ÊÂ¼þ¼àÌýÆ÷
 */
class EventListener implements ActionListener, WindowListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {

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