import java.util.List;
import java.util.function.Function;
import java.util.Deque;
import java.util.ArrayDeque;

public class Monkey {
    private List<Monkey> monkeys;
    private Deque<Long> items = new ArrayDeque<>();
    private Function<Long, Long> operation;
    private Long divisor;
    private int monkeyThrowTrue;
    private int monkeyThrowFalse;

    public long numInspected = 0;

    public Monkey(List<Monkey> monkeys, List<Long> startingItems, Function<Long, Long> operation,
    Long divisor, int monkeyThrowTrue, int monkeyThrowFalse) {
        this.monkeys = monkeys;
        this.items.addAll(startingItems);
        this.operation = operation;
        this.divisor = divisor;
        this.monkeyThrowTrue = monkeyThrowTrue;
        this.monkeyThrowFalse = monkeyThrowFalse;
    }

    public void receiveThrow(Long item) {
        items.addLast(item);
    }

    public void inspectNextItem() {
        Long item = items.pop();
        item = this.operation.apply(item);
        item = item % 9699690;
        if (item % this.divisor == 0L) {
            monkeys.get(this.monkeyThrowTrue).receiveThrow(item);
        } else {
            monkeys.get(this.monkeyThrowFalse).receiveThrow(item);
        }
    }

    public void inspectAllItems() {
        while (!this.items.isEmpty()) {
            inspectNextItem();
            numInspected++;
        }
    }
}
