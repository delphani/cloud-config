package com.delphani.services.room.repository;

import com.delphani.services.room.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by frankmoley on 5/22/17.
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByRoomNumber(String roomNumber);
}
