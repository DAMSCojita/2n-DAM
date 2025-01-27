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
    public partial class MenuPrincipal : Form
    {
        public MenuPrincipal()
        {
            InitializeComponent();
        }

        // Cream un mètode per gestionar els formularis quan l'usuari vagi canviant entre opcions.
        private void AbrirFormHijo(object formhijo)
        {
            // Estructura de control 'if'.
            // Verificam si el panel principal té qualque control.
            if (this.pnlPrincipal.Controls.Count > 0)
                this.pnlPrincipal.Controls.RemoveAt(0); // En cas de que trobem un control, eliminem el primer (posició 0).
            Form fh = formhijo as Form; // Convertim el objecte 'formhijo' en un objecte de tipus Form.
            fh.TopLevel = false; // Resumidament indiquem que el formulari no està a nivell superior (com un control secundari).
            fh.Dock = DockStyle.Fill; // Ajustem el formulari per a que ocupi tot el espai disponible en el panel (per si de cas).
            this.pnlPrincipal.Controls.Add(fh); // Afegim el formulari fill al panel principal com un control.
            this.pnlPrincipal.Tag = fh; // Emmagatzemam una referència al formulari fill en la propietat 'Tag' del panel per el seu posible ús posterior.
            fh.Show(); // Mostrem el formulari.
        }

        private void btnReportClientes_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormReportCustomers());
        }

        private void btnReportClientesParametros_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormReportPedidos()); 
        }
    }
}
