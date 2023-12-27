package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class Samurai extends Hero{
    public Samurai(int health, int damage, String name) {
        super(health, damage, SuperAbility.SHURIKEN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int typeOfShuriken = RPG_Game.random.nextInt(8) + 2;
        if (typeOfShuriken<=5){
            System.out.println("Samurai threw an shuriken with vaccine");
            boss.setHealth(boss.getHealth()+50);
        }
        if (typeOfShuriken>=5){
            System.out.println("Samurai threw an poison shuriken");
            boss.setHealth(boss.getHealth()-50);
        }
    }
}
