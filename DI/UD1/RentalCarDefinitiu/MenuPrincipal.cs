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

        // Mètode per gestionar el button de tancar.
        private void btnCerrar_Click(object sender, EventArgs e)
        {
            Application.Exit(); // Sortim del programa quan l'usuari pitgi aquest button de tancar.
        }

        // Mètode per gestionar el button de maximitzar.
        private void btnMaximizar_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Maximized; // Posam l'estat del formulari en maximitzat.
            btnMaximizar.Visible = false; // Feim que el button no sigui visible (ja que no tendria sentit que ho sigui quan el pitgem).
            btnRestaura.Visible = true; // Feim que el button de restauració de la finestra es possi visible.
        }

        // Mètode per gestionar el button de restauració.
        private void btnRestaura_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Normal; // Posam l'estat del formulari com estava de normal.
            btnRestaura.Visible = false; // Feim que el button mateix no sigui visible.
            btnMaximizar.Visible = true; // Feim que el button de maximitzar de la finestra es possi visible.
        }

        // Mètode per gestionar el button de minimitzar.
        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized; // Posam l'estat del formulari en minimitzat.
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
        
        // Mètode per gestionar el button de càrrecs.
        private void btnCargos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormCargos()); // Obrim el formulari de càrrecs.
        }

        // Mètode per gestionar el button de clients.
        private void btnClientes_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormClientes()); // Obrim el formulari de clients.
        }

        // Mètode per gestionar el button de contractes.
        private void btnContratos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormContratos()); // Obrim el formulari de contractes.
        }

        // Mètode per gestionar el button de reservas.
        private void btnReservas_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormReservas()); // Obrim el formulari de reservas.
        }

        // Mètode per gestionar el button de vehícles.
        private void btnVehiculos_Click(object sender, EventArgs e)
        {
            AbrirFormHijo(new FormVehiculos()); // Obrim el formulari de vehícles.
        }

        // Mètode per gestionar l'altre button de sortir (davall a l'esquerra).
        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit(); // Sortim del programa quan l'usuari pitgi aquest button de tancar.
        }

        private int clickX, clickY; // Declaram dues variables per emmagatzemar les coordenades X i Y.

        // Mètode per gestionar l'event que s'executa quan el mouse es mou sota el panell superior.
        private void pnlTitulo_MouseMove(object sender, MouseEventArgs e)
        {
            // Estructura de control 'if'.
            // Comprovará si el button esquerrà del mouse NO està presionat.
            // En cas contrari, calcularà el nou valor de cada posició. 
            if (e.Button != MouseButtons.Left) {
                clickX = e.X; // Guardem la coordenada X actual.
                clickY = e.Y; // Guardem la coordenada Y actual.
            } else {
                this.Left = this.Left + (e.X - clickX); // Calculem el nou valor de la posició horizontal (esquerra) de la finestra i el actualitzem.
                this.Top = this.Top + (e.Y - clickY); // Calculem el nou valor de la posició vertical (superior) de la finestra i el actualitzem.
            }
        }

        // Mètode que s'executa quan el menú principal es carrega.
        public void MenuPrincipal_Load(object sender, EventArgs e)
        {
            conseguirRestricciones(); // Trucam al mètode 'conseguirRestricciones()' per amagar les opcions que no estiguin disponibles per el tipus d'usuari que hagi entrat.
        }
        
        // Mètode per amagar les opcions del menú depenent del usuari que entri.
        private void conseguirRestricciones()
        {
            // Establim les interaccions amb la base de dades.
            SqlConnection conexion = new SqlConnection("Server=localhost\\SQLEXPRESS;Database=RentalCar;User id=user;Password=sql;Trusted_Connection=True;TrustServerCertificate=True"); // Declaram la connexió especificant l'ubicació del servidor, nom base de dades, usuari, contrasenya, etc...
            conexion.Open(); // Obrim la connexió.

            // Ens cream una variable que representa una query de SQL i feim la consulta necessària.
            // En aquest cas hem de seleccionar la columna de 'NombreOpcion' de la base de dades i el nom d'usuari pertinent.
            String sql = "SELECT NombreOpcion FROM Restriccion WHERE nombre = '" + Global.loginUser + "'"; 

            SqlCommand cmd = new SqlCommand(sql, conexion); // Feim una variable per executar la query amb sa connexió.
            SqlDataReader reader = cmd.ExecuteReader(); // Cream un reader que s'encarrega de llegir explícitament l'execució.

            // Estructura de control 'if'.
            // En cas de que hagi trobat columnes.
            if (reader.HasRows)
            {
                // Mentre el reader estigui llegint.
                while (reader.Read())
                {
                    // En cas de que hi hagi informació en la base de dades.
                    if (!reader.IsDBNull(0))
                    {
                        String restriccio = reader.GetString(0); // Declaram una variable que representi la restricció aplicada i la agafam des reader (posició 0).
                        // Estructura de control 'switch'.
                        // Gestionará la variable 'restriccio', és a dir, la variable que conté el nom de la opció a amagar.
                        switch (restriccio)
                        {
                            // En cas de que a la base de dades indiqui que la opció a amagar es "Cargos", amagará el button, panel i l'imatge.
                            case "Cargos":
                                // Amagam les opcions (tenim en compte si es un button, panel o lo que sigui que volguem amagar).
                                btnCargos.Visible = false;
                                pnlCargos.Visible = false;
                                picCargos.Visible = false;
                                break;
                            // En cas de que a la base de dades indiqui que la opció a amagar es "Clientes", amagará el button, panel i l'imatge.
                            case "Clientes":
                                // Amagam les opcions.
                                btnClientes.Visible = false;
                                pnlClientes.Visible = false;
                                picClientes.Visible = false;
                                break;
                            // En cas de que a la base de dades indiqui que la opció a amagar es "Contratos", amagará el button, panel i l'imatge.
                            case "Contratos":
                                // Amagam les opcions.
                                btnContratos.Visible = false;
                                pnlContratos.Visible = false;
                                picContratos.Visible = false;
                                break;
                            // En cas de que a la base de dades indiqui que la opció a amagar es "Reservas", amagará el button, panel i l'imatge.
                            case "Reservas":
                                // Amagam les opcions.
                                btnReservas.Visible = false;
                                pnlReservas.Visible = false;
                                picReservas.Visible = false;
                                break;
                            // En cas de que a la base de dades indiqui que la opció a amagar es "Vehículos", amagará el button, panel i l'imatge.
                            case "Vehículos":
                                // Amagam les opcions.
                                btnVehiculos.Visible = false;
                                pnlVehiculos.Visible = false;
                                picVehiculos.Visible = false;
                                break;
                        }
                    }
                }
            }
        }
    }
}
