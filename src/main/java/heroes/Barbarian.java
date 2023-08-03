package heroes;

import items.ArmorType;
import items.WeaponType;

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
    public String toString() {
        return "{Barbarian} "+ super.toString() +  " [Attributes]: " + attributes(this);
    }
}
