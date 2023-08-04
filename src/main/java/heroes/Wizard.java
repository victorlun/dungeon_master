package heroes;

import items.ArmorType;
import items.Slot;
import items.Weapon;
import items.WeaponType;

import java.text.DecimalFormat;

public class Wizard extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(1, 1, 8);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 1, 5);

    public Wizard (String name){
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Staff);
        addToValidWeaponType(WeaponType.Wand);
        addToValidArmorType(ArmorType.Cloth);
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
        double intelligence = totalAttribute().getIntelligence();
        double damageAttributes = (intelligence * lvl) / 10 ;
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
    @Override
    public String toString() {
        return "{Wizard} " + super.toString() + " Level attributes: " + attributes(this) + "\n    Equipment: " + equipment.toString();
    }
    @Override
    public String getType() {
        return "Wizard";
    }
}
