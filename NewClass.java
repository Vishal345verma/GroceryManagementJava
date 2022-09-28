import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class NewClass extends JFrame{
private static int rowindex=1;
public static void main(String args[]) throws Exception{
    MainLayout l = new MainLayout();
    l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    l.setSize(screenSize.width/2,screenSize.height/2);
    l.setLocationRelativeTo(null);
    l.setVisible(true);
    }
public static Boolean Search(int k,double j) throws FileNotFoundException, IOException, InvalidFormatException
{
    Boolean b=false;
    File file = new File("./MainList.xlsx");
    FileInputStream fis = new FileInputStream("./MainList.xlsx");
    XSSFWorkbook wb;
    wb = new XSSFWorkbook("./MainList.xlsx");
    Sheet sh = wb.getSheet("AddItemSheet");
    int rownum = sh.getLastRowNum();
    for(int i = 1 ; i <= rownum ; i++)
    {
       Row rn = sh.getRow(i);
       Cell cell = rn.getCell(0);
       double m = cell.getNumericCellValue();
       if(k == m)
       {
           b = true;
           Cell cell1 = rn.getCell(2);
           double m1 = cell1.getNumericCellValue();
           double m2 = m1 + j;
           cell1.setCellValue(m2);
           fis.close();
           FileOutputStream fos = new FileOutputStream(file);
           wb.write(fos);
           fos.close();
       }
    }
    return b;
}
public static Boolean Searchforbill(int k,double j) throws FileNotFoundException, IOException, InvalidFormatException
{
    Boolean b=false;
    double m2;
    File file = new File(".\\MainList.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    Sheet sh = wb.getSheet("AddItemSheet");
    int rownum = sh.getLastRowNum();
    for(int i = 1 ; i <= rownum ; i++)
    {
       Row rn = sh.getRow(i);
       Cell cell = rn.getCell(0);
       double m = cell.getNumericCellValue();
       if(k == m)
       {
           b = true;
           Cell cell1 = rn.getCell(2);
           double m1 = cell1.getNumericCellValue();
            m2 = m1 - j;
            if(m2 <= 0)
           {
               b=false;
               System.out.println("cannot add item" );
               System.out.println("need "+(-m2)+" more units");
           }
            else
           cell1.setCellValue(m2);
           fis.close();
           FileOutputStream fos = new FileOutputStream(file);
           wb.write(fos);
           fos.close();
       }
    }
    return b;
}
public static int Searchforbill2(int k) throws FileNotFoundException, IOException, InvalidFormatException
{
    double b=0;
    double m1=0;
    int m2=0;
    File file = new File("./MainList.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    Sheet sh = wb.getSheet("AddItemSheet");
    int rownum = sh.getLastRowNum();
    for(int i = 1 ; i <= rownum ; i++)
    {
       Row rn = sh.getRow(i);
       Cell cell = rn.getCell(0);
       double m = cell.getNumericCellValue();
       if(k == m)
       {
           Cell cell1 = rn.getCell(3);
           m1 = cell1.getNumericCellValue();
       }
    }
    m2 =(int)m1;
    return m2;
}
public String Searchforbill3(double k) throws FileNotFoundException, IOException, InvalidFormatException
{
    double b=0;
    String m1="";
    File file = new File("./MainList.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    Sheet sh = wb.getSheet("AddItemSheet");
    int rownum = sh.getLastRowNum();
    for(int i = 1 ; i <= rownum ; i++)
    {
       Row rn = sh.getRow(i);
       Cell cell = rn.getCell(0);
       double m = cell.getNumericCellValue();
       if(k == m)
       {
           
           Cell cell1 = rn.getCell(1);
           m1 = cell1.getStringCellValue();
       }
    }
    return m1;
}
public static Boolean SearchforStat(int k) throws FileNotFoundException, IOException, InvalidFormatException
{
    Boolean b=false;
    File file = new File("./MainList.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    Sheet sh = wb.getSheet("AddItemSheet");
    int rownum = sh.getLastRowNum();
    for(int i = 1 ; i <= rownum ; i++)
    {
       Row rn = sh.getRow(i);
       Cell cell1 = rn.getCell(1);
       Cell cell2 = rn.getCell(2);
       Cell cell3 = rn.getCell(3);
       Cell cell = rn.getCell(0);
       double m = cell.getNumericCellValue();
       if(k == m)
       {
           System.out.println("Product Name   "+cell1.getStringCellValue()+"    Quantity  " + cell2.getNumericCellValue() + "   Price Per Unit   " + cell3.getNumericCellValue() );
           fis.close();
           FileOutputStream fos = new FileOutputStream(file);
           wb.write(fos);
           fos.close();
       }
    }
    return b;
}

public void Insertforadd(int i,String str,int j,int k) throws Exception
{
  File file = new File("./MainList.xlsx");
  FileInputStream fis = new FileInputStream(file);
  XSSFWorkbook wb = new XSSFWorkbook(fis);
  Sheet sh = wb.getSheet("AddItemSheet");
  rowindex = sh.getLastRowNum();
  Row row = sh.createRow(rowindex + 1);
  Cell cell0 = row.createCell(0);
  Cell cell1 = row.createCell(1);
  Cell cell2 = row.createCell(2);
  Cell cell3 = row.createCell(3);
  cell0.setCellValue(i);
  cell1.setCellValue(str);
  cell2.setCellValue(j);
  cell3.setCellValue(k);
  fis.close();
  FileOutputStream fos = new FileOutputStream(file);
  wb.write(fos);
  fos.close();

}
}
class MainLayout extends JFrame implements ActionListener{
    private JButton additembutton;
    private JButton Billbutton;
    private JButton Statbutton;
    private FlowLayout fl;
    private Container ct;
    public MainLayout()
    {
        super("Main Menu");
        JFrame main = new JFrame("Main Menu");
        JPanel panel = new JPanel();
        main.add(panel);
        setLayout(null);
        this.setLocationRelativeTo(null);
        additembutton= new JButton("Add Item");
        additembutton.setLocation(250,25);
        additembutton.setSize(300, 100);
        Billbutton = new JButton("Billing");
        Billbutton.setLocation(250,150);
        Billbutton.setSize(300, 100);
        Statbutton = new JButton("Stats");
        Statbutton.setLocation(250,275);
        Statbutton.setSize(300, 100);
        add(additembutton);
        add(Billbutton);
        add(Statbutton);
        additembutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AddItemFrame ob = new AddItemFrame();
                ob.setVisible(true);
                ob.setSize(820,90);
                ob.setLocationRelativeTo(null);
                ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        Billbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BillFrame ob = new BillFrame();
                ob.setVisible(true);
                ob.setSize(610,120);
                ob.setLocationRelativeTo(null);
                ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
           Statbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StatusFrame ob = new StatusFrame();
                ob.setVisible(true);
                ob.setSize(500,100);
                ob.setLocationRelativeTo(null);
                ob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
     
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
class AddItemFrame extends JFrame implements ActionListener{
    String msg,msg1,msg2,msg4;
    public static int rowindex = 1;
    AddItemFrame()
    {
        super("Add Your Item");
         NewClass ob = new NewClass();
        JLabel lb1 = new JLabel("Code");
        JTextField txt1 = new JTextField(12);
        FlowLayout fl = new FlowLayout();
        Container container = getContentPane();
        setLayout(fl);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS)); 
        JLabel lb2 = new JLabel("Name");
        JTextField txt2 = new JTextField(12);
        JLabel lb3 = new JLabel("Quantity");
        JTextField txt3 = new JTextField(12);
        JLabel lb4 = new JLabel("Price");
        JTextField txt4 = new JTextField(12);
        JButton add = new JButton("Add");
        add(panel);
        add(lb1);
        add(txt1);
        add(lb2);
        add(txt2);
        add(lb3);
        add(txt3);
        add(lb4);
        add(txt4);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int code = Integer.parseInt(txt1.getText());
                msg1 = txt2.getText();
                int quantity = Integer.parseInt(txt3.getText());
                int price = Integer.parseInt(txt4.getText());
                try {
                    if(ob.Search(code,quantity))
                    {
                        System.out.println("Item found add button");
                    }
                    else
                    {
                        try {
                            ob.Insertforadd(code,msg1,quantity,price);
                        } catch (Exception ex) {
                            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
       
        
    }

    public void actionPerformed(ActionEvent ae)
    {
        
    }
}   
class BillFrame extends JFrame implements ActionListener{
    private static int rowindex = 0;
    BillFrame()
    {
        super("Create your Bill");
        JButton additem = new JButton("add item");
        JButton total = new JButton("Get Bill");
        JButton reset = new JButton("reset");
        JLabel lb2 = new JLabel("quantity");
        JTextField txt2 = new JTextField(12);
        JLabel lb1 = new JLabel("code");
        JTextField txt3 = new JTextField(12);
        FlowLayout layout=new FlowLayout();
        Container container = getContentPane();
        NewClass ob = new NewClass();
        setLayout(layout);
        add(lb1);
        add(txt3);
        add(lb2);
        add(txt2);
        add(additem);
        add(total);
        add(reset);
        additem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = Integer.parseInt(txt3.getText());
                int j = Integer.parseInt(txt2.getText());
                int k = 0;
                try {
                    k = ob.Searchforbill2(i);
                } catch (IOException ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    
                    if(ob.Searchforbill(i,j))
                    {
                        Insert(i,j,k*j);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        total.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    getBill();
                } catch (IOException ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    reset();
                } catch (Exception ex) {
                    Logger.getLogger(BillFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
public void Insert(int i,int k,int b) throws Exception
{
  File file = new File("./MainList.xlsx");
  FileInputStream fis = new FileInputStream(file);
  XSSFWorkbook wb = new XSSFWorkbook(fis);
  Sheet sh = wb.getSheet("BillSheet");
  rowindex++;
  Row row = sh.createRow(rowindex);
  Cell cell0 = row.createCell(0);
  Cell cell1 = row.createCell(1);
  Cell cell2 = row.createCell(2);
  cell0.setCellValue(i);
  cell1.setCellValue(k);
  cell2.setCellValue(b);
  fis.close();
  FileOutputStream fos = new FileOutputStream(file);
  wb.write(fos);
  fos.close();
 
}
public static void getBill() throws FileNotFoundException, IOException, InvalidFormatException
{
  double total = 0;
  String msg;
  int j;
  File file = new File("./MainList.xlsx");
  NewClass ob = new NewClass();
  FileInputStream fis = new FileInputStream(file);
  XSSFWorkbook wb = new XSSFWorkbook(fis);
  Sheet sh = wb.getSheet("BillSheet");
  Row[] rows = new Row[100];
  Cell[] cell = new Cell[100];
  int row = rowindex;
  System.out.println(row);
   for(int i=1 ;i<=row; i++)
             {
                for(j=0; j<=2; j++)
                {
                    rows[i] = sh.getRow(i);
                    cell[j]=rows[i].getCell(j);
                    
                    if(j == 0)
                    {
                       msg = ob.Searchforbill3(cell[j].getNumericCellValue());
                       System.out.print(msg);
                    }
                    System.out.print(" " + cell[j].getNumericCellValue());
        
                    
                }
                
                System.out.println();
                
            }
   for(int i=1; i<=row;i++)
   {
       Row row1 = sh.getRow(i);
       Cell cell1 = row1.getCell(2);
       total += cell1.getNumericCellValue();
   }
   System.out.println("Total = "+total);
}
  @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public static void reset() throws Exception
{   
        File file = new File("./MainList.xlsx");
        FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            Sheet sh = wb.getSheet("BillSheet");
            Row[] rows = new Row[10];
            Cell[] cell = new Cell[100];
            int row = sh.getLastRowNum();
            for(int i=1 ;i<=row; i++)
             {
                for(int j=0; j<=2; j++)
                {
                    rows[i] = sh.getRow(i);
                    cell[j]=rows[i].createCell(j);
                    
                }
                
            }
            fis.close();
            FileOutputStream fos = new FileOutputStream(".\\MainList.xlsx");
            wb.write(fos);
            fos.flush();
            fos.close();
            rowindex = 1;
}
    
}

class StatusFrame extends JFrame implements ActionListener{
    StatusFrame()
            {
            super("Get Status of Product");
            JButton status = new JButton("Get Status");
            JLabel lb1 = new JLabel("code");
            JTextField txt1 = new JTextField(12);
            FlowLayout fl = new FlowLayout();
            Container container = getContentPane();
            NewClass ob = new NewClass();
            setLayout(fl);
            add(lb1);
            add(txt1);
            add(status);
            status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        int num = Integer.parseInt(txt1.getText());
                        ob.SearchforStat(num);
                    } catch (IOException ex) {
                        Logger.getLogger(StatusFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidFormatException ex) {
                        Logger.getLogger(StatusFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}