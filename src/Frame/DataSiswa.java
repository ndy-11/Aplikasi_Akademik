/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataSiswa.java
 *
 * Created on Feb 5, 2014, 4:39:08 AM
 */

package Frame;

import Connection.Koneksi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author USER
 */
public class DataSiswa extends javax.swing.JFrame {
int kode;
Blob blob;
    private BufferedImage image;
    /** Creates new form DataSiswa */
    public DataSiswa() {
        initComponents();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();
    setLocation(
    (screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 2);
//    setExtendedState(MAXIMIZED_BOTH);

    try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String SQL = "select kode from enabled";
            ResultSet RS=st.executeQuery(SQL);
            while(RS.next())
                {
                    kode=RS.getInt(1);
                }
           if (kode==1)
                {
                    logintambah();
                }
          else if(kode==6)
                {
                    loginhapus();
                }
          else if(kode==7)
                {
                    loginedit();
                }
        }
        catch (SQLException e){}

    }

    void logintambah()
    {
        simpan.setEnabled(true);
        batal.setEnabled(true);
        back.setEnabled(true);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        carifoto.setEnabled(true);
    }

    void loginhapus()
    {
        simpan.setEnabled(false);
        batal.setEnabled(true);
        back.setEnabled(true);
        edit.setEnabled(false);
        hapus.setEnabled(true);
        carifoto.setEnabled(false);
    }

    void loginedit()
    {
        simpan.setEnabled(false);
        batal.setEnabled(true);
        back.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(false);
        carifoto.setEnabled(true);
    }

    void bersih()
    {
        nis.setText("");
        nama.setText("");
        alamat.setText("");
        tptlhir.setText("Tempat Lahir");
        tgllhir.setText("YYYY-MM-DD");
        ayah.setText("");
        kerjaayah.setSelectedIndex(0);
        ibu.setText("");
        kerjaibu.setSelectedIndex(0);
        alamatwali.setText("");
        telp.setText("");
        fotoo.setImage(null);
        txtfoto.setText("");
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ayah = new javax.swing.JTextField();
        tptlhir = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        nis = new javax.swing.JTextField();
        alamatwali = new javax.swing.JTextField();
        ibu = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        tgllhir = new javax.swing.JTextField();
        kerjaayah = new javax.swing.JComboBox();
        kerjaibu = new javax.swing.JComboBox();
        carifoto = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        fotoo = new Frame.PanelGambar();
        fotooo = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        txtfoto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Siswa");
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("NIS");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("Tanggal Lahir");

        jLabel5.setText("Ayah-Pekerjaan");

        jLabel6.setText("Ibu-Pekerjaan");

        jLabel7.setText("Alamat Wali ");

        jLabel8.setText("Telepon");

        ayah.setText(" ");
        ayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayahActionPerformed(evt);
            }
        });

        tptlhir.setText(" Tempat Lahir");

        alamat.setText(" ");
        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        nama.setText(" ");

        nis.setText(" ");
        nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisActionPerformed(evt);
            }
        });
        nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nisKeyPressed(evt);
            }
        });

        alamatwali.setText(" ");

        ibu.setText(" ");

        telp.setText(" ");

        tgllhir.setText("YYYY-MM-DD");

        kerjaayah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "PNS", "Karyawan Swasta", "Wiraswasta", "TNI/POLRI", "Tidak Bekerja", "Almarhum" }));

        kerjaibu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "PNS", "Karyawan Swasta", "Wiraswata", "Tidak Bekerja", "Almarhumah" }));

        carifoto.setBackground(new java.awt.Color(0, 204, 255));
        carifoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Finddata toolbar.png"))); // NOI18N
        carifoto.setText("Cari Foto");
        carifoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carifotoActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));

        edit.setBackground(new java.awt.Color(0, 204, 255));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit toolbar.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        edit.setBounds(190, 30, 130, 40);
        jDesktopPane1.add(edit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        hapus.setBackground(new java.awt.Color(0, 204, 255));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete toolbar.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        hapus.setBounds(590, 30, 130, 40);
        jDesktopPane1.add(hapus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        simpan.setBackground(new java.awt.Color(51, 204, 255));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        simpan.setBounds(10, 30, 120, 40);
        jDesktopPane1.add(simpan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        batal.setBackground(new java.awt.Color(0, 204, 255));
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_32.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        batal.setBounds(400, 30, 120, 40);
        jDesktopPane1.add(batal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fotoo.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout fotooLayout = new javax.swing.GroupLayout(fotoo);
        fotoo.setLayout(fotooLayout);
        fotooLayout.setHorizontalGroup(
            fotooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotooo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        fotooLayout.setVerticalGroup(
            fotooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotooo, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(foto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tptlhir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tgllhir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(147, 147, 147))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ibu, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kerjaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(alamatwali, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addGap(147, 147, 147))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kerjaayah, 0, 141, Short.MAX_VALUE)))
                                .addGap(49, 49, 49))
                            .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fotoo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carifoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtfoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {alamatwali, ayah, ibu, telp, tptlhir});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {kerjaayah, kerjaibu, tgllhir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tgllhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(tptlhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(kerjaayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kerjaibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alamatwali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(txtfoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carifoto))
                    .addComponent(fotoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carifotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carifotoActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
        File file=chooser.getSelectedFile();
        try {
            image = ImageIO.read(file);
            fotoo.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtfoto.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_carifotoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new MenuUtama().setVisible(true);
}//GEN-LAST:event_backActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
                {
                File fileGambar = new File(txtfoto.getText());
                FileInputStream fis = new FileInputStream(fileGambar);
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Akademik", "root", "");
                String query = "insert into siswa values(?,?,?,?,?,?)";
                PreparedStatement prepare = koneksi.prepareStatement(query);

                prepare.setString(1,nis.getText());
                prepare.setString(2,nama.getText());
                prepare.setString(3,alamat.getText());
                prepare.setString(4,tptlhir.getText());
                prepare.setString(5,tgllhir.getText());
                prepare.setBinaryStream(6, new FileInputStream(txtfoto.getText()), new File(txtfoto.getText()).length());
                prepare.executeUpdate();

                Koneksi objkoneksi = new Koneksi();
                Connection con =objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "insert into wali (id_wali, NIS, Ayah, KerjaAyah, Ibu, KerjaIbu, Alamat, Telepon)"
                    + "values ('"+nis.getText()+1+"','"+nis.getText()+"','"+ayah.getText()+"'"
                    + ",'"+kerjaayah.getSelectedItem()+"','"+ibu.getText()+"','"+kerjaibu.getSelectedItem()+"','"+alamatwali.getText()+"','"+telp.getText()+"')";
                int row =st.executeUpdate(sql);

                JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan ke dalam database","Pesan",JOptionPane.INFORMATION_MESSAGE);
                
                }
                catch(Exception ex)
                {
                JOptionPane.showMessageDialog(null,"Data gagal ditambahkan ke dalam database","Pesan",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(ex);
                }
        bersih();
}//GEN-LAST:event_simpanActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try
                {
                Koneksi objkoneksi = new Koneksi();
                Connection con =objkoneksi.bukakoneksi();
                Statement st = con.createStatement();

                String sql = "update siswa set nama='"+nama.getText()+"', "
                    + "alamat = '"+alamat.getText()+"',"
                    + "TempatLahir = '"+tptlhir.getText()+"',"
                    + "TanggalLahir = '"+tgllhir.getText()+"'"
                    + "where nis ='" +nis.getText()+"'";
                st.executeUpdate(sql);
                String sql2 = "update wali set ayah='"+ayah.getText()+"', "
                    + "KerjaAyah = '"+kerjaayah.getSelectedItem()+"',"
                    + "Ibu = '"+ibu.getText()+"',"
                    + "KerjaIbu = '"+kerjaibu.getSelectedItem()+"',"
                    + "Alamat = '"+alamatwali.getText()+"',"
                    + "Telepon = '"+telp.getText()+"'"
                    + "where nis ='" +nis.getText()+"'";
                int row =st.executeUpdate(sql2);
                if (row==1)
                {
                    JOptionPane.showMessageDialog(null,"Data sudah diupdate","informasi",JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Data gagal diupdate","Pesan",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(ex);
                }
            bersih();
    }//GEN-LAST:event_editActionPerformed

    private void nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisActionPerformed

    }//GEN-LAST:event_nisActionPerformed

    private void nisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nisKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)

        {
                int vblob;
                ImageIcon gambar;
                try
                {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Akademik", "root", "");
                Statement state = koneksi.createStatement();
                String query = "select *from siswa where NIS = '"+nis.getText()+"'";
                ResultSet rs = state.executeQuery(query);
                if(rs.next())
                {
                    nama.setText(rs.getString(2));
                    alamat.setText(rs.getString(3));
                    tptlhir.setText(rs.getString(4));
                    tgllhir.setText(rs.getString(5));


                        
                }

                String query2 = "select * from wali where NIS = '"+nis.getText()+"'";
                ResultSet rs2 = state.executeQuery(query2);
                if(rs2.next())
                {
                    ayah.setText(rs2.getString(3));
                    kerjaayah.setSelectedItem(rs2.getString(4));
                    ibu.setText(rs2.getString(5));
                    kerjaibu.setSelectedItem(rs2.getString(6));
                    alamatwali.setText(rs2.getString(7));
                    telp.setText(rs2.getString(8));

                    //Menampilkan gambar dari database
//                    blob = rs.getBlob(6);
//                    vblob = (int) blob.length();
//                    gambar = new ImageIcon(blob.getBytes(1,vblob));
//                    tampilfoto.setIcon(gambar);

                    nis.setEditable(false);
                    fotoo.setBackground(Color.white);
                    carifoto.setEnabled(false);
                    txtfoto.setEditable(false);
                    
                }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
        }
    }//GEN-LAST:event_nisKeyPressed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        bersih();
    }//GEN-LAST:event_batalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "delete from siswa where nis= '"+nis.getText()+"'";
            
            String sql2 = "delete from wali where NIS= '"+nis.getText()+"'";
            
            String sql3 = "delete from nilaiun where NIS= '"+nis.getText()+"'";
            
            String sql4 = "delete from rapot where NIS= '"+nis.getText()+"'";

            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
            int row = st.executeUpdate(sql4);
            if (row ==1)
            {
                JOptionPane.showMessageDialog(null,"data sudah dihapus dari database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }}
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "data tidak dihapus"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
    }//GEN-LAST:event_hapusActionPerformed

    private void ayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ayahActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField alamatwali;
    private javax.swing.JTextField ayah;
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JButton carifoto;
    private javax.swing.JButton edit;
    private javax.swing.JLabel foto;
    private Frame.PanelGambar fotoo;
    private javax.swing.JLabel fotooo;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField ibu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox kerjaayah;
    private javax.swing.JComboBox kerjaibu;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField telp;
    private javax.swing.JTextField tgllhir;
    private javax.swing.JTextField tptlhir;
    private javax.swing.JTextField txtfoto;
    // End of variables declaration//GEN-END:variables

}
