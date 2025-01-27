using Microsoft.Reporting.WinForms;
using Microsoft.ReportingServices.ReportProcessing.ReportObjectModel;
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
    public partial class FormReportPedidos : Form
    {
        public FormReportPedidos()
        {
            InitializeComponent();
        }

        private void FormReportPedidos_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'northwindDataSet.VReportPedidos' Puede moverla o quitarla según sea necesario.
            this.vReportPedidosTableAdapter.Fill(this.northwindDataSet.VReportPedidos);
        }

        private void btnVisualizar_Click(object sender, EventArgs e)
        {

            string titulo = "Listado de Pedidos de " + txtCompany.Text + " con pedidos realizados a partir de " + dateStart.Text + " hasta " + dateEnd.Text;

            ReportParameter[] parameters = new ReportParameter[1];

            parameters[0] = new ReportParameter("Titulo", titulo);
            
            this.reportViewer1.LocalReport.SetParameters(parameters);

            string filter = $"CompanyName LIKE '{txtCompany.Text}' AND OrderDate >= '{dateStart.Value.ToString("yyyy-MM-dd")}' AND OrderDate <= '{dateEnd.Value.ToString("yyyy-MM-dd")}'";

            vReportPedidosBindingSource.Filter = filter;

            this.reportViewer1.ProcessingMode = ProcessingMode.Local;
            this.reportViewer1.LocalReport.DataSources.Clear();
            this.reportViewer1.LocalReport.DataSources.Add(new ReportDataSource("DataSetReportView", vReportPedidosBindingSource));

            this.reportViewer1.LocalReport.ReportEmbeddedResource = "NorthWind.ReportPedidos.rdlc";

            this.reportViewer1.LocalReport.Refresh();

            this.reportViewer1.RefreshReport();
        }


    }
}
