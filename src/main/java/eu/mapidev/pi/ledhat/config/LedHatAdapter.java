package eu.mapidev.pi.ledhat.config;

import com.github.mbelling.ws281x.Ws281xLedStrip;

public class LedHatAdapter implements LedStrip, LedPixel {

    private final Ws281xLedStrip wls;

    public LedHatAdapter(Ws281xLedStrip wls) {
	this.wls = wls;
    }

    public synchronized void setPixel(int pixel, int red, int green, int blue) {
	wls.setPixel(pixel, red, green, blue);
    }

    public synchronized void setPixel(int pixel, Color color) {
	wls.setPixel(pixel, color.getRed(), color.getGreen(), color.getBlue());
    }

    public synchronized void setStrip(int red, int green, int blue) {
	wls.setStrip(red, green, blue);
    }

    public synchronized void setStrip(Color color) {
	wls.setStrip(color.getRed(), color.getGreen(), color.getBlue());
    }

    public synchronized void render() {
	wls.render();
    }

    public void setBrightness(int brightness) {
	wls.setBrightness(brightness);
    }

    public int getLedsCount() {
	return wls.getLedsCount();
    }

    public int getBrightness() {
	return wls.getBrightness();
    }

}
