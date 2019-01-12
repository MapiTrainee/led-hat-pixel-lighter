package eu.mapidev.pi.ledhat.util;

import eu.mapidev.pi.ledhat.config.Color;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class ColorParserTest {

    private static final String SAMPLE_HEX = "#12AF00";
    private static final String NOT_HEX = "#NOTHEX";
    private static final String RED_COLOR_TEXT = "red";

    private ColorParser parser;

    @Before
    public void setUp() {
	parser = new ColorParser();
    }

    @Test
    public void regExColorHexShouldMatchSampleHex() {
	//when
	boolean isMatched = SAMPLE_HEX.matches(ColorParser.REGEX_HEX_COLOR);

	//then
	assertThat(isMatched, is(true));
    }

    @Test
    public void regExColorHexShouldNotMatchNotHex() {
	//when
	boolean isMatched = NOT_HEX.matches(ColorParser.REGEX_HEX_COLOR);

	//then
	assertThat(isMatched, is(false));
    }

    @Test
    public void regExColorhexShouldNotMatchRedColorText() {
	//when
	boolean isMatched = RED_COLOR_TEXT.matches(ColorParser.REGEX_HEX_COLOR);

	//then
	assertThat(isMatched, is(false));
    }

    @Test
    public void shouldParseToColorWhenIsSampleHex() {
	//when
	Color actualColor = parser.parse(SAMPLE_HEX);

	//then
	assertThat(actualColor.getColorBits(), is(Long.decode("0x" + SAMPLE_HEX.substring(1))));
    }

    @Test
    public void shouldParseToColorWhenIsRedColorText() {
	//when
	Color actualColor = parser.parse(RED_COLOR_TEXT);

	//then
	assertThat(actualColor, is(equalTo(Color.RED)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIsNotHexAndColorText() {
	//when
	parser.parse(NOT_HEX);
    }

}
