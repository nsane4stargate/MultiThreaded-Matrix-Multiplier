import java.util.concurrent.RecursiveAction;
import java.util.List;


public class Print extends RecursiveAction{

    private List<Integer> list;
    private List<Integer> temp;
    private int startIndex, endIndex;

    public Print (List<Integer>list, List<Integer> temp, int startIndex, int endIndex){
        super();
        this.list = list;
        this.temp = temp;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected void compute() {
        if(temp.size() < 6){
            print(temp);
        }else{
         int mid = startIndex + temp.size()/2;
         int low = startIndex;

         temp = list.subList(low,mid);
         Print tLeft = new Print(list, temp, low, mid);

         int high = endIndex;
         temp = list.subList(mid, high);
         Print tRight = new Print(list, temp, mid, high);
         this.invokeAll(tLeft,tRight);
        }
    }

    private void print(List<Integer> temp) {
        temp.parallelStream().forEach(System.out::println);
    }
}
