package bsu.comp152;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testBetween() {
        Rectangle r1 = new Rectangle(0,0,30,30);
        Rectangle r2 = new Rectangle(0,0,20,20);
        assertTrue(r1.doesHit(r2));
    }

    public int randInt(int s, int e) {
        int range = (e - s);
        int v = (int)(Math.random()*range);
        v+=s;
        return v;
    }

    ArrayList<Rectangle[]> getOverlap(int n) {
        ArrayList<Rectangle[]> rects = new ArrayList<Rectangle[]>();
        for(int i = 0; i < n; i++) {
            int rand1 = randInt(i*20,(i+1)*20);
            int rand2 = randInt(i*20,(i+1)*20);
            int rand3 = randInt(i*20,i*20 + 10);
            Rectangle r1 = new Rectangle(0,0,rand1, rand2);
            Rectangle r2 = new Rectangle(0,0,rand1, rand3);
            rects.add(new Rectangle[] {r1, r2});
        }
        return rects;
    }

    ArrayList<Rectangle[]> getNoOverlap(int n) {
        ArrayList<Rectangle[]> rects = new ArrayList<Rectangle[]>();
        for(int i = 0; i < n; i++) {
            int rand1 = randInt(i*20,(i+1)*20);
            int rand2 = randInt(i*20,(i+1)*20);
            int rand3 = randInt((i+2)*20, (i+3)*20);
            int rand4 = randInt((i+4)*20, (i+5)*20);
            int rand5 = randInt((i+6)*20, (i+7)*20);
            int rand6 = randInt((i+8)*20, (i+9)*20);
            Rectangle r1 = new Rectangle(0,0,rand1, rand2);
            Rectangle r2 = new Rectangle(rand3,rand4,rand5, rand6);
            rects.add(new Rectangle[] {r1, r2});
        }
        return rects;
    }

    @Test
    public void testOverlap() {
        ArrayList<Rectangle[]> allrects = getOverlap(10);
        for(Rectangle[] arr : allrects) {
            assertTrue(arr[0].doesHit(arr[1]));
        }
    }


    @Test
    public void testNoOverlap() {
        ArrayList<Rectangle[]> allrects = getNoOverlap(10);
        for(Rectangle[] arr : allrects) {
            assertFalse(arr[0].doesHit(arr[1]));
        }
    }

}
