package com.chat.ChatAppBackend.controller;


import com.chat.ChatAppBackend.entities.Message;
import com.chat.ChatAppBackend.entities.Room;
import com.chat.ChatAppBackend.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")
public class RoomController {

    
    @Autowired
    private RoomRepository roomRepository;

//    create room


    @PostMapping
    public ResponseEntity<?> CreateRoom(@RequestBody String roomId){

      if(roomRepository.findByRoomId(roomId)!=null){
          return ResponseEntity.badRequest().body("Room Already Exist");
      }

      Room room = new Room();
      room.setRoomId(roomId);
      roomRepository.save(room);

      return ResponseEntity.status(HttpStatus.CREATED).body(room);

    }



//    get room

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getRoom(@PathVariable String roomId){

        Room room = roomRepository.findByRoomId(roomId);

        if(room==null){
            return ResponseEntity.badRequest().body("Room Not Found");
        }

        return ResponseEntity.ok(room);
    }



//    get messages of room

    @GetMapping("/{roomId}/messages")

    public ResponseEntity<?> getRoomMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page" , defaultValue = "0",required = false) int page,
            @RequestParam(value = "size" , defaultValue = "20", required = false ) int size

    ){

        Room room = roomRepository.findByRoomId(roomId);
        if(room==null){
            return ResponseEntity.badRequest().body("Room Not Found");
        }



        List<Message> messages = room.getMessages();

        int start = Math.max(0 , messages.size() - (page+1) * size);
        int end = Math.min(start + size, messages.size());

        List<Message> messages1 = messages.subList(start, end);

        return ResponseEntity.ok(messages);


    }
}



