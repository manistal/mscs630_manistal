
# Chapter 2 (Introduction to Crypto by Stanoyevitch)

## Symmetric Cryptosystems

- Only has a private key 
- You need to share your private key
- WEAK

## Asymmetric Cryptosystems

- Has a public key and private key
- Public Key (encrypts the message), Private Key (decrypts the message)
- Sender can encrypt messages to you using your public key
- To DECRYPT the message, you need the private key, which you DO NOT SHARE
    - RSA Encryption System 

## Number and divisibility

- Suppose A and B are integers with A != 0
    - We can say A divides B ( A| B ) if B = AC and C is also an integer
    - A is a *factor* of B
    - B is a *multiple* of A
    - -7| 84 : True divisible
    - 12|6 :   FALSE not divisible

    - Let A B and C be integers
        - if A | B and B | C then A | C  [transitive property]
        - if A | B and A | C then for any integers X and Y, A | (BX + CY)  []

### Prime numbers

- P > 1 and only factors are 1 and P then P is prime
- Not prime numbers are composite
- Fundamental Theorm of Arithmetic 
    - Every positive integer A > 1 can be uniquely expressed as a product of primes
- Brute Force Primality Check
    - Take the square root of a number, if any primes less than that are factors of the number it is composite
- Euclid says There are infinitely many primes
    - Proof by contradiction
    
### Greatest Common Divisor

- GCD(A, B) is the largest integer D that divides both A and B
- We say numbers A and B are relatively prime, if GCD(A, B) = 1
- Need relatively prime numbers for generating RSA Keys
- How to find the Greatest Common Divsior:

    - Brute Force: List all factors and pick the highest

    - Factor A and B, take all common prime factors and use the corresponding mimimum exponents of each prime

#### Division Algorithm*
- Not really an algorithm, but its called that anyways

- If A is an integer and D is any positive integer then there exists unique integers Q and R
    satisfying 0 <= R < D such that A = DQ + R

- A is the dividend, D is the divisor, Q is the quotient, R is the remainder

```A = floor(A / D) && R = A - QD ```

- When D (the divisor) is a prime number cool things happen
    - What cool things?!

#### Euclidian Algorithm 

- Input: A pair of integers a and b not both zero
- Output: The GCD of the inputs













    
