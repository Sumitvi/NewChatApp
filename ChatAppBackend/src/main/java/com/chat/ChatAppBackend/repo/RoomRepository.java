package com.chat.ChatAppBackend.repo;

import com.chat.ChatAppBackend.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {

//    get room using roomid

    Room findByRoomId(String roomId);
}
