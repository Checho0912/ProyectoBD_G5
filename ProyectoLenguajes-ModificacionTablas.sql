--Esto es para borrar todas las tablas previamente creadas
DROP TABLE DEVOLUCION CASCADE CONSTRAINTS;
DROP TABLE INGRESO CASCADE CONSTRAINTS;
DROP TABLE ENTREGA CASCADE CONSTRAINTS;
DROP TABLE TICKET_SOLICITUD CASCADE CONSTRAINTS;
DROP TABLE TICKET_AVERIA CASCADE CONSTRAINTS;
DROP TABLE TICKET_SOPORTE CASCADE CONSTRAINTS;
DROP TABLE DISPOSITIVO_DE_OFICINA CASCADE CONSTRAINTS;
DROP TABLE DISPOSITIVO_DE_COMPUTACION CASCADE CONSTRAINTS;
DROP TABLE DISPOSITIVO_NO_RETORNABLE CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;
DROP TABLE ADMINISTRADOR CASCADE CONSTRAINTS;
DROP TABLE DISPOSITIVO CASCADE CONSTRAINTS;
DROP TABLE DEPARTAMENTO CASCADE CONSTRAINTS;

-- CAMBIOS REALIZADOS:
-- 1. Se creó una tabla DISPOSITIVO base y las tablas hijas hacen referencia a ella.
-- 2. Se cambió USUARIO a ID_USUARIO en todas las tablas para evitar ambigüedad.
-- 3. Se corrigió VARCHAR por VARCHAR2.
-- 4. Se creó la tabla DEPARTAMENTO y se referenció en ADMINISTRADOR y USUARIO.
-- 5. Se eliminaron los campos redundantes de NUMERO_SERIAL fuera de DISPOSITIVO.
-- 6. Se agregó ID_TICKET en ENTREGA, INGRESO y DEVOLUCION para trazabilidad.
-- 7. Se completaron todas las FK con columna objetivo.

CREATE TABLE DEPARTAMENTO (
  ID_DEPARTAMENTO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  NOMBRE VARCHAR2(100) NOT NULL
);

CREATE TABLE ADMINISTRADOR(
  ID_ADMINISTRADOR NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  NOMBRE VARCHAR2(50),
  APELLIDOS VARCHAR2(50),
  CORREO VARCHAR2(100),
  PASSWORD VARCHAR2(100),
  ID_DEPARTAMENTO NUMBER,
  CONSTRAINT fk_admin_departamento FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO)
);

CREATE TABLE USUARIO (
  ID_USUARIO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  NOMBRE VARCHAR2(50),
  APELLIDOS VARCHAR2(50),
  CORREO VARCHAR2(100),
  ID_DEPARTAMENTO NUMBER,
  CONSTRAINT fk_usuario_departamento FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO)
);

CREATE TABLE DISPOSITIVO (
  ID_DISPOSITIVO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TIPO_DISPOSITIVO VARCHAR2(50), -- Ej: 'COMPUTACION', 'OFICINA', 'NO_RETORNABLE'
  MANUFACTURADOR VARCHAR2(100),
  MODELO VARCHAR2(100),
  NUMERO_SERIAL VARCHAR2(100),
  ID_USUARIO NUMBER,
  CONSTRAINT fk_dispositivo_usuario FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

-- Opcionalmente, puedes seguir con tablas hijas si necesitas atributos exclusivos.

CREATE TABLE TICKET_SOPORTE (
  ID_TICKET NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  DESCRIPCION VARCHAR2(100),
  FECHA DATE,
  STATUS VARCHAR2(50),
  FECHA_RESOLUCION DATE,
  ID_ADMINISTRADOR NUMBER,
  ID_USUARIO NUMBER,
  CONSTRAINT fk_ticket_admin FOREIGN KEY (ID_ADMINISTRADOR) REFERENCES ADMINISTRADOR(ID_ADMINISTRADOR),
  CONSTRAINT fk_ticket_usuario FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

CREATE TABLE TICKET_AVERIA (
  ID_TICKET NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  ID_DISPOSITIVO NUMBER,
  DESCRIPCION VARCHAR2(250),
  FECHA DATE,
  STATUS VARCHAR2(50),
  FECHA_RESOLUCION DATE,
  ID_ADMINISTRADOR NUMBER,
  ID_USUARIO NUMBER,
  CONSTRAINT fk_averia_admin FOREIGN KEY (ID_ADMINISTRADOR) REFERENCES ADMINISTRADOR(ID_ADMINISTRADOR),
  CONSTRAINT fk_averia_usuario FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
  CONSTRAINT fk_averia_dispositivo FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO(ID_DISPOSITIVO)
);

CREATE TABLE TICKET_SOLICITUD (
  ID_TICKET NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  DESCRIPCION VARCHAR2(250),
  FECHA DATE,
  STATUS VARCHAR2(50),
  FECHA_RESOLUCION DATE,
  ID_ADMINISTRADOR NUMBER,
  ID_USUARIO NUMBER,
  TIPO_SOLICITUD VARCHAR2(100),
  CONSTRAINT fk_solicitud_admin FOREIGN KEY (ID_ADMINISTRADOR) REFERENCES ADMINISTRADOR(ID_ADMINISTRADOR),
  CONSTRAINT fk_solicitud_usuario FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

CREATE TABLE ENTREGA (
  ID_ENTREGA NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  FECHA_ENTREGA DATE,
  ID_DISPOSITIVO NUMBER,
  ID_TICKET NUMBER,
  CONSTRAINT fk_entrega_dispositivo FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO(ID_DISPOSITIVO),
  CONSTRAINT fk_entrega_ticket FOREIGN KEY (ID_TICKET) REFERENCES TICKET_SOLICITUD(ID_TICKET)
);

CREATE TABLE INGRESO (
  ID_INGRESO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  FECHA_INGRESO DATE,
  ID_DISPOSITIVO NUMBER,
  ID_TICKET NUMBER,
  CONSTRAINT fk_ingreso_dispositivo FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO(ID_DISPOSITIVO),
  CONSTRAINT fk_ingreso_ticket FOREIGN KEY (ID_TICKET) REFERENCES TICKET_SOLICITUD(ID_TICKET)
);

CREATE TABLE DEVOLUCION (
  ID_DEVOLUCION NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  FECHA_DEVOLUCION DATE,
  ID_DISPOSITIVO NUMBER,
  ID_TICKET NUMBER,
  CONSTRAINT fk_devolucion_dispositivo FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO(ID_DISPOSITIVO),
  CONSTRAINT fk_devolucion_ticket FOREIGN KEY (ID_TICKET) REFERENCES TICKET_AVERIA(ID_TICKET)
);


-- Inserts para testear


INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Desarrollo de Software');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Soporte Técnico');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Infraestructura');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Recursos Humanos');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Administración');

select * from departamento;

INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
VALUES ('Ana', 'Rodríguez', 'ana.rodriguez@techcorp.com', 'admin123', 1);

INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
VALUES ('Luis', 'Gómez', 'luis.gomez@techcorp.com', 'admin456', 2);

INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
VALUES ('María', 'López', 'maria.lopez@techcorp.com', 'admin789', 3);

INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
VALUES ('Carlos', 'Méndez', 'carlos.mendez@techcorp.com', 'admin321', 4);

INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
VALUES ('Laura', 'Castro', 'laura.castro@techcorp.com', 'admin654', 5);


INSERT INTO USUARIO (NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO)
VALUES ('Pedro', 'Pérez', 'pedro.perez@techcorp.com', 1);

INSERT INTO USUARIO (NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO)
VALUES ('Sofía', 'Jiménez', 'sofia.jimenez@techcorp.com', 2);

INSERT INTO USUARIO (NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO)
VALUES ('David', 'Ramírez', 'david.ramirez@techcorp.com', 3);

INSERT INTO USUARIO (NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO)
VALUES ('Lucía', 'Vargas', 'lucia.vargas@techcorp.com', 4);

INSERT INTO USUARIO (NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO)
VALUES ('Jorge', 'Salas', 'jorge.salas@techcorp.com', 5);

-- dispositivos
INSERT INTO DISPOSITIVO (TIPO_DISPOSITIVO, MANUFACTURADOR, MODELO, NUMERO_SERIAL, ID_USUARIO)
VALUES ('COMPUTACION', 'Dell', 'XPS 13', 'SN12345', 1);

INSERT INTO DISPOSITIVO (TIPO_DISPOSITIVO, MANUFACTURADOR, MODELO, NUMERO_SERIAL, ID_USUARIO)
VALUES ('OFICINA', 'HP', 'LaserJet Pro', 'SN67890', 2);

INSERT INTO DISPOSITIVO (TIPO_DISPOSITIVO, MANUFACTURADOR, MODELO, NUMERO_SERIAL, ID_USUARIO)
VALUES ('NO_RETORNABLE', 'Logitech', 'MX Master 3', 'SN11223', 3);

INSERT INTO DISPOSITIVO (TIPO_DISPOSITIVO, MANUFACTURADOR, MODELO, NUMERO_SERIAL, ID_USUARIO)
VALUES ('COMPUTACION', 'Lenovo', 'ThinkPad X1', 'SN44556', 4);

INSERT INTO DISPOSITIVO (TIPO_DISPOSITIVO, MANUFACTURADOR, MODELO, NUMERO_SERIAL, ID_USUARIO)
VALUES ('OFICINA', 'Brother', 'HL-L2350DW', 'SN77889', 5);


--tickets de soporte
INSERT INTO TICKET_SOPORTE (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES ('No se puede iniciar sesión', SYSDATE, 'Abierto', NULL, 1, 1);

INSERT INTO TICKET_SOPORTE (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES ('Error en Outlook', SYSDATE-5, 'Resuelto', SYSDATE-2, 2, 2);

INSERT INTO TICKET_SOPORTE (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES ('Pantalla azul en laptop', SYSDATE-10, 'Abierto', NULL, 3, 3);

INSERT INTO TICKET_SOPORTE (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES ('VPN no conecta', SYSDATE-3, 'Resuelto', SYSDATE-1, 4, 4);

INSERT INTO TICKET_SOPORTE (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES ('No funciona el teclado', SYSDATE-1, 'En Proceso', NULL, 5, 5);




INSERT INTO TICKET_AVERIA (ID_DISPOSITIVO, DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES (1, 'Laptop no enciende', SYSDATE-7, 'Pendiente', NULL, 1, 1);

INSERT INTO TICKET_AVERIA (ID_DISPOSITIVO, DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES (2, 'Impresora no responde', SYSDATE-5, 'Resuelto', SYSDATE-3, 2, 2);

INSERT INTO TICKET_AVERIA (ID_DISPOSITIVO, DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES (3, 'Mouse defectuoso', SYSDATE-6, 'Resuelto', SYSDATE-4, 3, 3);

INSERT INTO TICKET_AVERIA (ID_DISPOSITIVO, DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES (4, 'Laptop sobrecalentada', SYSDATE-4, 'Abierto', NULL, 4, 4);

INSERT INTO TICKET_AVERIA (ID_DISPOSITIVO, DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO)
VALUES (5, 'Problemas de red', SYSDATE-2, 'En Proceso', NULL, 5, 5);


INSERT INTO TICKET_SOLICITUD (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO, TIPO_SOLICITUD)
VALUES ('Solicitud de nuevo monitor', SYSDATE-10, 'Aprobado', SYSDATE-9, 1, 1, 'Equipo');

INSERT INTO TICKET_SOLICITUD (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO, TIPO_SOLICITUD)
VALUES ('Acceso a Jira', SYSDATE-7, 'Aprobado', SYSDATE-6, 2, 2, 'Software');

INSERT INTO TICKET_SOLICITUD (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO, TIPO_SOLICITUD)
VALUES ('Cambio de mouse', SYSDATE-5, 'Rechazado', SYSDATE-4, 3, 3, 'Equipo');

INSERT INTO TICKET_SOLICITUD (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO, TIPO_SOLICITUD)
VALUES ('Solicitud de licencia de Office', SYSDATE-4, 'Pendiente', NULL, 4, 4, 'Software');

INSERT INTO TICKET_SOLICITUD (DESCRIPCION, FECHA, STATUS, FECHA_RESOLUCION, ID_ADMINISTRADOR, ID_USUARIO, TIPO_SOLICITUD)
VALUES ('Teclado ergonómico', SYSDATE-3, 'Aprobado', SYSDATE-2, 5, 5, 'Equipo');


INSERT INTO ENTREGA (FECHA_ENTREGA, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-9, 1, 1);

INSERT INTO ENTREGA (FECHA_ENTREGA, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-6, 2, 2);

INSERT INTO ENTREGA (FECHA_ENTREGA, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-4, 3, 3);

INSERT INTO ENTREGA (FECHA_ENTREGA, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-2, 4, 4);

INSERT INTO ENTREGA (FECHA_ENTREGA, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-1, 5, 5);


INSERT INTO INGRESO (FECHA_INGRESO, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-8, 1, 1);

INSERT INTO INGRESO (FECHA_INGRESO, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-6, 2, 2);

INSERT INTO INGRESO (FECHA_INGRESO, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-5, 3, 3);

INSERT INTO INGRESO (FECHA_INGRESO, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-3, 4, 4);

INSERT INTO INGRESO (FECHA_INGRESO, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-1, 5, 5);


INSERT INTO DEVOLUCION (FECHA_DEVOLUCION, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-5, 1, 1);

INSERT INTO DEVOLUCION (FECHA_DEVOLUCION, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-4, 2, 2);

INSERT INTO DEVOLUCION (FECHA_DEVOLUCION, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-3, 3, 3);

INSERT INTO DEVOLUCION (FECHA_DEVOLUCION, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-2, 4, 4);

INSERT INTO DEVOLUCION (FECHA_DEVOLUCION, ID_DISPOSITIVO, ID_TICKET)
VALUES (SYSDATE-1, 5, 5);

commit;
select * FROM administrador;

--PAQUETE DE TABLA DEPARTAMENTO--

CREATE OR REPLACE PACKAGE paquete_departamento AS
  PROCEDURE insertar_departamento(p_nombre VARCHAR2);
  PROCEDURE actualizar_departamento(p_id NUMBER, p_nombre VARCHAR2);
  PROCEDURE eliminar_departamento(p_id NUMBER);
  PROCEDURE listar_departamentos;
END paquete_departamento;
/

CREATE OR REPLACE PACKAGE BODY paquete_departamento AS
  PROCEDURE insertar_departamento(p_nombre VARCHAR2) IS
  BEGIN
    INSERT INTO departamento(nombre) VALUES (p_nombre);
  END;

  PROCEDURE actualizar_departamento(p_id NUMBER, p_nombre VARCHAR2) IS
  BEGIN
    UPDATE departamento SET nombre = p_nombre WHERE id_departamento = p_id;
  END;

  PROCEDURE eliminar_departamento(p_id NUMBER) IS
  BEGIN
    DELETE FROM departamento WHERE id_departamento = p_id;
  END;

  PROCEDURE listar_departamentos IS
    CURSOR c_dep IS SELECT * FROM departamento;
    v_dep departamento%ROWTYPE;
  BEGIN
    OPEN c_dep;
    LOOP
      FETCH c_dep INTO v_dep;
      EXIT WHEN c_dep%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_dep.id_departamento || ' - Nombre: ' || v_dep.nombre);
    END LOOP;
    CLOSE c_dep;
  END;
END paquete_departamento;
/

--PAQUETE DE TABLA ADMINISTRADOR--
CREATE OR REPLACE PACKAGE paquete_administrador AS
  PROCEDURE insertar_administrador(
    p_nombre IN VARCHAR2,
    p_apellidos IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_password IN VARCHAR2,
    p_id_departamento IN NUMBER
  );

  PROCEDURE actualizar_administrador(
    p_id_administrador IN NUMBER,
    p_nombre IN VARCHAR2,
    p_apellidos IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_password IN VARCHAR2,
    p_id_departamento IN NUMBER
  );

  PROCEDURE eliminar_administrador(p_id_administrador IN NUMBER);

  PROCEDURE listar_administradores; 
END paquete_administrador;
/

CREATE OR REPLACE PACKAGE BODY paquete_administrador AS

  PROCEDURE insertar_administrador(
    p_nombre IN VARCHAR2,
    p_apellidos IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_password IN VARCHAR2,
    p_id_departamento IN NUMBER
  ) IS
  BEGIN
    INSERT INTO ADMINISTRADOR (NOMBRE, APELLIDOS, CORREO, PASSWORD, ID_DEPARTAMENTO)
    VALUES (p_nombre, p_apellidos, p_correo, p_password, p_id_departamento);
  END insertar_administrador;

  PROCEDURE actualizar_administrador(
    p_id_administrador IN NUMBER,
    p_nombre IN VARCHAR2,
    p_apellidos IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_password IN VARCHAR2,
    p_id_departamento IN NUMBER
  ) IS
  BEGIN
    UPDATE ADMINISTRADOR
    SET NOMBRE = p_nombre,
        APELLIDOS = p_apellidos,
        CORREO = p_correo,
        PASSWORD = p_password,
        ID_DEPARTAMENTO = p_id_departamento
    WHERE ID_ADMINISTRADOR = p_id_administrador;
  END actualizar_administrador;

  PROCEDURE eliminar_administrador(p_id_administrador IN NUMBER) IS
  BEGIN
    DELETE FROM ADMINISTRADOR
    WHERE ID_ADMINISTRADOR = p_id_administrador;
  END eliminar_administrador;


  PROCEDURE listar_administradores IS
    CURSOR cur_admin IS
      SELECT ID_ADMINISTRADOR, NOMBRE, APELLIDOS, CORREO, ID_DEPARTAMENTO
      FROM ADMINISTRADOR;

    v_id            ADMINISTRADOR.ID_ADMINISTRADOR%TYPE;
    v_nombre        ADMINISTRADOR.NOMBRE%TYPE;
    v_apellidos     ADMINISTRADOR.APELLIDOS%TYPE;
    v_correo        ADMINISTRADOR.CORREO%TYPE;
    v_departamento  ADMINISTRADOR.ID_DEPARTAMENTO%TYPE;

  BEGIN
    OPEN cur_admin;
    LOOP
      FETCH cur_admin INTO v_id, v_nombre, v_apellidos, v_correo, v_departamento;
      EXIT WHEN cur_admin%NOTFOUND;

      DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || 
                           ' | Nombre: ' || v_nombre || ' ' || v_apellidos ||
                           ' | Correo: ' || v_correo ||
                           ' | Departamento: ' || v_departamento);
    END LOOP;
    CLOSE cur_admin;
  END listar_administradores;

END paquete_administrador;
/







