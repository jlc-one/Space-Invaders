package Logic;

import Assets.Invader;
import Main.Globals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class EnemyTracking {

    ArrayList<Invader> invaders;
    private int currentInvader = 0;

    public int getSize() {
        return invaders.size();
    }


    public EnemyTracking() {
        invaders = new ArrayList<>();
        for (int i = 0; i < 55; ++i) {
            int col = (i % 11);
            int row = (i / 11);
            Invader invader = new Invader(50 + (col * Globals.enemySpacing), 250 + (row * -Globals.enemySpacing));
            invader.setScore(scoreWorth(i));
            invader.setRow(row);
            invader.setCol(col);
            invader.setId(i);
            invaders.add(invader);
        }
    }

    public ArrayList<Invader> getInvaders() {
        return invaders;
    }

    private int scoreWorth(int n) {
        if (n < 22) {
            return 10;
        } else if (n < 44) {
            return 20;
        } else {
            return 30;
        }
    }

    public void moveNextInvader() {
        if (invaders.size() != 0) {
            if (currentInvader < invaders.size()) {
                Invader invader = invaders.get(currentInvader);
                if (invader.getAlive()) {
                    invader.moveX(invader.getMoveDirection() * Globals.enemyMovementPerFrame);
                    if (invader.getToMoveDown()) {
                        invader.moveY(Globals.enemyMovementDown);
                        invader.setToMoveDown(false);
                    }
                }
                ++currentInvader;
            } else {
                currentInvader = 0;
                checkBoundary();
                removeDeadInvaders();
            }
        }
    }

    private void checkBoundary() {
        if (invaders.get(0).getMoveDirection() == 1) {
            int col = EnemyBoundLogic.rightColumnCalculate(invaders);
            Invader invader = null;
            for (int i = 0; i < invaders.size(); ++i) {
                if (invaders.get(i).getCol() == col) {
                    invader = invaders.get(i);
                    break;
                }
            }
            if (invader.getX() > Globals.WIDTH - Globals.enemySidePadding) {
                changeDirection((short) -1);
            }

        } else {
            int col = EnemyBoundLogic.leftColumnCalculate(invaders);
            Invader invader = null;
            for (int i = 0; i < invaders.size(); ++i) {
                if (invaders.get(i).getCol() == col) {
                    invader = invaders.get(i);
                    break;
                }
            }
            if (invader.getX() < Globals.enemySidePadding) {
                changeDirection((short) 1);
            }
        }
    }

    private void changeDirection(short direction) {
        for (int i = 0; i < invaders.size(); ++i) {
            invaders.get(i).setMoveDirection(direction);
            invaders.get(i).setToMoveDown(true);
        }
    }

    private void removeDeadInvaders() {
        invaders.removeAll(invaders.stream()
                .filter(invader -> !invader.getAlive())
                .collect(Collectors.toList()));
    }


}
