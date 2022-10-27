package HelloGraphicsApp;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class HelloGraphicsApp extends GraphicsApp {

    /* Private Konstanten */
    private static final Color BACKGROUND_COLOR = Colors.BLACK;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {

    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }

    public static void main(String[] args) {
            GraphicsAppLauncher.launch();
        }
}
