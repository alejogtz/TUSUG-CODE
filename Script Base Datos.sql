create schema sistemaTusug authorization postgres;
set search_path to sistemaTusug;--Configura la ruta hacia donde se ejecutaran las instrucciones
--drop schema sistemaTusug cascade;
--Verificado
create table insumo(
	codigo_producto      int primary key not null,
	descripción_producto varchar(100)  not null,
	cantidad_producto    int,
	--check(codigo_producto>=1 and codigo_producto <=800)
);

--Verificar si la dirección de la imagen es nula == ??????????????
--Verificado
create table autobus(      
	matricula  	        varchar (10) primary key,
	id			varchar(30) not null,
        marca              	varchar(25) not null,
        numero_economico 	varchar(25) not null,      
	kilometraje		int,
	asientos		int,
	url_img			varchar(100)
);

-- Verificado trabajador
create table trabajador 
(
	rfc varchar (13) primary key,	
	nombre varchar(30) not null,			
	ap_paterno varchar(50),
	ap_materno varchar(50),
	domicilio varchar (100),
	puesto varchar(30) not null,
	fecha_nac date,
	fecha_contratacion date,
	estado varchar (6)not null, -- (Activo, Pasivo, Baja)
	url_img varchar (100),
	--check(estado = 'activo'or estado = 'pasivo'or estado = 'baja'),
	--check(puesto = 'activo'or puesto = 'pasivo'or puesto = 'baja')
	--check(fecha_nac<current_date)
);
-- Falta la interfaz
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

-- Falta la interfazzz
create table control_asistencia(
	fecha date ,
	rfc varchar(13) references trabajador(rfc),
	hora_entrada date not null,
	hora_salida date,
	observacion varchar(100),
	primary key(fecha, rfc)
);
--Verificado, se guardarán con un disparador
create table expediente_permanente(
	rfc varchar(13) references trabajador(rfc)not null,
	n_faltas int ,
	n_actasadministrativas int
);

--Hacer disparador para auto incremento
--o declarar autoincrement
create table siniestro(
	codigo_accidente SERIAL primary key,
	id_posesion int references ruta_autobus(id_posesion),
	fecha date not null,
	descripcion varchar(250) not null,
	lugar varchar(100),
	velocidad int
);

-- Un disparador que genere automaticamente un codigo_mantenimiento
--
create table mantenimiento(
	codigo_m int primary key,
	matricula varchar(10) references autobus(matricula),
	fecha_ingreso date not null,
	fecha_salida date not null,
<<<<<<< HEAD
	solicitante varchar(25),
	responsable varchar (25),
	solicitud varchar(25),
	area_trabajo varchar(25),
	prioridad varchar(25),
	tipo_de_mantenimiento(25), 
	direccion varchar(50), 
	telefono varchar(25), 
	email(25),

=======
	costo_reparacion numeric(8,2) not null,
	--check (fecha_ingreso<fecha_salida)
>>>>>>> 1986fb0f3af70ff3e75331193214d099bf8753df
);
create table servicio(
	id_servicio int primary key not null,
	codigo_m int references mantenimiento(codigo_m)not null,
	codigo_producto int references insumo(codigo_producto) not null,
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
--Verificado
create table reporte(
	folio int primary key,
	fecha date,		
	--tipo_reporte varchar(50),--{mantenimiento}{almacen}
	nombre_reporte varchar(50),
	url_formato varchar (100)
);
<<<<<<< HEAD

create table compras(
	numero_factura int primary key not null,
	cod_provedor varchar(20),
	razon_social varchar(20),
	direccion varchar(20),
	poblacion varchar(20),
	provincia varchar(20),
	cp int ,
	persona_contacto varchar(25),
	email varchar (25),
	telefono int,
	subtotal int,
	iva int , 
	descuento int, 
	total int
	);


create table control_nomina(
	fecha date,
	url_nomina varchar(100)
);
=======
--Verificado
-- Como se genera una archivo
create table control_factura
{
	numero_factura int primary key,
	codigo_proveedor int 
}
create table control_mantenimiento
{
	codigo_m int references mantenimiento(codigo_m),
	responsable varchar (50),
	fecha_emision date 
}
>>>>>>> 1986fb0f3af70ff3e75331193214d099bf8753df
