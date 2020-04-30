-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2020 at 02:06 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ahmed_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `users2`
--

CREATE TABLE `users2` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `imageurl` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users2`
--

INSERT INTO `users2` (`id`, `name`, `email`, `password`, `imageurl`) VALUES
(1, 'ahmed', 'ahmed@gmail.com', '$2y$10$OYrun4p.v605kmN7wgK20./Vzsw1yj8XVnqG7/65PgNJYHWJB5v6m', ''),
(2, 'aburaihan', 'saqi@saqi.com', '$2y$10$RwH0066ovQ5TtRlBlkKmmedL72hQEJneV2g66NIXfJhJIMC3W1PIC', ''),
(3, 'admin', 'admin@admin.com', '$2y$10$Jn/19/0EouNIa9XA9FvKBeDhtY2r8CO/TOniThCHA9AwxYyCPKB2G', ''),
(4, 'test1', 'test1@test.com', '$2y$10$SyUhRNDCp9Mx0i0h2xFOzuNQmjJeP3RRT5wpdHtAd8/Gsj1Klr5.a', ''),
(7, 'test2', 'test2@test..com', '$2y$10$4/2cIiyUBPlFDAxzfbGpaev62ozB.aVMZYXg6v8QeRfKC43xCx6CW', ''),
(8, 'asad', 'asad@asad.com', '$2y$10$kpvzpILJWD84Q23khnMvdOgFLP5G8AtPfKqn/a8XjaEzrrfimk8m.', ''),
(9, 'abc', 'abc@123', '$2y$10$8SnVKDFsK.2pFVXqdjnM5O4SN5gY6XxpL4.RkNYIMrZBJcNLGZmXK', ''),
(10, 'ahmedaburaihan', 'aaa@aaa.com', '$2y$10$kjX8AbaL.Et2lDdIzGv0Nu4JvtTBrRJNFYt03BsGfqrKQUeMzmqkq', 'http://192.168.8.104/RegisterWithVolley1/profile_image/10.jpeg'),
(11, 'rozi', 'rozi@rozi.com', '$2y$10$lfo6LtckkKepoNiaXBVDy.7zV9FxNzzAtJ22cfIziP9IVq3UmQDtO', 'http://192.168.8.104/RegisterWithVolley1/profile_image/11.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users2`
--
ALTER TABLE `users2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users2`
--
ALTER TABLE `users2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
