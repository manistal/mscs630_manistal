
# Message Authentication Codes

- Types of MACs
    - Ideal (section 6.2)
    - CMAC (section 6.3)
    - HMAC (section 6.4)
    - GMAC (section 6.5)


- Message Authentication Codes are a Function
    - `T = MAC(K, M)`
    - K, Key is of some fixed length per algorithm 
    - M, Message of arbitrary length 
    - T, message authentication code 
    - Verification given by `isReal = (MAC(k, M') == T)`
    - difference between MAC and Hash is the Key
    - T should not collide with other T

- CMAC 
    - What is it?
        - Uses Block Cipher in a CBC Mode (chaining) to produce a signature
        - Requires a message, block cipher, key, initialization vector (usually 0)
    - How does it work?
        - Encrypt blocks in CBC, return last block 
    - What makes it good?
        - Easy, secure (half as secure as the cipher)
        - Hardware acceleration for popular block ciphers
    - Any Flaws?
        - Collisions 
        - Implementation requires padding 
        - Keys

- GMAC 
    - What is it?
        - Galois Message Authentication Codes 
        - Key, Message, and a Nonce as input 
    - How does it work?
        - Call universal hash function, encrypt output in CTR mode with key 
    - What makes it good?
        - Fast/HW Acceleration 
        - Good for simple apps 
    - Any Flaws?
        - 128 bits only 
        - No one cares about it 

- HMAC 
    - What is it?
        - MAC based on hash function
        - Commonly used with SHA1 
        - Book recommends SHA256
        - K, m, h(), a, b, 
            - a and b are specified constants (salts)
    - How does it work?
        - `|| denotes concatenation` 
        - `HMAC = hash(key ^ A || hash(key ^ B || msg))`
    - What makes it good?
        - Double hashing 
        - Simple, efficient, and easy to implement
        - Strong hashes are strong 
        - Faster than CMAC
    - Any Flaws?
        - Weak against Birthday attacks
        - Has n/2 bits of security, security is based on the underlying hash func


- Birthday Attacks
    - Birthday Paradox
    - Chance of 2 people sharing a birthday is much higher than you think
    - Class of probabilsitic brute force attacks