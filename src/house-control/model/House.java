package model;

import java.util.ArrayList;


public class House {
    private ArrayList<Level> levels;
    private String name;

    public House (ArrayList<Level> levels, String name){
        this.levels = levels;
        this.name = name;
    }
    
    public House (String name){
        this.levels = new ArrayList<Level>();
        this.name = name;
    }

    
    public int countDevicesOn(){
        int devicesOn=0;
        for(int i=0;i<levels.size(); i++){
            ArrayList<Room>rooms = levels.get(i).getRooms();
            int counterRooms= levels.get(i).getRooms().size();
            for(int j=0;j<counterRooms; j++){
                ArrayList<Device> devices = rooms.get(j).getDevices();
                int counterDevices = rooms.get(j).getDevices().size();
                for(int k=0;k<counterDevices; k++){
                    if(devices.get(k).getStatus()){
                    devicesOn++;
                    }
                }
            }
        }
        return devicesOn;
    }

    public int countSpecificDevice(String name){
        int counter=0;
        for(int i=0;i<levels.size(); i++){
            ArrayList<Room>rooms = levels.get(i).getRooms();
            int counterRooms= levels.get(i).getRooms().size();
            for(int j=0;j<counterRooms; j++){
                ArrayList<Device> devices = rooms.get(j).getDevices();
                int counterDevices = rooms.get(j).getDevices().size();
                for(int k=0;k<counterDevices; k++){
                    if(devices.get(k).getName().equals(name)){
                    counter++;
                    }
                }
            }
        }
        return counter;
    }

public boolean toogleSpecificDeviceLevel(String level,String device){
    boolean flag = false;
    for(int i=0;i<levels.size(); i++){
        if(levels.get(i).getName().equals(level)){
        ArrayList<Room>rooms = levels.get(i).getRooms();
        int counterRooms= levels.get(i).getRooms().size();
        for(int j=0;j<counterRooms; j++){
            ArrayList<Device> devices = rooms.get(j).getDevices();
            int counterDevices = rooms.get(j).getDevices().size();
            for(int k=0;k<counterDevices; k++){
                if(devices.get(k).getName().equals(name)){
                devices.get(k).toggleDevice();
                flag = true;
                }
            }
          }
        }
    }
    return flag;
}

    public String toString(){
        String output = "";
        output=output+name +"\n";
        for(int i=0;i<levels.size();i++){
            output = output+levels.get(i).toString()+"\n";
        }
        return output;
    }

}

