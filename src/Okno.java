import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Okno extends JPanel {

    private Image black;
    private Image white;
    private ArrayList<Boolean> elements;

    private final int size = 5;


    public Okno() {

        setPreferredSize(new Dimension(500, 500));

        generate();
        loadImage();
        repaint();

    }

    public void generate() {

        elements = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {

            elements.add( random.nextBoolean() );
        }


    }

    private void loadImage() {

        ImageIcon black = new ImageIcon("src/images/black.jpg");
        this.black = black.getImage();


        ImageIcon white = new ImageIcon("src/images/white.jpg");
        this.white = white.getImage();
    }

    public void paintComponent(Graphics g) {

        int licznik = 0;
        super.paintComponent(g);


        for (int i = 0; i < 500; i += size) {

            for (int j = 0; j < 500; j += size) {

                if (elements.get(licznik) == true) {

                    g.drawImage(black, i, j, this);
                }
                if ( elements.get(licznik) == false ){

                    g.drawImage(white, i, j, this);
                }

                licznik++;
            }
        }

    }


}
