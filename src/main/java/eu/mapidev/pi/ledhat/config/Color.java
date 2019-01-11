package eu.mapidev.pi.ledhat.config;

public enum Color {

    WHITE(255, 255, 255),
    LIGHT_GRAY(192, 192, 192),
    GRAY(128, 128, 128),
    DARK_GRAY(64, 64, 64),
    BLACK(0, 0, 0),
    RED(255, 0, 0),
    PINK(255, 175, 175),
    ORANGE(255, 200, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    MAGENTA(255, 0, 255),
    CYAN(0, 255, 255),
    BLUE(0, 0, 255);

    private final int red;
    private final int green;
    private final int blue;

    private Color(int red, int green, int blue) {
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
