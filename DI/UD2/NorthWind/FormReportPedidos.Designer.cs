namespace NorthWind
{
    partial class FormReportPedidos
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
            this.pnlParametros = new System.Windows.Forms.Panel();
            this.lblEnd = new System.Windows.Forms.Label();
            this.dateEnd = new System.Windows.Forms.DateTimePicker();
            this.dateStart = new System.Windows.Forms.DateTimePicker();
            this.lblStart = new System.Windows.Forms.Label();
            this.txtCompany = new System.Windows.Forms.TextBox();
            this.lblCustomer = new System.Windows.Forms.Label();
            this.btnVisualizar = new System.Windows.Forms.Button();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.northwindDataSet = new NorthWind.NorthwindDataSet();
            this.vReportPedidosBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.vReportPedidosTableAdapter = new NorthWind.NorthwindDataSetTableAdapters.VReportPedidosTableAdapter();
            this.tableAdapterManager = new NorthWind.NorthwindDataSetTableAdapters.TableAdapterManager();
            this.reportViewer1 = new Microsoft.Reporting.WinForms.ReportViewer();
            this.pnlParametros.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.vReportPedidosBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlParametros
            // 
            this.pnlParametros.Controls.Add(this.lblEnd);
            this.pnlParametros.Controls.Add(this.dateEnd);
            this.pnlParametros.Controls.Add(this.dateStart);
            this.pnlParametros.Controls.Add(this.lblStart);
            this.pnlParametros.Controls.Add(this.txtCompany);
            this.pnlParametros.Controls.Add(this.lblCustomer);
            this.pnlParametros.Controls.Add(this.btnVisualizar);
            this.pnlParametros.Controls.Add(this.flowLayoutPanel1);
            this.pnlParametros.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlParametros.Location = new System.Drawing.Point(0, 0);
            this.pnlParametros.Name = "pnlParametros";
            this.pnlParametros.Size = new System.Drawing.Size(837, 79);
            this.pnlParametros.TabIndex = 0;
            // 
            // lblEnd
            // 
            this.lblEnd.AutoSize = true;
            this.lblEnd.Location = new System.Drawing.Point(199, 51);
            this.lblEnd.Name = "lblEnd";
            this.lblEnd.Size = new System.Drawing.Size(66, 16);
            this.lblEnd.TabIndex = 8;
            this.lblEnd.Text = "End Date:";
            // 
            // dateEnd
            // 
            this.dateEnd.Location = new System.Drawing.Point(271, 48);
            this.dateEnd.Name = "dateEnd";
            this.dateEnd.Size = new System.Drawing.Size(266, 22);
            this.dateEnd.TabIndex = 7;
            // 
            // dateStart
            // 
            this.dateStart.Location = new System.Drawing.Point(271, 10);
            this.dateStart.Name = "dateStart";
            this.dateStart.Size = new System.Drawing.Size(266, 22);
            this.dateStart.TabIndex = 6;
            // 
            // lblStart
            // 
            this.lblStart.AutoSize = true;
            this.lblStart.Location = new System.Drawing.Point(196, 13);
            this.lblStart.Name = "lblStart";
            this.lblStart.Size = new System.Drawing.Size(69, 16);
            this.lblStart.TabIndex = 5;
            this.lblStart.Text = "Start Date:";
            // 
            // txtCompany
            // 
            this.txtCompany.Location = new System.Drawing.Point(26, 35);
            this.txtCompany.Name = "txtCompany";
            this.txtCompany.Size = new System.Drawing.Size(150, 22);
            this.txtCompany.TabIndex = 4;
            // 
            // lblCustomer
            // 
            this.lblCustomer.AutoSize = true;
            this.lblCustomer.Location = new System.Drawing.Point(48, 16);
            this.lblCustomer.Name = "lblCustomer";
            this.lblCustomer.Size = new System.Drawing.Size(108, 16);
            this.lblCustomer.TabIndex = 3;
            this.lblCustomer.Text = "Company Name:";
            // 
            // btnVisualizar
            // 
            this.btnVisualizar.Dock = System.Windows.Forms.DockStyle.Right;
            this.btnVisualizar.Location = new System.Drawing.Point(672, 0);
            this.btnVisualizar.Name = "btnVisualizar";
            this.btnVisualizar.Size = new System.Drawing.Size(165, 79);
            this.btnVisualizar.TabIndex = 2;
            this.btnVisualizar.Text = "Visualizar";
            this.btnVisualizar.UseVisualStyleBackColor = true;
            this.btnVisualizar.Click += new System.EventHandler(this.btnVisualizar_Click);
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Location = new System.Drawing.Point(3, 135);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(802, 315);
            this.flowLayoutPanel1.TabIndex = 1;
            // 
            // panel2
            // 
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(0, 79);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(837, 424);
            this.panel2.TabIndex = 1;
            // 
            // northwindDataSet
            // 
            this.northwindDataSet.DataSetName = "NorthwindDataSet";
            this.northwindDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // vReportPedidosBindingSource
            // 
            this.vReportPedidosBindingSource.DataMember = "VReportPedidos";
            this.vReportPedidosBindingSource.DataSource = this.northwindDataSet;
            // 
            // vReportPedidosTableAdapter
            // 
            this.vReportPedidosTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.CategoriesTableAdapter = null;
            this.tableAdapterManager.Connection = null;
            this.tableAdapterManager.CustomerCustomerDemoTableAdapter = null;
            this.tableAdapterManager.CustomerDemographicsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
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
            // reportViewer1
            // 
            this.reportViewer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.reportViewer1.LocalReport.ReportEmbeddedResource = "NorthWind.ReportPedidos.rdlc";
            this.reportViewer1.Location = new System.Drawing.Point(0, 79);
            this.reportViewer1.Name = "reportViewer1";
            this.reportViewer1.ServerReport.BearerToken = null;
            this.reportViewer1.Size = new System.Drawing.Size(837, 499);
            this.reportViewer1.TabIndex = 1;
            // 
            // FormReportPedidos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(837, 578);
            this.Controls.Add(this.reportViewer1);
            this.Controls.Add(this.pnlParametros);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FormReportPedidos";
            this.Load += new System.EventHandler(this.FormReportPedidos_Load);
            this.pnlParametros.ResumeLayout(false);
            this.pnlParametros.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.northwindDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.vReportPedidosBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlParametros;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Button btnVisualizar;
        private System.Windows.Forms.Label lblCustomer;
        private System.Windows.Forms.TextBox txtCompany;
        private System.Windows.Forms.Label lblStart;
        private System.Windows.Forms.DateTimePicker dateStart;
        private System.Windows.Forms.DateTimePicker dateEnd;
        private System.Windows.Forms.Label lblEnd;
        private NorthwindDataSet northwindDataSet;
        private System.Windows.Forms.BindingSource vReportPedidosBindingSource;
        private NorthwindDataSetTableAdapters.VReportPedidosTableAdapter vReportPedidosTableAdapter;
        private NorthwindDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private Microsoft.Reporting.WinForms.ReportViewer reportViewer1;
    }
}