package heroes;

public class Wizard extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(1, 1, 8);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 1, 5);


    public Wizard (String name){
        super(name, BASE_ATTRIBUTE);
    }

    @Override
    public void levelUp() {
        this.level++;
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }
    @Override
    public String toString() {
        String type = "Wizard";
        return super.toString() + "  " + "Class: " + type + "  "+ "Level attributes: " + attributes(this);
    }
}
