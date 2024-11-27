USE [RentalCar]
GO

/****** Object:  Table [dbo].[Cliente]    Script Date: 27/11/2024 19:54:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Cliente](
	[dni] [nvarchar](10) NOT NULL,
	[nombre] [nvarchar](20) NULL,
	[apellidos] [nvarchar](20) NULL,
	[dirección] [nvarchar](50) NULL,
	[población] [nvarchar](15) NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


