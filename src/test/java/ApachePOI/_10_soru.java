package ApachePOI;/*
      Yeni bir excele merhaba Dünya 1 şeklinde yazdıktan sonra , programı tekrar
      çalıştırdığınızda aynı excelin bir alt satırına devam ediniz.
      Program her çalıştıkça aşağıdaki gibi olmalı
      Merhaba Dünya 1
      Merhaba Dünya 2
      Merhaba Dünya 3
       ....
       ....
       path="";
       File dosya=new File(path)

       if (dosya.exists()  // dosya var mı
     */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class _10_soru {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/YeniExcel1.xlsx";

        File f=new File(path);

        if(!f.exists()){//dosya yok ise

            // hafızada  yeni workbook oluştur, sonra sheet oluştur, sonra row oluştur, sonra cell oluştur.
            XSSFWorkbook workbook=new XSSFWorkbook();//xssworkbook sanal..exceli olusturuyor

            XSSFSheet sheet=workbook.createSheet("Sayfa1");

            // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
            Row yeniSatir= sheet.createRow(0); // satır oluşturuldu 0.yerde
            Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
            yeniHucre.setCellValue("First Snow *+*+*+"); // bilgi yazıldı.

            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();  // hafıza boşaltıldı
            outputStream.close();


            System.out.println("layy layy layy");



        }
        else{

            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet= workbook.getSheetAt(0);

            int rowcnt=sheet.getPhysicalNumberOfRows();
            Row yenisatir=sheet.createRow(0);
            Cell yeniHucre= yenisatir.createCell(0);
            yeniHucre.setCellValue("let it snow"+(rowcnt+1));

            inputStream.close();

            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            outputStream.close();
            System.out.println(" oleeey");







        }
    }
}
