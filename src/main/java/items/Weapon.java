package items;

public class Weapon extends Item{

    private WeaponType type;
    private int damage;


    public Weapon(String name,int requiredLevel, Slot slot, WeaponType type, int damage){
        super(name, requiredLevel, slot);
        this.type = type;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "{WEAPON} [Name]:" +  getName() + " [Req.Lvl]:" + getRequiredLevel() + " [Slot]:" + getSlot() + " [Type]:" + type + " [Damage]:"+ damage;
    }
}
