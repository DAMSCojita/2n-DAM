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

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection conexion = new SqlConnection("Server=localhost\\SQLEXPRESS;Database=RentalCar;User id=user;Password=sql;Trusted_Connection=True;TrustServerCertificate=True");
            conexion.Open();
            String sql = "SELECT * FROM Usuarios WHERE nombre = '" + textBox1.Text + "' AND contrasenya = '" + textBox2.Text + "' AND fechaDeBloqueo IS NULL;";
            SqlCommand cmd = new SqlCommand(sql, conexion);

            SqlDataReader reader = cmd.ExecuteReader();

            if (reader.HasRows) {
                DialogResult = DialogResult.OK;
                Global.loginUser = textBox1.Text;
                this.Close();
            } else {
                MessageBox.Show("Usuario o contraseña no reconocidos.");
                Global.contador = Global.contador + 1;
                if (Global.contador == 3) {
                    MessageBox.Show("Se han producido demasiados intentos para iniciar sesión. Se bloqueará la sesión.");
                    conexion.Close();
                    conexion.Open();
                    String sqlBloqueo = "UPDATE Usuarios SET fechaDeBloqueo = GETDATE() WHERE nombre = '" + textBox1.Text + "';";
                    SqlCommand cmdBloqueo = new SqlCommand(sqlBloqueo, conexion);
                    cmdBloqueo.ExecuteNonQuery();
                    DialogResult = DialogResult.Cancel;
                }
            }
        }
    }
}
