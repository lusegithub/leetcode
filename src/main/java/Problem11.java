/**
 * Created by jacky on 17-5-1.
 */
public class Problem11 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1, 1}));
    }
}
