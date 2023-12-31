package heroes;

import items.ArmorType;
import items.Slot;
import items.Weapon;
import items.WeaponType;

import java.text.DecimalFormat;

public class Archer extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(1, 7, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 5, 1);
    public Archer (String name){
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Bow);
        addToValidArmorType(ArmorType.Leather);
        addToValidArmorType(ArmorType.Mail);
    }
    @Override
    public void levelUp() {
        setLevel(getLevel() +1 );
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }
    @Override
    public double calculateDamage(Hero hero) {
        DecimalFormat df = new DecimalFormat("#.##");
        double lvl = getLevel();
        double dexterity = totalAttribute().getDexterity();
        double damageAttributes = (dexterity * lvl) / 10 ;
        Weapon weapon = (Weapon) equipment.get(Slot.Weapon);
        double damage;

        if(weapon == null){
            damage =  1 * (1 + (damageAttributes /100));
        }
        else{
            damage = (weapon.getDamage() * (1 + (damageAttributes /100)));
        }
        return Double.parseDouble(df.format(damage));
    }
    public String getType() {
        return "Archer";
    }
}

