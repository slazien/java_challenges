import gov.nih.nlm.nls.metamap.*;
import gov.nih.nlm.nls.metamap.AcronymsAbbrevs;
import gov.nih.nlm.nls.metamap.ConceptPair;
import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.Negation;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Position;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;

import java.io.PrintStream;
import java.util.List;

public class APITest {

    public static void process(String terms, PrintStream out, List<String> serverOptions)
            throws Exception
    {
        MetaMapApi api = new MetaMapApiImpl();
        if (serverOptions.size() > 0) {
            api.setOptions(serverOptions);
        }
        List<Result> resultList = api.processCitationsFromString(terms);
        for (Result result: resultList) {
            if (result != null) {
                out.println("input text: ");
                out.println(" " + result.getInputText());
                List<AcronymsAbbrevs> aaList = result.getAcronymsAbbrevsList();
                if (aaList.size() > 0) {
                    out.println("Acronyms and Abbreviations:");
                    for (AcronymsAbbrevs e: aaList) {
                        out.println("Acronym: " + e.getAcronym());
                        out.println("Expansion: " + e.getExpansion());
                        out.println("Count list: " + e.getCountList());
                        out.println("CUI list: " + e.getCUIList());
                    }
                }
                List<gov.nih.nlm.nls.metamap.Negation> negList = result.getNegationList();
                if (negList.size() > 0) {
                    out.println("Negations:");
                    for (Negation e: negList) {
                        out.println("type: " + e.getType());
                        out.print("Trigger: " + e.getTrigger() + ": [");
                        for (Position pos: e.getTriggerPositionList()) {
                            out.print(pos  + ",");
                        }
                        out.println("]");
                        out.print("ConceptPairs: [");
                        for (ConceptPair pair: e.getConceptPairList()) {
                            out.print(pair + ",");
                        }
                        out.println("]");
                        out.print("ConceptPositionList: [");
                        for (Position pos: e.getConceptPositionList()) {
                            out.print(pos + ",");
                        }
                        out.println("]");
                    }
                }
                for (Utterance utterance: result.getUtteranceList()) {
                    out.println("Utterance:");
                    out.println(" Id: " + utterance.getId());
                    out.println(" Utterance text: " + utterance.getString());
                    out.println(" Position: " + utterance.getPosition());

                    for (PCM pcm: utterance.getPCMList()) {
                        out.println("Phrase:");
                        out.println(" text: " + pcm.getPhrase().getPhraseText());
                        out.println(" Minimal Commitment Parse: " + pcm.getPhrase().getMincoManAsString());
                        out.println("Candidates:");

                        for (Ev ev: pcm.getCandidatesInstance().getEvList()) {
                            out.println(" Candidate:");
                            out.println("  Score: " + ev.getScore());
                            out.println("  Concept Id: " + ev.getConceptId());
                            out.println("  Concept Name: " + ev.getConceptName());
                            out.println("  Preferred Name: " + ev.getPreferredName());
                            out.println("  Matched Words: " + ev.getMatchedWords());
                            out.println("  Semantic Types: " + ev.getSemanticTypes());
                            out.println("  MatchMap: " + ev.getMatchMap());
                            out.println("  MatchMap alt. repr.: " + ev.getMatchMapList());
                            out.println("  is Head?: " + ev.isHead());
                            out.println("  is Overmatch?: " + ev.isOvermatch());
                            out.println("  Sources: " + ev.getSources());
                            out.println("  Positional Info: " + ev.getPositionalInfo());
                            out.println("  Pruning Status: " + ev.getPruningStatus());
                            out.println("  Negation Status: " + ev.getNegationStatus());
                        }

                        out.println("Mappings:");
                        for (Mapping map: pcm.getMappingList()) {
                            out.println(" Map Score: " + map.getScore());
                            for (Ev mapEv: map.getEvList()) {
                                out.println("   Score: " + mapEv.getScore());
                                out.println("   Concept Id: " + mapEv.getConceptId());
                                out.println("   Concept Name: " + mapEv.getConceptName());
                                out.println("   Preferred Name: " + mapEv.getPreferredName());
                                out.println("   Matched Words: " + mapEv.getMatchedWords());
                                out.println("   Semantic Types: " + mapEv.getSemanticTypes());
                                out.println("   MatchMap: " + mapEv.getMatchMap());
                                out.println("   MatchMap alt. repr.: " + mapEv.getMatchMapList());
                                out.println("   is Head?: " + mapEv.isHead());
                                out.println("   is Overmatch?: " + mapEv.isOvermatch());
                                out.println("   Sources: " + mapEv.getSources());
                                out.println("   Positional Info: " + mapEv.getPositionalInfo());
                                out.println("   Pruning Status: " + mapEv.getPruningStatus());
                                out.println("   Negation Status: " + mapEv.getNegationStatus());
                            }
                        }
                    }
                }
            } else {
                out.println("NULL result instance! ");
            }
        }
        this.api.resetOptions();
    }
}
