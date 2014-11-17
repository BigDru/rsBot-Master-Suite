package Misc;

import org.powerbot.script.rt4.ClientContext;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 15/11/14
 * Time: 1:56 AM
 * Purpose: Provides useful static functions.
 */
public class Toolbox {
    public final static int inventorySize = 28;

    public static boolean isInventoryFull(ClientContext ctx){
        return ctx.inventory.size() == inventorySize;
    }

    public static boolean isPlayerIdle(ClientContext ctx){
        return ctx.players.local().animation()==-1;
    }

    public static void sleep(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
        }
    }
}
