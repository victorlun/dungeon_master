import heroes.*;
import items.*;

public class Main {
    public static void main(String[] args) {
        // Weapon
        Weapon commonSword = new Weapon("Common Sword", 2, Slot.Weapon, WeaponType.Sword, 10);
        Weapon sunfuryPhoenixBow = new Weapon("Sunfury Phoenix Bow", 5, Slot.Weapon, WeaponType.Bow, 45);
        Weapon ashbringer = new Weapon("Ashbringer", 10, Slot.Weapon, WeaponType.Sword, 80);
        Weapon doomhammer = new Weapon("Doomhammer", 8, Slot.Weapon, WeaponType.Mace, 70);
        Weapon thoriDal = new Weapon("Thori'dal, the Stars' Fury", 10, Slot.Weapon, WeaponType.Bow, 90);
        Weapon frostmourne = new Weapon("Frostmourne", 12, Slot.Weapon, WeaponType.Sword, 100);
        Weapon sulfuras = new Weapon("Sulfuras, Hand of Ragnaros", 9, Slot.Weapon, WeaponType.Mace, 85);

        // Armor
        Armor aShattredMonocole = new Armor("A shattred Monocle", 0 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(0,0,0));
        Armor aLovelyPinkDress = new Armor("A lovely pink dress", 2, Slot.Body, ArmorType.Cloth, new HeroAttribute(0, 0, 5));
        Armor nemesisRobes = new Armor("Nemesis Robes", 7, Slot.Body, ArmorType.Cloth, new HeroAttribute(5, 10, 15));
        Armor stormrageRaiment = new Armor("Stormrage Raiment", 7, Slot.Body, ArmorType.Leather, new HeroAttribute(7, 7, 16));
        Armor judgmentArmor = new Armor("Judgment Armor", 8, Slot.Body, ArmorType.Plate, new HeroAttribute(10, 0, 20));
        Armor dragonstalkerArmor = new Armor("Dragonstalker Armor", 9, Slot.Body, ArmorType.Mail, new HeroAttribute(8, 2, 20));
        Armor helmOfDomination = new Armor("Helm of Domination", 10, Slot.Head, ArmorType.Plate, new HeroAttribute(8, 5, 25));



        Archer archer = new Archer("Victor");
        archer.levelUp();
        System.out.println(archer);

        Barbarian barbarian = new Barbarian("Agnes");
        barbarian.levelUp();
        System.out.println(barbarian);

        Swashbuckler swashbuckler = new Swashbuckler("Schanke");
        swashbuckler.levelUp();
        System.out.println(swashbuckler);

        Wizard wizard = new Wizard("Rudbeckius");
        wizard.levelUp();

        wizard.equipWeapon(commonSword);
        wizard.equipArmor(Slot.Body, aLovelyPinkDress);
        System.out.println(wizard);

        System.out.println(" ");


        System.out.println(aShattredMonocole);
        System.out.println(aLovelyPinkDress);
        System.out.println(frostmourne);

        System.out.print(swashbuckler.equipment.toString());

        wizard.totalAttribute(wizard);


    }
}
