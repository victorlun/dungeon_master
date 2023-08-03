package heroes;

import items.Armor;
import items.ArmorType;
import items.Slot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    //Archer-tests
    @Test
    public void archerNameTest(){
        Archer archer = new Archer("Victor");
        assertEquals("Victor", archer.getName());
    }
    @Test
    public void archerLevelTest(){
        Archer archer = new Archer("Victor");
        archer.levelUp();
        archer.levelUp();
        archer.levelUp();

        assertEquals(4, archer.getLevel());
    }
    @Test
    public void archerAttributeTest(){
       Archer archer = new Archer("Victor");
       archer.levelUp();
       assertEquals(new HeroAttribute(2,12,2), archer.attributes(archer));
    }
    //Barbarian-tests
    @Test
    public void barbarianNameTest(){
        Barbarian barbarian = new Barbarian("Agnes");
        assertEquals("Agnes", barbarian.getName());
    }
    @Test
    public void barbarianLevelTest(){
        Barbarian barbarian = new Barbarian("Agnes");
        barbarian.levelUp();
        barbarian.levelUp();
        barbarian.levelUp();

        assertEquals(4, barbarian.getLevel());
    }
    @Test
    public void barbarianAttributeTest(){
        Barbarian barbarian = new Barbarian("Agnes");
        barbarian.levelUp();
        assertEquals(new HeroAttribute(8,4,2), barbarian.attributes(barbarian));
    }
    //Swashbuckler-tests
    @Test
    public void swashbucklerNameTest(){
        Swashbuckler swashbuckler = new Swashbuckler("Lionel");
        assertEquals("Lionel", swashbuckler.getName());
    }
    @Test
    public void swashbucklerLevelTest(){
        Swashbuckler swashbuckler = new Swashbuckler("Lionel");
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        assertEquals(4, swashbuckler.getLevel());
    }
    @Test
    public void swashbucklerAttributeTest(){
        Swashbuckler swashbuckler = new Swashbuckler("Schanke");
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        swashbuckler.levelUp();
        assertEquals(new HeroAttribute(5,18,4), swashbuckler.attributes(swashbuckler));
    }
    //Wizard-tests
    @Test
    public void wizardNameTest(){
        Wizard wizard = new Wizard("Rudbeckius");
        assertEquals("Rudbeckius", wizard.getName());
    }
    @Test
    public void wizardLevelTest(){
        Wizard wizard = new Wizard ("Rudbeckius");
        wizard.levelUp();
        wizard.levelUp();
        wizard.levelUp();
        assertEquals(4, wizard.getLevel());
    }
    @Test
    public void wizardAttributeTest(){
        Wizard wizard = new Wizard ("Rudbeckius");
        wizard.levelUp();
        wizard.levelUp();
        wizard.levelUp();
        assertEquals(new HeroAttribute(4,4,23 ), wizard.attributes(wizard));
    }
    @Test
    public void heroTotalAttributeTest(){
        Wizard wizard = new Wizard("Rudbeckius");
        wizard.levelUp();
        Armor aLovelyPinkDress = new Armor("A lovely pink dress", 2, Slot.Body, ArmorType.Cloth, new HeroAttribute(0, 0, 5));
        Armor aShattredMonocole = new Armor("A shattred Monocle", 0 ,Slot.Head, ArmorType.Cloth, new HeroAttribute(1,1,1));
        wizard.equipArmor(Slot.Body, aLovelyPinkDress);
        wizard.equipArmor(Slot.Head, aShattredMonocole);

        assertEquals(new HeroAttribute(3,3,19), wizard.totalAttribute());


    }
}


