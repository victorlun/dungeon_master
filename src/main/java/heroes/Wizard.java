package heroes;

import items.WeaponType;

public class Wizard extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(1, 1, 8);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 1, 5);

    public Wizard (String name){
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Staff);
        addToValidWeaponType(WeaponType.Wand);
    }

    @Override
    public void levelUp() {
        setLevel(getLevel() +1 );
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }
    @Override
    public String toString() {
        return "{Wizard} " + super.toString() + " Level attributes: " + attributes(this) + "\n    Equipment: " + equipment.toString();
    }
}
