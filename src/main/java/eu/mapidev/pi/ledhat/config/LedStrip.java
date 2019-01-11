package eu.mapidev.pi.ledhat.config;

public interface LedStrip {

    void render();

    void setStrip(Color color);

    void setStrip(int red, int green, int blue);

}
