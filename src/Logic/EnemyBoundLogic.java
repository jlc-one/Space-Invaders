package Logic;

import Assets.Invader;

import java.util.ArrayList;

public class EnemyBoundLogic {

    public static int bottomRowCalculate(ArrayList<Invader> invaders) {
        int bottomMost = 4;
        for (int i = 0; i < invaders.size(); ++i) {
            if (invaders.get(i).getRow() < bottomMost) {
                return invaders.get(i).getRow();
            }
        }
        return bottomMost;
    }

    public static int leftColumnCalculate(ArrayList<Invader> invaders) {
        int leftMost = 10;
        for (int i = 0; i < invaders.size(); ++i) {
            if (invaders.get(i).getCol() < leftMost) {
                leftMost = invaders.get(i).getCol();
                if (leftMost == 0) {
                    return 0;
                }
            }
        }
        return leftMost;
    }

    public static int rightColumnCalculate(ArrayList<Invader> invaders) {
        int rightMost = 0;
        for (int i = 0; i < invaders.size(); ++i) {
            if (invaders.get(i).getCol() > rightMost) {
                rightMost = invaders.get(i).getCol();
                if (rightMost == 10) {
                    return 10;
                }
            }
        }
        return rightMost;
    }




}
