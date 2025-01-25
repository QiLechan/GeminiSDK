package org.yuezhikong.geminisdk.util;

import cn.hutool.http.HttpUtil;

public class Rest {
    private final String URL = "https://generativelanguage.googleapis.com/v1beta/models/";
    public String Post(String api_key, String GenerativeModel, String input) {
        String url = URL + GenerativeModel + ":generateContent?key=" + api_key;
        return HttpUtil.post(url, input);
    }
}
