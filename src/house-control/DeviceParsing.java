
import java.util.ArrayList;


public class DeviceParsing {
    ArrayList<Device> devices;
    String content;
    
    public DeviceParsing(){
        this.devices = new ArrayList<Device>();

    }
    
    public void getString(){
        content = new FileReader("Devices.txt").getContentFile();
        
    }
    
    public String[] parsingContent(){
        
        String[] parsing= content.split(",");
        return parsing;
    }
    
    public void setDevices(String[] parsing){
        for(int i = 0; i<parsing.length; i=i+3){
            devices.add(new Device(parsing[i], parsing[i+1], parsing[i+2], parsing[i+3], true));
        }
    }
    
    
    public static void main(String ar[]){
        DeviceParsing dp = new DeviceParsing();
        dp.getString();
        dp.parsingContent();
    
    }
    
}
