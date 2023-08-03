package heroes;
import items.*;
import java.util.*;

public abstract class Hero {
    private final String name;
    private int level = 1;
    public HeroAttribute levelAttributes;
    public Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    private ArrayList<String> validWeaponTypes = new ArrayList<String>();
    public ArrayList<String> validArmorTypes = new ArrayList<String>();

    public Hero (String name, HeroAttribute levelAttributes){
        this.name = name;
        this.levelAttributes = levelAttributes;
    }
    public abstract void levelUp();
    public void equipWeapon(Weapon weapon) {
        if (this.level >= weapon.getRequiredLevel()) {
            equipment.put(Slot.Weapon, weapon);
        } else {
            System.out.println("  You can't equip that weapon yet!" +  System.lineSeparator()+ "  You need to be atleast lvl " + weapon.getRequiredLevel());
        }
    }
    public void equipArmor(Slot slot, Armor armor){
        if(this.level >= armor.getRequiredLevel()){
            equipment.put(slot, armor);
        }
        else{
            System.out.println("You can't equip that armor yet! \n You need to be atleast lvl" + armor.getRequiredLevel());
        }
    }
    public int calculateDamage (Hero hero){
        return this.level * 5;
    }
    public HeroAttribute attributes(Hero hero){
        return this.levelAttributes;
    }
    public HeroAttribute totalAttribute(Hero hero){
        return this.levelAttributes; //+ equippedArmorAttribute
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return "[Name]: " + this.name + " [Lvl]:" + this.level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
