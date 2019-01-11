package eu.mapidev.pi.ledhat.config;

public interface LedPixel {

    void render();

    void setPixel(int pixel, Color color);

    void setPixel(int pixel, int red, int green, int blue);

}
