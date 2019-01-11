package eu.mapidev.pi.ledhat.config;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ColorTest {

    @Test
    public void shouldGetRGBColorAsBites() {
	long redBits = Color.RED.getColorBits();
	long greenBits = Color.GREEN.getColorBits();
	long blueBits = Color.BLUE.getColorBits();
	assertThat(redBits, is(0xff0000L));
	assertThat(greenBits, is(0x00ff00L));
	assertThat(blueBits, is(0x0000ffL));
    }
    
    @Test 
    public void shouldGetBlackAndWhiteColorAsBites(){
    	long whiteBits = Color.WHITE.getColorBits();
    	long blackBits = Color.BLACK.getColorBits();
	assertThat(whiteBits, is(0xffffffL));
	assertThat(blackBits, is(0x000000L));
    }

}
