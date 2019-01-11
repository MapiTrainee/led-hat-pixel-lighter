package eu.mapidev.pi.ledhat;

import eu.mapidev.pi.ledhat.config.Color;
import eu.mapidev.pi.ledhat.config.LedStrip;

public class StripLighter {

    private LedStrip ledStrip;

    public StripLighter(LedStrip ledStrip) {
	this.ledStrip = ledStrip;
    }

    public void light(Color color) {
	ledStrip.setStrip(color);
	ledStrip.render();
    }

    public void light(int red, int green, int blue) {
	ledStrip.setStrip(red, green, blue);
	ledStrip.render();
    }
}
