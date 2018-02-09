
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

- Extended version of the Euclidian Algorithm?

- Recap
    - Relatively prime numbers (GCD of the two numbers is 1)
    - Any number can be broken down into prime factors
    - Any number can be expressed as prime numbers raised to a power

#### Consequence of the Euclidian Algorithm 

- Let GCD of non-zero integers a and b:
    `d = GCD(a, b)`

- If there exists integers x and y such that:
    `d = ax + by`

- In the special case that a and b are relatively prime
    `1 = ax + by` 

#### Euclid's Lemma

- Suppose that P is prime, and that a and b are integers:
    - If p|ab then p|a or p|b


### Congruences

- a is congruent to b(mod m) if m|(a - b)
- The number m is called the modulus of the congruencey 


- Relfexivity: a is congruent with a for any integer a
- Symmetry: a is congruent with b then b is congruent with a for any inetgers a and b
- Transitivity: if a is congruent with b and b is congruent with c, then c is congruent with a

- if m is a positive integer (modulus) and a, b are both integers
    - then a is congruenct with b (mod m) if a and b both have the same remainder when divided by m

### Modular Arithmetic 

- Zm = { 0, 1, 2, ... m - 1 }
- where Zm is the set of remainders when dividing by m 

## Simplification of Congruences

- If a divides b, then any congruence where  ax is congruent with c(mod b) will also be a congruence of ax = c(mod a)
- This means you can simplify any redudant congruences in a system of equations
    
## Chinese Remainder Theorm 

- A system of congruences of n1, n2, n3 which are relatively prime, any integers b1, b2, b3 where 
    `bn mod(nn)` all have a unique modulo X 

- Provides to us that a unique solution is possible
