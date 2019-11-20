import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<List<Integer>>{
    private List<Integer> A;
    private List<Integer> B;
    private List<Integer> tempA;
    private List<Integer> tempB;

    int startIndex; int endIndex;

    public Sum(List<Integer> A, List<Integer> B,List<Integer> tempA, List<Integer> tempB, int startIndex, int endIndex) {
        super();
        this.A = A;
        this.B = B;
        this.tempA = tempA;
        this.tempB = tempB;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public List<Integer> compute() {
        if(tempA.size() < 10 && tempB.size() < 10){
           return sumValues(tempA,tempB);
        }
        else {
            int mid = startIndex + tempA.size()/2;
            int low = startIndex;

            tempA = A.subList(low,mid);
            tempB = B.subList(low, mid);
            Sum tLeft = new Sum(A, B, tempA, tempB, low, mid);

            int high = endIndex;
            tempA = A.subList(mid, high);
            tempB = B.subList(mid, high);
            Sum tRight = new Sum(A, B, tempA, tempB, mid, high);

            tLeft.fork();
            List<Integer> right = tRight.compute();
            List<Integer> left = tLeft.join();
            left.addAll(right);
            return left;
        }
    }

    private List<Integer>sumValues(List<Integer> a, List<Integer> b) {
        List<Integer> t = new ArrayList<>();
        for(int index = 0; index < a.size(); index ++){
            t.add((a.get(index) + b.get(index)));
        }
        return t;
    }
}
