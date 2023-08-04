package heroes;

import items.ArmorType;
import items.Slot;
import items.Weapon;
import items.WeaponType;

import java.text.DecimalFormat;

public class Barbarian  extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(5, 2, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(3, 2, 1);
    public Barbarian(String name){
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Sword);
        addToValidWeaponType(WeaponType.Mace);
        addToValidWeaponType(WeaponType.Hatchet);

        addToValidArmorType(ArmorType.Mail);
        addToValidArmorType(ArmorType.Plate);
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
        double strength = totalAttribute().getStrength();
        double damageAttributes = (strength * lvl) / 10 ;
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
        return "{Barbarian} "+ super.toString() +  " [Attributes]: " + attributes(this);
    }

    @Override
    public String getType() {
        return "Barbarian";
    }
}

