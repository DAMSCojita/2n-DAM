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
    public partial class FormClientes : Form
    {
        public FormClientes()
        {
            InitializeComponent();
        }

        private void clienteBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.clienteBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);

        }

        private void FormClientes_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Cliente' Puede moverla o quitarla según sea necesario.
            this.clienteTableAdapter.Fill(this.rentalCarDataSet.Cliente);

        }

        private void pictureBox1_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveFirst();
        }

        private void pictureBox2_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MovePrevious();
        }

        private void pictureBox3_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveNext();
        }

        private void pictureBox4_Click_1(object sender, EventArgs e)
        {
            clienteBindingSource.MoveLast();
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            clienteBindingSource.AddNew();
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                clienteBindingSource.RemoveCurrent();
                clienteTableAdapter.Update(rentalCarDataSet.Cliente);
            }
        }

        private void picConfirmar_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.clienteBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        private void picDenegar_Click(object sender, EventArgs e)
        {
            clienteBindingSource.CancelEdit();
        }

        private void validaNIF()
        {
            String dni = txtDni.Text.Trim();

            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        }

        
    }
}
