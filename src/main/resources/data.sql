
-- Inserta una persona en la tabla persona
INSERT INTO persona (id, nombre, apellido, identificacion, telefono, direccion)
VALUES
    (1, 'Juan', 'Pérez', '123456789', 3001234567, 'Calle 123, Ciudad'),
    (2, 'Ana', 'Gómez', '987654321', 3159876543, 'Avenida 456, Ciudad');

-- Inserta roles en la tabla rol (basado en el enum TipoRol)
INSERT INTO rol (id, tipo_rol)
VALUES
    (1, 'DOCENTE'),
    (2, 'DECANO'),
    (3, 'VICERRECTORIA'),
    (4, 'DIRECCIONPROGRAMA');


-- Inserta roles en la tabla rol (basado en el enum TipoRol)
INSERT INTO rol (id, tipo_rol)
VALUES
    (1, 'DOCENTE'),
    (2, 'DECANO'),
    (3, 'VICERRECTORIA'),
    (4, 'DIRECCIONPROGRAMA');


-- Inserta usuarios en la tabla usuario con relación a persona
INSERT INTO usuario (id, nombre_usuario, contrasena, persona_id)
VALUES
    (1, 'juanp', '$2a$10$D9C5qZIcz1eP0e.Xx1Z6SOXcmWJ1tFQhQPxkQXK7XrHGErbsh3s7C', 1), -- contrasena encriptada
    (2, 'anag', '$2a$10$O8Fj8UM5trUbK5T0qBpMleFHdVGaw6U3g/YpZlqlb47D3IzOxgRJu', 2); -- contrasena encriptada

-- Asigna roles a los usuarios en la tabla usuario_rol
-- Asigna el rol 'DOCENTE' al usuario 'juanp'
-- Asigna el rol 'DECANO' al usuario 'anag'
INSERT INTO usuario_rol (usuario_id, rol_id)
VALUES
    (1, 1), -- Usuario con id 1 (juanp) tiene el rol de 'DOCENTE'
    (2, 2); -- Usuario con id 2 (anag) tiene el rol de 'DECANO'
