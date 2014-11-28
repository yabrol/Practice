public class College{
  String name;
  String major;
  String minor;
  String degree;
  
  public College(String n, String major, String minor, String d){
    name = n;
    this.major = major;
    this.minor = minor;
    degree = d;
  }
  
  public String toString(){
    String str = "";
    str += name + " \n";
    str += degree + " in ";
    str += major;
    if(minor != null){
      str += " and " + minor + " (Minor)";
    }
    
    return str;
  }

}