package org.yuezhikong.geminisdk.util;

public class Rest {
    private final String URL = "https://generativelanguage.googleapis.com/v1beta/models/";
    private String GenerativeModel;
    private String api_key;
    public Json_Builder jsonbuilder = new Json_Builder();
    public String Post(String api_key, String GenerativeModel, String input) {
        String url = URL + GenerativeModel + ":generateContent?key=" + api_key;
        Json_Builder.Text Text = jsonbuilder.new Text();
    }
}
