USE [RentalCar]
GO

/****** Object:  Table [dbo].[Cargo]    Script Date: 27/11/2024 19:53:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Cargo](
	[idCargo] [int] NOT NULL,
	[idReserva] [int] NULL,
	[fechaCargo] [datetime] NULL,
	[importeCargo] [float] NULL,
 CONSTRAINT [PK_idCargo] PRIMARY KEY CLUSTERED 
(
	[idCargo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Cargo]  WITH CHECK ADD  CONSTRAINT [FK_Cargo_Reserva] FOREIGN KEY([idReserva])
REFERENCES [dbo].[Reserva] ([idReserva])
GO

ALTER TABLE [dbo].[Cargo] CHECK CONSTRAINT [FK_Cargo_Reserva]
GO


