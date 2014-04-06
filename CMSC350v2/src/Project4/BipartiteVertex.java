/*
 * CMSC350 Project 4 Stephen Drollinger Valimere@gmail.com DATE 15 December 2013
 * NetBeans IDE 7.4
 * part of code used from instructor provided documentation
 */
package Project4;

public class BipartiteVertex implements Displayable {

    private static final int INCREMENT = 100, MAX_X = 500;
    private static int nextX = INCREMENT, nextY = INCREMENT;
    private String name;
    private int x, y;

    BipartiteVertex(String name, int x, int y) {
        this.name = name;
        x = nextX;
        y = nextY;
        nextX += INCREMENT;
        if (nextX == MAX_X) {
            nextX = INCREMENT;
            nextY += INCREMENT;
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getName() {
        return name;
    }

    private static class LeftVertex {

        public LeftVertex() {
        }
    }

    private static class RightVertex {

        public RightVertex() {
        }
    }

}
