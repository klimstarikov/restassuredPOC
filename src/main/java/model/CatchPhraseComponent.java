package model;

public enum CatchPhraseComponent {
    MULTI_LAYERED("Multi-layered"),
    CLIENT_SERVER("client-server"),
    NEURAL_NET("neural-net");
    private final String value;

    CatchPhraseComponent(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
