package eu.mapidev.pi.ledhat.config;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ColorTest {

    @Test
    public void shouldGetRGBColorAsBits() {
	long redBits = Color.RED.getColorBits();
	long greenBits = Color.GREEN.getColorBits();
	long blueBits = Color.BLUE.getColorBits();
	assertThat(redBits, is(0xff0000L));
	assertThat(greenBits, is(0x00ff00L));
	assertThat(blueBits, is(0x0000ffL));
    }

    @Test
    public void shouldGetBlackAndWhiteColorAsBits() {
	long whiteBits = Color.WHITE.getColorBits();
	long blackBits = Color.BLACK.getColorBits();
	assertThat(whiteBits, is(0xffffffL));
	assertThat(blackBits, is(0x000000L));
    }

    @Test
    public void shouldBeAbleToCreateColorFromBitsWithCorrectRGB() {
	Color color = new Color(0xff00ffL);
	assertThat(color.getRed(), is(255));
	assertThat(color.getGreen(), is(0));
	assertThat(color.getBlue(), is(255));
    }

    @Test
    public void RandomColorShouldBeInCorrectRangeOfRGB() {
	Color random = Color.RANDOM;
	assertThat(random.getRed(), allOf(lessThanOrEqualTo(255), greaterThanOrEqualTo(0)));
	assertThat(random.getGreen(), allOf(lessThanOrEqualTo(255), greaterThanOrEqualTo(0)));
	assertThat(random.getBlue(), allOf(lessThanOrEqualTo(255), greaterThanOrEqualTo(0)));
    }

}
