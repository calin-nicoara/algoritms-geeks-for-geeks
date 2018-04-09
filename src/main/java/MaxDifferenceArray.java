import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDifferenceArray {

    public static void main(String[] args) {
        if(args.length <= 2) {
            System.out.println();
            return;
        }

        final List<Integer> numbersOrdered = new ArrayList<>();
        for(int i = 0; i < args.length; i++) {
            numbersOrdered.add(Integer.parseInt(args[i]));
        }
        Collections.sort(numbersOrdered);

        List<Integer> numbersInFinalOrder = new ArrayList<>();

        int indexOfLastElement = numbersOrdered.size() - 1;
        int middleIndex = (indexOfLastElement + numbersOrdered.size() % 2) / 2;
        for(int index = 0; index <= middleIndex; index++) {
            if(indexOfLastElement - index == index) {
                numbersInFinalOrder.add(numbersOrdered.get(index));
            } else {
                numbersInFinalOrder.add(numbersOrdered.get(indexOfLastElement-index));
                numbersInFinalOrder.add(numbersOrdered.get(index));
            }
        }

        int sum = 0;
        for(int index = 0; index < numbersInFinalOrder.size(); index++) {
            if(index == numbersInFinalOrder.size() - 1) {
                sum += Math.abs(numbersInFinalOrder.get(index) - numbersInFinalOrder.get(0));
            } else {
                sum += Math.abs(numbersInFinalOrder.get(index) - numbersInFinalOrder.get(index+1));
            }
        }

        System.out.println(sum);
    }
}
