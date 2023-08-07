package heroes;
import items.*;
import java.util.*;

public abstract class Hero {
    private final String name;
    private int level = 1;
    public HeroAttribute levelAttributes;
    public Map<Slot, Item> equipment = new HashMap<>();
    public List<WeaponType> validWeaponTypes = new ArrayList<>();
    public List<ArmorType> validArmorTypes = new ArrayList<>();

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
        if(!validArmorTypes.contains(armor.getArmorType())) {
            throw new IllegalArgumentException("You can't use this armor type.");
        }
        else{
            equipment.put(slot, armor);
        }
    }
    public abstract double calculateDamage (Hero hero);
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
        return "Name: " + this.name + "\nLvl: " + this.level + "\nType: " + getType();
    }

    public int getLevel() {
        return level;
    }
    public abstract String getType();
    public void setLevel(int level) {
        this.level = level;
    }
    public void addToValidWeaponType(WeaponType weaponType){
        validWeaponTypes.add(weaponType);
    }
    public void addToValidArmorType(ArmorType armorType){
        validArmorTypes.add(armorType);
    }
    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }
    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }
    public  String display(Hero hero){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Class: ").append(hero.getType()).append("\n");
        sb.append("Level: ").append(getLevel()).append("\n");
        sb.append("Total Strength: ").append(totalAttribute().getStrength()).append("\n");
        sb.append("Total Dexterity: ").append(totalAttribute().getDexterity()).append("\n");
        sb.append("Total Intelligence: ").append(totalAttribute().getIntelligence()).append("\n");
        sb.append("Damage: ").append(calculateDamage(this)).append("\n");
        return sb.toString();
    }

}
