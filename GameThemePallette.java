import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameThemePallette extends JFrame implements ActionListener {
    private JLabel mainLabel = new JLabel("Choose the color options");
    private String player1, player2, player3, player4;
    private int numHumanPlayers;
    private JButton regularMode, redGreenMode, blueYellowMode;
    private int normalModeActivated;
    private int compDiffLevel;

    GameThemePallette(int numHumanPlayers, String player1, String player2, String player3, String player4,
            int compDiffLevel) {
        this.numHumanPlayers = numHumanPlayers;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.compDiffLevel = compDiffLevel;
        this.setLayout();
    }

    private void setLayout() {
        this.setSize(800, 800);
        this.setLayout(null);
        this.setGameDisplayInCenter();
        this.setTitle("Choose Color Display Options");

        getContentPane().add(this.mainLabel);
        getContentPane().add(this.activateNormalColorModeBtn());
        getContentPane().add(this.activateRGColorModeBtn());
        getContentPane().add(this.activateBYColorModeBtn());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public JButton activateNormalColorModeBtn() {
        regularMode = new JButton("REGULAR MODE");
        regularMode.setBounds(50, 150, 200, 50);
        regularMode.setFocusable(false);
        regularMode.addActionListener(this);
        return regularMode;

    }

    public JButton activateRGColorModeBtn() {
        redGreenMode = new JButton("RED/GREEN BLIND MODE");
        redGreenMode.setBounds(300, 150, 200, 50);
        redGreenMode.setFocusable(false);
        redGreenMode.addActionListener(this);
        return redGreenMode;

    }

    public JButton activateBYColorModeBtn() {
        blueYellowMode = new JButton("BLUE/YELLOW BLIND MODE");
        blueYellowMode.setBounds(550, 150, 200, 50);
        blueYellowMode.setFocusable(false);
        blueYellowMode.addActionListener(this);
        return blueYellowMode;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regularMode) {
            normalModeActivated = 1;
            this.dispose();
            GameNormalMode game = new GameNormalMode(numHumanPlayers, player1, player2, player3, player4,
                    compDiffLevel, normalModeActivated);
        } else if (e.getSource() == redGreenMode) {
            GameRGMode game = new GameRGMode(numHumanPlayers, player1, player2, player3, player4,
                    compDiffLevel, normalModeActivated);

        } else if (e.getSource() == blueYellowMode) {
            GameBYMode game = new GameBYMode(numHumanPlayers, player1, player2, player3, player4,
                    compDiffLevel, normalModeActivated);
        }
    }

}
