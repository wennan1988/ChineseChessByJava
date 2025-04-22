package org.wen.chess;

public final class Constant {
    // 初始局面
    public final static String DEFAULT_MATCH = "rnbakabnr/9/1c5c1/p1p1p1p1p/9/9/P1P1P1P1P/1C5C1/9/RNBAKABNR";

    public  static final int BOARDSIZE90=90;

    public static final String[] chessName = new String[]{
            "   ", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            "黑将", "黑车", "黑车", "黑马", "黑马", "黑炮", "黑炮", "黑象", "黑象", "黑士", "黑士", "黑卒", "黑卒", "黑卒", "黑卒", "黑卒",
            "红将", "红车", "红车", "红马", "红马", "红炮", "红炮", "红象", "红象", "红士", "红士", "红卒", "红卒", "红卒", "红卒", "红卒",
    };
    public static final String[] chessIcon = new String[]{
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            "BK", "BR", "BR", "BN", "BN", "BC", "BC", "BB", "BB", "BA", "BA", "BP", "BP", "BP", "BP", "BP",
            "RK", "RR", "RR", "RN", "RN", "RC", "RC", "RB", "RB", "RA", "RA", "RP", "RP", "RP", "RP", "RP",
    };
}
