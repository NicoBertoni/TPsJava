-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2023 a las 21:00:57
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `idComentario` int(10) NOT NULL,
  `comentario` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_avance` date DEFAULT NULL,
  `idTarea` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`idComentario`, `comentario`, `fecha_avance`, `idTarea`) VALUES
(1, 'bueno estoy haciendi un comentario', '2023-06-19', 13),
(3, '#FINALIZADA#', '2023-06-20', 15),
(4, 'Calcular porcentaje con los metodos de cantidad de tareaData y EstadoTareaData', '2023-06-20', 16),
(5, 'No dejar comentar en tareas que ya\nestan finalizadas', '2023-06-20', 16),
(6, '#FINALIZADA#', '2023-06-20', 16),
(7, '#FINALIZADA#', '2023-06-20', 17),
(8, '#FINALIZADA#', '2023-06-20', 18),
(9, '#FINALIZADA#', '2023-06-20', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `idEquipo` int(10) NOT NULL,
  `idProyecto` int(10) DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`idEquipo`, `idProyecto`, `nombre`, `fecha_creacion`, `estado`) VALUES
(29, 13, 'g3', '2023-06-19', 0),
(30, 13, 'g4', '2023-06-19', 0),
(31, 13, 'Eq1', '2023-06-19', 0),
(32, 13, 'Equipo 3', '2023-06-20', 1),
(33, 14, 'Otro Equipo', '2023-06-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipomiembros`
--

CREATE TABLE `equipomiembros` (
  `idMiembroEq` int(10) NOT NULL,
  `fecha_incorporacion` date DEFAULT NULL,
  `idEquipo` int(10) DEFAULT NULL,
  `idMiembro` int(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `equipomiembros`
--

INSERT INTO `equipomiembros` (`idMiembroEq`, `fecha_incorporacion`, `idEquipo`, `idMiembro`, `estado`) VALUES
(54, '2023-06-19', 29, 27, 0),
(55, '2023-06-19', 30, 27, 0),
(56, '2023-06-19', 31, 27, 0),
(57, '2023-06-19', 31, 28, 0),
(58, '2023-06-19', 31, 29, 0),
(59, '2023-06-19', 31, 30, 0),
(60, '2023-06-20', 32, 27, 1),
(61, '2023-06-20', 32, 28, 1),
(62, '2023-06-20', 33, 29, 1),
(63, '2023-06-20', 33, 30, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadotarea`
--

CREATE TABLE `estadotarea` (
  `idEstadoTarea` int(10) NOT NULL,
  `idTarea` int(10) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estadotarea`
--

INSERT INTO `estadotarea` (`idEstadoTarea`, `idTarea`, `fecha`) VALUES
(2, 15, '2023-06-20'),
(3, 16, '2023-06-20'),
(4, 17, '2023-06-20'),
(5, 18, '2023-06-20'),
(6, 19, '2023-06-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembro`
--

CREATE TABLE `miembro` (
  `idMiembro` int(10) NOT NULL,
  `dni` varchar(10) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellido` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`idMiembro`, `dni`, `apellido`, `nombre`, `estado`) VALUES
(27, '35765481', 'Becerra', 'Juan', 1),
(28, '33333333', 'Cabrera', 'Gonzalo', 1),
(29, '44444444', 'Calderon', 'Gonzalo', 1),
(30, '55555555', 'Bertoni', 'Nicolas', 1),
(31, '40565789', 'Priotti', 'Paula', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `idProyecto` int(10) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`idProyecto`, `nombre`, `descripcion`, `fecha_inicio`, `estado`) VALUES
(13, 'Ges', 'ges', '2023-06-01', 1),
(14, 'Proyecto 2', 'Prueba', '2023-06-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE `tarea` (
  `idTarea` int(10) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `idMiembroEq` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`idTarea`, `nombre`, `fecha_creacion`, `fecha_cierre`, `estado`, `idMiembroEq`) VALUES
(12, 'tarea1 ', '2023-06-19', '2023-06-22', 0, 55),
(13, 'T1', '2023-06-19', '2023-06-21', 0, 56),
(14, 'Vistas', '2023-06-19', '2023-06-20', 0, 57),
(15, 'Vistas', '2023-06-20', '2023-06-22', 1, 60),
(16, 'Calcular Progreso', '2023-06-20', '2023-06-21', 1, 60),
(17, 'Tarea 3', '2023-06-20', '2023-06-22', 1, 61),
(18, '4ta Tarea', '2023-06-20', '2023-06-21', 1, 61),
(19, 'Tarea NIco', '2023-06-20', '2023-06-21', 1, 63);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`idComentario`),
  ADD KEY `idTarea` (`idTarea`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`idEquipo`),
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indices de la tabla `equipomiembros`
--
ALTER TABLE `equipomiembros`
  ADD PRIMARY KEY (`idMiembroEq`),
  ADD KEY `idEquipo` (`idEquipo`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `estadotarea`
--
ALTER TABLE `estadotarea`
  ADD PRIMARY KEY (`idEstadoTarea`),
  ADD KEY `fk_estadotarea_tarea` (`idTarea`);

--
-- Indices de la tabla `miembro`
--
ALTER TABLE `miembro`
  ADD PRIMARY KEY (`idMiembro`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`idProyecto`);

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`idTarea`),
  ADD KEY `idMiembroEq` (`idMiembroEq`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `idComentario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `idEquipo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `equipomiembros`
--
ALTER TABLE `equipomiembros`
  MODIFY `idMiembroEq` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT de la tabla `estadotarea`
--
ALTER TABLE `estadotarea`
  MODIFY `idEstadoTarea` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `miembro`
--
ALTER TABLE `miembro`
  MODIFY `idMiembro` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `idProyecto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `idTarea` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`idTarea`) REFERENCES `tarea` (`idTarea`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyecto` (`idProyecto`);

--
-- Filtros para la tabla `equipomiembros`
--
ALTER TABLE `equipomiembros`
  ADD CONSTRAINT `equipomiembros_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`idEquipo`),
  ADD CONSTRAINT `equipomiembros_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembro` (`idMiembro`);

--
-- Filtros para la tabla `estadotarea`
--
ALTER TABLE `estadotarea`
  ADD CONSTRAINT `fk_estadotarea_tarea` FOREIGN KEY (`idTarea`) REFERENCES `tarea` (`idTarea`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`idMiembroEq`) REFERENCES `equipomiembros` (`idMiembroEq`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
