/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.views;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import java.io.InputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
public class PdfReportView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
            PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        try {
			
						
            PdfReader pdfTemplate = new PdfReader((InputStream) model.get("template"));
    		PdfStamper stamper = new PdfStamper(pdfTemplate, response.getOutputStream());
    		stamper.setFormFlattening(true);
    		
    		stamper.getAcroFields().setField("txtNom", "Kamdoum");
    		stamper.getAcroFields().setField("txtPrenom", "Samuel");

    		stamper.close();
    		pdfTemplate.close();
    		
            System.out.println("This PDF has "+pdfTemplate.getNumberOfPages()+" pages.");
           
        } catch (Exception e) {
            System.out.println("PdfReportView.buildPdfDocument() "+e.getMessage());
        }
    }
    
}
