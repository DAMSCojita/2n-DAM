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

        bool modoEdicion = false;
        public FormVehiculos()
        {
            InitializeComponent();
        }

        private void vehiculoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.vehiculoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

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
            verificaVisibilidad();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveFirst();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MovePrevious();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveNext();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.MoveLast();
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.AddNew();
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                vehiculoBindingSource.RemoveCurrent();
                vehiculoTableAdapter.Update(rentalCarDataSet.Vehiculo);
            }
        }

        private void picEditar_Click(object sender, EventArgs e)
        {
            modoEdicion = true;
            verificaVisibilidad();
        }

        private void picConfirmar_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.vehiculoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
            modoEdicion = false;
            verificaVisibilidad();
        }

        private void picDenegar_Click(object sender, EventArgs e)
        {
            vehiculoBindingSource.CancelEdit();
            modoEdicion = false;
            verificaVisibilidad();
        }

        private void verificaVisibilidad()
        {
            foreach (Control con in pnlContenedor.Controls)
            {
                if (!(con is Label))
                {
                    con.Enabled = modoEdicion;
                }
            }
            foreach (Control con in pnlControles.Controls)
            {
                con.Enabled = !modoEdicion;
            }
            foreach (Control con in pnlVerificar.Controls)
            {
                con.Enabled = modoEdicion;
            }
            if (!modoEdicion && vehiculoBindingSource.Current == null)
            {
                btnEliminar.Enabled = false;
            }
        }

        private void cmbTipologia_SelectedIndexChanged(object sender, EventArgs e)
        {
            modeloBindingSource.Filter = "Tipologia = '" + cmbTipologia.Text + "'";
        }

        private void cmbMarca_SelectedIndexChanged(object sender, EventArgs e)
        {
            modeloBindingSource.Filter = "Marca = '" + cmbMarca.Text + "' AND Tipologia = '" + cmbTipologia.Text + "'";
        }
    }
}
