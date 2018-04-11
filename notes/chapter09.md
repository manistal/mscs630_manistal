
# Public Key Cryptography 

- In Symmetric key cryptosystems, the key needs to be distributed
    - Can't just be giving everyone your password!!

- Need a secure way to share keys 

- In the 1970s a paper on the first key exchange was published (Diffie-Hellman key exchange) 

- RSA was developed by MIT Scientists (Ronald Rivest, Adi Shamir, Leondard Adleman)
    - First secure key exchange used in the modern worldelfmann-something)
    - 

- Key element of public key cryptosystems is one way functions
    - Functions that are easy to compute the result of but nearly impossible to go the other way
    - Cannot be invertible, even if you wanted to
    - a number g is a primitive root modulo n if every number a coprime to n is congruent to a power of g modulo n
        - STUDY CONGRUENCES! 
    - If P is a large prime and G is a primitive rooot mod P then the following is a one way function
        - `E(x) = g ** x (mod p) `
        - There is some other number raised to a power that is congruent with G 
        - `G1 ** x  is congruent  with G2 ** x` 


- The Diffie Hellman Key Exchange Protocol
    - A large prime number P and a primitive root G (mod P), both G and P can be made public

- A Public Key Cryptosystem 
    - Requires a public key, available to everyone, corresponds to a one way encryption function
    - Requires a private key, available to NO ONE, and used for decryption 
    - RSA uses - Factoring Integers problem for security 
    - El Gamal - The discrete logarithm problem
    - Knapsack - The Knapsack problem 

- RSA (Rivest-Shamir-Adleman)
    - Based on the factorization problem 
    - Provides the means for the xchange of keys
    - Protocol:
        - Person A requires two different prime numbers p and q
        - Person A multiplies these primes to obtain a public integer `n = pq`
        - Person A selects (at random)  an integer d that is relatively prime to `(p-1) * (q-1)`
        - Person A computes (using the Extended Euclidian Alg), the inverse `e` of `d (mod (p-1) * (q-1))

    - Its hard to find large primes 
        - More secure, takes longer to figure out large primes