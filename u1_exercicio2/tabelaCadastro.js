function cadastroPessoa(nomeCompleto, dataNascimento, eMail, opcaoSexo) {
    var tabela = document.getElementById("tabelaCadastro");
    var qtdLinhas = tb.rows.length;
    var linha = tabela.insertRow(qtdLinhas);

    var cellNome = linha.insertCell(0);
    var cellData = linha.insertCell(1);
    var cellEmail = linha.insertCell(2);
    var cellOpcao = linha.insertCell(3);

    cellNome.innerHTML = nomeCompleto;
    cellData.innerHTML = dataNascimento;
    cellEmail.innerHTML = eMail;
    cellOpcao.innerHTML = opcaoSexo;
}