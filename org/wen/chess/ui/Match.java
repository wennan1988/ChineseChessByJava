package org.wen.chess.ui;

import com.pj.chess.ChessInitialize;
import com.pj.chess.NodeLink;
import com.pj.chess.Tools;
import com.pj.chess.chessmove.ChessMovePlay;
import com.pj.chess.evaluate.EvaluateComputeMiddleGame;
import com.pj.chess.zobrist.TranspositionTable;
import org.wen.chess.Constant;

/**
 * ��ֿ����߼�
 */
public class Match {
    public static void main(String[] args) {
        new Board();
    }

    /**
     * ��ֳ�ʼ��
     */
    private void initialize() {
        String savedMatch = readSaved();

        String[] fenArray = Tools.fenToFENArray(savedMatch);
        int[] boardTemp = Tools.parseFEN(fenArray[1]);
        //�������̳�ʼ����
        chessParamCont = ChessInitialize.getGlobalChessParam(boardTemp);
        //������н���ͼƬ
//		clearBoardIcon();
        //��ʼ��������
        for (int i = 0; i < boardTemp.length; i++) {
            if (boardTemp[i] > 0) {
                this.setBoardIconUnchecked(i, boardTemp[i]);
            }
        }

        //��ʼ����(Ҫ�����Ӱںú���ܼ������ֵ)
        transTable = new TranspositionTable();
        if (moveHistory == null) {
            moveHistory = new NodeLink(1 - play, transTable.boardZobrist32, transTable.boardZobrist64);
        }
        play = 1 - moveHistory.play;
        android[1 - play] = true;
        cmp = new ChessMovePlay(chessParamCont, transTable, new EvaluateComputeMiddleGame(chessParamCont));
    }

    /*
     * ��ȡ�ϴα����¼
     */
    private String readSaved() {

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
        return Constant.DEFAULT_MATCH;
    }
}
