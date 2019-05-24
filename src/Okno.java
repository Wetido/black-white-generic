import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class Okno extends JPanel {

    private Image black;
    private Image white;
    private ArrayList<Boolean> elements = new ArrayList<>();
    private JButton next = new JButton("Gotowy");
    private boolean rysowanie = false;

    private final int SIZE_X = 480;
    private final int SIZE_Y = 520;
    private final int SIZE = 80;



    public Okno() {


        setLayout(null);
        next.setBounds(190,485,100,30);

        next.addMouseListener( new Gotowy() );

        for (int i = 0; i < 36; i++) {

            elements.add(false) ;
        }

        setPreferredSize(new Dimension(SIZE_X, SIZE_Y));

        add(next);
        loadImage();
        generate();
        repaint();


    }

    private void generate() {

        Random random = new Random();

        for (int i = 0; i < elements.size(); i++) {

            elements.set(i, random.nextBoolean() );
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


        for (int i = 0; i < SIZE_X; i += SIZE) {

            for (int j = 0; j < 480; j += SIZE) {

                if (elements.get(licznik) ) {

                    g.drawImage(black, i, j, this);
                } else {

                    g.drawImage(white, i, j, this);
                }

                licznik++;
            }
        }

    }


    private class Rysowanie implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Point lokalizacja = MouseInfo.getPointerInfo().getLocation();

            double x = lokalizacja.getX();
            double y = lokalizacja.getX();


        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class Gotowy implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {


            for (int i = 0; i < elements.size(); i++) {

                elements.set(i, false );
            }

            repaint();
            addMouseListener( new Rysowanie() );

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
