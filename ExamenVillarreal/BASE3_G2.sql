/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     04/08/2021 20:14:33                          */
/*==============================================================*/


drop table PER_PERSONA;

drop table PER_PERSONA_DIRECCION;

drop table PER_TIPO_DIRECCION;

/*==============================================================*/
/* Table: PER_PERSONA                                           */
/*==============================================================*/
create table PER_PERSONA (
   COD_PERSONA          NUMERIC(10)          not null,
   COD_EMPRESA          VARCHAR(8)           null,
   FECHA_INGRESO        DATE                 null,
   NOMBRES              VARCHAR(250)         null,
   NOMBRE1              VARCHAR(50)          null,
   NOMBRE2              VARCHAR(50)          null,
   APELLIDO1            VARCHAR(50)          null,
   APELLIDO2            VARCHAR(50)          null,
   constraint PK_PER_PERSONA primary key (COD_PERSONA)
);

/*==============================================================*/
/* Table: PER_PERSONA_DIRECCION                                 */
/*==============================================================*/
create table PER_PERSONA_DIRECCION (
   COD_PERSONA          NUMERIC(10)          not null,
   SEC_PERSONA_DIRECCION NUMERIC(8)           not null,
   COD_TIPO_DIRECCION   VARCHAR(8)           null,
   CALLE_PRINCIPAL      VARCHAR(100)         null,
   NUMERACION           VARCHAR(15)          null,
   CALLE_SECUNDARIA     VARCHAR(2)           null,
   BARRIO               VARCHAR(100)         null,
   POR_OMISION          VARCHAR(1)           null
      constraint CKC_POR_OMISION_PER_PERS check (POR_OMISION is null or (POR_OMISION in ('S','N'))),
   constraint PK_PER_PERSONA_DIRECCION primary key (COD_PERSONA, SEC_PERSONA_DIRECCION)
);

/*==============================================================*/
/* Table: PER_TIPO_DIRECCION                                    */
/*==============================================================*/
create table PER_TIPO_DIRECCION (
   COD_TIPO_DIRECCION   VARCHAR(8)           not null,
   NOMBRE               VARCHAR(100)         null,
   OBSERVACION          VARCHAR(4000)        null,
   ESTADO               VARCHAR(3)           null
      constraint CKC_ESTADO_PER_TIPO check (ESTADO is null or (ESTADO in ('ACT','INA'))),
   constraint PK_PER_TIPO_DIRECCION primary key (COD_TIPO_DIRECCION)
);

alter table PER_PERSONA_DIRECCION
   add constraint FK_PER_PERS_FK_PERSON_PER_PERS foreign key (COD_PERSONA)
      references PER_PERSONA (COD_PERSONA)
      on delete restrict on update restrict;

alter table PER_PERSONA_DIRECCION
   add constraint FK_PER_PERS_FK_PERSON_PER_TIPO foreign key (COD_TIPO_DIRECCION)
      references PER_TIPO_DIRECCION (COD_TIPO_DIRECCION)
      on delete restrict on update restrict;

