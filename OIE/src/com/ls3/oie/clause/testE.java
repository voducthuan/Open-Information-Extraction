package com.ls3.oie.clause;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ls3.oie.parsing.tuplesItem;

public class testE {
    public static void main(String[] args) throws IOException {
        ClausIE clausIE = new ClausIE();
        clausIE.initParser();
        // input sentence
        // String sentence =
        // "Bell, a telecommunication company, which is based in Los Angeles, makes and distributes electronic, computer and building products.";
        // String sentence = "There is a ghost in the room";
        // sentence = "Bell sometimes makes products";
        // sentence = "By using its experise, Bell made great products in 1922 in Saarland.";
        // sentence = "Albert Einstein remained in Princeton.";
        // sentence = "Albert Einstein is smart.";
        //String sentence = " Bell makes electronic, computer and building products.";
        //String sentence="Mr. Eskandarian , who resigned his Della Femina post in September , becomes chairman and chief executive of Arnold .";
        //String sentence="The team that dumped runs by the bushel on the Chicago Cubs in the National League playoffs was held to just one in two games by the home-team Oakland A 's , the gang that had been done unto similarly by the Los Angeles Dodgers and Orel Hershiser in last year 's tournament .";
        //String sentence="Bell makes electronic, computer and building products.";
        //String sentence="I saw the book which you bought .";
        //String sentence="Mr. Eskandarian , who resigned his Della Femina post in September , becomes chairman and chief executive of Arnold .";
        //String sentence="Steve Clark reported for work at 5 a.m. , two and a half hours before the usual Monday morning strategy meeting .";
        //String sentence="Bill works for Microsoft .";
        //String sentence="Mr. Eskandarian becomes chairman and chief executive of Arnold .";
        //String sentence="The man in the house is my father.";
        //String sentence="Tom's book is beautiful .";
        //String sentence="The man swimming in the lake is my father.";
        //String sentence="The nation 's health maintenance organizations were required to tell the federal government by midnight Monday whether they plan to continue providing health insurance to Medicare recipients next year , raise premiums , or reduce benefits .";
        //String sentence="A spokesperson for Omega in Rio de Janeiro , was not immediately available for comment .";
        //String sentence="In recent weeks, as the incentive wars have escalated, other automakers have beefed up their warranties.";
        //String sentence="Maxus Energy Corp., Dallas, said it discovered a new oil field in the southeast Sumatra area of Indonesia.";
        //String sentence="The current El Nino , a complicated and vaguely understood series of phenomena that affect weather around the globe , is either the weather event of the century or an event whose bluster ca n't come close to living up to the super-hype preceding it .";
        //String sentence="The current El Nino , a complicated and vaguely understood series of phenomena that affect weather around the globe , is the weather event of the century.";
        //String sentence="There should be about 3 cups vegetables chopped medium fine .";
        //String sentence="Plus , Gidley notes , there are also a number of push providers such as PointCast Inc. , which provides news and information directly to computer users rather than requiring users to surf the Net to find it .";
        //String sentence="Eric Schmidt is CEO of the company.";
        //String sentence="Devoted mother of Lyn Boland Dosik and the late Howard Batzar.";
        //String sentence="Orders went out today to deploy 17,000 U.S. Army soldiers in the Persian Gulf region.";
        //String sentence="Orders went out to deploy 17,000 U.S. Army soldiers.";
        
        //String sentence="After living in Connecticut for a few months, the couple decided to move to Brooklyn, NY where PER began his solo career and signed with COMPANY in 2001 .";
        //String sentence="Treasury Secretary Henry Paulson will lead the US delegation and will be joined by Agriculture Secretary Ed Schafer, ORG PERSON, US Trade Representative Susan Schwab, EPA Administrator Stephen Johnson, and other officials .";
        //String sentence="ORG is a comprehensive co-educational school for pupils aged 11 to 18 in Stroud, CITY_OF_HEADQUARTERS, England ..";
        //String sentence="There is a ghost in the room.";
        
        
        //------------------------Temporal and Causal sentenctes----------------------------------------------
        //String sentence="According to the filing, HP acquired 730,070 common shares from Octel as as result of an Aug. 10, 1988, stock purchase agreement.";
        //String sentence="They do their home work after taking a trip.";
        
        //String sentence="The one that decides for him is his father";
        //String sentence="The city was founded in 1610 as capital of Nuevo Mexico, after it replaced Española as capital, which makes it the oldest state capital in the United States.";
        //String sentence="An accompanying music video, directed by Nigel Dick , portrays Spears as a student from a Catholic high school, who starts to daydream that she is singing and dancing around the school, while watching her love interest from afar.";        
        //String sentence="The music video was later referenced in the music video of  If U Seek Amy (2008), where Spears's fictional daughter is dressed with a similar schoolgirl outfit while wearing pink ribbons in her hair.";
        //String sentence="It also received numerous certifications around the world, and is one of the best-selling singles of all time , with over 10 million copies sold.";
        String sentence="a water pump works how?";
        
        System.out.println("Input sentence   : " + sentence);
        // parse tree
        clausIE.parse(sentence);
        System.out.print("Dependency parse : ");
        System.out.println(clausIE.getDepTree().pennString()
                .replaceAll("\n", "\n                   ").trim());
        System.out.print("Semantic graph   : ");
        System.out.println(clausIE.getSemanticGraph().toFormattedString()
                .replaceAll("\n", "\n                   ").trim());
        clausIE.detectClauses();
        clausIE.generatePropositions();
        System.out.print("Clauses          : ");
        String sep = "";
        for (Clause clause : clausIE.getClauses()) {
            System.out.println(sep + clause.toString(clausIE.getOptions()));
            sep = "                   ";
        }

        // generate propositions
        System.out.print("Propositions     : ");
        for (Proposition prop : clausIE.getPropositions()) {
        	System.out.println(prop.toString());
        }       
        System.out.print("New propositions     : ");
        List<tuplesItem> listtupItems= new ArrayList<tuplesItem>();
        listtupItems=com.ls3.oie.parsing.mainProcess.OIE(sentence);
        for (int j = 0; j < listtupItems.size(); j++) {
        	System.out.println(listtupItems.get(j).toString());
		}
        
        
        /*
        for (int i = 0; i < sentences.size(); i++) {
			System.out.println(i+". "+sentences.get(i));
			// parse tree
	        clausIE.parse(sentences.get(i));
	        clausIE.detectClauses();
	        clausIE.generatePropositions();
	        
			clausIE.updatePropositions();
	        // clause relation
			for (Proposition prop : clausIE.getPropositions()) {
	            System.out.println(prop.toString());
	            out.write(prop.toString()+" "+clausIE.getLP().getPCFGScore());
	            out.write("\n");
	            scorce=clausIE.getLP().getPCFGScore();
	        }
	        // new clause relation
	        List<tuplesItem> listtupItems= new ArrayList<tuplesItem>();
	        listtupItems=com.ls3.oie.parsing.mainProcess.OIE(sentences.get(i));
	        for (int j = 0; j < listtupItems.size(); j++) {
	        	System.out.println(listtupItems.get(j).toString());
	            out.write(listtupItems.get(j).toString()+" "+scorce);
	            out.write("\n");
			}  
		} 
        
        
        */
        
        
        
    }
}
