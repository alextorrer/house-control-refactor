package data;

import model.Device;

import java.util.ArrayList;


public class DeviceParsing {

    private static final String FILE_PATH = "Devices.txt";

    /**
     *
     * @return a list of devices obtained from a .txt
     */
    public static ArrayList<Device> getDevices() {
        ArrayList<Device> devices = new ArrayList<>();
        String[] content = new FileReader(FILE_PATH).getContentFile().split(",");

        for (int i = 0; i < content.length; i = i + 3) {
            devices.add(new Device(content[i], content[i + 1], content[i + 2], content[i + 3], true));
        }

        return devices;
    }

}
