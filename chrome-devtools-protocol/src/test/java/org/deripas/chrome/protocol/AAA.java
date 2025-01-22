package org.deripas.chrome.protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

public class AAA {

    @Data
    @RequiredArgsConstructor(staticName = "of")
    static class TDO {
//        private final AXNodeId id;
//        private final AXValueNativeSourceType type;
//        private final PermissionsPolicyFeature feature;
//        private final WindowID windowId;
//        private final ArrayOfStrings arrayOfStrings;
//        private final Headers headers;
    }

    @SneakyThrows
    public static void main(String[] args) {
        TDO tdo = TDO.of(
//            AXNodeId.of("1"),
//            AXValueNativeSourceType.LABEL,
//            PermissionsPolicyFeature.ALL_SCREENS_CAPTURE,
//            WindowID.of(123),
//            ArrayOfStrings.of(List.of(StringIndex.of(1), StringIndex.of(2))),
//            Headers.of(Maps.newLinkedHashMap(Map.of("h1", "qaz", "h2", "wsx")))
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String jsom = objectMapper.writeValueAsString(tdo);
        TDO tdo1 = objectMapper.readValue(jsom, TDO.class);
        System.out.println(tdo1.equals(tdo));
    }
}
