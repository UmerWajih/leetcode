package leetcode.questions.x700.to.x799;

//https://leetcode.com/problems/flood-fill/
public class Problem_733 {

	
	private static  void rec (int[][] image, int x, int y,  int color, int targetColor) {
		if(x < 0 || x == image.length || y == image[0].length || y < 0) return;
		
		if(image[x][y] == color) image[x][y]= targetColor;
		else return;
		rec ( image,  x+1,  y,    color,  targetColor);
		rec ( image,  x-1,  y,   color,  targetColor);
		rec ( image,  x,  y+1,   color,  targetColor);
		rec ( image,  x,  y-1,   color,  targetColor);
	}
	
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //starting point change img[x][y] to colour
        //if pixel up or down ,left or right have the same color update it
        // each updated pixel is now the starting point
		//image[sr][sc]
        //this is a simple recursive problem;
		if(image[sr][sc] == color) return image;
		rec (image, sr,  sc,  image[sr][sc],  color);
		return image;
		
    }
}
