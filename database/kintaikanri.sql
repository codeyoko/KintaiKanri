-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2023-12-12 07:28:38
-- サーバのバージョン： 10.4.27-MariaDB
-- PHP のバージョン: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `kintaikanri`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `admin`
--

CREATE TABLE `admin` (
  `username` varchar(10) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- テーブルのデータのダンプ `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('ad-eyes', 'eyesTokyo');

-- --------------------------------------------------------

--
-- テーブルの構造 `employee`
--

CREATE TABLE `employee` (
  `emp_code` varchar(8) NOT NULL,
  `start_date` varchar(10) NOT NULL,
  `work_year` int(10) NOT NULL,
  `emp_name` varchar(45) NOT NULL,
  `birthday` varchar(10) NOT NULL,
  `emp_age` int(10) NOT NULL,
  `last_date` varchar(10) NOT NULL,
  `depatment` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- テーブルのデータのダンプ `employee`
--

INSERT INTO `employee` (`emp_code`, `start_date`, `work_year`, `emp_name`, `birthday`, `emp_age`, `last_date`, `depatment`) VALUES
('20230063', '2023-11-20', 0, 'フウンヴァンソン', '1994-08-10', 29, '', '開発部'),
('20230064', '2010-06-11', 13, '山田太郎', '1990-10-18', 33, '', '人事部'),
('20230065', '2015-06-10', 8, '篠崎愛子', '2000-12-11', 23, '', '人事部'),
('20230066', '2019-06-10', 4, 'PhungVanSon', '1998-06-10', 25, '2023-12-30', '営業部'),
('20230067', '2012-07-11', 11, '内田幸子', '1985-10-20', 38, '2023-12-10', '開発部'),
('20230068', '2013-12-20', 10, '室田大輝', '2003-06-10', 20, '', '営業部'),
('32220832', '2022-04-01', 1, '松本', '2002-06-13', 21, '2023-12-20', '受付部'),
('32220833', '2017-02-10', 6, '君島太郎', '1999-06-10', 24, '', '開発部'),
('32220834', '2020-06-12', 3, '橋本', '2003-06-12', 20, '', '営業部');

-- --------------------------------------------------------

--
-- テーブルの構造 `work`
--

CREATE TABLE `work` (
  `No` int(11) NOT NULL,
  `emp_code` varchar(8) NOT NULL,
  `work_day` varchar(10) NOT NULL,
  `work_start` varchar(10) NOT NULL,
  `work_finish` varchar(10) NOT NULL,
  `work_time` varchar(10) NOT NULL,
  `break_time` varchar(10) NOT NULL,
  `over_time` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- テーブルのデータのダンプ `work`
--

INSERT INTO `work` (`No`, `emp_code`, `work_day`, `work_start`, `work_finish`, `work_time`, `break_time`, `over_time`) VALUES
(50, '20230063', '2023-12-11', '09:00', '18:00', '08:00', '01:00', '00:00'),
(51, '32220832', '2023-12-08', '09:00', '18:40', '08:00', '01:00', '00:40'),
(52, '20230064', '2023-12-12', '08:00', '18:30', '09:00', '01:00', '01:30'),
(53, '20230065', '2023-12-13', '08:30', '17:30', '08:00', '01:00', '00:00'),
(55, '20230063', '2023-12-12', '09:00', '14:30', '04:00', '01:00', '00:00'),
(56, '20230066', '2023-12-13', '10:00', '19:50', '08:00', '01:00', '00:50');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- テーブルのインデックス `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_code`);

--
-- テーブルのインデックス `work`
--
ALTER TABLE `work`
  ADD PRIMARY KEY (`No`),
  ADD KEY `cooperation_01` (`emp_code`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `work`
--
ALTER TABLE `work`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `work`
--
ALTER TABLE `work`
  ADD CONSTRAINT `cooperation_01` FOREIGN KEY (`emp_code`) REFERENCES `employee` (`emp_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
