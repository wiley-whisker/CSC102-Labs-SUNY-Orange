package lab4;

/**
 *
 * @author Wiley
 */
public class Banner
{
    String num = "No Number";
    
    String title = "Missing title";
    
    String description = "Missing description";
        
    String date = "##/##/##";
    
    String banner = "*\tWiley Matthews\t\t" + date + "\t*\n" +
                    "*\t\tLab " + num + "\t" + title + "\t\t*\n" +
                    "*\t\t\t\t\t\t*\n" + 
                    "*\t\t" + description;
    
    
    public Banner(String labn, String labtitle, String desc, String dte)
    {
        num = labn;
        title = labtitle;
        description = desc; 
        date = dte;
    }
    
    public String asString()
    {
        return banner;
    }
    
    public void update(String labn, String labtitle, String desc, String dte)
    {
        num = labn;
        title = labtitle;
        description = desc; 
        date = dte;
        banner = "*\tWiley Matthews\t\t" + date + "\t*\n" +
                    "*\t\tLab " + num + "\t" + title + "\t\t*\n" +
                    "*\t\t\t\t\t\t*\n" + 
                    "*\t\t" + description;
    }
}
