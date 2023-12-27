package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Nen_User extends Hero {
    private boolean damageIncreased = false;

    public Nen_User(int health, int damage, String name) {
        super(health, damage, SuperAbility.ADULT_FORM_TRANSFORMATION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (getHealth() < 100) {
            System.out.println(this.getName() + " transformed to adult form");
            setDamage(getDamage() + 250);
            damageIncreased=true;
            boss.setHealth(boss.getHealth()-this.getDamage());
            if(damageIncreased){
                this.setHealth(0);
            }
        }
    }
}