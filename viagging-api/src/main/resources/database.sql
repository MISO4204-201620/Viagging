DROP TABLE IF EXISTS TR_PermisoPerfil;
DROP TABLE IF EXISTS TP_Modulo;
DROP TABLE IF EXISTS TR_CuentaAcceso;
DROP TABLE IF EXISTS TB_Perfil;
DROP TABLE IF EXISTS TP_Mensaje;
DROP TABLE IF EXISTS TP_Conversacion;
DROP TABLE IF EXISTS TR_Pregunta;
DROP TABLE IF EXISTS TR_Movimiento;
DROP TABLE IF EXISTS TR_PaqueteServicio;
DROP TABLE IF EXISTS TR_Comentario_calificacion;
DROP TABLE IF EXISTS TR_Compra;
DROP TABLE IF EXISTS TP_Compra;
DROP TABLE IF EXISTS TP_Imagen_servicio;
DROP TABLE IF EXISTS TR_Caracteristica_servicio;
DROP TABLE IF EXISTS TR_Caracteristica;
DROP TABLE IF EXISTS TP_Servicio;
DROP TABLE IF EXISTS TP_Paquete;
DROP TABLE IF EXISTS TP_Orden;
DROP TABLE IF EXISTS TP_Transaccion;
DROP TABLE IF EXISTS TP_Usuario;
DROP TABLE IF EXISTS TR_PaseoEcologico;
DROP TABLE IF EXISTS TR_PaseosEcologicos;
DROP TABLE IF EXISTS TR_Transporte;
DROP TABLE IF EXISTS TR_Alimentacion;
DROP TABLE IF EXISTS TR_Alojamiento;
DROP TABLE IF EXISTS TP_PreguntasFrecuentes;
DROP TABLE IF EXISTS TP_ListaDeseos;

CREATE TABLE TP_Modulo (
  id SERIAL,
  nombre VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TB_Perfil (
  id SERIAL,
  nombre VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_PermisoPerfil (
  id SERIAL,
  idModulo INTEGER NOT NULL,
  idPerfil INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idModulo) REFERENCES TP_Modulo(id),
  FOREIGN KEY (idPerfil) REFERENCES TB_Perfil(id)
);

CREATE TABLE TP_Usuario (
  id SERIAL,
  login VARCHAR(20) NULL,
  password VARCHAR(200) NULL,
  primerNombre VARCHAR(45) NULL,
  segundoNombre VARCHAR(20) NULL,
  primerApellido VARCHAR(20) NULL,
  segundoApellido VARCHAR(20) NULL,
  tipoDocumento VARCHAR(20) NOT NULL,
  numeroDocumento VARCHAR(20) NOT NULL,
  correo VARCHAR(50) NULL,
  numeroCelular VARCHAR(20) NULL,
  direccion1 VARCHAR(120) NULL,
  direccion2 VARCHAR(120) NULL,
  ciudad VARCHAR(120) NULL,
  pais VARCHAR(50) NULL,
  estado VARCHAR(120) NULL,
  zipcode VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_CuentaAcceso (
  id SERIAL,
  idPerfil INTEGER NOT NULL,
  idUsuario INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idPerfil) REFERENCES TB_Perfil(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id)
);

CREATE TABLE TP_Conversacion (
  id SERIAL,
  IdUsuarioUno INTEGER NULL,
  IdUsuarioDos INTEGER NULL,
  fechaUltimoMensaje DATE NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (IdUsuarioUno) REFERENCES TP_Usuario(id),
  FOREIGN KEY (IdUsuarioDos) REFERENCES TP_Usuario(id)
);

CREATE TABLE TP_Mensaje (
  id SERIAL,
  idConversacion INTEGER NOT NULL,
  idMensajePadre INTEGER NULL,
  mensaje TEXT NULL,
  fecha DATE NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idConversacion) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idMensajePadre) REFERENCES TP_Mensaje(id)
);

CREATE TABLE TR_PaseoEcologico (
  id SERIAL,
  ciudad TEXT NULL,
  tiempoDeRecorrido TEXT NULL,
  horario TEXT NULL,
  fecha DATE NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_Transporte (
  id SERIAL,
  tipoTransporte TEXT NULL,
  lugarOrigen TEXT NULL,
  lugarDestino TEXT NULL,
  tiempoEstimado TEXT NULL,
  horarioInicio TEXT NULL,
  horarioFin TEXT NULL,
  frecuenciaSalida TEXT NULL,
  numeroPasajeros INTEGER NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_Alimentacion (
  id SERIAL,
  ciudad TEXT NULL,
  horarioApertura TEXT NULL,
  horarioCierre TEXT NULL,
  precioMenor INTEGER NULL,
  precioMayor INTEGER NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_Alojamiento (
  id SERIAL,
  ciudad TEXT NULL,
  valorPorNoche INTEGER NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TP_Servicio (
  id SERIAL,
  idUsuario INTEGER NOT NULL,
  idAlojamiento INTEGER NULL,
  idAlimentacion INTEGER NULL,
  idTransporte INTEGER NULL,
  idPaseosEcologicos INTEGER NULL,
  precio INTEGER NULL,
  nombre VARCHAR(100) NULL,
  descripcion VARCHAR(200) NULL,
  activo BOOL NULL,
  imagenPrincipal BYTEA NULL,
  restricciones TEXT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idAlojamiento) REFERENCES TR_Alojamiento(id),
  FOREIGN KEY (idAlimentacion) REFERENCES TR_Alimentacion(id),
  FOREIGN KEY (idTransporte) REFERENCES TR_Transporte(id),
  FOREIGN KEY (idPaseosEcologicos) REFERENCES TR_PaseoEcologico(id)
);

CREATE TABLE TP_IMAGEN_SERVICIO (
  id SERIAL,
  idServicio INTEGER NULL,
  imagen BYTEA NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TP_Paquete (
  id SERIAL,
  idUsuario INTEGER NOT NULL,
  nombrePaquete VARCHAR(100) NULL,
  descripcion VARCHAR(200) NULL,
  activo boolean NULL,
  precio INTEGER  NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id)
);

CREATE TABLE TR_Movimiento (
  id SERIAL,
  idUsuario INTEGER NULL,
  idPaquete INTEGER NULL,
  idServicio INTEGER NULL,
  accion VARCHAR NOT NULL,
  fecha DATE NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TR_Pregunta (
  id SERIAL,
  idUsuario INTEGER NULL,
  idPaquete INTEGER NULL,
  idServicio INTEGER NULL,
  pregunta VARCHAR NULL,
  respuesta VARCHAR NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TP_Transaccion (
	id SERIAL,
	medioPago VARCHAR(50) NOT NULL,
	valor NUMERIC NOT NULL,
	nombrePagador VARCHAR(200) NOT NULL,
	numeroTarjeta VARCHAR(20) NOT NULL,
	codigoSeguridad VARCHAR(4) NOT NULL,
	mesVencimiento VARCHAR(2) NOT NULL,
	annoVencimiento VARCHAR(2) NOT NULL,
	cuotas INTEGER NOT NULL,
	estado VARCHAR(30) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE TP_Orden (
	id SERIAL,
	idUsuario INTEGER NOT NULL,
	idTransaccion INTEGER NOT NULL,
	fechaCompra DATE NOT NULL,
	estado VARCHAR(30) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
	FOREIGN KEY (idTransaccion) REFERENCES TP_Transaccion(id)
);

CREATE TABLE TP_Compra (
	id SERIAL,
	idServicio INTEGER NULL,
	idPaquete INTEGER NULL,
	idOrden INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
	FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id),
	FOREIGN KEY (idOrden) REFERENCES TP_Orden(id)
);

CREATE TABLE TR_Comentario_calificacion (
  id SERIAL,
  idServicio INTEGER NULL,
  idUsuario INTEGER NOT NULL,
  idPaquete INTEGER NULL,
  comentario VARCHAR(255) NULL,
  calificacion FLOAT NULL,
  fechaRegistro DATE NULL,
  idCompra INTEGER NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id),
  FOREIGN KEY (idCompra) REFERENCES TP_Compra(id)
);

CREATE TABLE TR_PaqueteServicio (
  id SERIAL,
  idPaquete INTEGER NOT NULL,
  idServicio INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TR_Caracteristica (
  id SERIAL,
  categoria text NULL,
  valor text NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_Caracteristica_servicio (
  id SERIAL,
  idCaracteristica INTEGER NOT NULL,
  idServicio INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idCaracteristica) REFERENCES TR_Caracteristica(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TP_PreguntasFrecuentes (
  id SERIAL,
  titulo VARCHAR(100),
  descripcion VARCHAR(300),
  PRIMARY KEY(id)
);

CREATE TABLE TP_ListaDeseos (
  id SERIAL,
  idUsuario INTEGER NOT NULL,
  idServicio INTEGER NULL,
  idPaquete INTEGER NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id)
);

-- Inserts para tipos de perfil
INSERT INTO tb_perfil (id,nombre) VALUES ('1','Usuario');
INSERT INTO tb_perfil (id,nombre) VALUES ('2','Proveedor');
INSERT INTO tb_perfil (id,nombre) VALUES ('3','Administrador');

INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('1','ALOJAMIENTO','PISCINA');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('2','ALOJAMIENTO','BAR');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('3','ALOJAMIENTO','RESTAURANTE');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('4','ALOJAMIENTO','LAVANDERIA');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('5','ALIMENTACION','DESAYUNO');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('6','ALIMENTACION','ALMUERZO');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('7','ALIMENTACION','CENA');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('8','TRANSPORTE','AIRE_ACONDICIONADO');
INSERT INTO tr_caracteristica (id,categoria,valor) VALUES ('9','PASEOECOLOGICO','REFRIGERIO');
