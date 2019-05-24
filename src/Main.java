import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        JFrame frame = new JFrame( " BlackWhite ");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new Okno( ) );

        frame.pack();
        frame.setVisible( true );


    }
}