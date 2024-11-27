USE [RentalCar]
GO

/****** Object:  Table [dbo].[Vehiculo]    Script Date: 27/11/2024 19:55:58 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Vehiculo](
	[matricula] [nvarchar](10) NOT NULL,
	[tipologia] [nvarchar](7) NULL,
	[marca] [nvarchar](15) NULL,
	[modelo] [nvarchar](15) NULL,
	[color] [nvarchar](15) NULL,
 CONSTRAINT [PK_Vehiculo] PRIMARY KEY CLUSTERED 
(
	[matricula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


