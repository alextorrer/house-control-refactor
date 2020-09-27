package data;

import exception.ParsingDeviceException;
import model.Device;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class DeviceParsing {

    private static final String FILE_PATH = "Devices.txt";

    /**
     *
     * @return a list of devices obtained from a .txt
     * @throws ParsingDeviceException to be handled by the view
     */
    public static ArrayList<Device> getDevices() throws ParsingDeviceException {
        ArrayList<Device> devices = new ArrayList<>();
        try{
            String[] content = new FileReader(FILE_PATH).getContentFile().split(",");

            for (int i = 0; i < content.length; i = i + 3) {
                devices.add(new Device(content[i], content[i + 1], content[i + 2], content[i + 3], true));
            }

        }
        catch(FileNotFoundException ex){
            throw new ParsingDeviceException("No se pudo encontrar el archivo con los dispositivos");
        }

        return devices;
    }

}
