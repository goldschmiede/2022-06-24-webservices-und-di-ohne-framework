package com.anderscore;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RestApplication() {
        MessageRepository messageRepository = new MessageRepository();

        singletons.add(new MessageController(messageRepository));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
