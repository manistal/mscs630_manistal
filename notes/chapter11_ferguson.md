
# Key Exchange Protocols

- Number of Key Pairs needed is a calculation of `Combinations` (`nCr`)

- Certificate Authorities handle key exchanges
    - If you dont have a key its generated and stored in cookies



-  Does a 256 bit RSA key have a strength similar to 256 AES Key?
    - No. 
    - RSA keys are primes, which simplifies the brute force process 
    - 256 bit AES key ~ 2048 bit RSA key 
    - RSA should only be used to exchange private keys for AES 


- Encryption Limitations are in place in:
    - China
    - USA
    - Russia
    - Germany 

- If you have to choose an encryption algorithm for messaging
    - You'll use a cipher and a hashing algorithm 
    - One is for Message Authentication, the other is to protect data
    - Only one needs to be strong, since one without the other will not work 
    - Strong Hashes are faster, so pick a strong hash and a weaker cipher

- 