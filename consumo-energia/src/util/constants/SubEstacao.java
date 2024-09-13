package util.constants;

public enum SubEstacao {
    AURORA(1), HORIZONTE(2), LITORAL(3), PROGRESSO(4), PLANALTO(5);

    private int codigo;

    SubEstacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static SubEstacao getSubEstacao(int codigo) {
        for (SubEstacao subEstacao : SubEstacao.values()) {
            if (subEstacao.codigo == codigo) {
                return subEstacao;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
