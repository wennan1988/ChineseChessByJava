package org.wen.chess;

import com.pj.chess.NodeLink;
import com.pj.chess.chessmove.ChessMovePlay;
import com.pj.chess.zobrist.TranspositionTable;
import org.wen.chess.ui.Board;

/**
 * ��ֿ����߼�
 */
public class Game {

    TranspositionTable transTable;

    NodeLink moveHistory;

    int play = 1;

    volatile boolean[] android = new boolean[]{false, false};

    ChessMovePlay cmp = null;

    public static void main(String[] args) {
        new Game().initialize();
    }

    /**
     * ��ֳ�ʼ��
     */
    private void initialize() {

        char[] boardTemp = readSaved();

        //��ʼ��������
        new Board(boardTemp);

        //��ʼ����(Ҫ�����Ӱںú���ܼ������ֵ)
        transTable = new TranspositionTable();
        if (moveHistory == null) {
            moveHistory = new NodeLink(1 - play, transTable.boardZobrist32, transTable.boardZobrist64);
        }
        play = 1 - moveHistory.play;
        android[1 - play] = true;
    }

    /*
     * ��ȡ�ϴα����¼
     */
    private char[] readSaved() {

        // TODO
//        String fen = null;

//        try (BufferedReader fileInput = new BufferedReader(new FileReader("chess.txt"))) {
//
//            while (fileInput.ready()) {
//                fen = fileInput.readLine();
//            }
//
//        } catch (Exception e) {
//            fen = Constant.DEFAULT_MATCH;
//        } finally {
//            if (fileInput != null) {
//                try {
//                    fileInput.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        String data = Constant.DEFAULT_MATCH;

        char[] board=new char[90];
        int boardIndex = 0;
        
        int i=0;
        while(data.length()>i){
            if(Character.isAlphabetic(data.charAt(i))){

                board[boardIndex]=data.charAt(i);
                boardIndex++;
            }else if(Character.isDigit(data.charAt(i))){
                boardIndex+= Integer.parseInt(String.valueOf(data.charAt(i)));
            }
            i++;
        }
        return board;
    }
}
