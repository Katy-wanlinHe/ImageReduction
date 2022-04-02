import static org.junit.Assert.*;

import org.junit.Test;

//import QuadTreeNode.QuadName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;

public class QuadTreeNodeImplTest {
    private int[][] notPow;
    private int[][] allSameSmall;
    private int[][] allSameLarge;
    private int[][] notAllSameSmall;
    private int[][] notSameLarge;
    private int[][] singleElement;
    private int[][] mergeLarge;
    private int[][] beLeaf;
    private int[][] checkerSmall;
    private int[][] raggedSmallPow2;
    private int[][] raggedSmall;
    private int[][] raggedLargeNotPow2;
    private int[][] negativeSmall;
    private int[][] negativeLarge;
    private int[][] sample;
    private int[][] sizesample;
    private int[][] nullImage;
    private int[][] emptyImage = new int[0][0];
    private int[][] notSquare;
    private int[][] mergeSmall;

    @Before
    public void setupTestMazes() {
        notPow = new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {1, 0, 0},
        };
        
        allSameSmall = new int[][]{
            {1, 1},
            {1, 1},
        };
        
        mergeSmall = new int[][]{
            {1, 1},
            {1, 2},
        };
        
        notSquare = new int[][]{
            {1, 1},
            {1, 1},
            {1, 1},
            {1, 1},
        };
        
        raggedSmallPow2 = new int[][]{
            {1, 1},
            {1, 1, 1, 1},
        };
        
        raggedSmall = new int[][]{
            {1, 1},
            {1},
        };
        
        raggedLargeNotPow2 = new int[][]{
            {1, 2, 1, 2},
            {2, 1, 2, 1, 4},
            {1, 2, 1, 2, 1, 2, 1, 2},
            {2, 1, 2, 1},
        };
        
        allSameLarge = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
        };
        
        notAllSameSmall = new int[][]{
            {2, 4},
            {1, 3},
        };
        
        notSameLarge = new int[][]{
            {3, 4, 5, 6, 5, 3, 1, 1},
            {1, 3, 7, 8, 9, 4, 1, 1},
            {2, 3, 3, 6, 2, 6, 3, 2},
            {7, 8, 2, 4, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 1, 3, 4, 5},
        };
        
        mergeLarge = new int[][]{
            {3, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 3, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
        };
        
        singleElement = new int[][]{
            {1},
        };
        
        beLeaf = new int[][]{
            {1, 1, 3, 3, 2, 2, 2, 2},
            {1, 1, 3, 3, 2, 2, 2, 2},
            {7, 7, 1, 1, 2, 2, 2, 2},
            {7, 7, 1, 1, 2, 2, 2, 2},
            {4, 4, 5, 5, 1, 1, 1, 1},
            {4, 4, 5, 5, 1, 1, 4, 1},
            {7, 7, 1, 1, 1, 1, 1, 1},
            {7, 7, 1, 1, 1, 1, 1, 1},
        };
        
        checkerSmall = new int[][]{
            {1, 2, 1, 2},
            {2, 1, 2, 1},
            {1, 2, 1, 2},
            {2, 1, 2, 1},
        };
        
        negativeSmall = new int[][]{
            {-1, -1, -1, 2},
            {-1, -1, 2, -1},
            {-1, 2, -1, -1},
            {2, -1, -1, -1},
        };
        
        negativeLarge = new int[][]{
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
        };
        
        sample = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 7, 6, 4, 4},
            {2, 2, 2, 2, 5, 5, 4, 4},
            {2, 2, 2, 2, 3, 3, 3, 3},
            {2, 2, 2, 2, 3, 3, 3, 3},
        };
        
        sizesample = new int[][]{
            {1, 1, 1, 2},
            {1, 1, 1, 1},
            {2, 2, 1, 1},
            {2, 2, 1, 1},
        };


    }
    
    @Test(expected = IllegalArgumentException.class)
    public void notPowOf2() {
        QuadTreeNodeImpl.buildFromIntArray(notPow);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullError() {
        QuadTreeNodeImpl.buildFromIntArray(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setColorOutOfBoundNegative() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.setColor(-1, -1, 6);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setColorOutOfBoundPositiveOB() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.setColor(9, 12, 6);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setColorOutOfBoundEdge() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.setColor(8, 8, 6);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getColorOutOfBoundNegative1() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.getColor(-4, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getColorOutOfBoundNegative2() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.getColor(4, -1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getColorOutOfBoundPositive() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.getColor(19, 19);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getColorOutOfBoundEdge() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        test.getColor(8, 2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void raggedSmallPow2() {
        QuadTreeNodeImpl.buildFromIntArray(raggedSmallPow2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void raggedNotPow2() {
        QuadTreeNodeImpl.buildFromIntArray(raggedLargeNotPow2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalidTest1() {
        new QuadTreeNodeImpl(0, 0, 2, 2, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorInvalidTest2() {
        new QuadTreeNodeImpl(0, 0, 3, 7, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void notSquareTest() {
        QuadTreeNodeImpl.buildFromIntArray(notSquare);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void emptyImageTest() {
        QuadTreeNodeImpl.buildFromIntArray(emptyImage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullImageTest() {
        QuadTreeNodeImpl.buildFromIntArray(nullImage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void raggedSmallTest() {
        QuadTreeNodeImpl.buildFromIntArray(raggedSmall);
    }
    
    @Test
    public void allSameSmall() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(allSameSmall);
        assertEquals(1, (int) test.color);
        assertNull(test.bottomleft);
        assertNull(test.bottomright);
        assertNull(test.topleft);
        assertNull(test.topright);
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_RIGHT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT));
        assertEquals(2, test.getDimension());
        assertTrue(test.isLeaf());
        assertEquals(1, test.getSize());
        assertEquals(0.25, test.getCompressionRatio(), 0.01);
        assertArrayEquals(allSameSmall, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(allSameSmall[y][x], test.getColor(x, y));
            }
        }
        
        test.setColor(0, 0, 2);
        int [][] result = new int[][]{
            {2, 1},
            {1, 1},
        };
        assertNull(test.color);
        assertEquals(2, (int) test.topleft.color);
        assertArrayEquals(result, test.decompress());
    }
    
    @Test
    public void singleElement() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(singleElement);
        assertEquals(1, test.getColor(0, 0));
        assertNull(test.bottomleft);
        assertNull(test.bottomright);
        assertNull(test.topleft);
        assertNull(test.topright);
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_RIGHT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT));
        assertEquals(1, test.getDimension());
        assertTrue(test.isLeaf());
        assertEquals(1, test.getSize());
        assertEquals(1.00, test.getCompressionRatio(), 0.01);
        assertArrayEquals(singleElement, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(allSameSmall[y][x], test.getColor(x, y));
            }
        }
        
        test.setColor(0, 0, 2);
        int [][] result = new int[][]{
            {2},
        };
        assertArrayEquals(result, test.decompress());
    }
    
    @Test
    public void allSameLarge() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(allSameLarge);
        assertNull(test.bottomleft);
        assertNull(test.bottomright);
        assertNull(test.topleft);
        assertNull(test.topright);
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_RIGHT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_LEFT));
        assertNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT));
        assertEquals(8, test.dim);
        assertEquals(8, test.getDimension());
        assertTrue(test.isLeaf());
        assertEquals(1, test.getSize());
        double result = 1.00 / 64.00;
        assertEquals(result, test.getCompressionRatio(), 0.000001);
        assertArrayEquals(allSameLarge, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(allSameLarge[y][x], test.getColor(x, y));
            }
        }
        
        test.setColor(3, 6, 2);
        test.setColor(3, 5, 2);
        test.setColor(3, 4, 2);
        int [][] result2 = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
        };
        assertFalse(test.isLeaf());
        assertFalse(test.bottomleft.isLeaf());
        assertTrue(test.topright.isLeaf());
        assertEquals(1, test.getColor(5, 0));
        assertTrue(test.topleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertNull(test.color);
        assertEquals(1, (int) test.topright.color);
        assertNull(test.bottomleft.color);
        assertNull(test.bottomleft.topright.color);
        assertNull(test.bottomleft.bottomright.color);
        assertArrayEquals(result2, test.decompress());
    }
    
    @Test
    public void notSameSmall() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notAllSameSmall);
        assertNotEquals(null, test.bottomleft);
        assertNotEquals(null, test.bottomright);
        assertNotEquals(null, test.topleft);
        assertNotEquals(null, test.topright);
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_LEFT));
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_RIGHT));
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_LEFT));
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT));
        assertEquals(2, test.dim);
        assertEquals(2, test.getDimension());
        assertFalse(test.isLeaf());
        assertTrue(test.bottomleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertTrue(test.topleft.isLeaf());
        assertTrue(test.topright.isLeaf());
        assertEquals(5, test.getSize());
        assertEquals(1.25, test.getCompressionRatio(), 0.01);
        assertArrayEquals(notAllSameSmall, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(notAllSameSmall[y][x], test.getColor(x, y));
            }
        }
    }
    
    @Test
    public void notSameLarge() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        assertNull(test.color);
        assertEquals(1, (int) test.bottomleft.color);
        assertNotEquals(null, test.bottomright);
        assertNotEquals(null, test.topleft);
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.BOTTOM_RIGHT));
        assertNotNull(test.getQuadrant(QuadTreeNode.QuadName.TOP_LEFT));
        assertTrue(test.getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT)
                .getQuadrant(QuadTreeNode.QuadName.TOP_RIGHT).isLeaf());
        assertEquals(1, (int) test.topright.topright.color);
        assertEquals(8, test.dim);
        assertEquals(8, test.getDimension());
        assertFalse(test.isLeaf());
        assertTrue(test.bottomleft.isLeaf());
        assertFalse(test.bottomright.isLeaf());
        assertFalse(test.topleft.isLeaf());
        assertFalse(test.topright.isLeaf());
        assertTrue(test.topright.topright.isLeaf());
        assertEquals(61, test.getSize());
        double result = 61.00 / 64.00;
        assertEquals(result, test.getCompressionRatio(), 0.000001);
        assertArrayEquals(notSameLarge, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(notSameLarge[y][x], test.getColor(x, y));
            }
        }
    }
    
    @Test
    public void mergeLargeTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(mergeLarge);
        assertNull(test.color);
        assertEquals(1, (int) test.bottomleft.color);
        assertNotEquals(null, test.bottomright);
        assertNotEquals(null, test.topleft);
        assertEquals(1, (int) test.topright.topright.color);
        assertEquals(8, test.getDimension());
        assertFalse(test.isLeaf());
        assertTrue(test.bottomleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertFalse(test.topleft.isLeaf());
        assertFalse(test.topright.isLeaf());
        assertTrue(test.topright.topright.isLeaf());
        assertEquals(21, test.getSize());
        double result = 21.00 / 64.00;
        assertEquals(result, test.getCompressionRatio(), 0.000001);
        assertArrayEquals(mergeLarge, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(mergeLarge[y][x], test.getColor(x, y));
            }
        }
        
        test.setColor(0, 0, 1);
        test.setColor(4, 3, 1); 
        int [][] result2 = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
        };
        assertTrue(test.isLeaf());
        assertEquals(1, (int) test.color);
        assertArrayEquals(result2, test.decompress());
    }
    
    @Test
    public void doesNotChangeStructure() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        assertNull(test.color);
        assertEquals(1, (int) test.bottomleft.color);
        assertNotEquals(null, test.bottomright);
        assertNotEquals(null, test.topleft);
        assertEquals(1, (int) test.topright.topright.color);
        assertEquals(8, test.dim);
        assertEquals(8, test.getDimension());
        assertFalse(test.isLeaf());
        assertTrue(test.bottomleft.isLeaf());
        assertFalse(test.bottomright.isLeaf());
        assertFalse(test.topleft.isLeaf());
        assertFalse(test.topright.isLeaf());
        assertTrue(test.topright.topright.isLeaf());
        assertEquals(61, test.getSize());
        double result = 61.00 / 64.00;
        assertEquals(result, test.getCompressionRatio(), 0.000001);
        assertArrayEquals(notSameLarge, test.decompress());
        
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(notSameLarge[y][x], test.getColor(x, y));
            }
        }
        
        test.setColor(0, 0, 6);
        test.setColor(1, 1, 8); 
        test.setColor(2, 2, 9);
        test.setColor(3, 3, 7);
        int [][] resultGraph = new int[][]{
            {6, 4, 5, 6, 5, 3, 1, 1},
            {1, 8, 7, 8, 9, 4, 1, 1},
            {2, 3, 9, 6, 2, 6, 3, 2},
            {7, 8, 2, 7, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 1, 3, 4, 5},
        };
        
        assertFalse(test.isLeaf());
        assertFalse(test.topleft.isLeaf());
        assertFalse(test.topright.isLeaf());
        assertArrayEquals(resultGraph, test.decompress());
    }
    
    @Test
    public void quadTreeConstructorTest1() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        QuadTreeNodeImpl test2 = new QuadTreeNodeImpl(notSameLarge, 0, 0, 7, 7);
        assertArrayEquals(test.decompress(), test2.decompress());
        
        QuadTreeNodeImpl test3 = QuadTreeNodeImpl.buildFromIntArray(allSameLarge);
        QuadTreeNodeImpl test4 = new QuadTreeNodeImpl(allSameLarge, 0, 0, 7, 7);
        assertArrayEquals(test3.decompress(), test4.decompress());
        
    }
    
    @Test
    public void checkerSmall() {    
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(checkerSmall);
        assertEquals(21, test.getSize());
        assertEquals(1.3125, test.getCompressionRatio(), 0.000001);
    }
    
    
    @Test
    public void mustBeLeaf() {    
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(beLeaf);
        assertEquals(4, (int) test.bottomright.topright.bottomleft.color);
        assertEquals(1, (int) test.bottomright.topright.topleft.color);
        assertEquals(1, (int) test.bottomright.topright.topright.color);
        assertEquals(1, (int) test.bottomright.topright.bottomright.color);
        assertEquals(1, (int) test.bottomright.topleft.color);
        
        test.setColor(6, 5, 1);
        assertTrue(test.bottomright.isLeaf());
        assertEquals(1, (int) test.bottomright.color);
        assertEquals(13, test.getSize());
    }
    
    @Test
    public void randomSetLarge() {    
        int[][] testImage = new int[256][256];
        
        for (int y = 0; y < 256; y++) {
            for (int x = 0; x < 256; x++) {
                testImage[y][x] = (int) Math.floor(Math.random() * 255);
            }
        }
        
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(testImage);
        assertArrayEquals(testImage, test.decompress());
        test.setColor(165, 166, 8);
        testImage[166][165] = 8;
        test.setColor(172, 170, 29);
        testImage[170][172] = 29;
        assertArrayEquals(testImage, test.decompress());
    }
    
    @Test
    public void nodePropertyChanged() {    
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(notSameLarge);
        
        test.setColor(0, 0, 6);
        test.setColor(1, 1, 8); 
        test.setColor(2, 2, 9);
        test.setColor(3, 3, 7);
        int [][] resultGraph = new int[][]{
            {6, 4, 5, 6, 5, 3, 1, 1},
            {1, 8, 7, 8, 9, 4, 1, 1},
            {2, 3, 9, 6, 2, 6, 3, 2},
            {7, 8, 2, 7, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 3, 4, 5, 6},
            {1, 1, 1, 1, 1, 3, 4, 5},
        };
        
        //check existing node properties
        assertFalse(test.isLeaf());
        assertFalse(test.topleft.isLeaf());
        assertFalse(test.topright.isLeaf());
        assertTrue(test.topright.topright.isLeaf());
        assertEquals(1, (int) test.topright.topright.color);
        assertFalse(test.bottomright.isLeaf());
        assertTrue(test.bottomleft.isLeaf());
        assertEquals(1, (int) test.bottomleft.color);
        assertArrayEquals(resultGraph, test.decompress());
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(resultGraph[y][x], test.getColor(x, y));
            }
        }
    }
    
    @Test
    public void helperConstructorTest() {
        QuadTreeNodeImpl test = new QuadTreeNodeImpl(0, 0, 3, 3, -1);
        assertTrue(test.isLeaf());
        assertEquals(-1, (int) test.color);
    }
    
    @Test
    public void negativeSmallTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(negativeSmall);
        assertFalse(test.isLeaf());
        assertTrue(test.topleft.isLeaf());
        assertEquals(-1, (int) test.topleft.color);
        assertFalse(test.topright.isLeaf());
        assertFalse(test.bottomleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertEquals(-1, (int) test.bottomright.color);
        
        int[][] resultGraph = new int[][]{
            {-1, -1, -1, 2},
            {-1, -1, 2, -1},
            {-1, 2, -1, -1},
            {2, -1, -1, -1},
        };
        assertArrayEquals(resultGraph, test.decompress());
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(resultGraph[y][x], test.getColor(x, y));
            }
        }
        assertArrayEquals(resultGraph, test.decompress());
        test.setColor(3, 0, -1);
        test.setColor(2, 1, -1); 
        assertFalse(test.isLeaf());
        assertTrue(test.topleft.isLeaf());
        assertEquals(-1, (int) test.topleft.color);
        assertTrue(test.topright.isLeaf());
        assertEquals(-1, (int) test.topright.color);
        assertFalse(test.bottomleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertEquals(-1, (int) test.bottomright.color);
    }
    
    @Test
    public void negativLargeTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(negativeLarge);
        assertTrue(test.isLeaf());
        
        int[][] resultGraph = new int[][]{
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1},
        };
        assertArrayEquals(resultGraph, test.decompress());
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(resultGraph[y][x], test.getColor(x, y));
            }
        }
        assertArrayEquals(resultGraph, test.decompress());
        test.setColor(6, 0, -6);
        test.setColor(1, 4, -6); 
        assertFalse(test.isLeaf());
        assertTrue(test.topleft.isLeaf());
        assertEquals(-1, (int) test.topleft.color);
        assertFalse(test.topright.isLeaf());
        assertFalse(test.bottomleft.isLeaf());
        assertTrue(test.bottomright.isLeaf());
        assertEquals(-1, (int) test.bottomright.color);
    }
    
    @Test
    public void sampleTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(sample);
        assertFalse(test.isLeaf());
        
        int[][] resultGraph = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 7, 6, 4, 4},
            {2, 2, 2, 2, 5, 5, 4, 4},
            {2, 2, 2, 2, 3, 3, 3, 3},
            {2, 2, 2, 2, 3, 3, 3, 3},
        };
        assertArrayEquals(resultGraph, test.decompress());
        for (int y = 0; y < test.getDimension(); y++) {
            for (int x = 0; x < test.getDimension(); x++) {
                assertEquals(resultGraph[y][x], test.getColor(x, y));
            }
        }
        assertFalse(test.isLeaf());
        assertTrue(test.topleft.isLeaf());
        assertEquals(1, (int) test.topleft.color);
        assertTrue(test.topright.isLeaf());
        assertEquals(1, (int) test.topright.color);
        assertTrue(test.bottomleft.isLeaf());
        assertEquals(2, (int) test.bottomleft.color);
        assertFalse(test.bottomright.isLeaf());
        assertTrue(test.bottomright.bottomright.isLeaf());
        assertTrue(test.bottomright.bottomleft.isLeaf());
        assertTrue(test.bottomright.topright.isLeaf());
        assertFalse(test.bottomright.topleft.isLeaf());
        assertTrue(test.bottomright.topleft.topleft.isLeaf());
        assertTrue(test.bottomright.topleft.topright.isLeaf());
        assertTrue(test.bottomright.topleft.bottomleft.isLeaf());
        assertTrue(test.bottomright.topleft.bottomright.isLeaf());
        assertEquals(13, test.getSize());
        double result = 13.00 / 64.00;
        assertEquals(result, test.getCompressionRatio(), 0.000001);
    }
    
    @Test
    public void sizeTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(sizesample);
        assertFalse(test.isLeaf());
        assertEquals(9, test.getSize());
        double result = 9.00 / 16.00;
        assertEquals(result, test.getCompressionRatio(), 0.0000001);
    }
    
    @Test
    public void mergeSmallTest() {
        QuadTreeNodeImpl test = QuadTreeNodeImpl.buildFromIntArray(mergeSmall);
        assertFalse(test.isLeaf());
        assertEquals(5, test.getSize());
        test.setColor(1, 1, 1);
        assertTrue(test.isLeaf());
        assertEquals(1, test.getSize());
    }
    

}
