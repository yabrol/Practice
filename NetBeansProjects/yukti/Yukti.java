public class Yukti{
  
  String linkedInProfile;
  String ePortfolio;
  College undergrad;
  College grad;
  
  public Yukti(){
    linkedInProfile = "https://www.linkedin.com/in/yabrol";
    ePortfolio = "stonybrook.digication.com/yukti_abrol";
    undergrad = new College("Stony Brook", "Biomedical Engineering", "Computer Science", "B.E.");
    grad = new College("Cornell", "Computer Science", null, "M.Eng");
  }
  

  public String toString(){
    String str = "";
    str += "<h1>Yukti Abrol</h1> \n";
    str += "<p><a href=" + linkedInProfile + ">LinkedIn</a></p>\n";
    str += "<p><a href=" + ePortfolio + ">ePortfolio</a></p>\n";
    str += "<p>Undergraduate: " + undergrad.toString() +"</p>";
    str += "<p>Graduate: " + grad.toString() + "</p>";
    return str;
  }
  
  public static void main(String args[])
  {
    Yukti y = new Yukti();
    System.out.println(y.toString());
  }
}
