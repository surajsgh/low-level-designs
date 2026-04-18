package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeService {
    private List<Integer> denominations = List.of(1, 2, 5, 10, 20, 50, 100);

    public List<Integer> getDenominations() {
        return denominations;
    }

    public Map<Integer, Integer> getChange(int amount) {
        Map<Integer, Integer> change = new HashMap<>();

        for (int denomination: denominations) {
            int count = amount/denomination;
            if (count>0) {
                change.put(denomination, count);
                amount %= denomination;
            }
        }

        return change;
    }
}
