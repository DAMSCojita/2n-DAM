USE [RentalCar]
GO

/****** Object:  Table [dbo].[Reserva]    Script Date: 27/11/2024 19:55:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Reserva](
	[idReserva] [int] NOT NULL,
	[dni] [nvarchar](10) NULL,
	[fechaInicio] [date] NULL,
	[fechaFin] [date] NULL,
	[tipologia] [nvarchar](10) NULL,
 CONSTRAINT [PK_Reserva] PRIMARY KEY CLUSTERED 
(
	[idReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Reserva]  WITH CHECK ADD  CONSTRAINT [FK_Reserva_Cliente] FOREIGN KEY([dni])
REFERENCES [dbo].[Cliente] ([dni])
GO

ALTER TABLE [dbo].[Reserva] CHECK CONSTRAINT [FK_Reserva_Cliente]
GO


