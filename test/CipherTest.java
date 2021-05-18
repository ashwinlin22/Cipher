import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test Cipher methods
 *
 * @author Suzanne Balik
 * @author Ashwin Lingaraj
 */
public class CipherTest {

    
    /** Alphabet */
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /** Alphabet reversed */
    public static final String ALPHABET_REVERSED = "zyxwvutsrqponmlkjihgfedcba";

    /** One uppercase word */
    public static final String UPPERCASE_WORD = "COMPUTER";
    
    /** uppercase word reversed */
    public static final String UPPERCASE_WORD_REVERSED = "RETUPMOC";
    
    /** mixed case word reversed */
    public static final String MIXED_CASE_REVERSED = "!OlleH";

    /** One uppercase word shifted forward 2 with no wraparound */
    public static final String UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND = "EQORWVGT"; 

    /**
     * Test reversing null string
     */
    @Test
    public void testReverseLine0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.reverseLine(null),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test reversing entire alphabet
     */
    @Test
    public void testReverseLine1() {
        String description = "Reverse Line 1: alphabet";
        String actual = Cipher.reverseLine(ALPHABET);
        assertEquals(ALPHABET_REVERSED, actual, description);
    }
    
    /**
     * Test reversing word with all capital letters
     */
    @Test
    public void testReverseLine2() {
        String description = "Reverse Line 1: COMPUTER";
        String actual = Cipher.reverseLine(UPPERCASE_WORD);
        assertEquals(UPPERCASE_WORD_REVERSED, actual, description);  
    }
    
    /** 
     * Test reversing word with mixed case and punctuation
     */
    @Test
    public void testReverseLine3() {
        String description = "Reverse Line 1: HellO!";
        String actual = Cipher.reverseLine("HellO!");
        assertEquals(MIXED_CASE_REVERSED, actual, description);
    }
    
    /**
     * Test shifting null string forward
     */
    @Test
    public void testShiftLineLettersForward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }
    
    /**
     * Test shifting string forward with invalid shift amount
     */
    @Test
    public void testShiftLineLettersForward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(ALPHABET, -1),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward2() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(UPPERCASE_WORD, 2);
        assertEquals(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, actual, description);
    }

    /** 
     * Test shifting one word forward at boundary value 1 with no wrap around
     */
    @Test
    public void testShiftLineLettersForward3() {
        String description = "Shift lowercase word forward 1 with no wraparound";
        String actual = Cipher.shiftLineLettersForward("testing",1);
        assertEquals("uftujoh", actual, description);
    }
    
    /**
     * Test shifting one string forward 3 with numbers mixed in
     */
    @Test
    public void testShiftLineLettersForward4() {
        String description = "Shift string with numbers with no wraparound";
        String actual = Cipher.shiftLineLettersForward("one1two2three3", 3);
        assertEquals("rqh1wzr2wkuhh3", actual, description);
    }
    
    
    /** 
     * Test shifting word forward 4 with wraparound
     */
    @Test  
    public void testShiftLineLettersForward5() {
        String description = "Shift lowercase string forward 4 with wraparound";
        String actual = Cipher.shiftLineLettersForward("xylophone", 4);
        assertEquals("bcpstlsri", actual, description);
    }
   
    /**
     * Test shifting word forward 2 with exclamation marks
     */
    @Test
    public void testShiftLineLettersForward6() {
        String description = "Shift word with punctuation forward 2";
        String actual = Cipher.shiftLineLettersForward("hola!!!", 2);
        assertEquals("jqnc!!!", actual, description);
    }
    
    /**
     * Test shifting multiple words forward 3 with mixed case with no wraparound
     */ 
    @Test
    public void testShiftLineLettersForward7() {
        String description = "Shift string with multiple words";
        String actual = Cipher.shiftLineLettersForward("NC State",3);
        assertEquals("QF Vwdwh", actual, description);
    }
    
    /**
     * Test shifting null string backward
     */
    @Test
    public void testShiftLineLettersBackward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }
    
    /**
     * Test shifting string backward with invalid shift amount
     */
    @Test
    public void testShiftLineLettersBackward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(ALPHABET, 26),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward2() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual = 
            Cipher.shiftLineLettersBackward(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, 2);
        assertEquals(UPPERCASE_WORD, actual, description);
    }

    /**
     * Test shifting multiple words backwards with no wraparound
     */
    @Test
    public void testShiftLineLettersBackward3 () {
        String description = "Shift lowercase multiple words backward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("hello there", 2);
        assertEquals("fcjjm rfcpc", actual, description);
    }
    
    /**
     * Test shifting string with numbers backwards 4
     */
    @Test
    public void testShiftLineLettersBackward4() {
        String description = "Shift string with numbers backward 4 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("one1two2three3", 4);
        assertEquals("kja1psk2pdnaa3", actual, description);
    }
    
    /** 
     * Test shifting word backwards 3 with wraparound
     */
    @Test
    public void testShiftLineLettersBackward5() {
        String description = "Shift word backwards 3 with wraparound";
        String actual = Cipher.shiftLineLettersBackward("abacus", 3);
        assertEquals("xyxzrp", actual, description);
    }
    
    /**
     * Test shifting word with mixed case backwards 2
     */
    @Test
    public void testShiftLineLettersBackward6() {
        String description = "Shift word with mixed case backwards 2 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("CoMpUTeRs", 2);
        assertEquals("AmKnSRcPq", actual, description);
    }
    
    /** 
     * Test shifting backward at boundary value 1
     */
    @Test
    public void testShiftLineLettersBackward7() {
        String description = "Shift word backward at boundary value 1 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("testing", 1);
        assertEquals("sdrshmf", actual, description);
    }

}
