package heroes;

import java.util.ArrayList;

public class Hero {
    private String name;
    public int level = 1;

    protected HeroAttribute levelAttributes;
    //public ArrayList<Integer> levelAttributes = new ArrayList<Integer>();
    private ArrayList<String> equipment = new ArrayList<String>();
    private ArrayList<String> validWeaponTypes = new ArrayList<String>();
    private ArrayList<String> validArmorTypes = new ArrayList<String>();

    public Hero (String name, HeroAttribute levelAttributes){
        this.name = name;
        this.levelAttributes = levelAttributes;
    }
    public void levelUp(){
    }
    public void equipWeapon(String nameOfWeapon){
        equipment.add(nameOfWeapon);
    }
    public void equipArmor(String nameOfArmor){
        equipment.add(nameOfArmor);
    }
    public int calculateDamage (Hero hero){
        return this.level * 5;
    }
    public HeroAttribute attributes(Hero hero){
        return this.levelAttributes;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}
