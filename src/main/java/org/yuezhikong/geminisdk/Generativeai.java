package org.yuezhikong.geminisdk;

import lombok.Setter;
import org.yuezhikong.geminisdk.util.Image;
import org.yuezhikong.geminisdk.util.Json_Builder;
import org.yuezhikong.geminisdk.util.Rest;

import java.io.IOException;

public class Generativeai {
    private String api_key;
    private String GenerativeModel;
    public enum Mode {
        STREAM, IMAGE, IMAGE_STREAM
    }
    public Json_Builder jb = new Json_Builder();

    public void configure(String api_key) {
        this.api_key = api_key;
    }

    public void GenerativeModel(String GenerativeModel) {
        this.GenerativeModel = GenerativeModel;
    }

    public String generate_content(String input) {
        String json = String.format("{\"contents\": [{\"parts\":[{\"text\":\"%s\"}]}]}", input);
        return new Rest().post(api_key, GenerativeModel, json);
    }

    public String generate_content(String input, Mode mode, String image_path) throws IOException {
        switch (mode) {
            case IMAGE_STREAM:
                return generate_content(input);
            case IMAGE:
                String json = String.format("{\"contents\":[{\"parts\":[{\"text\":\"%s\"},{\"inline_data\":{\"mime_type\":\"image/png\",\"data\":\"%s\"}}]}]}", input, Image.open(image_path));
                return new Rest().post(api_key, GenerativeModel, json);
            default:
                return "";
        }
    }

    public String generate_content(String input, Mode mode) {
        switch (mode) {
            case STREAM:
                String json = String.format("{\"contents\": [{\"parts\":[{\"text\":\"%s\"}]}]}", input);
                new Rest().post_stream(api_key, GenerativeModel, json);
            default:
                return "";
        }
    }
}
