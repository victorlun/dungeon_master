package heroes;
import items.*;
import java.util.*;

public abstract class Hero {
    private final String name;
    private int level = 1;
    public HeroAttribute levelAttributes;
    public Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    public List<WeaponType> validWeaponTypes = new ArrayList<>();
    public ArrayList<String> validArmorTypes = new ArrayList<String>();

    public Hero (String name, HeroAttribute levelAttributes){
        this.name = name;
        this.levelAttributes = levelAttributes;
    }
    public abstract void levelUp();
    public void equipWeapon(Weapon weapon) throws IllegalArgumentException {
        if(weapon.getRequiredLevel() > level){
            throw new IllegalArgumentException("You are not high enough level for this weapon.");
        }
        if(!validWeaponTypes.contains(weapon.getType())){
            throw new IllegalArgumentException("You can't use this weapon type.");
        }
        else{
            equipment.put(Slot.Weapon, weapon);
        }
    }
    public void equipArmor(Slot slot, Armor armor){
        if(armor.getRequiredLevel() > level){
            throw new IllegalArgumentException("You are not high enough level for this piece of armor.");
        }
        else{
            equipment.put(slot, armor);
        }
    }
    public int calculateDamage (Hero hero){
        return this.level * 5;
    }
    public HeroAttribute attributes(Hero hero){
        return this.levelAttributes;
    }
    public HeroAttribute totalAttribute() {
        HeroAttribute totalAttributes = new HeroAttribute(this.levelAttributes.getStrength(), this.levelAttributes.getDexterity(), this.levelAttributes.getIntelligence());

        for (Map.Entry<Slot, Item> entry : equipment.entrySet()) {
            Item item = entry.getValue();
            if (item instanceof Armor) {
                totalAttributes = totalAttributes.addFromArmor(((Armor)item).getArmorAttribute());
            }
        }
        return totalAttributes;
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
    public void addToValidWeaponType(WeaponType weaponType){
        validWeaponTypes.add(weaponType);
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }
}
