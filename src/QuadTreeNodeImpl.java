// CIS 121, QuadTree

public class QuadTreeNodeImpl implements QuadTreeNode {
    /**
     * ! Do not delete this method !
     * Please implement your logic inside this method without modifying the signature
     * of this method, or else your code won't compile.
     * <p/>
     * As always, if you want to create another method, make sure it is not public.
     *
     * @param image image to put into the tree
     * @return the newly build QuadTreeNode instance which stores the compressed image
     * @throws IllegalArgumentException if image is null
     * @throws IllegalArgumentException if image is empty
     * @throws IllegalArgumentException if image.length is not a power of 2
     * @throws IllegalArgumentException if image, the 2d-array, is not a perfect square
     */
    
    //currently set to public for testing purposes, revert to private when done
    Integer color;   //set color equal to -1 if there is no uniform color exist
    int dim;
    QuadTreeNodeImpl topleft;
    QuadTreeNodeImpl topright;
    QuadTreeNodeImpl bottomleft;
    QuadTreeNodeImpl bottomright;
    
    public static QuadTreeNodeImpl buildFromIntArray(int[][] image) {
        if (image == null) {
            throw new IllegalArgumentException("Null image");
        } else if (image.length == 0 || image[0].length == 0) {
            throw new IllegalArgumentException("Empty image");
        } else if (image.length != image[0].length) {
            throw new IllegalArgumentException("Invalid image: not square");
        }
        
        int size = image.length - 1; 
        return new QuadTreeNodeImpl(image, 0, 0, size, size);       
    }
    
    QuadTreeNodeImpl(int[][] image, int xmin, int ymin, int xmax, int ymax) {
        int xlength = xmax - xmin + 1;
        int ylength = ymax - ymin + 1;
        
        if (image[ymin].length != image[ymax].length || image[ymin].length != image.length
                || image[ymax].length != image.length || image[0].length == 0) {
            throw new IllegalArgumentException("Invalid image: not square");
        } else if (xlength != ylength) {
            throw new IllegalArgumentException("Invalid image: not square");
        } else if (xlength > 1 && xlength % 2 != 0) {
            throw new IllegalArgumentException("Invalid image: length is not a power of 2");
        }
        
        dim = xlength;
                
        if (xmin == xmax && ymin == ymax) {
            color = (Integer) image[ymin][xmin];
            topleft = null;
            topright = null;
            bottomleft = null;
            bottomright = null;
        } else {
            int xadjust = xmin + (xmax - xmin) / 2;
            int yadjust = ymin + (ymax - ymin) / 2;
            
            //recursive call for top left section
            topleft = new QuadTreeNodeImpl(image, xmin, ymin, xadjust, yadjust);
            
            //recursive call for top right section
            topright = new QuadTreeNodeImpl(image, xadjust + 1, ymin, xmax, yadjust);
            
            //recursive call for bottom left section
            bottomleft = new QuadTreeNodeImpl(image, xmin, yadjust + 1, xadjust, ymax);
            
            //recursive call for bottom right section
            bottomright = new QuadTreeNodeImpl(image, xadjust + 1, yadjust + 1, xmax, ymax);
            
            if (topleft.color != null && topleft.color.equals(topright.color)
                    && topleft.color.equals(bottomleft.color)
                    && topleft.color.equals(bottomright.color)
                    && topright.color.equals(bottomright.color) 
                    && topright.color.equals(bottomleft.color)
                    && bottomleft.color.equals(bottomright.color)) {
                color = topleft.color;
                topleft = null;
                topright = null;
                bottomleft = null;
                bottomright = null;
            } else {
                color = null;
            }
        }
    }
    
    QuadTreeNodeImpl(int xmin, int ymin, int xmax, int ymax, int c) {
        int xlength = xmax - xmin + 1;
        int ylength = ymax - ymin + 1;
        
        if (xlength != ylength) {
            throw new IllegalArgumentException("Invalid image: not square");
        } else if (xlength > 1 && xlength % 2 != 0) {
            throw new IllegalArgumentException("Invalid image: length is not a power of 2");
        }
        
        dim = xlength;
                
        if (xmin == xmax && ymin == ymax) {
            color = (Integer) c;
            topleft = null;
            topright = null;
            bottomleft = null;
            bottomright = null;
        } else {
            int xadjust = xmin + (xmax - xmin) / 2;
            int yadjust = ymin + (ymax - ymin) / 2;

            //recursive call for top left section
            topleft = new QuadTreeNodeImpl(xmin, ymin, xadjust, yadjust, c);
            
            //recursive call for top right section
            topright = new QuadTreeNodeImpl(xadjust + 1, ymin, xmax, yadjust, c);
            
            //recursive call for bottom left section
            bottomleft = new QuadTreeNodeImpl(xmin, yadjust + 1, xadjust, ymax, c);
            
            //recursive call for bottom right section
            bottomright = new QuadTreeNodeImpl(xadjust + 1, yadjust + 1, xmax, ymax, c);
            
            if (topleft.color != null && topleft.color.equals(topright.color)
                    && topleft.color.equals(bottomleft.color) 
                    && topleft.color.equals(bottomright.color) 
                    && topright.color.equals(bottomright.color) 
                    && topright.color.equals(bottomleft.color)
                    && bottomleft.color.equals(bottomright.color)) {
                color = topleft.color;
                topleft = null;
                topright = null;
                bottomleft = null;
                bottomright = null;
            } else {
                color = null;
            }
        }
    }

    @Override
    public int getColor(int x, int y) {
        if (x >= dim || y >= dim || x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid Size");
        } else if (isLeaf()) {
            return color;
        } else {
            int adjust = dim / 2;
            if (x < adjust && y < adjust) {
                return topleft.getColor(x, y);
            } else if (x >= adjust && y < adjust) {
                return topright.getColor(x - adjust, y);
            } else if (x < adjust && y >= adjust) {
                return bottomleft.getColor(x, y - adjust);
            } else if (x >= adjust && y >= adjust) {
                return bottomright.getColor(x - adjust, y - adjust);
            }
        }
        throw new IllegalArgumentException("No color exist");
    }

    @Override
    public void setColor(int x, int y, int c) {
        if (x >= dim || y >= dim || x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid Size");
        } else if (dim == 1 && x == 0 && y == 0) {
            color = c;
        } else if (!isLeaf()) {
            int adjust = dim / 2;
            if (x < adjust && y < adjust) {
                topleft.setColor(x, y, c);
            } else if (x >= adjust && y < adjust) {
                topright.setColor(x - adjust, y, c);
            } else if (x < adjust && y >= adjust) {
                bottomleft.setColor(x, y - adjust, c);
            } else if (x >= adjust && y >= adjust) {
                bottomright.setColor(x - adjust, y - adjust, c);
            }
            
            if (topleft.color != null && topleft.color.equals(topright.color)
                    && topleft.color.equals(bottomleft.color) 
                    && topleft.color.equals(bottomright.color) 
                    && topright.color.equals(bottomright.color) 
                    && topright.color.equals(bottomleft.color)
                    && bottomleft.color.equals(bottomright.color)) {
                color = topleft.color;
                topleft = null;
                topright = null;
                bottomleft = null;
                bottomright = null;
            } else {
                color = null;
            }
        } else {
            int adjust = dim / 2;
            topleft = new QuadTreeNodeImpl(0, 0, adjust - 1, adjust - 1, color);
            topright = new QuadTreeNodeImpl(0, 0, adjust - 1, adjust - 1, color);
            bottomleft = new QuadTreeNodeImpl(0, 0, adjust - 1, adjust - 1, color);
            bottomright = new QuadTreeNodeImpl(0, 0, adjust - 1, adjust - 1, color);
            color = null; 

            if (x < adjust && y < adjust) {
                topleft.setColor(x, y, c);
            } else if (x >= adjust && y < adjust) {
                topright.setColor(x - adjust, y, c);
            } else if (x < adjust && y >= adjust) {
                bottomleft.setColor(x, y - adjust, c);
            } else if (x >= adjust && y >= adjust) {
                bottomright.setColor(x - adjust, y - adjust, c);
            }    
        }
    } 

    @Override
    public QuadTreeNode getQuadrant(QuadName quadrant) {
        if (quadrant.equals(QuadName.TOP_LEFT)) {
            return topleft;
        } else if (quadrant.equals(QuadName.TOP_RIGHT)) {
            return topright;
        } else if (quadrant.equals(QuadName.BOTTOM_LEFT)) {
            return bottomleft;
        } else {
            return bottomright;
        }
        
    }

    @Override
    public int getDimension() {
        return dim;
    }

    @Override
    public int getSize() {
        if (isLeaf()) {
            return 1; 
        } else {
            int result = topleft.getSize() + topright.getSize() 
                + bottomleft.getSize() + bottomright.getSize() + 1;
            
            return result;
        }
    }

    @Override
    public boolean isLeaf() {
        return (topleft == null && topright == null && bottomleft == null && bottomright == null
                && color != null);
    }

    @Override
    public int[][] decompress() {
        int[][] result = new int [dim][dim];
        decompressHelp(result, 0, 0, dim, dim); 
        
        return result;
    }
    
    int[][] decompressHelp(int[][] target, int xmin, int ymin, int xmax, int ymax) {
        if (isLeaf()) {
            for (int y = ymin; y < ymax; y++) {
                for (int x = xmin; x < xmax; x++) {
                    target[y][x] = color;
                }
            }
        } else {
            int xadjust = xmin + (xmax - xmin) / 2;
            int yadjust = ymin + (ymax - ymin) / 2;
            
            topleft.decompressHelp(target, xmin, ymin, xadjust, yadjust);
            topright.decompressHelp(target, xadjust, ymin, xmax, yadjust);
            bottomleft.decompressHelp(target, xmin, yadjust, xadjust, ymax);
            bottomright.decompressHelp(target, xadjust, yadjust, xmax, ymax);  
        }     
        return target;
    }

    @Override
    public double getCompressionRatio() {
        double ratio = (double) getSize() / (double) (getDimension() * getDimension());
        return ratio;
    }
}
