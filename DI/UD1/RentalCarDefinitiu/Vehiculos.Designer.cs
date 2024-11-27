namespace RentalCarDefinitiu
{
    partial class FormVehiculos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormVehiculos));
            this.lblMatricula = new System.Windows.Forms.Label();
            this.lblTipologia = new System.Windows.Forms.Label();
            this.lblMarca = new System.Windows.Forms.Label();
            this.lblModelo = new System.Windows.Forms.Label();
            this.lblColor = new System.Windows.Forms.Label();
            this.txtMatricula = new System.Windows.Forms.TextBox();
            this.vehiculoBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.rentalCarDataSet = new RentalCarDefinitiu.RentalCarDataSet();
            this.txtColor = new System.Windows.Forms.TextBox();
            this.btnAgregar = new System.Windows.Forms.Button();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.pnlControles = new System.Windows.Forms.Panel();
            this.picEditar = new System.Windows.Forms.PictureBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlVerificar = new System.Windows.Forms.Panel();
            this.picConfirmar = new System.Windows.Forms.PictureBox();
            this.picDenegar = new System.Windows.Forms.PictureBox();
            this.vehiculoDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pnlContenedor = new System.Windows.Forms.Panel();
            this.cmbModelo = new System.Windows.Forms.ComboBox();
            this.modeloBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.cmbMarca = new System.Windows.Forms.ComboBox();
            this.vistamarcaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.cmbTipologia = new System.Windows.Forms.ComboBox();
            this.vistatipologiaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.vehiculoTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.VehiculoTableAdapter();
            this.tableAdapterManager = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager();
            this.vista_tipologiaTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.vista_tipologiaTableAdapter();
            this.vista_marcaTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.vista_marcaTableAdapter();
            this.modeloTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.ModeloTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.vehiculoBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).BeginInit();
            this.pnlControles.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picEditar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlVerificar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.vehiculoDataGridView)).BeginInit();
            this.pnlContenedor.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.modeloBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.vistamarcaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.vistatipologiaBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // lblMatricula
            // 
            this.lblMatricula.AutoSize = true;
            this.lblMatricula.Location = new System.Drawing.Point(34, 19);
            this.lblMatricula.Name = "lblMatricula";
            this.lblMatricula.Size = new System.Drawing.Size(61, 16);
            this.lblMatricula.TabIndex = 2;
            this.lblMatricula.Text = "Matricula";
            // 
            // lblTipologia
            // 
            this.lblTipologia.AutoSize = true;
            this.lblTipologia.Location = new System.Drawing.Point(34, 63);
            this.lblTipologia.Name = "lblTipologia";
            this.lblTipologia.Size = new System.Drawing.Size(65, 16);
            this.lblTipologia.TabIndex = 3;
            this.lblTipologia.Text = "Tipologia";
            // 
            // lblMarca
            // 
            this.lblMarca.AutoSize = true;
            this.lblMarca.Location = new System.Drawing.Point(55, 106);
            this.lblMarca.Name = "lblMarca";
            this.lblMarca.Size = new System.Drawing.Size(45, 16);
            this.lblMarca.TabIndex = 4;
            this.lblMarca.Text = "Marca";
            // 
            // lblModelo
            // 
            this.lblModelo.AutoSize = true;
            this.lblModelo.Location = new System.Drawing.Point(47, 149);
            this.lblModelo.Name = "lblModelo";
            this.lblModelo.Size = new System.Drawing.Size(53, 16);
            this.lblModelo.TabIndex = 5;
            this.lblModelo.Text = "Modelo";
            // 
            // lblColor
            // 
            this.lblColor.AutoSize = true;
            this.lblColor.Location = new System.Drawing.Point(57, 189);
            this.lblColor.Name = "lblColor";
            this.lblColor.Size = new System.Drawing.Size(39, 16);
            this.lblColor.TabIndex = 6;
            this.lblColor.Text = "Color";
            // 
            // txtMatricula
            // 
            this.txtMatricula.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.vehiculoBindingSource, "Matricula", true));
            this.txtMatricula.Location = new System.Drawing.Point(101, 16);
            this.txtMatricula.Name = "txtMatricula";
            this.txtMatricula.Size = new System.Drawing.Size(135, 22);
            this.txtMatricula.TabIndex = 7;
            // 
            // vehiculoBindingSource
            // 
            this.vehiculoBindingSource.DataMember = "Vehiculo";
            this.vehiculoBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // rentalCarDataSet
            // 
            this.rentalCarDataSet.DataSetName = "RentalCarDataSet";
            this.rentalCarDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // txtColor
            // 
            this.txtColor.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.vehiculoBindingSource, "Color", true));
            this.txtColor.Location = new System.Drawing.Point(102, 186);
            this.txtColor.Name = "txtColor";
            this.txtColor.Size = new System.Drawing.Size(135, 22);
            this.txtColor.TabIndex = 11;
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(178, 4);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(49, 29);
            this.btnAgregar.TabIndex = 12;
            this.btnAgregar.Text = "+";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click);
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(233, 4);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(54, 29);
            this.btnEliminar.TabIndex = 13;
            this.btnEliminar.Text = "-";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // pnlControles
            // 
            this.pnlControles.Controls.Add(this.picEditar);
            this.pnlControles.Controls.Add(this.pictureBox4);
            this.pnlControles.Controls.Add(this.pictureBox3);
            this.pnlControles.Controls.Add(this.pictureBox2);
            this.pnlControles.Controls.Add(this.btnEliminar);
            this.pnlControles.Controls.Add(this.pictureBox1);
            this.pnlControles.Controls.Add(this.btnAgregar);
            this.pnlControles.Location = new System.Drawing.Point(0, 0);
            this.pnlControles.Name = "pnlControles";
            this.pnlControles.Size = new System.Drawing.Size(879, 36);
            this.pnlControles.TabIndex = 14;
            // 
            // picEditar
            // 
            this.picEditar.Image = ((System.Drawing.Image)(resources.GetObject("picEditar.Image")));
            this.picEditar.Location = new System.Drawing.Point(293, 2);
            this.picEditar.Name = "picEditar";
            this.picEditar.Size = new System.Drawing.Size(37, 31);
            this.picEditar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picEditar.TabIndex = 16;
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
            this.pnlVerificar.Location = new System.Drawing.Point(0, 465);
            this.pnlVerificar.Name = "pnlVerificar";
            this.pnlVerificar.Size = new System.Drawing.Size(879, 39);
            this.pnlVerificar.TabIndex = 15;
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
            this.picConfirmar.Click += new System.EventHandler(this.picConfirmar_Click);
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
            this.picDenegar.Click += new System.EventHandler(this.picDenegar_Click);
            // 
            // vehiculoDataGridView
            // 
            this.vehiculoDataGridView.AutoGenerateColumns = false;
            this.vehiculoDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.vehiculoDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10});
            this.vehiculoDataGridView.DataSource = this.vehiculoBindingSource;
            this.vehiculoDataGridView.Location = new System.Drawing.Point(0, 284);
            this.vehiculoDataGridView.Name = "vehiculoDataGridView";
            this.vehiculoDataGridView.RowHeadersWidth = 51;
            this.vehiculoDataGridView.RowTemplate.Height = 24;
            this.vehiculoDataGridView.Size = new System.Drawing.Size(879, 181);
            this.vehiculoDataGridView.TabIndex = 15;
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "matricula";
            this.dataGridViewTextBoxColumn6.HeaderText = "matricula";
            this.dataGridViewTextBoxColumn6.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            this.dataGridViewTextBoxColumn6.Width = 125;
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "tipologia";
            this.dataGridViewTextBoxColumn7.HeaderText = "tipologia";
            this.dataGridViewTextBoxColumn7.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            this.dataGridViewTextBoxColumn7.Width = 125;
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.DataPropertyName = "marca";
            this.dataGridViewTextBoxColumn8.HeaderText = "marca";
            this.dataGridViewTextBoxColumn8.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            this.dataGridViewTextBoxColumn8.Width = 125;
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.DataPropertyName = "modelo";
            this.dataGridViewTextBoxColumn9.HeaderText = "modelo";
            this.dataGridViewTextBoxColumn9.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            this.dataGridViewTextBoxColumn9.Width = 125;
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.DataPropertyName = "color";
            this.dataGridViewTextBoxColumn10.HeaderText = "color";
            this.dataGridViewTextBoxColumn10.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            this.dataGridViewTextBoxColumn10.Width = 125;
            // 
            // pnlContenedor
            // 
            this.pnlContenedor.Controls.Add(this.cmbModelo);
            this.pnlContenedor.Controls.Add(this.cmbMarca);
            this.pnlContenedor.Controls.Add(this.cmbTipologia);
            this.pnlContenedor.Controls.Add(this.txtColor);
            this.pnlContenedor.Controls.Add(this.txtMatricula);
            this.pnlContenedor.Controls.Add(this.lblColor);
            this.pnlContenedor.Controls.Add(this.lblModelo);
            this.pnlContenedor.Controls.Add(this.lblMarca);
            this.pnlContenedor.Controls.Add(this.lblTipologia);
            this.pnlContenedor.Controls.Add(this.lblMatricula);
            this.pnlContenedor.Location = new System.Drawing.Point(0, 39);
            this.pnlContenedor.Name = "pnlContenedor";
            this.pnlContenedor.Size = new System.Drawing.Size(876, 426);
            this.pnlContenedor.TabIndex = 16;
            // 
            // cmbModelo
            // 
            this.cmbModelo.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.vehiculoBindingSource, "modelo", true));
            this.cmbModelo.DataSource = this.modeloBindingSource;
            this.cmbModelo.DisplayMember = "modelo";
            this.cmbModelo.FormattingEnabled = true;
            this.cmbModelo.Location = new System.Drawing.Point(102, 146);
            this.cmbModelo.Name = "cmbModelo";
            this.cmbModelo.Size = new System.Drawing.Size(135, 24);
            this.cmbModelo.TabIndex = 14;
            // 
            // modeloBindingSource
            // 
            this.modeloBindingSource.DataMember = "Modelo";
            this.modeloBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // cmbMarca
            // 
            this.cmbMarca.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.vehiculoBindingSource, "marca", true));
            this.cmbMarca.DataSource = this.vistamarcaBindingSource;
            this.cmbMarca.DisplayMember = "marca";
            this.cmbMarca.FormattingEnabled = true;
            this.cmbMarca.Location = new System.Drawing.Point(102, 103);
            this.cmbMarca.Name = "cmbMarca";
            this.cmbMarca.Size = new System.Drawing.Size(135, 24);
            this.cmbMarca.TabIndex = 13;
            this.cmbMarca.SelectedIndexChanged += new System.EventHandler(this.cmbMarca_SelectedIndexChanged);
            // 
            // vistamarcaBindingSource
            // 
            this.vistamarcaBindingSource.DataMember = "vista_marca";
            this.vistamarcaBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // cmbTipologia
            // 
            this.cmbTipologia.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.vehiculoBindingSource, "tipologia", true));
            this.cmbTipologia.DataSource = this.vistatipologiaBindingSource;
            this.cmbTipologia.DisplayMember = "tipologia";
            this.cmbTipologia.FormattingEnabled = true;
            this.cmbTipologia.Location = new System.Drawing.Point(101, 59);
            this.cmbTipologia.Name = "cmbTipologia";
            this.cmbTipologia.Size = new System.Drawing.Size(135, 24);
            this.cmbTipologia.TabIndex = 12;
            this.cmbTipologia.SelectedIndexChanged += new System.EventHandler(this.cmbTipologia_SelectedIndexChanged);
            // 
            // vistatipologiaBindingSource
            // 
            this.vistatipologiaBindingSource.DataMember = "vista_tipologia";
            this.vistatipologiaBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // vehiculoTableAdapter
            // 
            this.vehiculoTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CargoTableAdapter = null;
            this.tableAdapterManager.ClienteTableAdapter = null;
            this.tableAdapterManager.ContratoTableAdapter = null;
            this.tableAdapterManager.ModeloTableAdapter = null;
            this.tableAdapterManager.ReservaTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.VehiculoTableAdapter = this.vehiculoTableAdapter;
            // 
            // vista_tipologiaTableAdapter
            // 
            this.vista_tipologiaTableAdapter.ClearBeforeFill = true;
            // 
            // vista_marcaTableAdapter
            // 
            this.vista_marcaTableAdapter.ClearBeforeFill = true;
            // 
            // modeloTableAdapter
            // 
            this.modeloTableAdapter.ClearBeforeFill = true;
            // 
            // FormVehiculos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(873, 503);
            this.Controls.Add(this.vehiculoDataGridView);
            this.Controls.Add(this.pnlVerificar);
            this.Controls.Add(this.pnlControles);
            this.Controls.Add(this.pnlContenedor);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormVehiculos";
            this.Text = "Formulario Vehiculos";
            this.Load += new System.EventHandler(this.FormVehiculos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.vehiculoBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).EndInit();
            this.pnlControles.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picEditar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlVerificar.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.vehiculoDataGridView)).EndInit();
            this.pnlContenedor.ResumeLayout(false);
            this.pnlContenedor.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.modeloBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.vistamarcaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.vistatipologiaBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private RentalCarDataSet rentalCarDataSet;
        private System.Windows.Forms.BindingSource vehiculoBindingSource;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.Label lblMatricula;
        private System.Windows.Forms.Label lblTipologia;
        private System.Windows.Forms.Label lblMarca;
        private System.Windows.Forms.Label lblModelo;
        private System.Windows.Forms.Label lblColor;
        private System.Windows.Forms.TextBox txtMatricula;
        private System.Windows.Forms.TextBox txtColor;
        private System.Windows.Forms.Button btnAgregar;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Panel pnlControles;
        private System.Windows.Forms.Panel pnlVerificar;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox picConfirmar;
        private System.Windows.Forms.PictureBox picDenegar;
        private RentalCarDataSetTableAdapters.VehiculoTableAdapter vehiculoTableAdapter;
        private RentalCarDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView vehiculoDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
        private System.Windows.Forms.PictureBox picEditar;
        private System.Windows.Forms.Panel pnlContenedor;
        private System.Windows.Forms.ComboBox cmbTipologia;
        private System.Windows.Forms.ComboBox cmbMarca;
        private System.Windows.Forms.ComboBox cmbModelo;
        private System.Windows.Forms.BindingSource vistatipologiaBindingSource;
        private RentalCarDataSetTableAdapters.vista_tipologiaTableAdapter vista_tipologiaTableAdapter;
        private System.Windows.Forms.BindingSource vistamarcaBindingSource;
        private RentalCarDataSetTableAdapters.vista_marcaTableAdapter vista_marcaTableAdapter;
        private System.Windows.Forms.BindingSource modeloBindingSource;
        private RentalCarDataSetTableAdapters.ModeloTableAdapter modeloTableAdapter;
    }
}