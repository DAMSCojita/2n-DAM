using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;



namespace RentalCarDefinitiu
{
    public partial class InicioSesion : Form
    {
        public InicioSesion()
        {
            InitializeComponent();
        }

        // Mètode per gestionar el button d'entrar del registre.
        private void btnEntrar_Click(object sender, EventArgs e)
        {
            // Establim les interaccions amb la base de dades.
            SqlConnection conexion = new SqlConnection("Server=localhost\\SQLEXPRESS;Database=RentalCar;User id=user;Password=sql;Trusted_Connection=True;TrustServerCertificate=True");
            conexion.Open(); // Obrim la connexió.

            // Ens cream una variable que representa una query de SQL i feim la consulta necessària.
            // En aquest cas hem de seleccionar tot de la taula d'usuaris on el nom i la contrasenya coincideixin amb el que ha possat el usuari als textBoxs.
            String sql = "SELECT * FROM Usuarios WHERE nombre = '" + txtUsuario.Text + "' AND contrasenya = '" + txtContrasenya.Text + "' AND fechaDeBloqueo IS NULL;";

            SqlCommand cmd = new SqlCommand(sql, conexion); // Feim una variable per executar la query amb sa connexió.
            SqlDataReader reader = cmd.ExecuteReader(); // Cream un reader que s'encarrega de llegir explícitament l'execució.

            // Estructura de control 'if'.
            // En cas de que trobi l'usuari corresponent, el validarà.
            // En cas contrari, el programa donarà un numero d'intents i avisarà a l'usuari que no reconeix els camps que ha posat.
            if (reader.HasRows) {
                DialogResult = DialogResult.OK; // El DialogResult es marcarà com OK, el que vol dir que l'inici de sessió ha sigut correcte.
                Global.loginUser = txtUsuario.Text; // Empram la variable Global 'loginUser' i l'assignam lo que ha introduït l'usuari.
                this.Close(); // Tancam aquest formulari.
            } else {
                MessageBox.Show("Usuario o contraseña no reconocidos."); // Indicam que no es troba l'usuari o contrasenya en qüestió.
                Global.contador = Global.contador + 1; // Empram la variable Global 'contador' i incrementem un intent.
                
                // Estructura de control 'if'.
                // En cas de que l'usuari superi 3 intents i no es trobi l'usuari i/o contrasenya, bloqueará la sessió guardant la data en la que s'ha produït l'incidència ...
                if (Global.contador == 3) {
                    MessageBox.Show("Se han producido demasiados intentos para iniciar sesión. Se bloqueará la sesión."); // El programa avisa de que s'han produït massa intents i que la sessió es bloquetjarà.
                    conexion.Close(); // Tancam la connexió.
                    conexion.Open(); // La tornam a obrir. Per si de cas.
                    String sqlBloqueo = "UPDATE Usuarios SET fechaDeBloqueo = GETDATE() WHERE nombre = '" + txtUsuario.Text + "';"; // Feim un altre consulta actualitzan la data de bloquetj a la taula d'usuaris.
                    SqlCommand cmdBloqueo = new SqlCommand(sqlBloqueo, conexion); // Feim una variable per executar la query amb sa connexió.
                    cmdBloqueo.ExecuteNonQuery(); // Executa una instrucció i retornem el numero de files afectades.
                    DialogResult = DialogResult.Cancel; // Posam un Cancel al DialogResult. Açò vol dir que l'inici de sessió no ha sigut exitòs.
                }
            }
        }
    }
}
