
# Security Algorithms

## Block Ciphers

1. What is an ideal block cipher? (section 3.3)
    - Collision Free 
    - For each key value, the block cipher is a random permutation, and each permutation is chosen randomly, independent of key value
    - A uniform probability distribution over the set of all possible block ciphers
    - Each block is reversible, even though each block has a unique key
    - Uniformly distributed over the keyspace or ciphertext space  ( NOT normal distribution ) 
    - Flipping even one bit in plaintext changes entire ciphertext

2. What are the weaknesses of Block Ciphers?
    - A secure block cipher is one for which no practical attack exists (yet)
    - An attack on a block cipher is a non-generic method of distinguishing the block cipher from an ideal block cipher

    - Complexity?
    - Implementations cannot be ideal because ideal is not practical


- Block ciphers go through a number of "rounds" of weak ciphers


## Examples of Block Ciphers

- DES
    - Data Encryption Standard
    - Input data is a 64 bit block 
    - Data is pseudorandomly permutated
    - Each round is encrypted using a seperate 48 bit key
        - The keygen is started with a 56 bit cipher key
        - It can then generate a set of 16 48 bit keys
        - These keys are then used in 16 rounds of encyrption

    - The strength of DES is in the Round-key Generator
        - a single 56 bit key can generate 16 48 bit keys
        - The pseuo-randomness makes all 16 keys different
        - It's completely invertible
            - Later on this became a weakness, being able to find the 56 bit key from the 48 bit keys

- 3DES 
    - an attempt to make the keys in DES bigger
    - Still not secure due to having all the other features of DES

- AES
    - Advanced Encryption Standard
    - Was done by a competition where the government called on academics and industry to invent a new standard
    - fifteen proposals were submitted, 5 ciphers were the finalists
    - Production of very strong keys 
    - Base 128 bit block size
    - 128 bit key size
    - 10 rounds


    - WHAT MAKES AES SO STRONG? *MIGHT BE ON TEST* 
        - The SBox's !
        - and mixing (based on lowelfield theory)

    - First Roundkey
        - AES takes the key and breaks it up into a 4x4 matrix by columns 
        - Operate on the last column of the key hex matrix:
            - Circular byte left shit of the entries
            - Byte substitution (S-Box) (basically a lookup table)
            - Adding round constant  (01, 00, 00, 00)
        - Create a new column (w[4]) which is w[0] XOR the result of operations on w[3]
        - New column (w[5]) which is w[4] XOR w[1]
        - New column (w[6]) which is w[5] XOR w[2]
        - New column (w[7]) which is w[6] XOR w[3]

    - "Mixing" 
        - Based on an algorithm  where you can dotproduct with a special matrix 

    - Original AES has 10 Roundkeys
        - Modern AES has ~14 

    

    - Each round has some XORs, SBox, Shift, Mix