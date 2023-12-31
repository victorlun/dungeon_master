package heroes;
import items.*;
import java.util.*;
/*
* Abstract representation of a hero in the program.
 */
public abstract class Hero {
    private final String name;
    private int level = 1;
    protected HeroAttribute levelAttributes;
    protected Map<Slot, Item> equipment = new HashMap<>();
    private List<WeaponType> validWeaponTypes = new ArrayList<>();
    private List<ArmorType> validArmorTypes = new ArrayList<>();

    //Constructor
    public Hero (String name, HeroAttribute levelAttributes){
        this.name = name;
        this.levelAttributes = levelAttributes;
    }

    //Abstract methods for subclass implementation
    public abstract void levelUp();
    public abstract double calculateDamage (Hero hero);
    public abstract String getType();

    //Equip-methods with validity checks
    public void equipWeapon(Weapon weapon) throws IllegalArgumentException {
        if(weapon.getRequiredLevel() > level){
            throw new IllegalArgumentException("You are not high enough level for this weapon.");
        }
        if(!validWeaponTypes.contains(weapon.getType())){
            throw new IllegalArgumentException("You can't use this weapon type.");
        }
            equipment.put(Slot.Weapon, weapon);
    }
    public void equipArmor(Armor armor){
        if(armor.getRequiredLevel() > level){
            throw new IllegalArgumentException("You are not high enough level for this piece of armor.");
        }
        if(!validArmorTypes.contains(armor.getArmorType())) {
            throw new IllegalArgumentException("You can't use this armor type.");
        }
            equipment.put(armor.getSlot(), armor);
    }
    //Attribute methods
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
    //Basic getters and setters
    public String getName(){
        return this.name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }
    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }
    public void addToValidWeaponType(WeaponType weaponType){
        validWeaponTypes.add(weaponType);
    }
    public void addToValidArmorType(ArmorType armorType){
        validArmorTypes.add(armorType);
    }
    //Display method for a detailed view of the hero
    public  String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Class: ").append(getType()).append("\n");
        sb.append("Level: ").append(getLevel()).append("\n");
        sb.append("Total Strength: ").append(totalAttribute().getStrength()).append("\n");
        sb.append("Total Dexterity: ").append(totalAttribute().getDexterity()).append("\n");
        sb.append("Total Intelligence: ").append(totalAttribute().getIntelligence()).append("\n");
        sb.append("Damage: ").append(calculateDamage(this)).append("\n");
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Name: " + this.name + "\nLvl: " + this.level + "\nType: " + getType();
    }

}
