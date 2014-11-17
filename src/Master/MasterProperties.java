package Master;

import Master.Superheat.Structs;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 16/11/14
 * Time: 1:34 PM
 * Purpose: Stores all property values for the Master Suite
 */
public class MasterProperties implements Serializable {
    public Superheat superheat;

    public MasterProperties() {
        superheat = new Superheat();
    }

    public class Superheat {
        public Structs.Equipment equipment = Structs.Equipment.FIRE_RUNE;
        public Structs.BarType barType = Structs.BarType.UNSELECTED;
        public boolean goldsmithGaunt = false;
    }

}
