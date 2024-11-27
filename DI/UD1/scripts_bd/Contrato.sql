USE [RentalCar]
GO

/****** Object:  Table [dbo].[Contrato]    Script Date: 27/11/2024 19:54:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Contrato](
	[idReserva] [int] NOT NULL,
	[fechaContrato] [datetime] NULL,
	[matricula] [nvarchar](10) NULL,
 CONSTRAINT [PK_Contrato] PRIMARY KEY CLUSTERED 
(
	[idReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [FK_Contrato_Reserva] FOREIGN KEY([idReserva])
REFERENCES [dbo].[Reserva] ([idReserva])
GO

ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [FK_Contrato_Reserva]
GO

ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [FK_Contrato_Vehiculo] FOREIGN KEY([matricula])
REFERENCES [dbo].[Vehiculo] ([matricula])
GO

ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [FK_Contrato_Vehiculo]
GO


