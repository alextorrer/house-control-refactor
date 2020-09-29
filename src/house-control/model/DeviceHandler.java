package model;

public interface DeviceHandler {
    int countDevicesOn();
    int countSpecificDevice(String name);
    boolean toggleSpecificDevice(String name);
}
