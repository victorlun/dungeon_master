package items;

import heroes.Barbarian;
import heroes.Wizard;
import heroes.HeroAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    public void testRequiredLvlWeapon() {
        Barbarian barbarian = new Barbarian("Gwedd");
        Weapon frostmourne = new Weapon("Frostmourne", 12, Slot.Weapon, WeaponType.Sword, 100);

        assertThrows(IllegalArgumentException.class, () -> barbarian.equipWeapon(frostmourne));
    }
    @Test
    public void testRequiredLvlArmor() {
        Wizard wizard = new Wizard("Schanke");
        Armor aLovelyPinkDress = new Armor("A lovely pink dress", 2, Slot.Body, ArmorType.Cloth, new HeroAttribute(0, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> wizard.equipArmor(aLovelyPinkDress));
    }
    @Test
    public void testValidWeaponType() {
        Wizard wizard = new Wizard("Schanke");
        Weapon frostmourne = new Weapon("Frostmourne", 1, Slot.Weapon, WeaponType.Sword, 100);
        assertThrows(IllegalArgumentException.class, () -> wizard.equipWeapon(frostmourne));
    }
    @Test
    public void testValidArmorType() {
        Wizard wizard = new Wizard("Schanke");
        Armor stormrageRaiment = new Armor("Stormrage Raiment", 1, Slot.Body, ArmorType.Leather, new HeroAttribute(7, 7, 16));

       assertThrows(IllegalArgumentException.class, () -> wizard.equipArmor(stormrageRaiment));
    }
    @Test
    public void testWeaponCreation_name(){
        Weapon frostmourne = new Weapon("Frostmourne", 10, Slot.Weapon, WeaponType.Sword, 50);
        assertEquals(frostmourne.getName(), "Frostmourne");
    }
    @Test
    public void testWeaponCreation_level(){
        Weapon frostmourne = new Weapon("Frostmourne", 10, Slot.Weapon, WeaponType.Sword, 50);
        assertEquals(frostmourne.getRequiredLevel(), 10);
    }
    @Test
    public void testWeaponCreation_slot(){
        Weapon frostmourne = new Weapon("Frostmourne", 10, Slot.Weapon, WeaponType.Sword, 50);
        assertEquals(Slot.Weapon, frostmourne.getSlot());
    }
    @Test
    public void testWeaponCreation_type(){
        Weapon frostmourne = new Weapon("Frostmourne", 10, Slot.Weapon, WeaponType.Sword, 50);
        assertEquals(WeaponType.Sword, frostmourne.getType());
    }
    @Test
    public void testWeaponCreation_damage(){
        Weapon frostmourne = new Weapon("Frostmourne", 10, Slot.Weapon, WeaponType.Sword, 50);
        assertEquals(50, frostmourne.getDamage());
    }
    @Test
    public void testArmorCreation_name(){
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        assertEquals("A shattred Monocle", aShattredMonocole.getName());
    }
    @Test
    public void testArmorCreation_level(){
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        assertEquals(1, aShattredMonocole.getRequiredLevel());
    }
    @Test
    public void testArmorCreation_slot(){
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        assertEquals(Slot.Head, aShattredMonocole.getSlot());
    }
    @Test
    public void testArmorCreation_type(){
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        assertEquals(ArmorType.Cloth, aShattredMonocole.getArmorType());
    }
    @Test
    public void testArmorCreation_attribute(){
        Armor aShattredMonocole = new Armor("A shattred Monocle", 1 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        assertEquals(new HeroAttribute(1,1,1), aShattredMonocole.getArmorAttribute()
        );
    }

}
