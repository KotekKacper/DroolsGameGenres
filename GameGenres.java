package com.sample;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class GameGenres {

    public static final void main(String[] args) {
        try {
//        	String [] answers = {"Medieval Fantasy", "Far Future",
//   				 "Mecha", "Generes related to near present",
//   				 "Westerns", "Supers", "Other Alternate History",
//   				 "Genre Shouldn't matter"};
//        	
//    		GUI.window("Which genre interests you?", answers);
        	
        	
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
    

}
