package kg.geeks.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.REVIVE, name);
    }
    @Override
    public void attack(Boss boss){

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                System.out.println("Witcher uses his power to revive " + hero.getName());
                hero.setHealth(getHealth());
                setHealth(0);
                break;
            }
        }
    }
}

