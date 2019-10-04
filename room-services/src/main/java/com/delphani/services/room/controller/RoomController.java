package com.delphani.services.room.controller;

import com.delphani.services.room.entity.Room;
import com.delphani.services.room.repository.RoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by frankmoley on 5/22/17.
 */
@RestController
@RequestMapping(value="/rooms")
@Api(value="rooms", description = "Data service operations on rooms", tags=("rooms"))
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Rooms", notes="Gets all rooms in the system", nickname="getRooms")
    public List<Room> findAll(){
        return (List<Room>) this.roomRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{roomNumber}")
    @ApiOperation(value="Get Room by number", notes="Gets rooms by number in the system", nickname="getByRoomNumber")
    public List<Room> findByRoomNumber(@PathVariable String roomNumber){
        if(StringUtils.isNotEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepository.findAll();
    }
}
