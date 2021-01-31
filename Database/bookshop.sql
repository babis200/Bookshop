CREATE DATABASE bookshop;
USE bookshop;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

CREATE TABLE `books` (
  `ID` int(4) NOT NULL,
  `ISBN` varchar(10) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Publisher` varchar(50) NOT NULL,
  `Quantity` int(4) NOT NULL
) 
DEFAULT CHARSET=utf8mb4;


INSERT INTO `books` (`ID`, `ISBN`, `Title`, `Author`, `Publisher`, `Quantity`) VALUES
(1, '9602743484', 'Ο Χάρι Πότερ και η φιλοσοφική λίθος', 'J. K. Rowling', 'Ψυχογιός', 5),
(2, '960036821X', 'Θα γίνω σκιά σου', 'Αγγελική Νικολούλη', 'Εκδόσεις Καστανιώτη', 2),
(3, '6185265176', 'Το δώρο', 'Στέφανος Ξενάκης', ' Key Books', 10),
(4, ' 960493565', 'Χημεία Γ’ λυκείου β’ τεύχος', 'Κώστας Σ. Σαλτερής', 'Σαββάλας', 0),
(6, '9602744014', 'Ο Χάρι Πότερ και η κάμαρα με τα μυστικά', 'J. K. Rowling', 'Ψυχογιός', 12),
(7, '9609797806', 'Μια φυσιολογική ζωή', 'Βασίλης Παλαιοκώστας', 'Οι Εκδόσεις των Συναδέλφων', 31),
(8, '6185265311', 'Το δώρο 2', 'Στέφανος Ξενάκης', 'Key Books', 22);

ALTER TABLE `books`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ISBN` (`ISBN-10`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
