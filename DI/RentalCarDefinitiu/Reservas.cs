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
        public FormReservas()
        {
            InitializeComponent();
        }

        private void reservaBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.reservaBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);

        }

        private void FormReservas_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'rentalCarDataSet.Reserva' Puede moverla o quitarla según sea necesario.
            this.reservaTableAdapter.Fill(this.rentalCarDataSet.Reserva);

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveFirst();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MovePrevious();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveNext();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            reservaBindingSource.MoveLast();
        }

        private void btnAgregar_Click_1(object sender, EventArgs e)
        {
            reservaBindingSource.AddNew();
        }

        private void btnEliminar_Click_1(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Desea eliminar el registro que acaba de introducir?", "Eliminar Registro", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                reservaBindingSource.RemoveCurrent();
                reservaTableAdapter.Update(rentalCarDataSet.Reserva);
            }
        }

        private void picConfirmar_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.reservaBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.rentalCarDataSet);
        }

        private void picDenegar_Click_1(object sender, EventArgs e)
        {
            reservaBindingSource.CancelEdit();
        }


    }
}
