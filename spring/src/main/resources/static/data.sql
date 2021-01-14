/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  moquiuti
 */
create table sessao
(
    id          bigint not null  constraint sessao_pkey primary key,
    pauta   bigint
        constraint fk_sessao_pauta_id
            references pauta,
    fim         date
);

create table pauta
(
    id             bigint not null constraint pauta_pkey primary key,
    descricao         varchar(1000)
);

create table associado
(
    id             bigint not null constraint associado_pkey primary key,
    nome         varchar(250)
);

create table votacao
(
    id          bigint not null  constraint votacao_pkey primary key,
    dataVoto         date,
    associado   bigint
        constraint fk_votacao_associado_id
            references associado,
    sessao   bigint
    constraint fk_votacao_sessao_id
            references sessao,
    sessao   bigint
    constraint fk_votacao_sessao_id
            references sessao,
    voto         varchar(3)
);