import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class totalPlayers extends JFrame implements ActionListener {
    private JFrame totalPlayersFrame;
    private JLabel totalPlayersLabel;

    private int totalNumPlayers;
    private int numPlayers;
    private int numHumanPlayers;
    private int numComputerPlayers;
    private JButton player1, player2, player3, player4;

    public totalPlayers() {

    }

    public void setLayout() {
        this.setSize(500, 400);
        this.setLayout(null);
        this.setGameDisplayInCenter();

        totalPlayersLabel = new JLabel("Total Players:-");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("NEW GAME");

        getContentPane().add(this.designTotalPlayersLabel());
        getContentPane().add(this.player2BtnDesign());
        getContentPane().add(this.player3BtnDesign());
        getContentPane().add(this.player4BtnDesign());

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
        player1.addActionListener(this);
        player1.setFocusable(false);
        return player1;
    }

    public JButton player2BtnDesign() {
        player2 = new JButton("2");
        player2.setBounds(150, 100, 50, 50);
        player2.addActionListener(this);
        player2.setFocusable(false);
        return player2;
    }

    public JButton player3BtnDesign() {
        player3 = new JButton("3");
        player3.setBounds(220, 100, 50, 50);
        player3.addActionListener(this);
        player3.setFocusable(false);
        return player3;
    }

    public JButton player4BtnDesign() {
        player4 = new JButton("4");
        player4.setBounds(290, 100, 50, 50);
        player4.addActionListener(this);
        player4.setFocusable(false);
        return player4;
    }

    public JLabel designTotalPlayersLabel() {
        totalPlayersLabel.setBounds(80, 50, 250, 50);
        totalPlayersLabel.setFont(new Font("Arial", Font.BOLD, 20));
        return totalPlayersLabel;
    }

    public int getNumHumanPlayers() {
        return numHumanPlayers;
    }

    public int getNumComputerPlayers() {
        numComputerPlayers = 4 - numHumanPlayers;
        return numComputerPlayers;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getTotalNumPlayers() {
        return totalNumPlayers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.player1) {
            this.totalNumPlayers = 1;

            this.dispose();
            playerInfo playerInfo = new playerInfo(this.getTotalNumPlayers());
            playerInfo.setLayout();

        } else if (e.getSource() == this.player2) {
            this.totalNumPlayers = 2;

            this.dispose();
            playerInfo playerInfo = new playerInfo(this.getTotalNumPlayers());
            playerInfo.setLayout();
        } else if (e.getSource() == this.player3) {
            this.totalNumPlayers = 3;
            this.dispose();
            playerInfo playerInfo = new playerInfo(this.getTotalNumPlayers());
            playerInfo.setLayout();
        } else if (e.getSource() == this.player4) {
            this.totalNumPlayers = 4;
            this.dispose();
            playerInfo playerInfo = new playerInfo(this.getTotalNumPlayers());
            playerInfo.setLayout();
        }
    }

}
