namespace RentalCarDefinitiu
{
    partial class FormContratos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormContratos));
            this.rentalCarDataSet = new RentalCarDefinitiu.RentalCarDataSet();
            this.contratoBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnAgregar = new System.Windows.Forms.Button();
            this.txtIdReserva = new System.Windows.Forms.TextBox();
            this.lblMatricula = new System.Windows.Forms.Label();
            this.lblIdReserva = new System.Windows.Forms.Label();
            this.lblFechaContrato = new System.Windows.Forms.Label();
            this.dateFechaContrato = new System.Windows.Forms.DateTimePicker();
            this.txtMatricula = new System.Windows.Forms.TextBox();
            this.pnlControles = new System.Windows.Forms.Panel();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlVerificar = new System.Windows.Forms.Panel();
            this.picConfirmar = new System.Windows.Forms.PictureBox();
            this.picDenegar = new System.Windows.Forms.PictureBox();
            this.contratoTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.ContratoTableAdapter();
            this.tableAdapterManager = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager();
            this.contratoDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.contratoBindingSource)).BeginInit();
            this.pnlControles.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlVerificar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.contratoDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // rentalCarDataSet
            // 
            this.rentalCarDataSet.DataSetName = "RentalCarDataSet";
            this.rentalCarDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // contratoBindingSource
            // 
            this.contratoBindingSource.DataMember = "Contrato";
            this.contratoBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(231, 5);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(46, 27);
            this.btnEliminar.TabIndex = 35;
            this.btnEliminar.Text = "-";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click_1);
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(178, 3);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(47, 29);
            this.btnAgregar.TabIndex = 34;
            this.btnAgregar.Text = "+";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click);
            // 
            // txtIdReserva
            // 
            this.txtIdReserva.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.contratoBindingSource, "IdReserva", true));
            this.txtIdReserva.Location = new System.Drawing.Point(120, 82);
            this.txtIdReserva.Name = "txtIdReserva";
            this.txtIdReserva.Size = new System.Drawing.Size(135, 22);
            this.txtIdReserva.TabIndex = 31;
            // 
            // lblMatricula
            // 
            this.lblMatricula.AutoSize = true;
            this.lblMatricula.Location = new System.Drawing.Point(53, 170);
            this.lblMatricula.Name = "lblMatricula";
            this.lblMatricula.Size = new System.Drawing.Size(61, 16);
            this.lblMatricula.TabIndex = 28;
            this.lblMatricula.Text = "Matricula";
            // 
            // lblIdReserva
            // 
            this.lblIdReserva.AutoSize = true;
            this.lblIdReserva.Location = new System.Drawing.Point(41, 85);
            this.lblIdReserva.Name = "lblIdReserva";
            this.lblIdReserva.Size = new System.Drawing.Size(75, 16);
            this.lblIdReserva.TabIndex = 27;
            this.lblIdReserva.Text = "ID Reserva";
            // 
            // lblFechaContrato
            // 
            this.lblFechaContrato.AutoSize = true;
            this.lblFechaContrato.Location = new System.Drawing.Point(18, 127);
            this.lblFechaContrato.Name = "lblFechaContrato";
            this.lblFechaContrato.Size = new System.Drawing.Size(98, 16);
            this.lblFechaContrato.TabIndex = 26;
            this.lblFechaContrato.Text = "Fecha Contrato";
            // 
            // dateFechaContrato
            // 
            this.dateFechaContrato.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.contratoBindingSource, "FechaContrato", true));
            this.dateFechaContrato.Location = new System.Drawing.Point(120, 122);
            this.dateFechaContrato.Name = "dateFechaContrato";
            this.dateFechaContrato.Size = new System.Drawing.Size(194, 22);
            this.dateFechaContrato.TabIndex = 36;
            // 
            // txtMatricula
            // 
            this.txtMatricula.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.contratoBindingSource, "Matricula", true));
            this.txtMatricula.Location = new System.Drawing.Point(120, 167);
            this.txtMatricula.Name = "txtMatricula";
            this.txtMatricula.Size = new System.Drawing.Size(135, 22);
            this.txtMatricula.TabIndex = 32;
            // 
            // pnlControles
            // 
            this.pnlControles.Controls.Add(this.pictureBox4);
            this.pnlControles.Controls.Add(this.pictureBox3);
            this.pnlControles.Controls.Add(this.pictureBox2);
            this.pnlControles.Controls.Add(this.pictureBox1);
            this.pnlControles.Controls.Add(this.btnEliminar);
            this.pnlControles.Controls.Add(this.btnAgregar);
            this.pnlControles.Location = new System.Drawing.Point(0, 0);
            this.pnlControles.Name = "pnlControles";
            this.pnlControles.Size = new System.Drawing.Size(879, 36);
            this.pnlControles.TabIndex = 45;
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
            this.pnlVerificar.Location = new System.Drawing.Point(0, 415);
            this.pnlVerificar.Name = "pnlVerificar";
            this.pnlVerificar.Size = new System.Drawing.Size(879, 39);
            this.pnlVerificar.TabIndex = 46;
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
            // 
            // contratoTableAdapter
            // 
            this.contratoTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CargoTableAdapter = null;
            this.tableAdapterManager.ClienteTableAdapter = null;
            this.tableAdapterManager.ContratoTableAdapter = this.contratoTableAdapter;
            this.tableAdapterManager.ReservaTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.VehiculoTableAdapter = null;
            // 
            // contratoDataGridView
            // 
            this.contratoDataGridView.AutoGenerateColumns = false;
            this.contratoDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.contratoDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6});
            this.contratoDataGridView.DataSource = this.contratoBindingSource;
            this.contratoDataGridView.Location = new System.Drawing.Point(0, 234);
            this.contratoDataGridView.Name = "contratoDataGridView";
            this.contratoDataGridView.RowHeadersWidth = 51;
            this.contratoDataGridView.RowTemplate.Height = 24;
            this.contratoDataGridView.Size = new System.Drawing.Size(879, 181);
            this.contratoDataGridView.TabIndex = 46;
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "idReserva";
            this.dataGridViewTextBoxColumn4.HeaderText = "idReserva";
            this.dataGridViewTextBoxColumn4.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            this.dataGridViewTextBoxColumn4.Width = 125;
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "fechaContrato";
            this.dataGridViewTextBoxColumn5.HeaderText = "fechaContrato";
            this.dataGridViewTextBoxColumn5.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            this.dataGridViewTextBoxColumn5.Width = 125;
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "matricula";
            this.dataGridViewTextBoxColumn6.HeaderText = "matricula";
            this.dataGridViewTextBoxColumn6.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            this.dataGridViewTextBoxColumn6.Width = 125;
            // 
            // FormContratos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(876, 454);
            this.Controls.Add(this.contratoDataGridView);
            this.Controls.Add(this.pnlVerificar);
            this.Controls.Add(this.pnlControles);
            this.Controls.Add(this.dateFechaContrato);
            this.Controls.Add(this.txtMatricula);
            this.Controls.Add(this.txtIdReserva);
            this.Controls.Add(this.lblMatricula);
            this.Controls.Add(this.lblIdReserva);
            this.Controls.Add(this.lblFechaContrato);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormContratos";
            this.Text = "Formulario Contratos";
            this.Load += new System.EventHandler(this.FormContratos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.contratoBindingSource)).EndInit();
            this.pnlControles.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlVerificar.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.contratoDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private RentalCarDataSet rentalCarDataSet;
        private System.Windows.Forms.BindingSource contratoBindingSource;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnAgregar;
        private System.Windows.Forms.TextBox txtIdReserva;
        private System.Windows.Forms.Label lblMatricula;
        private System.Windows.Forms.Label lblIdReserva;
        private System.Windows.Forms.Label lblFechaContrato;
        private System.Windows.Forms.DateTimePicker dateFechaContrato;
        private System.Windows.Forms.TextBox txtMatricula;
        private System.Windows.Forms.Panel pnlControles;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel pnlVerificar;
        private System.Windows.Forms.PictureBox picConfirmar;
        private System.Windows.Forms.PictureBox picDenegar;
        private RentalCarDataSetTableAdapters.ContratoTableAdapter contratoTableAdapter;
        private RentalCarDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView contratoDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
    }
}