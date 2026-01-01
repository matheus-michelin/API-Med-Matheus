create table consultas(

                          id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    medico_id bigint NOT NULL,
    paciente_id bigint NOT NULL,
    data TIMESTAMP NOT NULL,

    constraint fk_consultas_medico_id foreign key (medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key (paciente_id) references pacientes(id)
)