The basic requirement is to provide a program that can convert text into comma separated (CSV) data.
The text is to be parsed, broken into sentences and words and the words have to be sorted. For
simplicity, please treat “.”, “?” and “!” as the end of sentences.
The program must be able to input text like:

“Mary had a little lamb. Peter called for the wolf, and Aesop came.
Cinderella likes shoes.”
and convert to a CSV format.
The parsing must break the text into sentences and words. The parser should allow some whitespace
around words and delimiters, e.g. the following is allowed as input and should produce the same result
as the first example:

“ Mary had a little lamb .

Peter called for the wolf , and Aesop came .
Cinderella likes shoes.”

In both cases the CSV result should be like:
, Word 1, Word 2, Word 3, Word 4, Word 5, Word 6, Word 7, Word 8
Sentence 1, a, had, lamb, little, Mary
Sentence 2, Aesop, and, called, came, for, Peter, the, wolf
Sentence 3, Cinderella, likes, shoes