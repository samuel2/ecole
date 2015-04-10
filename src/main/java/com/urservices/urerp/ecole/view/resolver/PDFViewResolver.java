/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.ecole.view.resolver;

import com.urservices.urerp.ecole.views.PdfReportView;
import java.util.Locale;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 *
 * @author samuel < smlfolong@gmail.com >
 */
public class PDFViewResolver implements ViewResolver {

    public View resolveViewName(String arg0, Locale arg1) throws Exception {
        return new PdfReportView();
    }
    
}
