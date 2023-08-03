package items;

public class Weapon extends Item{

    private WeaponType type;
    private int damage;


    public Weapon(String name,int requiredLevel, Slot slot, WeaponType type, int damage){
        super(name, requiredLevel, slot);
        this.type = type;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public WeaponType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\n  [Name]:" +  getName() + " [Req.Lvl]:" + getRequiredLevel() + " [Slot]:" + getSlot() + " [Type]:" + type + " [Damage]:"+ damage;
    }
}
