package heroes;

import items.ArmorType;
import items.WeaponType;

public class Archer  extends Hero {
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

    public static HeroAttribute getBaseAttribute() {
        return BASE_ATTRIBUTE;
    }

    @Override
    public String toString() {
        return "{Archer} "+  super.toString()  +  " [Attributes]: " + attributes(this);
    }

}

