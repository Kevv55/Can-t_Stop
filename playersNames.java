import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class playersNames extends JFrame implements ActionListener {

    private int numHumanPlayers;
    private int numComputerPlayers;
    private int totalNumPlayers;
    private JButton player1selected, player2selected, player3selected, player4selected;
    private JLabel player1Label, player2Label, player3Label, player4Label, titleLabel;
    private JTextField player1Name, player2Name, player3Name, player4Name;

    public playersNames(int numHumanPlayers, int totalNumPlayers) {
        this.numHumanPlayers = numHumanPlayers;
        this.totalNumPlayers = totalNumPlayers;

        this.setLayout(null);
        this.setTitle("Player Names");

        if (numHumanPlayers == 1) {
            this.addPlayer1Name();
        } else if (numHumanPlayers == 2) {
            this.addPlayer2Name();
        } else if (numHumanPlayers == 3) {
            this.addPlayer3Name();
        } else if (numHumanPlayers == 4) {
            this.addPlayer4Name();
        }

        this.setGameDisplayInCenter();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    public int getTotalNumPlayers() {
        return totalNumPlayers;
    }

    public int getTotalHumanPlayers() {
        return numHumanPlayers;
    }

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    private JLabel designTitleLabel() {
        titleLabel = new JLabel("Please Enter Player Names");
        titleLabel.setBounds(50, 50, 300, 50);
        return titleLabel;
    }

    private JLabel designPlayer1Label() {
        player1Label = new JLabel("Player 1 Name:");
        player1Label.setBounds(50, 100, 150, 50);
        return player1Label;
    }

    private JLabel designPlayer2Label() {
        player2Label = new JLabel("Player 2 Name:");
        player2Label.setBounds(50, 150, 150, 50);
        return player2Label;
    }

    private JLabel designPlayer3Label() {
        player3Label = new JLabel("Player 3 Name:");
        player3Label.setBounds(50, 200, 150, 50);
        return player3Label;
    }

    private JLabel designPlayer4Label() {
        player4Label = new JLabel("Player 4 Name:");
        player4Label.setBounds(50, 250, 150, 50);
        return player4Label;
    }

    private JTextField fetchPlayer1Name() {
        player1Name = new JTextField();
        player1Name.setBounds(300, 100, 100, 50);
        return player1Name;
    }

    private JTextField fetchPlayer2Name() {
        player2Name = new JTextField();
        player2Name.setBounds(300, 150, 100, 50);
        return player2Name;
    }

    private JTextField fetchPlayer3Name() {
        player3Name = new JTextField();
        player3Name.setBounds(300, 200, 100, 50);
        return player3Name;
    }

    private JTextField fetchPlayer4Name() {
        player4Name = new JTextField();
        player4Name.setBounds(300, 250, 100, 50);
        return player4Name;
    }

    public JButton player1BtnDesign() {
        player1selected = new JButton("SUBMIT");
        player1selected.setBounds(80, 400, 150, 50);
        player1selected.setFocusable(false);
        player1selected.addActionListener(this);

        return player1selected;
    }

    public JButton player2BtnDesign() {
        player2selected = new JButton("SUBMIT");
        player2selected.addActionListener(this);
        player2selected.setBounds(80, 400, 150, 50);
        player2selected.setFocusable(false);
        return player2selected;
    }

    public JButton player3BtnDesign() {
        player3selected = new JButton("SUBMIT");
        player3selected.addActionListener(this);
        player3selected.setBounds(80, 400, 150, 50);
        player3selected.setFocusable(false);
        return player3selected;
    }

    public JButton player4BtnDesign() {
        player4selected = new JButton("SUBMIT");
        player4selected.setBounds(80, 400, 150, 50);
        player4selected.addActionListener(this);
        player4selected.setFocusable(false);
        return player4selected;
    }

    private void addPlayer1Name() {
        this.setSize(600, 600);
        this.setGameDisplayInCenter();

        getContentPane().add(this.designTitleLabel());
        getContentPane().add(this.designPlayer1Label());
        getContentPane().add(this.fetchPlayer1Name());
        getContentPane().add(player1Label);
        getContentPane().add(this.player1BtnDesign());

    }

    private void addPlayer2Name() {
        this.setSize(600, 600);
        this.setGameDisplayInCenter();

        getContentPane().add(this.designTitleLabel());
        getContentPane().add(this.designPlayer1Label());
        getContentPane().add(this.designPlayer2Label());
        getContentPane().add(this.fetchPlayer1Name());
        getContentPane().add(this.fetchPlayer2Name());
        getContentPane().add(player1Label);
        getContentPane().add(player2Label);
        getContentPane().add(this.player2BtnDesign());

    }

    private void addPlayer3Name() {
        this.setSize(600, 600);
        this.setGameDisplayInCenter();

        getContentPane().add(this.designTitleLabel());
        getContentPane().add(this.designPlayer1Label());
        getContentPane().add(this.designPlayer2Label());
        getContentPane().add(this.designPlayer3Label());
        getContentPane().add(this.fetchPlayer1Name());
        getContentPane().add(this.fetchPlayer2Name());
        getContentPane().add(this.fetchPlayer3Name());
        getContentPane().add(player1Label);
        getContentPane().add(player2Label);
        getContentPane().add(player3Label);
        getContentPane().add(this.player3BtnDesign());

    }

    private void addPlayer4Name() {
        this.setSize(600, 600);
        this.setGameDisplayInCenter();

        getContentPane().add(this.designTitleLabel());
        getContentPane().add(this.designPlayer1Label());
        getContentPane().add(this.designPlayer2Label());
        getContentPane().add(this.designPlayer3Label());
        getContentPane().add(this.designPlayer4Label());
        getContentPane().add(this.fetchPlayer1Name());
        getContentPane().add(this.fetchPlayer2Name());
        getContentPane().add(this.fetchPlayer3Name());
        getContentPane().add(this.fetchPlayer4Name());
        getContentPane().add(player1Label);
        getContentPane().add(player2Label);
        getContentPane().add(player3Label);
        getContentPane().add(player4Label);
        getContentPane().add(this.player4BtnDesign());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == player1selected) {
            if (player1Name.getText().isEmpty() != true) {
                this.dispose();

                if (this.getTotalHumanPlayers() == this.getTotalNumPlayers()) {
                    GameThemePallette easyModeColor = new GameThemePallette(this.getTotalHumanPlayers(),
                            player1Name.getText(), null,
                            null, null, 0);

                } else {

                    computerBot ComputerBot = new computerBot(this.numHumanPlayers, player1Name.getText(), null, null,
                            null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please check your name fields", "Incorrect Names",
                        JOptionPane.PLAIN_MESSAGE);
            }

        }

        if (e.getSource() == player2selected) {
            if (player2Name.getText().isEmpty() != true && player1Name.getText().isEmpty() != true) {
                this.dispose();

                if (this.getTotalHumanPlayers() == this.getTotalNumPlayers()) {
                    GameThemePallette easyModeColor = new GameThemePallette(this.getTotalHumanPlayers(),
                            player1Name.getText(), player2Name.getText(),
                            null, null, 0);

                } else {
                    computerBot ComputerBot = new computerBot(this.numHumanPlayers, player1Name.getText(),
                            player2Name.getText(), null, null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please check your name fields", "Incorrect Names",
                        JOptionPane.PLAIN_MESSAGE);
            }

        }

        if (e.getSource() == player3selected) {
            if (player3Name.getText().isEmpty() != true && player2Name.getText().isEmpty() != true
                    && player1Name.getText().isEmpty() != true) {
                this.dispose();

                if (this.getTotalHumanPlayers() == this.getTotalNumPlayers()) {
                    GameThemePallette easyModeColor = new GameThemePallette(this.getTotalHumanPlayers(),
                            player1Name.getText(), this.player2Name.getText(),
                            player3Name.getText(), null, 0);

                } else {
                    computerBot ComputerBot = new computerBot(this.numHumanPlayers, player1Name.getText(),
                            player2Name.getText(), player3Name.getText(), null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please check your name fields", "Incorrect Names",
                        JOptionPane.PLAIN_MESSAGE);
            }

        }

        if (e.getSource() == player4selected) {
            if (player4Name.getText().isEmpty() != true && player3Name.getText().isEmpty() != true
                    && player2Name.getText().isEmpty() != true && player1Name.getText().isEmpty() != true) {
                int compDiffLevel = 0;

                if (this.getTotalHumanPlayers() == this.getTotalNumPlayers()) {
                    GameThemePallette easyModeColor = new GameThemePallette(this.getTotalHumanPlayers(),
                            player1Name.getText(), player2Name.getText(),
                            player3Name.getText(), player4Name.getText(), 0);

                }

                else {
                    GameThemePallette newGamePallete = new GameThemePallette(this.numHumanPlayers,
                            player1Name.getText(),
                            player2Name.getText(), player3Name.getText(), player4Name.getText(), compDiffLevel);
                }
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Please check your name fields", "Incorrect Names",
                        JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

}
