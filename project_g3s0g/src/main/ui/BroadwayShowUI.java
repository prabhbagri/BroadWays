package ui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.BroadwayShow;
import model.BroadwayShowList;
import persistence.JsonReader;
import persistence.JsonWriter;

// Represents a GUI with a table and splash screen
public class BroadwayShowUI extends javax.swing.JFrame {

    private BroadwayShowList bsl;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // constructs a GUI with saving and loading
    public BroadwayShowUI() {
        this.bsl = new BroadwayShowList("My Broadway Show List");
        this.jsonWriter = new JsonWriter("./data/BroadwayShows.json");
        this.jsonReader = new JsonReader("./data/BroadwayShows.json");
        loadShows();
        initComponents();
    }

    private void init0() {
        panelShows = new javax.swing.JPanel();
        jscrollpane1 = new javax.swing.JScrollPane();
        tblShows = new javax.swing.JTable();
        btnAddShow = new javax.swing.JButton();
        btnLoadShows = new javax.swing.JButton();
        btnSaveShows = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        panelShow = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtRating = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jscrollpane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        panelShowLayout = new javax.swing.GroupLayout(panelShow);
        panelShow.setLayout(panelShowLayout);
        tblModel = new DefaultTableModel();
    }

    // EFFECTS: initializes control components
    private void init1() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Broadway Shows");
        setResizable(false);
        panelShows.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Shows"));

        tblShows.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"Title", "Description", "Rating"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, true};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jscrollpane1.setViewportView(tblShows);

    }

    // EFFECTS: initializes control components
    private void init11() {
        btnAddShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddShow.setText("Add Show");
        btnAddShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShowActionPerformed(evt);
            }
        });

        btnLoadShows.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoadShows.setText("Load");
        btnLoadShows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadShowsActionPerformed(evt);
            }
        });

        btnSaveShows.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveShows.setText("Save");
        btnSaveShows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveShowsActionPerformed(evt);
            }
        });
    }

    // EFFECTS: initializes control components
    private void init12() {

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
    }


    // EFFECTS: initializes control components
    private void init2() {
        panelShowsLayout = new javax.swing.GroupLayout(panelShows);
        panelShows.setLayout(panelShowsLayout);
        panelShowsLayout.setHorizontalGroup(
                panelShowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShowsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelShowsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelShowsLayout.createSequentialGroup()
                                                .addComponent(btnLoadShows, -2, 101, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddShow, -2, 103, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSaveShows, -2, 97, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnClose, -2, 95, -2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnRemove, -2, 95, -2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jscrollpane1, -1, 752, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    // EFFECTS: initializes control components
    private void init3() {
        panelShowsLayout.setVerticalGroup(
                panelShowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShowsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jscrollpane1, -2, 118, -2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelShowsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelShowsLayout.createSequentialGroup()
                                                .addGroup(panelShowsLayout
                                                        .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(btnLoadShows, GroupLayout.Alignment.LEADING,
                                                                -1, 42, 32767)
                                                        .addComponent(btnSaveShows, GroupLayout.Alignment.LEADING,
                                                                -2, 41, -2)
                                                        .addComponent(btnClose, GroupLayout.Alignment.LEADING,
                                                                -2, 40, -2)
                                                        .addComponent(btnRemove, GroupLayout.Alignment.LEADING,
                                                                -2, 40, -2))
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(panelShowsLayout.createSequentialGroup()
                                                .addComponent(btnAddShow, -2, 41, -2)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
    }

    // EFFECTS: initializes control components
    private void init4() {
        panelShow.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Show"));

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel1.setText("Title:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel2.setText("Description:");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel3.setText("Rating:");

        txtTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

    }

    // EFFECTS: initializes control components
    private void init41() {
        txtRating.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRating.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRatingKeyPressed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblMsg.setText("Message");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jscrollpane2.setViewportView(txtDescription);
    }

    // EFFECTS: initializes control components
    private void init5() {
        panelShowLayout.setHorizontalGroup(panelShowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelShowLayout.createSequentialGroup()
                        .addGroup(panelShowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelShowLayout.createSequentialGroup()
                                        .addGap(28, 28, 28).addGroup(panelShowLayout
                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jlabel2, -2, 83, -2)
                                                .addComponent(jlabel1, -2, 101, -2))
                                        .addGap(18, 18, 18).addGroup(panelShowLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtTitle)
                                                .addComponent(jscrollpane2, -1, 333, 32767)))
                                .addGroup(panelShowLayout.createSequentialGroup()
                                        .addGap(82, 82, 82).addComponent(jlabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(panelShowLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(panelShowLayout.createSequentialGroup()
                                                        .addComponent(txtRating, -2, 59, -2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblMsg))
                                                .addComponent(btnAdd, -2, 87, -2))))
                        .addContainerGap(-1, 32767)));
    }

    // EFFECTS: initializes control components
    private void init6() {
        panelShowLayout.setVerticalGroup(
                panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShowLayout.createSequentialGroup().addContainerGap()
                                .addGroup(panelShowLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlabel1, -2, 33, -2)
                                        .addGroup(panelShowLayout.createSequentialGroup().addGap(7, 7, 7)
                                                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        31, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlabel2, -2, 22, -2)
                                        .addComponent(jscrollpane2, -2, -1, -2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE)
                                .addGroup(panelShowLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3).addComponent(txtRating, -2, 32, -2)
                                        .addComponent(lblMsg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, -2, 36, -2).addContainerGap()));
    }

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

    // EFFECTS: initializes control components
    private void init7() {
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelShows, -1, -1, Short.MAX_VALUE)
                                        .addComponent(panelShow, -1, -1, Short.MAX_VALUE)))
        );
    }

    // EFFECTS: initializes control components
    private void init8() {
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelShows, -2, javax.swing.GroupLayout.DEFAULT_SIZE, -2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelShow, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
        );


    }

    // EFFECTS: initializes control components
    private void initComponents() {
        init0();
        init1();
        init11();
        init12();
        init2();
        init3();
        init4();
        init41();
        init5();
        init6();
        init7();
        init8();
        pack();
        tblModel = (DefaultTableModel) tblShows.getModel();
    }

    // EFFECTS: click event for "add show" button
    private void btnAddShowActionPerformed(java.awt.event.ActionEvent evt) {
        panelShow.setVisible(true);
    }

    // EFFECTS: action event for text title
    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {
    }

    // EFFECTS: adds show to user's list table
    private void addShow(String title, String desc, int rating) {
        int size = this.bsl.getSize();
        BroadwayShow show = this.bsl.getIndex(--size);
        lastId = show.getId();
        this.bsl.addShow(new BroadwayShow(++lastId, title, desc, rating));
    }

    // EFFECTS: action event for button "add", prompting row added to table
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String title = txtTitle.getText();
        String desc = txtDescription.getText();
        String rating = txtRating.getText();
        int intRating = Integer.parseInt(rating);
        String strRating = displayStars(intRating);
        if (title.equals("") || desc.equals("") || rating.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {
            addShow(title, desc, intRating);
            String[] data = {title, desc, strRating};
            //  DefaultTableModel tblModel = (DefaultTableModel) tblShows.getModel();
            tblModel.addRow(data);
            JOptionPane.showMessageDialog(this, "Broadway show added successfully");
            txtTitle.setText("");
            txtDescription.setText("");
            txtRating.setText("");
        }
    }

    // EFFECTS: key pressed event to validate integer for rating
    private void txtRatingKeyPressed(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c > '0' && c <= '5') {
            //can't able to enter text field if enter char is not number
            txtRating.setEditable(true);
            txtRating.setText("");
        } else {
            txtRating.setEditable(false);
            lblMsg.setText("Enter only numeric digits(1 - 5)");
        }
    }

    // EFFECTS: load shows from file
    private void loadShows() {
        try {
            bsl = jsonReader.read();
            //System.out.println(this.bsl.getSize());
            if (this.bsl.getSize() <= 0) {
                System.out.println("No shows in list! Please add a Broadway show.");
            } else {
                this.jsonReader = new JsonReader("./data/BroadwayShows.json");
                this.bsl = this.jsonReader.read();
                System.out.println("Loaded " + this.bsl.getName() + " from " + "./data/BroadwayShows.json");
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: ./data/BroadwayShows.json");
        }
    }

    // EFFECTS: converts stars into characters
    private String displayStars(int rating) {
        StringBuilder sb1 = new
                StringBuilder();
        for (int i = 0; i < rating; i++) {
            if (i >= 5) {
                break;
            }
            sb1.append("*"); //print stars instead of a number
        }
        return sb1.toString();
    }

    // EFFECTS: prints all the shows in list (inc current ones)
    private void printShows() {
        String name = this.bsl.getName();
        List<BroadwayShow> lst = bsl.getShows();

        for (BroadwayShow t : lst) {
            System.out.println(t.getId() + "\t" + t.getTitle() + "\t\t\t\t" + t.getDescription()
                    + "\t\t\t\t" + t.getRating());

            String rating = displayStars(t.getRating());

            String[] data = {t.getTitle(), t.getDescription(), rating};
            DefaultTableModel tblModel = (DefaultTableModel) tblShows.getModel();

            tblModel.addRow(data);

        }
    }

    // EFFECTS: action event for "Load" button
    private void btnLoadShowsActionPerformed(java.awt.event.ActionEvent evt) {
        int size = bsl.getSize();
        loadShows();
        printShows();
        btnLoadShows.setVisible(false);
        btnAddShow.setVisible(true);
        btnSaveShows.setVisible(true);
        btnClose.setVisible(true);
        btnRemove.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: saves shows to file
    private void saveShows() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.bsl);
            this.jsonWriter.close();
            JOptionPane.showMessageDialog(this,
                    "Saved " + this.bsl.getName() + " to " + "./data/BroadwayShows.json");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: ./data/BroadwayShows.json");
        }

    }

    // EFFECTS: action event for "Save" button
    private void btnSaveShowsActionPerformed(java.awt.event.ActionEvent evt) {
        saveShows();
    }

    // EFFECTS: action event for "Close" button
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        bsl.closeAction();
        System.exit(0);
    }

    // EFFECTS: action event for "Remove" button
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblShows.getSelectedRow() != -1) {
            int row = tblShows.getSelectedRow();
            // remove selected row from the model
            tblModel.removeRow(tblShows.getSelectedRow());
            bsl.removeShow(row);
            JOptionPane.showMessageDialog(null, "Selected row removed successfully");
        }
    }

    // EFFECTS: main function to run and execute ui
    public static void main(String[] args) {
        try {
            new SplashScreen();
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BroadwayShowUI().setVisible(true);
                panelShow.setVisible(false);
                btnAddShow.setVisible(false);
                btnSaveShows.setVisible(false);
                btnClose.setVisible(false);
                btnRemove.setVisible(false);
            }
        });
    }

    // EFFECTS: declare variables
    private javax.swing.GroupLayout panelShowsLayout;
    private javax.swing.GroupLayout panelShowLayout;
    private javax.swing.JButton btnAdd;
    private static javax.swing.JButton btnAddShow;
    private javax.swing.JButton btnLoadShows;
    private static javax.swing.JButton btnSaveShows;
    private static javax.swing.JButton btnClose;
    private static javax.swing.JButton btnRemove;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JScrollPane jscrollpane1;
    private javax.swing.JScrollPane jscrollpane2;
    private javax.swing.JLabel lblMsg;
    private static javax.swing.JPanel panelShow;
    private javax.swing.JPanel panelShows;
    private javax.swing.JTable tblShows;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtRating;
    private javax.swing.JTextField txtTitle;
    private DefaultTableModel tblModel;
    private static int lastId;
}
