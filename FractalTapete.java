import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class FractalTapete extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private int depth = 5;

    public FractalTapete() {
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tapete de Sierpinski");
        FractalTapete carpet = new FractalTapete();
        frame.add(carpet);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawSierpinskiCarpet(g, 0, 0, WIDTH, depth);
    }

    private void drawSierpinskiCarpet(Graphics g, int x, int y, int size, int depth) {
        if (depth == 0) {
            
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 3;
            
            drawSierpinskiCarpet(g, x, y, newSize, depth - 1);
            drawSierpinskiCarpet(g, x + newSize, y, newSize, depth - 1);
            drawSierpinskiCarpet(g, x + 2 * newSize, y, newSize, depth - 1);

            drawSierpinskiCarpet(g, x, y + newSize, newSize, depth - 1);
            
            drawSierpinskiCarpet(g, x + 2 * newSize, y + newSize, newSize, depth - 1);

            drawSierpinskiCarpet(g, x, y + 2 * newSize, newSize, depth - 1);
            drawSierpinskiCarpet(g, x + newSize, y + 2 * newSize, newSize, depth - 1);
            drawSierpinskiCarpet(g, x + 2 * newSize, y + 2 * newSize, newSize, depth - 1);
        }
    }
}