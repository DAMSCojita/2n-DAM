namespace NorthWind
{
    partial class MenuPrincipal
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pnlOpciones = new System.Windows.Forms.Panel();
            this.pnlOpcionesDebajo = new System.Windows.Forms.Panel();
            this.btnReportClientesParametros = new System.Windows.Forms.Button();
            this.btnReportClientes = new System.Windows.Forms.Button();
            this.pnlPrincipal = new System.Windows.Forms.Panel();
            this.northwindDataSet1 = new NorthWind.NorthwindDataSet();
            this.pnlOpciones.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet1)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlOpciones
            // 
            this.pnlOpciones.BackColor = System.Drawing.Color.Snow;
            this.pnlOpciones.Controls.Add(this.pnlOpcionesDebajo);
            this.pnlOpciones.Controls.Add(this.btnReportClientesParametros);
            this.pnlOpciones.Controls.Add(this.btnReportClientes);
            this.pnlOpciones.Dock = System.Windows.Forms.DockStyle.Left;
            this.pnlOpciones.Location = new System.Drawing.Point(0, 0);
            this.pnlOpciones.Name = "pnlOpciones";
            this.pnlOpciones.Size = new System.Drawing.Size(174, 658);
            this.pnlOpciones.TabIndex = 0;
            // 
            // pnlOpcionesDebajo
            // 
            this.pnlOpcionesDebajo.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.pnlOpcionesDebajo.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.pnlOpcionesDebajo.Location = new System.Drawing.Point(0, 241);
            this.pnlOpcionesDebajo.Name = "pnlOpcionesDebajo";
            this.pnlOpcionesDebajo.Size = new System.Drawing.Size(174, 417);
            this.pnlOpcionesDebajo.TabIndex = 3;
            // 
            // btnReportClientesParametros
            // 
            this.btnReportClientesParametros.BackColor = System.Drawing.Color.Red;
            this.btnReportClientesParametros.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnReportClientesParametros.Location = new System.Drawing.Point(0, 135);
            this.btnReportClientesParametros.Name = "btnReportClientesParametros";
            this.btnReportClientesParametros.Size = new System.Drawing.Size(174, 59);
            this.btnReportClientesParametros.TabIndex = 1;
            this.btnReportClientesParametros.Text = "Report de Clientes por Pedidos";
            this.btnReportClientesParametros.UseVisualStyleBackColor = false;
            this.btnReportClientesParametros.Click += new System.EventHandler(this.btnReportClientesParametros_Click);
            // 
            // btnReportClientes
            // 
            this.btnReportClientes.BackColor = System.Drawing.Color.Red;
            this.btnReportClientes.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnReportClientes.Location = new System.Drawing.Point(0, 34);
            this.btnReportClientes.Name = "btnReportClientes";
            this.btnReportClientes.Size = new System.Drawing.Size(174, 60);
            this.btnReportClientes.TabIndex = 0;
            this.btnReportClientes.Text = "Report de Clientes";
            this.btnReportClientes.UseVisualStyleBackColor = false;
            this.btnReportClientes.Click += new System.EventHandler(this.btnReportClientes_Click);
            // 
            // pnlPrincipal
            // 
            this.pnlPrincipal.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlPrincipal.Location = new System.Drawing.Point(174, 0);
            this.pnlPrincipal.Name = "pnlPrincipal";
            this.pnlPrincipal.Size = new System.Drawing.Size(948, 658);
            this.pnlPrincipal.TabIndex = 1;
            // 
            // northwindDataSet1
            // 
            this.northwindDataSet1.DataSetName = "NorthwindDataSet";
            this.northwindDataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // MenuPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1122, 658);
            this.Controls.Add(this.pnlPrincipal);
            this.Controls.Add(this.pnlOpciones);
            this.Name = "MenuPrincipal";
            this.Text = "Menú Principal";
            this.pnlOpciones.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlOpciones;
        private System.Windows.Forms.Panel pnlPrincipal;
        private System.Windows.Forms.Button btnReportClientes;
        private System.Windows.Forms.Button btnReportClientesParametros;
        private System.Windows.Forms.Panel pnlOpcionesDebajo;
        private NorthwindDataSet northwindDataSet1;
    }
}