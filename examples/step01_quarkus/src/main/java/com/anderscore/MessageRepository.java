package com.anderscore;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class MessageRepository {

    public List<Message> messageList = new ArrayList<>();

    public MessageRepository() {
        messageList.add(new Message("Hello World!"));
    }

    public void add(Message message) {
        this.messageList.add(message);
    }

    public Optional<Message> get(int id) {
        return messageList.stream().filter(message -> message.getId() == id).findFirst();
    }

    public List<Message> getAll() {
        return messageList;
    }

}
