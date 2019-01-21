package Raadi.domain;

import Raadi.domain.model.DocumentClean;
import Raadi.domain.model.DocumentRaw;
import Raadi.domain.model.TokenData;
import com.sun.corba.se.impl.logging.POASystemException;

import java.util.ArrayList;
import java.util.HashMap;

public class CleanUp
{
    public static DocumentClean cleanup(DocumentRaw documentRaw)
    {
        DocumentClean documentClean = new DocumentClean();
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
                // TODO : Check for Stop Words
                TokenData tokenData = new TokenData(unitFrequence, new ArrayList<Integer>() {{add(position);}});
                vector.put(arrWords[i], tokenData);
            }

        }

        return vector;
    }
}
