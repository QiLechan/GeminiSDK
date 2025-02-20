package org.yuezhikong.geminisdk;

import lombok.Getter;
import lombok.Setter;
import org.yuezhikong.geminisdk.util.Rest;

import java.util.List;


public class Client extends Types {
    @Setter
    private String api_key;

    public class Chats {
        @Setter
        private String model;

        @Getter
        public class Message{
            private List<String> role;

            private List<String> parts;
        }

        Message message = new Message();

        public String send_message(String message) {
            Generativeai genai = new Generativeai();
            genai.configure(api_key);
            genai.GenerativeModel(model);
            this.message.getRole().add("user");
            this.message.getParts().add(message);
            String response = genai.generate_content(message);
            this.message.getParts().add("");
            this.message.getRole().add(response);
            return response;
        }

        public Message _curated_history(){
            return message;
        }
    }

    public class Models{
        @Setter
        private String model;

        @Setter
        private String contents;

        @Setter
        private String config;

        public String GenerateJson(){
            return "";
        }

        public String generate_content(String json){
            return new Rest().post(api_key, model, json);
        }
    }

    public Chats create(String model){
        Chats chat= new Chats();
        chat.setModel(model);
        return chat;
    }
}
