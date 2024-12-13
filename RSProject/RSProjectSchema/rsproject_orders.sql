-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: rsproject
-- ------------------------------------------------------
-- Server version	5.7.40-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `bill_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  KEY `bill_id` (`bill_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1736565104,102),(1736565104,102),(1736565104,521),(1736565104,521),(852906232,113),(852906232,413),(1457018480,211),(1457018480,211),(1457018480,411),(1457018480,401),(1457018480,401),(1603657516,203),(1603657516,203),(1603657516,413),(1603657516,401),(1603657516,411),(238361320,213),(238361320,213),(238361320,211),(1039959900,113),(1039959900,213),(1039959900,213),(1039959900,413),(1039959900,413),(154927484,411),(154927484,411),(154927484,211),(1794643456,201),(1794643456,211),(1794643456,411),(1794643456,201),(1782763270,212),(1782763270,212),(1782763270,213),(800758038,213),(800758038,213),(800758038,401),(1660926088,411),(1660926088,411),(1660926088,401),(1660926088,201),(890944556,411),(890944556,411),(890944556,201),(890944556,201),(890944556,201),(1607581892,101),(1607581892,201),(1607581892,213),(1607581892,521),(299985128,523),(299985128,523),(299985128,523),(299985128,523),(299985128,523),(1837979740,401),(1837979740,411),(1837979740,411),(2002273360,112),(2002273360,522),(2002273360,521),(1857558452,522),(1857558452,521),(1857558452,523),(1857558452,513),(1857558452,512),(1857558452,511),(224628268,112),(224628268,212),(224628268,412),(224628268,403),(224628268,113),(224628268,502),(224628268,522),(852786592,211),(852786592,211),(852786592,111),(852786592,411),(852786592,411),(852786592,213),(852786592,413),(186141316,211),(186141316,523),(186141316,523),(186141316,523),(186141316,523),(186141316,523),(647701493,401),(647701493,401),(647701493,401),(1016437275,411),(1016437275,411),(1746670857,201),(1746670857,201),(1746670857,111),(1746670857,411),(1746670857,411),(1962583521,213),(1962583521,213),(1962583521,502),(1962583521,502),(1962583521,512),(1962583521,522),(1962583521,522),(866494829,411),(866494829,411),(866494829,111),(866494829,201),(866494829,201),(866494829,513),(866494829,523),(498151358,211),(498151358,211),(498151358,111),(498151358,101),(498151358,201),(498151358,401),(498151358,411),(498151358,513),(498151358,523),(498151358,513),(498151358,503),(208025481,211),(208025481,211),(208025481,411),(208025481,411),(1314165563,201),(1314165563,201),(1314165563,111),(1314165563,411),(170664297,413),(170664297,201),(170664297,211),(2121951958,213),(2121951958,213),(2121951958,413),(2121951958,413),(2121951958,401),(2121951958,411),(2121951958,111),(1019938528,513),(1019938528,503),(1019938528,523),(798114013,411),(798114013,101),(80960988,213),(80960988,213),(80960988,201),(545826077,203),(545826077,213),(1947523974,413),(1947523974,201),(1947523974,211),(1947523974,211),(1947523974,411),(1947523974,111),(1947523974,101),(1947523974,201),(1201277480,401),(1201277480,401),(1201277480,211),(1201277480,211),(1327296167,513),(1327296167,523),(1327296167,523),(2045055478,213),(2045055478,213),(2045055478,413),(2045055478,413),(2045055478,512),(2045055478,512),(2045055478,502),(2045055478,522),(927859702,103),(927859702,411),(927859702,411),(420946386,502),(420946386,512),(420946386,522),(420946386,521),(420946386,501),(420946386,511),(765128660,112),(765128660,112),(940498440,411),(940498440,211),(940498440,111),(934075320,513),(934075320,513),(934075320,503),(934075320,523),(1080509300,503),(1080509300,513),(1080509300,523),(1817694300,203),(1817694300,213),(1817694300,201),(1351139120,213),(1351139120,213),(997739780,523),(997739780,513),(997739780,503),(997739780,411),(997739780,211),(997739780,111),(997739780,101),(997739780,201),(997739780,401),(997739780,502),(997739780,512),(997739780,522),(997739780,113),(997739780,213),(997739780,413),(997739780,103),(997739780,203),(997739780,403),(997739780,501),(997739780,511),(997739780,521),(997739780,412),(997739780,402),(997739780,202),(997739780,212),(997739780,112),(997739780,102),(1695117700,102),(1695117700,112),(1695117700,103),(1695117700,203),(1695117700,522),(1755542476,113),(1755542476,101),(1755542476,111),(1755542476,211),(2098828612,102),(2098828612,103),(2098828612,501),(2098828612,502),(2098828612,502),(2098828612,503),(615397056,112),(615397056,501),(615397056,501),(1071566968,211),(1071566968,502),(85865588,102),(85865588,523),(896664688,112),(896664688,113),(896664688,411),(896664688,411);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-08 23:38:46