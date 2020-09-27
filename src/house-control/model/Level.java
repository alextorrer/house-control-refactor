package model;

import exception.DeviceNotFoundException;
import exception.RoomNotFoundException;

import java.util.ArrayList;

public class Level {

    private String name;
    private String IDLevel;
    private ArrayList<Room> rooms;

    public Level(String IDLevel, String name, ArrayList<Room> rooms){
        this.IDLevel = IDLevel;
        this.name = name;
        this.rooms = rooms;
    }

    public Level(String name){
        this.name = name;
        this.rooms =  new ArrayList<Room>();
    }

    /***GETTERS & SETTERS***/

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param status The new device status
     */
    public void switchAllRooms(boolean status){
        for (Room room : rooms) {
            room.switchAllDevices(status);
        }
    }

    /**
     * @implNote Switch a room inside the level
     * @param room The room to switch
     * @param status The new device's status
     * @throws RoomNotFoundException The room is not found
     */
    public void switchRoom(Room room, boolean status) throws RoomNotFoundException{
        int index = rooms.indexOf(room);
        if(index == -1){
            throw new RoomNotFoundException("No se encontró la habitación solicitada");
        }
        rooms.get(index).switchAllDevices(status);
    }

    /**
     * @implNote Switch a device inside a specific room
     * @param room The room to switch
     * @param device The device to switch
     * @param status The new device status
     * @throws RoomNotFoundException The room is not found
     * @throws DeviceNotFoundException The Device is not found inside the room
     */
    public void levelSwitchDevice(Room room, Device device, boolean status) throws RoomNotFoundException, DeviceNotFoundException {
        int lRoom = rooms.indexOf(room);
        if(lRoom == -1){
            throw new RoomNotFoundException("The room can't be found");
        }

        ArrayList<Device> d = rooms.get(lRoom).getDevices();
        int lDevice = d.indexOf(device);
        if(lDevice == -1){
            throw new DeviceNotFoundException("The device can't be found inside the room");
        }
        d.get(lDevice).switchDevice(status);
    }

    /**
     *
     * @param nameDevices The shared name of the device(s)
     * @param status The new device's status
     */
    public void switchAllSameDevices(String nameDevices, boolean status){
      for(Room room: rooms){
          room.switchAllSameDevices(nameDevices, status);
      }
    }

    public String toString(){
        String output = "";
        output=output+name +"\n";
        for (Room room : rooms) {
            output = output + room.toString() + "\n";
        }
        return output;
    }
  
    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof Level && obj!= null){
            Level otherDevice =(Level)obj;
            if(this.name == otherDevice.name){
                flag = true;
            }
        }
        return flag;
    }
    
}
