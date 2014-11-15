package Master.Superheat.Steel;

import Misc.Actions;
import Misc.ItemId;
import Misc.Task;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Npc;


/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 15/11/14
 * Time: 3:09 AM
 * Purpose: Withdraws necessary items for superheating steel.
 */
public class Bank extends Task<ClientContext> {

    private int numRetry;

    public Bank(ClientContext ctx) {
        super(ctx);
        numRetry = 3;
    }

    @Override
    public boolean activate() {
        boolean isOpen = ctx.bank.opened();
        return !isOpen;
    }

    /**
     * @return 0 - success; 1 - try again; -1 - no nats, terminate; -2 - unable to find bank
     */
    @Override
    public int execute() {
        // check if bank open
        if (ctx.bank.opened()) {

        } else {
            // open bank

            // poll for any npc banks and object banks
            boolean tryObj = false;
            Npc bank_npc = ctx.npcs.select().id(ItemId.npcs_bank).nearest().poll();
            GameObject bank_obj = ctx.objects.select().id(ItemId.object_bank).nearest().poll();

            // npcs
            if (bank_npc != ctx.npcs.nil()) {
                // place in viewport
                if (!bank_npc.inViewport())
                    ctx.camera.turnTo(bank_npc);
                // if failed to open, try with objects
                if (!bank_npc.interact(true, Actions.Bank) || !ctx.bank.opened()) {
                    tryObj = true;
                }
                // if inv is empty, take out nats.
                if (ctx.inventory.isEmpty()) {
                    System.out.println("Empty. Taking out nats.");
                    boolean withdraw = ctx.bank.withdraw(ItemId.object_nature_rune, org.powerbot.script.rt4.Bank.Amount.ALL);
                    if (!withdraw) {
                        System.out.println("No nats in bank.");
                        return -1;
                    }

                }
                // objects
            } else {
                tryObj = true;
            }
            if (tryObj) {
                if (bank_obj != ctx.objects.nil()) {

                } else {
                    numRetry--;
                    return -2;
                }
            }
        }
        return 0;
    }
}
