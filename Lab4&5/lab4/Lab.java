package lab4;

import javax.swing.*;

/**
 *
 * @author Wiley
 */
public class Lab
{
    String num = "No Number";
    
    String title = "No title";
    
    String date = "##/##/##";
    
    String description = "No header";
    
    Banner banner = new Banner(num, title, description, date);
    
    /**
     * A class meant to store elements common to all CSC102 labs.
     * @param lNum Lab number.
     * @param lTitle Lab title.
     * @param headr Lab Description.
     * @param dte Date.
     */
    public Lab(String lNum, String lTitle, String headr, String dte)
    {
        num = lNum;
        title = lTitle;
        description = headr;
        date = dte;
        banner.update(num, title, description, date);
    }
}
