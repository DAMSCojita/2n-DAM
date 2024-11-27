USE [RentalCar]
GO

/****** Object:  Table [dbo].[Usuarios]    Script Date: 27/11/2024 19:55:45 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Usuarios](
	[nombre] [nvarchar](255) NOT NULL,
	[contrasenya] [nvarchar](32) NULL,
	[fechaDeBloqueo] [datetime] NULL,
 CONSTRAINT [pk_nom] PRIMARY KEY CLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


