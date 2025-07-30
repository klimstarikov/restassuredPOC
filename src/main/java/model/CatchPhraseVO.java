package model;

import java.util.List;
import java.util.stream.Collectors;

public class CatchPhraseVO {
    private final List<CatchPhraseComponent> components;

    public CatchPhraseVO(List<CatchPhraseComponent> components) {
        if (components == null || components.isEmpty()) {
            throw new IllegalArgumentException("Components cannot be null or empty");
        }
        this.components = components;
    }

    public String asString() {
        return components.stream()
                .map(CatchPhraseComponent::getValue)
                .collect(Collectors.joining(" "));
    }

    public List<CatchPhraseComponent> getComponents() {
        return components;
    }
}
