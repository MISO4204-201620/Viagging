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
DROP TABLE IF EXISTS TP_IMAGEN_SERVICIO;
DROP TABLE IF EXISTS TP_Servicio;
DROP TABLE IF EXISTS TP_Paquete;
DROP TABLE IF EXISTS TP_Usuario;
DROP TABLE IF EXISTS TR_PaseosEcologicos;
DROP TABLE IF EXISTS TR_Transporte;
DROP TABLE IF EXISTS TR_Alimentacion;
DROP TABLE IF EXISTS TR_Alojamiento;

CREATE TABLE TP_Modulo (
  id     SERIAL,	
  nombre VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TB_Perfil (
  id     SERIAL,
  nombre VARCHAR(20) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_PermisoPerfil (
  id       SERIAL,
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
  numeroDocumento INTEGER NOT NULL,
  correo VARCHAR(20) NULL,
  numeroCelular INTEGER NULL,
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

CREATE TABLE TR_PaseosEcologicos (
  id SERIAL,
  ciudad TEXT  NULL,
  tiempoDeRecorrido TEXT NULL,
  horario TEXT NULL,
  caracteristicas TEXT NULL,
  fecha DATE NULL,
  restricciones TEXT NULL,
  imagenPrincipal BYTEA NULL, 
  PRIMARY KEY(id)
);

CREATE TABLE TR_Transporte (
  id SERIAL,
  tipoTransporte TEXT  NULL,
  lugarOrigen TEXT NULL,
  lugarDestino TEXT NULL,
  tiempoEstimado TEXT  NULL,
  horarioInicio TEXT NULL,
  horarioFin TEXT NULL,
  restricciones TEXT  NULL,
  frecuenciaSalida TEXT NULL,
  numeroPasajeros INTEGER NULL,
  imagenPrincipal BYTEA NULL,
  PRIMARY KEY(id)
);

CREATE TABLE TR_Alimentacion (
  id SERIAL,
  ciudad TEXT NULL,
  horarioApertura TEXT NULL,
  restricciones TEXT NULL,
  caracteristicas TEXT NULL,
  precioMenor INTEGER NULL,
  precioMayor INTEGER NULL,
  imagenPrincipal BYTEA NULL, 
  PRIMARY KEY(id)
);

CREATE TABLE TR_Alojamiento (
  id SERIAL,
  ciudad TEXT  NULL,
  valorPorNoche INTEGER NULL,
  restricciones TEXT NULL,
  caracteristicas TEXT NULL,
  imagenPrincipal BYTEA NULL, 
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
  nombre VARCHAR(20) NULL,
  descripcion VARCHAR(200) NULL,
  activo BOOL NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idAlojamiento) REFERENCES TR_Alojamiento(id),
  FOREIGN KEY (idAlimentacion) REFERENCES TR_Alimentacion(id),
  FOREIGN KEY (idTransporte) REFERENCES TR_Transporte(id),
  FOREIGN KEY (idPaseosEcologicos) REFERENCES TR_PaseosEcologicos(id)
);

CREATE TABLE TP_IMAGEN_SERVICIO (
  id SERIAL,
  idServicio INTEGER  NULL,
  imagen BYTEA NULL,  
  PRIMARY KEY(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TP_Paquete (
  id SERIAL,
  idUsuario INTEGER NOT NULL,
  nombrePaquete VARCHAR(20) NULL,
  activo boolean NULL,
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

CREATE TABLE TR_Compra (
  id SERIAL,
  idServicio INTEGER NULL,
  idPaquete INTEGER NULL,
  idUsuario INTEGER NOT NULL,
  fechaCompra DATE NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);

CREATE TABLE TR_Comentario_calificacion (
  id SERIAL,
  idServicio INTEGER NULL,
  idUsuario  INTEGER NOT NULL,
  idPaquete INTEGER NULL,
  comentario VARCHAR(255) NULL,
  calificacion FLOAT NULL,
  fechaRegistro DATE NULL,
  idCompra INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idUsuario) REFERENCES TP_Usuario(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id),
  FOREIGN KEY (idCompra) REFERENCES TR_Compra(id)
);

CREATE TABLE TR_PaqueteServicio (
  id SERIAL,
  idPaquete  INTEGER NOT NULL,
  idServicio INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (idPaquete) REFERENCES TP_Paquete(id),
  FOREIGN KEY (idServicio) REFERENCES TP_Servicio(id)
);