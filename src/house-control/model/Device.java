package model;

public class Device {
    
    private String IDDevice;
    private String name;
    private String brand;
    private String model;
    private boolean status;
    
    public Device(String IDDevice, String name, String brand, String model, boolean status){
        this.IDDevice = IDDevice;
        this.name = name;
        this.brand =  brand;
        this.model = model;
        this.status = status;
    }
 
    /***GETTERS & SETTERS***/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public String toString(){
        return name+" "+brand+" "+model +" " +status;
    }

    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof Device && obj!= null){
            Device otherDevice =(Device)obj;
            if(this.name == otherDevice.name &&
               this.brand == otherDevice.brand && 
               this.model == otherDevice.model){
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean toggleDevice(){
        this.status = !(this.status); 
        return status;
    }
    
    public boolean switchOffDevice(){
        status = false;
        return status;
    }
    
    public boolean switchOnDevice(){
        status = true;
        return status;
    }
    
}
