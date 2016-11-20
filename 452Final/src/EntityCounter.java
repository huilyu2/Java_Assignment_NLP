
import java.io.*;
import java.util.*;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ling.CoreAnnotations.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

/** This class demonstrates building and using a Stanford CoreNLP pipeline. */
public class EntityCounter{

  public static void main(String[] args) throws IOException {

    // Create a CoreNLP pipeline. To build the default pipeline, you can just use:
    //   StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // Here's a more complex setup example:
    //   Properties props = new Properties();
    //   props.put("annotators", "tokenize, ssplit, pos, lemma, ner, depparse");
    //   props.put("ner.model", "edu/stanford/nlp/models/ner/english.all.3class.distsim.crf.ser.gz");
    //   props.put("ner.applyNumericClassifiers", "false");
    //   StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    // Add in sentiment
    Properties props = new Properties();
    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref, sentiment");

    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    String fileName = "LesMiserables.txt";
    String outputFilename = "EntityCounter.txt";
    Scanner inputStream = null;
    String line = "";
    PrintWriter outputStream = null;
    try
    {
    	inputStream = new Scanner(new File(fileName));
    }
    catch (FileNotFoundException e)
    {
    	System.out.println("Error opening the file " + fileName);
    	System.exit(0);
    }
    
    try
    {
    	outputStream = new PrintWriter(outputFilename);
    }
    catch (FileNotFoundException e)
    {
    	System.out.println("Error creating the file.");
    	System.exit(0);
    }
    
    HashMap<String,Integer> counterMap = new HashMap<String,Integer>();

    String volumeLabel = "";
    String bookLabel = "";
    String chapterLabel = "";
    boolean resetChapter = false;
    
    while (inputStream.hasNextLine())
    {
    	if (!(line.startsWith("VOLUME")||line.startsWith("BOOK")||line.startsWith("CHAPTER")||line.startsWith("FOOTNOTES")))
    		line = inputStream.nextLine();
	    if (line.startsWith("VOLUME"))
	    {
	    	resetChapter = true;
	    	volumeLabel = line;
	    	line = inputStream.nextLine();
	    }
	    else if (line.startsWith("BOOK"))
	    {
	    	resetChapter = true;
	    	bookLabel = line;
	    	line = inputStream.nextLine();
	    }
	    else if (line.startsWith("CHAPTER"))
	    {
	    	if (resetChapter)
	    	{
	    		counterMap.clear();
	    		chapterLabel = line;
	    		resetChapter = false;
	    	}
	    
	    	while (inputStream.hasNextLine())
	    	{
	    		line = inputStream.nextLine();
	    		if (line.startsWith("VOLUME")||line.startsWith("BOOK")||line.startsWith("CHAPTER")||line.startsWith("FOOTNOTES"))
	    		{
	    			for (String Word : counterMap.keySet())
				    {
				    	 Integer count = counterMap.get(Word);
				    	 outputStream.println(volumeLabel + "|" + bookLabel + "|" + chapterLabel + "|" + Word + "|" + count);
				    }
	    			resetChapter = true;
	    			break;
	    		}
	    		
	    	    // Initialize an Annotation with some text to be annotated. The text is the argument to the constructor.
	    	    Annotation annotation;
	    	    annotation = new Annotation(line);
	    	      
	    	    // run all the selected Annotators on this text
	    	    pipeline.annotate(annotation);
	    	    List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
	        
			    for (CoreMap sentence: sentences) 
			    { //if (sentences != null && ! sentences.isEmpty()) {
			      for (CoreMap token : sentence.get(CoreAnnotations.TokensAnnotation.class)) 
			      {
			        // this is the text of the token
			        String word = token.get(TextAnnotation.class);
			        // this is the POS tag of the token
			        String pos = token.get(PartOfSpeechAnnotation.class);
			        // this is the NER label of the token
			        String ne = token.get(NamedEntityTagAnnotation.class);
			        if (ne.equals("PERSON") || ne.equals("LOCATION"))
			        {
			        	if (!counterMap.containsKey(word))
			        	{
			        		counterMap.put(word, 1);
			        	}
			        	else
			        	{			        		
			        		int number = counterMap.get(word);
			        		number++;
			        		counterMap.put(word, number);
			        	}  	
			        
			        }
			        
			       }
			   
			     }
	    	 }
	    	 
	     }
	     else if (line.startsWith("FOOTNOTES"))
	     {
	    	 break;
	     }
    
    }
    
    inputStream.close();
    
    outputStream.close();
  }
}

