import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class startMenu extends JFrame implements ActionListener {

    private JButton newGameBtn, loadGameBtn, rulesBtn, exitBtn;
    private JLabel titleLabel;

    public startMenu() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        newGameBtn = new JButton("Start New Game");
        loadGameBtn = new JButton("Load Game");
        rulesBtn = new JButton("Rules");
        exitBtn = new JButton("Exit");

        newGameBtn.addActionListener(this);
        loadGameBtn.addActionListener(this);
        rulesBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        titleLabel = new JLabel("Welcome to Can't Stop", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // add margin

        buttonPanel.add(newGameBtn);
        buttonPanel.add(loadGameBtn);
        buttonPanel.add(rulesBtn);
        buttonPanel.add(exitBtn);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitBtn) {
            System.exit(0);
        } else if (e.getSource() == newGameBtn) {
            this.dispose();

            totalPlayers totalPlayers = new totalPlayers();
            totalPlayers.setLayout();

        } else if (e.getSource() == rulesBtn) {
            try {
                Desktop.getDesktop().open(new java.io.File("Can't Stop Rules.pdf"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

}
