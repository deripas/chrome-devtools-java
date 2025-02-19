package io.github.deripas.chrome.protocol.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavadocUtilTest {

    @Test
    void normalize() {
        assertEquals("\"name\"", JavadocUtil.normalize("\"name\""));
        assertEquals("&lt;input type=\"text\"&gt;", JavadocUtil.normalize("<input type=\"text\">"));
        assertEquals("&dollar;", JavadocUtil.normalize("$"));
        assertEquals("&commat;starting-style", JavadocUtil.normalize("@starting-style"));
    }
}