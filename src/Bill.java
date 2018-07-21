import static bill.OffsetConstants.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class Bill{
/********************************************************************************************************************************
     this constructor includes the given path passed in parameter and initializes the all the values by calling init method.
 **********************************************************************************************************************************/   
    
    public Bill(String path){
        this.path = path;
        init();
    }
    
    public Bill(){
        init();
    }
    
/********************************************************************************************************************************
     Initialization goes here.
 **********************************************************************************************************************************/   
    private void init(){
        checkouts = new ArrayList<>();
        file = new File(this.path + "\\Bill" + billNo + ".pdf");
        loadPDFFile(new File("D:\\HotelManagement\\Bill.pdf"));
        CGSTAmount = 0;
        SGSTAmount = 0;
        totalGSTAmount = 0;
        totalPriceExcludingGST = 0;
        totalPriceIncludingGST = 0;
    }
/********************************************************************************************************************************
    this method sets path of the file.
 **********************************************************************************************************************************/

    public void setPath(String path) {
        this.path = path;
    }
    
/********************************************************************************************************************************
     Getters and setters.
 **********************************************************************************************************************************/
       public float getCGSTAmount() {
        return CGSTAmount;
    }

    public void setCGSTAmount(float CGSTAmount) {
        this.CGSTAmount = CGSTAmount;
    }

    
    public float getSGSTAmount() {
        return SGSTAmount;
    }

    public void setSGSTAmount(float SGSTAmount) {
        this.SGSTAmount = SGSTAmount;
    }

    
    public float getTotalPriceExcludingGST() {
        return totalPriceExcludingGST;
    }

    public float getTotalPriceIncludingGST() {
        return totalPriceIncludingGST;
    }
    
    
    
    public float getTotalGSTAmount(){
        if(totalGSTAmount>0)
            return totalGSTAmount;
        return -1;
    }
    
    
 /********************************************************************************************************************************
     Calculation of CGST, SGST, Tax, TotalTax and total price.
 **********************************************************************************************************************************/
    private void calculateCGSTAmount(){
        CGSTAmount = calculateTax(totalPriceExcludingGST, CGST);
    }
    private void calculateSGSTAmount(){
        SGSTAmount = calculateTax(totalPriceExcludingGST, SGST);
    }
    
    private float calculateTax(float totalAmount, float percent){
        float tax = 0;
        tax = (totalAmount * percent)/100;
        return tax;
    }
    private float calculateTotalTax(){
        return (totalGSTAmount = CGSTAmount + SGSTAmount);
    }
    private float calculateTotalPriceFromOrders(){
        float totalPriceExcludingGST = 0;
        for (CustomerCheckoutBill p : checkouts){
            totalPriceExcludingGST += (p.price * p.totalNoOfDays);
        }
        return totalPriceExcludingGST;
    }
    private float calculateTotalPriceIncludingGST(){
        if(totalPriceExcludingGST > 0 && CGSTAmount > 0 && SGSTAmount > 0){
            return (totalPriceIncludingGST = totalPriceExcludingGST + calculateTotalTax());
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return "Bill{" + "path=" + path + ", billNo=" + billNo + '}';
    }

    public int getInvoiceNo() {
        return billNo;
    }

    public void addOrder(String checkin,double price,String checkout, int days, String name, String email){
         checkouts.add(new CustomerCheckoutBill(checkin, price, checkout, days, name, email));
    }
    public void addOrder(CustomerCheckoutBill pd){
        addOrder(pd.checkin,pd.price,pd.checkout,pd.totalNoOfDays, pd.name, pd.email);
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
 /********************************************************************************************************************************
     Calculation of CGST, SGST, Tax, TotalTax and total price when the customer checks out.
 **********************************************************************************************************************************/
    private class CustomerCheckoutBill{

        private String checkin;
        private String checkout;
        private double price;
        private int totalNoOfDays ;
        private String name ;
        private String email;
        public CustomerCheckoutBill(String checkin, double price, String checkout, int totalDays, String name, String email) {
            this.checkin = checkin;
            this.price = price;
            this.checkout = checkout;
            this.totalNoOfDays = totalDays;
            this.name = name;
            this.email = email;
        }
    }
    
    
/********************************************************************************************************************************
     PDF writing of bill.
 **********************************************************************************************************************************/
    private void loadPDFFile(File file){
        try {
            templatePDF = PDDocument.load(file);
            contentStream = new PDPageContentStream(templatePDF,templatePDF.getPage(0),PDPageContentStream.AppendMode.APPEND,false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e + " in loadPDFFile");
        }
    }
    
    public boolean createBill(){
        if(checkouts != null){
            try {
                writeBillNo();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
                contentStream.setLeading(22);
                int count = 0;
                for(CustomerCheckoutBill p : checkouts){
                    writeBillDetails(p,count++);
                    writeCustomerDetails(p);
                }
                totalPriceExcludingGST = calculateTotalPriceFromOrders();
                writeCGSTAmount();
                writeSGSTAmount();
                writeTotalPriceIncludingGST();
                saveAndClose();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e + " in createBill");
            }
            return true;
        }
        return false;
    }
    
    
/********************************************************************************************************************************
     this method allows manager to enter cgst amount to generate total price. 
 **********************************************************************************************************************************/   
    private void writeCGSTAmount(){
        calculateCGSTAmount();
        try {
            contentStream.beginText();
            contentStream.newLineAtOffset(CGSTAMOUNTX, CGSTAMOUNTY);
            contentStream.showText("" + getCGSTAmount());
            contentStream.endText();
        } catch (Exception e) {
            System.out.println(e + " in writeCGST");
        }
    }
    
/********************************************************************************************************************************
    this method allows manager to enter sgst amount to generate total price. 
 **********************************************************************************************************************************/     
    private void writeSGSTAmount(){
        calculateSGSTAmount();
        try {
            contentStream.beginText();
            contentStream.newLineAtOffset(SGSTAMOUNTX, SGSTAMOUNTY);
            contentStream.showText("" + getSGSTAmount());
            contentStream.endText();
        } catch (Exception e) {
            System.out.println(e + " in writeSGST");
        }
    }
    
    
/*********************************************************************************************************************************
 * this method prints total price including GST
 **********************************************************************************************************************************/   
    private void writeTotalPriceIncludingGST(){
        calculateTotalPriceIncludingGST();
        try {
            contentStream.beginText();
            contentStream.newLineAtOffset(TOTALPRICEX, TOTALPRICEY);
            contentStream.showText("" + getTotalPriceIncludingGST());
            contentStream.endText();
        } catch (Exception e) {
            System.out.println(e + " in writeSGST");
        }
    }
/*********************************************************************************************************************************
  this method is used to write the bill details
 **********************************************************************************************************************************/    
    
    private void writeBillDetails(CustomerCheckoutBill p, int checkoutNum) throws IOException{
        if(p != null && !isBillEnded(checkoutNum)){
            contentStream.beginText();
            contentStream.newLineAtOffset(PRODUCTNAMEX,PRODUCTNAMEY - (checkoutNum * 22));
            contentStream.showText(p.checkin + " ");
            contentStream.newLineAtOffset(PRODUCTNAMEX + 230, 0);
            contentStream.showText(p.checkout + "");
            contentStream.newLineAtOffset(PRODUCTNAMEX + 160, 0);
            contentStream.showText(p.price*p.totalNoOfDays + "");
            contentStream.endText();
        }
    }
    
/*********************************************************************************************************************************
  this method is used to write the customer details
 **********************************************************************************************************************************/        
    
    private void writeCustomerDetails(CustomerCheckoutBill o) throws IOException{
            contentStream.beginText();
            contentStream.newLineAtOffset(CUSTOMERDETAILSX,CUSTOMERDETAILSY);
            contentStream.showText(o.name);
            contentStream.newLine();
            contentStream.showText(o.email);
            contentStream.newLine();
            contentStream.showText("sunnysretreat.com");
            contentStream.endText();
    }
    
/*********************************************************************************************************************************
  this method checks whether bill has ended i.e if checkout has take place
 **********************************************************************************************************************************/    
    private boolean isBillEnded(int numOfCheckouts){
        if(numOfCheckouts >= 16)
            return true;
        return false;
    }
    
 /*********************************************************************************************************************************
  this method is used to write the bill no.
 **********************************************************************************************************************************/    
    private void writeBillNo() throws IOException{
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 20);
        contentStream.newLineAtOffset(BILLNOX,BILLNOY);
        contentStream.showText(" " + billNo);
        contentStream.endText();
    }
    
/*********************************************************************************************************************************
  this method is used to save and close the bill
 **********************************************************************************************************************************/        
    private void saveAndClose(){
        try {
            contentStream.close();
            templatePDF.save(file);
            templatePDF.close();
        } catch (IOException e) {
            System.out.println(e+ " in saveAndClose");
        }
    }
   
   
//Variable Declaration    
    private PDDocument templatePDF = null;
    private PDPageContentStream contentStream = null;
    private String path = "D:\\HotelManagement";
    private int billNo = -1;
    private List<CustomerCheckoutBill> checkouts = null;
    private File file = null;
    public static final float CGST = 18.00F;
    public static final float SGST = 18.00F;
    private float CGSTAmount;
    private float SGSTAmount;
    private float totalGSTAmount;
    private float totalPriceExcludingGST;
    private float totalPriceIncludingGST;
}