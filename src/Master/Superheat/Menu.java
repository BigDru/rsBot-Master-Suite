package Master.Superheat;

import Master.MasterProperties;
import Master.Superheat.Structs.Equipment;
import Master.Superheat.Structs.BarType;

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

    public Menu(MenuEvent e, final MasterProperties p) {
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
                p.superheat.equipment = Equipment.FIRE_RUNE;
            }
        });
        JRadioButtonMenuItem staffOfFire = new JRadioButtonMenuItem("Use Staff of Fire");
        staffOfFire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.equipment = Equipment.STAFF_OF_FIRE;
            }
        });
        JCheckBoxMenuItem goldsmithingGauntlets = new JCheckBoxMenuItem("Use Goldsmithing Gauntlets");
        goldsmithingGauntlets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.goldsmithGaunt = !p.superheat.goldsmithGaunt;
            }
        });

        // set selected
        switch (p.superheat.equipment) {
            case FIRE_RUNE:
                fireRunes.setSelected(true);
                break;
            case STAFF_OF_FIRE:
                staffOfFire.setSelected(true);
                break;
        }
        goldsmithingGauntlets.setSelected(p.superheat.goldsmithGaunt);

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
                p.superheat.barType = BarType.UNSELECTED;
            }
        });
        JRadioButtonMenuItem bronze = new JRadioButtonMenuItem("Bronze");
        bronze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.BRONZE;
                System.out.println("Bronze Selected.");
            }
        });
        JRadioButtonMenuItem blurite = new JRadioButtonMenuItem("Blurite");
        blurite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.BLURITE;
                System.out.println("Blurite Selected.");
            }
        });
        JRadioButtonMenuItem iron = new JRadioButtonMenuItem("Iron");
        iron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.IRON;
                System.out.println("Iron Selected.");
            }
        });
        JRadioButtonMenuItem elemental = new JRadioButtonMenuItem("Elemental");
        elemental.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.ELEMENTAL;
                System.out.println("Elemental Selected.");
            }
        });
        JRadioButtonMenuItem silver = new JRadioButtonMenuItem("Silver");
        silver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.SILVER;
                System.out.println("Silver Selected.");
            }
        });
        JRadioButtonMenuItem steel = new JRadioButtonMenuItem("Steel");
        steel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.STEEL;
                System.out.println("Steel Selected.");
            }
        });
        JRadioButtonMenuItem gold = new JRadioButtonMenuItem("Gold");
        gold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.GOLD;
                System.out.println("Gold Selected.");
            }
        });
        JRadioButtonMenuItem perfectGold = new JRadioButtonMenuItem("Perfect Gold");
        perfectGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.PERFECT_GOLD;
                System.out.println("Perfect Gold Selected.");
            }
        });
        JRadioButtonMenuItem mithril = new JRadioButtonMenuItem("Mithril");
        mithril.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.MITHRIL;
                System.out.println("Mithril Selected.");
            }
        });
        JRadioButtonMenuItem adamant = new JRadioButtonMenuItem("Adamant");
        adamant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.ADAMENT;
                System.out.println("Adamant Selected.");
            }
        });
        JRadioButtonMenuItem obsidian = new JRadioButtonMenuItem("Obsidian");
        obsidian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.OBSIDIAN;
                System.out.println("Obsidian Selected.");
            }
        });
        JRadioButtonMenuItem rune = new JRadioButtonMenuItem("Rune");
        rune.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.superheat.barType = BarType.RUNE;
                System.out.println("Rune Selected.");
            }
        });

        // set selected
        switch (p.superheat.barType) {
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
