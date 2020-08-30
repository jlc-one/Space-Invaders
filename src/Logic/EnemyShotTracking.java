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
        if (Math.random() < 0.015) {
            while (true) {
                int r = rdm.nextInt(enemyTracking.getInvaders().size());
                Invader invader = enemyTracking.getInvaders().get(r);
                if (!invader.getObstructed()) {
                    EnemyShot shot = new EnemyShot(invader.getX(), invader.getY(), 1);
                    addEnemyShot(shot);
                    System.out.println("Enemy " + invader.getId() + " has shot");
                    break;
                }
            }
        }
    }



    //public



}
