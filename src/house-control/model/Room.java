package model;

import java.util.ArrayList;


public class Room implements DeviceHandler{

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
        for (Device device : devices) {
            device.switchDevice(status);
        }
    }

    /**
     *
     * @param nameDevice The name of the device(s)
     * @param status The new device's status
     */
    public void switchAllSameDevices(String nameDevice, boolean status){
        for(Device device : devices){
            if(device.getName().equals(nameDevice)){
                device.switchDevice(status);
            }
        }
    }

    public int countDevicesOn(){
        int devicesOn = 0;
        for(Device device : devices){
            if(device.getStatus()){
                devicesOn++;
            }
        }
        return devicesOn;
    }

    public int countSpecificDevice(String name){
        int sameDevices = 0;
        for(Device device : devices){
            if(device.getName().equals(name)){
                sameDevices++;
            }
        }
        return sameDevices;
    }

    public boolean toggleSpecificDevice(String name){
        boolean toggled = false;
        for(Device device : devices){
            if(device.getName().equals(name)){
                device.toggleDevice();
                toggled = true;
                break;
            }
        }
        return toggled;
    }

    public String toString(){
        String output = "";
        output=output+name +"\n";
        for (Device device : this.devices) {
            output = output + device.toString() + "\n";
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

