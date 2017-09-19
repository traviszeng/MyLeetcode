/**
 *  For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

 1. The area of the rectangular web page you designed must equal to the given target area.

 2. The width W should not be larger than the length L, which means L >= W.

 3. The difference between length L and width W should be as small as possible.

 */
public class ConstructRetangular {
    public int[] constructRectangle(int area) {
        double element = Math.sqrt(area);
        int up = (int)Math.ceil(element);
        while(area%up!=0){
            up++;
        }
        return new int[]{up,area/up};
    }

    public static void main(String[] args){
        ConstructRetangular c = new ConstructRetangular();
        int[] a=c.constructRectangle(100);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
