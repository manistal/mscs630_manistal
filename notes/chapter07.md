# Chapter 7 - Data Encryption Standard

- First programmable computer dates back to pre-WW2 created by german scientist Konrad Zuse
    - Zuse continued to improve his designed and started a computer company in the 1940s/50s

- British designed a computer named collosus to decrypt 

- IBM Created the first universal programming language FORTRAN 

## Evolution of DES

- DES was invented as part of a call by US Government to institute a standard
- Needed to be secure and efficient 

- Feistel who immigrated from Germany worked at IBM in crypto 
- Developed Lucifer
    - Lucifer was a complicated block cipher that worked on 64 bit blocks and processed them through 16 rounds 
    - All determined by a 112 bit key, forwarded to the NSA for evaluation 
    - Eventually became DES
    - Lucifer had a 112 bit key, NSA reduced DES key to 56 bits


## Feistel Cryptosystems 

- Block Cryptosystem determined by
    1) Block size 2t ( even number ), keysize N
    2) Number of rounds NR, positive number
    3) ????

- Security of the system is entirely dependant on the round key functions, and round key generation oprotocol 
- Not all round key systems would produce a secure system 
- All functions need to be bijective 

## DES (Based on Feistel Cipher)

- DES is easily crackable today
- TripleDES was developed as a 'pseudo-solution'
    - But would require 3 keys and more resources

- Linear Cryptanlysis

- Differential Cryptanalysis
    - Chosen Plaintext Attack 
    - Looks for difference in chosen plaintext pairs throughout the system 


## Modes of Operation (in block ciphers)

- ECB - Electronic Codebook 
    - Naieve way of doing things 
    - Ciphertext broken down in pieces
        - ` Ci = Ek(Pi) where i=1,2,3...`
    - Weak to differential analysis
    - Since blocks of text are sequential, you can look for patterns and do chosen plaintext attacks

- CBC - CipherBlock Chaining
    - `Ci = Ek(Pi XOR Ci-1)  where i=1,2,3...`
    - Next cipher text is based on previous cipher text 
    - Creates a situation where repeated words don't result in repeated ciphertext 
    - There is a problem when `i=1`, there's no previous value to xor
        - You can define C0 to be whatever you like, or an Initialzation Vector (IV), a Seed
    - Weak to chosen plaintext attacks targetting xor operations 

- CFB - Cipher Feedback 
    - Extremely similar to CBC 
    - Every block is just further decomposed into bits
    - Has the potential to become faster in certain hardware implementations 


## Authentication (aka Digital Signing) (aka MACs) (aka Hashing)

- Proving that a given origin was actually the source 
- Prevents tampering 

- MAC (Message Authentication Codes)

- Same signature should never exist for two documents
    - This is a *collision*, this is bad 

- An example MAC would be returning the final ciphertext from a CBC mode block cipher 
    - Because the final ciphertext is dependant on the entire file in CBC mode, that ciphertext is unique to the file as a whole

