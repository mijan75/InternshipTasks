-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 12, 2018 at 06:45 PM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hellodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `access_logs`
--

CREATE TABLE `access_logs` (
  `id` int(11) NOT NULL,
  `access_by` varchar(255) DEFAULT NULL,
  `access_time` date DEFAULT NULL,
  `log_text` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bill_info`
--

CREATE TABLE `bill_info` (
  `id` int(11) NOT NULL,
  `bank_tranxn_id` varchar(255) DEFAULT NULL,
  `bill_amount` double NOT NULL,
  `bill_number` varchar(255) DEFAULT NULL,
  `bill_type` int(11) NOT NULL,
  `cancel_date` datetime DEFAULT NULL,
  `canceled_by` varchar(255) DEFAULT NULL,
  `due_amount` double NOT NULL,
  `due_date` date DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `paid_amount` double NOT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `utility_tranxn_id` varchar(255) DEFAULT NULL,
  `vat_amount` double NOT NULL,
  `bill_status` int(11) DEFAULT NULL,
  `stake_id` int(11) DEFAULT NULL,
  `customer_number` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_info`
--

INSERT INTO `bill_info` (`id`, `bank_tranxn_id`, `bill_amount`, `bill_number`, `bill_type`, `cancel_date`, `canceled_by`, `due_amount`, `due_date`, `issue_date`, `paid_amount`, `paid_by`, `pay_date`, `remarks`, `total_amount`, `utility_tranxn_id`, `vat_amount`, `bill_status`, `stake_id`, `customer_number`) VALUES
(1, 'abc', 100, '123', 1, NULL, 'mijan', 100, NULL, NULL, 100, 'mijan', NULL, 'a', 100, '2a', 100, 1, 5, 7),
(2, 'abc', 100, '124', 1, NULL, 'mijan', 100, NULL, NULL, 100, 'mijan', NULL, 'a', 100, '2a', 100, 1, 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `bill_status_info`
--

CREATE TABLE `bill_status_info` (
  `id` int(11) NOT NULL,
  `meaning` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_status_info`
--

INSERT INTO `bill_status_info` (`id`, `meaning`, `status`) VALUES
(1, 'pending', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23),
(23),
(23),
(23),
(23),
(23);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ROLE_SUPER_ADMIN'),
(2, 'ROLE_ADMIN'),
(5, 'ROLE_STAKEHOLDER_API'),
(6, 'ROLE_STAKEHOLDER_REPORT'),
(4, 'ROLE_ADMIN_REPORT');

-- --------------------------------------------------------

--
-- Table structure for table `stakeholder_info`
--

CREATE TABLE `stakeholder_info` (
  `id` int(11) NOT NULL,
  `address` varchar(20) NOT NULL,
  `contact_person_mobile` varchar(20) NOT NULL,
  `contact_person_name` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stakeholder_info`
--

INSERT INTO `stakeholder_info` (`id`, `address`, `contact_person_mobile`, `contact_person_name`, `name`, `status`) VALUES
(5, 'Dhaka', '01728030032', 'Monirul Hasan', 'BankAsia', 1),
(6, 'Bangladesh', '017280300032', 'Monirul Hasan', 'Southeast University', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` date DEFAULT NULL,
  `is_stakeholder_user` varchar(255) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` date DEFAULT NULL,
  `username` varchar(10) NOT NULL,
  `stakeholder_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `created_by`, `created_time`, `is_stakeholder_user`, `name`, `password`, `status`, `updated_by`, `updated_time`, `username`, `stakeholder_id`) VALUES
(1, NULL, NULL, NULL, 'Md. Mijanur Rahaman', '$2a$12$1pyn15PcLabCi1/aWptapOdEYvDJuD1IK03MHIjyWoElL7MW7eQYy', 1, NULL, NULL, 'mijan', NULL),
(3, 'mijan', '2018-04-12', '', 'Md. Mijanur Rahaman', '$2a$12$0T6qiL/c2uqLwuHS3LHuO.l6otR61Y9IJXhsO.13IdnXQnMW2ZRwq', 1, 'mijan', '2018-04-12', 'admin', NULL),
(7, 'admin', '2018-04-12', 'yes', 'Md. Mijanur Rahaman', '$2a$12$/nZfw.Nrf9zc05oDJNQJve8J1s1P6o2UXPkMogxzJr0QyF3Kzije2', 1, 'admin', '2018-04-12', 'apiuser', 5),
(9, 'admin', '2018-04-12', 'yes', 'Md. Mijanur Rahaman', '$2a$12$MvZ6aQKJJP7GdSBg/874W.PB53Auc9FA5mfeK5lv.rEKvKOwsBPsC', 1, 'admin', '2018-04-12', 'apiuser2', 6),
(15, 'admin', '2018-04-12', 'yes', 'Md. Mijanur Rahaman', '$2a$12$p1KqWHdNnx1xwNB5rEMPXuhEPZaPFOntnJPu4rTzpa95Kh24rCAgy', 1, 'admin', '2018-04-12', 'StaReBA', 5),
(17, 'admin', '2018-04-12', 'no', 'Md. Mijanur Rahaman', '$2a$12$xrXbwqNnlm.e0MknY5If1OMe9F1z4X32vNd./IZromxfrMWh6hNge', 1, 'admin', '2018-04-13', 'staReSE', 6),
(21, 'admin', '2018-04-13', 'no', 'Md. Mijanur Rahaman', '$2a$12$y1INOFsxxBR9dTSa8ga4X.RbYpRe9pMnwTtoAWIBKrADDWKatl97G', 1, 'admin', '2018-04-13', 'Radmin', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_role_id`, `role_id`, `user_id`) VALUES
(2, 1, 1),
(4, 2, 3),
(8, 5, 7),
(10, 5, 9),
(16, 6, 15),
(18, 6, 17),
(22, 4, 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `access_logs`
--
ALTER TABLE `access_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill_info`
--
ALTER TABLE `bill_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk4oovxsiap3vv5c4u7bfvn65k` (`bill_status`),
  ADD KEY `FKda2sqaitome7nmatbmqdrne3s` (`stake_id`),
  ADD KEY `FK6nj85x4il22p0gf3k2hvduu9w` (`customer_number`);

--
-- Indexes for table `bill_status_info`
--
ALTER TABLE `bill_status_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `stakeholder_info`
--
ALTER TABLE `stakeholder_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbbe63ahivnjqyalitow2m18bq` (`stakeholder_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  ADD KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
