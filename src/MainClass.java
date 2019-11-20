import java.util.Random;

public class MainClass {
    public static void main(String[] args){
        int[][] A = new int [5][5], B = new int [5][5], C = new int [5][5], D = new int [5][5];
        int[][] r = new int [5][5], s = new int [5][5], t = new int [5][5];

        generateValues(A,B,C,D,r,s,t);

        MathMathImpl u = new MathMathImpl();

        // code to initialize A,B,C,D
        u.print(A);
        u.add(A,B,r);
        u.print(r);
        /* MULTIPLY() doesn't work. It crashes on index outofbound on stream */
        //u.multiply(r,C,s);
        //u.multiply(s,D,t);
    }

     public static void generateValues(int[][]A, int [][]B, int [][]C, int [][]D, int [][]r, int [][]s, int [][]t){
        Random rand = new Random();
        int rand_int = rand.nextInt(10);

        for(int [] i: A){
            for(int j = 0; j < i.length; j ++){
                i[j]=rand_int;
                rand_int=rand.nextInt(10);
            }
        }
        for(int [] i: B){
            for(int j = 0; j < i.length; j ++){
                i[j] = rand_int;
                rand_int = rand.nextInt(10);
            }
        }
        for(int [] i: C){
            for(int j = 0; j < i.length; j ++){
                i[j]=rand_int;
                rand_int=rand.nextInt(10);
            }
        }
        for(int [] i: D){
            for(int j = 0; j < i.length; j ++){
                i[j]=rand_int;
                rand_int=rand.nextInt(10);
            }
        }
         for(int [] i: r){
             for(int j = 0; j < i.length; j ++){
                 i[j]=0;
             }
         }
         for(int [] i: s){
             for(int j = 0; j < i.length; j ++){
                 i[j]=0;
             }
         }
         for(int [] i: t){
             for(int j = 0; j < i.length; j ++){
                 i[j]=0;
             }
         }
    }
}
