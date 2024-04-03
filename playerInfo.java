import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class playerInfo extends JFrame implements ActionListener {
    private JFrame playerInfoFrame;
    private JLabel playerInfoLabel;

    private int numPlayers;
    private int totalNumPlayers;
    private int numHumanPlayers;
    private int numComputerPlayers;
    private JButton player1, player2, player3, player4;

    public playerInfo(int totalNumPlayers) {
        this.totalNumPlayers = totalNumPlayers;
    }

    public void setLayout() {
        this.setSize(400, 300);
        this.setLayout(null);
        this.setGameDisplayInCenter();

        playerInfoLabel = new JLabel("Select Number of Human Players:-");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("NEW GAME");

        getContentPane().add(this.designPlayerInfoLabel());

        if (totalNumPlayers == 1) {
            getContentPane().add(this.player1BtnDesign());

        } else if (totalNumPlayers == 2) {
            getContentPane().add(this.player1BtnDesign());
            getContentPane().add(this.player2BtnDesign());

        } else if (totalNumPlayers == 3) {
            getContentPane().add(this.player1BtnDesign());
            getContentPane().add(this.player2BtnDesign());
            getContentPane().add(this.player3BtnDesign());

        } else if (totalNumPlayers == 4) {
            getContentPane().add(this.player1BtnDesign());
            getContentPane().add(this.player2BtnDesign());
            getContentPane().add(this.player3BtnDesign());
            getContentPane().add(this.player4BtnDesign());
        }

        this.setResizable(false);
        this.setVisible(true);
    }

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public JButton player1BtnDesign() {
        player1 = new JButton("1");
        player1.setBounds(80, 100, 50, 50);
        player1.setFocusable(false);
        player1.addActionListener(this);
        return player1;
    }

    public JButton player2BtnDesign() {
        player2 = new JButton("2");
        player2.setBounds(150, 100, 50, 50);
        player2.setFocusable(false);
        player2.addActionListener(this);
        return player2;
    }

    public JButton player3BtnDesign() {
        player3 = new JButton("3");
        player3.setBounds(220, 100, 50, 50);
        player3.setFocusable(false);
        player3.addActionListener(this);
        return player3;
    }

    public JButton player4BtnDesign() {
        player4 = new JButton("4");
        player4.setBounds(290, 100, 50, 50);
        player4.setFocusable(false);
        player4.addActionListener(this);
        return player4;
    }

    public JLabel designPlayerInfoLabel() {
        playerInfoLabel = new JLabel("Select Number of Human Players:-", SwingConstants.CENTER);
        playerInfoLabel.setBounds(50, 60, 300, 50);
        return playerInfoLabel;
    }

    public int getNumHumanPlayers() {
        return numHumanPlayers;
    }

    public int getNumComputerPlayers() {
        return 4 - numHumanPlayers;
    }

    public int getTotalNumPlayers() {
        return totalNumPlayers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.player1) {
            this.numHumanPlayers = 1;
            this.dispose();
            playersNames playersNames = new playersNames(this.getNumHumanPlayers(), this.getTotalNumPlayers());
        } else if (e.getSource() == player2) {
            this.numHumanPlayers = 2;
            this.dispose();
            playersNames playersNames = new playersNames(this.getNumHumanPlayers(), this.getTotalNumPlayers());
        } else if (e.getSource() == player3) {
            this.numHumanPlayers = 3;
            this.dispose();
            playersNames playersNames = new playersNames(this.getNumHumanPlayers(), this.getTotalNumPlayers());
        } else if (e.getSource() == player4) {
            this.numHumanPlayers = 4;
            this.dispose();
            playersNames playersNames = new playersNames(this.getNumHumanPlayers(), this.getTotalNumPlayers());
        }
    }

}
