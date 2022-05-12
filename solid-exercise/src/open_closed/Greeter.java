package open_closed;

public class Greeter {
    String formality;

    public String greet() {
    	String greet = "Hello";
    	switch(formality) {
    	case "formal":
    		greet = "Good evening, sir.";
    		break;
    	case "casual":
    		greet = "Sup bro?";
    		break;
    	case "intimate":
    		greet = "Hello Darling!";
    		break;
    	}
    	return greet;
    }

    

    public void setFormality(String formality) {
        this.formality = formality;
    }
}
    
    
    	
