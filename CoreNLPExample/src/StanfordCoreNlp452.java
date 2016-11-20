
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
public class StanfordCoreNlp452 {

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

    // Initialize an Annotation with some text to be annotated. The text is the argument to the constructor.
    Annotation annotation;
    annotation = new Annotation("Kosgi Santosh sent an email to Stanford University. He didn't get a reply.");
      
    // run all the selected Annotators on this text
    pipeline.annotate(annotation);
    List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
    for (CoreMap sentence: sentences) { //if (sentences != null && ! sentences.isEmpty()) {
      for (CoreMap token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        // this is the text of the token
        String word = token.get(TextAnnotation.class);
        // this is the POS tag of the token
        String pos = token.get(PartOfSpeechAnnotation.class);
        // this is the NER label of the token
        String ne = token.get(NamedEntityTagAnnotation.class);
        
        System.err.println("token: " + word + "\t\tPOS: " + pos + "\t\tNER: " + ne);
      }
    }
  }
}
