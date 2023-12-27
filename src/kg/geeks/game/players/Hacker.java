package kg.geeks.game.players;
import kg.geeks.game.general.RPG_Game;

public class Hacker extends Hero {
    private int healthStolenPerRound;

    public Hacker(int health, int damage, int healthStolenPerRound, String name) {
        super(health, damage, SuperAbility.HEALTH_STEAL, name);
        this.healthStolenPerRound = healthStolenPerRound;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.roundNumber % 2 == 0) {
            int stolenHealth = Math.min(boss.getHealth(), healthStolenPerRound);
            boss.setHealth(boss.getHealth() - stolenHealth);

            Hero receiver = findRandomAliveHeroExceptHacker(heroes);
            if (receiver != null) {
                receiver.setHealth(receiver.getHealth() + stolenHealth);
                System.out.println(this.getName() + " stole " + stolenHealth +
                        " health from " + boss.getName() + " and gave it to " + receiver.getName());
            }
        }
    }

    private Hero findRandomAliveHeroExceptHacker(Hero[] heroes) {
        Hero[] aliveHeroes = findAliveHeroesExceptHacker(heroes);
        if (aliveHeroes.length > 0) {
            int randomIndex = RPG_Game.random.nextInt(aliveHeroes.length);
            return aliveHeroes[randomIndex];
        }
        return null;
    }

    private Hero[] findAliveHeroesExceptHacker(Hero[] heroes) {
        int countAliveHeroes = 0;
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                countAliveHeroes++;
            }
        }

        Hero[] aliveHeroes = new Hero[countAliveHeroes];
        int index = 0;
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                aliveHeroes[index++] = hero;
            }
        }

        return aliveHeroes;
    }
}