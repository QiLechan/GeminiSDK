package org.yuezhikong.geminisdk;

import org.yuezhikong.geminisdk.util.Rest;

public class Generativeai {
    private String api_key;
    private String GenerativeModel;

    public void configure(String api_key) {
        this.api_key = api_key;
    }

    public void GenerativeModel(String GenerativeModel) {
        this.GenerativeModel = GenerativeModel;
    }

    public String generate_content(String input) {
        String response = new Rest().Post(api_key, GenerativeModel, input);

        return response;
    }
}
