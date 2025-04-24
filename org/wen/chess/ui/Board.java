package org.wen.chess.ui;

import com.pj.chess.*;
import com.pj.chess.chessmove.ChessMovePlay;
import com.pj.chess.chessmove.MoveNode;
import com.pj.chess.chessparam.ChessParam;
import com.pj.chess.zobrist.TranspositionTable;
import org.wen.chess.Constant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static com.pj.chess.ChessConstant.*;

public final class Board extends JFrame {

    private static final long serialVersionUID = 1L;

    int lastTimeCheckedSite = -1; //上次选中棋子的位置

    JLabel[] buttons = new JLabel[Constant.BOARDSIZE90];
    int play = 1;
    volatile boolean[] android = new boolean[]{false, false};
    int begin = -1;
    int end = 0;
    private static ComputerLevel computerLevel = ComputerLevel.greenHand; //默认
    boolean isBackstageThink = false;
    boolean computeFig = false;
    TranspositionTable transTable;
    ChessMovePlay cmp = null;
    AICoreHandler _AIThink = new AICoreHandler();
    AICoreHandler backstageAIThink = new AICoreHandler();
    //	public static List<MoveNode> backMove=new ArrayList<MoveNode>();
    NodeLink moveHistory;
    int turn_num = 0;//回合数
    ChessParam chessParamCont;
    private static boolean isSound = false;

    JPanel jPanelContent;

    private void setCenter(char[] boardData) {
        if (jPanelContent != null) {
            this.remove(jPanelContent);
        }
        jPanelContent = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    BufferedImage img = ImageIO.read(getClass().getResource("/images/MAIN.GIF"));
                    g.drawImage(img, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        this.setLayout(new BorderLayout());

        jPanelContent.setLayout(new BorderLayout());
        //北
        JPanel jpNorth = new JPanel();
        jpNorth.setPreferredSize(new Dimension(25, 25));
//		jpNorth.setBackground(Color.white);
        jpNorth.setOpaque(false);
        jPanelContent.add(jpNorth, BorderLayout.NORTH);
        //南
        JPanel jpSouth = new JPanel();
        jpSouth.setPreferredSize(new Dimension(25, 25));
        jpSouth.setBackground(Color.black);
        jpSouth.setOpaque(false);
        jPanelContent.add(jpSouth, BorderLayout.SOUTH);
        //西
        JPanel jpWest = new JPanel();
        jpWest.setPreferredSize(new Dimension(20, 20));
        jpWest.setBackground(Color.blue);
        jpWest.setOpaque(false);
        jPanelContent.add(jpWest, BorderLayout.WEST);
        //东
        JPanel jpEast = new JPanel();
        jpEast.setPreferredSize(new Dimension(20, 20));
        jpEast.setBackground(Color.CYAN);
        jpEast.setOpaque(false);
        jPanelContent.add(jpEast, BorderLayout.EAST);

        //中
        JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new GridLayout(10, 9));
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setOpaque(false);

        for (int i = 0; i < boardData.length; i++) {
            JLabel p = ChessPieceFactory.createChessPiece(boardData[i]);

            if ('\u0000' != boardData[i]) {
                p.setIcon(getImageIcon(boardData[i]));
                p.addMouseListener(new EventListener());
            }

            p.setBackground(Color.red);
            p.setSize(55, 55);
            panel.add(p);
        }

        jPanelContent.add(panel, BorderLayout.CENTER);

        this.add(jPanelContent, BorderLayout.CENTER);
    }

    public Board(char[] boardData) {
        super("新中国象棋");
        setCenter(boardData);

        JPanel control = new JPanel();
        control.setLayout(new GridLayout(1, 3));

        final EventListener listener = new EventListener();
        Button button = new Button("悔棋");
        button.addActionListener(listener);
        Button computerMove = new Button("立即走棋");
        computerMove.addActionListener(listener);
        control.add(button);
        control.add(computerMove);
        this.add(control, BorderLayout.SOUTH);

        this.addWindowListener(listener);
        this.setJMenuBar(setJMenuBar());

        this.setSize(568, 710);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    JRadioButtonMenuItem hashSize2M = new JRadioButtonMenuItem("HASH表小", true);
    JRadioButtonMenuItem hashSize32M = new JRadioButtonMenuItem("HASH表中", false);
    JRadioButtonMenuItem hashSize64M = new JRadioButtonMenuItem("HASH表大", false);

    private JMenuBar setJMenuBar() {
        JMenuBar jmb = new JMenuBar();
        JMenu menu_file = new JMenu("文件");
        JMenuItem create = new JMenuItem("新建");
        JMenuItem save = new JMenuItem("保存");
        JRadioButtonMenuItem mi_6 = new JRadioButtonMenuItem("菜鸟", true);
        JRadioButtonMenuItem mi_7 = new JRadioButtonMenuItem("入门", false);
        JRadioButtonMenuItem mi_8 = new JRadioButtonMenuItem("业余", false);
        JRadioButtonMenuItem mi_9 = new JRadioButtonMenuItem("专家", false);
        JRadioButtonMenuItem mi_10 = new JRadioButtonMenuItem("大师", false);
        JRadioButtonMenuItem mi_11 = new JRadioButtonMenuItem("无敌", false);

        ButtonGroup group = new ButtonGroup();
        group.add(mi_6);
        group.add(mi_7);
        group.add(mi_8);
        group.add(mi_9);
        group.add(mi_10);
        group.add(mi_11);

        final MenuItemActionListener menuItemAction = new MenuItemActionListener();
        create.addActionListener(menuItemAction);
        save.addActionListener(menuItemAction);
        mi_6.addActionListener(menuItemAction);
        mi_7.addActionListener(menuItemAction);
        mi_8.addActionListener(menuItemAction);
        mi_9.addActionListener(menuItemAction);
        mi_10.addActionListener(menuItemAction);
        mi_11.addActionListener(menuItemAction);

        create.setMnemonic(10);
        mi_6.setMnemonic(2);
        mi_7.setMnemonic(3);
        mi_8.setMnemonic(4);
        mi_9.setMnemonic(5);
        mi_10.setMnemonic(6);
        menu_file.setMnemonic('0');
        menu_file.add(create);
        menu_file.add(mi_6);
        menu_file.add(mi_7);
        menu_file.add(mi_8);
        menu_file.add(mi_9);
        menu_file.add(mi_10);
        menu_file.add(mi_11);
        menu_file.add(save);
        jmb.add(menu_file);
        //------------------------------------------------------
        JMenu menu_set = new JMenu("设置");
        JCheckBoxMenuItem redCmp = new JCheckBoxMenuItem("电脑红方", play != REDPLAYSIGN);
        JCheckBoxMenuItem blackCmp = new JCheckBoxMenuItem("电脑黑方", play != BLACKPLAYSIGN);

        JCheckBoxMenuItem isSoundBox = new JCheckBoxMenuItem("音效", isSound);


        ButtonGroup hashSizeGroup = new ButtonGroup();
        hashSizeGroup.add(hashSize2M);
        hashSizeGroup.add(hashSize32M);
        hashSizeGroup.add(hashSize64M);


        JCheckBoxMenuItem backstageThink = new JCheckBoxMenuItem("后台思考", isBackstageThink);

        redCmp.addActionListener(menuItemAction);
        blackCmp.addActionListener(menuItemAction);
        hashSize2M.addActionListener(menuItemAction);
        hashSize32M.addActionListener(menuItemAction);
        hashSize64M.addActionListener(menuItemAction);
        backstageThink.addActionListener(menuItemAction);
        isSoundBox.addActionListener(menuItemAction);

        menu_set.add(blackCmp);
        menu_set.add(redCmp);
        menu_set.add(hashSize2M);
        menu_set.add(hashSize32M);
        menu_set.add(hashSize64M);
        menu_set.add(backstageThink);
        menu_set.add(isSoundBox);
        jmb.add(menu_set);
        return jmb;
    }

    public void setBoardIconUnchecked(int site, int chess) {
//		site=boardMap[site];
//		initBoardRelation(site,chess);
        if (chess == NOTHING) {
            buttons[site].setIcon(null);
        } else {
            buttons[site].setIcon(getImageIcon(Constant.chessIcon[chess]));
        }
    }

    public void setBoardIconChecked(int site, int chess) {
        buttons[site].setIcon(getImageIcon(Constant.chessIcon[chess] + "S"));
    }

    public void setCheckedLOSS(int play) {
        buttons[chessParamCont.allChess[chessPlay[play]]].setIcon(getImageIcon(Constant.chessIcon[chessPlay[play]] + "M"));
    }

    public void move(MoveNode moveNode) {

        if (lastTimeCheckedSite != -1) {
            setBoardIconUnchecked(lastTimeCheckedSite, chessParamCont.board[lastTimeCheckedSite]);
        }
        setBoardIconUnchecked(moveNode.srcSite, NOTHING);
        setBoardIconChecked(moveNode.destSite, moveNode.srcChess);
        lastTimeCheckedSite = moveNode.destSite;
    }

    public void gameOverMsg(String msg) {
        if (JOptionPane.showConfirmDialog(this, msg + "是否继续？", "信息",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            new ChessBoardMain();
        } else {
            dispose();
        }
    }

    private ImageIcon getImageIcon(char chess) {

        String chessName = null;

        if ('a' <= chess && chess <= 'z') {
            chessName = "B" + String.valueOf(chess).toUpperCase();
        }

        if ('A' <= chess && chess <= 'Z') {
            chessName = "R" + String.valueOf(chess).toUpperCase();
        }

        String path = "/images/" + chessName + ".GIF";
        return new ImageIcon(getClass().getResource(path));
    }

    // TODO
    private ImageIcon getImageIcon(String chessName) {
        String path = "/images/" + chessName + ".GIF";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        return imageIcon;
    }

    private boolean checkGameOver() {
        boolean isGameOver = false;
        String msg = null;
        if (moveHistory == null || moveHistory.getMoveNode() == null) {
            msg = (play == BLACKPLAYSIGN ? "黑方" : "红方") + "被残忍的将死！";
            isGameOver = true;
            //自己帅被吃
        } else if (chessParamCont.allChess[chessPlay[BLACKPLAYSIGN]] == NOTHING || moveHistory.getMoveNode().destChess == chessPlay[BLACKPLAYSIGN]) {
            isGameOver = true;
            msg = "黑方被完虐！";
        } else if (chessParamCont.allChess[chessPlay[REDPLAYSIGN]] == NOTHING || moveHistory.getMoveNode().destChess == chessPlay[REDPLAYSIGN]) {
            msg = "红方被完虐！";
            isGameOver = true;
        } else if (moveHistory.getMoveNode().score == -LONGCHECKSCORE) {
            msg = (play == BLACKPLAYSIGN ? "黑方" : "红方") + "长将判负！";
            isGameOver = true;
        } else if (moveHistory.getMoveNode().score <= -(maxScore - 2)) {
            setCheckedLOSS(play);
            msg = (play == BLACKPLAYSIGN ? "黑方" : "红方") + "被残忍的将死！";
            isGameOver = true;
        } else if (moveHistory.getMoveNode().score >= (maxScore - 2)) {
            setCheckedLOSS(1 - play);
            msg = (play == BLACKPLAYSIGN ? "黑方" : "红方") + "赢得了最终的胜利！";
            isGameOver = true;
        } else if (chessParamCont.getAttackChessesNum(REDPLAYSIGN) == 0 && chessParamCont.getAttackChessesNum(BLACKPLAYSIGN) == 0) {
            msg = "双方都无攻击棋子此乃和棋！";
            isGameOver = true;
        } else if (turn_num >= 300) {
            msg = "大战300回合未分胜负啊！";
            isGameOver = true;
        }
        if (isGameOver) {
            launchSound(Constant.LOSS_SOUND);
            gameOverMsg(msg);
        } else {
            MoveNode moveNode = moveHistory.getMoveNode();
            if (cmp.checked(1 - play)) {//对手是否被将
                launchSound(Constant.CHECKED_SOUND);
            } else if (moveNode.destChess != NOTHING) {
                launchSound(Constant.CAPTURE_SOUND);
            } else {
                launchSound(Constant.MOVE_SOUND);
            }
        }
        return isGameOver;
    }

    private void opponentMove() {
        setHashTablesEnabled();
        //查看是否以胜利
        if (!checkGameOver()) {
            turn_num++;
            play = 1 - play; //交换双方
            //对手是否为电脑
            if (android[play]) {
                computeThinkStart();
            }
        }
    }

    private void computeThinkStart() {
        //设置后台思考
        if (isBackstageThink && (guessLink != null && moveHistory != null)) {
            //查看是否猜中
            if (guessLink.getMoveNode().equals(moveHistory.getMoveNode())) {
                new Thread() {
                    public void run() {
                        System.out.println("---->猜测命中！！");
                        try {
                            //加入时间控制
                            backstageAIThink.launchTimer();
                            backstageThinkThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            computeThink();
                        }
                        computeAIMoving(guessLink.getNextLink());
                    }
                }.start();
            } else {
                new Thread() {
                    public void run() {
                        System.out.println("--->未命中");
                        //如果没中进行运算
                        backstageAIThink.setStop();
                        try {
                            backstageThinkThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("--->重新思考");
                        computeThink();
                    }
                }.start();
            }
        } else {
            computeThink();
        }
    }

    private void computeThink() {
        new Thread() {
            public void run() {
                _AIThink.setLocalVariable(computerLevel, chessParamCont, moveHistory);
                _AIThink.launchTimer();
                _AIThink.run();
                computeAIMoving(moveHistory.getNextLink());
            }
        }.start();
    }

    private void computeAIMoving(NodeLink nodeLink) {
        moveHistory = nodeLink;
        // if(!checkGameOver()){
        if (nodeLink != null && nodeLink.getMoveNode() != null) {
            MoveNode moveNode = nodeLink.getMoveNode();
            showMoveNode(moveNode);
        }
        opponentMove();
        backstageThink();
        // }
    }

    private Thread backstageThinkThread = null;
    private NodeLink guessLink;

    //后台思考
    private void backstageThink() {
        if (!isBackstageThink) {
            return;
        }
        if (moveHistory.getNextLink() != null && moveHistory.getNextLink().getMoveNode() != null) {

            backstageThinkThread = new Thread() {
                public void run() {
                    //猜测的着法
                    guessLink = moveHistory.getNextLink();
                    backstageAIThink.setLocalVariable(computerLevel, chessParamCont, guessLink);
                    System.out.println("---->开始猜测(" + guessLink.getMoveNode() + ")");
                    backstageAIThink.guessRun(guessLink.getMoveNode());
                }
            };
            backstageThinkThread.start();
        }
    }

    private void showMoveNode(MoveNode moveNode) {
        if (moveNode != null) {
            move(moveNode);
            cmp.moveOperate(moveNode);
            transTable.synchroZobristBoardToStatic();
        }
    }

    private void setHashTablesEnabled() {
        hashSize2M.setEnabled(false);
        hashSize32M.setEnabled(false);
        hashSize64M.setEnabled(false);
    }

    public void launchSound(int type) {
        if (isSound) { //开启音效
            new SoundEffect(type).start();
        }
    }
}
