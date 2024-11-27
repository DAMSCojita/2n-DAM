USE [RentalCar]
GO

/****** Object:  Table [dbo].[Restriccion]    Script Date: 27/11/2024 19:55:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Restriccion](
	[nombre] [nvarchar](255) NULL,
	[tipoRestriccion] [nvarchar](255) NULL,
	[nombreOpcion] [nvarchar](255) NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Restriccion]  WITH CHECK ADD  CONSTRAINT [fk_nomUsuari] FOREIGN KEY([nombre])
REFERENCES [dbo].[Usuarios] ([nombre])
GO

ALTER TABLE [dbo].[Restriccion] CHECK CONSTRAINT [fk_nomUsuari]
GO


