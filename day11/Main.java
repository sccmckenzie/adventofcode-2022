import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int NUM_ROUNDS = 10_000;

    public static void main(String[] args) {
        List<Monkey> monkeys = new ArrayList<Monkey>();

        List<Long> l0 = List.of(84L, 72L, 58L, 51L);
        Function<Long, Long> f0 = x -> x * 3;
        Monkey monkey0 = new Monkey(monkeys, l0, f0, 13L, 1, 7);
        
        List<Long> l1 = List.of(88L, 58L, 58L);
        Function<Long, Long> f1 = x -> x + 8;
        Monkey monkey1 = new Monkey(monkeys, l1, f1, 2L, 7, 5);
        
        List<Long> l2 = List.of(93L, 82L, 71L, 77L, 83L, 53L, 71L, 89L);
        Function<Long, Long> f2 = x -> x * x;
        Monkey monkey2 = new Monkey(monkeys, l2, f2, 7L, 3, 4);
        
        List<Long> l3 = List.of(81L, 68L, 65L, 81L, 73L, 77L, 96L);
        Function<Long, Long> f3 = x -> x + 2;
        Monkey monkey3 = new Monkey(monkeys, l3, f3, 17L, 4, 6);

        List<Long> l4 = List.of(75L, 80L, 50L, 73L, 88L);
        Function<Long, Long> f4 = x -> x + 3;
        Monkey monkey4 = new Monkey(monkeys, l4, f4, 5L, 6, 0);
        
        List<Long> l5 = List.of(59L, 72L, 99L, 87L, 91L, 81L);
        Function<Long, Long> f5 = x -> x * 17;
        Monkey monkey5 = new Monkey(monkeys, l5, f5, 11L, 2, 3);
        
        List<Long> l6 = List.of(86L, 69L);
        Function<Long, Long> f6 = x -> x + 6;
        Monkey monkey6 = new Monkey(monkeys, l6, f6, 3L, 1, 0);
        
        List<Long> l7 = List.of(91L);
        Function<Long, Long> f7 = x -> x + 1;
        Monkey monkey7 = new Monkey(monkeys, l7, f7, 19L, 2, 5);

        monkeys.addAll(List.of(monkey0, monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7));


        for (int i = 0; i < NUM_ROUNDS; i++) {
            for (Monkey monkey : monkeys) {
                monkey.inspectAllItems();
            }
        }

        List<Long> monkeyTotals = new ArrayList<Long>();

        for (Monkey monkey : monkeys) {
            monkeyTotals.add(monkey.numInspected);
        }

        monkeyTotals.sort(Collections.reverseOrder());

        Long MonkeyBusiness = monkeyTotals.get(0) * monkeyTotals.get(1);

        System.out.println(MonkeyBusiness);
    }
}
