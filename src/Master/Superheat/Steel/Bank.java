package Master.Superheat.Steel;

import Master.MasterProperties;
import Misc.Actions;
import Misc.ItemId;
import Misc.Task;
import Misc.Toolbox;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;


/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 15/11/14
 * Time: 3:09 AM
 * Purpose: Withdraws necessary items for superheating steel.
 */
public class Bank extends Task<ClientContext> {
    private int maxIronOre = 9;
    private int maxCoalOre = 18;

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        boolean isOpen = ctx.bank.opened();
        return !isOpen;
    }

    /**
     * @return 0 - success; d-1 - no nats, terminate; -2 - unable to find bank
     */
    @Override
    public int execute(MasterProperties properties) {
        // open bank
        if (!ctx.bank.opened()) {
            // poll for any npc banks and object banks
            boolean tryObj = false;
            Npc bank_npc = ctx.npcs.select().id(ItemId.npcs_bank).nearest().poll();
            GameObject bank_obj = ctx.objects.select().id(ItemId.object_bank).nearest().poll();

            // npcs
            if (bank_npc != ctx.npcs.nil()) {
                System.out.println("Opening Bank through NPC.");
                // place in viewport
                if (!bank_npc.inViewport())
                    ctx.camera.turnTo(bank_npc);
                // if failed to interact, try objects
                if (!bank_npc.interact(true, Actions.Bank)) {
                    System.out.println("Failed Interact.");
                    tryObj = true;
                }
                Toolbox.sleep(5000);
                if (!ctx.bank.opened()) {
                    tryObj = true;
                }

                // objects
            } else {
                tryObj = true;
            }

            if (tryObj) {
                System.out.println("Opening Bank through Object.");
                if (bank_obj != ctx.objects.nil()) {
                    // place in viewport
                    if (!bank_obj.inViewport())
                        ctx.camera.turnTo(bank_npc);
                    // if failed to interact, return
                    if (!bank_obj.interact(true, Actions.Bank)) {
                        System.out.println("Failed Interact.");
                        return -2;
                    }
                    Toolbox.sleep(5000);
                    if (!ctx.bank.opened()) {
                        return -2;
                    }
                } else {
                    return -2;
                }
            }
        }

        if (ctx.bank.opened()) {
            System.out.println("Bank is open.");
            //TODO: add support for moving to all items tab.

            int numIronOreInInventory = 0;
            int numCoalOreInInventory = 0;

            // if inv is empty, take out nats.
            if (ctx.inventory.isEmpty()) {
                System.out.println("Empty. Taking out nats.");
                boolean withdraw = ctx.bank.withdraw(ItemId.object_nature_rune, org.powerbot.script.rt4.Bank.Amount.ALL);
                if (!withdraw) {
                    System.out.println("No nats in bank.");
                    return -1;
                }
            }
            // check if nats are in first slot in inventory.
            else if (ctx.inventory.itemAt(0).id() != ItemId.object_nature_rune) {
                System.out.println("Inventory Order Incorrect.");
                // dump inventory
                ctx.bank.depositInventory();
                Toolbox.sleep(500);
                // withdraw nats
                boolean withdraw = ctx.bank.withdraw(ItemId.object_nature_rune, org.powerbot.script.rt4.Bank.Amount.ALL);
                if (!withdraw) {
                    System.out.println("No nats in bank.");
                    return -1;
                }
            }
            // if more than nats in inventory, deposit everything else unless coal/iron.
            else if (ctx.inventory.count() != 1) {
                for (Item i : ctx.inventory.items()) {

                    // not nat rune?
                    if (i.id() != ItemId.object_nature_rune) {

                        if (i.id() == ItemId.object_iron_ore) {
                            numIronOreInInventory++;
                        } else if (i.id() == ItemId.object_coal_ore) {
                            numCoalOreInInventory++;
                        } else {
                            ctx.bank.deposit(i.id(), org.powerbot.script.rt4.Bank.Amount.ALL);
                        }
                    }
                }
                if (numIronOreInInventory > maxIronOre) {
                    ctx.bank.deposit(ItemId.object_iron_ore, numIronOreInInventory - maxIronOre);
                    Toolbox.sleep(500);
                }
                if (numCoalOreInInventory > maxCoalOre) {
                    ctx.bank.deposit(ItemId.object_coal_ore, numCoalOreInInventory - maxCoalOre);
                    Toolbox.sleep(500);
                }
            }

            // take out iron ore
            if (numIronOreInInventory != maxIronOre) {
                ctx.bank.withdraw(ItemId.object_iron_ore, maxIronOre - numIronOreInInventory);
                Toolbox.sleep(500);
            }

            // take out coal ore
            if (numCoalOreInInventory != maxCoalOre) {
                ctx.bank.withdraw(ItemId.object_coal_ore, maxCoalOre - numCoalOreInInventory);
                Toolbox.sleep(500);
            }

            ctx.bank.close();
            return 0;
        }
        return -1;
    }
}
