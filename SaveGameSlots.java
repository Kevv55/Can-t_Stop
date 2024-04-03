import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveGameSlots extends JFrame implements ActionListener {

    private JLabel infoLabel = new JLabel("Select the slot below to save:");
    private JButton slot1, slot2, slot3, slot4, slot5, slot6;

    SaveGameSlots() {
        this.setLayout();
    }

    private void setLayout() {
        this.setSize(600, 750);
        this.setLayout(null);
        this.setGameDisplayInCenter();
        this.setTitle("Game Slots");

        getContentPane().setLayout(null);

        getContentPane().add(this.infoLabel);
        getContentPane().add(this.activateSlot1Btn());
        getContentPane().add(this.activateSlot2Btn());
        getContentPane().add(this.activateSlot3Btn());
        getContentPane().add(this.activateSlot4Btn());
        getContentPane().add(this.activateSlot5Btn());
        getContentPane().add(this.activateSlot6Btn());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void setGameDisplayInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public JButton activateSlot1Btn() {
        infoLabel.setBounds(50, 50, 500, 50);
        slot1 = new JButton("SLOT 1");
        slot1.setBounds(50, 150, 200, 50);
        slot1.setFocusable(false);
        slot1.addActionListener(this);
        return slot1;
    }

    public JButton activateSlot2Btn() {
        slot2 = new JButton("SLOT 2");
        slot2.setBounds(300, 150, 200, 50);
        slot2.setFocusable(false);
        slot2.addActionListener(this);
        return slot2;
    }

    public JButton activateSlot3Btn() {
        slot3 = new JButton("SLOT 3");
        slot3.setBounds(50, 250, 200, 50);
        slot3.setFocusable(false);
        slot3.addActionListener(this);
        return slot3;
    }

    public JButton activateSlot4Btn() {
        slot4 = new JButton("SLOT 4");
        slot4.setBounds(300, 250, 200, 50);
        slot4.setFocusable(false);
        slot4.addActionListener(this);
        return slot4;
    }

    public JButton activateSlot5Btn() {
        slot5 = new JButton("SLOT 5");
        slot5.setBounds(50, 350, 200, 50);
        slot5.setFocusable(false);
        slot5.addActionListener(this);
        return slot5;
    }

    public JButton activateSlot6Btn() {
        slot6 = new JButton("SLOT 6");
        slot6.setBounds(300, 350, 200, 50);
        slot6.setFocusable(false);
        slot6.addActionListener(this);
        return slot6;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == slot1) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        } else if (e.getSource() == slot2) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        } else if (e.getSource() == slot3) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        } else if (e.getSource() == slot4) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        } else if (e.getSource() == slot5) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        } else if (e.getSource() == slot6) {
            int option = JOptionPane.showOptionDialog(null,
                    "Game saved successfully. Press EXIT to close the game or close this dialog box to resume with the game.",
                    "Game saved",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Exit" }, "Exit");

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                this.dispose();
            }
        }
    }

}
