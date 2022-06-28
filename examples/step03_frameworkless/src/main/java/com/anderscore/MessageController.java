package com.anderscore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

// @WebServlet(urlPatterns = "/messages")
public class MessageController extends HttpServlet {

    MessageRepository messageRepository = new MessageRepository();
    ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        if (request.getParameter("id") != null) {
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Optional<Message> message = messageRepository.get(id);

            if(message.isPresent()) {
                response.getWriter().println(writer.writeValueAsString(message.get()));
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.getWriter().println(writer.writeValueAsString(messageRepository.getAll()));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        messageRepository.add(new Message(body));
    }
}
