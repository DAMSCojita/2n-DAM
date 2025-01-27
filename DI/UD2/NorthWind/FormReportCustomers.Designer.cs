namespace NorthWind
{
    partial class FormReportCustomers
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.pnlParametros = new System.Windows.Forms.Panel();
            this.cmbReport = new System.Windows.Forms.ComboBox();
            this.lblReport = new System.Windows.Forms.Label();
            this.txtCity = new System.Windows.Forms.TextBox();
            this.lblCity = new System.Windows.Forms.Label();
            this.txtCountry = new System.Windows.Forms.TextBox();
            this.lblCountry = new System.Windows.Forms.Label();
            this.btnVisualizar = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.northwindDataSet = new NorthWind.NorthwindDataSet();
            this.customersBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.customersTableAdapter = new NorthWind.NorthwindDataSetTableAdapters.CustomersTableAdapter();
            this.tableAdapterManager = new NorthWind.NorthwindDataSetTableAdapters.TableAdapterManager();
            this.pnlParametros.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlParametros
            // 
            this.pnlParametros.Controls.Add(this.cmbReport);
            this.pnlParametros.Controls.Add(this.lblReport);
            this.pnlParametros.Controls.Add(this.txtCity);
            this.pnlParametros.Controls.Add(this.lblCity);
            this.pnlParametros.Controls.Add(this.txtCountry);
            this.pnlParametros.Controls.Add(this.lblCountry);
            this.pnlParametros.Controls.Add(this.btnVisualizar);
            this.pnlParametros.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlParametros.Location = new System.Drawing.Point(0, 0);
            this.pnlParametros.Name = "pnlParametros";
            this.pnlParametros.Size = new System.Drawing.Size(929, 89);
            this.pnlParametros.TabIndex = 0;
            // 
            // cmbReport
            // 
            this.cmbReport.FormattingEnabled = true;
            this.cmbReport.Location = new System.Drawing.Point(24, 41);
            this.cmbReport.Name = "cmbReport";
            this.cmbReport.Size = new System.Drawing.Size(171, 24);
            this.cmbReport.TabIndex = 12;
            // 
            // lblReport
            // 
            this.lblReport.AutoSize = true;
            this.lblReport.Location = new System.Drawing.Point(79, 22);
            this.lblReport.Name = "lblReport";
            this.lblReport.Size = new System.Drawing.Size(51, 16);
            this.lblReport.TabIndex = 11;
            this.lblReport.Text = "Report:";
            // 
            // txtCity
            // 
            this.txtCity.Location = new System.Drawing.Point(455, 38);
            this.txtCity.Name = "txtCity";
            this.txtCity.Size = new System.Drawing.Size(96, 22);
            this.txtCity.TabIndex = 4;
            // 
            // lblCity
            // 
            this.lblCity.AutoSize = true;
            this.lblCity.Location = new System.Drawing.Point(420, 41);
            this.lblCity.Name = "lblCity";
            this.lblCity.Size = new System.Drawing.Size(32, 16);
            this.lblCity.TabIndex = 3;
            this.lblCity.Text = "City:";
            // 
            // txtCountry
            // 
            this.txtCountry.Location = new System.Drawing.Point(281, 38);
            this.txtCountry.Name = "txtCountry";
            this.txtCountry.Size = new System.Drawing.Size(96, 22);
            this.txtCountry.TabIndex = 2;
            // 
            // lblCountry
            // 
            this.lblCountry.AutoSize = true;
            this.lblCountry.Location = new System.Drawing.Point(223, 41);
            this.lblCountry.Name = "lblCountry";
            this.lblCountry.Size = new System.Drawing.Size(55, 16);
            this.lblCountry.TabIndex = 1;
            this.lblCountry.Text = "Country:";
            // 
            // btnVisualizar
            // 
            this.btnVisualizar.Dock = System.Windows.Forms.DockStyle.Right;
            this.btnVisualizar.Location = new System.Drawing.Point(753, 0);
            this.btnVisualizar.Name = "btnVisualizar";
            this.btnVisualizar.Size = new System.Drawing.Size(176, 89);
            this.btnVisualizar.TabIndex = 0;
            this.btnVisualizar.Text = "Visualizar";
            this.btnVisualizar.UseVisualStyleBackColor = true;
            this.btnVisualizar.Click += new System.EventHandler(this.btnVisualizar_Click);
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.reportViewer1);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(0, 89);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(929, 519);
            this.panel2.TabIndex = 1;
            // 
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "NorthWind.ReportCustomers.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 0);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(929, 519);
            this.reportViewer1.TabIndex = 0;
            // 
            // northwindDataSet
            // 
            this.northwindDataSet.DataSetName = "NorthwindDataSet";
            this.northwindDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // customersBindingSource
            // 
            this.customersBindingSource.DataMember = "Customers";
            this.customersBindingSource.DataSource = this.northwindDataSet;
            // 
            // customersTableAdapter
            // 
            this.customersTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CategoriesTableAdapter = null;
            this.tableAdapterManager.CustomerCustomerDemoTableAdapter = null;
            this.tableAdapterManager.CustomerDemographicsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = this.customersTableAdapter;
            this.tableAdapterManager.EmployeesTableAdapter = null;
            this.tableAdapterManager.EmployeeTerritoriesTableAdapter = null;
            this.tableAdapterManager.Order_DetailsTableAdapter = null;
            this.tableAdapterManager.OrdersTableAdapter = null;
            this.tableAdapterManager.ProductsTableAdapter = null;
            this.tableAdapterManager.RegionTableAdapter = null;
            this.tableAdapterManager.ShippersTableAdapter = null;
            this.tableAdapterManager.SuppliersTableAdapter = null;
            this.tableAdapterManager.TerritoriesTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = NorthWind.NorthwindDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // FormReportCustomers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(929, 608);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.pnlParametros);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormReportCustomers";
            this.Text = "Report Customers";
            this.Load += new System.EventHandler(this.FormReportCustomers_Load);
            this.pnlParametros.ResumeLayout(false);
            this.pnlParametros.PerformLayout();
            this.panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlParametros;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Button btnVisualizar;
        private System.Windows.Forms.Label lblCountry;
        private System.Windows.Forms.TextBox txtCountry;
        private System.Windows.Forms.Label lblCity;
        private System.Windows.Forms.TextBox txtCity;
        private System.Windows.Forms.ComboBox cmbReport;
        private System.Windows.Forms.Label lblReport;
        private NorthwindDataSet northwindDataSet;
        private System.Windows.Forms.BindingSource customersBindingSource;
        private NorthwindDataSetTableAdapters.CustomersTableAdapter customersTableAdapter;
        private NorthwindDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
    }
}

