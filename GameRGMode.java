import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameRGMode extends GameSetup implements ActionListener {

    private JLabel infoLabel, diceLabel;
    private int numHumanPlayers;
    private String player1, player2, player3, player4;
    private int compDiffLevel;
    private int normalModeActivated;

    private JPanel infoPanel, topPanel, player1Panel, player2Panel, player3Panel, player4Panel, eastPanel, dicePanel;
    private JLabel player1Label, player2Label, player3Label, player4Label;

    private JButton redChecker, greenChecker, blueChecker, yellowChecker, whiteChecker, rollDiceBtn;
    private JButton dice1, dice2, dice3, dice4;
    private String checkerColor;

    GameRGMode(int numHumanPlayers, String player1, String player2, String player3, String player4,
            int compDiffLevel, int normalModeActivated) {
        this.numHumanPlayers = numHumanPlayers;

        if (player1 != null && player1.isEmpty() == false) {
            this.player1 = player1.toUpperCase();
        }

        else if (player1 == null || player1.isEmpty()) {
            this.player1 = "PLAYER 1";
        }

        if (player2 != null && player2.isEmpty() == false) {
            this.player2 = player2.toUpperCase();
        }

        else if (player2 == null || player2.isEmpty()) {
            this.player2 = "PLAYER 2";
        }

        if (player3 != null && player3.isEmpty() == false) {
            this.player3 = player3.toUpperCase();
        }

        else if (player3 == null || player3.isEmpty()) {
            this.player3 = "PLAYER 3";
        }
        if (player4 != null && player4.isEmpty() == false) {
            this.player4 = player4.toUpperCase();
        }

        else if (player4 == null || player4.isEmpty()) {
            this.player4 = "PLAYER 4";
        }

        this.compDiffLevel = compDiffLevel;
        this.normalModeActivated = normalModeActivated;
        this.initializeMenuBar();
        getContentPane().add(this.getTopPanel(), BorderLayout.NORTH);
        getContentPane().add(this.getEastPanel(), BorderLayout.EAST);

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
        player1Panel.setBorder(BorderFactory.createLineBorder(new Color(255, 192, 203), 4));
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
        player2Panel.setBorder(BorderFactory.createLineBorder(new Color(165, 42, 42), 4));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollDiceBtn) {

            Random rand = new Random();
            int dice1Num = rand.nextInt(6) + 1;
            int dice2Num = rand.nextInt(6) + 1;
            int dice3Num = rand.nextInt(6) + 1;
            int dice4Num = rand.nextInt(6) + 1;

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

    }

}
