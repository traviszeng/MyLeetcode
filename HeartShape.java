/**
 * Heart Shape created on 2017/2/14.
 */
public class HeartShape {
    //heart shape equation
    //(x^2+y^2-1)^3-x^2*y^3=0
    public void drawHeartShape(){
        String s="Arsenal";
        for(float y = (float) 1.3; y>=-1.1; y-=0.06){
            int index=0;
            for(float x = (float) -1.2; x<=1.2; x+=0.025){
                if (Math.pow((x*x+y*y-1.0),3)-x*x*y*y*y<=0.0){
                    System.out.print(s.charAt(index++%s.length()));
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HeartShape h = new HeartShape();
        h.drawHeartShape();
    }
}
