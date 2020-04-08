package com.saude.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.saude.web.rest.TestUtil;

public class ProfissionalSaudeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProfissionalSaude.class);
        ProfissionalSaude profissionalSaude1 = new ProfissionalSaude();
        profissionalSaude1.setId(1L);
        ProfissionalSaude profissionalSaude2 = new ProfissionalSaude();
        profissionalSaude2.setId(profissionalSaude1.getId());
        assertThat(profissionalSaude1).isEqualTo(profissionalSaude2);
        profissionalSaude2.setId(2L);
        assertThat(profissionalSaude1).isNotEqualTo(profissionalSaude2);
        profissionalSaude1.setId(null);
        assertThat(profissionalSaude1).isNotEqualTo(profissionalSaude2);
    }
}
