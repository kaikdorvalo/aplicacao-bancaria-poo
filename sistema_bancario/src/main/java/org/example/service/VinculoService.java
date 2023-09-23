package org.example.service;

import org.example.domain.Pessoa;
import org.example.domain.PessoaFisica;
import org.example.domain.Vinculo;
import org.example.enums.TipoVinculo;
import org.example.exceptions.vinculo.PessoaVinculadaException;
import org.example.exceptions.vinculo.TiposDePessoasDiferentesException;

public class VinculoService {
    public void vincularPessoas(PessoaFisica pessoa1, PessoaFisica pessoa2, TipoVinculo tipoVinculo) throws
            PessoaVinculadaException {

            if (pessoa1.getVinculo() == null && pessoa2.getVinculo() == null) {
                Vinculo vinculo1 = new Vinculo(pessoa1, tipoVinculo);
                Vinculo vinculo2 = new Vinculo(pessoa2, tipoVinculo);
                pessoa1.setVinculo(vinculo2);
                pessoa2.setVinculo(vinculo1);
            } else {
                throw new PessoaVinculadaException();
            }
        }
}
