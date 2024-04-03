import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class buttonPanelGridLayout extends JButton {

    private int xCoordinate;
    private int yCoordinate;
    private ArrayList<String> multipleCheckers;

    public buttonPanelGridLayout(int xCoordinate, int yCoordinate) {
        super();
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        multipleCheckers = new ArrayList<>();
    }

    public ArrayList<String> getMultipleStackCheckers() {
        return this.multipleCheckers;
    }

    public int getXCordinate() {
        return xCoordinate;
    }

    public int getYCordinate() {
        return yCoordinate;
    }

    public void setXCordinate(int value) {
        xCoordinate = value;
    }

    public void setYCordinate(int value) {
        yCoordinate = value;
    }

}
