
# Chapter 04 - Modular Matrices and the Hill Cryptosystem 

*NOTE* Modulus is communative 
*NOTE* Negative modulus matters (i.e. -8 % 6 is 4 because if you add a multiple of 6 (i.e. 12) to -8 you get 4)
       BE CAREFUL WITH THESE - THINK IT THROUGH. ITS SUPER UNINIUITIVE

## Matricies

- Anatomy of a matrix 
    - Rectangular spreadsheet of numbers
    - Indices that make up row/column
        - i.e. A(1,1) is row 1, column 1 
        - N rows, M columns A(N, M)
    - N x 1 matrix is a column matrix
    - 1 x M matrix is a row matrix
    - X x X Matrix is a square matrix

- Matrix Math 
    - Matrix Addition/Subtraction 
        - Elementwise arithmetic, one element at a time with corresponding element
        - All matrix arithmetic must happen on matricies of the same size

    - Scalar Math 
        - You apply the scalar operation to each entry in the matrix

    - Dot Product 
        - A dot B = SUM( A(i, i)*B(i, i) )

    - Matrix Multiplication 
        - Requires that for A(N, M) * B(N, M) that the number of columns in A is the number of rows in B (A(M) == B(N))
        - The result of matrix multplication is the size of A(N) x B(M)  (opposite the compatible indicies)

    - Matrix Inversion 
        - Idenity Matrix 
            - 1s from top left to bottom right (main diagonal)
            - Satisfies A^-1 * A = Identity 
            - Matrices which do not satisfy the above are not invertable 

        - Calulate the determinant 
            - Determinant of [ [ a, b ], [ c, d ] ] is ad - cb
            - Larger matrices use recursive of the same idea 
            - Product of main diagonal, less the product of the off diagonal 
            - For >= 3 square matricies, this is done recursively 

            - Co-factor Expansion (Stanoyevitch 4.1)
                - The Co-factor expansion for ANY row in a matrix is always the same!!
                - The determinant of ANY matrix is "The Cofactor Expansion of the First Row"
                - This is found by taking an entry A(i, j)*det(A(i+1 -> iN, j+1, jN)) and alternating signs down the row and adding 

        - Inveritability of a Square Matrix
            - A square matrix is only invertible if the determinant is nonzero 
            - For a modular square matrix, the determinant of the square matrix MUST be relatively prime to the mod
            - If the determinant is invertible in the corresponding number system, the matrix is invertible


        - Formula for the Inverse of a 2x2 Matrix 
            - `A = [[a, b], [c, d]]`
            - `A^-1 = (1 / det(A)) * [[d, -b], [-c, a]]`

        - The inverse of a moduluo determinant  i.e. A (mod B) is GCD(B, A*B) = 1
            - find the residuals of the stuff 

        - Inverse of an NxN Matrix 
            - Classical Adjoint Matrix
                - `[(-1)^(i+j) det(A(j,i))]`

            - `A^-1 = det(A)^-1 * adj(A)`
                - The classical adjoint matrix multiplied by the inverse of the deternminant of A 

            
## Applications to Cryptography - The Hill Cryptosystem 

- Keys are determined by an invertible RxR matrix 
- Plaintext is written in the 26 letter alphabet 
- Modulo of the matrix is 26

- Method
    - Encryption
        1. Convert plaintext to a string of mod 26 integers 

        2. Stack these mod26 integers into a 2 row matrix (because encryption matrix is 2x2)
            - If the final column is not filled, use 13 (plaintext n), (traditionally not 13, can be anything but has to be consistent )
            - [[n0, n2, n4...][n1, n3, n5...]]

        3. Multiply the matrix P by the encryption matrix to obtain a matrix C 
            - Because the matrix is 2xN and the Key is 2x2, the result is 2xN

        4. Form a vector of entries of C in a similar way to how the matrix P was formed from its vector
        
        5. Convert those numbers back to letters, this is the ciphertext 

    - Decryption
        - Using the inverse of the Key matrix, multiply against the ciphertext matrix
        - The result will be the plaintext 

- Parameters of the algorithm 
    - Number of rows you want
    - Length of the matrix 
    - Key Matrix 
    - Decryptor needs to know what the "fill" value is 

- Two different plaintext can be mapped to the same ciphertext and vice versa
    - This eliminates frequency attacks 

- Difficulty in the Hill Cryptosystem is finding matrices that are invertible
    - Why is that a weakness?
        - If it's hard to find invertible matrices, that means its a limited set
        - That means you can try them all, via brute force
        - The string needs to fit in a NxM matrix
        - The larger the matrix (longer the message) the fewer invertible matrices you get, makes long messages weaker

## HOMEWORK 2/16 
    - Chapter 4 (the book thats not Stanoyevitch)
    - Learn about the different modes
        - ECB and CBC 
