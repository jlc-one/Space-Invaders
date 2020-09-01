package Logic;

import Assets.EnemyShot;
import Assets.Invader;

import java.util.ArrayList;
import java.util.Random;

public class EnemyShotTracking {

    Random rdm = new Random();

    private ArrayList<EnemyShot> enemyShots;
    private EnemyTracking enemyTracking;

    public ArrayList<EnemyShot> getEnemyShots() {
        return enemyShots;
    }

    public EnemyShotTracking(EnemyTracking enemyTracking) {
        enemyShots = new ArrayList<>();
        this.enemyTracking = enemyTracking;
    }

    private void addEnemyShot(EnemyShot shot) {
        enemyShots.add(shot);
    }

    public void shoot() {
        if (Math.random() < 0.010 && enemyShots.size() < 4) {
            while (true) {
                int r = rdm.nextInt(enemyTracking.getInvaders().size());
                int s = rdm.nextInt(3);
                Invader invader = enemyTracking.getInvaders().get(r);
                if (!invader.getObstructed()) {
                    EnemyShot shot = new EnemyShot(invader.getX() + 17, invader.getY(), s);
                    //addEnemyShot(shot);
                    //System.out.println("Invader " + invader.getId() + " has shot");
                    break;
                }
            }
        }
    }

    public void removeShot() {
        for (int i = 0; i < enemyShots.size(); ++i) {
            if (!enemyShots.get(i).getAlive()) {
                enemyShots.remove(i);
            }
        }
    }



    //public



}
