package org.yuezhikong.geminisdk;

import org.yuezhikong.geminisdk.util.Json_Builder;
import org.yuezhikong.geminisdk.util.Rest;

public class Generativeai {
    private String api_key;
    private String GenerativeModel;
    public Json_Builder jb = new Json_Builder();

    public void configure(String api_key) {
        this.api_key = api_key;
    }

    public void GenerativeModel(String GenerativeModel) {
        this.GenerativeModel = GenerativeModel;
    }

    public String generate_content(String input) {
        Json_Builder.Text Text = jb.new Text();
        Text.setText(input);
        String json = Json_Builder.complexObjToJson(Text);
        return new Rest().Post(api_key, GenerativeModel, json);
    }

}
