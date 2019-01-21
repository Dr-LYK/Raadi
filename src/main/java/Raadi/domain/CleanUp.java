package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;
import Raadi.domain.model.TokenData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class CleanUp
{


    public static DocumentClean cleanup(DocumentRaw documentRaw)
    {
        DocumentClean documentClean = new DocumentClean();

        documentClean.setContent(documentRaw.getContent());
        documentClean.setChildrenURL(documentRaw.getChildrenURL());
        documentClean.setURL(documentRaw.getURL());
        documentClean.setVector(tokenization(documentClean.getContent()));

        return documentClean;
    }

    /**
     *
     * @param text
     * @return HashMap<String, TokenData>
     */
    private static HashMap<String, TokenData> tokenization(String text)
    {
        HashMap<String, TokenData> vector = new HashMap<>();
        String[] arrWords = text.split(" ");

        Double unitFrequence = 1.0/arrWords.length;

        for (int i = 0; i < arrWords.length; i++)
        {
            final int position = i;
            final String token = arrWords[i];

            // The word already exists
            if (vector.containsKey(arrWords[i]))
            {
                // Push new position in array positions
                ArrayList<Integer> positions = vector.get(token).getPositions();
                positions.add(position);
                vector.get(token).setPositions(positions);

                // Update the weight
                Double weight = vector.get(token).getWeight();
                weight += unitFrequence;
                vector.get(token).setWeight(weight);
            }
            else // create the token
            {
                // TODO : Synonyme
                if (!isStopWord(token))
                {
                    final String transformedToken = stemmingTransform(token);

                    TokenData tokenData = new TokenData(unitFrequence, new ArrayList<Integer>() {{
                        add(position);
                    }});
                    vector.put(transformedToken, tokenData);
                }
            }

        }

        return vector;
    }


    private static Boolean isStopWord(String word)
    {
        return Manager.getInstance().getStopWords().contains(word);
    }

    private static String stemmingTransform(String word)
    {
        if (Pattern.matches(".+sses", word) || Pattern.matches(".+ies", word))
            return word.substring(0, word.length()-3);
        else if (Pattern.matches(".+ss", word))
            return word;
        else if (Pattern.matches(".+s", word))
            return word.substring(0, word.length() - 2);

        return word;
    }
}
