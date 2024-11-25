namespace RentalCarDefinitiu
{
    partial class FormCargos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormCargos));
            this.rentalCarDataSet = new RentalCarDefinitiu.RentalCarDataSet();
            this.cargoBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.cargoTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.CargoTableAdapter();
            this.tableAdapterManager = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager();
            this.cargoDataGridView = new System.Windows.Forms.DataGridView();
            this.idCargoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idReservaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaCargoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.importeCargoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnAgregar = new System.Windows.Forms.Button();
            this.txtImporte = new System.Windows.Forms.TextBox();
            this.txtIdReserva = new System.Windows.Forms.TextBox();
            this.txtIdCargo = new System.Windows.Forms.TextBox();
            this.lblImporte = new System.Windows.Forms.Label();
            this.lblfechaCargo = new System.Windows.Forms.Label();
            this.lblIdReserva = new System.Windows.Forms.Label();
            this.lblIdCargo = new System.Windows.Forms.Label();
            this.dateFechaCargo = new System.Windows.Forms.DateTimePicker();
            this.pnlControles = new System.Windows.Forms.Panel();
            this.picEditar = new System.Windows.Forms.PictureBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlVerificar = new System.Windows.Forms.Panel();
            this.picConfirmar = new System.Windows.Forms.PictureBox();
            this.picDenegar = new System.Windows.Forms.PictureBox();
            this.pnlContenedor = new System.Windows.Forms.Panel();
            this.btnEliminar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cargoBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.cargoDataGridView)).BeginInit();
            this.pnlControles.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picEditar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlVerificar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).BeginInit();
            this.pnlContenedor.SuspendLayout();
            this.SuspendLayout();
            // 
            // rentalCarDataSet
            // 
            this.rentalCarDataSet.DataSetName = "RentalCarDataSet";
            this.rentalCarDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // cargoBindingSource
            // 
            this.cargoBindingSource.DataMember = "Cargo";
            this.cargoBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // cargoTableAdapter
            // 
            this.cargoTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CargoTableAdapter = this.cargoTableAdapter;
            this.tableAdapterManager.ClienteTableAdapter = null;
            this.tableAdapterManager.ContratoTableAdapter = null;
            this.tableAdapterManager.ReservaTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.VehiculoTableAdapter = null;
            // 
            // cargoDataGridView
            // 
            this.cargoDataGridView.AutoGenerateColumns = false;
            this.cargoDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.cargoDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idCargoDataGridViewTextBoxColumn,
            this.idReservaDataGridViewTextBoxColumn,
            this.fechaCargoDataGridViewTextBoxColumn,
            this.importeCargoDataGridViewTextBoxColumn});
            this.cargoDataGridView.DataSource = this.cargoBindingSource;
            this.cargoDataGridView.Location = new System.Drawing.Point(0, 302);
            this.cargoDataGridView.Name = "cargoDataGridView";
            this.cargoDataGridView.RowHeadersWidth = 51;
            this.cargoDataGridView.RowTemplate.Height = 24;
            this.cargoDataGridView.Size = new System.Drawing.Size(874, 151);
            this.cargoDataGridView.TabIndex = 1;
            // 
            // idCargoDataGridViewTextBoxColumn
            // 
            this.idCargoDataGridViewTextBoxColumn.DataPropertyName = "idCargo";
            this.idCargoDataGridViewTextBoxColumn.HeaderText = "idCargo";
            this.idCargoDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.idCargoDataGridViewTextBoxColumn.Name = "idCargoDataGridViewTextBoxColumn";
            this.idCargoDataGridViewTextBoxColumn.Width = 125;
            // 
            // idReservaDataGridViewTextBoxColumn
            // 
            this.idReservaDataGridViewTextBoxColumn.DataPropertyName = "idReserva";
            this.idReservaDataGridViewTextBoxColumn.HeaderText = "idReserva";
            this.idReservaDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.idReservaDataGridViewTextBoxColumn.Name = "idReservaDataGridViewTextBoxColumn";
            this.idReservaDataGridViewTextBoxColumn.Width = 125;
            // 
            // fechaCargoDataGridViewTextBoxColumn
            // 
            this.fechaCargoDataGridViewTextBoxColumn.DataPropertyName = "fechaCargo";
            this.fechaCargoDataGridViewTextBoxColumn.HeaderText = "fechaCargo";
            this.fechaCargoDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.fechaCargoDataGridViewTextBoxColumn.Name = "fechaCargoDataGridViewTextBoxColumn";
            this.fechaCargoDataGridViewTextBoxColumn.Width = 125;
            // 
            // importeCargoDataGridViewTextBoxColumn
            // 
            this.importeCargoDataGridViewTextBoxColumn.DataPropertyName = "importeCargo";
            this.importeCargoDataGridViewTextBoxColumn.HeaderText = "importeCargo";
            this.importeCargoDataGridViewTextBoxColumn.MinimumWidth = 6;
            this.importeCargoDataGridViewTextBoxColumn.Name = "importeCargoDataGridViewTextBoxColumn";
            this.importeCargoDataGridViewTextBoxColumn.Width = 125;
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(178, 3);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(43, 30);
            this.btnAgregar.TabIndex = 24;
            this.btnAgregar.Text = "+";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click);
            // 
            // txtImporte
            // 
            this.txtImporte.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.cargoBindingSource, "importeCargo", true));
            this.txtImporte.Location = new System.Drawing.Point(91, 176);
            this.txtImporte.Name = "txtImporte";
            this.txtImporte.Size = new System.Drawing.Size(135, 22);
            this.txtImporte.TabIndex = 22;
            // 
            // txtIdReserva
            // 
            this.txtIdReserva.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.cargoBindingSource, "IdReserva", true));
            this.txtIdReserva.Location = new System.Drawing.Point(91, 83);
            this.txtIdReserva.Name = "txtIdReserva";
            this.txtIdReserva.Size = new System.Drawing.Size(135, 22);
            this.txtIdReserva.TabIndex = 20;
            // 
            // txtIdCargo
            // 
            this.txtIdCargo.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.cargoBindingSource, "idCargo", true));
            this.txtIdCargo.Location = new System.Drawing.Point(91, 43);
            this.txtIdCargo.Name = "txtIdCargo";
            this.txtIdCargo.Size = new System.Drawing.Size(135, 22);
            this.txtIdCargo.TabIndex = 19;
            // 
            // lblImporte
            // 
            this.lblImporte.AutoSize = true;
            this.lblImporte.Location = new System.Drawing.Point(33, 182);
            this.lblImporte.Name = "lblImporte";
            this.lblImporte.Size = new System.Drawing.Size(52, 16);
            this.lblImporte.TabIndex = 17;
            this.lblImporte.Text = "Importe";
            // 
            // lblfechaCargo
            // 
            this.lblfechaCargo.AutoSize = true;
            this.lblfechaCargo.Location = new System.Drawing.Point(2, 131);
            this.lblfechaCargo.Name = "lblfechaCargo";
            this.lblfechaCargo.Size = new System.Drawing.Size(85, 16);
            this.lblfechaCargo.TabIndex = 16;
            this.lblfechaCargo.Text = "Fecha Cargo";
            // 
            // lblIdReserva
            // 
            this.lblIdReserva.AutoSize = true;
            this.lblIdReserva.Location = new System.Drawing.Point(12, 86);
            this.lblIdReserva.Name = "lblIdReserva";
            this.lblIdReserva.Size = new System.Drawing.Size(75, 16);
            this.lblIdReserva.TabIndex = 15;
            this.lblIdReserva.Text = "ID Reserva";
            // 
            // lblIdCargo
            // 
            this.lblIdCargo.AutoSize = true;
            this.lblIdCargo.Location = new System.Drawing.Point(25, 46);
            this.lblIdCargo.Name = "lblIdCargo";
            this.lblIdCargo.Size = new System.Drawing.Size(60, 16);
            this.lblIdCargo.TabIndex = 14;
            this.lblIdCargo.Text = "ID Cargo";
            // 
            // dateFechaCargo
            // 
            this.dateFechaCargo.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.cargoBindingSource, "fechaCargo", true));
            this.dateFechaCargo.Location = new System.Drawing.Point(91, 131);
            this.dateFechaCargo.Name = "dateFechaCargo";
            this.dateFechaCargo.Size = new System.Drawing.Size(194, 22);
            this.dateFechaCargo.TabIndex = 26;
            // 
            // pnlControles
            // 
            this.pnlControles.Controls.Add(this.btnEliminar);
            this.pnlControles.Controls.Add(this.picEditar);
            this.pnlControles.Controls.Add(this.pictureBox4);
            this.pnlControles.Controls.Add(this.pictureBox3);
            this.pnlControles.Controls.Add(this.pictureBox2);
            this.pnlControles.Controls.Add(this.pictureBox1);
            this.pnlControles.Controls.Add(this.btnAgregar);
            this.pnlControles.Location = new System.Drawing.Point(0, -1);
            this.pnlControles.Name = "pnlControles";
            this.pnlControles.Size = new System.Drawing.Size(874, 42);
            this.pnlControles.TabIndex = 46;
            // 
            // picEditar
            // 
            this.picEditar.Image = ((System.Drawing.Image)(resources.GetObject("picEditar.Image")));
            this.picEditar.Location = new System.Drawing.Point(282, 3);
            this.picEditar.Name = "picEditar";
            this.picEditar.Size = new System.Drawing.Size(37, 31);
            this.picEditar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picEditar.TabIndex = 48;
            this.picEditar.TabStop = false;
            this.picEditar.Click += new System.EventHandler(this.picEditar_Click);
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
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
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
            this.pictureBox3.Click += new System.EventHandler(this.pictureBox3_Click);
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
            this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
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
            this.pnlVerificar.Location = new System.Drawing.Point(0, 453);
            this.pnlVerificar.Name = "pnlVerificar";
            this.pnlVerificar.Size = new System.Drawing.Size(874, 39);
            this.pnlVerificar.TabIndex = 47;
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
            // pnlContenedor
            // 
            this.pnlContenedor.Controls.Add(this.dateFechaCargo);
            this.pnlContenedor.Controls.Add(this.txtImporte);
            this.pnlContenedor.Controls.Add(this.txtIdReserva);
            this.pnlContenedor.Controls.Add(this.txtIdCargo);
            this.pnlContenedor.Controls.Add(this.lblImporte);
            this.pnlContenedor.Controls.Add(this.lblfechaCargo);
            this.pnlContenedor.Controls.Add(this.lblIdReserva);
            this.pnlContenedor.Controls.Add(this.lblIdCargo);
            this.pnlContenedor.Location = new System.Drawing.Point(0, 39);
            this.pnlContenedor.Name = "pnlContenedor";
            this.pnlContenedor.Size = new System.Drawing.Size(873, 414);
            this.pnlContenedor.TabIndex = 48;
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(227, 4);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(49, 30);
            this.btnEliminar.TabIndex = 49;
            this.btnEliminar.Text = "-";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // FormCargos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(874, 488);
            this.Controls.Add(this.pnlVerificar);
            this.Controls.Add(this.pnlControles);
            this.Controls.Add(this.cargoDataGridView);
            this.Controls.Add(this.pnlContenedor);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormCargos";
            this.Text = "Formulario Cargos";
            this.Load += new System.EventHandler(this.FormCargos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cargoBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.cargoDataGridView)).EndInit();
            this.pnlControles.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picEditar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlVerificar.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).EndInit();
            this.pnlContenedor.ResumeLayout(false);
            this.pnlContenedor.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private RentalCarDataSet rentalCarDataSet;
        private System.Windows.Forms.BindingSource cargoBindingSource;
        private RentalCarDataSetTableAdapters.CargoTableAdapter cargoTableAdapter;
        private RentalCarDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView cargoDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.Button btnAgregar;
        private System.Windows.Forms.TextBox txtImporte;
        private System.Windows.Forms.TextBox txtIdReserva;
        private System.Windows.Forms.TextBox txtIdCargo;
        private System.Windows.Forms.Label lblImporte;
        private System.Windows.Forms.Label lblfechaCargo;
        private System.Windows.Forms.Label lblIdReserva;
        private System.Windows.Forms.Label lblIdCargo;
        private System.Windows.Forms.DateTimePicker dateFechaCargo;
        private System.Windows.Forms.Panel pnlControles;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel pnlVerificar;
        private System.Windows.Forms.PictureBox picConfirmar;
        private System.Windows.Forms.PictureBox picDenegar;
        private System.Windows.Forms.DataGridViewTextBoxColumn idCargoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn idReservaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaCargoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn importeCargoDataGridViewTextBoxColumn;
        private System.Windows.Forms.PictureBox picEditar;
        private System.Windows.Forms.Panel pnlContenedor;
        private System.Windows.Forms.Button btnEliminar;
    }
}