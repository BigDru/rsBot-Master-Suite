package Master.Superheat;

import Master.MasterProperties;
import Misc.Task;
import org.powerbot.script.BotMenuListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import javax.swing.event.MenuEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 14/11/14
 * Time: 9:59 PM
 * Purpose: Use Superheat to make any bars.
 */

@Script.Manifest(name = "Master Superheat", description = "Uses Superheat to make any bars. Must start near bank. Must select bar type at start of script. Bank must be in all items tab.")
public class Superheat extends PollingScript<ClientContext> implements BotMenuListener {

    private List<Task> taskList = new ArrayList<Task>();
    MasterProperties properties = new MasterProperties();
    private int numRetry = 3;

    @Override
    public void start() {
        super.start();
        // obtain properties from persistent location
        boolean propertiesExist = false;
        try {
            FileInputStream inputStream = new FileInputStream("MasterSuiteProperties.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            properties = (MasterProperties) objectInputStream.readObject();
            objectInputStream.close();
            propertiesExist = true;
            properties.superheat.barType = Structs.BarType.UNSELECTED;
        } catch (Exception e) {
        }

        if (!propertiesExist) {
            properties = new MasterProperties();
            properties.superheat.barType = Structs.BarType.STEEL;
            System.out.println("Using default options");
        }

        // setup tasks to reflect data
        setup();
    }

    @Override
    public void stop() {
        // write properties to file
        boolean writeSuccess = false;
        try {
            FileOutputStream outputStream = new FileOutputStream("MasterSuiteProperties.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(properties);
            objectOutputStream.close();
            writeSuccess = true;
        } catch (Exception e) {
        }

        if (!writeSuccess) {
            System.out.println("Properties Write Failed.");
        }

        super.stop();
    }


    @Override
    public void poll() {
        setup();
        for (Task task : taskList) {
            if (task.activate()) {
                if (task.execute(properties) != 0) {
                    numRetry--;
                    if (numRetry > 0) {
                        System.out.println("Retries left: " + numRetry);
                    } else {
                        System.out.println("Something, somewhere, when horribly wrong.");
                        ctx.controller.stop();
                    }
                }
            }
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        new Menu(e, properties);
    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }

    private void setup() {
        taskList.clear();

        // equipment
        switch (properties.superheat.equipment) {
            case FIRE_RUNE:
                break;
            case STAFF_OF_FIRE:
                break;
        }

        //bars
        switch (properties.superheat.barType) {
            case UNSELECTED:
                break;
            case BRONZE:
                break;
            case BLURITE:
                break;
            case IRON:
                break;
            case ELEMENTAL:
                break;
            case SILVER:
                break;
            case STEEL:
                taskList.add(new Master.Superheat.Steel.Bank(ctx));
                break;
            case GOLD:
                break;
            case PERFECT_GOLD:
                break;
            case MITHRIL:
                break;
            case ADAMENT:
                break;
            case OBSIDIAN:
                break;
            case RUNE:
                break;
        }
    }
}
