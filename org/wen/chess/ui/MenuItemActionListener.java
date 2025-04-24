package org.wen.chess.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuItemActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
//        if ("新建".equals(actionCommand)) {
//            dispose();
//            new ChessBoardMain();
//        } else if ("保存".equalsIgnoreCase(actionCommand)) {
//            Tools.saveFEN(chessParamCont.board, moveHistory);
//        } else if ("菜鸟".equals(actionCommand)) {
//            computerLevel = ComputerLevel.greenHand;
//        } else if ("入门".equals(actionCommand)) {
//            computerLevel = ComputerLevel.introduction;
//        } else if ("业余".equals(actionCommand)) {
//            computerLevel = ComputerLevel.amateur;
//        } else if ("专家".equals(actionCommand)) {
//            computerLevel = ComputerLevel.career;
//        } else if ("大师".equals(actionCommand)) {
//            computerLevel = ComputerLevel.master;
//        } else if ("无敌".equals(actionCommand)) {
//            computerLevel = ComputerLevel.invincible;
//        } else if ("电脑红方".equals(actionCommand)) {
//            android[REDPLAYSIGN] = !android[REDPLAYSIGN];
//            if (android[REDPLAYSIGN] && (REDPLAYSIGN == play || turn_num <= 0)) {
//                if (turn_num <= 0) {
//                    play = REDPLAYSIGN;
//                    moveHistory.play = 1 - REDPLAYSIGN;
//                }
//                computeThinkStart();
//            }
//        } else if ("电脑黑方".equals(actionCommand)) {
//            android[BLACKPLAYSIGN] = !android[BLACKPLAYSIGN];
//            if (android[BLACKPLAYSIGN] && (BLACKPLAYSIGN == play || turn_num <= 0)) {
//                if (turn_num <= 0) {
//                    play = BLACKPLAYSIGN;
//                    moveHistory.play = 1 - BLACKPLAYSIGN;
//                }
//                computeThinkStart();
//            }
//        } else if ("HASH表小".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0x7FFFF);
//            }
//        } else if ("HASH表中".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0xFFFFF);
//            }
//        } else if ("HASH表大".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0x1FFFFF);
//            }
//        } else if ("后台思考".equals(actionCommand)) {
//            isBackstageThink = !isBackstageThink;
//        } else if ("音效".equals(actionCommand)) {
//            isSound = !isSound;
//        }
    }
}
