import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MathMathImpl implements MatMath {

    public static List<Integer> C = new ArrayList<>();

    public MathMathImpl(){

    }

    /* multiply Doesn't work */

    @Override
    public void multiply(int[][] A, int[][] B, int[][] C) {
        int colsOfA = A[0].length;
        int rowsOfB = B.length;

        if(colsOfA != rowsOfB){
            System.out.println(" Cannot perform matrix multiplication");
        }
    }

    @Override
    public void add(int[][] A, int[][] B, int[][] r) {
        List<Integer> listA = convertToList(A);
        List<Integer> listB = convertToList(B);
        List<Integer> tempA = convertToList(r);
        List<Integer> tempB = tempA;
        List<Integer> listC;

        Sum task = new Sum(listA, listB, tempA, tempB,0, listA.size());
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        listC = pool.invoke(task);
        convertToArray(listC, A.length, r);
        pool.shutdown();
    }

    @Override
    public void print(int[][] A) {
        List<Integer> list = convertToList(A);
        List<Integer> temp = list;

        Print task = new Print(list,temp,0, temp.size());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        for(int i = 0; i < 2; i ++){ System.out.println(" "); }
        pool.shutdown();
    }


    public List<Integer> convertToList(int [][] twoD){
        List<Integer> list = new ArrayList();
        for(int i[] : twoD){
            for(int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    public void convertToArray(List<Integer> list, int size, int[][] r){
        List<Integer> temp;
        int startIndex = 0, endIndex = size;
        int row = 0;
        for(int[] i : r){
            temp = list.subList(startIndex,endIndex);
            Integer[] holder =  Arrays.stream(temp.toArray())
                    .map(Object::toString)
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            i = Arrays.stream(holder).mapToInt(Integer::intValue).toArray();
            r[row ++] = i;
            startIndex = endIndex;
            endIndex += size;
        }
    }
}
