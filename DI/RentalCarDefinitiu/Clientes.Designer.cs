namespace RentalCarDefinitiu
{
    partial class FormClientes
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
            System.Windows.Forms.Label lblDni;
            System.Windows.Forms.Label lblNombre;
            System.Windows.Forms.Label lblApellidos;
            System.Windows.Forms.Label lblDireccion;
            System.Windows.Forms.Label lblPoblacion;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormClientes));
            this.rentalCarDataSet = new RentalCarDefinitiu.RentalCarDataSet();
            this.clienteBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.clienteTableAdapter = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.ClienteTableAdapter();
            this.tableAdapterManager = new RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager();
            this.clienteDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pnlControles = new System.Windows.Forms.Panel();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlVerificar = new System.Windows.Forms.Panel();
            this.picConfirmar = new System.Windows.Forms.PictureBox();
            this.picDenegar = new System.Windows.Forms.PictureBox();
            this.txtDni = new System.Windows.Forms.TextBox();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.txtApellidos = new System.Windows.Forms.TextBox();
            this.txtDireccion = new System.Windows.Forms.TextBox();
            this.txtPoblacion = new System.Windows.Forms.TextBox();
            this.btnEliminar = new System.Windows.Forms.Button();
            this.btnAgregar = new System.Windows.Forms.Button();
            lblDni = new System.Windows.Forms.Label();
            lblNombre = new System.Windows.Forms.Label();
            lblApellidos = new System.Windows.Forms.Label();
            lblDireccion = new System.Windows.Forms.Label();
            lblPoblacion = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteDataGridView)).BeginInit();
            this.pnlControles.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlVerificar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).BeginInit();
            this.SuspendLayout();
            // 
            // lblDni
            // 
            lblDni.AutoSize = true;
            lblDni.Location = new System.Drawing.Point(44, 62);
            lblDni.Name = "lblDni";
            lblDni.Size = new System.Drawing.Size(28, 16);
            lblDni.TabIndex = 16;
            lblDni.Text = "dni:";
            // 
            // lblNombre
            // 
            lblNombre.AutoSize = true;
            lblNombre.Location = new System.Drawing.Point(16, 102);
            lblNombre.Name = "lblNombre";
            lblNombre.Size = new System.Drawing.Size(56, 16);
            lblNombre.TabIndex = 17;
            lblNombre.Text = "nombre:";
            // 
            // lblApellidos
            // 
            lblApellidos.AutoSize = true;
            lblApellidos.Location = new System.Drawing.Point(6, 145);
            lblApellidos.Name = "lblApellidos";
            lblApellidos.Size = new System.Drawing.Size(66, 16);
            lblApellidos.TabIndex = 18;
            lblApellidos.Text = "apellidos:";
            // 
            // lblDireccion
            // 
            lblDireccion.AutoSize = true;
            lblDireccion.Location = new System.Drawing.Point(7, 188);
            lblDireccion.Name = "lblDireccion";
            lblDireccion.Size = new System.Drawing.Size(65, 16);
            lblDireccion.TabIndex = 19;
            lblDireccion.Text = "dirección:";
            // 
            // lblPoblacion
            // 
            lblPoblacion.AutoSize = true;
            lblPoblacion.Location = new System.Drawing.Point(2, 227);
            lblPoblacion.Name = "lblPoblacion";
            lblPoblacion.Size = new System.Drawing.Size(70, 16);
            lblPoblacion.TabIndex = 20;
            lblPoblacion.Text = "población:";
            // 
            // rentalCarDataSet
            // 
            this.rentalCarDataSet.DataSetName = "RentalCarDataSet";
            this.rentalCarDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // clienteBindingSource
            // 
            this.clienteBindingSource.DataMember = "Cliente";
            this.clienteBindingSource.DataSource = this.rentalCarDataSet;
            // 
            // clienteTableAdapter
            // 
            this.clienteTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CargoTableAdapter = null;
            this.tableAdapterManager.ClienteTableAdapter = this.clienteTableAdapter;
            this.tableAdapterManager.ContratoTableAdapter = null;
            this.tableAdapterManager.ReservaTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = RentalCarDefinitiu.RentalCarDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            this.tableAdapterManager.VehiculoTableAdapter = null;
            // 
            // clienteDataGridView
            // 
            this.clienteDataGridView.AutoGenerateColumns = false;
            this.clienteDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.clienteDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5});
            this.clienteDataGridView.DataSource = this.clienteBindingSource;
            this.clienteDataGridView.Location = new System.Drawing.Point(0, 255);
            this.clienteDataGridView.Name = "clienteDataGridView";
            this.clienteDataGridView.RowHeadersWidth = 51;
            this.clienteDataGridView.RowTemplate.Height = 24;
            this.clienteDataGridView.Size = new System.Drawing.Size(738, 127);
            this.clienteDataGridView.TabIndex = 1;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "dni";
            this.dataGridViewTextBoxColumn1.HeaderText = "dni";
            this.dataGridViewTextBoxColumn1.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.Width = 125;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "nombre";
            this.dataGridViewTextBoxColumn2.HeaderText = "nombre";
            this.dataGridViewTextBoxColumn2.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            this.dataGridViewTextBoxColumn2.Width = 125;
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "apellidos";
            this.dataGridViewTextBoxColumn3.HeaderText = "apellidos";
            this.dataGridViewTextBoxColumn3.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            this.dataGridViewTextBoxColumn3.Width = 125;
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "dirección";
            this.dataGridViewTextBoxColumn4.HeaderText = "dirección";
            this.dataGridViewTextBoxColumn4.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            this.dataGridViewTextBoxColumn4.Width = 125;
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "población";
            this.dataGridViewTextBoxColumn5.HeaderText = "población";
            this.dataGridViewTextBoxColumn5.MinimumWidth = 6;
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            this.dataGridViewTextBoxColumn5.Width = 125;
            // 
            // pnlControles
            // 
            this.pnlControles.Controls.Add(this.btnEliminar);
            this.pnlControles.Controls.Add(this.pictureBox4);
            this.pnlControles.Controls.Add(this.btnAgregar);
            this.pnlControles.Controls.Add(this.pictureBox3);
            this.pnlControles.Controls.Add(this.pictureBox2);
            this.pnlControles.Controls.Add(this.pictureBox1);
            this.pnlControles.Location = new System.Drawing.Point(1, 1);
            this.pnlControles.Name = "pnlControles";
            this.pnlControles.Size = new System.Drawing.Size(737, 36);
            this.pnlControles.TabIndex = 15;
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
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click_1);
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
            this.pictureBox3.Click += new System.EventHandler(this.pictureBox3_Click_1);
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
            this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click_1);
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
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click_1);
            // 
            // pnlVerificar
            // 
            this.pnlVerificar.Controls.Add(this.picConfirmar);
            this.pnlVerificar.Controls.Add(this.picDenegar);
            this.pnlVerificar.Location = new System.Drawing.Point(1, 382);
            this.pnlVerificar.Name = "pnlVerificar";
            this.pnlVerificar.Size = new System.Drawing.Size(737, 39);
            this.pnlVerificar.TabIndex = 16;
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
            this.picDenegar.Location = new System.Drawing.Point(696, 6);
            this.picDenegar.Name = "picDenegar";
            this.picDenegar.Size = new System.Drawing.Size(38, 30);
            this.picDenegar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.picDenegar.TabIndex = 18;
            this.picDenegar.TabStop = false;
            this.picDenegar.Click += new System.EventHandler(this.picDenegar_Click);
            // 
            // txtDni
            // 
            this.txtDni.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clienteBindingSource, "dni", true));
            this.txtDni.Location = new System.Drawing.Point(78, 59);
            this.txtDni.Name = "txtDni";
            this.txtDni.Size = new System.Drawing.Size(100, 22);
            this.txtDni.TabIndex = 17;
            // 
            // txtNombre
            // 
            this.txtNombre.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clienteBindingSource, "nombre", true));
            this.txtNombre.Location = new System.Drawing.Point(78, 99);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(100, 22);
            this.txtNombre.TabIndex = 18;
            // 
            // txtApellidos
            // 
            this.txtApellidos.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clienteBindingSource, "apellidos", true));
            this.txtApellidos.Location = new System.Drawing.Point(78, 142);
            this.txtApellidos.Name = "txtApellidos";
            this.txtApellidos.Size = new System.Drawing.Size(100, 22);
            this.txtApellidos.TabIndex = 19;
            // 
            // txtDireccion
            // 
            this.txtDireccion.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clienteBindingSource, "dirección", true));
            this.txtDireccion.Location = new System.Drawing.Point(78, 185);
            this.txtDireccion.Name = "txtDireccion";
            this.txtDireccion.Size = new System.Drawing.Size(100, 22);
            this.txtDireccion.TabIndex = 20;
            // 
            // txtPoblacion
            // 
            this.txtPoblacion.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clienteBindingSource, "población", true));
            this.txtPoblacion.Location = new System.Drawing.Point(78, 224);
            this.txtPoblacion.Name = "txtPoblacion";
            this.txtPoblacion.Size = new System.Drawing.Size(100, 22);
            this.txtPoblacion.TabIndex = 21;
            // 
            // btnEliminar
            // 
            this.btnEliminar.Location = new System.Drawing.Point(227, 5);
            this.btnEliminar.Name = "btnEliminar";
            this.btnEliminar.Size = new System.Drawing.Size(38, 27);
            this.btnEliminar.TabIndex = 23;
            this.btnEliminar.Text = "-";
            this.btnEliminar.UseVisualStyleBackColor = true;
            this.btnEliminar.Click += new System.EventHandler(this.btnEliminar_Click);
            // 
            // btnAgregar
            // 
            this.btnAgregar.Location = new System.Drawing.Point(178, 3);
            this.btnAgregar.Name = "btnAgregar";
            this.btnAgregar.Size = new System.Drawing.Size(43, 30);
            this.btnAgregar.TabIndex = 22;
            this.btnAgregar.Text = "+";
            this.btnAgregar.UseVisualStyleBackColor = true;
            this.btnAgregar.Click += new System.EventHandler(this.btnAgregar_Click);
            // 
            // FormClientes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(736, 424);
            this.Controls.Add(lblPoblacion);
            this.Controls.Add(this.txtPoblacion);
            this.Controls.Add(lblDireccion);
            this.Controls.Add(this.txtDireccion);
            this.Controls.Add(lblApellidos);
            this.Controls.Add(this.txtApellidos);
            this.Controls.Add(lblNombre);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(lblDni);
            this.Controls.Add(this.txtDni);
            this.Controls.Add(this.pnlVerificar);
            this.Controls.Add(this.pnlControles);
            this.Controls.Add(this.clienteDataGridView);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormClientes";
            this.Text = "Clientes";
            this.Load += new System.EventHandler(this.FormClientes_Load);
            ((System.ComponentModel.ISupportInitialize)(this.rentalCarDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteDataGridView)).EndInit();
            this.pnlControles.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlVerificar.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picConfirmar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picDenegar)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private RentalCarDataSet rentalCarDataSet;
        private System.Windows.Forms.BindingSource clienteBindingSource;
        private RentalCarDataSetTableAdapters.ClienteTableAdapter clienteTableAdapter;
        private RentalCarDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView clienteDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.Panel pnlControles;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel pnlVerificar;
        private System.Windows.Forms.PictureBox picConfirmar;
        private System.Windows.Forms.PictureBox picDenegar;
        private System.Windows.Forms.TextBox txtDni;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.TextBox txtApellidos;
        private System.Windows.Forms.TextBox txtDireccion;
        private System.Windows.Forms.TextBox txtPoblacion;
        private System.Windows.Forms.Button btnEliminar;
        private System.Windows.Forms.Button btnAgregar;
    }
}