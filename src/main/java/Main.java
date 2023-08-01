import heroes.*;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Victor");
        archer.levelUp();

        System.out.println(archer.toString());

        System.out.println(" ");
        System.out.println(" ");

      Barbarian barbarian = new Barbarian("Agnes");
      barbarian.levelUp();
      System.out.println(barbarian.toString());


      System.out.println(" ");
      System.out.println(" ");

      Swashbuckler swashbuckler = new Swashbuckler("Karin");
      swashbuckler.levelUp();
      System.out.println(swashbuckler.toString());


      System.out.println(" ");
      System.out.println(" ");

      Wizard wizard = new Wizard("Peter");
      wizard.levelUp();
      wizard.levelUp();
      System.out.println(wizard.toString());

    }
    }
