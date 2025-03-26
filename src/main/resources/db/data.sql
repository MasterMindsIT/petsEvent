CREATE TABLE region (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE comuna (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    region_id BIGINT NOT NULL,
    CONSTRAINT fk_comuna_region FOREIGN KEY (region_id) REFERENCES region(id) ON DELETE CASCADE
);

CREATE TABLE tipo_mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE participante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo_mascota_id BIGINT NOT NULL,
    participante_id BIGINT NOT NULL,
    CONSTRAINT fk_mascota_tipo FOREIGN KEY (tipo_mascota_id) REFERENCES tipo_mascota(id) ON DELETE CASCADE,
    CONSTRAINT fk_mascota_participante FOREIGN KEY (participante_id) REFERENCES participante(id) ON DELETE CASCADE
);

CREATE TABLE evento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio TIMESTAMP NOT NULL,
    fecha_fin TIMESTAMP NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    comuna_id BIGINT NOT NULL,
    CONSTRAINT fk_evento_comuna FOREIGN KEY (comuna_id) REFERENCES comuna(id) ON DELETE CASCADE
);

CREATE TABLE evento_participante (
    evento_id BIGINT NOT NULL,
    participante_id BIGINT NOT NULL,
    PRIMARY KEY (evento_id, participante_id),
    CONSTRAINT fk_evento_participante_evento FOREIGN KEY (evento_id) REFERENCES evento(id) ON DELETE CASCADE,
    CONSTRAINT fk_evento_participante_participante FOREIGN KEY (participante_id) REFERENCES participante(id) ON DELETE CASCADE
);


-- Insertar datos en la tabla 'region'
INSERT INTO region (id, nombre) VALUES
(1, 'Región Metropolitana'),
(2, 'Región de Valparaíso'),
(3, 'Región del Biobío');

-- Insertar datos en la tabla 'comuna'
INSERT INTO comuna (id, nombre, region_id) VALUES
(1, 'Santiago', 1),
(2, 'Providencia', 1),
(3, 'Viña del Mar', 2),
(4, 'Concepción', 3);

INSERT INTO tipo_mascota (id, nombre) VALUES
(1, 'Perro'),
(2, 'Gato'),
(3, 'Ave'),
(4, 'Reptil');

-- Insertar datos en la tabla 'participante'
INSERT INTO participante (id, nombre, email) VALUES
(1, 'Juan Pérez', 'juan.perez@example.com'),
(2, 'María López', 'maria.lopez@example.com'),
(3, 'Carlos Díaz', 'carlos.diaz@example.com'),
(4, 'Ana Gómez', 'ana.gomez@example.com');

-- Insertar datos en la tabla 'mascota'
INSERT INTO mascota (id, nombre, tipo_mascota_id, participante_id) VALUES
(1, 'Firulais', 1, 1), -- Perro de Juan Pérez
(2, 'Michi', 2, 2),    -- Gato de María López
(3, 'Rex', 1, 3),      -- Perro de Carlos Díaz
(4, 'Piolín', 3, 4),   -- Ave de Ana Gómez
(5, 'Luna', 2, 1),     -- Gato adicional de Juan Pérez
(6, 'Rocky', 1, 2);    -- Perro adicional de María López


-- Insertar datos en la tabla 'evento'
INSERT INTO evento (id, nombre, descripcion, fecha_inicio, fecha_fin, ubicacion, comuna_id) VALUES
(1, 'Feria de Adopción', 'Evento para promover la adopción de mascotas', '2025-04-01 10:00:00', '2025-04-01 18:00:00', '-33.4489,-70.6693', 1),
(2, 'Carrera Canina', 'Competencia de carreras para perros', '2025-04-15 09:00:00', '2025-04-15 14:00:00', '-33.4378,-70.6106', 2),
(3, 'Exposición Felina', 'Exhibición de razas de gatos', '2025-05-10 11:00:00', '2025-05-10 17:00:00', '-33.0153,-71.5500', 3),
(4, 'Jornada de Vacunación', 'Vacunación gratuita para mascotas', '2025-06-20 08:00:00', '2025-06-20 16:00:00', '-36.8201,-73.0444', 4);

-- Insertar datos en la tabla 'evento_participante' (relación muchos a muchos)
INSERT INTO evento_participante (evento_id, participante_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 1),
(4, 2),
(4, 3);