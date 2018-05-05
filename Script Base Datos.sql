create schema sistemaTusug authorization postgres;
set search_path to sistemaTusug;--Configura la ruta hacia donde se ejecutaran las instrucciones
--drop schema sistemaTusug cascade;

create table refaccion(
	codigo_producto      int primary key not null,
	descripción_producto varchar(100)  not null,
	cantidad_producto    int,
	check(codigo_producto>=1 and codigo_producto <=800)
);

create table autobus(      
	matricula  	varchar (10) primary key,
	id					varchar(25),
    marca              	varchar(50) not null,
    numero_economico 	varchar(80) not null,      
	kilometraje			int,
	asientos			int,
	url_img				varchar(100)
);

create table poliza(
	codigo_poliza int primary key,
	matricula varchar references autobus(matricula) not null,
	descripcion varchar (100) not null,
	fecha_comienzo date not null,
	fecha_terminacion date,
	prima_pagar numeric (8,2),
	limite_indemnizacion numeric (8,2) not null
);

create table ruta(
		codigo_ruta  int primary key,
        nombre_ruta  varchar(100) not null,
        color_ruta   varchar (40) not null,
		url_img		varchar(100)
);
create table ruta_autobus
(	
	id_posesion int primary key,
	codigo_ruta int references ruta(codigo_ruta),
	matricula varchar(10) references autobus(matricula)
);
create table trabajador 
(
	rfc varchar (13) primary key,	
	nombre varchar(30) not null,			
	ap_paterno varchar(50),
	ap_materno varchar(50),
	domicilio varchar (100),
	fecha_nac date,
	fecha_contratacion date,
	estado varchar (6)not null, -- (Activo, Pasivo, Baja)
	url_img varchar (100),
	check(estado = 'activo'or estado = 'pasivo'or estado = 'baja'),
	check(fecha_nac<current_date)
);

create table chofer
(
	rfc varchar(13) references trabajador(rfc),
	licencia int not null,
	horas_trabajadas int,
	experiencia int,	--en años
	unique(rfc)
);

create table chofer_autobus
(	
	rfc varchar(13) references chofer(rfc) not null,
	matricula varchar(10) references autobus(matricula) not null
);



create table control_asistencia(
	fecha date ,
	rfc varchar(13) references trabajador(rfc),
	hora_entrada date not null,
	hora_salida date,
	observacion varchar(100),
	primary key(fecha, rfc)
);

create table expediente_permanente(
	rfc varchar(13) references trabajador(rfc)not null,
	n_faltas int ,
	n_actasadministrativas int
);

--Hacer disparador para auto incremento
--o declarar autoincrement
create table accidente(
	codigo_accidente SERIAL primary key,
	id_posesion int references ruta_autobus(id_posesion),
	fecha date not null,
	descripcion varchar(250) not null,
	lugar varchar(100),
	velocidad int
);

--hacer disparador mantenimiento
create table mantenimiento(
	codigo_m int primary key,
	matricula varchar(10) references autobus(matricula),
	fecha_ingreso date not null,
	fecha_salida date not null,
	costo_reparacion numeric(8,2) not null,
	check (fecha_ingreso>fecha_salida)
);

create table servicio(
	id_servicio int primary key not null,
	codigo_m int references mantenimiento(codigo_m)not null,
	codigo_producto int references refaccion(codigo_producto) not null,
	cantidad_producto int
);
/*=================================================================
		CONTROL DE USUARIO
===================================================================*/

create table rol(
	id_rol int primary key,
	descripcion varchar(20)
);

create table usuario(
	rfc varchar(13) references trabajador(rfc),
	id_rol int references rol(id_rol),
	contrasenia varchar (64),
	url_image varchar(100),--Siempre debe una por default
	uti_vez date
);


create table reporte(
	folio int primary key,
	fecha date,		
	tipo_reporte varchar(50),--{mantenimiento}{almacen}
	url_formato varchar (100)
);

create table control_nomina(
	fecha date,
	url_nomina varchar(100)
);