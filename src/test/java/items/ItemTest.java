package items;

import heroes.Barbarian;
import heroes.HeroAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    public void tooHighLevelWeaponTest(){
        Barbarian barbarian = new Barbarian("Gwedd");
        Weapon frostmourne = new Weapon("Frostmourne", 12, Slot.Weapon, WeaponType.Sword, 100);

        assertThrows(IllegalArgumentException.class, () -> {
            barbarian.equipWeapon(frostmourne);
        });
    }

    @Test
    public void tooHighLevelArmorTest(){
        Barbarian wizard = new Barbarian("Schanke");
        Armor aLovelyPinkDress = new Armor("A lovely pink dress", 2, Slot.Body, ArmorType.Cloth, new HeroAttribute(0, 0, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            wizard.equipArmor(aLovelyPinkDress.getSlot() ,aLovelyPinkDress);
    });
}
}