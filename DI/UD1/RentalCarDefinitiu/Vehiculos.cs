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
    public partial class FormVehiculos : Form
    {

        bool modoEdicion = false; // Cream una variable per controlar la edició en el formulari.
        public FormVehiculos()
        {
            InitializeComponent();
        }

        // Mètode que guarda automàticament els items.
        private void vehiculoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.vehiculoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        // Mètode que s'executa quan el formulari es carrega.
        private void FormVehiculos_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Modelo' Puede moverla o quitarla según sea necesario.
            this.modeloTableAdapter.Fill(this.rentalCarDataSet.Modelo);
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.vista_marca' Puede moverla o quitarla según sea necesario.
            this.vista_marcaTableAdapter.Fill(this.rentalCarDataSet.vista_marca);
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.vista_tipologia' Puede moverla o quitarla según sea necesario.
            this.vista_tipologiaTableAdapter.Fill(this.rentalCarDataSet.vista_tipologia);
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Vehiculo' Puede moverla o quitarla según sea necesario.
            this.vehiculoTableAdapter.Fill(this.rentalCarDataSet.Vehiculo);
            verificaVisibilidad(); // Trucam al mètode 'verificaVisibilidad()'.
        }

        // Mètode per gestionar el picture de moure primer.
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveFirst();
        }

        // Mètode per gestionar el picture de moviment previ.
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MovePrevious();
        }

        // Mètode per gestionar el picture de moure següent.
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveNext();
        }

        // Mètode per gestionar el picture de moure últim.
        private void pictureBox4_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveLast();
        }

        // Mètode per gestionar el button d'afegir camps al DataGrid.
        private void btnAgregar_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.AddNew();
        }

        // Mètode per gestionar el button d'eliminar camps al DataGrid.
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            // Afegim un missatge per preguntar a l'usuari si està segur d'eliminar el registre.
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                vehiculoBindingSource.RemoveCurrent(); // Eliminem el registre actual.
                vehiculoTableAdapter.Update(rentalCarDataSet.Vehiculo); // Actualitzem la base de dades.
            }
        }

        // Mètode per gestionar el picture d'editar.
        private void picEditar_Click(object sender, EventArgs e)
        {
            modoEdicion = true;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Mètode per gestionar el picture de confirmar.
        private void picConfirmar_Click(object sender, EventArgs e)
        {
            this.Validate(); // Validem les dades.
            this.vehiculoBindingSource.EndEdit(); // Apliquem les dades.
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet); // Actualitzem la base de dades.
            modoEdicion = false;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Mètode per gestionar el picture de denegar.
        private void picDenegar_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.CancelEdit(); // Cancel·lem el registre.
            modoEdicion = false;
            verificaVisibilidad(); // Trucam al mètode per verificar la visibilidad.
        }

        // Cream un mètode per verificar la visibilitat dels controls (mode edició).
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
            if (!modoEdicion && vehiculoBindingSource.Current == null)
            {
                btnEliminar.Enabled = false; // Deshabilitem el butó d'eliminar si no està en mode edició.
            }
        }

        // Mètode que gestiona el event de selecció del combo de Tipologia.
        private void cmbTipologia_SelectedIndexChanged(object sender, EventArgs e)
        {
            modeloBindingSource.Filter = "Tipologia = '" + cmbTipologia.Text + "'"; // Apliquem un filtre a l'origen de dades 'modeloBindingSource' per mostrar només els registres on la columna 'Tipologia' coincideixi amb el text seleccionat a 'cmbTipologia'.
        }

        // Mètode que gestiona el event de selecció del combo de Marca.
        private void cmbMarca_SelectedIndexChanged(object sender, EventArgs e)
        {
            modeloBindingSource.Filter = "Marca = '" + cmbMarca.Text + "' AND Tipologia = '" + cmbTipologia.Text + "'";
            // Apliquem un filtre més específic a l'origen de dades 'modeloBindingSource', mostrant només els registres on:
            // 1. La columna 'Marca' coincideix amb el text seleccionat a 'cmbMarca'.
            // 2. La columna 'Tipologia' coincideix amb el text seleccionat a 'cmbTipologia'.
        }
    }
}
