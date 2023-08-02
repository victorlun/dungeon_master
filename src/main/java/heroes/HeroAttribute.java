package heroes;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    public HeroAttribute add(HeroAttribute heroAttribute){
        return new HeroAttribute(
                this.strength + heroAttribute.strength,
                this.dexterity + heroAttribute.dexterity,
                this.intelligence + heroAttribute.intelligence
        );
    }

    @Override
    public String toString() {
        return "Str:" + this.strength + " Dex:" + this.dexterity + " Int:" + this.intelligence;
    }
}
