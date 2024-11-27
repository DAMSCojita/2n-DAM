using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

// Declaram una clase independent per emprar variables globals en l'aplicació. Com pot ser el loginUser y un comptador específic per els intents. 
public static class Global { 
    public static String loginUser; 
    public static int contador = 0;
}

namespace RentalCarDefinitiu
{
    internal static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            InicioSesion iS = new InicioSesion(); // Declaram una instància de la clase de 'InicioSesion' per poder emprar-la.
            DialogResult res = iS.ShowDialog(); // Feim un DialogResult per emmagatzemar el resultat del inici (OK o Cancel).
            // Estructura de control 'if'.
            // Gestionarà l'inici de sessió. En cas de que el DialogResult sigui OK (lo que vol dir que l'inici és correcte) entrarà al formulari del menú principal.
            if (res == DialogResult.OK) {
                Application.Run(new MenuPrincipal());
            }
        }
    }
}
