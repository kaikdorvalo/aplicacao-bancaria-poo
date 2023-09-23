package org.example.service;

import org.example.domain.Endereco;
import org.example.domain.PessoaFisica;
import org.example.domain.PessoaJuridica;
import org.example.enums.TipoVinculo;
import org.example.exceptions.vinculo.PessoaVinculadaException;
import org.example.exceptions.vinculo.TiposDePessoasDiferentesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VinculoServiceTest {
    VinculoService vinculoService = new VinculoService();
    Endereco endereco = new Endereco("Brasil", "Paraná", "Maringá", "Avenida Guedner", "0000", "Na Unicesumar");
    PessoaFisica pessoaFisica1 = new PessoaFisica("122.122.122-55", "Pessoa1", endereco);
    PessoaFisica pessoaFisica2 = new PessoaFisica("133.133.133-55", "Pessoa2", endereco);

    @Test
    public void deveVincularPessoasFisicas() throws PessoaVinculadaException, TiposDePessoasDiferentesException {
        vinculoService.vincularPessoas(pessoaFisica1, pessoaFisica2, TipoVinculo.UNIAO_CIVIL);

        Assertions.assertEquals(pessoaFisica1, pessoaFisica2.getVinculo().getVinculado());
        Assertions.assertEquals(pessoaFisica2, pessoaFisica1.getVinculo().getVinculado());
    }
}
