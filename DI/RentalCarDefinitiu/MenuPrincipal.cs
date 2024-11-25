using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RentalCarDefinitiu
{
    public partial class MenuPrincipal : Form
    {
        public MenuPrincipal()
        {
            InitializeComponent();
        }

        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnMaximizar_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized;
            btnMaximizar.Visible = false;
            btnRestaura.Visible = true;
        }

        private void btnRestaura_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Normal;
            btnRestaura.Visible = false;
            btnMaximizar.Visible = true;
        }

        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
        }

        private void AbrirFormHijo(object formhijo)
        {
            if (this.pnlPrincipal.Controls.Count > 0)
                this.pnlPrincipal.Controls.RemoveAt(0);
            Form fh = formhijo as Form;
            fh.TopLevel = false;
            fh.Dock = DockStyle.Fill;
            this.pnlPrincipal.Controls.Add(fh);
            this.pnlPrincipal.Tag = fh;
            fh.Show();
        }
        private void btnCargos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormCargos());
        }

        private void btnClientes_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormClientes());
        }

        private void btnContratos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormContratos());
        }

        private void btnReservas_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormReservas());
        }

        private void btnVehiculos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormVehiculos());
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private int clickX, clickY;
        private void pnlTitulo_MouseMove(object sender, MouseEventArgs e)
        {
            // si no se presiona el boton izquierdo del mouse
            // se guarda las coordenadas X, Y, esto pasa solo si se pasa
            // el raton por encima del panel.
            if (e.Button != MouseButtons.Left) {
                clickX = e.X;
                clickY = e.Y;
            } else {
                this.Left = this.Left + (e.X - clickX);
                this.Top = this.Top + (e.Y - clickY);
            }
        }

        public void MenuPrincipal_Load(object sender, EventArgs e)
        {
            conseguirRestricciones();
        }
        
        private void conseguirRestricciones()
        {
            SqlConnection conexion = new SqlConnection("Server=localhost\\SQLEXPRESS;Database=RentalCar;User id=user;Password=sql;Trusted_Connection=True;TrustServerCertificate=True");
            conexion.Open();
            String sql = "SELECT NombreOpcion FROM Restriccion WHERE nombre = '" + Global.loginUser + "'";
            SqlCommand cmd = new SqlCommand(sql, conexion);
            SqlDataReader reader = cmd.ExecuteReader();

            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    if (!reader.IsDBNull(0))
                    {
                        String restriccio = reader.GetString(0);
                        foreach (Control ctrl in pnlMenuVertical.Controls) {
                            if (ctrl is Button btn && restriccio.Contains(btn.Name)) {
                                btn.Visible = false;
                                panel1.Visible = false;
                                pictureBox2.Visible = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
