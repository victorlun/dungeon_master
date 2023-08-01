package heroes;

import heroes.Hero;

public class Barbarian  extends Hero {
    private final String type = "Barbarian";
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(5, 2, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(3, 2, 1);
    private int strength = 5;
    private int dexterity = 2;
    private int intelligence = 1;

    public Barbarian(String name){
        super(name, BASE_ATTRIBUTE);
    }

    @Override
    public void levelUp() {
        this.level++;
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }

    @Override
    public String toString() {
        return super.toString() + "  " + "Class: " + type + "  "+ "Level attributes: " + attributes(this);
    }

}
