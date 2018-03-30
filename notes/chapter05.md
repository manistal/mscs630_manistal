# History of Codebreaking

## Frequency Analysis Attack on Substitution Cipher

- The Ceasar Cipher 
    - Was a shift cipher, too easy to attack

- To improve on ceasar cipher, went to full on subsitution 

- Al-Kindi 
    - 8th Centurary Scholar
    - Wrote nearly 300 books
    - Most famous book was on Cryptanalysis
    - Was still used by Confederates during US Civil war in 1860s!
    - Responsible for first account of frequency analysis (ciphertext only ) attacks

- Because substitution ciphers are one to one substitution of characters in the alphabet
     you can use frequency analysis to determine which letters show up proporitionally to their 
     substituted counterparts in the plaintext alphabet

- Relavent properities
    - Vowels tend to be "social" (appear together)
        - i.e. "OO" appears very often relative to most combinations
    
    - Consanants tend to be less social
        - i.e. q is almost always followed by u

    - Adjacency data combined with frequency can be used to differentiate letters than show up similar numbers of times in small messages


- The Demise of the Vignerere Cipher
    - Had a lifespace of almost 300 years 
    - An english cryptography "reinvented" the Vingere Cipher, was challenged to break it
    - Charles Babbage discovered the weakness in the 1840s, but was told not to publish, as it provided a tactical advantage in the Crimean war
    - The attack was called the Cabbage/Kisiski attack

- Babbage Attack 
    - Frequency counts of the cipher text letters are useless in a Vingere cipher
    - Babbage started by determininbg the length of the keyword
    - Due to the nature of the cipher, any plaintext characters seperated by N ccharacters where N is the key length, would be subject to the same shift cipher (loop over keyword applying same transformation for a given index )
    - Can then apply the frequency analysis 

    - Finding the Key Length 
        - Find the duplicated grams (substrings)
        - find the seperation of the duplicated grams
        - For all of the seperation values, find the GCD
        - The GCD is the likely length of the keyword


