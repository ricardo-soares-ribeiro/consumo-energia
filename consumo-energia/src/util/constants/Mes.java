package util.constants;

public enum Mes {
    JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), JUNHO(6),
    JULHO(7), AGOSTO(8), SETEMBRO(9), OUTUBRO(10), NOVEMBRO(11), DEZEMBRO(12);

    private int numero;

    Mes(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static Mes getMes(int num) {
        for (Mes mes : Mes.values()) {
            if (num == mes.getNumero()) {
                return mes;
            }
        }
        throw new IllegalArgumentException("Número inválido: " + num);
    }
}
