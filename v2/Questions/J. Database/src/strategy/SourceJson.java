package strategy;

import model.DynamicEntity;
import java.util.List;

public class SourceJson implements Source {

    @Override
    public List<DynamicEntity> getDynamicEntity(String input) {
        return List.of();
    }
}
