-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2018 at 07:19 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'soap'),
(7, 'Remotes');

-- --------------------------------------------------------

--
-- Table structure for table `employeeinfo`
--

CREATE TABLE `employeeinfo` (
  `empid` int(11) NOT NULL,
  `empname` varchar(255) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `bloodgroup` varchar(50) NOT NULL,
  `contactno` bigint(50) NOT NULL,
  `post` varchar(255) NOT NULL,
  `salary` varchar(11) NOT NULL,
  `doj` date NOT NULL,
  `address` text NOT NULL,
  `empimage` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeeinfo`
--

INSERT INTO `employeeinfo` (`empid`, `empname`, `gender`, `age`, `bloodgroup`, `contactno`, `post`, `salary`, `doj`, `address`, `empimage`) VALUES
(1, 'Ram', 'Female', 20, 'AB+', 9422673891, 'Receptionist', 'Pending', '2018-07-20', 'hnm', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800dc007603012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00e4a08e3642c41cd2bcd0aa9448c93ea6ab862176eee3d2a64f29bef1c57d01c245e6fa2815225c953ca8229c224738404d3a7b1960601d70719a39a3b14a0dea481e397a617daae7f67958965dea548e3159d15acaf9d8b9c55a0f751461093b7d08aca4fa266b1835ab469e956a8f78a245dc83a926b67c9b17bb3179401c7ddce0d6169d710973e79653d88edf856a5d69f1189a58b74aec3820715cd37ef6a74423788e9b4c32b1f2e208b8edcd66cd6514528423f1ae86c2ca5874c2257f2cf24e7ad114361180f26c7cf508738acd5568d7d9230a58238a31b47cc39fad27da24b9c2b48a88bfc39adf9ecec6500c273bba027fa0aa72da5b47852a880f7634d544c4e99416c309e601b81aa93e73b44780062b66d440864592e17cb03aaf5fa0aad2bd8ab615f20f720d353771b82b194918e7228abcf2da93f2918f65eb455f3b27951cefd9118e11d49a70d3dc350966586f59571d7af34e17f776e36a382071d01ae9bb7f0b38d24b744c96cd6f862d83db1cd6b26a162f0837251a5c639078acdb4d59784bab6475f51c1a2e9ec656fdc215cfad6324e4fde368b497bacded3dc3dc892ca18645c60a7b55fbfd32396357722390f5503a571d6ed35a1f3a17287b569c3e26bb0db65dae3a127a9aca74e57bc59b46a2b5a4473c51db4842ab3e3be3156a7d5bcdb54863df1ed00702a68e4b1d401925b8f2dfb29a65c59228dd13165f5db4b997da1f2bfb267bdc5c4e555a4dd8e07353f95a9942891108dd7e5eb4e96cd3cbdcacd91d78a48eea64511a4b2055f53c5372bfc20a16f88d0b5b1bcb78c16758d9ba0ce0d56bab79a273e6162a4e720e6a48352995b6ce43283dc649fc6ad4b7f0489bdada5dbd307358b724f53a128b5a19d6d246f288a5711464f2c456e49a359b5b868e5560dcab6739fcab205cd9b46516dc827f1e6a4b5bab88d0c504a769e400bc8a99b6f55a0e314365d0e5cfeec8c7ae0d15d569f2c9f655f3c82df4a2b2f6f345fb38f63c943ecfbbb87ad48a030f9725bd29dbd768dd18fad58b74864c6d9021efb9b15ec37d4f1a2ba15c2b83ce055eb6b312479dca58f1d6ac43651b82140771dd5b348d05c5b13b61c9233cf6ac653be88de30b6a2c362ab28598e109c16cf4a96f34b862c949411d45534ba76609326173d45745671c1e4e1260e4f1f39e9594db8bbdcda29495ac60416c01c87e476adab49a6101605502f524673497f6a6251b767b6de49acbf3ae63ca06f949e4114be343f80dcb6bb82556695d19fa631504f0c2e498d00cf726b1880c791cfa835a168914a87372e84762322a5c54754691939683e0b26965009c0cfdeadbfdc416cb0ac858e3938eb556d618c21db2ac8fd837152c91bec05940fa573ce5ccf53a60acb41b1da0721d182fb55bb65f23931213ea16b358c88f9087d8e0d59b6d4a16252684ab81c64e05449368a4fb971ae4963fbbc7be28aaa192e49313e00feed153ca3d0e1609e1db89e227d0e714db831efc423e5ed5504ce46093566da7030a4a819e722bda6ada9e1a77d08e367470ca76b0ee0e2b486ab7722888befc7ad44f6d0b1261df29ff006578a622881c168db3e959c9c646b18ca25a4937b10e1b77a0151cd1c83919c54c2f226e91ec206492d5665d684b0ac66284e06326b2bc93d11bda36d58cd375b9ec5c6f8d67503015eb5a3d4adb523fbe863839ecb9ac8b2ba02e39823973fc22adde46b2057481910f040cf5ace69736d634a69daf7b9a834d516e5d4c2c1ba152093587341716f21054edce4e053ad1daca5f31e07319e315b8975a7de2855668988fbaea47eb5973383ee8d9454d76673ff6c019580271d456cd84d757a8764c15547dd23815345a1da316fdfa37fb2ac0d6ac31a5bc5e5c2b1283c7a9359d4ad16b44694e8b5bb39e985fa484198119eb9e0d3a2b5bb9e418f2dce7a8adf4813766480be7a6d4c629ce6ced5c111b076381819ac9d6e891afb244569a7b5a83bd43337a51539ba4231248e9e9918a2b2726cae53ccede5b26216e15a3f70334d16d04b237977080678dc7155e5fb3b80f1c879eaa4722a10b96c0e4fb0af72dd6e7877e964cdc8a0b9d3dd658d0bf1c15e86a64bc69df134072dc06040c5661824112298e51c75cff004a55b290eddd2ec3d831ac5a4f56cea5ccb48a35df49b771bfed0b1e7fbd50be93105f9678d9bd9c536db4aba7f992e22603b33835ab6e9881bed16910653c320ac2555c7695ce985052de3632134bb80729927fd9209ab22defa30a596408bc827a55d92d7332bfda1608cf50a706abea0f02154b5677f572c4f34bdab9bb0dd08c1365b8ee242630e8768ec723357116ce593e638ef80d8ae7ac35cd46ea67b67102c7133461886dcd8eed93cf5ed8a9ae4cf248a5e6471d3e418ace5077b376348544e3748e9a2d2f4f605c499cf504f0296e34ab544df0c6c1b1c156ae7e0bc9e6d7068bb228a311799e6fcdbd8e01dbd718c73d33ef5b0249ec061d9e54f409802b9e4a517b9d106a49e9b129d426b4b7d92021c0e37f3fcaa8adeddce0bb5f411b1e8a53fc6992ddc13b9322dd1f51da990c364f2e5639c93fc246053564b540e2dbd05920d52539174927bae0d142c512e7f7663e7a0279a2abda7f5617b1feae701bfe6e2a44976f5ce2a1dcb8fbb834e562a7206715ed3d8f9c574cdcb0d56140a92c6b91c0623f9d698867bc5df1a5bba7f78d72cd70ac411101c7ad21959b1918c7a1ae5950bbbad0f4218ae55cb2d7f03ae6b255407ecb22ca060f97c83496b68b83e6a3a639c7415ccc17f7503031dc48b8edb8e29f2dfdd4e4f993c8c0f62dc562e84f6b9d0b174f7e537aeade37e6064523a032026996a2480ee6bcf28af215f041ae770dd48352c6d83d3f3abf64d2b5c8fac272bf29120fed0d5352479ca179b7028a4e4fd0102aedb680d72008f527cfb4678fd6b2b4f75fb7de38073e6657773dcf5ae862bb6818bc0e235946781d28a8a4b489343924ef329d9d94b65e2b8ed3ed6cf247196121c8e70081d6bae691d225916f25c107fd663f11f81e2b866b9b85d7e3b91213232b7cd81c8e47f4ad786fe7989866727cc3953d3e6e983f5e3f4e9cd61569ca566d9d34aac21749753a7b5be81d42bc88d27a918cd4e0ac8d9dcbff000138ae4e09614077ab97e9f4ad1b38657920def7096f29c06ced07b7049c7535c9568a8dddcec8622eb546db7970c61db3b49c672719a2b9f3777729fb3d95cbac3193bdf6ab6e7048f9739e31dfbfe14573f23ee57b7f238ef3370c9e6a45b80a8547cb9eb8ef55c1047523da93073c9afa4b23e6af25aa2c2baf4c8fcaa429f20718e7f3a8a30dfc0738ec4d38cedbb6c8085f45e2a5dfa1b452b7bc28200e739fad4de6854e0839ec6aaf1bbe5ce3dcd4b1a87e0119f7a4fcc217d916123796269530557a81d453015073d00eb9a62ef81b292107bec3520963f2e46977820121f1ce6a2f635e54f47a333ed164324ad1924963938f7ad7b2f38830c9c46dd18afdc3ebfe3ffd6acc84aa9764e0191b1dfbd59fb43ac4c07cbb875a8a8a52d99a52708ab4913b5ac965a9c06751c03ce321860e0fd2a7753336e58f0a7b01c5386a4f1470a88a29e10c4049572071d88208fc0d6a5a3bf94b7074e892272426e7665241e460107f5ae5955715791d3c89be55b17f48d3629a35b9be4592104ee97ccdbc0ebbbd3fdeefdf9aa5af6ab0d8e9db3cc962b2c606ee1e70719545cfddef9eff004acdd7b5e168035d389676f9a3b58c048d4f383b471dcf2726b82bdbc9efa7335cc85dba004f0a3d07a0ac2961aa569734de8457c4c28c7963b96b55d6ae7549be4cdbdb2ffab850f03dcfa9a2b29a5c74a2bd58d18455923c7955949ddb3a38f6b300cc40a712c99018919e0e6a2f94b1c3103df9a7c7b15bf7b9231dab66545696fc4923432670d8c0c9c9a4e33d6985f27a71d85008a5a8db8f42e2308a1277b673c60532378da5dd28661ec7155c3e0d38b649e6a794d7daded6e85b33280420da3d037348d233464bbb0078dc727db155f2300014a49f2ce3760f0707f9d4f294ea37b92c4aa2dc1278323f4fad231c80a33c9157f4b9e182d55a604832363033deba7b07b3783ce78e458fa2931fde23b0fa6466bcdc462e745bb41b3d4a584a55229b9d9d969632b4dd391ac96e2e8308d64f9547058907079ea3239aa5aff8996cdde3b6f2daed89ced50123e7d0719f6a97c4fe2e4915ec74e55241c19b1feac7a273ff00eaae0a764473b18b7b9f5a785a33adfbcacade4618cc54692f6749dedd46cb33cb23cb348cf231cb331c926ab3be4d23be4f34fb6b49ef1b11ae13bb9e82bd4d228f1759b2166a2ba2b6d36d2d948651331eace3f90ed454f39aaa200e2a48d4cae4348a80296dce78e067fa5478a8e63f2103f1addab9cfccd227047d29cc0062030619e1874350a1df841dce29d17ddda7a8a97b94b624a752528e9499a44729a790300719ce475cd228f6ad0d3ec1ef650a1b6c69f348dce147f8d6139a8abb3a29c1cb445fd12c12ee18d642446923b3607247a0f7aa7e23f10f9ae6cac4aa44abb19d3a01fdd07fad56bdd76eb4e4bab2d32e1e2b7773e6157f9997b038ae5a494918ace3439e7cf2dba1b62313ecd7247b21f2ce157647c0ee6a9166660aa0927a01dea58e36b8996204027b9ad7b7b48ad07cbf33f773d6ba9e9a23ce8c5cddd94ed74a1c49747e9183fceb4f70550aa0051d00e314d273de938f5a8b1ba56d876ecd14cc0f5a29d8776213c53766f214725881571f45314a15e5608c372bf96402bb88cf38e303fa54d6d611417a8659590210c725720678e33e9cd54ab452d198c28cdc9292d0a36b2bc570855d87cc3383d466948c4871d326b463b0d392627ed6ff002738debce09ef9f6a70b4d384ec1e6dcb827fd7a8fe958fb68735d2fc0dbd84f92cdadfb99e08c75029ca54ff10ab4f269517c8220cd86048763cf623a74ae822bbf0e9b584ad8aa4a1177b265b240f43d33939e7b0aceae21c55d45b2e9d0bbb5d195a7e9535e46d2a80b12f5763804fa0f5349e29d4e3d2e31a4584b2642299c952a4315048e7d3247a0edd4d5ebcf10dbc30f95a7d9fce4e0cf390cfd7b0e80fbf26b86bf9a5babb9269a4692573b9998e49359d184eb4f9aa2d17434af38d285a9bd48ee8e1d01ff009e687ff1d151adbccea196362a7a1c55ad4a302e90038fdc447ff1c5a92de465b6403a015e8cb4d8f39da526ca96f13c57d16f52be99ad72d54cb799790123a6efe55604aa6a5ab9709a5eea1d9a32693728ee28debfde1f9d4d8be662e714546664f527e828a039d9556ee4c6198b7d49a7addb2be42afa1cd5611352f96d5d3ecd1c7cefb9645c9cf2063d01e29e6e036ff917e6f4ed55446d4ff2cd4ba68a551ad094489b7be7357e19e310e3b815981180a7007041aca74ae690acd176eae22c2f9679ef590e72c4d5a652c2a2309a29c39158756a39bb8b7ade6dca9eb88a35fc940a7c5c5b8a6184b367e82a748dc460063f9d54d914a36561b6e47da63627fbc3a7b1a66f1918cfd6a4489c28ff007bfa537ecedc75a4a4ac1c8f9ee12ed21303076f3ce735288e229feb70dee38fce986dc9c7b0a984585c7f4aca52d343a146ef61d15b42cbf34ea28a448c01cff2a2b06e57dcd5457620118a5d94f02940e6bd63ca48688c528414fa70a92c6796294460d3bb9a5152c6208c51e5026a4534e1d6a18d118856a4108a7af4a957151237891adb8c62a5fb3ae3a548b8cd49915ceee74c126402d87a53becfc54f914a08ac9dcd9245716fed455b045159dd9b28a39e038a5148338a515ec9e00b4e14dc53bb5030e94a31498a00a9631e0d38534014e152c687a918a957151af4a9545652378122914e079a4414ec562f73a61b0a7ad2a9193484734e5c5672354387b5140c628a8353041e28069a0f14a0d7aecf087134e1f76a327834e53f2d218fef40229074a6af39a4c09734e0722a3ee29cbd0d431a265e952af5a816a453cd67246f1278fa53ba542a4e0d38138ac24b5378b25cf5a72f4a8b2769a7a1ca8fa543378b25078a29051599aa67ffd9);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `category_id`, `quantity`) VALUES
(47, 'Dove', 1, 100),
(48, 'Dettol', 1, 200),
(49, 'Tv', 7, 2000),
(50, 'Medimix', 1, 400);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `emailid` varchar(255) NOT NULL,
  `phoneno` int(11) NOT NULL,
  `city` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `checkindate` date NOT NULL,
  `checkoutdate` date NOT NULL,
  `roomtype` text NOT NULL,
  `noofadults` int(11) NOT NULL,
  `noofchildren` int(11) NOT NULL,
  `roomno` int(11) NOT NULL,
  `isVacant` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`firstname`, `lastname`, `emailid`, `phoneno`, `city`, `address`, `checkindate`, `checkoutdate`, `roomtype`, `noofadults`, `noofchildren`, `roomno`, `isVacant`) VALUES
('Ram', 'Seth', 'ream@gmail.com', 1234, 'Mumbai', 'mulund	', '2018-07-20', '2018-07-20', 'Super Deluxe', 0, 0, 402, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `employeeinfo`
--
ALTER TABLE `employeeinfo`
  ADD PRIMARY KEY (`empid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employeeinfo`
--
ALTER TABLE `employeeinfo`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;