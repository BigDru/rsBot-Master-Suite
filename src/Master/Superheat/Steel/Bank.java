package Master.Superheat.Steel;

import Misc.Task;
import org.powerbot.script.rt4.ClientContext;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 15/11/14
 * Time: 3:09 AM
 * Purpose: Withdraws necessary items for superheating
 */
public class Bank extends Task<ClientContext> {

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        boolean isOpen = ctx.bank.opened();
        return !isOpen;
    }

    @Override
    public int execute() {
        ctx.
        return 0;
    }
}
