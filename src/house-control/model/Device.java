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
    public String getIDDevice() { return IDDevice; }

    public void setIDDevice(String IDDevice){ this.IDDevice = IDDevice; }

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

    public boolean getStatus() {
        return status;
    }

    public void switchDevice(boolean status) {
        this.status = status;
    }

    public void toggleDevice(){
        this.status = !(this.status);
    }

    public String toString(){
        return name+" "+brand+" "+model +" " +status;
    }

    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof Device){
            Device otherDevice =(Device)obj;
            if(this.name.equals(otherDevice.name) &&
                this.brand.equals(otherDevice.brand) &&
                this.model.equals(otherDevice.model)){
                flag = true;
            }
        }
        return flag;
    }

}
