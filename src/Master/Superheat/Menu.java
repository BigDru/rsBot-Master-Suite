package Master.Superheat;

import z.A;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Dru
 * Date: 15/11/14
 * Time: 5:07 PM
 * Purpose: Handle menu operations
 */
public class Menu {
    public enum Equipment {
        FIRE_RUNE,
        STAFF_OF_FIRE
    }

    public enum BarType {
        UNSELECTED,
        BRONZE,
        BLURITE,
        IRON,
        ELEMENTAL,
        SILVER,
        STEEL,
        GOLD,
        PERFECT_GOLD,
        MITHRIL,
        ADAMENT,
        OBSIDIAN,
        RUNE
    }

    public static Equipment equipment = Equipment.FIRE_RUNE;
    public static BarType barType = BarType.UNSELECTED;
    public static boolean goldsmithGaunt = false;

    public static void handle(MenuEvent e) {
        final JMenu optionsMenu = (JMenu) e.getSource();

        // define menu items

        // Equipment
        JMenu equipmentMenu = new JMenu("Equipment");
        ButtonGroup equipmentButtonGroup = new ButtonGroup();

        // create items
        JRadioButtonMenuItem fireRunes = new JRadioButtonMenuItem("Use Fire Runes");
        fireRunes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = Equipment.FIRE_RUNE;
            }
        });
        JRadioButtonMenuItem staffOfFire = new JRadioButtonMenuItem("Use Staff of Fire");
        staffOfFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipment = Equipment.STAFF_OF_FIRE;
            }
        });
        JCheckBoxMenuItem goldsmithingGauntlets = new JCheckBoxMenuItem("Use Goldsmithing Gauntlets");
        goldsmithingGauntlets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goldsmithGaunt = !goldsmithGaunt;
            }
        });

        // set selected
        switch (equipment) {
            case FIRE_RUNE:
                fireRunes.setSelected(true);
                break;
            case STAFF_OF_FIRE:
                staffOfFire.setSelected(true);
                break;
        }
        goldsmithingGauntlets.setSelected(goldsmithGaunt);

        // add to button group
        equipmentButtonGroup.add(fireRunes);
        equipmentButtonGroup.add(staffOfFire);

        // add to menus
        equipmentMenu.add(fireRunes);
        equipmentMenu.addSeparator();
        equipmentMenu.add(staffOfFire);
        equipmentMenu.addSeparator();
        equipmentMenu.add(goldsmithingGauntlets);
        optionsMenu.add(equipmentMenu);


        // Bars
        JMenu barMenu = new JMenu("Bars");
        ButtonGroup barsButtonGroup = new ButtonGroup();

        // create items
        JRadioButtonMenuItem unselected = new JRadioButtonMenuItem("Unselected");
        unselected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.UNSELECTED;
            }
        });
        JRadioButtonMenuItem bronze = new JRadioButtonMenuItem("Bronze");
        bronze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.BRONZE;
            }
        });
        JRadioButtonMenuItem blurite = new JRadioButtonMenuItem("Blurite");
        blurite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.BLURITE;
            }
        });
        JRadioButtonMenuItem iron = new JRadioButtonMenuItem("Iron");
        iron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.IRON;
            }
        });
        JRadioButtonMenuItem elemental = new JRadioButtonMenuItem("Elemental");
        elemental.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.ELEMENTAL;
            }
        });
        JRadioButtonMenuItem silver = new JRadioButtonMenuItem("Silver");
        silver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.SILVER;
            }
        });
        JRadioButtonMenuItem steel = new JRadioButtonMenuItem("Steel");
        steel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.STEEL;
            }
        });
        JRadioButtonMenuItem gold = new JRadioButtonMenuItem("Gold");
        gold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.GOLD;
            }
        });
        JRadioButtonMenuItem perfectGold = new JRadioButtonMenuItem("Perfect Gold");
        perfectGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.PERFECT_GOLD;
            }
        });
        JRadioButtonMenuItem mithril = new JRadioButtonMenuItem("Mithril");
        mithril.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.MITHRIL;
            }
        });
        JRadioButtonMenuItem adamant = new JRadioButtonMenuItem("Adamant");
        adamant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.ADAMENT;
            }
        });
        JRadioButtonMenuItem obsidian = new JRadioButtonMenuItem("Obsidian");
        obsidian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.OBSIDIAN;
            }
        });
        JRadioButtonMenuItem rune = new JRadioButtonMenuItem("Rune");
        rune.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barType = BarType.RUNE;
            }
        });

        // set selected
        switch (barType) {
            case UNSELECTED:
                unselected.setSelected(true);
                break;
            case BRONZE:
                bronze.setSelected(true);
                break;
            case BLURITE:
                blurite.setSelected(true);
                break;
            case IRON:
                iron.setSelected(true);
                break;
            case ELEMENTAL:
                elemental.setSelected(true);
                break;
            case SILVER:
                silver.setSelected(true);
                break;
            case STEEL:
                steel.setSelected(true);
                break;
            case GOLD:
                gold.setSelected(true);
                break;
            case PERFECT_GOLD:
                perfectGold.setSelected(true);
                break;
            case MITHRIL:
                mithril.setSelected(true);
                break;
            case ADAMENT:
                adamant.setSelected(true);
                break;
            case OBSIDIAN:
                obsidian.setSelected(true);
                break;
            case RUNE:
                rune.setSelected(true);
                break;
        }

        // add to button group
        barsButtonGroup.add(unselected);
        barsButtonGroup.add(bronze);
        barsButtonGroup.add(blurite);
        barsButtonGroup.add(iron);
        barsButtonGroup.add(elemental);
        barsButtonGroup.add(silver);
        barsButtonGroup.add(steel);
        barsButtonGroup.add(gold);
        barsButtonGroup.add(perfectGold);
        barsButtonGroup.add(mithril);
        barsButtonGroup.add(adamant);
        barsButtonGroup.add(obsidian);
        barsButtonGroup.add(rune);

        // add to Menus
        barMenu.add(unselected);
        barMenu.add(bronze);
        barMenu.add(blurite);
        barMenu.add(iron);
        barMenu.add(elemental);
        barMenu.add(silver);
        barMenu.add(steel);
        barMenu.add(gold);
        barMenu.add(perfectGold);
        barMenu.add(mithril);
        barMenu.add(adamant);
        barMenu.add(obsidian);
        barMenu.add(rune);
        optionsMenu.add(barMenu);
    }
}
