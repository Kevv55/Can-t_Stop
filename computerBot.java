import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class computerBot extends JFrame implements ActionListener {

    private JLabel mainLabel = new JLabel("Computer BOT Settings");
    private int numHumanPlayers;
    private JButton easy, hard;
    private String player1, player2, player3, player4;

    private int compDiffLevel;

    computerBot(int numHumanPlayers, String player1, String player2, String player3, String player4) {
        this.numHumanPlayers = numHumanPlayers;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.setLayout();

    }

    public void setLayout() {
        this.setSize(500, 500);
        this.setLayout(null);

        this.setGameDisplayInCenter();
        this.setTitle("Computer BOT Difficulty Level");

        getContentPane().add(this.mainLabel);
        getContentPane().add(activateEasyButton());
        getContentPane().add(activateHardButton());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public JButton activateEasyButton() {
        easy = new JButton("EASY");
        easy.addActionListener(this);
        easy.setBounds(50, 100, 150, 50);
        easy.setFocusable(false);
        return easy;

    }

    public JButton activateHardButton() {

        hard = new JButton("HARD");
        hard.setBounds(250, 100, 150, 50);
        hard.setFocusable(false);
        hard.addActionListener(this);
        return hard;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.easy) {
            this.compDiffLevel = 0;
            this.dispose();
            GameThemePallette easyModeColor = new GameThemePallette(numHumanPlayers, this.player1, this.player2,
                    this.player3, this.player4, this.compDiffLevel);
        }

        if (e.getSource() == this.hard) {
            this.compDiffLevel = 1;
            this.dispose();
            GameThemePallette hardModeColor = new GameThemePallette(numHumanPlayers, this.player1, this.player2,
                    this.player3, this.player4, this.compDiffLevel);
        }

    }

}
