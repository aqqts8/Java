-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2024 at 11:28 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_qlnv`
--

-- --------------------------------------------------------

--
-- Table structure for table `bangcap`
--

CREATE TABLE `bangcap` (
  `mabangcap` int(11) NOT NULL,
  `tenbangcap` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `bangcap`
--

INSERT INTO `bangcap` (`mabangcap`, `tenbangcap`) VALUES
(1, 'Cao Đẳng'),
(2, 'Đại Học'),
(3, 'Thạc Sĩ'),
(4, 'Tiến Sĩ'),
(5, 'Trung Cấp');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` int(10) NOT NULL,
  `HoTenNhanVien` varchar(50) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `DienThoai` int(10) NOT NULL,
  `MaBangCap` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTenNhanVien`, `NgaySinh`, `DiaChi`, `DienThoai`, `MaBangCap`) VALUES
(1, 'Pham Dao Minh Vu', '1980-01-24', '163/30 Thanh Thai F.14 Q.10 TPCM', 905646162, 1),
(2, 'Nguyen Minh Thanh', '1983-04-05', '41/4 CALMETTE Q1 TPHCM', 908373612, 2),
(3, 'Nguyen Ha My', '1985-04-13', '178 Nam Ky Khoi Nghia Q4 TPHCM', 908783274, 3),
(4, 'Vo Tan Dung', '1985-08-02', '100 Nguyen Huu Dat QTan Phu TPHCM', 908783274, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bangcap`
--
ALTER TABLE `bangcap`
  ADD PRIMARY KEY (`mabangcap`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bangcap`
--
ALTER TABLE `bangcap`
  MODIFY `mabangcap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
