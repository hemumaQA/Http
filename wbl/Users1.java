package org.wbl;

import java.io.Serializable;

public class Users1 implements Serializable {
   // public int id;
   // public String firstname;
   // public  String lastname;
    public String name;
    public  String job;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getJob(){
        return  job;
    }
    public  void setJob(String job){
        this.job=job;
    }





   /* public  int getId(){
        return id;
    }
    public  void setId(int id ){
        this.id=id;
    }

    public String getFirstname(){
        return firstname;
    }
    public  void setFirstname(String firstname){
        this.firstname=firstname;
    }

    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public void setEmail(String s) {
    }

    public void setFirst_name(String janet) {
    }

    public void setLast_name(String weaver) {
    }*/

    public String getuserinfo()
    {
        return (this.name+" "+this.job);
    }
   /* {
        return(this.id+" "+this.firstname+" "+this.lastname);
    }*/
}
