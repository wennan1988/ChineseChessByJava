package org.wen.chess.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuItemActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
//        if ("�½�".equals(actionCommand)) {
//            dispose();
//            new ChessBoardMain();
//        } else if ("����".equalsIgnoreCase(actionCommand)) {
//            Tools.saveFEN(chessParamCont.board, moveHistory);
//        } else if ("����".equals(actionCommand)) {
//            computerLevel = ComputerLevel.greenHand;
//        } else if ("����".equals(actionCommand)) {
//            computerLevel = ComputerLevel.introduction;
//        } else if ("ҵ��".equals(actionCommand)) {
//            computerLevel = ComputerLevel.amateur;
//        } else if ("ר��".equals(actionCommand)) {
//            computerLevel = ComputerLevel.career;
//        } else if ("��ʦ".equals(actionCommand)) {
//            computerLevel = ComputerLevel.master;
//        } else if ("�޵�".equals(actionCommand)) {
//            computerLevel = ComputerLevel.invincible;
//        } else if ("���Ժ췽".equals(actionCommand)) {
//            android[REDPLAYSIGN] = !android[REDPLAYSIGN];
//            if (android[REDPLAYSIGN] && (REDPLAYSIGN == play || turn_num <= 0)) {
//                if (turn_num <= 0) {
//                    play = REDPLAYSIGN;
//                    moveHistory.play = 1 - REDPLAYSIGN;
//                }
//                computeThinkStart();
//            }
//        } else if ("���Ժڷ�".equals(actionCommand)) {
//            android[BLACKPLAYSIGN] = !android[BLACKPLAYSIGN];
//            if (android[BLACKPLAYSIGN] && (BLACKPLAYSIGN == play || turn_num <= 0)) {
//                if (turn_num <= 0) {
//                    play = BLACKPLAYSIGN;
//                    moveHistory.play = 1 - BLACKPLAYSIGN;
//                }
//                computeThinkStart();
//            }
//        } else if ("HASH��С".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0x7FFFF);
//            }
//        } else if ("HASH����".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0xFFFFF);
//            }
//        } else if ("HASH���".equals(actionCommand)) {
//            if (turn_num == 0) {
//                TranspositionTable.setHashSize(0x1FFFFF);
//            }
//        } else if ("��̨˼��".equals(actionCommand)) {
//            isBackstageThink = !isBackstageThink;
//        } else if ("��Ч".equals(actionCommand)) {
//            isSound = !isSound;
//        }
    }
}
