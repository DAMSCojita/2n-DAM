using RentalCarDefinitiu.RentalCarDataSetTableAdapters;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics.Eventing.Reader;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace RentalCarDefinitiu
{
    public partial class FormClientes : Form
    {

        bool modoEdicion = false; // Cream una variable per controlar la edició en el formulari.

        public FormClientes()
        {
            InitializeComponent();
        }

        // Mètode que guarda automàticament els items.
        private void clienteBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.clienteBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);

        }

        // Mètode que s'executa quan el formulari es carrega.
        private void FormClientes_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Cliente' Puede moverla o quitarla según sea necesario.
            this.clienteTableAdapter.Fill(this.rentalCarDataSet.Cliente);
            verificaVisibilidad(); // Trucam al mètode 'verificaVisibilidad()'.
        }

        // Mètode per gestionar el picture de moure primer.
        private void pictureBox1_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveFirst();
        }

        // Mètode per gestionar el picture de moviment previ.
        private void pictureBox2_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MovePrevious();
        }

        // Mètode per gestionar el picture de moure següent.
        private void pictureBox3_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveNext();
        }

        // Mètode per gestionar el picture de moure últim.
        private void pictureBox4_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveLast();
        }

        // Mètode per gestionar el button d'afegir camps al DataGrid.
        private void btnAgregar_Click(object sender, EventArgs e)
        {
            clienteBindingSource.AddNew();
        }

        // Mètode per gestionar el button d'eliminar camps al DataGrid.
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            // Afegim un missatge per preguntar a l'usuari si està segur d'eliminar el registre.
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                clienteBindingSource.RemoveCurrent(); // Eliminem el registre actual.
                clienteTableAdapter.Update(rentalCarDataSet.Cliente); // Actualitzem la base de dades.
            }
        }

        // Mètode per gestionar el picture d'editar.
        private void picEditar_Click(object sender, EventArgs e)
        {
            modoEdicion = true;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Mètode per gestionar el picture de confirmar.
        // També validarà el NIF.
        private void picConfirmar_Click(object sender, EventArgs e)
        {

            this.Validate(); // Validem les dades del control abans.

            bool validado = false; // Cream una variable booleana que represente si està validat o no el NIF.
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE"; // Declaram una variable amb les lletres de control vàlides per als NIF.
            String DNI = txtDni.Text; // Ingresam el text ingresat en el camp d'entrada del DNI.
            String numero = DNI.Substring(0, 8); // Extraguem els 8 primers caràcters del DNI (la part numèrica).

            // Estructures de control 'if'.
            // Començarà comprovant si el DNI comença amb les lletres 'X', 'Y', 'Z'.
            if (DNI.Substring(0, 1).Equals("X", StringComparison.OrdinalIgnoreCase))
            {
                numero = "0" + DNI.Substring(1, 7); // Substitueim 'X' per '0' i mantenim la resta dels números.
            }
            else if (DNI.Substring(0, 1).Equals("Y", StringComparison.OrdinalIgnoreCase))
            {
                numero = "1" + DNI.Substring(1, 7); // Substitueim 'Y' per '1' i mantenim la resta dels números.
            }
            else if (DNI.Substring(0, 1).Equals("Z", StringComparison.OrdinalIgnoreCase))
            {
                numero = "2" + DNI.Substring(1, 7); // Substitueim 'Z' per '2' i mantenim la resta dels números.
            }

            int restoDivision = Int32.Parse(numero) % 23; // Convertim la part numèrica a enter guardant-lo en una variable i calculam el residu de dividir per 23.
            numero = letras.Substring(restoDivision, 1); // Obtenim la lletra corresponent al residu de la divisió.

            // Comparam la lletra calculada amb la lletra introduïda al NIF.
            if (numero.Equals(DNI.Substring(8)))
            {
                validado = true; // Si coincideixen, marca el NIF com a validat.
            }

            // En cas de que el NIF ha estat validat correctament...
            if (validado == true)
            {
                MessageBox.Show("NIF validado y introducido con éxito."); // Mostram un missatge informant que el NIF s'ha validat correctament.
                clienteBindingSource.EndEdit(); // Finalitzem l'edició del client actual a l'origen de dades.
                clienteTableAdapter.Update(rentalCarDataSet.Cliente); // Actualitzem la base de dades.
                modoEdicion = false; // Canvia el mode d'edició a fals.
                verificaVisibilidad(); // Actualitzem la visibilitat dels controls segons l'estat actual.
            } 
            else
            {
                MessageBox.Show("NIF no válido. Por favor, asegúrese de que lo ha puesto correctamente y vuelva a intentarlo.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Information); // En cas de que el NIF no sigui correcte també informam amb aquest missatge.
            }
        }

        // Mètode per gestionar el picture de denegar.
        private void picDenegar_Click(object sender, EventArgs e)
        {
            clienteBindingSource.CancelEdit(); // Cancel·lem el registre.
            modoEdicion = false;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        private void verificaVisibilidad()
        {
            // Bucles 'for-each'.
            // Per cada control en els panels, els habilitarà o deshabilitarà depenent de quin.
            foreach (Control con in pnlContenedor.Controls)
            {
                // Verifiquem si el control no es un label. 
                if (!(con is Label))
                {
                    con.Enabled = modoEdicion; // Habilitem o deshabilitem el control segons el valor del mode edició.
                }
            }
            foreach (Control con in pnlControles.Controls)
            {
                con.Enabled = !modoEdicion; // Habilitem o deshabilitem el control oposadament segons el valor del mode edició.
            }
            foreach (Control con in pnlVerificar.Controls)
            {
                con.Enabled = modoEdicion; // Habilitem o deshabilitem el control segons el valor del mode edició.
            }
            if (!modoEdicion && clienteBindingSource.Current == null)
            {
                btnEliminar.Enabled = false; // Deshabilitem el butó d'eliminar si no està en mode edició.
            }
        }

        
    }
}
