package strategy;

import model.DynamicEntity;

import java.util.List;

public interface Source {
    public List<DynamicEntity> getDynamicEntity(String input);
}
