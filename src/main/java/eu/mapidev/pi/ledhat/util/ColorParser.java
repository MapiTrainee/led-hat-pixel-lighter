package eu.mapidev.pi.ledhat.util;

import eu.mapidev.pi.ledhat.config.Color;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColorParser {

    public static final String REGEX_HEX_COLOR = "^#(?:[0-9a-fA-F]{3}){1,2}$";
    private static final Logger LOGGER = Logger.getLogger(ColorParser.class.getName());

    public Color parse(String input) {
	if (isHex(input)) {
	    return new Color(Long.decode("0x" + input.substring(1)));
	}
	Color color = parseColorName(input);
	if (colorIsNotNull(color)) {
	    return color;
	}
	throw new IllegalArgumentException("Input is NOT correct color name or hex!");
    }

    private boolean colorIsNotNull(Color color) {
	return color != null;
    }

    private boolean isHex(String input) throws NumberFormatException {
	if (input.matches(REGEX_HEX_COLOR)) {
	    return true;
	}
	return false;
    }

    private Color parseColorName(String name) {
	try {
	    Class<?> colorClass = Color.class;
	    Field[] fields = colorClass.getFields();
	    for (Field field : fields) {
		if (field.getType().isAssignableFrom(Color.class) && field.getName().equalsIgnoreCase(name)) {
		    return (Color) field.get(name);
		}
	    }
	} catch (IllegalAccessException | IllegalArgumentException ex) {
	    LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
	}
	return null;
    }

}
