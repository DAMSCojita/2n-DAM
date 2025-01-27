using Microsoft.Reporting.WinForms;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NorthWind
{
    public partial class FormReportCustomers : Form
    {
        public FormReportCustomers()
        {
            InitializeComponent();
        }

        private void customersBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.customersBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.northwindDataSet);

        }

        private void FormReportCustomers_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'northwindDataSet.Customers' Puede moverla o quitarla según sea necesario.
            this.customersTableAdapter.Fill(this.northwindDataSet.Customers);

            cmbReport.Items.Add("ReportCustomers");
            cmbReport.Items.Add("ReportCustomersSimple");

        }

        private void btnVisualizar_Click(object sender, EventArgs e)
        {

            string Titulo = "Listado de Clientes";
            ReportParameter[] parameters = new ReportParameter[1];

            if (txtCountry.Text.Length > 0)
            {
                this.customersBindingSource.Filter = "Country like '" + txtCountry.Text + "'";
                parameters[0] = new ReportParameter("Titulo", Titulo + " de " + txtCity.Text);
            }
            else
            {
                this.customersBindingSource.Filter = "";
                parameters[0] = new ReportParameter("Titulo", Titulo);
            }

            this.reportViewer1.ProcessingMode = ProcessingMode.Local;
            this.reportViewer1.LocalReport.DataSources.Clear();
            this.reportViewer1.LocalReport.DataSources.Add(new ReportDataSource("DataSetReportCustomers", customersBindingSource));

            string reportElegido = cmbReport.SelectedItem.ToString();
            this.reportViewer1.LocalReport.ReportEmbeddedResource = $"NorthWind.{reportElegido}.rdlc";

            this.reportViewer1.LocalReport.SetParameters(parameters);

            this.reportViewer1.LocalReport.Refresh();

            this.reportViewer1.RefreshReport();
        }

        
    }
}
