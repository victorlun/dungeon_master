package heroes;

import items.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    //Archer-tests
    @Test
    public void testArcher_name(){
        Archer archer = new Archer("Victor");
        assertEquals("Victor", archer.getName());
    }
    @Test
    public void testArcher_level(){
        Archer archer = new Archer("Victor");
        archer.levelUp();
        archer.levelUp();
        archer.levelUp();
        assertEquals(4, archer.getLevel());
    }
    @Test
    public void testArcher_attributes(){
       Archer archer = new Archer("Victor");
       archer.levelUp();
       assertEquals(new HeroAttribute(2,12,2), archer.attributes(archer));
    }
    //Barbarian-tests
    @Test
    public void testBarbarian_name(){
        Barbarian barbarian = new Barbarian("Agnes");
        assertEquals("Agnes", barbarian.getName());
    }
    @Test
    public void testBarbarian_level(){
        Barbarian barbarian = new Barbarian("Agnes");
        barbarian.levelUp();
        barbarian.levelUp();
        barbarian.levelUp();

        assertEquals(4, barbarian.getLevel());
    }
    @Test
    public void testBarbarian_attributes(){
        Barbarian barbarian = new Barbarian("Agnes");
        barbarian.levelUp();
        assertEquals(new HeroAttribute(8,4,2), barbarian.attributes(barbarian));
    }
    @Test
    public void testBarbarian_armor_types() {
        Barbarian barbarian = new Barbarian("Kungen");
        assertEquals(Arrays.asList(ArmorType.Mail, ArmorType.Plate), barbarian.getValidArmorTypes());
    }
    //Swashbuckler-tests
    @Test
    public void testSwashbuckler_name(){
        Swashbuckler swashbuckler = new Swashbuckler("Lionel");
        assertEquals("Lionel", swashbuckler.getName());
    }
    @Test
    public void testSwashbuckler_level(){
        Swashbuckler swashbuckler = new Swashbuckler("Lionel");
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        assertEquals(4, swashbuckler.getLevel());
    }
    @Test
    public void testSwashbuckler_attributes(){
        Swashbuckler swashbuckler = new Swashbuckler("Schanke");
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        assertEquals(new HeroAttribute(5,18,4), swashbuckler.attributes(swashbuckler));
    }
    //Wizard-tests
    @Test
    public void testWizard_name(){
        Wizard wizard = new Wizard("Rudbeckius");
        assertEquals("Rudbeckius", wizard.getName());
    }
    @Test
    public void testWizard_level(){
        Wizard wizard = new Wizard ("Rudbeckius");
        wizard.levelUp();
        wizard.levelUp();
        wizard.levelUp();
        assertEquals(4, wizard.getLevel());
    }
    @Test
    public void testWizard_attributes(){
        Wizard wizard = new Wizard ("Rudbeckius");
        wizard.levelUp();
        wizard.levelUp();
        wizard.levelUp();
        assertEquals(new HeroAttribute(4,4,23 ), wizard.attributes(wizard));
    }
    @Test
    public void testWizard_armor_types() {
        Wizard wizard = new Wizard("Rudbeckius");
        assertEquals(List.of(ArmorType.Cloth), wizard.getValidArmorTypes());
    }
    @Test
    public void testTotalAttributes_no_armor_equipped(){
        Wizard wizard = new Wizard("Rudbeckius");
        wizard.levelUp();
        assertEquals(new HeroAttribute(2,2,13), wizard.totalAttribute());
    }
    @Test
    public void testTotalAttributes_one_armor_equipped(){
        Wizard wizard = new Wizard("Rudbeckius");
        wizard.levelUp();
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1, Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        wizard.equipArmor(aShattredMonocole.getSlot(), aShattredMonocole);
        assertEquals(new HeroAttribute(3,3,14), wizard.totalAttribute());
    }
    @Test
    public void testTotalAttributes_two_armor_equipped(){
        Wizard wizard = new Wizard("Rudbeckius");

        Armor aLovelyPinkDress = new Armor("A lovely pink dress", 1, Slot.Body, ArmorType.Cloth, new HeroAttribute(0, 0, 5));
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1, Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        wizard.equipArmor(Slot.Body, aLovelyPinkDress);
        wizard.equipArmor(Slot.Head, aShattredMonocole);

        assertEquals(new HeroAttribute(2,2,14), wizard.totalAttribute());
    }
    @Test
    public void testTotalAttributes_replaced_armor_equipped(){
        Wizard wizard = new Wizard("Rudbeckius");
        wizard.levelUp();
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1, Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        Armor pristinePairOfGlasses = new Armor("Pristine pair of glasses", 1, Slot.Head, ArmorType.Cloth, new HeroAttribute(2,2,2));
        wizard.equipArmor(aShattredMonocole.getSlot(), aShattredMonocole);
        wizard.equipArmor(pristinePairOfGlasses.getSlot(), pristinePairOfGlasses);
        assertEquals(new HeroAttribute(4,4,15), wizard.totalAttribute());
    }
    @Test
    public void testValidWeaponTypes() {
        Wizard wizard = new Wizard("Rudbeckius");
        assertEquals(Arrays.asList(WeaponType.Staff, WeaponType.Wand), wizard.getValidWeaponTypes());
    }
    @Test
    public void testDamageCalculation_no_weapon_equipped(){
        Archer archer = new Archer("Virre");
        double result= archer.calculateDamage(archer);
        assertEquals(1.01, result);
    }
    @Test
    public void testDamageCalculation_weapon_equipped(){
        Archer archer = new Archer("Virre");
        Weapon semiFunctionalBow= new Weapon("Semi-Functional Bow", 1, Slot.Weapon, WeaponType.Bow, 10);
        archer.equipWeapon(semiFunctionalBow);
        double result= archer.calculateDamage(archer);
        assertEquals(10.07, result);
    }
    @Test
    public void testDamageCalculation_replaced_weapon_equipped(){
        Archer archer = new Archer("Virre");
        Weapon semiFunctionalBow= new Weapon("Semi-Functional Bow", 1, Slot.Weapon, WeaponType.Bow, 10);
        Weapon veryFunctionalBow= new Weapon("Very Functional Bow", 1, Slot.Weapon, WeaponType.Bow, 100);
        archer.equipWeapon(semiFunctionalBow);
        archer.equipWeapon(veryFunctionalBow);
        double result= archer.calculateDamage(archer);
        assertEquals(100.7, result);
    }
    @Test
    public void testDamageCalculation_weapon_and_armor_equipped(){
        Archer archer = new Archer("Virre");
        Weapon sunfuryPhoenixBow = new Weapon("Sunfury Phoenix Bow", 1, Slot.Weapon, WeaponType.Bow, 45);
        Armor huntersChest = new Armor("Hunter's Chest", 1, Slot.Body, ArmorType.Leather, new HeroAttribute(0, 5, 0));
        archer.equipWeapon(sunfuryPhoenixBow);
        archer.equipArmor(Slot.Body, huntersChest);
        double result= archer.calculateDamage(archer);

        assertEquals(45.54, result);
    }
    @Test
    public void testHeroDisplay(){
        Wizard wizard = new Wizard("Schanke");
        wizard.levelUp();
        assertEquals("Name: Schanke\nClass: Wizard\nLevel: 2\nTotal Strength: 2\nTotal Dexterity: 2\nTotal Intelligence: 13\nDamage: 1.03\n", wizard.display());
    }
}


