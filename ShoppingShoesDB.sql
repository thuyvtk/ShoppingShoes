USE [master]
GO
/****** Object:  Database [ShoppingShoes]    Script Date: 11/3/2018 4:35:28 PM ******/
CREATE DATABASE [ShoppingShoes]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ShoppingShoes', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THUYVTKSE63436\MSSQL\DATA\ShoppingShoes.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ShoppingShoes_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THUYVTKSE63436\MSSQL\DATA\ShoppingShoes_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ShoppingShoes] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ShoppingShoes].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ShoppingShoes] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ShoppingShoes] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ShoppingShoes] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ShoppingShoes] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ShoppingShoes] SET ARITHABORT OFF 
GO
ALTER DATABASE [ShoppingShoes] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ShoppingShoes] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ShoppingShoes] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ShoppingShoes] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ShoppingShoes] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ShoppingShoes] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ShoppingShoes] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ShoppingShoes] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ShoppingShoes] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ShoppingShoes] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ShoppingShoes] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ShoppingShoes] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ShoppingShoes] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ShoppingShoes] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ShoppingShoes] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ShoppingShoes] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ShoppingShoes] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ShoppingShoes] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ShoppingShoes] SET  MULTI_USER 
GO
ALTER DATABASE [ShoppingShoes] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ShoppingShoes] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ShoppingShoes] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ShoppingShoes] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ShoppingShoes] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ShoppingShoes]
GO
/****** Object:  Table [dbo].[tbl_account]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_account](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](30) NOT NULL,
	[custID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_customer]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_customer](
	[custID] [varchar](10) NOT NULL,
	[lastName] [varchar](15) NOT NULL,
	[middleName] [varchar](30) NULL,
	[firstName] [varchar](15) NULL,
	[address] [varchar](250) NULL,
	[phone] [varchar](11) NOT NULL,
	[custLevel] [int] NOT NULL,
 CONSTRAINT [PK_tbl_customer] PRIMARY KEY CLUSTERED 
(
	[custID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_order]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_order](
	[orderID] [varchar](10) NOT NULL,
	[orderDate] [datetime] NOT NULL,
	[custID] [varchar](10) NOT NULL,
	[total] [float] NOT NULL,
 CONSTRAINT [PK_tbl_order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_orderDetail]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_orderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productID] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[unitPrice] [float] NOT NULL,
	[total] [float] NOT NULL,
	[orderID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_orderDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_shoes]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_shoes](
	[shoesID] [varchar](10) NOT NULL,
	[description] [varchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tbl_shoes] PRIMARY KEY CLUSTERED 
(
	[shoesID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_shoesSize]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_shoesSize](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[shoesID] [varchar](10) NOT NULL,
	[sizeID] [varchar](3) NOT NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_tbl_shoesSize] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_sizes]    Script Date: 11/3/2018 4:35:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_sizes](
	[id] [varchar](3) NOT NULL,
	[sizes] [int] NOT NULL,
	[country] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_sizes] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'khanhkt', N'12345678', N'10')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'phat', N'1', N'4')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'Phat123', N'vonhatthien', N'13')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'thien', N'1', N'3')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'thienthie', N'12345678', N'11')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'thuy', N'1', N'2')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'trang1', N'12345678', N'12')
INSERT [dbo].[tbl_account] ([username], [password], [custID]) VALUES (N'van anh', N'12345678', N'6')
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'1', N'a', N'a', N'a', N'a', N'09999999999', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'10', N'khanh', N'', N'', N'go vap', N'0123456789', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'11', N'thuy', N'', N'', N'quan12', N'0123456789', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'12', N'chuc', N'', N'', N'di linh', N'0123456789', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'13', N'ad', N'adfa', N'asdfas', N'asfas', N'0983974232', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'2', N'thuy', N'kim', N'vo', N'go vap', N'0278034064', 3)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'3', N'thien', N'nhat', N'vo', N'quan 12', N'0912121212', 1)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'4', N'phat', N'huu', N'do', N'quan 12', N'0913131313', 2)
INSERT [dbo].[tbl_customer] ([custID], [lastName], [middleName], [firstName], [address], [phone], [custLevel]) VALUES (N'6', N'', N'', N'', N'go vap', N'0123456789', 1)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'1', CAST(N'2018-10-30 22:35:35.510' AS DateTime), N'1', 30000)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'2', CAST(N'2018-10-30 22:36:43.553' AS DateTime), N'1', 30000)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'3', CAST(N'2018-11-03 00:00:00.000' AS DateTime), N'2', 1100)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'4', CAST(N'2018-11-03 00:00:00.000' AS DateTime), N'2', 1100)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'5', CAST(N'2018-11-03 00:00:00.000' AS DateTime), N'2', 1800)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'6', CAST(N'2018-11-03 00:00:00.000' AS DateTime), N'2', 910)
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [custID], [total]) VALUES (N'7', CAST(N'2018-11-03 00:00:00.000' AS DateTime), N'13', 2200)
SET IDENTITY_INSERT [dbo].[tbl_orderDetail] ON 

INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [total], [orderID]) VALUES (23, 18, 1, 700, 700, N'5')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [total], [orderID]) VALUES (24, 5, 1, 1100, 1100, N'5')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [total], [orderID]) VALUES (25, 11, 1, 910, 910, N'6')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [total], [orderID]) VALUES (26, 5, 2, 1100, 2200, N'7')
SET IDENTITY_INSERT [dbo].[tbl_orderDetail] OFF
INSERT [dbo].[tbl_shoes] ([shoesID], [description], [quantity]) VALUES (N'SH01', N'Nike', 95)
INSERT [dbo].[tbl_shoes] ([shoesID], [description], [quantity]) VALUES (N'SH02', N'Adidas', 199)
INSERT [dbo].[tbl_shoes] ([shoesID], [description], [quantity]) VALUES (N'SH03', N'Fendi', 9)
INSERT [dbo].[tbl_shoes] ([shoesID], [description], [quantity]) VALUES (N'SH04', N'Puma', 50)
INSERT [dbo].[tbl_shoes] ([shoesID], [description], [quantity]) VALUES (N'SH05', N'Smith', 100)
SET IDENTITY_INSERT [dbo].[tbl_shoesSize] ON 

INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (4, N'SH01', N'S1', 1000, 20)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (5, N'SH01', N'S2', 1100, 27)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (6, N'SH01', N'S3', 1150, 10)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (8, N'SH01', N'S4', 1200, 25)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (9, N'SH01', N'S5', 12100, 15)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (10, N'SH02', N'S1', 900, 35)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (11, N'SH02', N'S2', 910, 49)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (12, N'SH02', N'S3', 920, 60)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (15, N'SH02', N'S4', 930, 40)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (16, N'SH03', N'S1', 850, 1)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (17, N'SH04', N'S2', 900, 50)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (18, N'SH03', N'S5', 700, 0)
INSERT [dbo].[tbl_shoesSize] ([id], [shoesID], [sizeID], [price], [quantity]) VALUES (19, N'SH03', N'S2', 300, 0)
SET IDENTITY_INSERT [dbo].[tbl_shoesSize] OFF
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S1', 35, N'USA')
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S2', 36, N'USA')
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S3', 37, N'USA')
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S4', 38, N'USA')
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S5', 39, N'USA')
INSERT [dbo].[tbl_sizes] ([id], [sizes], [country]) VALUES (N'S6', 40, N'USA')
SET ANSI_PADDING ON

GO
/****** Object:  Index [UniqueTK]    Script Date: 11/3/2018 4:35:28 PM ******/
ALTER TABLE [dbo].[tbl_account] ADD  CONSTRAINT [UniqueTK] UNIQUE NONCLUSTERED 
(
	[custID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbl_account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_account_tbl_customer] FOREIGN KEY([custID])
REFERENCES [dbo].[tbl_customer] ([custID])
GO
ALTER TABLE [dbo].[tbl_account] CHECK CONSTRAINT [FK_tbl_account_tbl_customer]
GO
ALTER TABLE [dbo].[tbl_order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_tbl_customer] FOREIGN KEY([custID])
REFERENCES [dbo].[tbl_customer] ([custID])
GO
ALTER TABLE [dbo].[tbl_order] CHECK CONSTRAINT [FK_tbl_order_tbl_customer]
GO
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_order] FOREIGN KEY([orderID])
REFERENCES [dbo].[tbl_order] ([orderID])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_order]
GO
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_shoesSize] FOREIGN KEY([productID])
REFERENCES [dbo].[tbl_shoesSize] ([id])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_shoesSize]
GO
ALTER TABLE [dbo].[tbl_shoesSize]  WITH CHECK ADD  CONSTRAINT [FK_tbl_shoesSize_tbl_shoes] FOREIGN KEY([shoesID])
REFERENCES [dbo].[tbl_shoes] ([shoesID])
GO
ALTER TABLE [dbo].[tbl_shoesSize] CHECK CONSTRAINT [FK_tbl_shoesSize_tbl_shoes]
GO
ALTER TABLE [dbo].[tbl_shoesSize]  WITH CHECK ADD  CONSTRAINT [FK_tbl_shoesSize_tbl_sizes] FOREIGN KEY([sizeID])
REFERENCES [dbo].[tbl_sizes] ([id])
GO
ALTER TABLE [dbo].[tbl_shoesSize] CHECK CONSTRAINT [FK_tbl_shoesSize_tbl_sizes]
GO
USE [master]
GO
ALTER DATABASE [ShoppingShoes] SET  READ_WRITE 
GO
