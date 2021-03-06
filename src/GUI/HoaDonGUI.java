/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import BUS.outBill;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import DTO.HoaDonDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Shadow
 */
public class HoaDonGUI extends JPanel{
    private ChiTietHDBUS ctBUS = new ChiTietHDBUS(1);
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private JTable tbl;
    private JTextField txtMaHD,txtMaKH,txtMaNV,txtNgayHD,txtTongTien;
    private JTextField txtMinPrice,txtMaxPrice;
    private DefaultTableModel model;
    private Choice yearChoice,monthChoice;
    private int DEFALUT_WIDTH;
    private JTextField txtMaSP;
    private JLabel btnEdit;
    private JLabel btnDelete;
    private JLabel btnView;
    private JLabel btnBill;
    private JLabel btnConfirm;
    private JLabel btnBack;
    private JDateChooser dateChoice;
    
    public HoaDonGUI(int width)
    {
        DEFALUT_WIDTH = width;
        init();

    }
    public void init()
    {        
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
       
/*********************** PH???N VIEW TH??NG TIN *****************************/
        JPanel itemView = new JPanel(null);
        itemView.setBackground(null);
        itemView.setBounds(new Rectangle(30,40,this.DEFALUT_WIDTH - 200,120));

        JLabel lbMaHD = new JLabel("M?? HD");
        lbMaHD.setFont(font0);
        lbMaHD.setBounds(0,0,55,30);
        txtMaHD = new JTextField();
        txtMaHD.setFont(font0);
        txtMaHD.setBounds(new Rectangle(55,0,80,30));
        itemView.add(lbMaHD);
        itemView.add(txtMaHD);

        JLabel lbMaKH = new JLabel("M?? KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(155,0,60,30);
        txtMaKH = new JTextField();
        txtMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(215,0,80,30));
        itemView.add(lbMaKH);
        itemView.add(txtMaKH);

        JLabel lbMaNV = new JLabel("M?? NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(315,0,60,30);
        txtMaNV = new JTextField();
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(375,0,80,30));
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);

        JLabel lbNgayHD = new JLabel("Ng??y HD");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0,40,60,30);
        txtNgayHD = new JTextField();
        txtNgayHD.setFont(font0);        
        txtNgayHD.setBounds(new Rectangle(80,40,375,30));
        itemView.add(lbNgayHD);
        itemView.add(txtNgayHD);
        
        dateChoice = new JDateChooser();
        dateChoice.setBounds(new Rectangle(80,40,375,30));
        dateChoice.setVisible(false);
        itemView.add(dateChoice);

        JLabel lbTongTien = new JLabel("T???ng Ti???n");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(0,80,60,30);
        txtTongTien = new JTextField();
        txtTongTien.setFont(font0);
        txtTongTien.setBounds(new Rectangle(80,80,375,30));
        itemView.add(lbTongTien);
        itemView.add(txtTongTien);

        add(itemView);
        /**************** T???O C??C BTN X??A, S???A, VIEW, IN BILL ********************/

        btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(500,0,200,50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
        btnDelete = new JLabel(new ImageIcon(("./src/image/btnDelete.png")));
        btnDelete.setBounds(new Rectangle(500,60,200,50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnView = new JLabel(new ImageIcon(("./src/image/btnView.png")));
        btnView.setBounds(new Rectangle(730,0,200,50));
        btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnBill = new JLabel(new ImageIcon(("./src/image/btnBill.png")));
        btnBill.setBounds(new Rectangle(730,60,200,50));
        btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(500,0,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(500,60,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        itemView.add(btnEdit);
        itemView.add(btnDelete);
        itemView.add(btnView);
        itemView.add(btnBill);
        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
        
        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {   
                int i = JOptionPane.showConfirmDialog(null, "X??c nh???n x??a","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    ctBUS.delete(txtMaHD.getText());
                    hdBUS.delete(txtMaHD.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, hdBUS.getList());
                }
            }
        });
        
        // Xem Chi Ti???t HD
        btnView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ChiTietHDGUI chitiet = new ChiTietHDGUI(txtMaHD.getText());
            }
        });
        
        // In Bill
        btnBill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String maHD = txtMaHD.getText();
                String maKH = txtMaKH.getText();
                String maNV = txtMaNV.getText();
                String ngayHD = txtNgayHD.getText();
                double tongTien = Double.parseDouble(txtTongTien.getText());
                HoaDonDTO hd = new HoaDonDTO(maHD, maKH, maNV, ngayHD, tongTien);
                ChiTietHDBUS ctBUS = new ChiTietHDBUS(1);
                ArrayList<ChiTietHDDTO> cthd = ctBUS.getListHD(maHD);
                outBill bill = new outBill(hd, cthd);
                bill.print();
            }
        });
        
        //Edit h??a ????n
        btnEdit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(txtMaHD.getText().equals(""))
                {   
                    JOptionPane.showMessageDialog(null, "Vui l??ng ch???n h??a ????n !");
                    return;
                }
                isEdit(true);
                
            }   
        });
        
        btnConfirm.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String maHD = txtMaHD.getText();
                String maKH = txtMaKH.getText();
                String maNV = txtMaNV.getText();
                String ngayHD = txtNgayHD.getText();
                double tongTien = Double.parseDouble(txtTongTien.getText());

                if(dateChoice.getCalendar() != null)
                {
                    Date time = Timestamp.valueOf(txtNgayHD.getText());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(time.getTime());
                    int dd = dateChoice.getCalendar().get(Calendar.DATE);
                    int mm = dateChoice.getCalendar().get(Calendar.MONTH);
                    int yyy = dateChoice.getCalendar().get(Calendar.YEAR);
                    calendar.set(yyy,mm, dd);
                    Timestamp newTime = new Timestamp(calendar.getTime().getTime());
                    
                    ngayHD = newTime.toString();
                }        
                
                HoaDonDTO hd = new HoaDonDTO(maHD, maKH, maNV, ngayHD, tongTien);
                int i = hdBUS.set(hd);
                outModel(model, hdBUS.getList());
                tbl.setRowSelectionInterval(i, i);
                isEdit(false);
            }   
        });
        
        btnBack.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
                isEdit(false);
                
                Date time = Timestamp.valueOf(txtNgayHD.getText());
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(time.getTime());

                if(dateChoice.getCalendar() != null)
                {
                    int dd = dateChoice.getCalendar().get(Calendar.DATE);
                    int mm = dateChoice.getCalendar().get(Calendar.MONTH);
                    int yyy = dateChoice.getCalendar().get(Calendar.YEAR);
                    calendar.set(yyy,mm, dd);
                    Timestamp newTime = new Timestamp(calendar.getTime().getTime());
                    System.out.println(newTime);
                    txtNgayHD.setText(newTime.toString());
                }
            }
        });
        /*************************************************************************/
/****************** T???O MODEL V?? HEADER *********************************************/
        Vector header = new Vector();
        header.add("M?? H??a ????n");
        header.add("M?? KH");
        header.add("M?? NV");
        header.add("Ngay H??a ????n");
        header.add("T???ng Ti???n");
        model = new DefaultTableModel(header,5)
        {
            public Class getColumnClass(int column)
            {
                switch(column){
                    case 4:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }              
        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list(); //?????c t??? database l??n table 
        
/*********************************************************/
        
/**************** T???O TABLE ************************************************************/

        // Ch???nh width c??c c???t 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);

        DefaultTableCellRenderer leftAlign = new DefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(JLabel.LEFT);
        tbl.getColumnModel().getColumn(4).setCellRenderer(leftAlign);
        
        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        // Add table v??o ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 270, this.DEFALUT_WIDTH - 400 , 400));
        scroll.setBackground(null);
        
        add(scroll);
/*****************************************************************************************/

        
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                txtMaHD.setText(tbl.getModel().getValueAt(i, 0).toString());
                try
                {
                    txtMaKH.setText(tbl.getModel().getValueAt(i, 1).toString());
                }
                catch(NullPointerException ex)
                {
                    txtMaKH.setText("");
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtNgayHD.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtTongTien.setText( tbl.getModel().getValueAt(i, 4).toString());
             }
        });
/*********************** SORT TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,170,this.DEFALUT_WIDTH - 400,140);
        
        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------------ B??? L???C ------------------------------------------------------------------------------------",JLabel.CENTER); // M???i b??n 84 d???u ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH - 400,30));
        sort.add(sortTitle);
        
        /******** SORT TH???I GIAN **************/
        JLabel sortTime = new JLabel("Th???i gian :");
        sortTime.setFont(font0);
        sortTime.setBounds(0,40,80,30);
        sort.add(sortTime);
        // Choice Th??ng
        int month = Calendar.getInstance().get(Calendar.MONTH);// L???y th??ng hi???n t???i
        monthChoice = new Choice();
        monthChoice.setFont(font0);
        monthChoice.add("Kh??ng");
        for(int i = 1 ; i <= 12 ; i++ )
        {
            monthChoice.add("Th??ng "+i);
        }
        monthChoice.select(0);
        monthChoice.setBounds(new Rectangle(80,42,80,40));
        sort.add(monthChoice);
        // Choice N??m
        int year = Calendar.getInstance().get(Calendar.YEAR);//L???y n??m hi???n t???i
        yearChoice = new Choice();
        yearChoice.setFont(font0);
        yearChoice.add("Kh??ng");
        for(int i = year ; i >= 1999 ; i--)
        {
            yearChoice.add(String.valueOf(i));
        }
        yearChoice.select(0);
        yearChoice.setBounds(new Rectangle(170,42,80,40));
        sort.add(yearChoice);
        /*************************************/
        
        /************ SORT THEO GI?? ***************/
        JLabel sortPrice = new JLabel("Gi?? (VN??) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(300,40,80,30);
        sort.add(sortPrice);
        
        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(380,42,100,26));
        sort.add(txtMinPrice);
        
        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(490, 56, 10, 6);
        sort.add(sepPrice);
        
        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(510,42,100,26));
        sort.add(txtMaxPrice);
          
        /******************************************/
        /************ SORT M?? SP ***************/
        JLabel sortSP = new JLabel("M?? SP :");
        sortSP.setFont(font0);
        sortSP.setBounds(650,40,60,30);
        sort.add(sortSP);

        txtMaSP = new JTextField();
        txtMaSP.setFont(font0);
        txtMaSP.setBounds(new Rectangle(700,42,100,26));  
        sort.add(txtMaSP);
//        /******************************************/
        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840,20,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
               search();
           }
        });
        sort.add(btnSearch);
        
        add(sort);

/****************************************************************/
        
    }
    public void search()
    {
        
        
        int mm = monthChoice.getSelectedIndex()-1;
        int yyy ;
        try{
            yyy = Integer.parseInt(yearChoice.getSelectedItem());
        }catch(NumberFormatException ex)
        {
            yyy = 0;
        }
        double max = txtMaxPrice.getText().equals("") ? 99999999 : Double.parseDouble(txtMaxPrice.getText());
        double min = txtMinPrice.getText().equals("") ? 0      : Double.parseDouble(txtMinPrice.getText());

        outModel(model,hdBUS.search(mm, yyy, max, min,ctBUS.getHD(txtMaSP.getText())));
    }
    public void cleanView()
    {
        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtNgayHD.setText("");
        txtTongTien.setText("");
    }
    public void outModel(DefaultTableModel model , ArrayList<HoaDonDTO> hd) // Xu???t ra Table t??? ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for(HoaDonDTO h:hd)
        {
            data = new Vector();
            data.add(h.getMaHD());
            data.add(h.getMaKH());
            data.add(h.getMaNV());
            data.add(h.getNgayHD());
            data.add(h.getTongTien());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    public void list() // Ch??p ArrayList l??n table
    {
        if(hdBUS.getList()== null)hdBUS.list();
        ArrayList<HoaDonDTO> hd = hdBUS.getList();
        model.setRowCount(0);
        outModel(model,hd);
    }
    public void isEdit(boolean flag)
    {
        txtNgayHD.setVisible(!flag);
        btnEdit.setVisible(!flag);
        btnDelete.setVisible(!flag);
        btnBill.setVisible(!flag);
        btnView.setVisible(!flag);
        tbl.setEnabled(!flag);
        
        btnConfirm.setVisible(flag);
        btnBack.setVisible(flag);
        dateChoice.setVisible(flag);
        
    }
}
