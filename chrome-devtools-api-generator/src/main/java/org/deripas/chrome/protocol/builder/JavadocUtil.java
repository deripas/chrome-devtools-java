package org.deripas.chrome.protocol.builder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JavadocUtil {

    /**
     * Normalize javadoc.
     * '$' is not allowed in javadoc.
     *
     * @param javadoc javadoc
     * @return normalized javadoc
     */
    public static String normalize(String javadoc) {
        return javadoc.replace("$", "&#36;");
    }
}
