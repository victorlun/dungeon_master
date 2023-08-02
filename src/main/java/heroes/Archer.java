package heroes;
public class Archer  extends Hero {
    private static final HeroAttribute BASE_ATTRIBUTE = new HeroAttribute(1, 7, 1);
    private static final HeroAttribute LEVEL_UP_ATTRIBUTE = new HeroAttribute(1, 5, 1);
    public Archer (String name){
        super(name, BASE_ATTRIBUTE);
    }
    @Override
    public void levelUp() {
        this.level++;
        this.levelAttributes = this.levelAttributes.add(LEVEL_UP_ATTRIBUTE);
    }
    @Override
    public String toString() {
        return "{Archer} "+  super.toString()  +  " [Attributes]: " + attributes(this);
    }
}
