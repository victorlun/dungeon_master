package heroes;
public class Barbarian  extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(5, 2, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(3, 2, 1);
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
        String type = "Barbarian";
        return super.toString() + "  " + "Class: " + type + "  "+ "Level attributes: " + attributes(this);
    }
}
