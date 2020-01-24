-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2019 at 09:00 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ofir-joyas`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `cod_Cliente` varchar(15) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `CI` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`cod_Cliente`, `Nombre`, `direccion`, `telefono`, `CI`) VALUES
('C1', 'Juan Perez', 'av. Arce', '74174188', '78945963'),
('C2', 'Maria Luna', 'calle Montenegro', '74174788', '123456789'),
('C3', 'Juan Marco', 'av. Murillo', '418529', '741852'),
('C4', 'Juan Molina', 'av. Algo', '7894561', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `cod_Empleado` varchar(15) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `CI` varchar(45) DEFAULT NULL,
  `Cargo` varchar(45) DEFAULT NULL,
  `Contraseña` varchar(45) DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`cod_Empleado`, `Nombre`, `CI`, `Cargo`, `Contraseña`, `Telefono`) VALUES
('E1', 'Joanna Martinez', '9876544', 'vendedor', '1234', '60678945'),
('E2', 'Leonardo Molina', '7418578', 'vendedor', '4321', '74185288');

-- --------------------------------------------------------

--
-- Table structure for table `joya`
--

CREATE TABLE `joya` (
  `cod_Joya` varchar(15) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Metal` varchar(45) DEFAULT NULL,
  `Peso` double DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Tipo_Joya_cod_Tipo_Joya` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `joya`
--

INSERT INTO `joya` (`cod_Joya`, `Nombre`, `Metal`, `Peso`, `Precio`, `Stock`, `Tipo_Joya_cod_Tipo_Joya`) VALUES
('J1', 'Collar de Amistad', 'Plata', 100, 50, 15, 'TJ2'),
('J2', 'Anillo de Compromiso', 'Plata con Diamante', 120, 100.99, 13, 'TJ1'),
('J3', 'Pulsera de Anillado', 'Plata', 103, 99.99, 3, 'TJ3'),
('J4', 'Collar de Oro', 'oro', 103.6, 20.99, 26, 'TJ2'),
('J5', 'Anillo de Compromiso con Diamante', 'Plata', 102, 200.5, 5, 'TJ1'),
('J6', 'Collar Simple', 'Plata', 50, 20, 20, 'TJ2');

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `cod_Pedido` varchar(15) NOT NULL,
  `Fecha Emision` date DEFAULT NULL,
  `Fecha Entrega` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `Cliente_cod_Cliente` varchar(15) NOT NULL,
  `Empleado_cod_Empleado` varchar(15) NOT NULL,
  `statusEntrega` tinyint(4) DEFAULT NULL,
  `nombreJoya` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`cod_Pedido`, `Fecha Emision`, `Fecha Entrega`, `cantidad`, `Cliente_cod_Cliente`, `Empleado_cod_Empleado`, `statusEntrega`, `nombreJoya`) VALUES
('P1', '2019-05-30', '2019-07-10', 2, 'C2', 'E1', 1, 'Collar de Corazon Partido'),
('P2', '2019-05-31', '2019-06-19', 1, 'C2', 'E2', 1, 'Anillo de Poder'),
('P3', '2019-06-06', '2019-06-27', 2, 'C4', 'E1', 0, 'Collar de la Amistad');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_joya`
--

CREATE TABLE `tipo_joya` (
  `cod_Tipo_Joya` varchar(15) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_joya`
--

INSERT INTO `tipo_joya` (`cod_Tipo_Joya`, `tipo`) VALUES
('TJ1', 'anillo'),
('TJ2', 'collar'),
('TJ3', 'pulsera');

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `cod_Venta` varchar(15) NOT NULL,
  `fecha` date DEFAULT NULL,
  `Cliente_cod_Cliente` varchar(15) NOT NULL,
  `Joya_cod_Joya` varchar(15) NOT NULL,
  `Empleado_cod_Empleado` varchar(15) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `CI` varchar(45) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`cod_Venta`, `fecha`, `Cliente_cod_Cliente`, `Joya_cod_Joya`, `Empleado_cod_Empleado`, `cantidad`, `CI`, `total`) VALUES
('V1', '2019-05-30', 'C2', 'J2', 'E1', 2, '123456789', 201.98),
('V2', '2019-05-31', 'C3', 'J1', 'E1', 5, '741852', 250),
('V3', '2019-05-31', 'C4', 'J4', 'E2', 3, '123456', 62.97),
('V4', '2019-06-06', 'C3', 'J4', 'E1', 1, '741852', 20.99);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_Cliente`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cod_Empleado`);

--
-- Indexes for table `joya`
--
ALTER TABLE `joya`
  ADD PRIMARY KEY (`cod_Joya`),
  ADD KEY `fk_Joya_Tipo_Joya1` (`Tipo_Joya_cod_Tipo_Joya`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`cod_Pedido`),
  ADD KEY `fk_Pedidio_Cliente1` (`Cliente_cod_Cliente`),
  ADD KEY `fk_Pedidio_Empleado1` (`Empleado_cod_Empleado`);

--
-- Indexes for table `tipo_joya`
--
ALTER TABLE `tipo_joya`
  ADD PRIMARY KEY (`cod_Tipo_Joya`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`cod_Venta`),
  ADD KEY `fk_Venta_Cliente1` (`Cliente_cod_Cliente`),
  ADD KEY `fk_Venta_Joya1` (`Joya_cod_Joya`),
  ADD KEY `fk_Venta_Empleado1` (`Empleado_cod_Empleado`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `joya`
--
ALTER TABLE `joya`
  ADD CONSTRAINT `fk_Joya_Tipo_Joya1` FOREIGN KEY (`Tipo_Joya_cod_Tipo_Joya`) REFERENCES `tipo_joya` (`cod_Tipo_Joya`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_Pedidio_Cliente1` FOREIGN KEY (`Cliente_cod_Cliente`) REFERENCES `cliente` (`cod_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pedidio_Empleado1` FOREIGN KEY (`Empleado_cod_Empleado`) REFERENCES `empleado` (`cod_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_Venta_Cliente1` FOREIGN KEY (`Cliente_cod_Cliente`) REFERENCES `cliente` (`cod_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Venta_Empleado1` FOREIGN KEY (`Empleado_cod_Empleado`) REFERENCES `empleado` (`cod_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Venta_Joya1` FOREIGN KEY (`Joya_cod_Joya`) REFERENCES `joya` (`cod_Joya`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
