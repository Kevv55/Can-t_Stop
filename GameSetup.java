import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GameSetup extends JFrame implements ActionListener {
    public static JButton[][] gameBoardArray;
    private JMenuBar menubar;
    private JButton checker;
    private JPanel mainPanel;
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private boolean isGameStarted = false;

    public JMenuItem startNewGame, loadGame, saveGame, exitGame, rulesView;

    public GameSetup() {
        this.setLayout();
    }

    public void setLayout() {
        this.setTitle("Can't Stop");
        this.setSize(1200, 720);
        this.setGameDisplayInCenter();

        this.initializeMenuBar();

        getContentPane().add(this.getMainPanel(), BorderLayout.CENTER);

        this.disableUnusedButtons();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);

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

    protected JButton[][] getGameBoardArray() {

        return gameBoardArray;
    }

    public JPanel getMainPanel() {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(13, 11, 5, 5));
        mainPanel.setSize(600, 600);

        gameBoardArray = new JButton[13][11];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                gameBoardArray[i][j] = new buttonPanelGridLayout(i, j);
                gameBoardArray[i][j].setBackground(Color.WHITE);
                mainPanel.add(gameBoardArray[i][j]);

            }
        }

        return mainPanel;
    }

    private void disableUnusedButtons() {
        gameBoardArray[0][0].setVisible(false);
        gameBoardArray[0][1].setVisible(false);
        gameBoardArray[0][2].setVisible(false);
        gameBoardArray[0][3].setVisible(false);
        gameBoardArray[0][4].setVisible(false);
        gameBoardArray[0][6].setVisible(false);
        gameBoardArray[0][7].setVisible(false);
        gameBoardArray[0][8].setVisible(false);
        gameBoardArray[0][9].setVisible(false);
        gameBoardArray[0][10].setVisible(false);

        gameBoardArray[1][0].setVisible(false);
        gameBoardArray[1][1].setVisible(false);
        gameBoardArray[1][2].setVisible(false);
        gameBoardArray[1][3].setVisible(false);
        gameBoardArray[1][7].setVisible(false);
        gameBoardArray[1][8].setVisible(false);
        gameBoardArray[1][9].setVisible(false);
        gameBoardArray[1][10].setVisible(false);

        gameBoardArray[2][0].setVisible(false);
        gameBoardArray[2][1].setVisible(false);
        gameBoardArray[2][2].setVisible(false);
        gameBoardArray[2][8].setVisible(false);
        gameBoardArray[2][9].setVisible(false);
        gameBoardArray[2][10].setVisible(false);

        gameBoardArray[3][0].setVisible(false);
        gameBoardArray[3][1].setVisible(false);
        gameBoardArray[3][9].setVisible(false);
        gameBoardArray[3][10].setVisible(false);

        gameBoardArray[4][0].setVisible(false);
        gameBoardArray[4][10].setVisible(false);

        gameBoardArray[8][0].setVisible(false);
        gameBoardArray[8][10].setVisible(false);

        gameBoardArray[9][0].setVisible(false);
        gameBoardArray[9][1].setVisible(false);
        gameBoardArray[9][9].setVisible(false);
        gameBoardArray[9][10].setVisible(false);

        gameBoardArray[10][0].setVisible(false);
        gameBoardArray[10][1].setVisible(false);
        gameBoardArray[10][2].setVisible(false);
        gameBoardArray[10][8].setVisible(false);
        gameBoardArray[10][9].setVisible(false);
        gameBoardArray[10][10].setVisible(false);

        gameBoardArray[11][0].setVisible(false);
        gameBoardArray[11][1].setVisible(false);
        gameBoardArray[11][2].setVisible(false);
        gameBoardArray[11][3].setVisible(false);
        gameBoardArray[11][7].setVisible(false);
        gameBoardArray[11][8].setVisible(false);
        gameBoardArray[11][9].setVisible(false);
        gameBoardArray[11][10].setVisible(false);

        gameBoardArray[12][0].setVisible(false);
        gameBoardArray[12][1].setVisible(false);
        gameBoardArray[12][2].setVisible(false);
        gameBoardArray[12][3].setVisible(false);
        gameBoardArray[12][4].setVisible(false);
        gameBoardArray[12][6].setVisible(false);
        gameBoardArray[12][7].setVisible(false);
        gameBoardArray[12][8].setVisible(false);
        gameBoardArray[12][9].setVisible(false);
        gameBoardArray[12][10].setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

}