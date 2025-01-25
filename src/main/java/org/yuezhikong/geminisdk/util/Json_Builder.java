package org.yuezhikong.geminisdk.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@lombok.NoArgsConstructor
@lombok.Data
public class Json_Builder {
    public static String complexObjToJson(Object obj) {
        if (Objects.isNull(obj)) return "";
        try {
            Gson gson = new Gson();
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public class Text {
        @com.fasterxml.jackson.annotation.JsonProperty("contents")
        private List<ContentsDTO> contents;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class ContentsDTO {
            @com.fasterxml.jackson.annotation.JsonProperty("parts")
            private List<PartsDTO> parts;

            @lombok.NoArgsConstructor
            @lombok.Data
            public static class PartsDTO {
                @com.fasterxml.jackson.annotation.JsonProperty("text")
                private String text;
            }
        }

        public void setText(String text) {
            ContentsDTO.PartsDTO parts = new ContentsDTO.PartsDTO();
            parts.setText(text);
        }
    }

    @NoArgsConstructor
    @Data
    public class Text_Image {

        @JsonProperty("contents")
        private List<ContentsDTO> contents;

        @NoArgsConstructor
        @Data
        public static class ContentsDTO {
            @JsonProperty("parts")
            private List<PartsDTO> parts;

            @NoArgsConstructor
            @Data
            public static class PartsDTO {
                @JsonProperty("text")
                private String text;
                @JsonProperty("inline_data")
                private InlineDataDTO inlineData;

                @NoArgsConstructor
                @Data
                public static class InlineDataDTO {
                    @JsonProperty("mime_type")
                    private String mimeType;
                    @JsonProperty("data")
                    private String data;
                }
            }
        }
    }

    @NoArgsConstructor
    @Data
    public class Text_Stream {

        @JsonProperty("contents")
        private List<ContentsDTO> contents;

        @NoArgsConstructor
        @Data
        public static class ContentsDTO {
            @JsonProperty("parts")
            private List<PartsDTO> parts;

            @NoArgsConstructor
            @Data
            public static class PartsDTO {
                @JsonProperty("text")
                private String text;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public class Interactive_Chat{

        @JsonProperty("contents")
        private List<ContentsDTO> contents;

        @NoArgsConstructor
        @Data
        public static class ContentsDTO {
            @JsonProperty("role")
            private String role;
            @JsonProperty("parts")
            private List<PartsDTO> parts;

            @NoArgsConstructor
            @Data
            public static class PartsDTO {
                @JsonProperty("text")
                private String text;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public class Configure_Text{

        @JsonProperty("contents")
        private List<ContentsDTO> contents;
        @JsonProperty("safetySettings")
        private List<SafetySettingsDTO> safetySettings;
        @JsonProperty("generationConfig")
        private GenerationConfigDTO generationConfig;

        @NoArgsConstructor
        @Data
        public static class GenerationConfigDTO {
            @JsonProperty("stopSequences")
            private List<String> stopSequences;
            @JsonProperty("temperature")
            private Integer temperature;
            @JsonProperty("maxOutputTokens")
            private Integer maxOutputTokens;
            @JsonProperty("topP")
            private Double topP;
            @JsonProperty("topK")
            private Integer topK;
        }

        @NoArgsConstructor
        @Data
        public static class ContentsDTO {
            @JsonProperty("parts")
            private List<PartsDTO> parts;

            @NoArgsConstructor
            @Data
            public static class PartsDTO {
                @JsonProperty("text")
                private String text;
            }
        }

        @NoArgsConstructor
        @Data
        public static class SafetySettingsDTO {
            @JsonProperty("category")
            private String category;
            @JsonProperty("threshold")
            private String threshold;
        }
    }
}
