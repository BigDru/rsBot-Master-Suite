package Master.Superheat.Steel;

import Master.MasterProperties;
import Misc.Actions;
import Misc.ItemId;
import Misc.Task;
import Misc.Toolbox;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Magic;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 16/11/14
 * Time: 8:24 PM
 * Purpose:
 */
public class Cast extends Task<ClientContext> {

    int numIron = 0;
    int numCoal = 0;

    public Cast(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        // call only if inventory has ores and nats are present
        numIron = 0;
        numCoal = 0;
        boolean hasNats = false;
        // count ores
        for (Item i : ctx.inventory.items()) {
            if (i.id() == ItemId.object_coal_ore)
                numCoal++;
            else if (i.id() == ItemId.object_iron_ore)
                numIron++;
            else if (i.id() == ItemId.object_nature_rune)
                hasNats = true;
        }
        return (numIron > 0 && numCoal > 1 && hasNats);
    }

    @Override
    public int execute(MasterProperties properties) {
        int timesToCast;
        if (numCoal >= numIron * 2)
            timesToCast = numIron;
        else
            timesToCast = numIron / 2;

        for (; timesToCast > 0; timesToCast--) {
            ctx.magic.cast(Magic.Spell.SUPERHEAT_ITEM);
            for (Item i : ctx.inventory.items()){
                if (i.id() == ItemId.object_iron_ore){
                    i.interact(true, Actions.Cast);
                    break;
                }
            }
            Toolbox.sleep(2500);
        }
        return 0;
    }
}
