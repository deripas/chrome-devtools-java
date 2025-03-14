package io.github.deripas.chrome.devtools.api.transport;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

public interface Response extends Record {

    Long getId();

    @Data
    class Success implements Response {
        private Long id;
        private JsonNode result;
    }

    @Data
    class Failed implements Response {
        private Long id;
        private Error error;

        public Exception toException() {
            return new ResponseException(error);
        }
    }

    @Data
    class Error {
        private Long code;
        private String message;
        private JsonNode data;
    }
}