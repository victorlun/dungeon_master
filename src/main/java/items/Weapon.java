package items;

public class Weapon extends Item{
    private String type;

    public Weapon(String name,int requiredLevel, String slot, String type){
        super(name, requiredLevel, slot);
        this.type = type;
    }
}
