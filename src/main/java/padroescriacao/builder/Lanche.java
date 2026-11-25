package padroescriacao.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Produto imutável: só pode ser criado pelo Builder, e só sai de lá válido.
public class Lanche {

    private final String pao;
    private final String proteina;
    private final String ponto;
    private final String queijo;
    private final List<String> extras;

    private Lanche(Builder builder) {
        this.pao = builder.pao;
        this.proteina = builder.proteina;
        this.ponto = builder.ponto;
        this.queijo = builder.queijo;
        this.extras = Collections.unmodifiableList(new ArrayList<String>(builder.extras));
    }

    public String getPao() {
        return pao;
    }

    public String getProteina() {
        return proteina;
    }

    public String getPonto() {
        return ponto;
    }

    public String getQueijo() {
        return queijo;
    }

    public List<String> getExtras() {
        return extras;
    }

    public String getDescricao() {
        return "Lanche{" +
                "pao='" + this.pao + '\'' +
                ", proteina='" + this.proteina + '\'' +
                ", ponto='" + this.ponto + '\'' +
                ", queijo='" + this.queijo + '\'' +
                ", extras=" + this.extras +
                '}';
    }

    public static class Builder {

        private String pao;
        private String proteina;
        private String ponto = "Ao ponto";
        private String queijo = "Sem queijo";
        private List<String> extras = new ArrayList<String>();

        public Builder pao(String pao) {
            this.pao = pao;
            return this;
        }

        public Builder proteina(String proteina) {
            this.proteina = proteina;
            return this;
        }

        public Builder ponto(String ponto) {
            this.ponto = ponto;
            return this;
        }

        public Builder queijo(String queijo) {
            this.queijo = queijo;
            return this;
        }

        public Builder extra(String extra) {
            this.extras.add(extra);
            return this;
        }

        public Lanche build() {
            if (this.pao == null || this.pao.isEmpty()) {
                throw new IllegalArgumentException("Pão obrigatório");
            }
            if (this.proteina == null || this.proteina.isEmpty()) {
                throw new IllegalArgumentException("Proteína obrigatória");
            }
            return new Lanche(this);
        }
    }
}
