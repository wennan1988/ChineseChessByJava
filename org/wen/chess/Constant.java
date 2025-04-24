package org.wen.chess;

import com.pj.chess.ChessBoardMain;

import java.net.URL;

public final class Constant {
    // ��ʼ����
    public final static String DEFAULT_MATCH = "rnbakabnr/9/1c5c1/p1p1p1p1p/9/9/P1P1P1P1P/1C5C1/9/RNBAKABNR";

    public final static int BOARDSIZE90=90;

    public static final String[] chessName = new String[]{
            "   ", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            "�ڽ�", "�ڳ�", "�ڳ�", "����", "����", "����", "����", "����", "����", "��ʿ", "��ʿ", "����", "����", "����", "����", "����",
            "�콫", "�쳵", "�쳵", "����", "����", "����", "����", "����", "����", "��ʿ", "��ʿ", "����", "����", "����", "����", "����",
    };
    public static final String[] chessIcon = new String[]{
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            "BK", "BR", "BR", "BN", "BN", "BC", "BC", "BB", "BB", "BA", "BA", "BP", "BP", "BP", "BP", "BP",
            "RK", "RR", "RR", "RN", "RN", "RC", "RC", "RB", "RB", "RA", "RA", "RP", "RP", "RP", "RP", "RP",
    };

    public final static int MOVE_SOUND = 1;
    public final static int CAPTURE_SOUND = 2;
    public final static int CHECKED_SOUND = 3;
    public final static int LOSS_SOUND = 4;

    public static final URL MOVEPATHURL = ChessBoardMain.class.getResource("/sounds/MOVE.WAV");
    public static final URL CHECKEDURL = ChessBoardMain.class.getResource("/sounds/CHECKED.WAV");
    public static final URL CAPTUREURL = ChessBoardMain.class.getResource("/sounds/CAPTURE.WAV");
    public static final URL LOSSURL = ChessBoardMain.class.getResource("/sounds/LOSS.WAV");
}
