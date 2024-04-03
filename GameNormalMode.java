import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameNormalMode extends GameSetup implements ActionListener {

    private JLabel infoLabel, diceLabel, dicecombination1Label, dicecombination2Label, dicecombination3Label;
    private int numHumanPlayers;
    private String player1, player2, player3, player4;
    private int compDiffLevel;
    private int normalModeActivated;

    private JPanel infoPanel, topPanel, player1Panel, player2Panel, player3Panel, player4Panel, eastPanel, dicePanel;
    private JLabel player1Label, player2Label, player3Label, player4Label, turnLabel;

    private JButton rollDiceBtn, botTurnButton, stopTurnButton;
    private JButton dice1, dice2, dice3, dice4;
    private int currentPlayer = 1;
    private int dice1Num, dice2Num, dice3Num, dice4Num;
    private int[] diceValues = { dice1Num, dice2Num, dice3Num, dice4Num };

    private boolean player2Bot, player3Bot, player4Bot;

    private JButton selectedBtn;
    private int selectedRow, selectedCol;
    private int whiteCheckerCount = 0;

    private ArrayList<JButton[][]> wChecker;
    private int movesP1, movesP2, movesP3, movesP4;

    GameNormalMode(int numHumanPlayers, String player1, String player2, String player3, String player4,
            int compDiffLevel, int normalModeActivated) {
        this.numHumanPlayers = numHumanPlayers;

        if (player1 != null && player1.isEmpty() == false) {
            this.player1 = player1.toUpperCase();
        }

        else if (player1 == null || player1.isEmpty()) {
            this.player1 = "PLAYER 1: BOT";
        }

        if (player2 != null && player2.isEmpty() == false) {
            this.player2 = player2.toUpperCase();
        }

        else if (player2 == null || player2.isEmpty()) {
            this.player2 = "PLAYER 2: BOT";
        }

        if (player3 != null && player3.isEmpty() == false) {
            this.player3 = player3.toUpperCase();
        }

        else if (player3 == null || player3.isEmpty()) {
            this.player3 = "PLAYER 3: BOT";
        }
        if (player4 != null && player4.isEmpty() == false) {
            this.player4 = player4.toUpperCase();
        }

        else if (player4 == null || player4.isEmpty()) {
            this.player4 = "PLAYER 4: BOT";
        }

        this.initializeMenuBar();
        this.setBotPlayer();

        this.compDiffLevel = compDiffLevel;
        this.normalModeActivated = normalModeActivated;
        this.setGameBoardNumbers();
        getContentPane().add(this.getTopPanel(), BorderLayout.NORTH);
        getContentPane().add(this.getEastPanel(), BorderLayout.EAST);
        getContentPane().add(this.getBottomPanel(), BorderLayout.SOUTH);
        this.updateBtnVisibility();

    }

    public void initializeMenuBar() {
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

        startNewGame = new JMenuItem("Start New Game");
        loadGame = new JMenuItem("Load Game");
        saveGame = new JMenuItem("Save Game");
        rulesView = new JMenuItem("Rules");
        exitGame = new JMenuItem("Exit Game");

        startNewGame.addActionListener(this);
        loadGame.addActionListener(this);
        saveGame.addActionListener(this);
        rulesView.addActionListener(this);
        exitGame.addActionListener(this);

        gameMenuBar.add(menu);
        menu.add(startNewGame);
        menu.add(loadGame);
        menu.add(saveGame);
        menu.add(rulesView);
        menu.add(exitGame);

        this.setJMenuBar(gameMenuBar);
    }

    public void setGameBoardNumbers() {
        super.gameBoardArray[5][0].setText("2");
        super.gameBoardArray[4][1].setText("3");
        super.gameBoardArray[3][2].setText("4");
        super.gameBoardArray[2][3].setText("5");
        super.gameBoardArray[1][4].setText("6");
        super.gameBoardArray[0][5].setText("7");
        super.gameBoardArray[1][6].setText("8");
        super.gameBoardArray[2][7].setText("9");
        super.gameBoardArray[3][8].setText("10");
        super.gameBoardArray[4][9].setText("11");
        super.gameBoardArray[5][10].setText("12");

        for (int i = 0; i < super.gameBoardArray.length; i++) {
            for (int j = 0; j < super.gameBoardArray[i].length; j++) {
                // Add an action listener to the button
                super.gameBoardArray[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Invoke the makeMoveClickBtn function
                        selectedBtn = (JButton) e.getSource();
                        makeMoveClickBtn();
                    }
                });
            }
        }

    }

    private void setBotPlayer() {
        // Conditional block for one Human player
        if (this.numHumanPlayers == 1) {
            this.player2Bot = true;
            this.player3Bot = true;
            this.player4Bot = true;
        }
        // Conditional block for two Human player
        else if (this.numHumanPlayers == 2) {
            this.player3Bot = true;
            this.player4Bot = true;
        }
        // Conditional block for Three Human player
        else if (this.numHumanPlayers == 3) {
            this.player4Bot = true;
        }
        // Conditional block for Four Human player
        else {
            this.player2Bot = false;
            this.player3Bot = false;
            this.player4Bot = false;
        }
    }

    private JPanel getTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        topPanel.add(this.getPlayer1Panel());
        topPanel.add(this.getPlayer2Panel());
        topPanel.add(this.getRollDiceBtn());
        topPanel.add(this.getPlayer3Panel());
        topPanel.add(this.getPlayer4Panel());

        return topPanel;
    }

    private JPanel getEastPanel() {
        eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(this.getDicePanel(), BorderLayout.SOUTH);

        return eastPanel;
    }

    private JPanel getBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        turnLabel = new JLabel("Current Turn: Player 1");
        bottomPanel.add(turnLabel);

        botTurnButton = new JButton("Bot Turn");
        botTurnButton.addActionListener(this);
        bottomPanel.add(botTurnButton);

        stopTurnButton = new JButton("Finish Turn");
        stopTurnButton.addActionListener(this);
        bottomPanel.add(stopTurnButton);

        currentPlayer = 1;

        return bottomPanel;
    }

    private JButton getRollDiceBtn() {
        rollDiceBtn = new JButton("ROLL DICE");
        rollDiceBtn.setFocusable(false);
        rollDiceBtn.addActionListener(this);
        return rollDiceBtn;

    }

    private JPanel getPlayer1Panel() {
        player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));

        player1Panel.setPreferredSize(new Dimension(150, 50));
        player1Label = new JLabel();
        player1Label.setText(String.valueOf(this.player1));
        player1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        player1Label.setVisible(true);

        player1Panel.add(player1Label);
        player1Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        return player1Panel;
    }

    private JPanel getPlayer2Panel() {
        player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));

        player2Panel.setPreferredSize(new Dimension(150, 50));
        player2Label = new JLabel();
        player2Label.setText(String.valueOf(this.player2));
        player2Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        player2Panel.add(player2Label);
        player2Panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        return player2Panel;
    }

    private JPanel getPlayer3Panel() {
        player3Panel = new JPanel();
        player3Panel.setLayout(new BoxLayout(player3Panel, BoxLayout.Y_AXIS));

        player3Panel.setPreferredSize(new Dimension(150, 50));
        player3Label = new JLabel();
        player3Label.setText(String.valueOf(this.player3));
        player3Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        player3Panel.add(player3Label);
        player3Panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        return player3Panel;
    }

    private JPanel getPlayer4Panel() {
        player4Panel = new JPanel();
        player4Panel.setLayout(new BoxLayout(player4Panel, BoxLayout.Y_AXIS));

        player4Panel.setPreferredSize(new Dimension(150, 50));
        player4Label = new JLabel();
        player4Label.setText(String.valueOf(this.player4));
        player4Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        player4Panel.add(player4Label);
        player4Panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
        return player4Panel;
    }

    private JPanel getDicePanel() {
        JPanel dicePanel = new JPanel();

        dicePanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Create the dice buttons and add an empty border to create space
        dice1 = new JButton();
        dice1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dice2 = new JButton();
        dice2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dice3 = new JButton();
        dice3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dice4 = new JButton();
        dice4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dice1.setPreferredSize(new Dimension(100, 100));
        dice2.setPreferredSize(new Dimension(100, 100));
        dice3.setPreferredSize(new Dimension(100, 100));
        dice4.setPreferredSize(new Dimension(100, 100));

        dice1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        dice2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        dice3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        dice4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        dicePanel.add(dice1);
        dicePanel.add(dice2);
        dicePanel.add(dice3);
        dicePanel.add(dice4);

        dicePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 50));

        return dicePanel;
    }

    private void updateBtnVisibility() {

        if (currentPlayer == 2 && player2Bot || currentPlayer == 3 && player3Bot || currentPlayer == 4 && player4Bot) {
            botTurnButton.setVisible(true);
            rollDiceBtn.setEnabled(false);
        } else {
            botTurnButton.setVisible(false);
            rollDiceBtn.setEnabled(true);
        }
    }

    private int getRowOfButton(JButton button) {
        for (int row = 0; row < super.gameBoardArray.length; row++) {
            for (int col = 0; col < super.gameBoardArray[row].length; col++) {
                if (super.gameBoardArray[row][col] == button) {
                    return row;
                }
            }
        }
        return -1;
    }

    private int getColOfButton(JButton button) {
        for (int row = 0; row < super.gameBoardArray.length; row++) {
            for (int col = 0; col < super.gameBoardArray[col].length; col++) {
                if (super.gameBoardArray[row][col] == button) {
                    return col;
                }
            }
        }
        return -1;
    }

    private boolean isDiceCombinationMatch(int row, int col) {
        for (int i = 0; i < diceValues.length; i++) {
            for (int j = i + 1; j < diceValues.length; j++) {
                int sum = diceValues[i] + diceValues[j];
                if (sum == col + 2) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean runnerClicked(int row, int col) {
        if (gameBoardArray[row][col].getText().equals("W")) {
            return true;
        }
        return false;
    }

    private void moveRunner(int row, int col) {
        if (whiteCheckerCount < 3) {
            placeChecker(row, col);
        } else if (runnerClicked(row, col)) {
            super.gameBoardArray[row][col].setText("");
            super.gameBoardArray[row - 1][col].setText("W");
            updateMoves(currentPlayer);
        } else {
            JOptionPane.showMessageDialog(null, "Click on the current runner to move");
        }

    }

    private void placeChecker(int row, int col) {
        boolean c = checker(row, col);
        if (c) {
            JOptionPane.showMessageDialog(null, "There is already a runner in this column");
            return;
        } else if (!setBegin(row, col) && !beginCoor(row, col)) {
            JOptionPane.showMessageDialog(null, "You must place the runner at the begining first");
            return;
        } else if (whiteCheckerCount != 3) {
            gameBoardArray[row][col].setText("W");
            whiteCheckerCount++;
            updateMoves(currentPlayer);
        } else {
            JOptionPane.showMessageDialog(null, "You have used all white checkers");
        }
    }

    // Checks if there is another runner in the column
    private boolean checker(int row, int col) {
        for (int i = 1; i < 13; i++) {
            if (gameBoardArray[i][col].getText().equals("W")) {
                return true;
            }
        }
        return false;
    }

    // to check if there is a runner in the beginning
    private boolean setBegin(int row, int col) {
        if (col == 0) {
            return gameBoardArray[7][0].getText().equals("W");
        } else if (col == 1) {
            return gameBoardArray[8][1].getText().equals("W");
        } else if (col == 2) {
            return gameBoardArray[9][2].getText().equals("W");
        } else if (col == 3) {
            return gameBoardArray[10][3].getText().equals("W");
        } else if (col == 4) {
            return gameBoardArray[11][4].getText().equals("W");
        } else if (col == 5) {
            return gameBoardArray[12][5].getText().equals("W");
        } else if (col == 6) {
            return gameBoardArray[11][6].getText().equals("W");
        } else if (col == 7) {
            return gameBoardArray[10][7].getText().equals("W");
        } else if (col == 8) {
            return gameBoardArray[9][8].getText().equals("W");
        } else if (col == 9) {
            return gameBoardArray[8][9].getText().equals("W");
        } else {
            return gameBoardArray[7][10].getText().equals("W");
        }
    }

    // to check if the coordinates clicked are in the beggining
    private boolean beginCoor(int row, int col) {
        if (row == 7 && col == 0) {
            return true;
        } else if (row == 8 && col == 1) {
            return true;
        } else if (row == 9 && col == 2) {
            return true;
        } else if (row == 10 && col == 3) {
            return true;
        } else if (row == 11 && col == 4) {
            return true;
        } else if (row == 12 && col == 5) {
            return true;
        } else if (row == 11 && col == 6) {
            return true;
        } else if (row == 10 && col == 7) {
            return true;
        } else if (row == 9 && col == 8) {
            return true;
        } else if (row == 8 && col == 9) {
            return true;
        } else if (row == 7 && col == 10) {
            return true;
        } else {
            return false;
        }
    }

    // used to check if a row is empty
    private boolean isEmpty(int row, int col) {
        for (int i = 0; i < 13; i++) {
            if (gameBoardArray[i][col].getText().equals("W")) {
                return false;
            }
        }
        return true;
    }

    private void colorWhiteChecker() {
        for (int row = 0; row < super.gameBoardArray.length; row++) {
            for (int col = 0; col < super.gameBoardArray[row].length; col++) {
                JButton button = super.gameBoardArray[row][col];
                if (button.getText().equals("W")) {
                    if (currentPlayer == 1)
                        button.setBackground(Color.RED);
                    else if (currentPlayer == 2)
                        button.setBackground(Color.GREEN);
                    else if (currentPlayer == 3)
                        button.setBackground(Color.BLUE);
                    else if (currentPlayer == 4)
                        button.setBackground(Color.YELLOW);

                    button.setText("");
                }
            }
        }
        whiteCheckerCount = 0;

    }

    private void makeMoveClickBtn() {
        selectedRow = this.getRowOfButton(selectedBtn);
        selectedCol = this.getColOfButton(selectedBtn);

        if (isDiceCombinationMatch(selectedRow, selectedCol)) {
            if (getMoves(currentPlayer) == 0) {
                placeChecker(selectedRow, selectedCol);
            } else if (getMoves(currentPlayer) > 0) {
                moveRunner(selectedRow, selectedCol);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid move");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollDiceBtn || e.getSource() == botTurnButton) {

            Random rand = new Random();
            dice1Num = rand.nextInt(6) + 1;
            dice2Num = rand.nextInt(6) + 1;
            dice3Num = rand.nextInt(6) + 1;
            dice4Num = rand.nextInt(6) + 1;

            diceValues = new int[] { dice1Num, dice2Num, dice3Num, dice4Num };

            dice1.setText(String.valueOf(dice1Num));
            dice2.setText(String.valueOf(dice2Num));
            dice3.setText(String.valueOf(dice3Num));
            dice4.setText(String.valueOf(dice4Num));

        }

        if (e.getSource() == exitGame) {
            System.exit(0);
        } else if (e.getSource() == startNewGame) {

            totalPlayers totalPlayers = new totalPlayers();
            totalPlayers.setLayout();

        } else if (e.getSource() == rulesView) {
            try {
                Desktop.getDesktop().open(new java.io.File("Can't Stop Rules.pdf"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == saveGame) {
            SaveGameSlots saveGame = new SaveGameSlots();
        }

        if (e.getSource() == stopTurnButton) {
            this.colorWhiteChecker();
            currentPlayer++;
            if (currentPlayer > 4) {
                currentPlayer = 1;
            }

            turnLabel.setText("Current Turn: Player: " + currentPlayer);
            this.updateBtnVisibility();

        }

    }

    public void updateMoves(int currentPlayer) {
        if (currentPlayer == 1) {
            movesP1++;
        } else if (currentPlayer == 2) {
            movesP2++;
        } else if (currentPlayer == 3) {
            movesP3++;
        } else if (currentPlayer == 4) {
            movesP4++;
        }
    }

    public int getMoves(int currentPlayer) {
        if (currentPlayer == 1) {
            return movesP1;
        } else if (currentPlayer == 2) {
            return movesP2;
        } else if (currentPlayer == 3) {
            return movesP3;
        } else {
            return movesP4;
        }
    }
}
