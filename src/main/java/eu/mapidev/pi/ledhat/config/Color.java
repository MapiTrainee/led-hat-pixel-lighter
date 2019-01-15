package eu.mapidev.pi.ledhat.config;

public class Color {

    public final static Color WHITE = new Color(255, 255, 255);
    public final static Color LIGHT_GRAY = new Color(192, 192, 192);
    public final static Color GRAY = new Color(128, 128, 128);
    public final static Color DARK_GRAY = new Color(64, 64, 64);
    public final static Color BLACK = new Color(0, 0, 0);
    public final static Color RED = new Color(255, 0, 0);
    public final static Color PINK = new Color(255, 175, 175);
    public final static Color ORANGE = new Color(255, 200, 0);
    public final static Color YELLOW = new Color(255, 255, 0);
    public final static Color GREEN = new Color(0, 255, 0);
    public final static Color MAGENTA = new Color(255, 0, 255);
    public final static Color CYAN = new Color(0, 255, 255);
    public final static Color BLUE = new Color(0, 0, 255);
    public final static Color RANDOM = createRandomColor();

    private static Color createRandomColor() {
	int red = (int) (Math.random() * 255);
	int green = (int) (Math.random() * 255);
	int blue = (int) (Math.random() * 255);
	return new Color(red, green, blue);
    }

    private final int red;
    private final int green;
    private final int blue;

    public Color(long bits) {
	this.red = (short) (bits >> 16) & 255;
	this.green = (short) (bits >> 8) & 255;
	this.blue = (short) bits & 255;
    }

    public Color(int red, int green, int blue) {
	this.red = red;
	this.green = green;
	this.blue = blue;
    }

    public int getRed() {
	return red;
    }

    public int getGreen() {
	return green;
    }

    public int getBlue() {
	return blue;
    }

    public long getColorBits() {
	return red << 16 | green << 8 | blue;
    }
}
