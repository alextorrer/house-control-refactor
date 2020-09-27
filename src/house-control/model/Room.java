package model;

import java.util.ArrayList;


public class Room {

    private ArrayList<Device> devices;
    private String IDRoom;
    private String name;

    
    public Room(String IDRoom, String name, ArrayList<Device> devices){
        this.IDRoom = IDRoom;
        this.name = name;
        this.devices = devices;
        }
    
    public Room(String name){
        this.devices = new ArrayList<Device>();
        this.name = name;
        
    }

    /*GETTERS & SETTERS*/
    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     * @param status The new status for the devices
     */
    public void switchAllDevices(boolean status){
        for(int index=0; index<devices.size(); index++){
            devices.get(index).switchDevice(status);
        }
    }

    public String toString(){
        String output = "";
        output=output+name +"\n";
        for(int i=0;i<this.devices.size();i++){
            output = output+devices.get(i).toString()+"\n";
        }
        return output;
    }

    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof Room){
            Room otherRoom =(Room)obj;
            if(this.name.equals(otherRoom.name)){
                    flag = true;
            }
        }
        return flag;
    }

}

