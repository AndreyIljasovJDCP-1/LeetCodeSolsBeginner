package leetcode.medium;

public class MaxVolume {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{20, 8, 6, 12, 5, 4, 8, 3, 5}));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            System.out.println(currentArea);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    public static int reservoir(int[] volumes) {

        int maxVolume = -1;
        int reservoirVolume;
        int maxReservoirVolume = -1;

        int uBound;
        for (int i = 0; i < volumes.length; i++) {
            int currentVolume = volumes[i];
            for (int j = i + 1; j < volumes.length; j++) {
                currentVolume += volumes[j];
                uBound = Math.min(volumes[j], volumes[i]);
                reservoirVolume = uBound * (j - i + 1);

                if (currentVolume <= reservoirVolume) {
                    maxVolume = Math.max(currentVolume, maxVolume);
                    maxReservoirVolume = Math.max(maxReservoirVolume, reservoirVolume);
                    System.out.println("left= " + volumes[i] + " right= " + volumes[j]);
                    System.out.println("currentVolume= " + currentVolume + " reservoirVolume= " + reservoirVolume);
                }


            }
        }
        System.out.println(maxReservoirVolume);
        System.out.println(maxVolume);
        return 0;
    }
}
