namespace RentalCarDefinitiu
{
    partial class FormReservas
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormReservas));
            this.rentalCarDataSet = new RentalCarDefinitiu.RentalCarDataSet();
            this.reservaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.txtIdReserva = new System.Windows.Forms.TextBox();
            this.lblIdReserva = new System.Windows.Forms.Label();
            this.txtDni = new System.Windows.Forms.TextBox();
            this.lblDni = new System.Windows.Forms.Label();
            this.txtFechaFin = new System.Windows.Forms.TextBox();
            this.lblFechaFin = new System.Windows.Forms.Label();
            this.txtFechaInicio = new System.Windows.Forms.TextBox();
            this.lblFechaInicio = new System.Windows.Forms.Label();
            this.txtTipologia = new System.Windows.Forms.TextBox();
            this.lblTipologia = new System.Windows.Forms.Label();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnAgregar = new System.Windows.Forms.Button();
            this.pnlControles = new System.Windows.Forms.Panel();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlVerificar = new System.Windows.Forms.Panel();
            this.picConfirmar = new System.Windows.Forms.PictureBox();
            this.picDenegar = new System.Windows.Forms.PictureBox();
            this.reservaTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.ReservaTableAdapter();
            this.tableAdapterManager = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager();
            this.reservaDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservaBindingSource)).BeginInit();
            this.pnlControles.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlVerificar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservaDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // rentalCarDataSet
            // 
            this.rentalCarDataSet.DataSetName = "RentalCarDataSet";
            this.rentalCarDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // reservaBindingSource
            // 
            this.reservaBindingSource.DataMember = "Reserva";
            this.reservaBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // txtIdReserva
            // 
            this.txtIdReserva.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservaBindingSource, "IdReserva", true));
            this.txtIdReserva.Location = new System.Drawing.Point(105, 65);
            this.txtIdReserva.Name = "txtIdReserva";
            this.txtIdReserva.Size = new System.Drawing.Size(135, 22);
            this.txtIdReserva.TabIndex = 33;
            // 
            // lblIdReserva
            // 
            this.lblIdReserva.AutoSize = true;
            this.lblIdReserva.Location = new System.Drawing.Point(26, 68);
            this.lblIdReserva.Name = "lblIdReserva";
            this.lblIdReserva.Size = new System.Drawing.Size(75, 16);
            this.lblIdReserva.TabIndex = 32;
            this.lblIdReserva.Text = "ID Reserva";
            // 
            // txtDni
            // 
            this.txtDni.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservaBindingSource, "Dni", true));
            this.txtDni.Location = new System.Drawing.Point(105, 107);
            this.txtDni.Name = "txtDni";
            this.txtDni.Size = new System.Drawing.Size(135, 22);
            this.txtDni.TabIndex = 35;
            // 
            // lblDni
            // 
            this.lblDni.AutoSize = true;
            this.lblDni.Location = new System.Drawing.Point(71, 113);
            this.lblDni.Name = "lblDni";
            this.lblDni.Size = new System.Drawing.Size(30, 16);
            this.lblDni.TabIndex = 34;
            this.lblDni.Text = "DNI";
            // 
            // txtFechaFin
            // 
            this.txtFechaFin.Location = new System.Drawing.Point(105, 198);
            this.txtFechaFin.Name = "txtFechaFin";
            this.txtFechaFin.Size = new System.Drawing.Size(135, 22);
            this.txtFechaFin.TabIndex = 39;
            // 
            // lblFechaFin
            // 
            this.lblFechaFin.AutoSize = true;
            this.lblFechaFin.Location = new System.Drawing.Point(35, 204);
            this.lblFechaFin.Name = "lblFechaFin";
            this.lblFechaFin.Size = new System.Drawing.Size(66, 16);
            this.lblFechaFin.TabIndex = 38;
            this.lblFechaFin.Text = "Fecha Fin";
            // 
            // txtFechaInicio
            // 
            this.txtFechaInicio.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservaBindingSource, "FechaInicio", true));
            this.txtFechaInicio.Location = new System.Drawing.Point(105, 156);
            this.txtFechaInicio.Name = "txtFechaInicio";
            this.txtFechaInicio.Size = new System.Drawing.Size(135, 22);
            this.txtFechaInicio.TabIndex = 37;
            // 
            // lblFechaInicio
            // 
            this.lblFechaInicio.AutoSize = true;
            this.lblFechaInicio.Location = new System.Drawing.Point(20, 159);
            this.lblFechaInicio.Name = "lblFechaInicio";
            this.lblFechaInicio.Size = new System.Drawing.Size(79, 16);
            this.lblFechaInicio.TabIndex = 36;
            this.lblFechaInicio.Text = "Fecha Inicio";
            // 
            // txtTipologia
            // 
            this.txtTipologia.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservaBindingSource, "Tipologia", true));
            this.txtTipologia.Location = new System.Drawing.Point(105, 247);
            this.txtTipologia.Name = "txtTipologia";
            this.txtTipologia.Size = new System.Drawing.Size(135, 22);
            this.txtTipologia.TabIndex = 41;
            // 
            // lblTipologia
            // 
            this.lblTipologia.AutoSize = true;
            this.lblTipologia.Location = new System.Drawing.Point(38, 250);
            this.lblTipologia.Name = "lblTipologia";
            this.lblTipologia.Size = new System.Drawing.Size(65, 16);
            this.lblTipologia.TabIndex = 40;
            this.lblTipologia.Text = "Tipologia";
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(225, 5);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(41, 28);
            this.btnEliminar.TabIndex = 43;
            this.btnEliminar.Text = "-";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click_1);
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(178, 5);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(41, 28);
            this.btnAgregar.TabIndex = 42;
            this.btnAgregar.Text = "+";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click_1);
            // 
            // pnlControles
            // 
            this.pnlControles.Controls.Add(this.pictureBox4);
            this.pnlControles.Controls.Add(this.pictureBox3);
            this.pnlControles.Controls.Add(this.btnEliminar);
            this.pnlControles.Controls.Add(this.pictureBox2);
            this.pnlControles.Controls.Add(this.btnAgregar);
            this.pnlControles.Controls.Add(this.pictureBox1);
            this.pnlControles.Location = new System.Drawing.Point(3, 0);
            this.pnlControles.Name = "pnlControles";
            this.pnlControles.Size = new System.Drawing.Size(879, 36);
            this.pnlControles.TabIndex = 44;
            // 
            // pictureBox4
            // 
            this.pictureBox4.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox4.Image")));
            this.pictureBox4.Location = new System.Drawing.Point(134, 3);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(38, 30);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox4.TabIndex = 16;
            this.pictureBox4.TabStop = false;
            // 
            // pictureBox3
            // 
            this.pictureBox3.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox3.Image")));
            this.pictureBox3.Location = new System.Drawing.Point(90, 3);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(38, 30);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox3.TabIndex = 17;
            this.pictureBox3.TabStop = false;
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(46, 3);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(38, 30);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox2.TabIndex = 16;
            this.pictureBox2.TabStop = false;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(12, 3);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(25, 30);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // pnlVerificar
            // 
            this.pnlVerificar.Controls.Add(this.picConfirmar);
            this.pnlVerificar.Controls.Add(this.picDenegar);
            this.pnlVerificar.Location = new System.Drawing.Point(3, 412);
            this.pnlVerificar.Name = "pnlVerificar";
            this.pnlVerificar.Size = new System.Drawing.Size(900, 39);
            this.pnlVerificar.TabIndex = 45;
            // 
            // picConfirmar
            // 
            this.picConfirmar.Image = ((System.Drawing.Image)(resources.GetObject("picConfirmar.Image")));
            this.picConfirmar.Location = new System.Drawing.Point(12, 6);
            this.picConfirmar.Name = "picConfirmar";
            this.picConfirmar.Size = new System.Drawing.Size(38, 30);
            this.picConfirmar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picConfirmar.TabIndex = 16;
            this.picConfirmar.TabStop = false;
            this.picConfirmar.Click += new System.EventHandler(this.picConfirmar_Click_1);
            // 
            // picDenegar
            // 
            this.picDenegar.Image = ((System.Drawing.Image)(resources.GetObject("picDenegar.Image")));
            this.picDenegar.Location = new System.Drawing.Point(824, 6);
            this.picDenegar.Name = "picDenegar";
            this.picDenegar.Size = new System.Drawing.Size(38, 30);
            this.picDenegar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picDenegar.TabIndex = 18;
            this.picDenegar.TabStop = false;
            this.picDenegar.Click += new System.EventHandler(this.picDenegar_Click_1);
            // 
            // reservaTableAdapter
            // 
            this.reservaTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CargoTableAdapter = null;
            this.tableAdapterManager.ClienteTableAdapter = null;
            this.tableAdapterManager.ContratoTableAdapter = null;
            this.tableAdapterManager.ReservaTableAdapter = this.reservaTableAdapter;
            this.tableAdapterManager.UpdateOrder = RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.VehiculoTableAdapter = null;
            // 
            // reservaDataGridView
            // 
            this.reservaDataGridView.AutoGenerateColumns = false;
            this.reservaDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.reservaDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10});
            this.reservaDataGridView.DataSource = this.reservaBindingSource;
            this.reservaDataGridView.Location = new System.Drawing.Point(3, 288);
            this.reservaDataGridView.Name = "reservaDataGridView";
            this.reservaDataGridView.RowHeadersWidth = 51;
            this.reservaDataGridView.RowTemplate.Height = 24;
            this.reservaDataGridView.Size = new System.Drawing.Size(900, 124);
            this.reservaDataGridView.TabIndex = 45;
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "idReserva";
            this.dataGridViewTextBoxColumn6.HeaderText = "idReserva";
            this.dataGridViewTextBoxColumn6.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            this.dataGridViewTextBoxColumn6.Width = 125;
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "dni";
            this.dataGridViewTextBoxColumn7.HeaderText = "dni";
            this.dataGridViewTextBoxColumn7.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            this.dataGridViewTextBoxColumn7.Width = 125;
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.DataPropertyName = "fechaInicio";
            this.dataGridViewTextBoxColumn8.HeaderText = "fechaInicio";
            this.dataGridViewTextBoxColumn8.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            this.dataGridViewTextBoxColumn8.Width = 125;
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.DataPropertyName = "fechaFin";
            this.dataGridViewTextBoxColumn9.HeaderText = "fechaFin";
            this.dataGridViewTextBoxColumn9.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            this.dataGridViewTextBoxColumn9.Width = 125;
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.DataPropertyName = "tipologia";
            this.dataGridViewTextBoxColumn10.HeaderText = "tipologia";
            this.dataGridViewTextBoxColumn10.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            this.dataGridViewTextBoxColumn10.Width = 125;
            // 
            // FormReservas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(902, 453);
            this.Controls.Add(this.reservaDataGridView);
            this.Controls.Add(this.pnlVerificar);
            this.Controls.Add(this.pnlControles);
            this.Controls.Add(this.txtTipologia);
            this.Controls.Add(this.lblTipologia);
            this.Controls.Add(this.txtFechaFin);
            this.Controls.Add(this.lblFechaFin);
            this.Controls.Add(this.txtFechaInicio);
            this.Controls.Add(this.lblFechaInicio);
            this.Controls.Add(this.txtDni);
            this.Controls.Add(this.lblDni);
            this.Controls.Add(this.txtIdReserva);
            this.Controls.Add(this.lblIdReserva);
            this.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservaBindingSource, "FechaFin", true));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormReservas";
            this.Text = "Formulario Reservas";
            this.Load += new System.EventHandler(this.FormReservas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservaBindingSource)).EndInit();
            this.pnlControles.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlVerificar.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservaDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private RentalCarDataSet rentalCarDataSet;
        private System.Windows.Forms.BindingSource reservaBindingSource;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.TextBox txtIdReserva;
        private System.Windows.Forms.Label lblIdReserva;
        private System.Windows.Forms.TextBox txtDni;
        private System.Windows.Forms.Label lblDni;
        private System.Windows.Forms.TextBox txtFechaFin;
        private System.Windows.Forms.Label lblFechaFin;
        private System.Windows.Forms.TextBox txtFechaInicio;
        private System.Windows.Forms.Label lblFechaInicio;
        private System.Windows.Forms.TextBox txtTipologia;
        private System.Windows.Forms.Label lblTipologia;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnAgregar;
        private System.Windows.Forms.Panel pnlControles;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel pnlVerificar;
        private System.Windows.Forms.PictureBox picConfirmar;
        private System.Windows.Forms.PictureBox picDenegar;
        private RentalCarDataSetTableAdapters.ReservaTableAdapter reservaTableAdapter;
        private RentalCarDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView reservaDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
    }
}