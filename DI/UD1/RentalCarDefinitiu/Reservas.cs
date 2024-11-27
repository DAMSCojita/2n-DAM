using RentalCarDefinitiu.RentalCarDataSetTableAdapters;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RentalCarDefinitiu
{
    public partial class FormReservas : Form
    {

        bool modoEdicion = false; // Cream una variable per controlar la edició en el formulari.

        public FormReservas()
        {
            InitializeComponent();
        }

        // Mètode que guarda automàticament els items.
        private void reservaBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.reservaBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        // Mètode que s'executa quan el formulari es carrega.
        private void FormReservas_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Reserva' Puede moverla o quitarla según sea necesario.
            this.reservaTableAdapter.Fill(this.rentalCarDataSet.Reserva);
            verificaVisibilidad(); // Trucam al mètode 'verificaVisibilidad()'.
        }

        // Mètode per gestionar el picture de moure primer.
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveFirst();
        }

        // Mètode per gestionar el picture de moviment previ.
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MovePrevious();
        }

        // Mètode per gestionar el picture de moure següent.
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveNext();
        }

        // Mètode per gestionar el picture de moure últim.
        private void pictureBox4_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveLast();
        }

        // Mètode per gestionar el button d'afegir camps al DataGrid.
        private void btnAgregar_Click_1(object sender, EventArgs e)
        {
            reservaBindingSource.AddNew();
        }

        // Mètode per gestionar el button d'eliminar camps al DataGrid.
        private void btnEliminar_Click_1(object sender, EventArgs e)
        {
            // Afegim un missatge per preguntar a l'usuari si està segur d'eliminar el registre.
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                reservaBindingSource.RemoveCurrent(); // Eliminem el registre actual.
                reservaTableAdapter.Update(rentalCarDataSet.Reserva); // Actualitzem la base de dades.
            }
        }

        // Mètode per gestionar el picture d'editar.
        private void picEditar_Click(object sender, EventArgs e)
        {
            modoEdicion = true;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Mètode per gestionar el picture de confirmar.
        private void picConfirmar_Click_1(object sender, EventArgs e)
        {
            this.Validate(); // Validem les dades.
            this.reservaBindingSource.EndEdit(); // Apliquem les dades.
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet); // Actualitzem la base de dades.
            modoEdicion = true;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Mètode per gestionar el picture de denegar.
        private void picDenegar_Click_1(object sender, EventArgs e)
        {
            reservaBindingSource.CancelEdit(); // Cancel·lem el registre.
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
            if (!modoEdicion && reservaBindingSource.Current == null)
            {
                btnEliminar.Enabled = false; // Deshabilitem el butó d'eliminar si no està en mode edició.
            }
        }

    }
}
