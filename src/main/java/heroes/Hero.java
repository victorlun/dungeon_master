package heroes;
import items.*;
import java.util.*;

public abstract class Hero {
    private final String name;
    public int level = 1;
    protected HeroAttribute levelAttributes;
    private Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    private ArrayList<String> validWeaponTypes = new ArrayList<String>();
    private ArrayList<String> validArmorTypes = new ArrayList<String>();

    public Hero (String name, HeroAttribute levelAttributes){
        this.name = name;
        this.levelAttributes = levelAttributes;
    }
    public abstract void levelUp();
    public void equipWeapon(Weapon weapon){
        equipment.put(Slot.Weapon ,weapon);
    }
    public void equipArmor(Slot slot, Armor armor){
        equipment.put(slot, armor);
    }
    public int calculateDamage (Hero hero){
        return this.level * 5;
    }
    public HeroAttribute attributes(Hero hero){
        return this.levelAttributes;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return "[Name]: " + this.name;
    }
}
