# Galois Math!!

Evariste Galois invented mathematics of Galois Fields 


## Finite Fields

- General purpose mathematics of numbers is "Number Theory" 
    - Not generally defined as finite unless certain conditions exist
    - i.e. if a number has a specific modulus, the numbers that are congruent are limited


- What if the modulus is infinite? Well its not finite

- Infinite Sets:
    - Integers, rationals, complex numbers, natural, etc

- Finite Fields 
    - Provide a range of numbers that are bounded by a specific thing
    - Especially numbers in modular arithmetic 


- Inventory of Finite Fields
    - If F is a finite field with at least two elements
        - Then there exists a prime P such that the number of elements of F is a power of P
        - `|F| = p ** n` (magnitude of F, for some positive integer n)

    - Conversely for any such prime power `p ** n` there exists a finite field having `p ** n` elements and this field is unique
        - The unique field with `p ** n` is denoted as `GF(p ** n)`


- AES and Galois fields 
    - Use `GF(2**8) and GF(2**4)` aka `GF(16)` `GF(256)`


## Application of G Fields 

- AES Review
    - TODO: https://en.wikipedia.org/wiki/Confusion_and_diffusion 
    - Add Key 
        - Does xor (addition without carry ) of the key with the plaintext

    - Nibble Substiution 
        - obfuscates the relationship between the key and plaintext via Shanon's property of confusion
        - primary source of confusion 

    - Column Mixing
        - primary source of diffusion in the cipher
        - Appears to be random, but is invertible 
        - Proven that MixColumns is effective enough that after 3 rounds of mixing, there's no increased value
        - So they just decided on the last round there would be no mixing 


- AES Decryption Review 
    - Add Key
        - XOR  the round keys backwards 
        - 10->0 in order of round keys

    - Shift Rows
        - Shift them backwards

    - Nibble Substiution 
        - Inverse SBox

    - Inverse GMixing 
        - See the wikipedia page
        - Inverse coeficients are 14, 11, 13, 9