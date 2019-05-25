import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Okno extends JPanel {

    private Image black;
    private Image white;
    private ArrayList<Boolean> elements = new ArrayList<>();
    private ArrayList<Boolean> pattern = new ArrayList<>();
    private JButton next = new JButton("Gotowy");

    private Gotowy gotowy = new Gotowy();
    private Sprawdzanie sprawdzanie = new Sprawdzanie();
    private Rysowanie rysowanie = new Rysowanie();

    private final int SIZE_X = 320;
    private final int SIZE_Y = 360;
    private final int SIZE = 80;



    public Okno() {


        setLayout(null);
        next.setBounds(SIZE_X /3 ,SIZE_Y - 35,100,30);

        next.addMouseListener( gotowy );

        for (int i = 0; i < Math.pow( SIZE_X / 80, 2.0) ; i++) {

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

            for (int j = 0; j < SIZE_Y - 40; j += SIZE) {

                if (elements.get(licznik) ) {

                    g.drawImage(black, j, i, this);
                } else {

                    g.drawImage(white, j, i, this);
                }

                licznik++;
            }
        }

    }

    private class Sprawdzanie implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            if ( pattern.equals( elements ) ) System.out.println( "Dobrze" );
            else System.out.println( "Zle" );

            generate();
            repaint();

            removeMouseListener( rysowanie );
            next.removeMouseListener( sprawdzanie );
            next.addMouseListener( gotowy );
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

    private class Rysowanie implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Point lokalizacja = getMousePosition();

            int x =  ( (int) lokalizacja.getX() / 80 )  ;
            int y =  ( (int) lokalizacja.getY() / 80 )  ;

            int licznik = ( int )( Math.sqrt( elements.size()) * y + x );

            if( elements.get( licznik ) ) {
                elements.set(licznik, false);
            } else
                elements.set( licznik , true );


            repaint();
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

            pattern = (ArrayList<Boolean>) elements.clone();

            for (int i = 0; i < elements.size(); i++) {

                elements.set(i, false );
            }


            next.removeMouseListener( gotowy );
            next.addMouseListener( sprawdzanie );
            addMouseListener( rysowanie );

            repaint();
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
