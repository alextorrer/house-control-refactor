package model;

import java.util.ArrayList;


public class House implements DeviceHandler{
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
        for(Level level : levels){
            devicesOn += level.countDevicesOn();
        }
        return devicesOn;
    }

    public int countSpecificDevice(String name){
        int sameDevices=0;
        for(Level level : levels){
            sameDevices += level.countSpecificDevice(name);
        }
        return sameDevices;
    }

    public boolean toggleSpecificDevice(String device){
        boolean toggled = false;
        for(Level level : levels){
            if(level.toggleSpecificDevice(name)){
                toggled = true;
                break;
            }
        }
        return toggled;
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

