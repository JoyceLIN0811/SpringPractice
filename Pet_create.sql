USE [PETDB]
GO


/**會員表單1**/

CREATE TABLE [dbo].[PetMembers](
	[memberId][int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](64) NULL,
	[password] [varchar](32) NULL,
	[username] [nvarchar](20) NULL,
	[gender] [char](10) NULL,
	[age] [int] NULL,

	PRIMARY KEY CLUSTERED 
(
	[memberId] ASC
)ON [PRIMARY])
GO



/**討論區表單2-4**/

CREATE TABLE [dbo].[Topic](
	[topicId] [int] IDENTITY(1,1) NOT NULL,
	[categoryId] [int] NULL,
	[title] [nvarchar](32) NULL,
	[content] [nvarchar](1500) NULL,
	[username] [nvarchar](20) NULL,
	[postTime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[topicId] ASC
)ON [PRIMARY])
GO

Drop TABLE Menu;

CREATE TABLE [dbo].[Menu](
	[categoryId] [int] IDENTITY(1,1) NOT NULL,
	[category] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
) ON [PRIMARY])
GO

  insert into menu (category) values ('生活')
    insert into menu (category) values ('資訊')
	  insert into menu (category) values ('新聞')
	    insert into menu (category) values ('發問')
		  insert into menu (category) values ('認養')
		    insert into menu (category) values ('其他')

			GO


Drop TABLE Reply;

CREATE TABLE [dbo].[Reply](
	[replyId] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](20) NULL,
	[topicId] [int] NULL,
	[replyContent] [nvarchar](1500) NULL,
	[replyTime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[replyId] ASC
) ON [PRIMARY])
GO



Create view topiclistView
as
SELECT  p.memberId, t.username, t.topicId, t.categoryId, t.title, t.postTime, m.category,(CASE WHEN r.reply_num IS NULL THEN 0 ELSE r.reply_num END) replyNum 
FROM Topic t
LEFT JOIN Menu m
ON t.categoryId = m.categoryId
LEFT JOIN PetMembers p
ON t.username = p.username
LEFT JOIN (SELECT topicId,count(*) reply_num from reply group by topicId) r
ON t.topicId = r.topicId


Create view replylistView
as
SELECT   p.memberId, r.username, t.topicId, t.title, r.replyId, r.replyContent, r.replyTime
FROM Reply r
LEFT JOIN Topic t
ON t.topicId =  r.topicId
LEFT JOIN PetMembers p
ON r.username = p.username

Drop table Post


/**募資平台表單**/

CREATE TABLE Post (
  postno INT IDENTITY PRIMARY KEY,
  postname  nvarchar(30),
  name nvarchar(10),
  content nvarchar(max),
  expdate varchar(30),
  amount int
);

/**預約系統表單5-8**/

CREATE TABLE [dbo].[Service Item](
	[itemId] [int] IDENTITY(1,1) NOT NULL,
	[item] [nchar](10) NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CompanyList](
	[companyId] [int] IDENTITY(1,1) NOT NULL,
	[itemId] [int] NULL,
	[name] [nvarchar](30) NULL,
	[price] [money] NULL,
	[location] [nvarchar](50) NULL,
	[evaluationId] [int] NULL,
	[availableDateTime] [datetime] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Request](
	[requestId] [int] IDENTITY(1,1) NOT NULL,
	[itemId] [int] NULL,
	[username] [nvarchar](20) NULL,
	[number] [int] NULL,
	[type] [nvarchar](10) NULL,
	[breed] [nvarchar](10) NULL,
	[weight] [float] NULL,
	[otherInformation] [nvarchar](30) NULL,
	[datetime] [datetime] NULL,
	[location] [nvarchar](50) NULL,
	[companyId] [int] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Evaluation](
	[evaluationId] [int] IDENTITY(1,1) NOT NULL,
	[requestId] [int] NULL,
	[itemId] [int] NULL,
	[companyId] [int] NULL,
	[stars] [int] NULL,
	[content] [nvarchar](50) NULL,
	[username] [nvarchar](20) NULL,
) ON [PRIMARY]
GO


/**商城表單12-15**/

CREATE TABLE [dbo].[Pet](
	[petId] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[price] [money] NULL,
	[discount] [money] NULL,
	[coverImage] [image] NULL,
	[fileName] [varchar](255) NULL,
	[description] [nvarchar](255) NULL,
	[category_id] [varchar](40) NULL,
	[amount] [int] NULL,
	PRIMARY KEY CLUSTERED 
(
   [petId] ASC
) ON [PRIMARY])
GO


CREATE TABLE [dbo].[Category](
	[cateId] [int] IDENTITY(1,1) NOT NULL,
	[cateName] [varchar](100) NOT NULL,
	[cateDescription] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
   [cateId] ASC
) ON [PRIMARY])
GO

CREATE TABLE [dbo].[Orderdetail](
	[seqno] [int] IDENTITY(1,1) NOT NULL,
	[orderNo] [int] NULL,
	[productId] [int] NULL,
	[description] [varchar](72) NULL,
	[amount] [int] NULL,
	[unitPrice] [decimal](18, 1) NULL,
	[discount] [money] NULL,
	PRIMARY KEY CLUSTERED 
(
   [seqno] ASC
) ON [PRIMARY])
GO

CREATE TABLE [dbo].[Orders](
	[orderNo] [int] IDENTITY(1,1) NOT NULL,
	[memberId] [varchar](20) NULL,
	[totalAmount] [decimal](11, 1) NULL,
	[shippingAddress] [varchar](64) NULL,
	[orderDate] [datetime] NULL,
	[shippingDate] [datetime] NULL,
	[cancelTag] [char](1) NULL,
		PRIMARY KEY CLUSTERED 
(
   [orderNo] ASC
) ON [PRIMARY])
GO

