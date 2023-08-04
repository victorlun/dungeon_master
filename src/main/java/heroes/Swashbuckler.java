package heroes;

import items.ArmorType;
import items.Slot;
import items.Weapon;
import items.WeaponType;

import java.text.DecimalFormat;

public class Swashbuckler extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(2, 6, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 4, 1);
    private String type = "Swashbuckler";


    public Swashbuckler(String name) {
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Dagger);
        addToValidWeaponType(WeaponType.Sword);

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
        double dext = totalAttribute().getDexterity();
        double damageAttributes = (dext * lvl) / 10 ;
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
        return "{Swashbuckler} " + super.toString() + "  " +  " [Attributes]: " + attributes(this);
    }

    @Override
    public String getType() {
        return type;
    }
}
