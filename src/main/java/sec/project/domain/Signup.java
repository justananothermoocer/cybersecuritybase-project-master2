package sec.project.domain;

import javax.persistence.Entity;
import javax.xml.bind.DatatypeConverter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.springframework.web.util.UriUtils.encode;

@Entity
public class Signup extends AbstractPersistable<Long> {

    private String name;
    private String address;
    private String pcode;
    private String pword;

    
    public Signup() {
        super();
        //super() is a special use of the super keyword 
        //where you call a parameterless parent constructor.
        //In general, the super keyword can be used to call 
        // overridden methods, access hidden fields or invoke
        // a superclass's constructor.
        // -> so we keep it
    }

    public Signup(String name, String address, String pcode, String pword) {
        this();
        this.name = name;
        this.address = address;
        this.pcode = pcode;
        this.pword = pword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPcode() {
        return pcode;
    }
    
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    
    public String getPword() {
      
        char[] key = {'K', 'G', 'B'};                   //
	StringBuilder output = new StringBuilder();
            for(int i = 0; i < pword.length(); i++) {
	    output.append((char) (pword.charAt(i) ^ key[i % key.length]));
	    }
 		
	    return output.toString();    
                    
        
        
    }    
    public void setCcard(String pword) {
        this.pword = pword;
    }

   // private String toString(byte[] converted) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
}
