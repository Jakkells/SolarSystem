import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SolarSystem extends JPanel {

    private int Earthx, Earthy, moon1x, moon1y, Mercuryx, Mercuryy, Venusx, Venusy, Marsx, Marsy, Jupiterx, JupiterY, Saturnx, Saturny, Uranusx, Uranusy, Neptunex, Neptuney;
    private int angle = 0;
    private float zoomLevel = 1.0f;
    private static int xShift = 0;
    private static int yShift = 0;

    public static void panLeft() {
        xShift -= 20;
    }

    public static void panRight() {
        xShift += 20;
    }

    public static void panUp() {
        yShift -= 20;
    }

    public static void panDown() {
        yShift += 20;
    }



    public SolarSystem() {
        this.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                zoomLevel += 0.1;
            } else {
                zoomLevel -= 0.1;
            }
            repaint();
        });

        repaint();

        new Thread(() -> {
            while (true) {
                angle += 1;

                float EarthIncrement = 1.5F;
                Earthx = (int) (getWidth() / 2 + (700 * zoomLevel) * Math.cos(angle* Math.PI / 180 * EarthIncrement));
                Earthy = (int) (getHeight() / 2 + (700 * zoomLevel) * Math.sin(angle * Math.PI / 180 * EarthIncrement));

                int moon1Increment = 3;
                moon1x = (int) (Earthx + (50 * zoomLevel) * Math.cos(angle * 2 * Math.PI / 180 * moon1Increment));
                moon1y = (int) (Earthy + (50 * zoomLevel) * Math.sin(angle * 2 * Math.PI / 180 * moon1Increment));

                int MercuryIncrement = 1;
                Mercuryx = (int) (getWidth() / 2 + (300 * zoomLevel) * Math.cos(angle * Math.PI / 180 * MercuryIncrement));
                Mercuryy = (int) (getHeight() / 2 + (300 * zoomLevel) * Math.sin(angle * Math.PI / 180 * MercuryIncrement));

                float VenusIncrement = 1.3F;
                Venusx = (int) (getWidth() / 2 + (500 * zoomLevel) * Math.cos(angle * Math.PI / 180 * VenusIncrement));
                Venusy = (int) (getHeight() / 2 + (500 * zoomLevel) * Math.sin(angle * Math.PI / 180 * VenusIncrement));

                float MarsIncrement = 1.8F;
                Marsx = (int) (getWidth() / 2 + (900 * zoomLevel) * Math.cos(angle * Math.PI / 180 * MarsIncrement));
                Marsy = (int) (getHeight() / 2 + (900 * zoomLevel) * Math.sin(angle * Math.PI / 180 * MarsIncrement));

                float JupiterIncrement = 0.5F;
                Jupiterx = (int) (getWidth() / 2 + (2000 * zoomLevel) * Math.cos(angle * Math.PI / 180 * JupiterIncrement));
                JupiterY = (int) (getHeight() / 2 + (2000 * zoomLevel) * Math.sin(angle * Math.PI / 180 * JupiterIncrement));

                float SaturnIncrement = 1.1F;
                Saturnx = (int) (getWidth() / 2 + (2300 * zoomLevel) * Math.cos(angle * Math.PI / 180 * SaturnIncrement));
                Saturny = (int) (getHeight() / 2 + (2300 * zoomLevel) * Math.sin(angle * Math.PI / 180 * SaturnIncrement));

                float UranusIncrement = 1.3F;
                Uranusx = (int) (getWidth() / 2 + (2600 * zoomLevel) * Math.cos(angle * Math.PI / 180 * UranusIncrement));
                Uranusy = (int) (getHeight() / 2 + (2600 * zoomLevel) * Math.sin(angle * Math.PI / 180 * UranusIncrement));

                float NeptuneIncrement = 1.6F;
                Neptunex = (int) (getWidth() / 2 + (2800 * zoomLevel) * Math.cos(angle * Math.PI / 180 * NeptuneIncrement));
                Neptuney = (int) (getHeight() / 2 + (2800 * zoomLevel) * Math.sin(angle * Math.PI / 180 * NeptuneIncrement));




                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth() / 2 + xShift;
        int y = getHeight() / 2 + yShift;
        int sunRadius = (int) (200 * zoomLevel);

        g.setColor(Color.YELLOW);
        g.fillOval(x - sunRadius, y - sunRadius, 2 * sunRadius, 2 * sunRadius);

        int EarthRadius = (int) (24 * zoomLevel);

        g.setColor(Color.BLUE);
        g.fillOval(Earthx - EarthRadius + xShift, Earthy - EarthRadius + yShift,
                2 * EarthRadius, 2 * EarthRadius);

        int MercuryRadius = (int) (12 * zoomLevel);

        g.setColor(Color.darkGray);
        g.fillOval(Mercuryx - MercuryRadius + xShift, Mercuryy - MercuryRadius + yShift,
                2 * MercuryRadius, 2 * MercuryRadius);

        int moon1Radius = (int) (8 * zoomLevel);

        g.setColor(Color.GRAY);
        g.fillOval(moon1x - moon1Radius + xShift, moon1y- moon1Radius + yShift,
                2 * moon1Radius, 2 * moon1Radius);

        int VenusRadius = (int) (20 * zoomLevel);

        g.setColor(Color.white);
        g.fillOval(Venusx - VenusRadius + xShift, Venusy - VenusRadius + yShift,
                2 * VenusRadius, 2 * VenusRadius );

        int MarsRadius = (int) (16 * zoomLevel);

        g.setColor(Color.red);
        g.fillOval(Marsx - MarsRadius + xShift, Marsy - MarsRadius + yShift,
                2 * MarsRadius, 2 * MarsRadius );

        int JupiterRadius = (int) (40 * zoomLevel);

        g.setColor(Color.white);
        g.fillOval(Jupiterx - JupiterRadius + xShift, JupiterY - JupiterRadius + yShift,
                2 * JupiterRadius, 2 * JupiterRadius );

        int SaturnRadius = (int) (35 * zoomLevel);

        g.setColor(Color.white);
        g.fillOval(Saturnx - SaturnRadius + xShift, Saturny - SaturnRadius + yShift,
                2 * SaturnRadius, 2 * SaturnRadius );

        int UranusRadius = (int) (30 * zoomLevel);

        g.setColor(Color.blue);
        g.fillOval(Uranusx - UranusRadius + xShift, Uranusy - UranusRadius + yShift,
                2 * UranusRadius, 2 * UranusRadius );

        int NeptuneRadius = (int) (30 * zoomLevel);

        g.setColor(Color.blue);
        g.fillOval(Neptunex - NeptuneRadius + xShift, Neptuney - NeptuneRadius + yShift,
                2 * NeptuneRadius, 2 * NeptuneRadius );

        setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SolarSystem());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> SolarSystem.panLeft();
                    case KeyEvent.VK_RIGHT -> SolarSystem.panRight();
                    case KeyEvent.VK_UP -> SolarSystem.panUp();
                    case KeyEvent.VK_DOWN -> SolarSystem.panDown();
                }
            }
        });
        frame.setFocusable(true);
        frame.requestFocus();
    }
}

