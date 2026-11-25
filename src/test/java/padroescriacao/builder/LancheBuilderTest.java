package padroescriacao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheBuilderTest {

    @Test
    void deveRetornarExcecaoParaLancheSemPao() {
        try {
            Lanche lanche = new Lanche.Builder()
                    .proteina("Carne")
                    .queijo("Cheddar")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pão obrigatório", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaLancheSemProteina() {
        try {
            Lanche lanche = new Lanche.Builder()
                    .pao("Brioche")
                    .queijo("Cheddar")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Proteína obrigatória", e.getMessage());
        }
    }

    @Test
    void deveRetornarLancheCompleto() {
        Lanche lanche = new Lanche.Builder()
                .pao("Brioche")
                .proteina("Carne")
                .ponto("Mal passado")
                .queijo("Cheddar")
                .extra("Bacon")
                .extra("Ovo")
                .build();

        assertEquals("Lanche{pao='Brioche', proteina='Carne', ponto='Mal passado', queijo='Cheddar', extras=[Bacon, Ovo]}", lanche.getDescricao());
    }

    @Test
    void deveRetornarLancheComValoresPadrao() {
        Lanche lanche = new Lanche.Builder()
                .pao("Francês")
                .proteina("Carne")
                .build();

        assertEquals("Lanche{pao='Francês', proteina='Carne', ponto='Ao ponto', queijo='Sem queijo', extras=[]}", lanche.getDescricao());
    }

    @Test
    void deveCriarLanchesIndependentesComMesmoBuilder() {
        Lanche.Builder builder = new Lanche.Builder()
                .pao("Brioche")
                .proteina("Carne")
                .extra("Bacon");

        Lanche lanche1 = builder.build();
        Lanche lanche2 = builder.extra("Ovo").build();

        assertNotSame(lanche1, lanche2);
        assertEquals("[Bacon]", lanche1.getExtras().toString());
        assertEquals("[Bacon, Ovo]", lanche2.getExtras().toString());
    }
}
