package org.yuezhikong.geminisdk;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class Client {
    @Setter
    private String api_key;

    public class Chats {
        @Setter
        private String model;

        @Getter
        public class Message{
            private List<String> role;

            private List<String> part;
        }

        Message message = new Message();

        public String send_message(String message) {
            Generativeai genai = new Generativeai();
            genai.configure(api_key);
            genai.GenerativeModel(model);
            this.message.getRole().add("user");
            this.message.getPart().add(message);
            String response = genai.generate_content(message);
            this.message.getPart().add("");
            this.message.getRole().add(response);
            return response;
        }

        public Message _curated_history(){
            return message;
        }
    }
    public Chats create(String model){
        Chats chat= new Chats();
        chat.setModel(model);
        return chat;
    }
}
