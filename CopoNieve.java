
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class CopoNieve extends JPanel {
    double sin60 = Math.sin(Math.PI / 3);
    int nivel_de_recursividad = 5;  

    public CopoNieve() {
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Copo de Nieve de Koch");
        CopoNieve fractalCop = new CopoNieve();
        frame.add(fractalCop);
        frame.setSize(600, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        double xp1 = 100, yp1 = 400;
        double xp2 = 500, yp2 = 400;
        double xp3 = (xp1 + xp2) / 2, yp3 = yp1 - (xp2 - xp1) * sin60;

        paintRecursivo(g, nivel_de_recursividad, xp1, yp1, xp2, yp2);
        paintRecursivo(g, nivel_de_recursividad, xp2, yp2, xp3, yp3);
        paintRecursivo(g, nivel_de_recursividad, xp3, yp3, xp1, yp1);
    }

    private void paintRecursivo(Graphics g, int i, double xp1, double yp1, double xp2, double yp2) {
        double dx = (xp2 - xp1) / 3.;
        double dy = (yp2 - yp1) / 3.;

        double x3 = xp1 + dx;
        double y3 = yp1 + dy;
        double x4 = xp2 - dx;
        double y4 = yp2 - dy;
        double xx = x3 + dx / 2 - dy * sin60;
        double yy = y3 + dy / 2 + dx * sin60;

        if (i <= 0) {
            g.drawLine((int) xp1, (int) yp1, (int) xp2, (int) yp2);
        } else {

            paintRecursivo(g, i - 1, xp1, yp1, x3, y3);
            paintRecursivo(g, i - 1, x3, y3, xx, yy);
            paintRecursivo(g, i - 1, xx, yy, x4, y4);
            paintRecursivo(g, i - 1, x4, y4, xp2, yp2);
        }
    }
}
