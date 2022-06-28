package com.anderscore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/messages")
public class MessageController {

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("id") int id) {
        Optional<Message> message = messageRepository.get(id);

        if (message.isPresent()) {
            return message.get();
        } else {
            throw new NotFoundException();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageRepository.getAll();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(String messageContent) {
        Message message = new Message(messageContent);
        messageRepository.add(message);

        return Response.ok(message).build();
    }

}