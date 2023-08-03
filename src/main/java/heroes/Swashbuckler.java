package heroes;

import items.WeaponType;

public class Swashbuckler extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(2, 6, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 4, 1);


    public Swashbuckler(String name) {
        super(name, BASE_ATTRIBUTE);
        addToValidWeaponType(WeaponType.Dagger);
        addToValidWeaponType(WeaponType.Sword);
    }

    @Override
    public void levelUp() {
        setLevel(getLevel() +1 );
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }
    @Override
    public String toString() {
        return "{Swashbuckler} " + super.toString() + "  " +  " [Attributes]: " + attributes(this);
    }
}
