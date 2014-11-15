package Master.Superheat;

import Master.Superheat.Steel.Bank;
import Misc.Task;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 14/11/14
 * Time: 9:59 PM
 * Purpose: Use Superheat to make any bars.
 */

@Script.Manifest(name = "Master Superheat", description = "Uses Superheat to make any bars. Must start near bank.")
public class Superheat extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        super.start();
        taskList.addAll(Arrays.asList(new Bank(ctx)));
    }


    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate())
                task.execute();
        }
    }
}
