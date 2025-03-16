package com.chat.ChatAppBackend.controller;


import com.chat.ChatAppBackend.entities.Message;
import com.chat.ChatAppBackend.entities.Room;
import com.chat.ChatAppBackend.payload.MessageRequest;
import com.chat.ChatAppBackend.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:5173")
public class ChatController {

    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepo) {
        this.roomRepository = roomRepo;
    }





//    for sending and reciving messages

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ){


        Room room = roomRepository.findByRoomId(request.getRoomId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());


        if(room!=null){
            room.getMessages().add(message);
            roomRepository.save(room);
        }else{

            throw new RuntimeException("Room Not Found");
        }



        return message;

    }



}
