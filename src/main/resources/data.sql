
INSERT INTO persona (nombre, apellido, identificacion, telefono, direccion, state)
VALUES
    ('Juan', 'Pérez', '123456789', '3001234567', 'Calle 123, Ciudad', true),
    ('Ana', 'Gómez', '987654321', '3159876543', 'Avenida 456, Ciudad', true );


INSERT INTO rol (tipo_rol, state)
VALUES
    ('DOCENTE',true),
    ('DECANO',true),
    ('VICERRECTORIA', true),
    ('DIRECCIONPROGRAMA', true);

-- Inserta usuarios en la tabla usuario con relación a persona
INSERT INTO usuario (nombre_usuario, contrasena, persona_id, state)
VALUES
    ('juanp', '1234', 9, true), -- ID de persona
    ('anag', '1234', 10, true); -- ID de persona


INSERT INTO usuario_rol (usuario_id, rol_id)
VALUES
    (3, 1), -- Usuario con id 1 tiene el rol de DOCENTE
    (4, 2); -- Usuario con id 2 tiene el rol de DECANO


SELECT * FROM usuario_rol;
DELETE FROM usuario_rol;

SELECT * FROM usuario;
DELETE FROM usuario;

SELECT * FROM rol;
DELETE FROM rol;

SELECT * FROM persona;
DELETE FROM persona;

