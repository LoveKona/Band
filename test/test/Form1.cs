using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace test
{
    public partial class Form1 : Form
    {
        BandClass cal = new BandClass();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox1.Text = cal.GetToken();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show(cal.getFullAuthToken());
        }
    }
}
