package io.github.deripas.chrome.protocol.builder;

import lombok.experimental.UtilityClass;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.LookupTranslator;

import java.util.Map;

@UtilityClass
public class JavadocUtil {

    private static final Map<CharSequence, CharSequence> MAP = Map.of(
        "$", "&dollar;",
        "&", "&amp;",
        "@", "&commat;",
        "<", "&lt;",
        ">", "&gt;"
    );
    private static final AggregateTranslator TRANSLATOR = new AggregateTranslator(
        new LookupTranslator(MAP),
        new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE),
        new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE)
    );

    /**
     * Normalize javadoc.
     * '$' is not allowed in javadoc.
     *
     * @param javadoc javadoc
     * @return normalized javadoc
     */
    public static String normalize(String javadoc) {
        return TRANSLATOR.translate(javadoc);
    }
}
