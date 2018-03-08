# Chapter 1 Stanoyevitch


## Definitions

Cryptography 
    - Art of secret communications
    - Historically used by  States/Spies
    - Now used pervasively in privacy
    
Types of Cryptography
    - Authentication
    - Integrity 
    - Non-repudiation [Verification of authenticy (i.e. CAs)]

Cryptosystems 
    - Algorithms for rendering text unintelligble
    - Can be defined on any alphabet
    - Alphabet is a finite series of symbols
    - *String*: Ordered sequence of characters

Function 
    - f(a) = b
    - Mapping of A to B is the Function F
    - A is the Domain (arguument)
    - B is the Codomain (result)
    - Range is the subset of all possible values for typeof(B) 

    - *One to One* [Injective]
        - Every B has at most one A 
        - Might not be able to get all of typeof(B)
    
    - *Onto* [Surjective]
        - Every B has at least one A 
        - Definitely can get every of typeof(B) 

    - *Bijective* 
        - Every B has exactly one A


    - *Inverse* 
        - Reverse mapping of B to A
        - All bijective functions are invertible (because B has exactly one A)

## Historical Cryptography

Data Encryption Standard (DES)
    - US Developed in 1973 
    - 16 rounds of block encryption
    - High degree of entropy 
    - Eventually cracked

Advanced Encryption Standard (AES)
    - US had a connest in 2002 to replace DES
    - Also a block cipher

August Kerckhoffs
    - Defined military cryptography
        1) System must be practically (if not mathematically) unbreakable
        2) It may be assumed advesary knows the system, but not the key

## Cryptography  Background

Substitution Cipher
    - `f(P) = C`
    - `If P1 != P2 then f(P1) != f(P2)`
    - P: Plaintext Alphabet, C: Ciphertext Alphabet
    - Bijective 
    - Monoalphabetic or polyalphabetic 

Shift Cipher
    - `F(P) = K + P (mod 26)`
    - K: Shift amount
    - Variant of Substitution cipher
    - Caesar Cipher
        - Used by julius ceasar
        - Plaintext is lowercase, Ciphertext is uppercase
        
Vingere 
    - Uses table and key to substitute characters
    - Type of shift cipher

Block Cryptosystems
    - Encrypts "blocks" of text 
    - See Chapter 04

Public Key Cryptography 
    - Symmetric Key Systems are weak (Both the sender and reciever know the password)
    - Assymetric Cryptosystems solved this by using a Public and Private key (like SSH's RSA)

## Attacks on Ciphers

Passive Attacks 
    - Just listen (i.e. packet sniffing)

    - *Ciphertext Only*
        -  You can only see ciphertext 
        - Brute Force, Frequency Analysis

    - *Known Plaintext Attack* 
        - You can see at least some of Plaintext and Ciphertext

    - *Chosen Plaintext Attack* 
        - Temporary access to cipher and can encrypt chosen strings
        - i.e. pick are 0x000...  and 0xfff... and get bounds

    - *Chosen Ciphertext Attack* 
        - Temporary access to decryption algorithm
        - pick ciphertext to decrypt and see what happens 

Active Attacks 
    - Modify/corrupt results

