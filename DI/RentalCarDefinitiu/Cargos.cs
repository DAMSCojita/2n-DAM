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
    public partial class FormCargos : Form
    {

        bool modoEdicion = false;

        public FormCargos()
        {
            InitializeComponent();
        }

        private void cargoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.cargoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        private void FormCargos_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Vehiculo' Puede moverla o quitarla según sea necesario.
            this.cargoTableAdapter.Fill(this.rentalCarDataSet.Cargo);
            verificaVisibilidad();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            cargoBindingSource.MoveFirst();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            cargoBindingSource.MovePrevious();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            cargoBindingSource.MoveNext();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            cargoBindingSource.MoveLast();
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            cargoBindingSource.AddNew();
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                cargoBindingSource.RemoveCurrent();
                cargoTableAdapter.Update(rentalCarDataSet.Cargo);
            }
        }

        private void picEditar_Click(object sender, EventArgs e)
        {
            modoEdicion = true;
            verificaVisibilidad();
        }

        private void picConfirmar_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.cargoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
            modoEdicion = false;
            verificaVisibilidad();
        }

        private void picDenegar_Click_1(object sender, EventArgs e)
        {
            cargoBindingSource.CancelEdit();
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
            if (!modoEdicion && cargoBindingSource.Current == null)
            {
                btnEliminar.Enabled = false;
            }
        }

        
    }
}
