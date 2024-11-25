using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
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
            InicioSesion iS = new InicioSesion();
            DialogResult res = iS.ShowDialog();
            if (res == DialogResult.OK) {
                Application.Run(new MenuPrincipal());
            }
        }
    }
}
