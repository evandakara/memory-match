import javax.swing.*;
import java.awt.*;

public class Card extends JButton {

    private Integer id;
    private Icon image;
    public static final Icon bgImage = new ImageIcon("background.jpg");
    private boolean matched;

    // Buat Konstruktor Card Disini

    public Card(Integer id, String imageFileName) {
        super(bgImage);
        this.id = id;
        this.image = new ImageIcon(imageFileName);
        Image rescaled = ((ImageIcon) this.image).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(rescaled);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

}