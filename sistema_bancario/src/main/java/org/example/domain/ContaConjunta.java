package org.example.domain;

import org.example.enums.TipoConta;
import org.example.exceptions.conta.*;

import java.util.ArrayList;
import java.util.List;

public class ContaConjunta extends Conta{
    private List<Pessoa> titulares = new ArrayList<Pessoa>();

    public ContaConjunta(TipoConta tipoConta, PessoaFisica titular1, PessoaFisica titular2, double saldo) throws
            ContaConjuntaSemTitularesException,
            TitularesIguaisExcepton,
            VinculoPessoaDiferenteException,
            ContaSemTipoException,
            ContaPoupancaValorAberturaIndevidoException, ContaConjuntaEmpresarialException {

        super(tipoConta, saldo);

        if (titular1 == null || titular2 == null) {
            throw new ContaConjuntaSemTitularesException();
        } else if (titular1 == titular2) {
            throw new TitularesIguaisExcepton();
        } else {
            if (titular1.temVinculo() && titular2.temVinculo()) {
                if (titular1.getVinculo().getVinculado() == titular2 &&
                        titular2.getVinculo().getVinculado() == titular1) {

                    titulares.add(titular1);
                    titulares.add(titular2);
                } else {
                    throw new VinculoPessoaDiferenteException();
                }
            } else {
                throw new VinculoPessoaDiferenteException();
            }
        }
    }
}
