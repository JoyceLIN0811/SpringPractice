USE [PETDB]
GO


/**�|�����1**/

CREATE TABLE [dbo].[PetMembers](
	[memberId][int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](64) NULL,
	[password] [varchar](32) NULL,
	[username] [nvarchar](20) NULL,
	[gender] [char](10) NULL,
	[age] [int] NULL,
	[bday] [date] NULL,
	[address] [nvarchar](64) NULL,
	[phone] [varchar](15) NULL,
	[petType] [nvarchar](10) NULL,
	[memberImage] [image] NULL,
	[fileName] [nvarchar](20) NULL,
	[registerTime] [datetime] NULL,
	PRIMARY KEY CLUSTERED 
(
	[memberId] ASC
)ON [PRIMARY])
GO



/**�Q�װϪ��2-4**/

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

  insert into menu (category) values ('�ͬ�')
    insert into menu (category) values ('��T')
	  insert into menu (category) values ('�s�D')
	    insert into menu (category) values ('�o��')
		  insert into menu (category) values ('�{�i')
		    insert into menu (category) values ('��L')

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
SELECT   p.memberId, t.username, t.topicId, t.title, r.replyId, r.replyContent, r.replyTime
FROM Reply r
LEFT JOIN Topic t
ON t.topicId =  r.topicId
LEFT JOIN PetMembers p
ON t.username = p.username


/**�w���t�Ϊ��5-8**/

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

/**�Ҹꥭ�x���9-11**/
CREATE TABLE Post (
	[postId] [int] IDENTITY(1,1) NOT NULL,
  [img] [varbinary](MAX),
  [categoryId] [int],
  [title] [nvarchar](50),
  [username] [nvarchar](20),
  [content] [nvarchar](max),
  [today] [date],
  [expdate] [date],
  [amount] [int],
  [total] [int],
  [supplies] [nvarchar](30),
PRIMARY KEY CLUSTERED 
(
	[postId] ASC
) ON [PRIMARY])
GO

CREATE TABLE FoundCategory (
	[categoryId] [int] IDENTITY(1,1) NOT NULL,
  [categoryName] [nchar](10),
PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
) ON [PRIMARY])
GO
  insert into FoundCategory(categoryName) values ('���B')
    insert into FoundCategory (categoryName) values ('����')
	  insert into FoundCategory(categoryName) values ('�]�p')

CREATE TABLE Sponsor (
[sponsorId] [int] IDENTITY(1,1) NOT NULL,
[username] [nvarchar](20),
[phone][int],
[address][nvarchar](30),
[today][date],
[totalAmount] [int],
[supplies][nvarchar](30),
PRIMARY KEY CLUSTERED 
(
   [sponsorId] ASC
) ON [PRIMARY])
GO

/**�ӫ����12-15**/

CREATE TABLE [dbo].[Product](
	[productId] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[price] [money] NULL,
	[discount] [money] NULL,
	[coverImage] [image] NULL,
	[fileName] [nvarchar](255) NULL,
	[description] [nvarchar](255) NULL,
	[categoryId] [nvarchar](255) NULL,
	[amount] [int] NULL,
	[sales] [int] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK__Pet__DDF850795C1234E2] PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO



CREATE TABLE [dbo].[Category](
	[cateId] [int] IDENTITY(1,1) NOT NULL,
	[cateName] [varchar](100) NOT NULL,
	[cateDescription] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[cateId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Orders](
	[orderId] [int] IDENTITY(1,1) NOT NULL,
	[memberId] [int] NULL,
	[totalAmount] [int] NULL,
	[shippingAddress] [nvarchar](255) NULL,
	[orderDate] [nvarchar](255) NULL,
	[state] [nvarchar](255) NULL,
 CONSTRAINT [PK__Orders__0809CA8659ED0369] PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

