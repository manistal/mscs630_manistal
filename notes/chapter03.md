
# The Evolution of Codemaking

- Opened with Jimmy Fallon "Google Translate Songs" 
    - Songs translated from english to language X to english, and then singing it

- Example of an Unsolved Ancient Code: Phaistos Disk 
    - Was difficult (impossible?) to solve because there's no equivalency to compare
    - Unclear what symbols and grouping of symbols are (symbols repeat, groupings differ)
    - No context 

- Navajo Codebtalkers   
    - In WW2 the American Military used Navajo to communicate
    - It was easy to recruit members since there was enough of them, but not well known
    - They used simple encoding but always spoke in Navajo

- Formal Definition of a Cryptosystem  *will be on quiz* 
    - A plaintext alphabet '*P*'
    - A cyphertext alphabet '*C*'
    - A plaintext domain *cursive P* (a set of strings in the plaintext alphabet)
    - A cyphertext domain *cursive C* ( a set of strings in the ciphertext alphabet)
    - A Key domain *K* 
    - Encryption function *e*, decryption function *d*
    - Where: *e* : *P* -> *C*  (one for each key k in *K*)
    - and :  *d* : *C* -> *P*  ( the inverse of the corresponding encryption function )

    - Where the key easily determines the encryption and decryption functions, its symmetric encryption

- Shift cyphers
    - Caesar cipher
    - Symmetric cyphers, key is the base of the encryption and decryption 

- Substitution cyphers
    - Maps P to C in the same domain based on some function 

- Affine Cyphers
    - easily described in terms of modular artithmetic 
    - Generalized class of ciphers, some shift ciphers are affine ciphers
    - The affine cipher is a type of monoalphabetic substitution cipher, wherein each letter in an alphabet is mapped to its numeric equivalent, encrypted using a simple mathematical function, and converted back to a letter.

    - Passive attacks on Affine ciphers
        - Assumption, he knows its an affine cipher, but the key is unknown
        1. Cyphertext Only Attack
            -  Pick cyphertext to play back through decryption 
            - Choose relatively prime numbers (for a monoalphabetic cypher the set of relative primes to 26)

        2. Known Plaintext Attack 
            - Have plaintext and cipher relationships
            - If you know two correspondences you can form a system of equations and solve for the congruences

        3. Chosen Plaintext attack 
            - Opposite of ciphertext only 


- Steganography 
    - Concealment of messages without ciphertext 
    - Plaintext is left intact, but the existance of said message is concealed

    - Ancienct Chinese wrote messages in thin silk sheets covered in wax and ingested by a messanger
    - Greeks would shave a head, tattoo a message, grow hair back and send the messanger
    - Germans used Microdots to embed messages in periods at the end of sentances

    - Applying cryptpgraphy and steganography adds layers of protection  


- Transposition Ciphers 
    - Permute locations of the plaintext letters rather than substituting them 
    - Grek cipher known as : Scytale. Worked by wrapping a narrow cloth around a rod diagnalloy and transposing letters

- First book written exclusively about Cyptography in 725AD

- First countermeasures to Frequency Analysis 
    1. Nulls
        - Nulls are additional ciphertext symbols that will be known to be ignored by the intended recipient to throw off frequency analaysis
        - This ISNT the concept of \0 that C, C++, etc has, these are Invalid chars in the ciphertext domain

    2. Homophones 
        - Additional ciphertext characters used to represent more common plaintext characters
        - In a substitution cipher, one letter word followed by a two letter word is probably "I am"
        - By using seperate ciphertext you can break the frequency analysis

- Thomas Jefferson's Cryptosystem: The Jefferson Wheel Cipher
    - 36 numbered wheels, each containing a different permutation of the alphabet 
    - > 10^41 possible keys! Brute force wasn't possible (especially in this time period)
    - Immune to attacks for 150 years
    - Jefferson considered the Father of American Cryptography 






