package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class King extends Hero{
    String RESET = "\u001B[0m";
    String RED_TEXT = "\u001B[31m";

    String BLACK_BG = "\u001B[40m";
    public King(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAITAMA, name);
    }
    public void attack(Boss boss){

    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int saitamaChance = RPG_Game.random.nextInt(100);
        if (saitamaChance<10){
            System.out.println(RED_TEXT+BLACK_BG+ " INCREDIBLE KING SUMMONED SAITAMA "+RESET);
            boss.setHealth(boss.getHealth()-boss.getHealth());
        }
        else{
            System.out.println("king failed to summon saitama");
        }
    }
}
