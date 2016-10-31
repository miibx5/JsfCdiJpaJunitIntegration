/*
 *  Projeto...........: FinancasPessoais
 *  Desenvolvedor.....: Éder Luciano da Costa
 *  Copyright...: 2013
 *  Criacao...........: 08/12/2013, 16:54:31
 *  Revisao...........: $Rev:$, $Id:$
 *  Codificacao.......: UTF-8 (Utilizado na criacao do arquivo)
 *  Usuario...........: Éder
 *  ---------------------------------------------------
 *  Éder Luciano da Costa - © Copyright 2013 - Todos os direitos reservados
 *  ---------------------------------------------------
 */

/**
 * Funcao que mantem  os dialog's de cadastro e edicao de Pessoas aberto se falhar a validacao.
 *
 * @param {type} args
 * @returns {undefined}
 */
function handlePersonRequest(args)
{
    if (args.validationFailed || args.sucesso === false)
    {
        PF('dlgNewPerson').jq.effect("shake", {times: 5}, 100);
    } else
    {
        PF('dlgNewPerson').hide();
    }
}

