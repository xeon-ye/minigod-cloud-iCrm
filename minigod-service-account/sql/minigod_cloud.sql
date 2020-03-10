/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.17-log : Database - mg_main
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg_main` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mg_main`;

/*Table structure for table `captcha_email` */

DROP TABLE IF EXISTS `captcha_email`;

CREATE TABLE `captcha_email` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '验证码id',
  `email` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
  `type` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '验证码类型',
  `captcha` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '验证码，6位',
  `expires_time` datetime NOT NULL COMMENT '短信失效时间',
  `is_checked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否验证过',
  `is_used` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否使用过',
  `validate_count` tinyint(4) NOT NULL DEFAULT '0' COMMENT '验证错误次数',
  `create_time` datetime NOT NULL COMMENT '信息发送时间',
  `update_time` datetime NOT NULL COMMENT '信息修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_sms_captcha` (`email`,`captcha`,`expires_time`),
  KEY `idx_used` (`is_used`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `captcha_email` */

/*Table structure for table `captcha_sms` */

DROP TABLE IF EXISTS `captcha_sms`;

CREATE TABLE `captcha_sms` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '验证码id',
  `phone` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
  `type` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '验证码类型',
  `captcha` char(6) COLLATE utf8mb4_bin NOT NULL COMMENT '验证码，6位',
  `expires_time` datetime NOT NULL COMMENT '短信失效时间',
  `is_checked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否验证过',
  `is_used` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否使用过',
  `validate_count` tinyint(4) NOT NULL DEFAULT '0' COMMENT '验证错误次数',
  `create_time` datetime NOT NULL COMMENT '信息发送时间',
  `update_time` datetime NOT NULL COMMENT '信息修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_sms_captcha` (`phone`,`captcha`,`expires_time`),
  KEY `idx_used` (`is_used`,`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `captcha_sms` */

insert  into `captcha_sms`(`id`,`phone`,`type`,`captcha`,`expires_time`,`is_checked`,`is_used`,`validate_count`,`create_time`,`update_time`) values 
(1,'18938070402','4001','775474','2019-12-30 14:40:33',0,0,0,'2019-12-30 14:35:33','2019-12-30 14:35:33'),
(2,'18938070402','4001','495381','2019-12-30 14:48:05',0,0,0,'2019-12-30 14:43:05','2019-12-30 14:43:05'),
(3,'18938070402','4001','648687','2019-12-30 19:08:28',0,0,0,'2019-12-30 19:03:28','2019-12-30 19:03:28'),
(4,'18938070402','4001','658301','2020-01-05 12:46:16',0,0,0,'2020-01-05 12:41:16','2020-01-05 12:41:16'),
(5,'18938070402','4001','582804','2020-01-05 12:56:35',0,0,0,'2020-01-05 12:51:35','2020-01-05 12:51:35'),
(6,'18938070402','4001','923966','2020-01-08 12:40:55',0,0,0,'2020-01-08 12:35:55','2020-01-08 12:35:55'),
(7,'18938070402','4001','128537','2020-01-08 13:33:42',0,0,0,'2020-01-08 13:28:42','2020-01-08 13:28:42'),
(8,'18938070402','4001','802505','2020-01-08 14:53:41',0,0,0,'2020-01-08 14:48:41','2020-01-08 14:48:41'),
(9,'18938070402','4001','249128','2020-01-08 15:09:40',0,0,0,'2020-01-08 15:04:40','2020-01-08 15:04:40'),
(10,'18938070402','4001','261249','2020-01-09 18:45:59',0,0,0,'2020-01-09 18:45:58','2020-01-09 18:45:58'),
(11,'18938070402','4001','196591','2020-01-17 12:14:28',0,0,0,'2020-01-17 12:14:28','2020-01-17 12:14:28'),
(12,'18938070402','4001','028620','2020-01-17 12:17:55',0,0,0,'2020-01-17 12:17:55','2020-01-17 12:17:55'),
(13,'18938070402','4003','429617','2020-01-17 16:02:00',0,0,0,'2020-01-17 16:02:00','2020-01-17 16:02:00'),
(14,'18938070402','4003','184038','2020-01-17 16:16:18',1,0,1,'2020-01-17 16:11:18','2020-01-17 16:17:45');

/*Table structure for table `custom_basic` */

DROP TABLE IF EXISTS `custom_basic`;

CREATE TABLE `custom_basic` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id（自增主键）',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码（可空）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态 0-停用,1-正常,2-锁定',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='用户基本表';

/*Data for the table `custom_basic` */

insert  into `custom_basic`(`id`,`phone`,`email`,`password`,`status`,`create_time`,`update_time`) values 
(10001,'18938070402',NULL,NULL,1,'2019-12-30 12:36:54','2020-01-17 16:17:45');

/*Table structure for table `custom_open_cn_cache_info` */

DROP TABLE IF EXISTS `custom_open_cn_cache_info`;

CREATE TABLE `custom_open_cn_cache_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `step` int(10) DEFAULT NULL,
  `json_info` varchar(12000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`step`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

/*Data for the table `custom_open_cn_cache_info` */

insert  into `custom_open_cn_cache_info`(`id`,`user_id`,`step`,`json_info`,`create_time`,`update_time`) values 
(49,10001,1,'{}','2020-01-08 00:00:00','2020-02-28 11:59:25'),
(50,10001,2,'{\"familyName\":\"周\",\"givenName\":\"文晋\",\"familyNameSpell\":\"ZHOU\",\"givenNameSpell\":\"WENJIN\",\"idCardValue\":\"430381199312285013\",\"addressValue\":\"湖南省湘乡市月山镇水口村大子冲村民组\",\"dateStartValue\":\"2008-01-15\",\"dateEndValue\":\"2028-01-15\",\"authority\":\"深圳市公安局南山分局\",\"nation\":\"汉\",\"isLonger\":false,\"sex\":\"0\",\"birthday\":\"1993-12-28\",\"cnNameValue\":\"周文晋\",\"enNameValue\":\"ZHOUWENJIN\"}','2020-01-08 00:00:00','2020-02-28 11:59:27'),
(53,10001,-1,'{\"lastStep\":10}','2020-01-08 16:46:06','2020-03-02 21:03:59'),
(54,10001,4,'{\"email\":\"jim@zszhizhu.com\",\"homeRadio\":2,\"homeCity\":[{\"index\":0,\"text\":\"香港\"},{\"index\":0,\"text\":\"香港岛\"},{\"index\":0,\"text\":\"中西区\"}],\"homeAddressDetail\":\"反對\",\"homeAddressNumber\":\"2131\",\"homeOhterCountry\":\"\",\"otherFamilyRepublic\":\"\",\"homeOhterCountryLabel\":\"\",\"homeOtherProvince\":\"\",\"homeOtherCity\":\"\",\"homeOtherArea\":\"\",\"contactRadio\":6,\"contactCity\":[],\"contactAddressDetail\":\"\",\"contactAddressNumber\":\"\",\"otherContactRepublic\":\"\",\"contactOhterCountry\":\"\",\"contactOhterCountryLable\":\"\",\"contactOtherProvince\":\"\",\"contactOtherCity\":\"\",\"contactOtherArea\":\"\",\"professionCode\":4,\"companyName\":\"\",\"companyAddress\":\"\",\"industryRange\":\"\",\"jobPosition\":\"\"}','2020-01-15 16:01:02','2020-02-28 13:25:02'),
(55,10001,5,'{\"riskAgreement\":true}','2020-01-15 16:01:11','2020-02-28 13:25:14'),
(56,10001,6,'{\"isAccountOwner\":true,\"otherOwnerName\":\"\",\"otherOwnerCardType\":\"\",\"otherOwnerCardNum\":\"\",\"isNotOurStaff\":true,\"ourStaffJob\":\"关键支援\",\"isNotOurStaffKin\":true,\"ourStaffKinName\":\"\",\"ourStaffKinRelation\":\"\",\"isNotHkexParterStaff\":true,\"hkexParterCompany\":\"\",\"hkexParterStaffJob\":\"\",\"isNotExchangeParter\":true,\"exchangeParterName\":\"\",\"exchangeParterNation\":\"\",\"isNotCompanyController\":true,\"companyControllerName0\":\"\",\"companyControllerName1\":\"\",\"companyControllerName2\":\"\",\"companyControllerName3\":\"\",\"companyControllerName4\":\"\",\"companyControllerJob0\":\"\",\"companyControllerJob1\":\"\",\"companyControllerJob2\":\"\",\"companyControllerJob3\":\"\",\"companyControllerJob4\":\"\",\"companyControllerExchange0\":\"\",\"companyControllerExchange1\":\"\",\"companyControllerExchange2\":\"\",\"companyControllerExchange3\":\"\",\"companyControllerExchange4\":\"\",\"companyControllerCode0\":\"\",\"companyControllerCode1\":\"\",\"companyControllerCode2\":\"\",\"companyControllerCode3\":\"\",\"companyControllerCode4\":\"\",\"isNotUsGreenCardHolder\":true,\"usGreenCardCode\":\"\",\"isAllowProvidePrivacy\":true,\"infoCardCount\":0,\"offerPrivacy1\":\"\",\"offerPrivacy2\":\"\",\"offerPrivacy3\":\"\",\"offerPrivacy4\":\"\",\"noOfferPrivacy1\":\"\",\"noOfferPrivacy2\":\"\",\"noOfferPrivacy3\":\"\",\"noOfferPrivacy4\":\"\",\"canPrivacyNum1\":\"\",\"canPrivacyNum2\":\"\",\"canPrivacyNum3\":\"\",\"canPrivacyNum4\":\"\",\"reasonDesc1\":\"\",\"reasonDesc2\":\"\",\"reasonDesc3\":\"\",\"reasonDesc4\":\"\",\"country1\":\"\",\"country2\":\"\",\"country3\":\"\",\"country4\":\"\",\"defaultPrivacyNum\":\"440305199311125013\",\"infoCount\":0}','2020-01-15 16:01:21','2020-02-28 13:25:21'),
(57,10001,7,'{\"income\":1,\"assets\":2,\"capitalTxt\":\"薪酬\",\"capital\":[1],\"investTarget\":5,\"investTargetOther\":\"\",\"stock\":1,\"stockGq\":1,\"stockGoods\":1}','2020-01-15 16:06:17','2020-02-28 13:25:23'),
(58,10001,8,'{\"accountType\":1,\"accountCashMarkets\":[\"1\",\"2\",\"3\"],\"accountMarginMarkets\":[\"1\"],\"derivative\":1,\"derivativeTrade\":true,\"derivativeCourse\":true,\"derivativeIndustry\":true}','2020-01-15 16:08:57','2020-02-28 13:25:25'),
(59,10001,9,'{\"pelCheck\":false}','2020-01-15 16:41:50','2020-01-15 18:13:46'),
(60,10001,11,'{\"pelCheck\":false}','2020-01-16 10:03:54','2020-01-16 10:15:32'),
(61,10001,12,'{\"pelCheck\":false}','2020-02-27 19:00:45','2020-02-28 13:25:53'),
(62,10001,10,'{\"pelCheck\":false}','2020-02-27 23:37:56','2020-03-02 21:03:59'),
(63,10001,3,'{\"bankNum\":\"6222021001092536884\",\"bankPhoneNum\":\"18938070402\"}','2020-02-28 11:59:42','2020-02-28 11:59:53');

/*Table structure for table `custom_open_cn_img` */

DROP TABLE IF EXISTS `custom_open_cn_img`;

CREATE TABLE `custom_open_cn_img` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `location_key` char(3) DEFAULT NULL COMMENT '图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]',
  `location_type` char(3) DEFAULT NULL COMMENT '图片类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]',
  `url` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `error_status` int(20) DEFAULT NULL COMMENT '标识错误图片，1:图片错误',
  PRIMARY KEY (`id`),
  KEY `idx_userid_location` (`user_id`,`location_key`,`location_type`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `custom_open_cn_img` */

insert  into `custom_open_cn_img`(`id`,`user_id`,`location_key`,`location_type`,`url`,`create_time`,`error_status`) values 
(52,10001,'1','101','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/267123280eab4557bfb9674ba352dc59.jpg','2020-02-26 17:26:14',0),
(53,10001,'1','102','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/519765d51a4c413d8591787d2bfd8295.jpg','2020-02-23 18:07:25',0),
(56,10001,'3','301','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f2e77897166e4cc5aab9f6d7cbcaffb5.jpg','2020-03-02 20:26:33',0),
(57,10001,'5','504','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/a4ca0579d47043988296f87554157802.jpg','2020-02-23 20:18:50',0),
(58,10001,'4','402','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/4fd7cfa3d5e5463884c8b3d0b3acdeda.jpg','2020-02-23 20:19:27',0),
(59,10001,'4','401','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/407b20a4d25e4277bb774c7390d33b5f.jpg','2020-02-23 20:19:28',0),
(60,10001,'3','302','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/1c93348e64df400bb03438da46adf73d.jpg','2020-02-27 22:56:38',0);

/*Table structure for table `custom_open_hk_cache_info` */

DROP TABLE IF EXISTS `custom_open_hk_cache_info`;

CREATE TABLE `custom_open_hk_cache_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `step` int(10) DEFAULT NULL,
  `json_info` varchar(12000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`step`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `custom_open_hk_cache_info` */

insert  into `custom_open_hk_cache_info`(`id`,`user_id`,`step`,`json_info`,`create_time`,`update_time`) values 
(1,10001,1,'{\"idKindKey\":\"idCardCn\",\"idKind\":\"1\",\"nationType\":\"1\",\"otherNationality\":\"\",\"familyName\":\"陶\",\"givenName\":\"伟\",\"familyNameSpell\":\"TAO\",\"givenNameSpell\":\"WEI\",\"idCardValue\":\"360103197410053411\",\"addressValue\":\"广东省深圳市南山区东滨路福满园A-5B\",\"birthday\":\"1974-10-05\",\"sex\":\"0\",\"dateStartValue\":\"2008-01-15\",\"dateEndValue\":\"2028-01-15\",\"passportStartValue\":\"\",\"passportEndValue\":\"\"}','2020-02-26 20:03:25','2020-03-02 20:29:35'),
(2,10001,-1,'{\"lastStep\":8}','2020-02-26 20:03:25','2020-03-02 20:32:14'),
(3,10001,2,'{\"familyName\":\"陶\",\"givenName\":\"伟\",\"familyNameSpell\":\"TAO\",\"givenNameSpell\":\"WEI\",\"idCardValue\":\"360103197410053411\",\"addressValue\":\"广东省深圳市南山区东滨路福满园A-5B\",\"dateStartValue\":\"2008-01-15\",\"dateEndValue\":\"2028-01-15\",\"isLonger\":false,\"birthday\":\"1974-10-05\",\"sex\":\"0\",\"passportStartValue\":\"\",\"passportEndValue\":\"\",\"cnNameValue\":\"陶伟\",\"enNameValue\":\"TAOWEI\"}','2020-02-27 10:57:09','2020-03-02 20:29:38'),
(4,10001,3,'{\"bankUserName\":\"TAOWEI\",\"bankName\":\"汇丰银行\",\"bankId\":\"HSBCHK\",\"bankNum\":\"123465\"}','2020-02-27 13:55:17','2020-03-02 20:29:39'),
(5,10001,5,'{\"riskAgreement\":true}','2020-02-27 17:47:54','2020-03-02 20:29:44'),
(6,10001,6,'{\"isAccountOwner\":true,\"otherOwnerName\":\"\",\"otherOwnerCardType\":\"\",\"otherOwnerCardNum\":\"\",\"isNotOurStaff\":true,\"ourStaffJob\":\"\",\"isNotOurStaffKin\":true,\"ourStaffKinName\":\"\",\"ourStaffKinRelation\":\"\",\"isNotHkexParterStaff\":true,\"hkexParterCompany\":\"\",\"hkexParterStaffJob\":\"\",\"isNotExchangeParter\":true,\"exchangeParterName\":\"\",\"exchangeParterNation\":\"\",\"isNotCompanyController\":true,\"companyControllerName0\":\"\",\"companyControllerName1\":\"\",\"companyControllerName2\":\"\",\"companyControllerName3\":\"\",\"companyControllerName4\":\"\",\"companyControllerJob0\":\"\",\"companyControllerJob1\":\"\",\"companyControllerJob2\":\"\",\"companyControllerJob3\":\"\",\"companyControllerJob4\":\"\",\"companyControllerExchange0\":\"\",\"companyControllerExchange1\":\"\",\"companyControllerExchange2\":\"\",\"companyControllerExchange3\":\"\",\"companyControllerExchange4\":\"\",\"companyControllerCode0\":\"\",\"companyControllerCode1\":\"\",\"companyControllerCode2\":\"\",\"companyControllerCode3\":\"\",\"companyControllerCode4\":\"\",\"isNotUsGreenCardHolder\":true,\"usGreenCardCode\":\"\",\"isAllowProvidePrivacy\":true,\"infoCardCount\":0,\"offerPrivacy1\":\"\",\"offerPrivacy2\":\"\",\"offerPrivacy3\":\"\",\"offerPrivacy4\":\"\",\"noOfferPrivacy1\":\"\",\"noOfferPrivacy2\":\"\",\"noOfferPrivacy3\":\"\",\"noOfferPrivacy4\":\"\",\"canPrivacyNum1\":\"\",\"canPrivacyNum2\":\"\",\"canPrivacyNum3\":\"\",\"canPrivacyNum4\":\"\",\"reasonDesc1\":\"\",\"reasonDesc2\":\"\",\"reasonDesc3\":\"\",\"reasonDesc4\":\"\",\"country1\":\"\",\"country2\":\"\",\"country3\":\"\",\"country4\":\"\",\"defaultCountryCn\":\"中国大陆\",\"defaultCountryHk\":\"\",\"defaultCountryOther\":\"\",\"defaultPrivacyNum\":\"360103197410053411\",\"infoCount\":0}','2020-02-27 17:47:59','2020-03-02 20:32:12'),
(7,10001,7,'{\"income\":1,\"assets\":2,\"capitalTxt\":\"薪酬、继承\",\"capital\":[4,1],\"investTarget\":3,\"investTargetOther\":\"\",\"stock\":1,\"stockGq\":1,\"stockGoods\":1}','2020-02-27 17:48:01','2020-03-02 20:32:13'),
(8,10001,8,'{\"accountType\":1,\"accountCashMarkets\":[\"1\",\"2\"],\"accountMarginMarkets\":[\"1\",\"2\"],\"derivative\":0,\"derivativeTrade\":true,\"derivativeCourse\":true,\"derivativeIndustry\":true}','2020-02-27 17:48:09','2020-03-02 20:32:14'),
(9,10001,4,'{\"email\":\"jim@zszhizhu.com\",\"homeRadio\":2,\"homeCity\":[{\"index\":0,\"text\":\"香港\"},{\"index\":0,\"text\":\"香港岛\"},{\"index\":0,\"text\":\"中西区\"}],\"homeAddressDetail\":\"发送发送\",\"homeAddressNumber\":\"12\",\"homeOhterCountry\":\"\",\"otherFamilyRepublic\":\"\",\"homeOhterCountryLabel\":\"\",\"homeOtherProvince\":\"\",\"homeOtherCity\":\"\",\"homeOtherArea\":\"\",\"contactRadio\":6,\"contactCity\":[],\"contactAddressDetail\":\"\",\"contactAddressNumber\":\"\",\"otherContactRepublic\":\"\",\"contactOhterCountry\":\"\",\"contactOhterCountryLable\":\"\",\"contactOtherProvince\":\"\",\"contactOtherCity\":\"\",\"contactOtherArea\":\"\",\"professionCode\":4,\"companyName\":\"\",\"companyAddress\":\"\",\"industryRange\":\"\",\"jobPosition\":\"\"}','2020-02-28 13:38:09','2020-03-02 20:29:41');

/*Table structure for table `custom_open_hk_img` */

DROP TABLE IF EXISTS `custom_open_hk_img`;

CREATE TABLE `custom_open_hk_img` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `location_key` char(3) DEFAULT NULL COMMENT '图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]',
  `location_type` char(3) DEFAULT NULL COMMENT '图片类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]',
  `url` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `error_status` int(20) DEFAULT NULL COMMENT '标识错误图片，1:图片错误',
  PRIMARY KEY (`id`),
  KEY `idx_userid_location` (`user_id`,`location_key`,`location_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `custom_open_hk_img` */

insert  into `custom_open_hk_img`(`id`,`user_id`,`location_key`,`location_type`,`url`,`create_time`,`error_status`) values 
(1,10001,'1','103','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/1fe2cbcb259942f6b3ea0bb90bf7d285.jpg','2020-02-26 20:06:09',0),
(2,10001,'1','101','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/536e95eb2b3648d9a50d2b5ee3cafee9.jpg','2020-02-27 10:12:27',0),
(3,10001,'1','102','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/7eaafecc19ac4d55a444ac8336cf6c48.jpg','2020-02-27 10:08:53',0),
(4,10001,'1','105','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5e9c36467a944af4b3dd6934c015ba71.jpg','2020-02-26 20:06:13',0),
(5,10001,'1','104','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d53f9972416342d1800c17a7b3fc06e1.jpg','2020-02-26 20:56:19',0),
(6,10001,'3','301','https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f74e9f0d1b2c4506b2be9e1f835444f7.jpg','2020-03-02 20:43:24',0);

/*Table structure for table `custom_open_info` */

DROP TABLE IF EXISTS `custom_open_info`;

CREATE TABLE `custom_open_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `phone` varchar(100) NOT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(100) DEFAULT NULL,
  `bank_card` varchar(20) DEFAULT NULL COMMENT '银行卡号',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `status` int(4) DEFAULT '0' COMMENT '0:未提交（默认），1:开户中，2:已取消,3:开户成功，4:开户失败，5:销户',
  `access_way` int(2) DEFAULT NULL COMMENT '开户接入方式: 1:H5开户 2:APP开户',
  `account_type` int(2) DEFAULT NULL COMMENT '账户类型 1：现金账户 2：融资账户',
  `open_type` int(2) DEFAULT NULL COMMENT '开户方式：0:未知，1:线上内地开户，2:线下（开户宝），3:线上香港开户',
  `account_markets` varchar(20) DEFAULT NULL COMMENT '账户类型：1：港股 2：美股 3：中华通',
  `pending_type` int(4) DEFAULT NULL COMMENT '0:预批中，1:审批中，2:CA认证中,3:柜台开户中',
  `fail_type` int(4) DEFAULT NULL COMMENT '0:其他错误，1:基本数据错误，2:影像数据错误,3:基本或影像数据错误，4:CA数据错误',
  `open_result` varchar(500) DEFAULT NULL COMMENT '开户结果',
  `is_need_push` tinyint(1) DEFAULT '0' COMMENT '是否需要推送',
  `push_err_count` int(2) DEFAULT '0' COMMENT '推送失败次数',
  `remote_id` varchar(20) DEFAULT NULL COMMENT '远程开户系统ID',
  `open_date` datetime DEFAULT NULL COMMENT '开户日期',
  `trade_account` varchar(20) DEFAULT NULL COMMENT '客户号（交易帐号）',
  `is_send` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '是否发送消息',
  `info` varchar(12000) DEFAULT NULL COMMENT '开户数据',
  `open_account_pdf_url` varchar(256) DEFAULT NULL COMMENT '开户PDF文件地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_id` (`phone`),
  KEY `idx_user_id` (`phone`),
  KEY `idx_id_card` (`id_card`),
  KEY `idx_bank_card` (`bank_card`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

/*Data for the table `custom_open_info` */

insert  into `custom_open_info`(`id`,`phone`,`email`,`password`,`bank_card`,`id_card`,`status`,`access_way`,`account_type`,`open_type`,`account_markets`,`pending_type`,`fail_type`,`open_result`,`is_need_push`,`push_err_count`,`remote_id`,`open_date`,`trade_account`,`is_send`,`info`,`open_account_pdf_url`,`create_time`,`update_time`) values 
(10001,'18938070402','jim@zszhizhu.com',NULL,'123465','360103197410053411',1,1,NULL,1,NULL,0,-1,'',0,0,'2020030310000004',NULL,NULL,0,'{\"futuresInvestmentExperienceType\":1,\"fundAccountType\":1,\"companyName\":\"\",\"otherNationality\":\"\",\"warrantsInvestmentExperienceType\":1,\"idNo\":\"360103197410053411\",\"familyCountyName\":\"中西区\",\"derivativeProductsStudyType\":\"\",\"otherFamilyRepublic\":\"\",\"idCardValidDateEnd\":\"2028-01-15\",\"sourceChannelId\":1,\"familyName\":\"陶\",\"givenNameSpell\":\"WEI\",\"contactCountyName\":\"中西区\",\"contactAddress\":\"香港岛中西区发送发送12\",\"isOpenUsaStockMarket\":1,\"idKind\":\"1\",\"familyProvinceName\":\"香港\",\"professionType\":\"\",\"bankType\":0,\"addressType\":6,\"givenName\":\"伟\",\"otherContactRepublic\":\"\",\"contactCityName\":\"香港岛\",\"jobPosition\":\"\",\"isAllowProvidePrivacy\":1,\"familyDetailAddress\":\"发送发送12\",\"capitalSource\":[1,4],\"otherDisclosure\":[{\"disclosureCode\":\"1\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"21\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"22\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"23\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"24\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"25\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"},{\"disclosureCode\":\"26\",\"disclosureIsTrue\":1,\"disclosure1\":\"\",\"disclosure2\":\"\",\"disclosure3\":\"\",\"disclosure4\":\"\"}],\"bankId\":\"HSBCHK\",\"familyRepublicName\":2,\"phoneNumber\":\"18938070402\",\"nationality\":0,\"stocksInvestmentExperienceType\":1,\"inviterId\":1,\"contactProvinceName\":\"香港\",\"isKnowDerivativeProducts\":0,\"derivativeProductsStudyTypeOther\":\"\",\"idCardAddress\":\"广东省深圳市南山区东滨路福满园A-5B\",\"investTarget\":[3],\"financingInstitutionWorkExperienceType\":\"\",\"birthday\":\"1974-10-05\",\"annualIncome\":1,\"isOpenHkStockMarket\":1,\"clientName\":\"陶伟\",\"idCardValidDateStart\":\"2008-01-15\",\"clientNameSpell\":\"TAOWEI\",\"familyAddress\":\"香港岛中西区发送发送12\",\"contactDetailAddress\":\"发送发送12\",\"investTargetOther\":\"\",\"propertyType\":[{\"propertyType\":0,\"propertyAmount\":2}],\"financingInstitutionWorkExperienceTypeOther\":\"\",\"bankNo\":\"123465\",\"email\":\"jim@zszhizhu.com\",\"bankAccountName\":\"TAOWEI\",\"openAccountType\":1,\"contactRepublicName\":2,\"professionCode\":4,\"sex\":\"0\",\"taxationInfo\":[{\"taxCountry\":\"中国大陆\",\"taxNumber\":\"360103197410053411\",\"hasTaxNumber\":1}],\"userId\":10001,\"openAccountAccessWay\":\"1\",\"isTradedDerivativeProducts\":\"\",\"companyAddress\":\"\",\"familyNameSpell\":\"TAO\",\"familyCityName\":\"香港岛\",\"northTrade\":0}',NULL,NULL,'2020-03-02 21:04:00');

/*Table structure for table `custom_session` */

DROP TABLE IF EXISTS `custom_session`;

CREATE TABLE `custom_session` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '会话的id（自增主键）',
  `user_id` int(20) NOT NULL COMMENT '用户ID',
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `token` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `expire_time` datetime NOT NULL COMMENT 'session过期时间',
  `is_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效(1有效,0无效)',
  `msg` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `token` (`token`),
  KEY `user_id` (`user_id`,`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='会话管理表';

/*Data for the table `custom_session` */

insert  into `custom_session`(`id`,`user_id`,`device_id`,`token`,`expire_time`,`is_status`,`msg`,`create_time`,`update_time`) values 
(1001,10001,-1,'e2933a775d8f4cde823b4daa9fca27521001','9999-12-31 12:00:00',1,NULL,'2020-01-17 16:17:45','2020-01-17 16:17:45');

/*Table structure for table `sys_storage` */

DROP TABLE IF EXISTS `sys_storage`;

CREATE TABLE `sys_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(63) NOT NULL COMMENT '文件的唯一索引',
  `name` varchar(255) NOT NULL COMMENT '文件名',
  `type` varchar(20) NOT NULL COMMENT '文件类型',
  `size` int(11) NOT NULL COMMENT '文件大小',
  `url` varchar(255) DEFAULT NULL COMMENT '文件访问链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COMMENT='文件存储表';

/*Data for the table `sys_storage` */

insert  into `sys_storage`(`id`,`key`,`name`,`type`,`size`,`url`,`create_time`,`update_time`) values 
(1,'8b25c08b421f4f149d185678cdd44498.jpg','10001_1011582024393735.jpg','image/jpg',17495,'http://192.168.0.105:8153/storage/file/8b25c08b421f4f149d185678cdd44498.jpg','2020-02-18 19:13:14','2020-02-18 19:13:14'),
(2,'4d43e5b58a544067a6466cf75565cc84.jpg','10001_1021582028328349.jpg','image/jpg',18515,'http://192.168.0.105:8153/security/storage/file/4d43e5b58a544067a6466cf75565cc84.jpg','2020-02-18 20:18:49','2020-02-18 20:18:49'),
(3,'54a975554b0d47ecbfbd9bca3a703722.jpg','10001_1011582076861276.jpg','image/jpg',35631,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/54a975554b0d47ecbfbd9bca3a703722.jpg','2020-02-19 09:47:51','2020-02-19 09:47:51'),
(4,'e5078e1d9e4047d6b794b0345e429df4.jpg','10001_1011582077081292.jpg','image/jpg',17495,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/e5078e1d9e4047d6b794b0345e429df4.jpg','2020-02-19 09:51:29','2020-02-19 09:51:29'),
(5,'47c8514e4b064cc0b1ed2f9070e3da76.jpg','10001_1011582077673454.jpg','image/jpg',233943,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/47c8514e4b064cc0b1ed2f9070e3da76.jpg','2020-02-19 10:01:20','2020-02-19 10:01:20'),
(6,'60b7ef57634f412795ab9c3d459d49bf.jpg','10001_1021582447060301.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/60b7ef57634f412795ab9c3d459d49bf.jpg','2020-02-23 16:37:49','2020-02-23 16:37:49'),
(7,'a386aeabd8254ebab06cf489dbc95b54.jpg','10001_1011582447107457.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/a386aeabd8254ebab06cf489dbc95b54.jpg','2020-02-23 16:38:28','2020-02-23 16:38:28'),
(8,'969fc01ecb664fb0aeb13b583e7e9848.jpg','10001_1011582451224439.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/969fc01ecb664fb0aeb13b583e7e9848.jpg','2020-02-23 17:47:06','2020-02-23 17:47:06'),
(9,'5feee0036ae846498e19bb8b9c6b80b3.jpg','10001_1021582451226953.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5feee0036ae846498e19bb8b9c6b80b3.jpg','2020-02-23 17:47:07','2020-02-23 17:47:07'),
(10,'2ddec8bc8d654f9598b11e38b6f1e0e7.jpg','10001_1011582451493093.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/2ddec8bc8d654f9598b11e38b6f1e0e7.jpg','2020-02-23 17:51:33','2020-02-23 17:51:33'),
(11,'d04205c2af664b9fa88a156cca30a484.jpg','10001_1021582451495834.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d04205c2af664b9fa88a156cca30a484.jpg','2020-02-23 17:51:36','2020-02-23 17:51:36'),
(12,'2475480d8e444a51b0f15eddda5ce769.jpg','10001_1011582451573232.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/2475480d8e444a51b0f15eddda5ce769.jpg','2020-02-23 17:52:53','2020-02-23 17:52:53'),
(13,'0fb5b87bcf0543439e8979f5865c7931.jpg','10001_1011582451618777.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/0fb5b87bcf0543439e8979f5865c7931.jpg','2020-02-23 17:53:39','2020-02-23 17:53:39'),
(14,'26e326f7cb264a21b5c9c87001177484.jpg','10001_1011582451834201.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/26e326f7cb264a21b5c9c87001177484.jpg','2020-02-23 17:57:14','2020-02-23 17:57:14'),
(15,'82d7028a805f43468d4eb427ef5e90fd.jpg','10001_1011582451897215.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/82d7028a805f43468d4eb427ef5e90fd.jpg','2020-02-23 17:58:18','2020-02-23 17:58:18'),
(16,'bca01650ecb548bba13cf4000ea0f89f.jpg','10001_1011582452073852.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/bca01650ecb548bba13cf4000ea0f89f.jpg','2020-02-23 18:01:14','2020-02-23 18:01:14'),
(17,'361365dc13ca41489d41148e1009f628.jpg','10001_1011582452132504.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/361365dc13ca41489d41148e1009f628.jpg','2020-02-23 18:02:13','2020-02-23 18:02:13'),
(18,'82ee2ed25eb947849a30e060645fc07a.jpg','10001_1011582452185889.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/82ee2ed25eb947849a30e060645fc07a.jpg','2020-02-23 18:03:06','2020-02-23 18:03:06'),
(19,'cd0c6b74f10143ff9ca621a2377789a8.jpg','10001_1021582452209125.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/cd0c6b74f10143ff9ca621a2377789a8.jpg','2020-02-23 18:03:29','2020-02-23 18:03:29'),
(20,'34ef4bdbf34247298bd9838550bdfd67.jpg','10001_1021582452281492.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/34ef4bdbf34247298bd9838550bdfd67.jpg','2020-02-23 18:04:42','2020-02-23 18:04:42'),
(21,'14f44010480c4849835f56c1c60717bb.jpg','10001_1011582452289215.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/14f44010480c4849835f56c1c60717bb.jpg','2020-02-23 18:04:50','2020-02-23 18:04:50'),
(22,'78338cfcb222426d86b0009e08ff7abd.jpg','10001_1011582452442000.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/78338cfcb222426d86b0009e08ff7abd.jpg','2020-02-23 18:07:22','2020-02-23 18:07:22'),
(23,'519765d51a4c413d8591787d2bfd8295.jpg','10001_1021582452444792.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/519765d51a4c413d8591787d2bfd8295.jpg','2020-02-23 18:07:25','2020-02-23 18:07:25'),
(24,'bfb578d7b5c74b43b6821c1833ea8027.jpg','10001_1011582457594298.jpg','image/jpg',233943,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/bfb578d7b5c74b43b6821c1833ea8027.jpg','2020-02-23 19:33:15','2020-02-23 19:33:15'),
(25,'4d0a328216374e4683831fe1428885a6.jpg','10001_1011582457728064.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/4d0a328216374e4683831fe1428885a6.jpg','2020-02-23 19:35:28','2020-02-23 19:35:28'),
(26,'a4ca0579d47043988296f87554157802.jpg','10001_5041582460329281.jpg','image/jpg',14999,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/a4ca0579d47043988296f87554157802.jpg','2020-02-23 20:18:50','2020-02-23 20:18:50'),
(27,'4fd7cfa3d5e5463884c8b3d0b3acdeda.jpg','10001_4021582460365760.jpg','image/jpg',3883,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/4fd7cfa3d5e5463884c8b3d0b3acdeda.jpg','2020-02-23 20:19:26','2020-02-23 20:19:26'),
(28,'407b20a4d25e4277bb774c7390d33b5f.jpg','10001_4011582460365753.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/407b20a4d25e4277bb774c7390d33b5f.jpg','2020-02-23 20:19:27','2020-02-23 20:19:27'),
(29,'0b89788cdd6c4f968cab08c69b8a7e98.jpg','10001_4011582460365827.jpg','image/jpg',12967,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/0b89788cdd6c4f968cab08c69b8a7e98.jpg','2020-02-23 20:19:26','2020-02-23 20:19:26'),
(30,'5dd05dfc5455488ba398e58ecd3cffd2.jpg','10001_3011582460365917.jpg','image/jpg',104859,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5dd05dfc5455488ba398e58ecd3cffd2.jpg','2020-02-23 20:19:29','2020-02-23 20:19:29'),
(31,'338f309dbbdc49cab6c3b9978bb85532.jpg','10001_3011582460366058.jpg','image/jpg',104859,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/338f309dbbdc49cab6c3b9978bb85532.jpg','2020-02-23 20:19:30','2020-02-23 20:19:30'),
(32,'82fdca5b386142fd8a99e205fbc83477.jpg','10001_3011582460368557.jpg','image/jpg',104859,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/82fdca5b386142fd8a99e205fbc83477.jpg','2020-02-23 20:19:30','2020-02-23 20:19:30'),
(33,'f030e5ace65f4c9f8456c54e152f4aba.jpg','10001_3011582551764007.jpg','image/jpg',84879,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f030e5ace65f4c9f8456c54e152f4aba.jpg','2020-02-24 21:42:47','2020-02-24 21:42:47'),
(34,'3c193bc0a3744d92af8496f90d7a8b29.jpg','10001_3011582556368290.jpg','image/jpg',72399,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/3c193bc0a3744d92af8496f90d7a8b29.jpg','2020-02-24 22:59:30','2020-02-24 22:59:30'),
(35,'e5e36294146547b7b04ecb4cc23d86da.jpg','10001_3011582599313110.jpg','image/jpg',144055,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/e5e36294146547b7b04ecb4cc23d86da.jpg','2020-02-25 10:55:14','2020-02-25 10:55:14'),
(36,'83eac5a993e544e59d1a51c8cf2daa5b.jpg','10001_3011582600748651.jpg','image/jpg',94815,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/83eac5a993e544e59d1a51c8cf2daa5b.jpg','2020-02-25 11:19:10','2020-02-25 11:19:10'),
(37,'86aea7501f2e41288dcec376a8318f2d.jpg','10001_3011582600748576.jpg','image/jpg',94815,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/86aea7501f2e41288dcec376a8318f2d.jpg','2020-02-25 11:19:10','2020-02-25 11:19:10'),
(38,'544abb200a624a4281862661c7f7a78d.jpg','10001_3011582600751658.jpg','image/jpg',94815,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/544abb200a624a4281862661c7f7a78d.jpg','2020-02-25 11:19:17','2020-02-25 11:19:17'),
(39,'6c02b50ca3d94478858ed96947629684.jpg','10001_1031582702926334.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/6c02b50ca3d94478858ed96947629684.jpg','2020-02-26 15:42:10','2020-02-26 15:42:10'),
(40,'d5b0e2e445824719acbc54fb09682538.jpg','10001_1011582704812364.jpg','image/jpg',14999,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d5b0e2e445824719acbc54fb09682538.jpg','2020-02-26 16:13:33','2020-02-26 16:13:33'),
(41,'5881cc5e8da84152bbe983e53810aa23.jpg','10001_1021582704814834.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5881cc5e8da84152bbe983e53810aa23.jpg','2020-02-26 16:13:35','2020-02-26 16:13:35'),
(42,'edb63da81ad441f9b67afb83b652a9c2.jpg','10001_1011582705033607.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/edb63da81ad441f9b67afb83b652a9c2.jpg','2020-02-26 16:17:14','2020-02-26 16:17:14'),
(43,'8f4be85c8ee846f0972b0e1a1c7f1c12.jpg','10001_1021582705036084.jpg','image/jpg',14899,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/8f4be85c8ee846f0972b0e1a1c7f1c12.jpg','2020-02-26 16:17:16','2020-02-26 16:17:16'),
(44,'90753e56b45f4aeba3e02da3ec5aab0d.jpg','10001_1011582705074089.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/90753e56b45f4aeba3e02da3ec5aab0d.jpg','2020-02-26 16:17:54','2020-02-26 16:17:54'),
(45,'408fd28210ee4e2381c0250682ba9bc4.jpg','10001_1021582705076176.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/408fd28210ee4e2381c0250682ba9bc4.jpg','2020-02-26 16:17:56','2020-02-26 16:17:56'),
(46,'8b26fae2486f4c31b76229d444e58a4f.jpg','10001_1051582707408259.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/8b26fae2486f4c31b76229d444e58a4f.jpg','2020-02-26 16:56:48','2020-02-26 16:56:48'),
(47,'0c241c9e97f448b1814770c9d06f3587.jpg','10001_1051582707425299.jpg','image/jpg',12967,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/0c241c9e97f448b1814770c9d06f3587.jpg','2020-02-26 16:57:05','2020-02-26 16:57:05'),
(48,'f11f348c99be4a7c89e8738484c09cdb.jpg','10001_1031582707455022.jpg','image/jpg',8919,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f11f348c99be4a7c89e8738484c09cdb.jpg','2020-02-26 16:57:35','2020-02-26 16:57:35'),
(49,'267123280eab4557bfb9674ba352dc59.jpg','10001_1011582709174078.jpg','image/jpg',14999,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/267123280eab4557bfb9674ba352dc59.jpg','2020-02-26 17:26:14','2020-02-26 17:26:14'),
(50,'2c9bfa735441446eb9e270f993e55181.jpg','10001_1031582709193038.jpg','image/jpg',14999,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/2c9bfa735441446eb9e270f993e55181.jpg','2020-02-26 17:26:33','2020-02-26 17:26:33'),
(51,'5ebb696bcf7e492abea8d5ef4f56f98e.jpg','10001_1031582709264325.jpg','image/jpg',14999,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5ebb696bcf7e492abea8d5ef4f56f98e.jpg','2020-02-26 17:27:44','2020-02-26 17:27:44'),
(52,'7c79e27585844db6a1db168ae62f54aa.jpg','10001_1031582709268511.jpg','image/jpg',8919,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/7c79e27585844db6a1db168ae62f54aa.jpg','2020-02-26 17:27:49','2020-02-26 17:27:49'),
(53,'18afdc39813d4a20b7947eb0cd22b855.jpg','10001_1011582717673930.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/18afdc39813d4a20b7947eb0cd22b855.jpg','2020-02-26 19:47:54','2020-02-26 19:47:54'),
(54,'4e65513a4e0a43d595874988534ebde7.jpg','10001_1021582717680216.jpg','image/jpg',6139,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/4e65513a4e0a43d595874988534ebde7.jpg','2020-02-26 19:48:00','2020-02-26 19:48:00'),
(55,'abea215e8d2b4db784a1b63b0aa70479.jpg','10001_1011582717880742.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/abea215e8d2b4db784a1b63b0aa70479.jpg','2020-02-26 19:51:21','2020-02-26 19:51:21'),
(56,'8878e00d50fd46ed9328f4abd42db5a9.jpg','10001_1011582717904959.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/8878e00d50fd46ed9328f4abd42db5a9.jpg','2020-02-26 19:51:45','2020-02-26 19:51:45'),
(57,'8550165a8286445eb2076d4dce2674f8.jpg','10001_1021582717907386.jpg','image/jpg',6139,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/8550165a8286445eb2076d4dce2674f8.jpg','2020-02-26 19:51:48','2020-02-26 19:51:48'),
(58,'cc351c4252d64fdfa4a555fc06d8390d.jpg','10001_1011582718073877.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/cc351c4252d64fdfa4a555fc06d8390d.jpg','2020-02-26 19:54:34','2020-02-26 19:54:34'),
(59,'b00de9e224e543d8a142f00669169d81.jpg','10001_1021582718076180.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/b00de9e224e543d8a142f00669169d81.jpg','2020-02-26 19:54:36','2020-02-26 19:54:36'),
(60,'b6abcfc11db74b60a3d634f6d0a5ebea.jpg','10001_1011582718139480.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/b6abcfc11db74b60a3d634f6d0a5ebea.jpg','2020-02-26 19:55:40','2020-02-26 19:55:40'),
(61,'b592fe06ba7a4cd5a2a3770f400465b1.jpg','10001_1021582718142504.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/b592fe06ba7a4cd5a2a3770f400465b1.jpg','2020-02-26 19:55:43','2020-02-26 19:55:43'),
(62,'699c13d28b9a42e29c51f3bb614f0eca.jpg','10001_1011582718207618.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/699c13d28b9a42e29c51f3bb614f0eca.jpg','2020-02-26 19:56:48','2020-02-26 19:56:48'),
(63,'88ffa145ffda497eb135f9345bd88a18.jpg','10001_1021582718210429.jpg','image/jpg',6139,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/88ffa145ffda497eb135f9345bd88a18.jpg','2020-02-26 19:56:50','2020-02-26 19:56:50'),
(64,'c557ddfb4b66442182df82796e9f1fd8.jpg','10001_1011582718218733.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/c557ddfb4b66442182df82796e9f1fd8.jpg','2020-02-26 19:56:59','2020-02-26 19:56:59'),
(65,'34cf515bd48745cf905fb50e41c20302.jpg','10001_1011582718484555.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/34cf515bd48745cf905fb50e41c20302.jpg','2020-02-26 20:01:25','2020-02-26 20:01:25'),
(66,'130c8e0533e04ec699a8b6c68cf2b5dc.jpg','10001_1011582718506895.jpg','image/jpg',6167,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/130c8e0533e04ec699a8b6c68cf2b5dc.jpg','2020-02-26 20:01:47','2020-02-26 20:01:47'),
(67,'b32a48dbc14d41839c42474f61e97b8a.jpg','10001_1011582718590791.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/b32a48dbc14d41839c42474f61e97b8a.jpg','2020-02-26 20:03:11','2020-02-26 20:03:11'),
(68,'c3ae38f6a81f404aa4b769e3b77ee3bd.jpg','10001_1031582718604594.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/c3ae38f6a81f404aa4b769e3b77ee3bd.jpg','2020-02-26 20:03:25','2020-02-26 20:03:25'),
(69,'1fe2cbcb259942f6b3ea0bb90bf7d285.jpg','10001_1031582718769115.jpg','image/jpg',14759,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/1fe2cbcb259942f6b3ea0bb90bf7d285.jpg','2020-02-26 20:06:09','2020-02-26 20:06:09'),
(70,'5e9c36467a944af4b3dd6934c015ba71.jpg','10001_1051582718773209.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5e9c36467a944af4b3dd6934c015ba71.jpg','2020-02-26 20:06:13','2020-02-26 20:06:13'),
(71,'e4501e82ef7c4a9f93f0cd2415825c74.jpg','10001_1041582721719301.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/e4501e82ef7c4a9f93f0cd2415825c74.jpg','2020-02-26 20:55:19','2020-02-26 20:55:19'),
(72,'d53f9972416342d1800c17a7b3fc06e1.jpg','10001_1041582721778509.jpg','image/jpg',15035,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d53f9972416342d1800c17a7b3fc06e1.jpg','2020-02-26 20:56:19','2020-02-26 20:56:19'),
(73,'d7f195504a38498faa929a61ba5b8cba.jpg','10001_1011582767573497.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d7f195504a38498faa929a61ba5b8cba.jpg','2020-02-27 09:39:35','2020-02-27 09:39:35'),
(74,'deb8a7ab2e30434bbe5055315c848d6f.jpg','10001_1021582767576539.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/deb8a7ab2e30434bbe5055315c848d6f.jpg','2020-02-27 09:39:37','2020-02-27 09:39:37'),
(75,'d3b098b6c1864176a0b784c3a2a1d96c.jpg','10001_1011582767857732.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/d3b098b6c1864176a0b784c3a2a1d96c.jpg','2020-02-27 09:44:18','2020-02-27 09:44:18'),
(76,'3883aa385ede42e7964384f56f7f36b3.jpg','10001_1021582767860282.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/3883aa385ede42e7964384f56f7f36b3.jpg','2020-02-27 09:44:20','2020-02-27 09:44:20'),
(77,'3095627be3df4c64b82f2a711f86c07e.jpg','10001_1011582768070123.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/3095627be3df4c64b82f2a711f86c07e.jpg','2020-02-27 09:47:50','2020-02-27 09:47:50'),
(78,'7eaafecc19ac4d55a444ac8336cf6c48.jpg','10001_1021582769332641.jpg','image/jpg',140471,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/7eaafecc19ac4d55a444ac8336cf6c48.jpg','2020-02-27 10:08:53','2020-02-27 10:08:53'),
(79,'aeaf384981104a458641de86e44d1ebb.jpg','10001_1011582769380933.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/aeaf384981104a458641de86e44d1ebb.jpg','2020-02-27 10:09:41','2020-02-27 10:09:41'),
(80,'42a21649b0aa4b1592cc4a02fcb65239.jpg','10001_1011582769462913.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/42a21649b0aa4b1592cc4a02fcb65239.jpg','2020-02-27 10:11:03','2020-02-27 10:11:03'),
(81,'536e95eb2b3648d9a50d2b5ee3cafee9.jpg','10001_1011582769546336.jpg','image/jpg',133083,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/536e95eb2b3648d9a50d2b5ee3cafee9.jpg','2020-02-27 10:12:27','2020-02-27 10:12:27'),
(82,'8d3ac6d1593e4491b9cc7b0fbc383c89.jpg','10001_3011582792026428.jpg','image/jpg',87919,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/8d3ac6d1593e4491b9cc7b0fbc383c89.jpg','2020-02-27 16:27:07','2020-02-27 16:27:07'),
(83,'f61bb3ac289440e89ce90ef99fe2d635.jpg','10001_3011582792828189.jpg','image/jpg',58139,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f61bb3ac289440e89ce90ef99fe2d635.jpg','2020-02-27 16:40:28','2020-02-27 16:40:28'),
(84,'57c7ad0b0ec34fa493e07f792ec0fa40.jpg','10001_3011582796989040.jpg','image/jpg',119995,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/57c7ad0b0ec34fa493e07f792ec0fa40.jpg','2020-02-27 17:49:50','2020-02-27 17:49:50'),
(85,'ad9eb69202644d4f8b7c161e8fcb87a3.jpg','10001_3011582807732500.jpg','image/jpg',75027,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/ad9eb69202644d4f8b7c161e8fcb87a3.jpg','2020-02-27 20:48:53','2020-02-27 20:48:53'),
(86,'6c2a3af5bd6240909fdc84966ae605f9.jpg','10001_3011582807756269.jpg','image/jpg',94279,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/6c2a3af5bd6240909fdc84966ae605f9.jpg','2020-02-27 20:49:16','2020-02-27 20:49:16'),
(87,'ed8c3bdd6b8e453ab87ebea5dea852c0.jpg','10001_3011582807765834.jpg','image/jpg',63587,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/ed8c3bdd6b8e453ab87ebea5dea852c0.jpg','2020-02-27 20:49:26','2020-02-27 20:49:26'),
(88,'37850aed716e4deb97f235c0c9bb4d4c.jpg','10001_3011582808031916.jpg','image/jpg',80691,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/37850aed716e4deb97f235c0c9bb4d4c.jpg','2020-02-27 20:53:52','2020-02-27 20:53:52'),
(89,'b745843838ae454d88f98d03b0ffe96b.jpg','10001_3011582810958234.jpg','image/jpg',75615,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/b745843838ae454d88f98d03b0ffe96b.jpg','2020-02-27 21:42:39','2020-02-27 21:42:39'),
(90,'9cdf7ff9caec419cba34ea80fa020e00.jpg','10001_3011582813676367.jpg','image/jpg',60463,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/9cdf7ff9caec419cba34ea80fa020e00.jpg','2020-02-27 22:27:57','2020-02-27 22:27:57'),
(91,'281d1f2b609b4f3faf9fefd138b91eeb.jpg','10001_3021582815387168.jpg','image/jpg',133671,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/281d1f2b609b4f3faf9fefd138b91eeb.jpg','2020-02-27 22:56:28','2020-02-27 22:56:28'),
(92,'1c93348e64df400bb03438da46adf73d.jpg','10001_3021582815398132.jpg','image/jpg',133671,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/1c93348e64df400bb03438da46adf73d.jpg','2020-02-27 22:56:38','2020-02-27 22:56:38'),
(93,'30b9a3ecfdca4d40a2f7e677e87171bf.jpg','10001_3011582817083671.jpg','image/jpg',103199,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/30b9a3ecfdca4d40a2f7e677e87171bf.jpg','2020-02-27 23:24:44','2020-02-27 23:24:44'),
(94,'c80c0187f6df49f28571fa9606c263db.jpg','10001_3011582817352469.jpg','image/jpg',81535,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/c80c0187f6df49f28571fa9606c263db.jpg','2020-02-27 23:29:13','2020-02-27 23:29:13'),
(95,'a952587f58744ab8b3e5975d778e33cd.jpg','10001_3011582817352863.jpg','image/jpg',81535,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/a952587f58744ab8b3e5975d778e33cd.jpg','2020-02-27 23:29:13','2020-02-27 23:29:13'),
(96,'98ee8473f00047cd81986e697b9c1327.jpg','10001_3011582817846258.jpg','image/jpg',81327,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/98ee8473f00047cd81986e697b9c1327.jpg','2020-02-27 23:37:27','2020-02-27 23:37:27'),
(97,'e682723210144f9fb1ce50cfe6a31ec5.jpg','10001_3011582853942058.jpg','image/jpg',113839,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/e682723210144f9fb1ce50cfe6a31ec5.jpg','2020-02-28 09:39:06','2020-02-28 09:39:06'),
(98,'01de03cff53541e5a56b914a1f01fd86.jpg','10001_3011582853944916.jpg','image/jpg',113839,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/01de03cff53541e5a56b914a1f01fd86.jpg','2020-02-28 09:39:06','2020-02-28 09:39:06'),
(99,'861231dffbe040f3961117455b92b48b.jpg','10001_3011582867542903.jpg','image/jpg',64727,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/861231dffbe040f3961117455b92b48b.jpg','2020-02-28 13:25:44','2020-02-28 13:25:44'),
(100,'18f39fb2a58d4bebad8c350a185237c1.jpg','10001_3011582867538665.jpg','image/jpg',64727,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/18f39fb2a58d4bebad8c350a185237c1.jpg','2020-02-28 13:25:44','2020-02-28 13:25:44'),
(101,'5adb0bc36f3d4f86bfa33ea6f71f93a4.jpg','10001_3011582868302949.jpg','image/jpg',115063,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/5adb0bc36f3d4f86bfa33ea6f71f93a4.jpg','2020-02-28 13:38:24','2020-02-28 13:38:24'),
(102,'f2e77897166e4cc5aab9f6d7cbcaffb5.jpg','10001_3011583151989032.jpg','image/jpg',133359,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f2e77897166e4cc5aab9f6d7cbcaffb5.jpg','2020-03-02 20:26:33','2020-03-02 20:26:33'),
(103,'660d2128f42445c0ad70c7bccb7bd0e2.jpg','10001_3011583151988821.jpg','image/jpg',133359,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/660d2128f42445c0ad70c7bccb7bd0e2.jpg','2020-03-02 20:26:33','2020-03-02 20:26:33'),
(104,'7964f7c88978409890b580c36bbe1003.jpg','10001_3011583152530533.jpg','image/jpg',95787,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/7964f7c88978409890b580c36bbe1003.jpg','2020-03-02 20:35:31','2020-03-02 20:35:31'),
(105,'6dc28f7a2a3946189c1f5af1d102c247.jpg','10001_3011583152649381.jpg','image/jpg',80655,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/6dc28f7a2a3946189c1f5af1d102c247.jpg','2020-03-02 20:37:30','2020-03-02 20:37:30'),
(106,'a342f8ae69c4497d856cc0626dfd9b61.jpg','10001_3011583152675428.jpg','image/jpg',105403,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/a342f8ae69c4497d856cc0626dfd9b61.jpg','2020-03-02 20:37:56','2020-03-02 20:37:56'),
(107,'fd50545304d8446195d03b95e1c093c8.jpg','10001_3011583152757010.jpg','image/jpg',75563,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/fd50545304d8446195d03b95e1c093c8.jpg','2020-03-02 20:39:18','2020-03-02 20:39:18'),
(108,'655cb74bab64492099ebbccdeac314b6.jpg','10001_3011583152946662.jpg','image/jpg',119363,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/655cb74bab64492099ebbccdeac314b6.jpg','2020-03-02 20:42:28','2020-03-02 20:42:28'),
(109,'f74e9f0d1b2c4506b2be9e1f835444f7.jpg','10001_3011583153003779.jpg','image/jpg',97223,'https://security-1258565443.cos-website.ap-guangzhou.myqcloud.com/f74e9f0d1b2c4506b2be9e1f835444f7.jpg','2020-03-02 20:43:24','2020-03-02 20:43:24');

/*Table structure for table `verify_bank_card` */

DROP TABLE IF EXISTS `verify_bank_card`;

CREATE TABLE `verify_bank_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',
  `bank_card` varchar(30) DEFAULT NULL COMMENT '银行卡号',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `is_valid` tinyint(1) DEFAULT NULL COMMENT '状态(0:不通过 1:通过)',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `check_count` int(2) DEFAULT '1' COMMENT '验证次数',
  `check_date` datetime DEFAULT NULL COMMENT '验证时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `index_card_verify` (`user_name`,`id_card`,`bank_card`,`phone`),
  KEY `idx_id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='银行卡四要素验证信息表';

/*Data for the table `verify_bank_card` */

insert  into `verify_bank_card`(`id`,`user_name`,`id_card`,`bank_card`,`phone`,`is_valid`,`remark`,`check_count`,`check_date`,`create_time`,`update_time`) values 
(1,'周文晋','430381199312285013','6222021001092536883','18938070402',0,'b87e77cd-c0de-46b0-8052-f9c120be96b4认证未通过',1,'2020-02-20 09:59:45','2020-02-20 09:59:45','2020-02-20 09:59:45'),
(2,'周文晋','430381199312285013','6222021001092536884','18938070402',1,NULL,1,'2020-02-20 10:01:52','2020-02-20 10:01:52','2020-02-28 11:59:53'),
(3,'陶伟','360103197410053411','6222000000000000','18900000000',0,'8ee1a573-127b-4ab6-a2e7-1407b467c1ef-认证未通过',1,'2020-02-23 19:32:41','2020-02-23 19:32:41','2020-02-23 19:32:41');

/*Table structure for table `verify_id_card` */

DROP TABLE IF EXISTS `verify_id_card`;

CREATE TABLE `verify_id_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证',
  `is_valid` tinyint(1) DEFAULT NULL COMMENT '状态(0:不通过 1:通过)',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `check_count` int(2) DEFAULT '1' COMMENT '验证次数',
  `check_date` datetime DEFAULT NULL COMMENT '验证时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ukey_card_verify` (`user_name`,`id_card`),
  KEY `idx_id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='身份证验证信息表';

/*Data for the table `verify_id_card` */

insert  into `verify_id_card`(`id`,`user_name`,`id_card`,`is_valid`,`remark`,`check_count`,`check_date`,`create_time`,`update_time`) values 
(1,'周国军','430381197607065019',1,NULL,1,'2020-02-23 19:34:44','2020-02-23 19:34:44','2020-02-23 19:34:44'),
(2,'周文晋','430381199312285013',1,NULL,1,'2020-02-23 20:17:34','2020-02-23 20:17:34','2020-02-28 11:59:27'),
(3,'陶伟','360103197410053411',1,NULL,1,'2020-02-27 10:53:45','2020-02-27 10:53:45','2020-03-02 20:29:37');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
