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
    public partial class FormContratos : Form
    {
        public FormContratos()
        {
            InitializeComponent();
        }

        private void contratoBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.contratoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);

        }

        private void FormContratos_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Contrato' Puede moverla o quitarla según sea necesario.
            this.contratoTableAdapter.Fill(this.rentalCarDataSet.Contrato);

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            contratoBindingSource.MoveFirst();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            contratoBindingSource.MovePrevious();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            contratoBindingSource.MoveNext();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            contratoBindingSource.MoveLast();
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            contratoBindingSource.AddNew();
        }

        private void btnEliminar_Click_1(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                contratoBindingSource.RemoveCurrent();
                contratoTableAdapter.Update(rentalCarDataSet.Contrato);
            }
        }

        private void picConfirmar_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.contratoBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        private void picDenegar_Click(object sender, EventArgs e)
        {
            contratoBindingSource.CancelEdit();
        }

        
    }
}
