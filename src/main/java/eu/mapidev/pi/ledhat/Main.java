package eu.mapidev.pi.ledhat;

import com.github.mbelling.ws281x.LedStripType;
import com.github.mbelling.ws281x.Ws281xLedStrip;
import eu.mapidev.pi.ledhat.config.LedHatAdapter;
import eu.mapidev.pi.ledhat.util.ColorParser;

public class Main {
    
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("usage: (program) color_can_be_hex");
	    System.exit(0);
	}
	
	ColorParser cp = new ColorParser();
	Ws281xLedStrip wls = new Ws281xLedStrip(32, 18, 800000, 5, 100, 0, false, LedStripType.WS2811_STRIP_GRB, true);
	StripLighter stripLighter = new StripLighter(new LedHatAdapter(wls));
	stripLighter.light(cp.parse(args[0]));
    }
}
