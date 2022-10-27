package HelloGraphicsApp;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Ellipse;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class HelloGraphicsApp extends GraphicsApp {

    /* Private Konstanten */
    private static final Color BACKGROUND_COLOR = Colors.WHITE;
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {
        setupCanvas();
    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        drawSmiley();
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        drawBackground(BACKGROUND_COLOR);
    }

    private void drawSmiley() {
        drawFace();
        drawMouth();
        drawLeftEye();
        drawRightEye();
    }

    /*
        CANVAS_WIDTH bzw. CANVAS_HEIGHT / 2 liefert die Position der Mitte unserer Zeichenfläche. Hier platzieren wir den
        Mittelpunkt unseres Kreises, so dass dieser mittig im Bild angezeigt wird. Das .f hinter 2 sorgt dafür, dass
        die 2 als eine Kommazahl behandelt wird und somit die Nachkommastellen nicht abgeschnitten werden.
        Durch Aufruf von face.draw() wird der Kreis im Bild angezeigt.
    */
    private void drawFace() {
        float x = CANVAS_WIDTH / 2.f;
        float y = CANVAS_HEIGHT / 2.f;
        int width = CANVAS_WIDTH / 2;
        int height = CANVAS_HEIGHT / 2;
        Ellipse face = new Ellipse(x, y, width, height, Colors.YELLOW);
        face.draw();
    }

    /*
        Der Mund soll aus der x-Achse mittig angezeigt werden, aber auf der y-Achse nach unten versetzt werden.
        Da in der GraphicsApp höhere y-Werte weiter unten sind, wird der CANVAS_HEIGHT durch eine kleinere Zahl
        geteilt, um den Kreis nach unten zu verschieben.
    */
    private void drawMouth() {
        float x = CANVAS_WIDTH / 2.f;
        float y = CANVAS_HEIGHT / 1.5f;
        int width = CANVAS_WIDTH / 10;
        int height = CANVAS_HEIGHT /20;
        Ellipse mouth = new Ellipse(x, y, width,height, Colors.BLACK);
        mouth.draw();
    }

    /*
        Das linke Auge wird nach links verschoben indem vom Mittelpunkt der Zeichenfläche, den man durch
        CANVAS_WIDTH/2 erhält ein Wert abgezogen wird. Denn wie in einem Koordinatensystem sind kleinere Werte
        weiter links und größere weiter rechts.
        Das Auge wird weiter nach oben verschoben, indem die Höhe des Canvas durch einen Wert >2 geteilt wird,
        dadurch wird der Wert kleiner und kleinere y-Werte liegen in der GraphicsApp weiter oben.
        Das Auge soll außerdem nicht so graß sein wie der ganze Canvas, daher werden Breite und Höhe durch
        Teilen der Canvas Breite und Höhe durch Zahlen >1 berechnet. Analog gilt das für die Pupillen, diese
        sollen aber kleiner sein als das Auge und werden daher durch nochmal größere Zahlen geteilt.
    */
    private void drawLeftEye() {
        float x = CANVAS_WIDTH / 2.f - CANVAS_WIDTH / 10.f;
        float y = CANVAS_HEIGHT / 2.5f;
        int width = CANVAS_WIDTH / 10;
        int height = CANVAS_HEIGHT /10;
        int pupilWidth = CANVAS_WIDTH /20;
        int pupilHeight= CANVAS_HEIGHT /20;
        Ellipse leftEye = new Ellipse(x, y, width, height, Colors.BLACK);
        leftEye.draw();
        Ellipse leftIris = new Ellipse(x, y, pupilWidth, pupilHeight, Colors.WHITE);
        leftIris.draw();
    }

    // Diese Methode funktioniert analog zu drawLeftEye()
    private void drawRightEye() {
        float x = CANVAS_WIDTH / 2.f + CANVAS_WIDTH / 10.f;
        float y = CANVAS_HEIGHT / 2.5f;
        int width = CANVAS_WIDTH / 10;
        int height = CANVAS_HEIGHT /10;
        int pupilWidth = CANVAS_WIDTH /20;
        int pupilHeight= CANVAS_HEIGHT /20;
        Ellipse rightEye = new Ellipse(x, y, width, height, Colors.BLACK);
        rightEye.draw();
        Ellipse rightIris = new Ellipse(x, y, pupilWidth, pupilHeight, Colors.WHITE);
        rightIris.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
